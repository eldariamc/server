package net.minecraft.server;

public class RecipesTools {

    private String[][] a = new String[][] { { "XXX", " # ", " # "}, { "X", "#", "#"}, { "XX", "X#", " #"}, { "XX", " #", " #"}};
    private Object[][] b;

    public RecipesTools() {
        this.b = new Object[][] {
            { Blocks.WOOD       , Blocks.COBBLESTONE , Items.IRON_INGOT  , Items.DIAMOND        , Items.GOLD_INGOT  , Items.ZINC, Items.CRONYXE, Items.KOBALT, Items.ELDARIUM},
            { Items.WOOD_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLD_PICKAXE, Items.ZINC_PICKAXE, Items.CRONYXE_PICKAXE, Items.KOBALT_PICKAXE, Items.ELDARIUM_PICKAXE},
            { Items.WOOD_SPADE  , Items.STONE_SPADE  , Items.IRON_SPADE  , Items.DIAMOND_SPADE  , Items.GOLD_SPADE  , Items.ZINC_SHOVEL, Items.CRONYXE_SHOVEL, Items.KOBALT_SHOVEL, Items.ELDARIUM_SHOVEL},
            { Items.WOOD_AXE    , Items.STONE_AXE    , Items.IRON_AXE    , Items.DIAMOND_AXE    , Items.GOLD_AXE    , Items.ZINC_AXE, Items.CRONYXE_AXE, Items.KOBALT_AXE, Items.ELDARIUM_AXE},
            { Items.WOOD_HOE    , Items.STONE_HOE    , Items.IRON_HOE    , Items.DIAMOND_HOE    , Items.GOLD_HOE    , Items.ZINC_HOE, Items.CRONYXE_HOE, Items.KOBALT_HOE, Items.ELDARIUM_HOE}
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

        craftingmanager.registerShapedRecipe(new ItemStack(Items.SHEARS), new Object[] { " #", "# ", Character.valueOf('#'), Items.IRON_INGOT});
    }
}
