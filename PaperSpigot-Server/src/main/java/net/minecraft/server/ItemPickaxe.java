//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.Sets;

import java.util.Set;

public class ItemPickaxe extends ItemTool {
	private static final Set c;

	protected ItemPickaxe(EnumToolMaterial var1) {
		super(2.0F, var1, c);
	}

	public boolean canDestroySpecialBlock(Block block) {
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
		if (block == Blocks.ELDARIUM_ORE || block == Blocks.GEMME_ORE)
			return this.b.d() >= 3;
		if (block.getMaterial() == Material.STONE || block.getMaterial() == Material.BRICK)
			return true;
		if (block.getMaterial() == Material.ORE)
			return true;
		if (block == Blocks.ANVIL)
			return this.b.d() >= 1;

		return false;
		
		//return block == Blocks.OBSIDIAN?this.b.d() == 3:(block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE?(block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK?(block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE?(block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE?(block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE?(block != Blocks.REDSTONE_ORE && block != Blocks.GLOWING_REDSTONE_ORE?(block.getMaterial() == Material.STONE?true:(block.getMaterial() == Material.ORE?true:block.getMaterial() == Material.HEAVY)):this.b.d() >= 2):this.b.d() >= 1):this.b.d() >= 1):this.b.d() >= 2):this.b.d() >= 2):this.b.d() >= 2);
	}

	public float getDestroySpeed(ItemStack var1, Block var2) {
		return var2.getMaterial() != Material.ORE && var2.getMaterial() != Material.HEAVY && var2.getMaterial() != Material.STONE?super.getDestroySpeed(var1, var2):this.a;
	}

	static {
		c = Sets.newHashSet(new Block[]{Blocks.COBBLESTONE, Blocks.DOUBLE_STEP, Blocks.STEP, Blocks.STONE, Blocks.SANDSTONE, Blocks.MOSSY_COBBLESTONE, Blocks.IRON_ORE, Blocks.IRON_BLOCK, Blocks.COAL_ORE, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.DIAMOND_BLOCK, Blocks.ICE, Blocks.NETHERRACK, Blocks.LAPIS_ORE, Blocks.LAPIS_BLOCK, Blocks.REDSTONE_ORE, Blocks.GLOWING_REDSTONE_ORE, Blocks.RAILS, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.ACTIVATOR_RAIL});
	}
}
