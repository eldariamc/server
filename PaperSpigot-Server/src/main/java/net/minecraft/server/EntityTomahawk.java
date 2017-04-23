package net.minecraft.server;

/**
 * Created by David on 14/01/2017.
 */
public class EntityTomahawk extends EntityProjectile {
	public EntityTomahawk(World world) {
		super(world);
	}

	public EntityTomahawk(World world, EntityLiving thrower) {
		super(world, thrower);
	}

	public EntityTomahawk(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	public void h() {
		this.pitch += 36.0F;
		super.h();
	}

	@Override
	protected void a(MovingObjectPosition movingObj) {
		if (movingObj.type == EnumMovingObjectType.ENTITY
				&& movingObj.entity instanceof EntityLiving) {
			EntityLiving living = (EntityLiving) movingObj.entity;
			living.damageEntity(DamageSource.projectile(this, getShooter()), 4.0F);
			living.addEffect(new MobEffect(2, 60, 0, true));
		} else {
			// TODO: play soud "ding"
		}

		if (!this.world.isStatic) {
			float vel = 0.7F;
			double x = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			double y = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			double z = (double)(random.nextFloat() * vel) + (double)(1.0F - vel) * 0.5D;
			EntityItem var13 = new EntityItem(world, locX + x, locY + y, locZ + z, new ItemStack(Items.TOMAHAWK));
			var13.pickupDelay = 10;
			world.addEntity(var13);
		}
		this.die();
	}
}
