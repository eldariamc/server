package net.minecraft.server;

import org.bukkit.craftbukkit.inventory.CraftInventoryView;
import org.bukkit.craftbukkit.inventory.CraftInventoryWaterPipe;

/**
 * Created by David on 28/06/2016.
 */
public class ContainerWaterPipe extends Container {

	private TileEntityWaterPipe waterPipe;

	public ContainerWaterPipe(PlayerInventory inventoryPlayer, TileEntityWaterPipe waterPipe) {
		this.waterPipe = waterPipe;
		this.player = inventoryPlayer;
		this.a(new Slot(waterPipe, 0, 70, 9){
			@Override
			public boolean isAllowed(ItemStack itemstack) {
				return itemstack != null && itemstack.getItem() == Items.LIT_COAL;
			}
		});
		this.a(new SlotBrewing(null, waterPipe, 1, 66, 31));

		int var3;
		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				this.a(new Slot(inventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			this.a(new Slot(inventoryPlayer, var3, 8 + var3 * 18, 142));
		}
	}

	// CraftBukkit start
	private CraftInventoryView bukkitEntity = null;
	private PlayerInventory player;

	public CraftInventoryView getBukkitView() {
		if (bukkitEntity != null) {
			return bukkitEntity;
		}

		CraftInventoryWaterPipe inventory = new CraftInventoryWaterPipe(this.waterPipe);
		bukkitEntity = new CraftInventoryView(this.player.player.getBukkitEntity(), inventory, this);
		return bukkitEntity;
	}
	// CraftBukkit end

	@Override
	public boolean a(EntityHuman entityhuman) {
		return this.waterPipe.a(entityhuman);
	}

	/**
	 * Called when a player shift-clicks on registerRecipe slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack b(EntityHuman p_82846_1_, int p_82846_2_)
	{
		ItemStack var3 = null;
		Slot var4 = this.getSlot(p_82846_2_);

		if (var4 != null && var4.hasItem())
		{
			ItemStack var5 = var4.getItem();
			var3 = var5.cloneItemStack();

			if (p_82846_2_ < this.waterPipe.getSize())
			{
				if (!this.a(var5, this.waterPipe.getSize(), this.c.size(), true))
				{
					return null;
				}
			}
			else if (!this.a(var5, 0, this.waterPipe.getSize(), false))
			{
				return null;
			}

			if (var5.count == 0)
			{
				var4.set(null);
			}
			else
			{
				var4.f();
			}
		}

		return var3;
	}

	protected void a(int i, int j, boolean flag, EntityHuman entityhuman) {}
}
