package net.minecraft.server;

import java.util.Random;

/**
 * Created by David on 27/06/2016.
 */
public class BlockWaterPipe extends BlockContainer {

	private Random field_149961_a = new Random();

	protected BlockWaterPipe() {
		super(Material.ORE);
	}

	public void postPlace(World world, int x, int y, int z, EntityLiving player, ItemStack itemStack) {
		int playerRotation = MathHelper.floor((double) (player.yaw * 4.0F / 360.0F) + 0.5D) & 3;
		byte rotation = 0;

		if (playerRotation == 1) {
			rotation = 3;
		} else if (playerRotation == 2) {
			rotation = 2;
		} else if (playerRotation == 3) {
			rotation = 1;
		}

		TileEntityWaterPipe pipeEntity = (TileEntityWaterPipe) world.getTileEntity(x, y, z);

		if (pipeEntity != null) {
			pipeEntity.setRotation(rotation);
		}

	}

	public boolean interact(World world, int x, int y, int z, EntityHuman player, int u1, float u1f, float u2f, float u3f) {
		if (!world.isStatic) {
			TileEntityWaterPipe pipeEntity = (TileEntityWaterPipe) world.getTileEntity(x, y, z);

			if (pipeEntity != null && !player.isEating()) {
				if ((player.isSneaking() && pipeEntity.getSmokeTime() > 0) || pipeEntity.activate(player))
					player.openWaterPipe(pipeEntity);
			}
		}
		return true;
	}

	public void remove(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
	{
		TileEntity var7 = p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

		if (var7 instanceof TileEntityWaterPipe)
		{
			TileEntityWaterPipe var8 = (TileEntityWaterPipe) var7;

			for (int var9 = 0; var9 < var8.getSize(); ++var9)
			{
				ItemStack var10 = var8.getItem(var9);

				if (var10 != null)
				{
					float var11 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
					float var12 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;
					float var13 = this.field_149961_a.nextFloat() * 0.8F + 0.1F;

					while (var10.count > 0)
					{
						int var14 = this.field_149961_a.nextInt(21) + 10;

						if (var14 > var10.count)
						{
							var14 = var10.count;
						}

						var10.count -= var14;
						EntityItem var15 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var11), (double)((float)p_149749_3_ + var12), (double)((float)p_149749_4_ + var13), new ItemStack(var10.getItem(), var14, var10.getData()));
						float var16 = 0.05F;
						var15.motX = (double)((float)this.field_149961_a.nextGaussian() * var16);
						var15.motY = (double)((float)this.field_149961_a.nextGaussian() * var16 + 0.2F);
						var15.motZ = (double)((float)this.field_149961_a.nextGaussian() * var16);
						p_149749_1_.addEntity(var15);
					}
				}
			}
		}

		super.remove(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	}

	// isOpaqueCube
	public boolean c()
	{
		return false;
	}

	public TileEntity a(World world, int i) {
		return new TileEntityWaterPipe();
	}

	public boolean canPlace(World world, int j, int k, int l) {
		return world.isEmpty(j, k + 1, l) && !world.isEmpty(j, k - 1, l);
	}

	public void postPlace(World world, int j, int k, int l, int u1) {
		super.postPlace(world, j, k, l, u1);
		this.checkFlowerChange(world, j, k, l);
	}

	protected final void checkFlowerChange(World world, int x, int y, int z) {
		if (!this.canPlace(world, x, y, z)) {
			this.remove(world, x, y, z, this, 0);
			world.setAir(x, y, z);
		}

	}

	public boolean j(World world, int j, int k, int l) {
		return !world.isEmpty(j, k - 1, l);
	}

	public AxisAlignedBB a(World world, int x, int y, int z) {
		return null;
	}



	/*public void registerBlockIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[8];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.setFlag("waterpipe:WaterPipe_" + i);
		}

	}*/
}
