//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.Sets;

import java.util.Set;

public class ItemAxe extends ItemTool {
	public static final Set<Block> c;

	protected ItemAxe(EnumToolMaterial var1) {
		super(3.0F, var1, c);
	}

	public float getDestroySpeed(ItemStack var1, Block var2) {
		return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT && var2.getMaterial() != Material.REPLACEABLE_PLANT?super.getDestroySpeed(var1, var2):this.a;
	}

	static {
		c = Sets.newHashSet(new Block[]{Blocks.WOOD, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.JACK_O_LANTERN});
	}
}
