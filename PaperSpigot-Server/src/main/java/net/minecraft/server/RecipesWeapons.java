package net.minecraft.server;

public class RecipesWeapons {

    private String[][] a = new String[][] { { "X", "X", "#"}};
    private Object[][] b;

    public RecipesWeapons() {
        this.b = new Object[][] {
            { Blocks.WOOD     , Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND      , Items.GOLD_INGOT, Items.ZINC, Items.CRONYXE, Items.KOBALT, Items.ELDARIUM},
            { Items.WOOD_SWORD, Items.STONE_SWORD , Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLD_SWORD, Items.ZINC_SWORD, Items.CRONYXE_SWORD, Items.KOBALT_SWORD, Items.ELDARIUM_SWORD}
        };
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), new Object[] { this.a[j], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), object});
            }
        }

        craftingmanager.registerShapedRecipe(new ItemStack(Items.BOW, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Items.STRING, Character.valueOf('#'), Items.STICK});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ARROW, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK});

        // --- Arcs Eldaria ---

        craftingmanager.registerShapedRecipe(new ItemStack(Items.ZINC_BOW), " #X", "# X", " #X", 'X', Items.STRING, '#', Items.ZINC);
        craftingmanager.registerShapedRecipe(new ItemStack(Items.CRONYXE_BOW), " #X", "# X", " #X", 'X', Items.STRING, '#', Items.CRONYXE);
        craftingmanager.registerShapedRecipe(new ItemStack(Items.KOBALT_BOW), " #X", "# X", " #X", 'X', Items.STRING, '#', Items.KOBALT);
        craftingmanager.registerShapedRecipe(new ItemStack(Items.ELDARIUM_BOW), " #X", "# X", " #X", 'X', Items.STRING, '#', Items.ELDARIUM);

        // --------------------
    }
}
