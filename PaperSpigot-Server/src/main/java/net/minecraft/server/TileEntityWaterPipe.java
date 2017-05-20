package net.minecraft.server;


import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;

import java.util.List;

/**
 * Created by David on 27/06/2016.
 */
public class TileEntityWaterPipe extends TileEntity implements IWorldInventory {

	private static final int[] topSlot = new int[]{0};
	private static final int[] sideSlot = new int[]{1};
	private ItemStack[] inventory = new ItemStack[2];
	private String name;
	private int smokeTime = 0;
	private int potionId;
	private byte rotation;

	public List<HumanEntity> transaction = new java.util.ArrayList<HumanEntity>();

	/**
	 * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
	 * block.
	 *
	 * @param side
	 */
	@Override
	public int[] getSlotsForFace(int side) {
		return side == 1 ? topSlot : sideSlot;
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
	 * side
	 *
	 * @param slot
	 * @param item
	 * @param side
	 */
	@Override
	public boolean canPlaceItemThroughFace(int slot, ItemStack item, int side) {
		return this.b(slot, item);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
	 * side
	 *
	 * @param p_102008_1_
	 * @param p_102008_2_
	 * @param p_102008_3_
	 */
	@Override
	public boolean canTakeItemThroughFace(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return false;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSize() {
		return inventory.length;
	}

	/**
	 * Returns the stack in slot i
	 *
	 * @param i
	 */
	@Override
	public ItemStack getItem(int i) {
		return i >= 0 && i < inventory.length ? inventory[i] : null;
	}

	/**
	 * Removes from an inventory slot (first arg) up to setFlag specified number (second arg) of items and returns them in setFlag
	 * new stack.
	 *
	 * @param p_70298_1_
	 * @param p_70298_2_
	 */
	@Override
	public ItemStack splitStack(int p_70298_1_, int p_70298_2_) {
		if (this.inventory[p_70298_1_] != null)
		{
			ItemStack var3;

			if (this.inventory[p_70298_1_].count <= p_70298_2_)
			{
				var3 = this.inventory[p_70298_1_];
				this.inventory[p_70298_1_] = null;
				return var3;
			}
			else
			{
				var3 = this.inventory[p_70298_1_].a(p_70298_2_);

				if (this.inventory[p_70298_1_].count == 0)
				{
					this.inventory[p_70298_1_] = null;
				}

				return var3;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close setFlag workbench GUI.
	 *
	 * @param p_70304_1_
	 */
	@Override
	public ItemStack splitWithoutUpdate(int p_70304_1_) {
		if (p_70304_1_ >= 0 && p_70304_1_ < this.inventory.length)
		{
			ItemStack var2 = this.inventory[p_70304_1_];
			this.inventory[p_70304_1_] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 *
	 * @param p_70299_1_
	 * @param p_70299_2_
	 */
	@Override
	public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
		if (p_70299_1_ >= 0 && p_70299_1_ < this.inventory.length)
		{
			this.inventory[p_70299_1_] = p_70299_2_;
		}
	}

	/**
	 * Returns the name of the inventory
	 */
	@Override
	public String getInventoryName() {
		return this.k_() ? this.name : "container.smoking";
	}

	public void setInventoryName(String name) {
		this.name = name;
	}

	/**
	 * Returns if the inventory name is localized
	 */
	@Override
	public boolean k_() {
		return this.name != null && this.name.length() > 0;
	}

	/**
	 * Returns the maximum stack size for setFlag inventory slot.
	 */
	@Override
	public int getMaxStackSize() {
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 *
	 * @param entityhuman
	 */
	@Override
	public boolean a(EntityHuman entityhuman) {
		return this.world.getTileEntity(this.x, this.y, this.z) == this && entityhuman.e((double) this.x + 0.5D, (double) this.y + 0.5D, (double) this.z + 0.5D) <= 64.0D;
	}

	@Override
	public void startOpen() {}

	@Override
	public void closeContainer() {}

	@Override
	public ItemStack[] getContents() {
		return inventory;
	}

	@Override
	public void onOpen(CraftHumanEntity who) {
		transaction.add(who);
	}

	@Override
	public void onClose(CraftHumanEntity who) {
		transaction.remove(who);
	}

	@Override
	public List<HumanEntity> getViewers() {
		return transaction;
	}

	@Override
	public void setMaxStackSize(int size) {

	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 *
	 * @param slot
	 * @param item
	 */
	@Override
	// isItemValidForSlot
	public boolean b(int slot, ItemStack item) {
		return slot == 0 ? item.getItem() == Items.COAL : item.getItem().m(item);
	}

	@Override
	public Packet getUpdatePacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
		b(tagCompound);
		return new PacketPlayOutTileEntityData(x, y, z, 6, tagCompound);
	}

	public void a(NBTTagCompound tagCompound)
	{
		super.a(tagCompound);
		NBTTagList tagList = tagCompound.getList("Inventory", 10);

		for (int i = 0; i < tagList.size(); ++i) {
			NBTTagCompound tag = tagList.get(i);
			byte slot = tag.getByte("Slot");

			if (slot >= 0 && slot < this.inventory.length) {
				this.inventory[slot] = ItemStack.createStack(tag);
			}
		}

		this.rotation = tagCompound.getByte("Rotation");
		this.smokeTime = tagCompound.getShort("SmokeTime");
		this.potionId = tagCompound.getByte("PotionId");

		if (tagCompound.hasKeyOfType("CustomName", 8))
		{
			this.name = tagCompound.getString("CustomName");
		}
	}

	public void b(NBTTagCompound tagCompound)
	{
		super.b(tagCompound);
		tagCompound.setByte("Rotation", this.rotation);
		tagCompound.setShort("SmokeTime", (short) this.smokeTime);
		tagCompound.setByte("PotionId", (byte) this.potionId);
		NBTTagList itemList = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i) {
			ItemStack stack = this.inventory[i];

			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();

				tag.setByte("Slot", (byte) i);
				stack.save(tag);
				itemList.add(tag);
			}
		}

		tagCompound.set("Inventory", itemList);

		if (this.k_())
		{
			tagCompound.setString("CustomName", this.name);
		}
	}

	public int getSmokeTime() {
		return smokeTime;
	}

	public void setSmokeTime(int smokeTime) {
		this.smokeTime = smokeTime;
	}

	public int getPotionId() {
		return potionId;
	}

	public void setPotionId(int potionId) {
		this.potionId = potionId;
	}

	public void setRotation(byte rotation) {
		this.rotation = rotation;
	}

	@Override
	// updateEntity()
	public void h() {
		super.h();
		if (!world.isStatic && smokeTime == 0 && inventory[0] != null && inventory[0].getItem() == Items.COAL
				&& inventory[1] != null) {
			Item item = inventory[1].getItem();
			if (item == Items.SUGAR)
				potionId = 1;
			else if (item == Items.BLAZE_POWDER)
				potionId = 5;
			else if (item == Items.SPECKLED_MELON)
				potionId = 6;
			else if (item == Items.SLIME_BALL)
				potionId = 8;
			else if (item == Items.GHAST_TEAR)
				potionId = 10;
			else if (item == Items.MAGMA_CREAM)
				potionId = 12;
			else if (item == Items.RAW_FISH && EnumFish.a(inventory[1]) == EnumFish.PUFFERFISH)
				potionId = 13;
			else if (item == Items.CARROT_GOLDEN)
				potionId = 16;
			else if (item == Items.FERMENTED_SPIDER_EYE)
				potionId = 18;
			else if (item == Items.SPIDER_EYE)
				potionId = 19;
			else
				return;
			splitStack(0, 1);
			splitStack(1, 1);
			smokeTime = 5;
			this.world.notify(x, y, z);
		}
	}

	public boolean activate(EntityHuman player) {
		if (smokeTime > 0) {
			player.addEffect(new MobEffect(MobEffectList.CONFUSION.id, 300, 0));
			if(MobEffectList.byId[potionId].isInstant()) {
				MobEffectList.byId[potionId].applyInstantEffect(null, player, 1, 1.0);
			} else {
				player.addEffect(new MobEffect(potionId, 9600, 1));
			}
			this.world.makeSound(player, "random.drink", 5.0F, this.world.random.nextFloat() * 0.1F + 0.9F);
			smokeTime--;
			this.world.notify(x, y, z);
			return false;
		}
		return true;
	}
}
