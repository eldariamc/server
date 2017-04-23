//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public class ItemArmor extends Item {
	private static final int[] m = new int[]{11, 16, 15, 13};
	private static final String[] n = new String[]{"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};
	public static final String[] a = new String[]{"empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots"};
	private static final IDispenseBehavior o = new DispenseBehaviorArmor();
	public final int b;
	public final float c;
	public final int d;
	private final EnumArmorMaterial p;

	public static int[] e() {
		return m;
	}

	public ItemArmor(EnumArmorMaterial var1, int var2, int var3) {
		this.p = var1;
		this.b = var3;
		this.d = var2;
		this.c = var1.b(var3);
		this.setMaxDurability(var1.a(var3));
		this.maxStackSize = 1;
		this.a(CreativeModeTab.j);
		BlockDispenser.a.a(this, o);
	}

	public int c() {
		return this.p.a();
	}

	public EnumArmorMaterial m_() {
		return this.p;
	}

	public boolean c_(ItemStack var1) {
		return this.p != EnumArmorMaterial.CLOTH?false:(!var1.hasTag()?false:(!var1.getTag().hasKeyOfType("display", 10)?false:var1.getTag().getCompound("display").hasKeyOfType("color", 3)));
	}

	public int b(ItemStack var1) {
		if(this.p != EnumArmorMaterial.CLOTH) {
			return -1;
		} else {
			NBTTagCompound var2 = var1.getTag();
			if(var2 == null) {
				return 10511680;
			} else {
				NBTTagCompound var3 = var2.getCompound("display");
				return var3 == null?10511680:(var3.hasKeyOfType("color", 3)?var3.getInt("color"):10511680);
			}
		}
	}

	public void c(ItemStack var1) {
		if(this.p == EnumArmorMaterial.CLOTH) {
			NBTTagCompound var2 = var1.getTag();
			if(var2 != null) {
				NBTTagCompound var3 = var2.getCompound("display");
				if(var3.hasKey("color")) {
					var3.remove("color");
				}

			}
		}
	}

	public void b(ItemStack var1, int var2) {
		if(this.p != EnumArmorMaterial.CLOTH) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTTagCompound var3 = var1.getTag();
			if(var3 == null) {
				var3 = new NBTTagCompound();
				var1.setTag(var3);
			}

			NBTTagCompound var4 = var3.getCompound("display");
			if(!var3.hasKeyOfType("display", 10)) {
				var3.set("display", var4);
			}

			var4.setInt("color", var2);
		}
	}

	public boolean a(ItemStack var1, ItemStack var2) {
		return this.p.b() == var2.getItem()?true:super.a(var1, var2);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		int var4 = EntityInsentient.b(var1) - 1;
		ItemStack var5 = var3.r(var4);
		if(var5 == null) {
			var3.setEquipment(var4, var1.cloneItemStack());
			var1.count = 0;
		}

		return var1;
	}
}
