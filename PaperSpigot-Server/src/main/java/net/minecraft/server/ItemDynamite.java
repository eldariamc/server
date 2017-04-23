package net.minecraft.server;

/**
 * Created by David on 18/12/2016.
 */
public class ItemDynamite extends Item {

	public ItemDynamite()
	{
		this.maxStackSize = 16;
		this.a(CreativeModeTab.j);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack a(ItemStack itemStack, World world, EntityHuman player)
	{
		if (!player.abilities.canInstantlyBuild)
		{
			--itemStack.count;
		}

		world.makeSound(player, "fire.ignite", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));

		if (!world.isStatic)
		{
			world.addEntity(new EntityDynamite(world, player));
		}

		return itemStack;
	}
}