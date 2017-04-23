//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public class RecipeIngots {
	private Object[][] a;

	public RecipeIngots() {
		this.a = new Object[][]{
				{Blocks.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9)},
				{Blocks.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9)},
				{Blocks.DIAMOND_BLOCK, new ItemStack(Items.DIAMOND, 9)},
				{Blocks.EMERALD_BLOCK, new ItemStack(Items.EMERALD, 9)},
				{Blocks.LAPIS_BLOCK, new ItemStack(Items.INK_SACK, 9, 4)},
				{Blocks.REDSTONE_BLOCK, new ItemStack(Items.REDSTONE, 9)},
				{Blocks.COAL_BLOCK, new ItemStack(Items.COAL, 9, 0)},
				{Blocks.HAY_BLOCK, new ItemStack(Items.WHEAT, 9)},
				{Blocks.ZINC_BLOCK, new ItemStack(Items.ZINC, 9)},
				{Blocks.CRONYXE_BLOCK, new ItemStack(Items.CRONYXE, 9)},
				{Blocks.KOBALT_BLOCK, new ItemStack(Items.KOBALT, 9)},
				{Blocks.ELDARIUM_BLOCK, new ItemStack(Items.ELDARIUM, 9)}
		};
	}

	public void a(CraftingManager var1) {
		for(int var2 = 0; var2 < this.a.length; ++var2) {
			Block var3 = (Block)this.a[var2][0];
			ItemStack var4 = (ItemStack)this.a[var2][1];
			var1.registerShapedRecipe(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
			var1.registerShapedRecipe(var4, new Object[]{"#", Character.valueOf('#'), var3});
		}

		var1.registerShapedRecipe(new ItemStack(Items.GOLD_INGOT), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.GOLD_NUGGET});
		var1.registerShapedRecipe(new ItemStack(Items.GOLD_NUGGET, 9), new Object[]{"#", Character.valueOf('#'), Items.GOLD_INGOT});
	}
}
