//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class EntityTypes {
	private static final Logger b = LogManager.getLogger();
	private static Map c = new HashMap();
	private static Map d = new HashMap();
	private static Map e = new HashMap();
	private static Map f = new HashMap();
	private static Map g = new HashMap();
	public static HashMap eggInfo = new LinkedHashMap();

	private static void a(Class var0, String var1, int var2) {
		if(c.containsKey(var1)) {
			throw new IllegalArgumentException("ID is already registered: " + var1);
		} else if(e.containsKey(Integer.valueOf(var2))) {
			throw new IllegalArgumentException("ID is already registered: " + var2);
		} else {
			c.put(var1, var0);
			d.put(var0, var1);
			e.put(Integer.valueOf(var2), var0);
			f.put(var0, Integer.valueOf(var2));
			g.put(var1, Integer.valueOf(var2));
		}
	}

	private static void a(Class var0, String var1, int var2, int var3, int var4) {
		a(var0, var1, var2);
		eggInfo.put(Integer.valueOf(var2), new MonsterEggInfo(var2, var3, var4));
	}

	public static Entity createEntityByName(String var0, World var1) {
		Entity var2 = null;

		try {
			Class var3 = (Class)c.get(var0);
			if(var3 != null) {
				var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	public static Entity a(NBTTagCompound var0, World var1) {
		Entity var2 = null;
		if("Minecart".equals(var0.getString("id"))) {
			switch(var0.getInt("Type")) {
				case 0:
					var0.setString("id", "MinecartRideable");
					break;
				case 1:
					var0.setString("id", "MinecartChest");
					break;
				case 2:
					var0.setString("id", "MinecartFurnace");
			}

			var0.remove("Type");
		}

		try {
			Class var3 = (Class)c.get(var0.getString("id"));
			if(var3 != null) {
				var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if(var2 != null) {
			var2.f(var0);
		} else {
			b.warn("Skipping Entity with id " + var0.getString("id"));
		}

		return var2;
	}

	public static Entity a(int var0, World var1) {
		Entity var2 = null;

		try {
			Class var3 = a(var0);
			if(var3 != null) {
				var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if(var2 == null) {
			b.warn("Skipping Entity with id " + var0);
		}

		return var2;
	}

	public static int a(Entity var0) {
		Class var1 = var0.getClass();
		return f.containsKey(var1)?((Integer)f.get(var1)).intValue():0;
	}

	public static Class a(int var0) {
		return (Class)e.get(Integer.valueOf(var0));
	}

	public static String b(Entity var0) {
		return (String)d.get(var0.getClass());
	}

	public static String b(int var0) {
		Class var1 = a(var0);
		return var1 != null?(String)d.get(var1):null;
	}

	public static void a() {
	}

	public static Set b() {
		return Collections.unmodifiableSet(g.keySet());
	}

	static {
		a(EntityItem.class, "Item", 1);
		a(EntityExperienceOrb.class, "XPOrb", 2);
		a(EntityLeash.class, "LeashKnot", 8);
		a(EntityPainting.class, "Painting", 9);
		a(EntityArrow.class, "Arrow", 10);
		a(EntitySnowball.class, "Snowball", 11);
		a(EntityLargeFireball.class, "Fireball", 12);
		a(EntitySmallFireball.class, "SmallFireball", 13);
		a(EntityEnderPearl.class, "ThrownEnderpearl", 14);
		a(EntityEnderSignal.class, "EyeOfEnderSignal", 15);
		a(EntityPotion.class, "ThrownPotion", 16);
		a(EntityThrownExpBottle.class, "ThrownExpBottle", 17);
		a(EntityItemFrame.class, "ItemFrame", 18);
		a(EntityWitherSkull.class, "WitherSkull", 19);
		a(EntityTNTPrimed.class, "PrimedTnt", 20);
		a(EntityFallingBlock.class, "FallingSand", 21);
		a(EntityFireworks.class, "FireworksRocketEntity", 22);
		a(EntityDynamite.class, "Dynamite", 23);                   // Keyrisium - Register dynamite entity
		a(EntityC4.class, "C4", 24);                               // Keyrisium - Register c4 entity
		a(EntityTomahawk.class, "Tomahawk", 25);                   // Keyrisium - Register tomahawk entity
		a(EntityBoat.class, "Boat", 41);
		a(EntityMinecartRideable.class, "MinecartRideable", 42);
		a(EntityMinecartChest.class, "MinecartChest", 43);
		a(EntityMinecartFurnace.class, "MinecartFurnace", 44);
		a(EntityMinecartTNT.class, "MinecartTNT", 45);
		a(EntityMinecartHopper.class, "MinecartHopper", 46);
		a(EntityMinecartMobSpawner.class, "MinecartSpawner", 47);
		a(EntityMinecartCommandBlock.class, "MinecartCommandBlock", 40);
		a(EntityInsentient.class, "Mob", 48);
		a(EntityMonster.class, "Monster", 49);
		a(EntityCreeper.class, "Creeper", 50, 894731, 0);
		a(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
		a(EntitySpider.class, "Spider", 52, 3419431, 11013646);
		a(EntityGiantZombie.class, "Giant", 53);
		a(EntityZombie.class, "Zombie", 54, '꾯', 7969893);
		a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
		a(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
		a(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
		a(EntityEnderman.class, "Enderman", 58, 1447446, 0);
		a(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
		a(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
		a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
		a(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
		a(EntityEnderDragon.class, "EnderDragon", 63);
		a(EntityWither.class, "WitherBoss", 64);
		a(EntityBat.class, "Bat", 65, 4996656, 986895);
		a(EntityWitch.class, "Witch", 66, 3407872, 5349438);
		a(EntityPig.class, "Pig", 90, 15771042, 14377823);
		a(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
		a(EntityCow.class, "Cow", 92, 4470310, 10592673);
		a(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
		a(EntitySquid.class, "Squid", 94, 2243405, 7375001);
		a(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
		a(EntityMushroomCow.class, "MushroomCow", 96, 10489616, 12040119);
		a(EntitySnowman.class, "SnowMan", 97);
		a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
		a(EntityIronGolem.class, "VillagerGolem", 99);
		a(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
		a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
		a(EntityEnderCrystal.class, "EnderCrystal", 200);
	}
}
