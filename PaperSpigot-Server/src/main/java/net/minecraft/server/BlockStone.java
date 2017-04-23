//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.util.Random;

public class BlockStone extends Block {

	public static final String[] TYPES = new String[]{"stone", "granite", "smooth_granite", "diorite", "smooth_diorite", "andesite", "smooth_andesite"};
	public static final String[] NAMES = new String[]{"stone", "granite", "graniteSmooth", "diorite", "dioriteSmooth", "andesite", "andesiteSmooth"};

	public BlockStone() {
		super(Material.STONE);
		this.a(CreativeModeTab.b);
	}

	public Item getDropType(int var1, Random var2, int var3) {
		return var1 == 0 ? Item.getItemOf(Blocks.COBBLESTONE) : Item.getItemOf(Blocks.STONE);
	}

	@Override
	public int getDropData(int i) {
		return i;
	}

	@Override
	public MaterialMapColor f(int i) {
		switch (i) {
			case 0:
			case 5:
			case 6:
				return MaterialMapColor.m;
			case 1:
			case 2:
				return MaterialMapColor.l;
			case 3:
			case 4:
				return MaterialMapColor.p;
		}
		return super.f(i);
	}


}
