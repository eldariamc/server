package net.minecraft.server;

public class RecipesCrafting {

    public void a(CraftingManager cm) {
        cm.registerShapedRecipe(new ItemStack(Blocks.CHEST), "###", "# #", "###", '#', Blocks.WOOD);
        cm.registerShapedRecipe(new ItemStack(Blocks.TRAPPED_CHEST), "#-", '#', Blocks.CHEST, '-', Blocks.TRIPWIRE_SOURCE);
        cm.registerShapedRecipe(new ItemStack(Blocks.ENDER_CHEST), "###", "#E#", "###", '#', Blocks.OBSIDIAN, 'E', Items.EYE_OF_ENDER);
        cm.registerShapedRecipe(new ItemStack(Blocks.FURNACE), "###", "# #", "###", '#', Blocks.COBBLESTONE);
        cm.registerShapedRecipe(new ItemStack(Blocks.WORKBENCH), "##", "##", '#', Blocks.WOOD);
        cm.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE), "##", "##", '#', new ItemStack(Blocks.SAND, 1, 0));
        cm.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 4, 2), "##", "##", '#', Blocks.SANDSTONE);
        cm.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 1, 1), "#", "#", '#', new ItemStack(Blocks.STEP, 1, 1));
        cm.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1), "#", "#", '#', new ItemStack(Blocks.STEP, 1, 7));
        cm.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 2, 2), "#", "#", '#', new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0));
        cm.registerShapedRecipe(new ItemStack(Blocks.SMOOTH_BRICK, 4), "##", "##", '#', Blocks.STONE);
        cm.registerShapedRecipe(new ItemStack(Blocks.IRON_FENCE, 16), "###", "###", '#', Items.IRON_INGOT);
        cm.registerShapedRecipe(new ItemStack(Blocks.THIN_GLASS, 16), "###", "###", '#', Blocks.GLASS);
        cm.registerShapedRecipe(new ItemStack(Blocks.REDSTONE_LAMP_OFF, 1), " R ", "RGR", " R ", 'R', Items.REDSTONE, 'G', Blocks.GLOWSTONE);
        cm.registerShapedRecipe(new ItemStack(Blocks.BEACON, 1), "GGG", "GSG", "OOO", 'G', Blocks.GLASS, 'S', Items.NETHER_STAR, 'O', Blocks.OBSIDIAN);
        cm.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK, 1), "NN", "NN", 'N', Items.NETHER_BRICK);

        // --- Crafts Keyrisium ---

        cm.registerShapedRecipe(new ItemStack(Blocks.OBSIDIAN_FURNACE), "###", "#F#", "###", '#', Blocks.OBSIDIAN, 'F', Blocks.FURNACE);
        cm.registerShapedRecipe(new ItemStack(Blocks.REINFORCED_OBSIDIAN, 2), "##", "##", '#', Blocks.COBBLESTONE);
        cm.registerShapedRecipe(new ItemStack(Items.COMPACTED_SLIME_BALL), "##", "##", '#', Items.SLIME_BALL);
        cm.registerShapedRecipe(new ItemStack(Blocks.IRON_LADDER), "# #", "###", "# #", '#', Items.IRON_INGOT);
        cm.registerShapedRecipe(new ItemStack(Blocks.SLIME), "###", "#C#", "###", '#', Items.SLIME_BALL, 'C', Items.COMPACTED_SLIME_BALL);
        cm.registerShapedRecipe(new ItemStack(Blocks.OBSAND), "##", "G#", '#', Blocks.OBSIDIAN, 'G', Blocks.GRAVEL);
        cm.registerShapedRecipe(new ItemStack(Blocks.WATER_PIPE), "P ", "G ", "BG", 'P', Items.PAPER, 'G', Blocks.THIN_GLASS, 'B', Items.BREWING_STAND);
        cm.registerShapedRecipe(new ItemStack(Blocks.ZINC_CHEST), "###", "#C#", "###", '#', Items.ZINC, 'C', Blocks.CHEST);
        cm.registerShapedRecipe(new ItemStack(Blocks.CRONYXE_CHEST), "###", "#C#", "###", '#', Items.CRONYXE, 'C', Blocks.CHEST);
        cm.registerShapedRecipe(new ItemStack(Blocks.KOBALT_CHEST), "###", "#C#", "###", '#', Items.KOBALT, 'C', Blocks.CHEST);
        cm.registerShapedRecipe(new ItemStack(Items.CHEST_ORB), "CG ", "GKG", " G-", 'C', Items.CRONYXE, 'G', Blocks.GLASS, 'K', Items.KOBALT, '-', Items.STICK);
        cm.registerShapedRecipe(new ItemStack(Items.ELDARIUM), "###",  "###", "###", '#', Items.ELDARIUM_NUGGET);
        cm.registerShapedRecipe(new ItemStack(Items.ELDARIUM_NUGGET, 9), "#", '#', Items.ELDARIUM);

        // ------------------------
    }
}
