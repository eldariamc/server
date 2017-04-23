package net.minecraft.server;

/**
 * Created by David on 11/07/2016.
 */
public class BlockSlime extends BlockHalfTransparent
{
	public BlockSlime()
	{
		super("slime", Material.CLAY, false);
		this.a(CreativeModeTab.c);
		this.frictionFactor = 0.8F;
	}

	/*
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}
	*/

	/**
	 * Block's chance to react to setFlag living entity falling on it.
	 */
	public void a(World worldIn, int x, int y, int z, Entity entityIn, float fallDistance) // onFallenUpon()
	{
		if (entityIn.isSneaking())
		{
			super.a(worldIn, x, y, z, entityIn, fallDistance);
		}
		else
		{
			entityIn.b(0.0F);
		}
	}

	/**
	 * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
	 * on its own
	 */
	public void b(World worldIn, int x, int y, int z, Entity entityIn)
	{
		if (entityIn.isSneaking())
		{
			super.b(worldIn, x, y, z, entityIn);
		}
		else if (entityIn.motY < 0.0D)
		{
			entityIn.motY = -entityIn.motY;
		}
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the block)
	 */
	public void a(World worldIn, int x, int y, int z, Entity entityIn) // onEntityCollidedWithBlock()
	{
		if (Math.abs(entityIn.motY) < 0.1D && !entityIn.isSneaking())
		{
			double d0 = 0.4D + Math.abs(entityIn.motY) * 0.2D;
			entityIn.motX *= d0;
			entityIn.motZ *= d0;
		}

		super.a(worldIn, x, y, z, entityIn);
	}
}
