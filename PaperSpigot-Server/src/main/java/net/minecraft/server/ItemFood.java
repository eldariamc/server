//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public class ItemFood extends Item {
	public final int a;
	private final int b;
	private final float c;
	private final boolean d;
	private boolean m;
	private int n;
	private int o;
	private int p;
	private float q;

	public ItemFood(int var1, float var2, boolean var3) {
		this.a = 32;
		this.b = var1;
		this.d = var3;
		this.c = var2;
		this.a(CreativeModeTab.h);
	}

	public ItemFood(int var1, boolean var2) {
		this(var1, 0.6F, var2);
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		--var1.count;
		var3.getFoodData().a(this, var1);
		var2.makeSound(var3, "random.burp", 0.5F, var2.random.nextFloat() * 0.1F + 0.9F);
		this.c(var1, var2, var3);
		return var1;
	}

	protected void c(ItemStack var1, World var2, EntityHuman var3) {
		if(!var2.isStatic && this.n > 0 && var2.random.nextFloat() < this.q) {
			var3.addEffect(new MobEffect(this.n, this.o * 20, this.p));
		}

	}

	public int d_(ItemStack var1) {
		return 32;
	}

	public EnumAnimation d(ItemStack var1) {
		return EnumAnimation.EAT;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if(var3.g(this.m)) {
			var3.a(var1, this.d_(var1));
		}

		return var1;
	}

	public int getNutrition(ItemStack var1) {
		return this.b;
	}

	public float getSaturationModifier(ItemStack var1) {
		return this.c;
	}

	public boolean i() {
		return this.d;
	}

	public ItemFood a(int var1, int var2, int var3, float var4) {
		this.n = var1;
		this.o = var2;
		this.p = var3;
		this.q = var4;
		return this;
	}

	public ItemFood j() {
		this.m = true;
		return this;
	}
}
