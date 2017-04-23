package org.bukkit.inventory;

import org.bukkit.block.WaterPipe;

/**
 * Created by David on 03/09/2016.
 */
public interface WaterPipeInventory extends Inventory {

	ItemStack getCoal();

	ItemStack getIngredient();

	void setCoal(ItemStack coal);

	void setIngredient(ItemStack ingredient);

	WaterPipe getHolder();

}
