//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.*;

public class StatisticList {
	protected static Map a = new HashMap();
	public static List stats = new ArrayList();
	public static List c = new ArrayList();
	public static List d = new ArrayList();
	public static List e = new ArrayList();
	public static Statistic f = (new CounterStatistic("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).i().h();
	public static Statistic g = (new CounterStatistic("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), Statistic.h)).i().h();
	public static Statistic h = (new CounterStatistic("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic i = (new CounterStatistic("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic j = (new CounterStatistic("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic k = (new CounterStatistic("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic l = (new CounterStatistic("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic m = (new CounterStatistic("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic n = (new CounterStatistic("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic o = (new CounterStatistic("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic p = (new CounterStatistic("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic q = (new CounterStatistic("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), Statistic.i)).i().h();
	public static Statistic r = (new CounterStatistic("stat.jump", new ChatMessage("stat.jump", new Object[0]))).i().h();
	public static Statistic s = (new CounterStatistic("stat.drop", new ChatMessage("stat.drop", new Object[0]))).i().h();
	public static Statistic t = (new CounterStatistic("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), Statistic.j)).h();
	public static Statistic u = (new CounterStatistic("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), Statistic.j)).h();
	public static Statistic v = (new CounterStatistic("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
	public static Statistic w = (new CounterStatistic("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
	public static Statistic x = (new CounterStatistic("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
	public static Statistic y = (new CounterStatistic("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
	public static Statistic z = (new CounterStatistic("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
	public static Statistic A = (new CounterStatistic("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
	public static Statistic B = (new CounterStatistic("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
	public static final Statistic[] MINE_BLOCK_COUNT = new Statistic[4096];
	public static final Statistic[] CRAFT_BLOCK_COUNT = new Statistic[32000];
	public static final Statistic[] USE_ITEM_COUNT = new Statistic[32000];
	public static final Statistic[] BREAK_ITEM_COUNT = new Statistic[32000];

	public static void a() {
		c();
		d();
		e();
		b();
		AchievementList.a();
		EntityTypes.a();
	}

	private static void b() {
		HashSet var0 = new HashSet();
		Iterator var1 = CraftingManager.getInstance().getRecipes().iterator();

		while(var1.hasNext()) {
			IRecipe var2 = (IRecipe)var1.next();
			if(var2.b() != null) {
				var0.add(var2.b().getItem());
			}
		}

		var1 = RecipesFurnace.getInstance().getRecipes().values().iterator();

		while(var1.hasNext()) {
			ItemStack var4 = (ItemStack)var1.next();
			var0.add(var4.getItem());
		}

		var1 = var0.iterator();

		while(var1.hasNext()) {
			Item var5 = (Item)var1.next();
			if(var5 != null) {
				int var3 = Item.getId(var5);
				CRAFT_BLOCK_COUNT[var3] = (new CraftingStatistic("stat.craftItem." + var3, new ChatMessage("stat.craftItem", new Object[]{(new ItemStack(var5)).E()}), var5)).h();
			}
		}

		a(CRAFT_BLOCK_COUNT);
	}

	private static void c() {
		Iterator var0 = Block.REGISTRY.iterator();

		while(var0.hasNext()) {
			Block var1 = (Block)var0.next();
			if(Item.getItemOf(var1) != null) {
				int var2 = Block.getId(var1);
				if(var1.G()) {
					MINE_BLOCK_COUNT[var2] = (new CraftingStatistic("stat.mineBlock." + var2, new ChatMessage("stat.mineBlock", new Object[]{(new ItemStack(var1)).E()}), Item.getItemOf(var1))).h();
					e.add((CraftingStatistic)MINE_BLOCK_COUNT[var2]);
				}
			}
		}

		a(MINE_BLOCK_COUNT);
	}

	private static void d() {
		Iterator var0 = Item.REGISTRY.iterator();

		while(var0.hasNext()) {
			Item var1 = (Item)var0.next();
			if(var1 != null) {
				int var2 = Item.getId(var1);
				USE_ITEM_COUNT[var2] = (new CraftingStatistic("stat.useItem." + var2, new ChatMessage("stat.useItem", new Object[]{(new ItemStack(var1)).E()}), var1)).h();
				if(!(var1 instanceof ItemBlock)) {
					d.add((CraftingStatistic)USE_ITEM_COUNT[var2]);
				}
			}
		}

		a(USE_ITEM_COUNT);
	}

	private static void e() {
		Iterator var0 = Item.REGISTRY.iterator();

		while(var0.hasNext()) {
			Item var1 = (Item)var0.next();
			if(var1 != null) {
				int var2 = Item.getId(var1);
				if(var1.usesDurability()) {
					BREAK_ITEM_COUNT[var2] = (new CraftingStatistic("stat.breakItem." + var2, new ChatMessage("stat.breakItem", new Object[]{(new ItemStack(var1)).E()}), var1)).h();
				}
			}
		}

		a(BREAK_ITEM_COUNT);
	}

	private static void a(Statistic[] var0) {
		a(var0, Blocks.STATIONARY_WATER, Blocks.WATER);
		a(var0, Blocks.STATIONARY_LAVA, Blocks.LAVA);
		a(var0, Blocks.JACK_O_LANTERN, Blocks.PUMPKIN);
		try {
			a(var0, Blocks.BURNING_FURNACE, Blocks.FURNACE);
		} catch (NoSuchFieldError ex) {
			ex.printStackTrace();
		}
		a(var0, Blocks.GLOWING_REDSTONE_ORE, Blocks.REDSTONE_ORE);
		a(var0, Blocks.DIODE_ON, Blocks.DIODE_OFF);
		a(var0, Blocks.REDSTONE_COMPARATOR_ON, Blocks.REDSTONE_COMPARATOR_OFF);
		a(var0, Blocks.REDSTONE_TORCH_ON, Blocks.REDSTONE_TORCH_OFF);
		a(var0, Blocks.REDSTONE_LAMP_ON, Blocks.REDSTONE_LAMP_OFF);
		a(var0, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM);
		a(var0, Blocks.DOUBLE_STEP, Blocks.STEP);
		a(var0, Blocks.WOOD_DOUBLE_STEP, Blocks.WOOD_STEP);
		a(var0, Blocks.GRASS, Blocks.DIRT);
		a(var0, Blocks.SOIL, Blocks.DIRT);
	}

	private static void a(Statistic[] var0, Block var1, Block var2) {
		int var3 = Block.getId(var1);
		int var4 = Block.getId(var2);
		if(var0[var3] != null && var0[var4] == null) {
			var0[var4] = var0[var3];
		} else {
			stats.remove(var0[var3]);
			e.remove(var0[var3]);
			c.remove(var0[var3]);
			var0[var3] = var0[var4];
		}
	}

	public static Statistic a(MonsterEggInfo var0) {
		String var1 = EntityTypes.b(var0.a);
		return var1 == null?null:(new Statistic("stat.killEntity." + var1, new ChatMessage("stat.entityKill", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
	}

	public static Statistic b(MonsterEggInfo var0) {
		String var1 = EntityTypes.b(var0.a);
		return var1 == null?null:(new Statistic("stat.entityKilledBy." + var1, new ChatMessage("stat.entityKilledBy", new Object[]{new ChatMessage("entity." + var1 + ".name", new Object[0])}))).h();
	}

	public static Statistic getStatistic(String var0) {
		return (Statistic)a.get(var0);
	}
}
