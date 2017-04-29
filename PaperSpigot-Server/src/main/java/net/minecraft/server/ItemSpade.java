//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import net.minecraft.util.com.google.common.collect.Sets;

import java.util.Set;

public class ItemSpade extends ItemTool {
	public static final Set<Block> c;

	public ItemSpade(EnumToolMaterial var1) {
		super(1.0F, var1, c);
	}

	public boolean canDestroySpecialBlock(Block var1) {
		return var1 == Blocks.SNOW || var1 == Blocks.SNOW_BLOCK;
	}

	static {
		c = Sets.newHashSet(new Block[]{Blocks.GRASS, Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.CLAY, Blocks.SOIL, Blocks.SOUL_SAND, Blocks.MYCEL});
	}
}
