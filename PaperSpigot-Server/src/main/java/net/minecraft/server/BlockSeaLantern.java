package net.minecraft.server;


public class BlockSeaLantern extends Block
{
	public BlockSeaLantern(Material materialIn)
	{
		super(materialIn);
		this.a(CreativeModeTab.b);
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 */
	public MaterialMapColor f(int meta)
	{
		return MaterialMapColor.p;
	}

	protected boolean E()
	{
		return true;
	}
}
