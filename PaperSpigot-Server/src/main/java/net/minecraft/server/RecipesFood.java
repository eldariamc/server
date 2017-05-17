package net.minecraft.server;

public class RecipesFood {

    public void a(CraftingManager cm) {
        cm.registerShapelessRecipe(new ItemStack(Items.MUSHROOM_SOUP), new Object[] { Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Items.BOWL});
        //cm.registerShapedRecipe(new ItemStack(Items.COOKIE, 8), new Object[] { "#X#", Character.valueOf('X'), new ItemStack(Items.INK_SACK, 1, 3), Character.valueOf('#'), Items.WHEAT});
        cm.registerShapedRecipe(new ItemStack(Blocks.MELON), new Object[] { "MMM", "MMM", "MMM", Character.valueOf('M'), Items.MELON});
        cm.registerShapedRecipe(new ItemStack(Items.MELON_SEEDS), new Object[] { "M", Character.valueOf('M'), Items.MELON});
        cm.registerShapedRecipe(new ItemStack(Items.PUMPKIN_SEEDS, 4), new Object[] { "M", Character.valueOf('M'), Blocks.PUMPKIN});
        cm.registerShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), new Object[] { Blocks.PUMPKIN, Items.SUGAR, Items.EGG});
        cm.registerShapelessRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE), new Object[] { Items.SPIDER_EYE, Blocks.BROWN_MUSHROOM, Items.SUGAR});
        cm.registerShapelessRecipe(new ItemStack(Items.BLAZE_POWDER, 2), new Object[] { Items.BLAZE_ROD});
        cm.registerShapelessRecipe(new ItemStack(Items.MAGMA_CREAM), new Object[] { Items.BLAZE_POWDER, Items.SLIME_BALL});

        // --- Crafts Eldaria ---

        cm.registerShapedRecipe(new ItemStack(Items.COOKIE, 6), "SSS", "BBB", 'S', Items.SUGAR, 'B', Items.BREAD);
        cm.registerShapedRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 2), "###", "#X#", "###", '#', Items.CRONYXE, 'X', Items.APPLE);

        // ----------------------
    }
}
