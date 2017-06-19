package net.minecraft.server;

import java.util.Random;

public class BiomeDecorator {

    protected World a;
    protected Random b;
    protected int c;
    protected int d;
    protected WorldGenerator e = new WorldGenClay(4);
    protected WorldGenerator f = new WorldGenSand(Blocks.SAND, 7);
    protected WorldGenerator g = new WorldGenSand(Blocks.GRAVEL, 6);
    protected WorldGenerator h = new WorldGenMinable(Blocks.DIRT, 32);
    protected WorldGenerator i = new WorldGenMinable(Blocks.GRAVEL, 32);
    protected WorldGenerator j = new WorldGenMinable(Blocks.COAL_ORE, 16);
    protected WorldGenerator k = new WorldGenMinable(Blocks.IRON_ORE, 8);
    protected WorldGenerator l = new WorldGenMinable(Blocks.GOLD_ORE, 8);
    protected WorldGenerator m = new WorldGenMinable(Blocks.REDSTONE_ORE, 7);
    protected WorldGenerator n = new WorldGenMinable(Blocks.DIAMOND_ORE, 7);
    protected WorldGenerator o = new WorldGenMinable(Blocks.LAPIS_ORE, 6);

    // --- Generators minerais Keyrisium ---

    protected WorldGenerator zincGen = new WorldGenMinable(Blocks.ZINC_ORE, 6);
    protected WorldGenerator cronyxeGen = new WorldGenMinable(Blocks.CRONYXE_ORE, 5);
    protected WorldGenerator luckyGen = new WorldGenMinable(Blocks.LUCKY_ORE, 4);
    protected WorldGenerator kobaltGen = new WorldGenMinable(Blocks.KOBALT_ORE, 4);
    protected WorldGenerator xpGen = new WorldGenMinable(Blocks.XP_ORE, 4);
    protected WorldGenerator eldariumGen = new WorldGenMinable(Blocks.ELDARIUM_ORE, 2);
    protected WorldGenerator gemmeGen = new WorldGenMinable(Blocks.GEMME_ORE, 1, Blocks.DIAMOND_ORE);

    // -------------------------------------

    protected WorldGenFlowers p = new WorldGenFlowers(Blocks.YELLOW_FLOWER);
    protected WorldGenerator q = new WorldGenFlowers(Blocks.BROWN_MUSHROOM);
    protected WorldGenerator r = new WorldGenFlowers(Blocks.RED_MUSHROOM);
    protected WorldGenerator s = new WorldGenHugeMushroom();
    protected WorldGenerator t = new WorldGenReed();
    protected WorldGenerator u = new WorldGenCactus();
    protected WorldGenerator v = new WorldGenWaterLily();
    protected int w;
    protected int x;
    protected int y = 2;
    protected int z = 1;
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E = 1;
    protected int F = 3;
    protected int G = 1;
    protected int H;
    public boolean I = true;

    public void a(World world, Random random, BiomeBase biomebase, int i, int j) {
        if (this.a != null) {
            throw new RuntimeException("Already decorating!!");
        } else {
            this.a = world;
            this.b = random;
            this.c = i;
            this.d = j;
            this.a(biomebase);
            this.a = null;
            this.b = null;
        }
    }

    protected void a(BiomeBase biomebase) {
        this.a();

        int i;
        int j;
        int k;

        for (i = 0; i < this.F; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.f.generate(this.a, this.b, j, this.a.i(j, k), k);
        }

        for (i = 0; i < this.G; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.e.generate(this.a, this.b, j, this.a.i(j, k), k);
        }

        for (i = 0; i < this.E; ++i) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            this.g.generate(this.a, this.b, j, this.a.i(j, k), k);
        }

        i = this.x;
        if (this.b.nextInt(10) == 0) {
            ++i;
        }

        int l;
        int i1;

        for (j = 0; j < i; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.a.getHighestBlockYAt(k, l);
            WorldGenTreeAbstract worldgentreeabstract = biomebase.a(this.b);

            worldgentreeabstract.a(1.0D, 1.0D, 1.0D);
            if (worldgentreeabstract.generate(this.a, this.b, k, i1, l)) {
                worldgentreeabstract.b(this.a, this.b, k, i1, l);
            }
        }

        for (j = 0; j < this.H; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            this.s.generate(this.a, this.b, k, this.a.getHighestBlockYAt(k, l), l);
        }

        for (j = 0; j < this.y; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.a.getHighestBlockYAt(k, l) + 32);
            String s = biomebase.a(this.b, k, i1, l);
            BlockFlowers blockflowers = BlockFlowers.e(s);

            if (blockflowers.getMaterial() != Material.AIR) {
                this.p.a(blockflowers, BlockFlowers.f(s));
                this.p.generate(this.a, this.b, k, i1, l);
            }
        }

        for (j = 0; j < this.z; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
            WorldGenerator worldgenerator = biomebase.b(this.b);

            worldgenerator.generate(this.a, this.b, k, i1, l);
        }

        for (j = 0; j < this.A; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
            (new WorldGenDeadBush(Blocks.DEAD_BUSH)).generate(this.a, this.b, k, i1, l);
        }

        for (j = 0; j < this.w; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;

            for (i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); i1 > 0 && this.a.isEmpty(k, i1 - 1, l); --i1) { // Spigot
                ;
            }

            this.v.generate(this.a, this.b, k, i1, l);
        }

        for (j = 0; j < this.B; ++j) {
            if (this.b.nextInt(4) == 0) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.d + this.b.nextInt(16) + 8;
                i1 = this.a.getHighestBlockYAt(k, l);
                this.q.generate(this.a, this.b, k, i1, l);
            }

            if (this.b.nextInt(8) == 0) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.d + this.b.nextInt(16) + 8;
                i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
                this.r.generate(this.a, this.b, k, i1, l);
            }
        }

        if (this.b.nextInt(4) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(this.getHighestBlockYAt(j, k) * 2); // Spigot
            this.q.generate(this.a, this.b, j, l, k);
        }

        if (this.b.nextInt(8) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(this.getHighestBlockYAt(j, k) * 2); // Spigot
            this.r.generate(this.a, this.b, j, l, k);
        }

        for (j = 0; j < this.C; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
            this.t.generate(this.a, this.b, k, i1, l);
        }

        for (j = 0; j < 10; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
            this.t.generate(this.a, this.b, k, i1, l);
        }

        if (this.b.nextInt(32) == 0) {
            j = this.c + this.b.nextInt(16) + 8;
            k = this.d + this.b.nextInt(16) + 8;
            l = this.b.nextInt(this.getHighestBlockYAt(j, k) * 2); // Spigot
            (new WorldGenPumpkin()).generate(this.a, this.b, j, l, k);
        }

        for (j = 0; j < this.D; ++j) {
            k = this.c + this.b.nextInt(16) + 8;
            l = this.d + this.b.nextInt(16) + 8;
            i1 = this.b.nextInt(this.getHighestBlockYAt(k, l) * 2); // Spigot
            this.u.generate(this.a, this.b, k, i1, l);
        }

        if (this.I) {
            for (j = 0; j < 50; ++j) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.b.nextInt(this.b.nextInt(248) + 8);
                i1 = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.WATER)).generate(this.a, this.b, k, l, i1);
            }

            for (j = 0; j < 20; ++j) {
                k = this.c + this.b.nextInt(16) + 8;
                l = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
                i1 = this.d + this.b.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.LAVA)).generate(this.a, this.b, k, l, i1);
            }
        }
    }

    protected void a(int i, WorldGenerator worldgenerator, int j, int k) {
        for (int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k - j) + j;
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.generate(this.a, this.b, i1, j1, k1);
        }
    }

    protected void b(int i, WorldGenerator worldgenerator, int j, int k) {
        for (int l = 0; l < i; ++l) {
            int i1 = this.c + this.b.nextInt(16);
            int j1 = this.b.nextInt(k) + this.b.nextInt(k) + (j - k);
            int k1 = this.d + this.b.nextInt(16);

            worldgenerator.generate(this.a, this.b, i1, j1, k1);
        }
    }

    protected void a() {
        this.a(20, this.h, 0, 256); // dirt
        this.a(10, this.i, 0, 256); // gravel
        this.a(20, this.j, 0, 128); // coal
        this.a(20, this.k, 0, 64); // iron
        this.a(2, this.l, 0, 32); // gold
        this.a(8, this.m, 0, 16); // redstone
        this.a(1, this.n, 0, 16); // diamond
        this.b(1, this.o, 16, 16); // lapis

        // --- Minerais Keyrisium ---

        this.a(4, this.zincGen, 2, 20);
        this.a(3, this.cronyxeGen, 2, 17);
        this.a(2, this.luckyGen, 2, 17);
        this.a(3, this.kobaltGen, 2, 16);
        this.a(4, this.xpGen, 2, 16);
        this.a(1, this.eldariumGen, 2, 16);
        this.a(425, this.gemmeGen, 0, 16);

        // --------------------------
    }

    // Spigot Start
    private int getHighestBlockYAt(int x, int z)
    {
        return Math.max( 1, this.a.getHighestBlockYAt( x, z ) );
    }
    // Spigot End
}
