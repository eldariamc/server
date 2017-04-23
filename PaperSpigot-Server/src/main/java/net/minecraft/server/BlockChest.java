//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class BlockChest extends BlockContainer {
	private final Random b = new Random();
	public final int a;
	public final boolean canBeLarge;
	private final int size;


	protected BlockChest(int var1) {
		this(var1, true, 27);
	}

	protected BlockChest(int var1, boolean canBeLarge, int size) {
		super(Material.WOOD);
		this.a = var1;
		this.a(CreativeModeTab.c);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		this.canBeLarge = canBeLarge;
		this.size = size;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 22;
	}

	public void updateShape(IBlockAccess var1, int var2, int var3, int var4) {
		if(canBeLarge && var1.getType(var2, var3, var4 - 1) == this) {
			this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if(canBeLarge && var1.getType(var2, var3, var4 + 1) == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if(canBeLarge && var1.getType(var2 - 1, var3, var4) == this) {
			this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if(canBeLarge && var1.getType(var2 + 1, var3, var4) == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}

	}

	public void onPlace(World var1, int var2, int var3, int var4) {
		super.onPlace(var1, var2, var3, var4);
		this.e(var1, var2, var3, var4);

		if (canBeLarge) {
			Block var5 = var1.getType(var2, var3, var4 - 1);
			Block var6 = var1.getType(var2, var3, var4 + 1);
			Block var7 = var1.getType(var2 - 1, var3, var4);
			Block var8 = var1.getType(var2 + 1, var3, var4);
			if (var5 == this) {
				this.e(var1, var2, var3, var4 - 1);
			}

			if (var6 == this) {
				this.e(var1, var2, var3, var4 + 1);
			}

			if (var7 == this) {
				this.e(var1, var2 - 1, var3, var4);
			}

			if (var8 == this) {
				this.e(var1, var2 + 1, var3, var4);
			}
		}
	}

	public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5, ItemStack var6) {
		Block var7 = var1.getType(var2, var3, var4 - 1);
		Block var8 = var1.getType(var2, var3, var4 + 1);
		Block var9 = var1.getType(var2 - 1, var3, var4);
		Block var10 = var1.getType(var2 + 1, var3, var4);
		byte var11 = 0;
		int var12 = MathHelper.floor((double)(var5.yaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(var12 == 0) {
			var11 = 2;
		}

		if(var12 == 1) {
			var11 = 5;
		}

		if(var12 == 2) {
			var11 = 3;
		}

		if(var12 == 3) {
			var11 = 4;
		}

		if(var7 != this && var8 != this && var9 != this && var10 != this || !canBeLarge) {
			var1.setData(var2, var3, var4, var11, 3);
		} else {
			if((var7 == this || var8 == this) && (var11 == 4 || var11 == 5)) {
				if(var7 == this) {
					var1.setData(var2, var3, var4 - 1, var11, 3);
				} else {
					var1.setData(var2, var3, var4 + 1, var11, 3);
				}

				var1.setData(var2, var3, var4, var11, 3);
			}

			if((var9 == this || var10 == this) && (var11 == 2 || var11 == 3)) {
				if(var9 == this) {
					var1.setData(var2 - 1, var3, var4, var11, 3);
				} else {
					var1.setData(var2 + 1, var3, var4, var11, 3);
				}

				var1.setData(var2, var3, var4, var11, 3);
			}
		}

		if(var6.hasName()) {
			((TileEntityChest)var1.getTileEntity(var2, var3, var4)).a(var6.getName());
		}

	}

	public void e(World var1, int var2, int var3, int var4) {
		if(!var1.isStatic) {
			Block var5 = var1.getType(var2, var3, var4 - 1);
			Block var6 = var1.getType(var2, var3, var4 + 1);
			Block var7 = var1.getType(var2 - 1, var3, var4);
			Block var8 = var1.getType(var2 + 1, var3, var4);
			boolean var9 = true;
			int var10;
			Block var11;
			int var12;
			Block var13;
			boolean var14;
			byte var15;
			int var16;
			if(var5 != this && var6 != this || !canBeLarge) {
				if(var7 != this && var8 != this || !canBeLarge) {
					var15 = 3;
					if(var5.j() && !var6.j()) {
						var15 = 3;
					}

					if(var6.j() && !var5.j()) {
						var15 = 2;
					}

					if(var7.j() && !var8.j()) {
						var15 = 5;
					}

					if(var8.j() && !var7.j()) {
						var15 = 4;
					}
				} else {
					var10 = var7 == this?var2 - 1:var2 + 1;
					var11 = var1.getType(var10, var3, var4 - 1);
					var12 = var7 == this?var2 - 1:var2 + 1;
					var13 = var1.getType(var12, var3, var4 + 1);
					var15 = 3;
					var14 = true;
					if(var7 == this) {
						var16 = var1.getData(var2 - 1, var3, var4);
					} else {
						var16 = var1.getData(var2 + 1, var3, var4);
					}

					if(var16 == 2) {
						var15 = 2;
					}

					if((var5.j() || var11.j()) && !var6.j() && !var13.j()) {
						var15 = 3;
					}

					if((var6.j() || var13.j()) && !var5.j() && !var11.j()) {
						var15 = 2;
					}
				}
			} else {
				var10 = var5 == this?var4 - 1:var4 + 1;
				var11 = var1.getType(var2 - 1, var3, var10);
				var12 = var5 == this?var4 - 1:var4 + 1;
				var13 = var1.getType(var2 + 1, var3, var12);
				var15 = 5;
				var14 = true;
				if(var5 == this) {
					var16 = var1.getData(var2, var3, var4 - 1);
				} else {
					var16 = var1.getData(var2, var3, var4 + 1);
				}

				if(var16 == 4) {
					var15 = 4;
				}

				if((var7.j() || var11.j()) && !var8.j() && !var13.j()) {
					var15 = 5;
				}

				if((var8.j() || var13.j()) && !var7.j() && !var11.j()) {
					var15 = 4;
				}
			}

			var1.setData(var2, var3, var4, var15, 3);
		}
	}

	public boolean canPlace(World var1, int var2, int var3, int var4) {
		if (!canBeLarge)
			return true;

		int var5 = 0;
		if(var1.getType(var2 - 1, var3, var4) == this) {
			++var5;
		}

		if(var1.getType(var2 + 1, var3, var4) == this) {
			++var5;
		}

		if(var1.getType(var2, var3, var4 - 1) == this) {
			++var5;
		}

		if(var1.getType(var2, var3, var4 + 1) == this) {
			++var5;
		}

		return var5 > 1?false:(this.n(var1, var2 - 1, var3, var4)?false:(this.n(var1, var2 + 1, var3, var4)?false:(this.n(var1, var2, var3, var4 - 1)?false:!this.n(var1, var2, var3, var4 + 1))));
	}

	private boolean n(World var1, int var2, int var3, int var4) {
		return var1.getType(var2, var3, var4) != this?false:(var1.getType(var2 - 1, var3, var4) == this?true:(var1.getType(var2 + 1, var3, var4) == this?true:(var1.getType(var2, var3, var4 - 1) == this?true:var1.getType(var2, var3, var4 + 1) == this)));
	}

	public void doPhysics(World var1, int var2, int var3, int var4, Block var5) {
		super.doPhysics(var1, var2, var3, var4, var5);
		TileEntityChest var6 = (TileEntityChest)var1.getTileEntity(var2, var3, var4);
		if(var6 != null) {
			var6.u();
		}

	}

	public void remove(World var1, int var2, int var3, int var4, Block var5, int var6) {
		TileEntityChest var7 = (TileEntityChest)var1.getTileEntity(var2, var3, var4);
		if(var7 != null) {
			for(int var8 = 0; var8 < var7.getSize(); ++var8) {
				ItemStack var9 = var7.getItem(var8);
				if(var9 != null) {
					float var10 = this.b.nextFloat() * 0.8F + 0.1F;
					float var11 = this.b.nextFloat() * 0.8F + 0.1F;

					EntityItem var14;
					for(float var12 = this.b.nextFloat() * 0.8F + 0.1F; var9.count > 0; var1.addEntity(var14)) {
						int var13 = this.b.nextInt(21) + 10;
						if(var13 > var9.count) {
							var13 = var9.count;
						}

						var9.count -= var13;
						var14 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), new ItemStack(var9.getItem(), var13, var9.getData()));
						float var15 = 0.05F;
						var14.motX = (double)((float)this.b.nextGaussian() * var15);
						var14.motY = (double)((float)this.b.nextGaussian() * var15 + 0.2F);
						var14.motZ = (double)((float)this.b.nextGaussian() * var15);
						if(var9.hasTag()) {
							var14.getItemStack().setTag((NBTTagCompound)var9.getTag().clone());
						}
					}
				}
			}

			var1.updateAdjacentComparators(var2, var3, var4, var5);
		}

		super.remove(var1, var2, var3, var4, var5, var6);
	}

	public boolean interact(World var1, int var2, int var3, int var4, EntityHuman var5, int var6, float var7, float var8, float var9) {
		if(var1.isStatic) {
			return true;
		} else {
			IInventory var10 = this.m(var1, var2, var3, var4);
			if(var10 != null) {
				var5.openContainer(var10);
			}

			return true;
		}
	}

	public IInventory m(World var1, int var2, int var3, int var4) {
		Object var5 = (TileEntityChest)var1.getTileEntity(var2, var3, var4);
		if(var5 == null) {
			return null;
		} else if(var1.getType(var2, var3 + 1, var4).r()) {
			return null;
		} else if(o(var1, var2, var3, var4)) {
			return null;
		} else if(var1.getType(var2 - 1, var3, var4) == this && (var1.getType(var2 - 1, var3 + 1, var4).r() || o(var1, var2 - 1, var3, var4))) {
			return null;
		} else if(var1.getType(var2 + 1, var3, var4) == this && (var1.getType(var2 + 1, var3 + 1, var4).r() || o(var1, var2 + 1, var3, var4))) {
			return null;
		} else if(var1.getType(var2, var3, var4 - 1) == this && (var1.getType(var2, var3 + 1, var4 - 1).r() || o(var1, var2, var3, var4 - 1))) {
			return null;
		} else if(var1.getType(var2, var3, var4 + 1) == this && (var1.getType(var2, var3 + 1, var4 + 1).r() || o(var1, var2, var3, var4 + 1))) {
			return null;
		} else if (canBeLarge){
			if(var1.getType(var2 - 1, var3, var4) == this) {
				var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)var1.getTileEntity(var2 - 1, var3, var4), (IInventory)var5);
			}

			if(var1.getType(var2 + 1, var3, var4) == this) {
				var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)var1.getTileEntity(var2 + 1, var3, var4));
			}

			if(var1.getType(var2, var3, var4 - 1) == this) {
				var5 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)var1.getTileEntity(var2, var3, var4 - 1), (IInventory)var5);
			}

			if(var1.getType(var2, var3, var4 + 1) == this) {
				var5 = new InventoryLargeChest("container.chestDouble", (IInventory)var5, (TileEntityChest)var1.getTileEntity(var2, var3, var4 + 1));
			}
		}

		return (IInventory)var5;
	}

	// createNewTileEntity()
	public TileEntity a(World var1, int var2) {
		return new TileEntityChest(this.a, this.size);
	}

	public boolean isPowerSource() {
		return this.a == 1;
	}

	public int b(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		if(!this.isPowerSource()) {
			return 0;
		} else {
			int var6 = ((TileEntityChest)var1.getTileEntity(var2, var3, var4)).o;
			return MathHelper.a(var6, 0, 15);
		}
	}

	public int c(IBlockAccess var1, int var2, int var3, int var4, int var5) {
		return var5 == 1?this.b(var1, var2, var3, var4, var5):0;
	}

	private static boolean o(World var0, int var1, int var2, int var3) {
		Iterator var4 = var0.a(EntityOcelot.class, AxisAlignedBB.a((double)var1, (double)(var2 + 1), (double)var3, (double)(var1 + 1), (double)(var2 + 2), (double)(var3 + 1))).iterator();

		EntityOcelot var6;
		do {
			if(!var4.hasNext()) {
				return false;
			}

			Entity var5 = (Entity)var4.next();
			var6 = (EntityOcelot)var5;
		} while(!var6.isSitting());

		return true;
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int g(World var1, int var2, int var3, int var4, int var5) {
		return Container.b(this.m(var1, var2, var3, var4));
	}
}
