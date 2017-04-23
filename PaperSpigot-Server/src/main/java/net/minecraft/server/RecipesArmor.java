package net.minecraft.server;

public class RecipesArmor {

    private String[][] a = new String[][] { { "XXX", "X X"}, { "X X", "XXX", "XXX"}, { "XXX", "X X", "X X"}, { "X X", "X X"}};
    private Object[][] b;

    public RecipesArmor() {
        this.b = new Object[][] {
            { Items.LEATHER           , Blocks.FIRE               , Items.IRON_INGOT     , Items.DIAMOND           , Items.GOLD_INGOT     , Items.ZINC           , Items.CRONYXE           , Items.KOBALT           , Items.ELDARIUM           },
            { Items.LEATHER_HELMET    , Items.CHAINMAIL_HELMET    , Items.IRON_HELMET    , Items.DIAMOND_HELMET    , Items.GOLD_HELMET    , Items.ZINC_HELMET    , Items.CRONYXE_HELMET    , Items.KOBALT_HELMET    , Items.ELDARIUM_HELMET    },
            { Items.LEATHER_CHESTPLATE, Items.CHAINMAIL_CHESTPLATE, Items.IRON_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.GOLD_CHESTPLATE, Items.ZINC_CHESTPLATE, Items.CRONYXE_CHESTPLATE, Items.KOBALT_CHESTPLATE, Items.ELDARIUM_CHESTPLATE},
            { Items.LEATHER_LEGGINGS  , Items.CHAINMAIL_LEGGINGS  , Items.IRON_LEGGINGS  , Items.DIAMOND_LEGGINGS  , Items.GOLD_LEGGINGS  , Items.ZINC_LEGGINGS  , Items.CRONYXE_LEGGINGS  , Items.KOBALT_LEGGINGS  , Items.ELDARIUM_LEGGINGS  },
            { Items.LEATHER_BOOTS     , Items.CHAINMAIL_BOOTS     , Items.IRON_BOOTS     , Items.DIAMOND_BOOTS     , Items.GOLD_BOOTS     , Items.ZINC_BOOTS     , Items.CRONYXE_BOOTS     , Items.KOBALT_BOOTS     , Items.ELDARIUM_BOOTS     }
        };
    }

    public void a(CraftingManager craftingmanager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            Object object = this.b[0][i];

            for (int j = 0; j < this.b.length - 1; ++j) {
                Item item = (Item) this.b[j + 1][i];

                craftingmanager.registerShapedRecipe(new ItemStack(item), this.a[j], 'X', object);
            }
        }

    }
}
