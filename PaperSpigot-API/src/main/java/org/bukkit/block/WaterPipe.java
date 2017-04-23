package org.bukkit.block;

import org.bukkit.inventory.WaterPipeInventory;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by David on 03/09/2016.
 */
public interface WaterPipe extends BlockState, ContainerBlock {

	int getUsages();

	void setUsages(int usages);

	PotionEffectType getActiveEffect();

	void setActiveEffect(PotionEffectType activeEffect);

	WaterPipeInventory getInventory();

}
