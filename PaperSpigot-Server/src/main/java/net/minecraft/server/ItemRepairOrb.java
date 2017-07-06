package net.minecraft.server;

/**
 * Created by David on 10/12/2016.
 */
public class ItemRepairOrb extends Item {

	private boolean isFullRepair;

	public ItemRepairOrb(boolean isFullRepair) {
		this.e(1);
		this.isFullRepair = isFullRepair;
	}

	@Override
	public ItemStack a(ItemStack itemStack, World world, EntityHuman player) {
		/*if (!player.abilities.canInstantlyBuild)
			itemStack.count--;

		world.makeSound(player, "block.enchantment_table.use", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));

		if (!world.isStatic) {
			repair(player.inventory.armor);
			if (isFullRepair)
				repair(player.inventory.items);
		}*/

		return itemStack;
	}

	private static void repair(ItemStack[] inventory) {
		for (ItemStack itemStack : inventory)
			if (itemStack != null && itemStack.l() > 0)
				itemStack.setData(0);
	}
}
