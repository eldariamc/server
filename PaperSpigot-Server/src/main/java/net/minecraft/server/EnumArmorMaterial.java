//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public enum EnumArmorMaterial {
	CLOTH(5, new float[]{3, 5, 4, 3}, 15),
	CHAIN(15, new float[]{4, 8, 6, 3}, 12),
	IRON(15, new float[]{5, 9, 7, 5}, 9),
	GOLD(7, new float[]{5, 8, 6, 4}, 25),
	DIAMOND(33, new float[]{6, 12, 8, 6}, 10),
	ZINC(65, new float[]{7, 14, 9, 7}, 10),
	CRONYXE(80, new float[]{7.5f, 14.75f, 10.75f, 7.5f}, 14),
	KOBALT(90, new float[]{8, 16, 12, 8}, 18),
	ELDARIUM(110, new float[]{8.5f, 16.5f, 12.5f, 8.5f}, 28);

	private int f;
	private float[] g;
	private int h;

	private EnumArmorMaterial(int var3, float[] var4, int var5) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
	}

	public int a(int var1) {
		return ItemArmor.e()[var1] * this.f;
	}

	public float b(int var1) {
		return this.g[var1];
	}

	public int a() {
		return this.h;
	}

	public Item b() {
		switch (this) {
			case CLOTH:
				return Items.LEATHER;
			case CHAIN:
				return Items.IRON_INGOT;
			case GOLD:
				return Items.GOLD_INGOT;
			case IRON:
				return Items.IRON_INGOT;
			case DIAMOND:
				return Items.DIAMOND;
			case ZINC:
				return Items.ZINC;
			case CRONYXE:
				return Items.CRONYXE;
			case KOBALT:
				return Items.KOBALT;
			case ELDARIUM:
				return Items.ELDARIUM;
			default:
				return null;
		}
		//return this == CLOTH?Items.LEATHER:(this == CHAIN?Items.IRON_INGOT:(this == GOLD?Items.GOLD_INGOT:(this == IRON?Items.IRON_INGOT:(this == DIAMOND?Items.DIAMOND:null))));
	}

	public String getMaterialName() {
		StringBuilder sb = new StringBuilder(name());
		for (int i = 1; i < sb.length(); i++)
			sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
		return sb.toString();
	}
}
