package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.TileEntityWaterPipe;
import org.bukkit.block.WaterPipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.WaterPipeInventory;

/**
 * Created by David on 03/09/2016.
 */
public class CraftInventoryWaterPipe extends CraftInventory implements WaterPipeInventory {
	public CraftInventoryWaterPipe(TileEntityWaterPipe inventory) {
		super(inventory);
	}

	@Override
	public ItemStack getCoal() {
		return getItem(0);
	}

	@Override
	public ItemStack getIngredient() {
		return getItem(1);
	}

	@Override
	public void setCoal(ItemStack coal) {
		setItem(0, coal);
	}

	@Override
	public void setIngredient(ItemStack ingredient) {
		setItem(1, ingredient);
	}

	public WaterPipe getHolder() {
		return (WaterPipe) inventory.getOwner();
	}
}
