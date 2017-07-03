package net.minecraft.server;

import java.util.Random;

public class BlockOre extends Block {

    public BlockOre() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }

    public Item getDropType(int i, Random random, int j) {
        if (this == Blocks.COAL_ORE)
            return Items.COAL;
        if (this == Blocks.DIAMOND_ORE)
            return Items.DIAMOND;
        if (this == Blocks.LAPIS_ORE)
            return Items.INK_SACK;
        if (this == Blocks.EMERALD_ORE)
            return Items.EMERALD;
        if (this == Blocks.QUARTZ_ORE)
            return Items.QUARTZ;
        if (this == Blocks.LIGNITE_ORE)
            return Items.LIGNITE;
        if (this == Blocks.GEMME_ORE)
            return Items.GEMME;
        if (this == Blocks.ELDARIUM_ORE)
            return Items.ELDARIUM_NUGGET;

        return super.getDropType(i, random, j);    }

    public int a(Random random) {
        if (this == Blocks.LAPIS_ORE)
            return 4 + random.nextInt(5);
        /*if (this == Blocks.KOBALT_ORE)
            return 1 + random.nextInt(2);
        if (this == Blocks.CRONYXE_ORE)
            return 1 + random.nextInt(3);*/
        if (this == Blocks.XP_ORE)
            return 0;

        return super.a(random);
    }

    public int getDropCount(int i, Random random) {
        if (i > 0 && Item.getItemOf(this) != this.getDropType(0, random, i)) {
            int j = random.nextInt(i + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return (this == Blocks.ELDARIUM_ORE ? 1 : this.a(random) * (j + 1)); // Eldaria - eldarium ore only drop one with fortune
        } else {
            return this.a(random);
        }
    }

    public void dropNaturally(World world, int i, int j, int k, int l, float f, int i1) {
        super.dropNaturally(world, i, j, k, l, f, i1);
        /* CraftBukkit start - Delegated to getExpDrop
        if (this.getDropType(l, world.random, i1) != Item.getItemOf(this)) {
            int j1 = 0;

            if (this == Blocks.COAL_ORE) {
                j1 = MathHelper.nextInt(world.random, 0, 2);
            } else if (this == Blocks.DIAMOND_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.EMERALD_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.LAPIS_ORE) {
                j1 = MathHelper.nextInt(world.random, 2, 5);
            } else if (this == Blocks.QUARTZ_ORE) {
                j1 = MathHelper.nextInt(world.random, 2, 5);
            }

            this.dropExperience(world, i, j, k, j1);
        }
        // */
    }

    public int getExpDrop(World world, int l, int i1) {
        if (this.getDropType(l, world.random, i1) != Item.getItemOf(this)) {
            int j1 = 0;

            if (this == Blocks.COAL_ORE) {
                j1 = MathHelper.nextInt(world.random, 0, 2);
            } else if (this == Blocks.DIAMOND_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.EMERALD_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.LAPIS_ORE) {
                j1 = MathHelper.nextInt(world.random, 2, 5);
            } else if (this == Blocks.QUARTZ_ORE) {
                j1 = MathHelper.nextInt(world.random, 2, 5);
            } else if (this == Blocks.LIGNITE_ORE) {
                j1 = MathHelper.nextInt(world.random, 0, 2);
            } else if (this == Blocks.KOBALT_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.CRONYXE_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.ELDARIUM_ORE) {
                j1 = MathHelper.nextInt(world.random, 3, 7);
            } else if (this == Blocks.XP_ORE) {
                j1 = MathHelper.nextInt(world.random, 7, 12);
            }

            return j1;
        }

        return 0;
        // CraftBukkit end
    }

    public int getDropData(int i) {
        return this == Blocks.LAPIS_ORE ? 4 : 0;
    }
}
