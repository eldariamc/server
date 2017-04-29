package net.minecraft.server;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by David on 29/04/2017.
 */
public class ItemGlobalTool extends ItemTool {

	public ItemGlobalTool(EnumToolMaterial material) {
		super(3.0F, material, getProperBlocks());
	}

	public float getDestroySpeed(ItemStack var1, Block var2) {
		return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT
				&& var2.getMaterial() != Material.REPLACEABLE_PLANT && var2.getMaterial() != Material.ORE &&
				var2.getMaterial() != Material.HEAVY && var2.getMaterial() != Material.STONE
				? super.getDestroySpeed(var1, var2)
				: this.a;
	}

	public boolean canDestroySpecialBlock(Block var1) {
		return var1 == Blocks.SNOW || var1 == Blocks.SNOW_BLOCK || canPickaxe(var1);
	}

	private static Set<Block> getProperBlocks() {
		Set<Block> properBlocks = Sets.newHashSet();
		properBlocks.addAll(ItemAxe.c);
		properBlocks.addAll(ItemPickaxe.c);
		properBlocks.addAll(ItemSpade.c);
		return properBlocks;
	}
}
