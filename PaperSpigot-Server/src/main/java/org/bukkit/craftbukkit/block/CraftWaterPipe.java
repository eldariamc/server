package org.bukkit.craftbukkit.block;


import net.minecraft.server.TileEntityWaterPipe;
import org.bukkit.block.Block;
import org.bukkit.block.WaterPipe;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftInventoryWaterPipe;
import org.bukkit.inventory.WaterPipeInventory;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by David on 03/09/2016.
 */
public class CraftWaterPipe extends CraftBlockState implements WaterPipe {

	private final TileEntityWaterPipe waterPipe;

	public CraftWaterPipe(final Block block) {
		super(block);

		waterPipe = (TileEntityWaterPipe) ((CraftWorld) block.getWorld()).getTileEntityAt(getX(), getY(), getZ());
	}

	@Override
	public int getUsages() {
		return waterPipe.getSmokeTime();
	}

	@Override
	public void setUsages(int usages) {
		waterPipe.setSmokeTime(usages);
	}

	@Override
	public PotionEffectType getActiveEffect() {
		return PotionEffectType.getById(waterPipe.getPotionId());
	}

	@Override
	public void setActiveEffect(PotionEffectType activeEffect) {
		waterPipe.setPotionId(activeEffect.getId());
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		boolean result = super.update(force, applyPhysics);

		if (result) {
			waterPipe.update();
		}

		return result;
	}

	@Override
	public WaterPipeInventory getInventory() {
		return new CraftInventoryWaterPipe(waterPipe);
	}
}
