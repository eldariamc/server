package net.minecraft.server;

import java.util.Random;

public class BlockObsidian extends Block {

    public BlockObsidian() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }

    public int a(Random random) {
        return 1;
    }

    public Item getDropType(int i, Random random, int j) {
        return Item.getItemOf(Blocks.OBSIDIAN);
    }

    public MaterialMapColor f(int i) {
        return MaterialMapColor.J;
    }
}
