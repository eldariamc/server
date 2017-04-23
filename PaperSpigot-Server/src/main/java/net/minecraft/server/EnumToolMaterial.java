//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public enum EnumToolMaterial {
	WOOD(0, 59, 2.0F, 0.0F, 15),
	STONE(1, 131, 4.0F, 1.0F, 5),
	IRON(2, 250, 6.0F, 2.0F, 14),
	DIAMOND(3, 1561, 8.0F, 3.0F, 10),
	GOLD(0, 32, 12.0F, 0.0F, 22),
	ZINC(3, 2099, 10.0F, 3.5F, 10),
	CRONYXE(3, 2699, 11.0F, 4.25F, 12),
	KOBALT(3, 2999, 12.0F, 5.0F, 16),
	ELDARIUM(3, 3299, 14.0F, 6.5F, 25);

	private final int f;
	private final int g;
	private final float h;
	private final float i;
	private final int j;

	EnumToolMaterial(int var3, int var4, float var5, float var6, int var7) {
		this.f = var3;
		this.g = var4;
		this.h = var5;
		this.i = var6;
		this.j = var7;
	}

	public int a() {
		return this.g;
	}

	public float b() {
		return this.h;
	}

	public float c() {
		return this.i;
	}

	public int d() {
		return this.f;
	}

	public int e() {
		return this.j;
	}

	public Item f() {
		if (this == WOOD)
			return Item.getItemOf(Blocks.WOOD);
		if (this == STONE)
			return Item.getItemOf(Blocks.COBBLESTONE);
		if (this == GOLD)
			return Items.GOLD_INGOT;
		if (this == IRON)
			return Items.GOLD_INGOT;
		if (this == DIAMOND)
			return Items.DIAMOND;
		if (this == ZINC)
			return Items.ZINC;
		if (this == CRONYXE)
			return Items.CRONYXE;
		if (this == KOBALT)
			return Items.KOBALT;
		if (this == ELDARIUM)
			return Items.ELDARIUM;

		return null;
		//return this == WOOD?Item.getItemOf(Blocks.WOOD):(this == STONE?Item.getItemOf(Blocks.COBBLESTONE):(this == GOLD?Items.GOLD_INGOT:(this == IRON?Items.IRON_INGOT:(this == DIAMOND?Items.DIAMOND:null))));
	}

	public String getMaterialName() {
		StringBuilder sb = new StringBuilder(name());
		for (int i = 1; i < sb.length(); i++)
			sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
		return sb.toString();
	}
}
