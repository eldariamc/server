//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.Multimap;

import java.util.Set;

public class ItemTool extends Item {
	private Set c;
	protected float a = 4.0F;
	private float d;
	protected EnumToolMaterial b;

	protected ItemTool(float var1, EnumToolMaterial var2, Set var3) {
		this.b = var2;
		this.c = var3;
		this.maxStackSize = 1;
		this.setMaxDurability(var2.a());
		this.a = var2.b();
		this.d = var1 + var2.c();
		this.a(CreativeModeTab.i);
	}

	public float getDestroySpeed(ItemStack var1, Block var2) {
		return this.c.contains(var2)?this.a:1.0F;
	}

	public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		var1.damage(2, var3);
		return true;
	}

	public boolean a(ItemStack var1, World var2, Block var3, int var4, int var5, int var6, EntityLiving var7) {
		if((double)var3.f(var2, var4, var5, var6) != 0.0D) {
			var1.damage(1, var7);
		}

		return true;
	}

	public EnumToolMaterial i() {
		return this.b;
	}

	public int c() {
		return this.b.e();
	}

	public String j() {
		return this.b.toString();
	}

	public boolean a(ItemStack var1, ItemStack var2) {
		return this.b.f() == var2.getItem()?true:super.a(var1, var2);
	}

	public Multimap k() {
		Multimap var1 = super.k();
		var1.put(GenericAttributes.e.getName(), new AttributeModifier(f, "Tool modifier", (double)this.d, 0));
		return var1;
	}

	protected boolean canPickaxe(Block block) {
		if (block == Blocks.OBSIDIAN || block == Blocks.OBSIDIAN_FURNACE || block == Blocks.BURNING_OBSIDIAN_FURNACE)
			return this.b.d() >= 3;
		if (block == Blocks.DIAMOND_BLOCK || block == Blocks.DIAMOND_ORE)
			return this.b.d() >= 2;
		if (block == Blocks.EMERALD_ORE || block == Blocks.EMERALD_BLOCK)
			return this.b.d() >= 2;
		if (block == Blocks.GOLD_BLOCK || block == Blocks.GOLD_ORE)
			return this.b.d() >= 2;
		if (block == Blocks.IRON_BLOCK || block == Blocks.IRON_ORE)
			return this.b.d() >= 1;
		if (block == Blocks.LAPIS_BLOCK || block == Blocks.LAPIS_ORE)
			return this.b.d() >= 1;
		if (block == Blocks.REDSTONE_ORE || block == Blocks.GLOWING_REDSTONE_ORE)
			return this.b.d() >= 2;
		if (block == Blocks.ZINC_ORE || block == Blocks.KOBALT_ORE || block == Blocks.CRONYXE_ORE)
			return this.b.d() >= 3;
		if (block == Blocks.ELDARIUM_ORE)
			return this.b.d() >= 3;
		if (block.getMaterial() == Material.STONE || block.getMaterial() == Material.BRICK)
			return true;
		if (block.getMaterial() == Material.ORE)
			return true;
		if (block == Blocks.ANVIL)
			return this.b.d() >= 1;

		return false;
	}
}
