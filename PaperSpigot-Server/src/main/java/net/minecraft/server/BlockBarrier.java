package net.minecraft.server;

/**
 * Created by David on 05/04/2017.
 */
public class BlockBarrier extends Block {
	protected BlockBarrier() {
		super(Material.BARRIER);
	}

	public int b() {
		return -1;
	}

	public AxisAlignedBB a(World var1, int var2, int var3, int var4) {
		return super.a(var1, var2, var3, var4);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void dropNaturally(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
	}
}