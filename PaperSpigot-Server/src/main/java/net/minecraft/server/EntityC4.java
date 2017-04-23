package net.minecraft.server;

import org.bukkit.event.entity.ExplosionPrimeEvent;

/**
 * Created by David on 18/12/2016.
 */
public class EntityC4 extends EntityProjectile
{
	public int fuse = 100;

	public EntityC4(World world) {
		super(world);
	}

	public EntityC4(World world, EntityLiving thrower)
	{
		super(world, thrower);
	}

	public EntityC4(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	@Override
	public void h() {
		super.h();

		/*if (this.inWater) {
			if (!this.world.isStatic) {
				float vel = 0.7F;
				double x = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
				double y = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
				double z = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
				EntityItem var13 = new EntityItem(world, locX + x, locY + y, locZ + z, new ItemStack(Items.DYNAMITE));
				var13.pickupDelay = 10;
				world.addEntity(var13);
			}
			this.die();
			return;
		}*/

		if (this.fuse-- <= 0)
		{
			this.die();

			if (!this.world.isStatic)
			{
				this.explode();
			}
		}
		else
		{
			this.world.addParticle("smoke", this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D);
		}
	}

	private void explode() {
		org.bukkit.craftbukkit.CraftServer server = this.world.getServer();

		ExplosionPrimeEvent event = new ExplosionPrimeEvent((org.bukkit.entity.Explosive) org.bukkit.craftbukkit.entity.CraftEntity.getEntity(server, this));
		server.getPluginManager().callEvent(event);

		if (!event.isCancelled()) {
			// give 'this' instead of (Entity) null so we know what causes the damage
			float power = 4.5F;
			this.world.explode(this, this.locX, this.locY, this.locZ, power, true);
		}


	}

	@Override
	protected void a(MovingObjectPosition movingObj) {
		if (movingObj.type == EnumMovingObjectType.ENTITY) {
			this.motX *= -0.10000000149011612D;
			this.motY *= -0.10000000149011612D;
			this.motZ *= -0.10000000149011612D;
		} else {
			this.blockX = movingObj.b;
			this.blockY = movingObj.c;
			this.blockZ = movingObj.d;
			this.inBlockId = this.world.getType(this.blockX, this.blockY, this.blockZ);
			this.motX = (double)((float)(movingObj.pos.a - this.locX));
			this.motY = (double)((float)(movingObj.pos.b - this.locY));
			this.motZ = (double)((float)(movingObj.pos.c - this.locZ));
			//double var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
			//this.posX -= this.motionX / var20 * 0.05000000074505806D;
			//this.posY -= this.motionY / var20 * 0.05000000074505806D;
			//this.posZ -= this.motionZ / var20 * 0.05000000074505806D;
			//this.playSound("randomom.bowhit", 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			this.inGround = true;
			this.shake = 7;
			if (this.inBlockId.getMaterial() != Material.AIR)
			{
				this.inBlockId.a(this.world, this.blockX, this.blockY, this.blockZ, this);
			}
		}
	}

	@Override
	protected float e() {
		return 0.75F;
	}

	@Override
	public void a(NBTTagCompound tagCompound) {
		super.a(tagCompound);

		fuse = tagCompound.getShort("Fuse");
	}

	@Override
	public void b(NBTTagCompound tagCompound) {
		super.b(tagCompound);

		tagCompound.setShort("Fuse", (short)fuse);
	}

	@Override
	public boolean c(EntityHuman player) {
		if (!this.world.isStatic) {
			float vel = 0.7F;
			double x = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			double y = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			double z = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			EntityItem var13 = new EntityItem(world, locX + x, locY + y, locZ + z, new ItemStack(Items.DYNAMITE));
			var13.pickupDelay = 10;
			world.addEntity(var13);
		}
		this.die();
		return true;
	}
}