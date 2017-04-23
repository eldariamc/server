//
// Source code recreated from setStepSound .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.Random;

public class BlockFurnace extends BlockContainer {
	private final Random a = new Random();
	private final boolean b;
	private static boolean M;
	private Block drop;
	private double furnaceSpeed = 1.0;

	protected BlockFurnace() {
		super(Material.STONE);
		this.b = false;
		this.drop = this;
	}

	protected BlockFurnace(Block drop) {
		super(Material.STONE);
		this.b = true;
		this.drop = drop;
	}

	public Item getDropType(int var1, Random var2, int var3) {
		return Item.getItemOf(drop);
	}

	public void onPlace(World var1, int var2, int var3, int var4) {
		super.onPlace(var1, var2, var3, var4);
		this.e(var1, var2, var3, var4);
	}

	private void e(World var1, int var2, int var3, int var4) {
		if(!var1.isStatic) {
			Block var5 = var1.getType(var2, var3, var4 - 1);
			Block var6 = var1.getType(var2, var3, var4 + 1);
			Block var7 = var1.getType(var2 - 1, var3, var4);
			Block var8 = var1.getType(var2 + 1, var3, var4);
			byte var9 = 3;
			if(var5.j() && !var6.j()) {
				var9 = 3;
			}

			if(var6.j() && !var5.j()) {
				var9 = 2;
			}

			if(var7.j() && !var8.j()) {
				var9 = 5;
			}

			if(var8.j() && !var7.j()) {
				var9 = 4;
			}

			var1.setData(var2, var3, var4, var9, 2);
		}
	}

	public boolean interact(World var1, int var2, int var3, int var4, EntityHuman var5, int var6, float var7, float var8, float var9) {
		if(var1.isStatic) {
			return true;
		} else {
			TileEntityFurnace var10 = (TileEntityFurnace)var1.getTileEntity(var2, var3, var4);
			if(var10 != null) {
				var5.openFurnace(var10);
			}

			return true;
		}
	}

	public void a(boolean var0, World var1, int var2, int var3, int var4) {
		int var5 = var1.getData(var2, var3, var4);
		TileEntity var6 = var1.getTileEntity(var2, var3, var4);
		M = true;
		if(var0) {
			var1.setTypeUpdate(var2, var3, var4, Block.b("lit_" + this.d));
		} else {
			var1.setTypeUpdate(var2, var3, var4, Block.b(this.d));
		}

		M = false;
		var1.setData(var2, var3, var4, var5, 2);
		if(var6 != null) {
			var6.t();
			var1.setTileEntity(var2, var3, var4, var6);
		}

	}

	public TileEntity a(World var1, int var2) { // createNewTileEntity()
		TileEntityFurnace tef = new TileEntityFurnace();
		tef.furnaceSpeed = this.furnaceSpeed;
		return tef;
	}

	public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5, ItemStack var6) {
		int var7 = MathHelper.floor((double)(var5.yaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(var7 == 0) {
			var1.setData(var2, var3, var4, 2, 2);
		}

		if(var7 == 1) {
			var1.setData(var2, var3, var4, 5, 2);
		}

		if(var7 == 2) {
			var1.setData(var2, var3, var4, 3, 2);
		}

		if(var7 == 3) {
			var1.setData(var2, var3, var4, 4, 2);
		}

		if(var6.hasName()) {
			((TileEntityFurnace)var1.getTileEntity(var2, var3, var4)).a(var6.getName());
		}

	}

	public void remove(World var1, int var2, int var3, int var4, Block var5, int var6) {
		if(!M) {
			TileEntityFurnace var7 = (TileEntityFurnace)var1.getTileEntity(var2, var3, var4);
			if(var7 != null) {
				for(int var8 = 0; var8 < var7.getSize(); ++var8) {
					ItemStack var9 = var7.getItem(var8);
					if(var9 != null) {
						float var10 = this.a.nextFloat() * 0.8F + 0.1F;
						float var11 = this.a.nextFloat() * 0.8F + 0.1F;
						float var12 = this.a.nextFloat() * 0.8F + 0.1F;

						while(var9.count > 0) {
							int var13 = this.a.nextInt(21) + 10;
							if(var13 > var9.count) {
								var13 = var9.count;
							}

							var9.count -= var13;
							EntityItem var14 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), new ItemStack(var9.getItem(), var13, var9.getData()));
							if(var9.hasTag()) {
								var14.getItemStack().setTag((NBTTagCompound)var9.getTag().clone());
							}

							float var15 = 0.05F;
							var14.motX = (double)((float)this.a.nextGaussian() * var15);
							var14.motY = (double)((float)this.a.nextGaussian() * var15 + 0.2F);
							var14.motZ = (double)((float)this.a.nextGaussian() * var15);
							var1.addEntity(var14);
						}
					}
				}

				var1.updateAdjacentComparators(var2, var3, var4, var5);
			}
		}

		super.remove(var1, var2, var3, var4, var5, var6);
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int g(World var1, int var2, int var3, int var4, int var5) {
		return Container.b((IInventory)var1.getTileEntity(var2, var3, var4));
	}

	public double getFurnaceSpeed() {
		return furnaceSpeed;
	}

	public BlockFurnace setFurnaceSpeed(double furnaceSpeed) {
		this.furnaceSpeed = furnaceSpeed;
		return this;
	}
}
