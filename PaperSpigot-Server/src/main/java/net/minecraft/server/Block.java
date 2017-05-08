package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Block {

    public static final RegistryMaterials REGISTRY = new RegistryBlocks("air");
    private CreativeModeTab creativeTab;
    protected String d;
    public static final StepSound e = new StepSound("stone", 1.0F, 1.0F); // soundTypeStone
    public static final StepSound f = new StepSound("wood", 1.0F, 1.0F); // soundTypeWood
    public static final StepSound g = new StepSound("gravel", 1.0F, 1.0F); // soundTypeGravel
    public static final StepSound h = new StepSound("grass", 1.0F, 1.0F); // soundTypeGrass
    public static final StepSound i = new StepSound("stone", 1.0F, 1.0F); // soundTypePiston
    public static final StepSound j = new StepSound("stone", 1.0F, 1.5F); // soundTypeMetal
    public static final StepSound k = new StepSoundStone("stone", 1.0F, 1.0F); // soundTypeGlass
    public static final StepSound l = new StepSound("cloth", 1.0F, 1.0F); // soundTypeCloth
    public static final StepSound m = new StepSound("sand", 1.0F, 1.0F); // soundTypeSand
    public static final StepSound n = new StepSound("snow", 1.0F, 1.0F); // soundTypeSnow
    public static final StepSound o = new StepSoundLadder("ladder", 1.0F, 1.0F); // soundTypeLadder
    public static final StepSound p = new StepSoundAnvil("anvil", 0.3F, 1.0F); // soundTypeAnvil
    public static final StepSound soundTypeSlime = new StepSound("slime", 1.0F, 1.0F)// soundTypeSlime
    {
        public String getBreakSound()
        {
            return "mob.slime.big";
        }
        public String getStepSound()
        {
            return "mob.slime.big";
        }
        public String getPlaceSound()
        {
            return "mob.slime.small";
        }
    };
    protected boolean q;
    protected int r;
    protected boolean s;
    protected int t;
    protected boolean u;
    protected float strength;
    protected float durability;
    protected boolean x = true;
    protected boolean y = true;
    protected boolean z;
    protected boolean isTileEntity;
    protected double minX;
    protected double minY;
    protected double minZ;
    protected double maxX;
    protected double maxY;
    protected double maxZ;
    public StepSound stepSound;
    public float I;
    protected final Material material;
    public float frictionFactor;
    private String name;

    public static int getId(Block block) {
        return REGISTRY.b(block);
    }

    public static Block getById(int i) {
        return (Block) REGISTRY.a(i);
    }

    public static Block a(Item item) {
        return getById(Item.getId(item));
    }

    public static Block b(String s) {
        if (REGISTRY.b(s)) {
            return (Block) REGISTRY.get(s);
        } else {
            try {
                return (Block) REGISTRY.a(Integer.parseInt(s));
            } catch (NumberFormatException numberformatexception) {
                return null;
            }
        }
    }

    public boolean j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int m() {
        return this.t;
    }

    public boolean n() {
        return this.u;
    }

    public Material getMaterial() {
        return this.material;
    }

    public MaterialMapColor f(int i) {
        return this.getMaterial().r();
    }

    public static void p() {
        REGISTRY.a(0, "air", (new BlockAir()).setBlockName("air"));
        REGISTRY.a(1, "stone", (new BlockStone()).c(1.5F).b(10.0F).a(i).setBlockName("stone").setBlockTextureName("stone"));
        REGISTRY.a(2, "grass", (new BlockGrass()).c(0.6F).a(h).setBlockName("grass").setBlockTextureName("grass"));
        REGISTRY.a(3, "dirt", (new BlockDirt()).c(0.5F).a(g).setBlockName("dirt").setBlockTextureName("dirt"));
        Block block = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setBlockName("stonebrick").a(CreativeModeTab.b).setBlockTextureName("cobblestone");

        REGISTRY.a(4, "cobblestone", block);
        Block block1 = (new BlockWood()).c(2.0F).b(5.0F).a(f).setBlockName("wood").setBlockTextureName("planks");

        REGISTRY.a(5, "planks", block1);
        REGISTRY.a(6, "sapling", (new BlockSapling()).c(0.0F).a(h).setBlockName("sapling").setBlockTextureName("sapling"));
        REGISTRY.a(7, "bedrock", (new Block(Material.STONE)).s().b(6000000.0F).a(i).setBlockName("bedrock").H().a(CreativeModeTab.b).setBlockTextureName("bedrock"));
        REGISTRY.a(8, "flowing_water", (new BlockFlowing(Material.WATER)).c(100.0F).g(3).setBlockName("water").H().setBlockTextureName("water_flow"));
        REGISTRY.a(9, "water", (new BlockStationary(Material.WATER)).c(100.0F).g(3).setBlockName("water").H().setBlockTextureName("water_still"));
        REGISTRY.a(10, "flowing_lava", (new BlockFlowing(Material.LAVA)).c(100.0F).a(1.0F).setBlockName("lava").H().setBlockTextureName("lava_flow"));
        REGISTRY.a(11, "lava", (new BlockStationary(Material.LAVA)).c(100.0F).a(1.0F).setBlockName("lava").H().setBlockTextureName("lava_still"));
        REGISTRY.a(12, "sand", (new BlockSand()).c(0.5F).a(m).setBlockName("sand").setBlockTextureName("sand"));
        REGISTRY.a(13, "gravel", (new BlockGravel()).c(0.6F).a(g).setBlockName("gravel").setBlockTextureName("gravel"));
        REGISTRY.a(14, "gold_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreGold").setBlockTextureName("gold_ore"));
        REGISTRY.a(15, "iron_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreIron").setBlockTextureName("iron_ore"));
        REGISTRY.a(16, "coal_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreCoal").setBlockTextureName("coal_ore"));
        REGISTRY.a(17, "log", (new BlockLog1()).setBlockName("log").setBlockTextureName("log"));
        REGISTRY.a(18, "leaves", (new BlockLeaves1()).setBlockName("leaves").setBlockTextureName("leaves"));
        REGISTRY.a(19, "sponge", (new BlockSponge()).c(0.6F).a(h).setBlockName("sponge").setBlockTextureName("sponge"));
        REGISTRY.a(20, "glass", (new BlockGlass(Material.SHATTERABLE, false)).c(0.3F).a(k).setBlockName("glass").setBlockTextureName("glass"));
        REGISTRY.a(21, "lapis_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreLapis").setBlockTextureName("lapis_ore"));
        REGISTRY.a(22, "lapis_block", (new BlockOreBlock(MaterialMapColor.H)).c(3.0F).b(5.0F).a(i).setBlockName("blockLapis").a(CreativeModeTab.b).setBlockTextureName("lapis_block"));
        REGISTRY.a(23, "dispenser", (new BlockDispenser()).c(3.5F).a(i).setBlockName("dispenser").setBlockTextureName("dispenser"));
        Block block2 = (new BlockSandStone()).a(i).c(0.8F).setBlockName("sandStone").setBlockTextureName("sandstone");

        REGISTRY.a(24, "sandstone", block2);
        REGISTRY.a(25, "noteblock", (new BlockNote()).c(0.8F).setBlockName("musicBlock").setBlockTextureName("noteblock"));
        REGISTRY.a(26, "bed", (new BlockBed()).c(0.2F).setBlockName("bed").H().setBlockTextureName("bed"));
        REGISTRY.a(27, "golden_rail", (new BlockPoweredRail()).c(0.7F).a(j).setBlockName("goldenRail").setBlockTextureName("rail_golden"));
        REGISTRY.a(28, "detector_rail", (new BlockMinecartDetector()).c(0.7F).a(j).setBlockName("detectorRail").setBlockTextureName("rail_detector"));
        REGISTRY.a(29, "sticky_piston", (new BlockPiston(true)).setBlockName("pistonStickyBase"));
        REGISTRY.a(30, "web", (new BlockWeb()).g(1).c(4.0F).setBlockName("web").setBlockTextureName("web"));
        REGISTRY.a(31, "tallgrass", (new BlockLongGrass()).c(0.0F).a(h).setBlockName("tallgrass"));
        REGISTRY.a(32, "deadbush", (new BlockDeadBush()).c(0.0F).a(h).setBlockName("deadbush").setBlockTextureName("deadbush"));
        REGISTRY.a(33, "piston", (new BlockPiston(false)).setBlockName("pistonBase"));
        REGISTRY.a(34, "piston_head", new BlockPistonExtension());
        REGISTRY.a(35, "wool", (new BlockCloth(Material.CLOTH)).c(0.8F).a(l).setBlockName("cloth").setBlockTextureName("wool_colored"));
        REGISTRY.a(36, "piston_extension", new BlockPistonMoving());
        REGISTRY.a(37, "yellow_flower", (new BlockFlowers(0)).c(0.0F).a(h).setBlockName("flower1").setBlockTextureName("flower_dandelion"));
        REGISTRY.a(38, "red_flower", (new BlockFlowers(1)).c(0.0F).a(h).setBlockName("flower2").setBlockTextureName("flower_rose"));
        REGISTRY.a(39, "brown_mushroom", (new BlockMushroom()).c(0.0F).a(h).a(0.125F).setBlockName("mushroom").setBlockTextureName("mushroom_brown"));
        REGISTRY.a(40, "red_mushroom", (new BlockMushroom()).c(0.0F).a(h).setBlockName("mushroom").setBlockTextureName("mushroom_red"));
        REGISTRY.a(41, "gold_block", (new BlockOreBlock(MaterialMapColor.F)).c(3.0F).b(10.0F).a(j).setBlockName("blockGold").setBlockTextureName("gold_block"));
        REGISTRY.a(42, "iron_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setBlockName("blockIron").setBlockTextureName("iron_block"));
        REGISTRY.a(43, "double_stone_slab", (new BlockStep(true)).c(2.0F).b(10.0F).a(i).setBlockName("stoneSlab"));
        REGISTRY.a(44, "stone_slab", (new BlockStep(false)).c(2.0F).b(10.0F).a(i).setBlockName("stoneSlab"));
        Block block3 = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setBlockName("brick").a(CreativeModeTab.b).setBlockTextureName("brick");

        REGISTRY.a(45, "brick_block", block3);
        REGISTRY.a(46, "tnt", (new BlockTNT(1.0F)).c(0.0F).a(h).setBlockName("tnt").setBlockTextureName("tnt"));
        REGISTRY.a(47, "bookshelf", (new BlockBookshelf()).c(1.5F).a(f).setBlockName("bookshelf").setBlockTextureName("bookshelf"));
        REGISTRY.a(48, "mossy_cobblestone", (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setBlockName("stoneMoss").a(CreativeModeTab.b).setBlockTextureName("cobblestone_mossy"));
        REGISTRY.a(49, "obsidian", (new BlockObsidian()).c(50.0F).b(2000.0F).a(i).setBlockName("obsidian").setBlockTextureName("obsidian"));
        REGISTRY.a(50, "torch", (new BlockTorch()).c(0.0F).a(0.9375F).a(f).setBlockName("torch").setBlockTextureName("torch_on"));
        REGISTRY.a(51, "fire", (new BlockFire()).c(0.0F).a(1.0F).a(f).setBlockName("fire").H().setBlockTextureName("fire"));
        REGISTRY.a(52, "mob_spawner", (new BlockMobSpawner()).c(5.0F).a(j).setBlockName("mobSpawner").H().setBlockTextureName("mob_spawner"));
        REGISTRY.a(53, "oak_stairs", (new BlockStairs(block1, 0)).setBlockName("stairsWood"));
        REGISTRY.a(54, "chest", (new BlockChest(0)).c(2.5F).a(f).setBlockName("chest"));
        REGISTRY.a(55, "redstone_wire", (new BlockRedstoneWire()).c(0.0F).a(e).setBlockName("redstoneDust").H().setBlockTextureName("redstone_dust"));
        REGISTRY.a(56, "diamond_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreDiamond").setBlockTextureName("diamond_ore"));
        REGISTRY.a(57, "diamond_block", (new BlockOreBlock(MaterialMapColor.G)).c(5.0F).b(10.0F).a(j).setBlockName("blockDiamond").setBlockTextureName("diamond_block"));
        REGISTRY.a(58, "crafting_table", (new BlockWorkbench()).c(2.5F).a(f).setBlockName("workbench").setBlockTextureName("crafting_table"));
        REGISTRY.a(59, "wheat", (new BlockCrops()).setBlockName("crops").setBlockTextureName("wheat"));
        Block block4 = (new BlockSoil()).c(0.6F).a(g).setBlockName("farmland").setBlockTextureName("farmland");

        REGISTRY.a(60, "farmland", block4);
        Block furnace = new BlockFurnace().c(3.5F).a(i).setBlockName("furnace").a(CreativeModeTab.c).setBlockTextureName("furnace");
        REGISTRY.a(61, "furnace", furnace);
        REGISTRY.a(62, "lit_furnace", (new BlockFurnace(furnace)).c(3.5F).a(i).a(0.875F).setBlockName("furnace").setBlockTextureName("furnace"));
        REGISTRY.a(63, "standing_sign", (new BlockSign(TileEntitySign.class, true)).c(1.0F).a(f).setBlockName("sign").H());
        REGISTRY.a(64, "wooden_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorWood").H().setBlockTextureName("door_wood"));
        REGISTRY.a(65, "ladder", (new BlockLadder()).c(0.4F).a(o).setBlockName("ladder").setBlockTextureName("ladder"));
        REGISTRY.a(66, "rail", (new BlockMinecartTrack()).c(0.7F).a(j).setBlockName("rail").setBlockTextureName("rail_normal"));
        REGISTRY.a(67, "stone_stairs", (new BlockStairs(block, 0)).setBlockName("stairsStone"));
        REGISTRY.a(68, "wall_sign", (new BlockSign(TileEntitySign.class, false)).c(1.0F).a(f).setBlockName("sign").H());
        REGISTRY.a(69, "lever", (new BlockLever()).c(0.5F).a(f).setBlockName("lever").setBlockTextureName("lever"));
        REGISTRY.a(70, "stone_pressure_plate", (new BlockPressurePlateBinary("stone", Material.STONE, EnumMobType.MOBS)).c(0.5F).a(i).setBlockName("pressurePlate"));
        REGISTRY.a(71, "iron_door", (new BlockDoor(Material.ORE)).c(5.0F).a(j).setBlockName("doorIron").H().setBlockTextureName("door_iron"));
        REGISTRY.a(72, "wooden_pressure_plate", (new BlockPressurePlateBinary("planks_oak", Material.WOOD, EnumMobType.EVERYTHING)).c(0.5F).a(f).setBlockName("pressurePlate"));
        REGISTRY.a(73, "redstone_ore", (new BlockRedstoneOre(false)).c(3.0F).b(5.0F).a(i).setBlockName("oreRedstone").a(CreativeModeTab.b).setBlockTextureName("redstone_ore"));
        REGISTRY.a(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).a(0.625F).c(3.0F).b(5.0F).a(i).setBlockName("oreRedstone").setBlockTextureName("redstone_ore"));
        REGISTRY.a(75, "unlit_redstone_torch", (new BlockRedstoneTorch(false)).c(0.0F).a(f).setBlockName("notGate").setBlockTextureName("redstone_torch_off"));
        REGISTRY.a(76, "redstone_torch", (new BlockRedstoneTorch(true)).c(0.0F).a(0.5F).a(f).setBlockName("notGate").a(CreativeModeTab.d).setBlockTextureName("redstone_torch_on"));
        REGISTRY.a(77, "stone_button", (new BlockStoneButton()).c(0.5F).a(i).setBlockName("button"));
        REGISTRY.a(78, "snow_layer", (new BlockSnow()).c(0.1F).a(n).setBlockName("snow").g(0).setBlockTextureName("snow"));
        REGISTRY.a(79, "ice", (new BlockIce()).c(0.5F).g(3).a(k).setBlockName("ice").setBlockTextureName("ice"));
        REGISTRY.a(80, "snow", (new BlockSnowBlock()).c(0.2F).a(n).setBlockName("snow").setBlockTextureName("snow"));
        REGISTRY.a(81, "cactus", (new BlockCactus()).c(0.4F).a(l).setBlockName("cactus").setBlockTextureName("cactus"));
        REGISTRY.a(82, "clay", (new BlockClay()).c(0.6F).a(g).setBlockName("clay").setBlockTextureName("clay"));
        REGISTRY.a(83, "reeds", (new BlockReed()).c(0.0F).a(h).setBlockName("reeds").H().setBlockTextureName("reeds"));
        REGISTRY.a(84, "jukebox", (new BlockJukeBox()).c(2.0F).b(10.0F).a(i).setBlockName("jukebox").setBlockTextureName("jukebox"));
        REGISTRY.a(85, "fence", (new BlockFence("planks_oak", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("fence"));
        Block block5 = (new BlockPumpkin(false)).c(1.0F).a(f).setBlockName("pumpkin").setBlockTextureName("pumpkin");

        REGISTRY.a(86, "pumpkin", block5);
        REGISTRY.a(87, "netherrack", (new BlockBloodStone()).c(0.4F).a(i).setBlockName("hellrock").setBlockTextureName("netherrack"));
        REGISTRY.a(88, "soul_sand", (new BlockSlowSand()).c(0.5F).a(m).setBlockName("hellsand").setBlockTextureName("soul_sand"));
        REGISTRY.a(89, "glowstone", (new BlockLightStone(Material.SHATTERABLE)).c(0.3F).a(k).a(1.0F).setBlockName("lightgem").setBlockTextureName("glowstone"));
        REGISTRY.a(90, "portal", (new BlockPortal()).c(-1.0F).a(k).a(0.75F).setBlockName("portal").setBlockTextureName("portal"));
        REGISTRY.a(91, "lit_pumpkin", (new BlockPumpkin(true)).c(1.0F).a(f).a(1.0F).setBlockName("litpumpkin").setBlockTextureName("pumpkin"));
        REGISTRY.a(92, "cake", (new BlockCake()).c(0.5F).a(l).setBlockName("cake").H().setBlockTextureName("cake"));
        REGISTRY.a(93, "unpowered_repeater", (new BlockRepeater(false)).c(0.0F).a(f).setBlockName("diode").H().setBlockTextureName("repeater_off"));
        REGISTRY.a(94, "powered_repeater", (new BlockRepeater(true)).c(0.0F).a(0.625F).a(f).setBlockName("diode").H().setBlockTextureName("repeater_on"));
        REGISTRY.a(95, "stained_glass", (new BlockStainedGlass(Material.SHATTERABLE)).c(0.3F).a(k).setBlockName("stainedGlass").setBlockTextureName("glass"));
        REGISTRY.a(96, "trapdoor", (new BlockTrapdoor(Material.WOOD)).c(3.0F).a(f).setBlockName("trapdoor").H().setBlockTextureName("trapdoor"));
        REGISTRY.a(97, "monster_egg", (new BlockMonsterEggs()).c(0.75F).setBlockName("monsterStoneEgg"));
        Block block6 = (new BlockSmoothBrick()).c(1.5F).b(10.0F).a(i).setBlockName("stonebricksmooth").setBlockTextureName("stonebrick");

        REGISTRY.a(98, "stonebrick", block6);
        REGISTRY.a(99, "brown_mushroom_block", (new BlockHugeMushroom(Material.WOOD, 0)).c(0.2F).a(f).setBlockName("mushroom").setBlockTextureName("mushroom_block"));
        REGISTRY.a(100, "red_mushroom_block", (new BlockHugeMushroom(Material.WOOD, 1)).c(0.2F).a(f).setBlockName("mushroom").setBlockTextureName("mushroom_block"));
        REGISTRY.a(101, "iron_bars", (new BlockThin("iron_bars", "iron_bars", Material.ORE, true)).c(5.0F).b(10.0F).a(j).setBlockName("fenceIron"));
        REGISTRY.a(102, "glass_pane", (new BlockThin("glass", "glass_pane_top", Material.SHATTERABLE, false)).c(0.3F).a(k).setBlockName("thinGlass"));
        Block block7 = (new BlockMelon()).c(1.0F).a(f).setBlockName("melon").setBlockTextureName("melon");

        REGISTRY.a(103, "melon_block", block7);
        REGISTRY.a(104, "pumpkin_stem", (new BlockStem(block5)).c(0.0F).a(f).setBlockName("pumpkinStem").setBlockTextureName("pumpkin_stem"));
        REGISTRY.a(105, "melon_stem", (new BlockStem(block7)).c(0.0F).a(f).setBlockName("pumpkinStem").setBlockTextureName("melon_stem"));
        REGISTRY.a(106, "vine", (new BlockVine()).c(0.2F).a(h).setBlockName("vine").setBlockTextureName("vine"));
        REGISTRY.a(107, "fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("fenceGate").setBlockTextureName("planks_oak"));
        REGISTRY.a(108, "brick_stairs", (new BlockStairs(block3, 0)).setBlockName("stairsBrick"));
        REGISTRY.a(109, "stone_brick_stairs", (new BlockStairs(block6, 0)).setBlockName("stairsStoneBrickSmooth"));
        REGISTRY.a(110, "mycelium", (new BlockMycel()).c(0.6F).a(h).setBlockName("mycel").setBlockTextureName("mycelium"));
        REGISTRY.a(111, "waterlily", (new BlockWaterLily()).c(0.0F).a(h).setBlockName("waterlily").setBlockTextureName("waterlily"));
        Block block8 = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).setBlockName("netherBrick").a(CreativeModeTab.b).setBlockTextureName("nether_brick");

        REGISTRY.a(112, "nether_brick", block8);
        REGISTRY.a(113, "nether_brick_fence", (new BlockFence("nether_brick", Material.STONE)).c(2.0F).b(10.0F).a(i).setBlockName("netherFence"));
        REGISTRY.a(114, "nether_brick_stairs", (new BlockStairs(block8, 0)).setBlockName("stairsNetherBrick"));
        REGISTRY.a(115, "nether_wart", (new BlockNetherWart()).setBlockName("netherStalk").setBlockTextureName("nether_wart"));
        REGISTRY.a(116, "enchanting_table", (new BlockEnchantmentTable()).c(5.0F).b(2000.0F).setBlockName("enchantmentTable").setBlockTextureName("enchanting_table"));
        REGISTRY.a(117, "brewing_stand", (new BlockBrewingStand()).c(0.5F).a(0.125F).setBlockName("brewingStand").setBlockTextureName("brewing_stand"));
        REGISTRY.a(118, "cauldron", (new BlockCauldron()).c(2.0F).setBlockName("cauldron").setBlockTextureName("cauldron"));
        REGISTRY.a(119, "end_portal", (new BlockEnderPortal(Material.PORTAL)).c(-1.0F).b(6000000.0F));
        REGISTRY.a(120, "end_portal_frame", (new BlockEnderPortalFrame()).a(k).a(0.125F).c(-1.0F).setBlockName("endPortalFrame").b(6000000.0F).a(CreativeModeTab.c).setBlockTextureName("endframe"));
        REGISTRY.a(121, "end_stone", (new Block(Material.STONE)).c(3.0F).b(15.0F).a(i).setBlockName("whiteStone").a(CreativeModeTab.b).setBlockTextureName("end_stone"));
        REGISTRY.a(122, "dragon_egg", (new BlockDragonEgg()).c(3.0F).b(15.0F).a(i).a(0.125F).setBlockName("dragonEgg").setBlockTextureName("dragon_egg"));
        REGISTRY.a(123, "redstone_lamp", (new BlockRedstoneLamp(false)).c(0.3F).a(k).setBlockName("redstoneLight").a(CreativeModeTab.d).setBlockTextureName("redstone_lamp_off"));
        REGISTRY.a(124, "lit_redstone_lamp", (new BlockRedstoneLamp(true)).c(0.3F).a(k).setBlockName("redstoneLight").setBlockTextureName("redstone_lamp_on"));
        REGISTRY.a(125, "double_wooden_slab", (new BlockWoodStep(true)).c(2.0F).b(5.0F).a(f).setBlockName("woodSlab"));
        REGISTRY.a(126, "wooden_slab", (new BlockWoodStep(false)).c(2.0F).b(5.0F).a(f).setBlockName("woodSlab"));
        REGISTRY.a(127, "cocoa", (new BlockCocoa()).c(0.2F).b(5.0F).a(f).setBlockName("cocoa").setBlockTextureName("cocoa"));
        REGISTRY.a(128, "sandstone_stairs", (new BlockStairs(block2, 0)).setBlockName("stairsSandStone"));
        REGISTRY.a(129, "emerald_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("oreEmerald").setBlockTextureName("emerald_ore"));
        REGISTRY.a(130, "ender_chest", (new BlockEnderChest()).c(22.5F).b(1000.0F).a(i).setBlockName("enderChest").a(0.5F));
        REGISTRY.a(131, "tripwire_hook", (new BlockTripwireHook()).setBlockName("tripWireSource").setBlockTextureName("trip_wire_source"));
        REGISTRY.a(132, "tripwire", (new BlockTripwire()).setBlockName("tripWire").setBlockTextureName("trip_wire"));
        REGISTRY.a(133, "emerald_block", (new BlockOreBlock(MaterialMapColor.I)).c(5.0F).b(10.0F).a(j).setBlockName("blockEmerald").setBlockTextureName("emerald_block"));
        REGISTRY.a(134, "spruce_stairs", (new BlockStairs(block1, 1)).setBlockName("stairsWoodSpruce"));
        REGISTRY.a(135, "birch_stairs", (new BlockStairs(block1, 2)).setBlockName("stairsWoodBirch"));
        REGISTRY.a(136, "jungle_stairs", (new BlockStairs(block1, 3)).setBlockName("stairsWoodJungle"));
        REGISTRY.a(137, "command_block", (new BlockCommand()).s().b(6000000.0F).setBlockName("commandBlock").setBlockTextureName("command_block"));
        REGISTRY.a(138, "beacon", (new BlockBeacon()).setBlockName("beacon").a(1.0F).setBlockTextureName("beacon"));
        REGISTRY.a(139, "cobblestone_wall", (new BlockCobbleWall(block)).setBlockName("cobbleWall"));
        REGISTRY.a(140, "flower_pot", (new BlockFlowerPot()).c(0.0F).a(e).setBlockName("flowerPot").setBlockTextureName("flower_pot"));
        REGISTRY.a(141, "carrots", (new BlockCarrots()).setBlockName("carrots").setBlockTextureName("carrots"));
        REGISTRY.a(142, "potatoes", (new BlockPotatoes()).setBlockName("potatoes").setBlockTextureName("potatoes"));
        REGISTRY.a(143, "wooden_button", (new BlockWoodButton()).c(0.5F).a(f).setBlockName("button"));
        REGISTRY.a(144, "skull", (new BlockSkull()).c(1.0F).a(i).setBlockName("skull").setBlockTextureName("skull"));
        REGISTRY.a(145, "anvil", (new BlockAnvil()).c(5.0F).a(p).b(2000.0F).setBlockName("anvil"));
        REGISTRY.a(146, "trapped_chest", (new BlockChest(1)).c(2.5F).a(f).setBlockName("chestTrap"));
        REGISTRY.a(147, "light_weighted_pressure_plate", (new BlockPressurePlateWeighted("gold_block", Material.ORE, 15)).c(0.5F).a(f).setBlockName("weightedPlate_light"));
        REGISTRY.a(148, "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighted("iron_block", Material.ORE, 150)).c(0.5F).a(f).setBlockName("weightedPlate_heavy"));
        REGISTRY.a(149, "unpowered_comparator", (new BlockRedstoneComparator(false)).c(0.0F).a(f).setBlockName("comparator").H().setBlockTextureName("comparator_off"));
        REGISTRY.a(150, "powered_comparator", (new BlockRedstoneComparator(true)).c(0.0F).a(0.625F).a(f).setBlockName("comparator").H().setBlockTextureName("comparator_on"));
        REGISTRY.a(151, "daylight_detector", (new BlockDaylightDetector()).c(0.2F).a(f).setBlockName("daylightDetector").setBlockTextureName("daylight_detector"));
        REGISTRY.a(152, "redstone_block", (new BlockRedstone(MaterialMapColor.f)).c(5.0F).b(10.0F).a(j).setBlockName("blockRedstone").setBlockTextureName("redstone_block"));
        REGISTRY.a(153, "quartz_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).setBlockName("netherquartz").setBlockTextureName("quartz_ore"));
        REGISTRY.a(154, "hopper", (new BlockHopper()).c(3.0F).b(8.0F).a(f).setBlockName("hopper").setBlockTextureName("hopper"));
        Block block9 = (new BlockQuartz()).a(i).c(0.8F).setBlockName("quartzBlock").setBlockTextureName("quartz_block");

        REGISTRY.a(155, "quartz_block", block9);
        REGISTRY.a(156, "quartz_stairs", (new BlockStairs(block9, 0)).setBlockName("stairsQuartz"));
        REGISTRY.a(157, "activator_rail", (new BlockPoweredRail()).c(0.7F).a(j).setBlockName("activatorRail").setBlockTextureName("rail_activator"));
        REGISTRY.a(158, "dropper", (new BlockDropper()).c(3.5F).a(i).setBlockName("dropper").setBlockTextureName("dropper"));
        REGISTRY.a(159, "stained_hardened_clay", (new BlockCloth(Material.STONE)).c(1.25F).b(7.0F).a(i).setBlockName("clayHardenedStained").setBlockTextureName("hardened_clay_stained"));
        REGISTRY.a(160, "stained_glass_pane", (new BlockStainedGlassPane()).c(0.3F).a(k).setBlockName("thinStainedGlass").setBlockTextureName("glass"));
        REGISTRY.a(161, "leaves2", (new BlockLeaves2()).setBlockName("leaves").setBlockTextureName("leaves"));
        REGISTRY.a(162, "log2", (new BlockLog2()).setBlockName("log").setBlockTextureName("log"));
        REGISTRY.a(163, "acacia_stairs", (new BlockStairs(block1, 4)).setBlockName("stairsWoodAcacia"));
        REGISTRY.a(164, "dark_oak_stairs", (new BlockStairs(block1, 5)).setBlockName("stairsWoodDarkOak"));
        REGISTRY.a(166, "barrier", new BlockBarrier().setBlockName("barrier").a(CreativeModeTab.c));
        REGISTRY.a(169, "sea_lantern", (new BlockSeaLantern(Material.BUILDABLE_GLASS)).c(0.3F).a(k).a(1.0F).setBlockName("seaLantern"));
        REGISTRY.a(170, "hay_block", (new BlockHay()).c(0.5F).a(h).setBlockName("hayBlock").a(CreativeModeTab.b).setBlockTextureName("hay_block"));
        REGISTRY.a(171, "carpet", (new BlockCarpet()).c(0.1F).a(l).setBlockName("woolCarpet").g(0));
        REGISTRY.a(172, "hardened_clay", (new BlockHardenedClay()).c(1.25F).b(7.0F).a(i).setBlockName("clayHardened").setBlockTextureName("hardened_clay"));
        REGISTRY.a(173, "coal_block", (new Block(Material.STONE)).c(5.0F).b(10.0F).a(i).setBlockName("blockCoal").a(CreativeModeTab.b).setBlockTextureName("coal_block"));
        REGISTRY.a(174, "packed_ice", (new BlockPackedIce()).c(0.5F).a(k).setBlockName("icePacked").setBlockTextureName("ice_packed"));
        REGISTRY.a(175, "double_plant", new BlockTallPlant());
        REGISTRY.a(183, "spruce_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("spruceFenceGate").setBlockTextureName("planks_spruce"));
        REGISTRY.a(184, "birch_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("birchFenceGate").setBlockTextureName("planks_birch"));
        REGISTRY.a(185, "jungle_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("jungleFenceGate").setBlockTextureName("planks_jungle"));
        REGISTRY.a(186, "dark_oak_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("darkOakFenceGate").setBlockTextureName("planks_big_oak"));
        REGISTRY.a(187, "acacia_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).setBlockName("acaciaFenceGate").setBlockTextureName("planks_acacia"));
        REGISTRY.a(188, "spruce_fence", (new BlockFence("planks_spruce", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("spruceFence"));
        REGISTRY.a(189, "birch_fence", (new BlockFence("planks_birch", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("birchFence"));
        REGISTRY.a(190, "jungle_fence", (new BlockFence("planks_jungle", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("jungleFence"));
        REGISTRY.a(191, "dark_oak_fence", (new BlockFence("planks_big_oak", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("darkOakFence"));
        REGISTRY.a(192, "acacia_fence", (new BlockFence("planks_acacia", Material.WOOD)).c(2.0F).b(5.0F).a(f).setBlockName("acaciaFence"));
        REGISTRY.a(193, "spruce_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorSpruce").H());
        REGISTRY.a(194, "birch_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorBirch").H());
        REGISTRY.a(195, "jungle_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorJungle").H());
        REGISTRY.a(196, "acacia_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorAcacia").H());
        REGISTRY.a(197, "dark_oak_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).setBlockName("doorDarkOak").H());

        // --- Blocs Keyrisium ---
        int id = 200;

        Block obsidianFurnace = (new BlockFurnace()).setFurnaceSpeed(2.0).c(50.0F).b(2000.0F).a(i).setBlockName("obsidianFurnace").a(CreativeModeTab.c).setBlockTextureName("obsidian_furnace");
        REGISTRY.a(id++, "obsidian_furnace", obsidianFurnace);
        REGISTRY.a(id++, "lit_obsidian_furnace", new BlockFurnace(obsidianFurnace).setFurnaceSpeed(2.0).c(50.0F).b(2000.0F).a(i).a(0.875F).setBlockName("obsidianFurnace").setBlockTextureName("obsidian_furnace"));
        REGISTRY.a(id++, "reinforced_obsidian", new Block(Material.BRICK).c(100.0F).b(4000.0F).a(i).setBlockName("reinforcedObsidian").a(CreativeModeTab.b).setBlockTextureName("reinforced_obsidian"));
        REGISTRY.a(id++, "water_pipe", new BlockWaterPipe().c(0.5F).a(0.125F).setBlockName("waterPipe").a(CreativeModeTab.k).setBlockTextureName("water_pipe"));
        REGISTRY.a(id++, "iron_ladder", (new BlockLadder()).c(5.0F).b(10.0F).a(j).setBlockName("ironLadder").setBlockTextureName("iron_ladder"));
        REGISTRY.a(id++, "slime", new BlockSlime().setBlockName("slime").a(soundTypeSlime));
        REGISTRY.a(id++, "lignite_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreLignite").setBlockTextureName("lignite_ore"));
        REGISTRY.a(id++, "zinc_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreZinc").setBlockTextureName("zinc_ore"));
        REGISTRY.a(id++, "cronyxe_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreCronyxe").setBlockTextureName("cronyxe_ore"));
        REGISTRY.a(id++, "kobalt_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreKobalt").setBlockTextureName("kobalt_ore"));
        REGISTRY.a(id++, "eldarium_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreEldarium").setBlockTextureName("eldarium_ore"));
        REGISTRY.a(id++, "gemme_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreGemme").setBlockTextureName("gemme_ore"));
        REGISTRY.a(id++, "greek_tnt", (new BlockTNT(3.0F)).c(0.0F).a(h).setBlockName("greekTnt").setBlockTextureName("greek_tnt"));
        REGISTRY.a(id++, "obsand", new BlockFalling(Material.BRICK).c(50.0F).b(2000.0F).a(i).setBlockName("obsand").a(CreativeModeTab.b).setBlockTextureName("obsand"));
        REGISTRY.a(id++, "mystery_box", new BlockChest(2).c(2.5F).a(i).setBlockName("mysteryBox"));
        REGISTRY.a(id++, "magic_chest", new BlockChest(3).c(2.5F).a(i).setBlockName("magicChest"));
        REGISTRY.a(id++, "zinc_chest", new BlockChest(4, false, 36).c(2.5F).a(i).setBlockName("zincChest"));
        REGISTRY.a(id++, "cronyxe_chest", new BlockChest(5, false, 45).c(2.5F).a(i).setBlockName("cronyxeChest"));
        REGISTRY.a(id++, "kobalt_chest", new BlockChest(6, false, 54).c(2.5F).a(i).setBlockName("kobaltChest"));
        REGISTRY.a(id++, "zinc_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setBlockName("blockZinc").setBlockTextureName("zinc_block"));
        REGISTRY.a(id++, "cronyxe_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setBlockName("blockCronyxe").setBlockTextureName("cronyxe_block"));
        REGISTRY.a(id++, "kobalt_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setBlockName("blockKobalt").setBlockTextureName("kobalt_block"));
        REGISTRY.a(id++, "eldarium_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).setBlockName("blockEldarium").setBlockTextureName("eldarium_block"));
        REGISTRY.a(id++, "xp_ore", new BlockOre().c(3.0F).b(5.0F).a(i).setBlockName("oreXp").setBlockTextureName("xp_ore"));
        REGISTRY.a(id++, "lucky_ore", new Block(Material.STONE).a(CreativeModeTab.b).c(3.0F).b(5.0F).a(i).setBlockName("oreLuck").setBlockTextureName("lucky_ore"));
        REGISTRY.a(id++, "peppers", new BlockPeppers().setBlockName("peppers").setBlockTextureName("peppers"));


        // -----------------------

        Iterator iterator = REGISTRY.iterator();

        while (iterator.hasNext()) {
            Block block10 = (Block) iterator.next();

            if (block10.material == Material.AIR) {
                block10.u = false;
            } else {
                boolean flag = false;
                boolean flag1 = block10.b() == 10;
                boolean flag2 = block10 instanceof BlockStepAbstract;
                boolean flag3 = block10 == block4;
                boolean flag4 = block10.s;
                boolean flag5 = block10.r == 0;

                if (flag1 || flag2 || flag3 || flag4 || flag5) {
                    flag = true;
                }

                block10.u = flag;
            }
        }
    }

    protected Block(Material material) {
        this.stepSound = e;
        this.I = 1.0F;
        this.frictionFactor = 0.6F;
        this.material = material;
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.q = this.c();
        this.r = this.c() ? 255 : 0;
        this.s = !material.blocksLight();
    }

    protected Block a(StepSound stepsound) {
        this.stepSound = stepsound;
        return this;
    }

    protected Block g(int i) {
        this.r = i;
        return this;
    }

    protected Block a(float f) {
        this.t = (int) (15.0F * f);
        return this;
    }

    protected Block b(float f) {
        this.durability = f * 3.0F;
        return this;
    }

    public boolean r() {
        return this.material.k() && this.d() && !this.isPowerSource();
    }

    public boolean d() {
        return true;
    }

    public boolean b(IBlockAccess iblockaccess, int i, int j, int k) {
        return !this.material.isSolid();
    }

    public int b() {
        return 0;
    }

    protected Block c(float f) {
        this.strength = f;
        if (this.durability < f * 5.0F) {
            this.durability = f * 5.0F;
        }

        return this;
    }

    protected Block s() {
        this.c(-1.0F);
        return this;
    }

    public float f(World world, int i, int j, int k) {
        return this.strength;
    }

    protected Block a(boolean flag) {
        this.z = flag;
        return this;
    }

    public boolean isTicking() {
        return this.z;
    }

    public boolean isTileEntity() {
        return this.isTileEntity;
    }

    protected final void a(float f, float f1, float f2, float f3, float f4, float f5) {
        this.minX = (double) f;
        this.minY = (double) f1;
        this.minZ = (double) f2;
        this.maxX = (double) f3;
        this.maxY = (double) f4;
        this.maxZ = (double) f5;
    }

    public boolean d(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return iblockaccess.getType(i, j, k).getMaterial().isBuildable();
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, List list, Entity entity) {
        AxisAlignedBB axisalignedbb1 = this.a(world, i, j, k);

        if (axisalignedbb1 != null && axisalignedbb.b(axisalignedbb1)) {
            list.add(axisalignedbb1);
        }
    }

    public AxisAlignedBB a(World world, int i, int j, int k) {
        return AxisAlignedBB.a((double) i + this.minX, (double) j + this.minY, (double) k + this.minZ, (double) i + this.maxX, (double) j + this.maxY, (double) k + this.maxZ);
    }

    public boolean c() {
        return true;
    }

    public boolean a(int i, boolean flag) {
        return this.v();
    }

    public boolean v() {
        return true;
    }

    public void a(World world, int i, int j, int k, Random random) {}

    public void postBreak(World world, int i, int j, int k, int l) {}

    public void doPhysics(World world, int i, int j, int k, Block block) {}

    public int a(World world) {
        return 10;
    }

    public void onPlace(World world, int i, int j, int k) {
        org.spigotmc.AsyncCatcher.catchOp( "block onPlace"); // Spigot
    }

    public void remove(World world, int i, int j, int k, Block block, int l) {
        org.spigotmc.AsyncCatcher.catchOp( "block remove"); // Spigot
    }

    public int a(Random random) {
        return 1;
    }

    public Item getDropType(int i, Random random, int j) {
        return Item.getItemOf(this);
    }

    public float getDamage(EntityHuman entityhuman, World world, int i, int j, int k) {
        float f = this.f(world, i, j, k);

        return f < 0.0F ? 0.0F : (!entityhuman.a(this) ? entityhuman.a(this, false) / f / 100.0F : entityhuman.a(this, true) / f / 30.0F);
    }

    public final void b(World world, int i, int j, int k, int l, int i1) {
        this.dropNaturally(world, i, j, k, l, 1.0F, i1);
    }

    public void dropNaturally(World world, int i, int j, int k, int l, float f, int i1) {
        if (!world.isStatic) {
            int j1 = this.getDropCount(i1, world.random);

            for (int k1 = 0; k1 < j1; ++k1) {
                // CraftBukkit - <= to < to allow for plugins to completely disable block drops from explosions
                if (world.random.nextFloat() < f) {
                    Item item = this.getDropType(l, world.random, i1);

                    if (item != null) {
                        this.a(world, i, j, k, new ItemStack(item, 1, this.getDropData(l)));
                    }
                }
            }
        }
    }

    protected void a(World world, int i, int j, int k, ItemStack itemstack) {
        if (!world.isStatic && world.getGameRules().getBoolean("doTileDrops")) {
            float f = 0.7F;
            double d0 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d1 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            double d2 = (double) (world.random.nextFloat() * f) + (double) (1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double) i + d0, (double) j + d1, (double) k + d2, itemstack);

            entityitem.pickupDelay = 10;
            world.addEntity(entityitem);
        }
    }

    protected void dropExperience(World world, int i, int j, int k, int l) {
        if (!world.isStatic) {
            while (l > 0) {
                int i1 = EntityExperienceOrb.getOrbValue(l);

                l -= i1;
                world.addEntity(new EntityExperienceOrb(world, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, i1));
            }
        }
    }

    public int getDropData(int i) {
        return 0;
    }

    public float a(Entity entity) {
        return this.durability / 5.0F;
    }

    public MovingObjectPosition a(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1) {
        this.updateShape(world, i, j, k);
        vec3d = vec3d.add((double) (-i), (double) (-j), (double) (-k));
        vec3d1 = vec3d1.add((double) (-i), (double) (-j), (double) (-k));
        Vec3D vec3d2 = vec3d.b(vec3d1, this.minX);
        Vec3D vec3d3 = vec3d.b(vec3d1, this.maxX);
        Vec3D vec3d4 = vec3d.c(vec3d1, this.minY);
        Vec3D vec3d5 = vec3d.c(vec3d1, this.maxY);
        Vec3D vec3d6 = vec3d.d(vec3d1, this.minZ);
        Vec3D vec3d7 = vec3d.d(vec3d1, this.maxZ);

        if (!this.a(vec3d2)) {
            vec3d2 = null;
        }

        if (!this.a(vec3d3)) {
            vec3d3 = null;
        }

        if (!this.b(vec3d4)) {
            vec3d4 = null;
        }

        if (!this.b(vec3d5)) {
            vec3d5 = null;
        }

        if (!this.c(vec3d6)) {
            vec3d6 = null;
        }

        if (!this.c(vec3d7)) {
            vec3d7 = null;
        }

        Vec3D vec3d8 = null;

        if (vec3d2 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d2) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d2;
        }

        if (vec3d3 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d3) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d3;
        }

        if (vec3d4 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d4) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d4;
        }

        if (vec3d5 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d5) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d5;
        }

        if (vec3d6 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d6) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d6;
        }

        if (vec3d7 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d7) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d7;
        }

        if (vec3d8 == null) {
            return null;
        } else {
            byte b0 = -1;

            if (vec3d8 == vec3d2) {
                b0 = 4;
            }

            if (vec3d8 == vec3d3) {
                b0 = 5;
            }

            if (vec3d8 == vec3d4) {
                b0 = 0;
            }

            if (vec3d8 == vec3d5) {
                b0 = 1;
            }

            if (vec3d8 == vec3d6) {
                b0 = 2;
            }

            if (vec3d8 == vec3d7) {
                b0 = 3;
            }

            return new MovingObjectPosition(i, j, k, b0, vec3d8.add((double) i, (double) j, (double) k));
        }
    }

    private boolean a(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.b >= this.minY && vec3d.b <= this.maxY && vec3d.c >= this.minZ && vec3d.c <= this.maxZ;
    }

    private boolean b(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.minX && vec3d.a <= this.maxX && vec3d.c >= this.minZ && vec3d.c <= this.maxZ;
    }

    private boolean c(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.minX && vec3d.a <= this.maxX && vec3d.b >= this.minY && vec3d.b <= this.maxY;
    }

    public void wasExploded(World world, int i, int j, int k, Explosion explosion) {}

    public boolean canPlace(World world, int i, int j, int k, int l, ItemStack itemstack) {
        return this.canPlace(world, i, j, k, l);
    }

    public boolean canPlace(World world, int i, int j, int k, int l) {
        return this.canPlace(world, i, j, k);
    }

    public boolean canPlace(World world, int i, int j, int k) {
        return world.getType(i, j, k).material.isReplaceable();
    }

    public boolean interact(World world, int i, int j, int k, EntityHuman entityhuman, int l, float f, float f1, float f2) {
        return false;
    }

    public void b(World world, int i, int j, int k, Entity entity) { // onEntityWalking()
        entity.motY = 0.0;
    }

    public int getPlacedData(World world, int i, int j, int k, int l, float f, float f1, float f2, int i1) {
        return i1;
    }

    public void attack(World world, int i, int j, int k, EntityHuman entityhuman) {}

    public void a(World world, int i, int j, int k, Entity entity, Vec3D vec3d) {}

    public void updateShape(IBlockAccess iblockaccess, int i, int j, int k) {}

    public final double x() {
        return this.minX;
    }

    public final double y() {
        return this.maxX;
    }

    public final double z() {
        return this.minY;
    }

    public final double A() {
        return this.maxY;
    }

    public final double B() {
        return this.minZ;
    }

    public final double C() {
        return this.maxZ;
    }

    public int b(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return 0;
    }

    public boolean isPowerSource() {
        return false;
    }

    public void a(World world, int i, int j, int k, Entity entity) {}

    public int c(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return 0;
    }

    public void g() {}

    public void a(World world, EntityHuman entityhuman, int i, int j, int k, int l) {
        entityhuman.a(StatisticList.MINE_BLOCK_COUNT[getId(this)], 1);
        entityhuman.applyExhaustion(world.paperSpigotConfig.blockBreakExhaustion); // PaperSpigot - Configurable block break exhaustion
        if (this.E() && EnchantmentManager.hasSilkTouchEnchantment(entityhuman)) {
            ItemStack itemstack = this.j(l);

            if (itemstack != null) {
                this.a(world, i, j, k, itemstack);
            }
        } else {
            int i1 = EnchantmentManager.getBonusBlockLootEnchantmentLevel(entityhuman);

            this.b(world, i, j, k, l, i1);
        }
    }

    protected boolean E() {
        return this.d() && !this.isTileEntity;
    }

    protected ItemStack j(int i) {
        int j = 0;
        Item item = Item.getItemOf(this);

        if (item != null && item.n()) {
            j = i;
        }

        return new ItemStack(item, 1, j);
    }

    public int getDropCount(int i, Random random) {
        return this.a(random);
    }

    public boolean j(World world, int i, int j, int k) {
        return true;
    }

    public void postPlace(World world, int i, int j, int k, EntityLiving entityliving, ItemStack itemstack) {}

    public void postPlace(World world, int i, int j, int k, int l) {}

    public Block setBlockName(String s) {
        this.name = s;
        return this;
    }

    public String getName() {
        return LocaleI18n.get(this.a() + ".name");
    }

    public String a() {
        return "tile." + this.name;
    }

    public boolean a(World world, int i, int j, int k, int l, int i1) {
        return false;
    }

    public boolean G() {
        return this.y;
    }

    protected Block H() {
        this.y = false;
        return this;
    }

    public int h() {
        return this.material.getPushReaction();
    }

    public void a(World world, int i, int j, int k, Entity entity, float f) {} // onFallenUpon()

    public int getDropData(World world, int i, int j, int k) {
        return this.getDropData(world.getData(i, j, k));
    }

    public Block a(CreativeModeTab creativemodetab) {
        this.creativeTab = creativemodetab;
        return this;
    }

    public void a(World world, int i, int j, int k, int l, EntityHuman entityhuman) {}

    public void f(World world, int i, int j, int k, int l) {}

    public void l(World world, int i, int j, int k) {}

    public boolean L() {
        return true;
    }

    public boolean a(Explosion explosion) {
        return true;
    }

    public boolean c(Block block) {
        return this == block;
    }

    public static boolean a(Block block, Block block1) {
        return block != null && block1 != null ? (block == block1 ? true : block.c(block1)) : false;
    }

    public boolean isComplexRedstone() {
        return false;
    }

    public int g(World world, int i, int j, int k, int l) {
        return 0;
    }

    protected Block setBlockTextureName(String s) {
        this.d = s;
        return this;
    }

    // CraftBukkit start
    public int getExpDrop(World world, int data, int enchantmentLevel) {
        return 0;
    }
    // CraftBukkit end

    // Spigot start
    public static float range(float min, float value, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
    // Spigot end
}
