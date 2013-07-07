package com.mrcrayfish.furniture;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryPackage extends InventoryBasic 
{
	protected EntityPlayer playerEntity;
	protected ItemStack envelope;
	protected boolean reading = false;
	protected String uniqueID;

	public InventoryPackage(EntityPlayer player, ItemStack is) 
	{
		super("Package", false, getInventorySize(is));

		playerEntity = player;
		envelope = is;
		uniqueID = "";

		if(!hasInventory()) 
		{
			uniqueID = UUID.randomUUID().toString();
			createInventory();
		}
		loadInventory();
	}

	@Override
	public void onInventoryChanged() 
	{
		super.onInventoryChanged();
		if(!reading) 
		{
			saveInventory();
		}
	}

	@Override
	public void openChest() 
	{
		loadInventory();
	}

	@Override
	public void closeChest() 
	{
		saveInventory();
	}

	protected static int getInventorySize(ItemStack is) 
	{
		return 6;
	}

	/**
	 * Returns if an Inventory is saved in the NBT.
	 * 
	 * @return True when the NBT is not null and the NBT has key "Package"
	 *         otherwise false.
	 */
	protected boolean hasInventory() 
	{
		return NBTHelper.hasTag(envelope, "Package");
	}

	/**
	 * Creates the Inventory Tag in the NBT with an empty inventory.
	 */
	protected void createInventory() 
	{
		writeToNBT();
	}


	/**
	 * Searches the backpack in players inventory and saves NBT data in it.
	 */
	protected void setNBT() 
	{
		for(ItemStack itemStack : playerEntity.inventory.mainInventory) 
		{
			if(itemStack != null && itemStack.getItem() instanceof IMail) 
			{
				NBTTagCompound nbt = itemStack.getTagCompound();
				if(nbt != null)
				{
					if(nbt.getCompoundTag("Package").getString("UniqueID") == uniqueID)
					{
						itemStack.setTagCompound(envelope.getTagCompound());
						break;
					}
				}
			}
		}
	}

	/**
	 * If there is no inventory create one. Then load the content and title of
	 * the inventory from the NBT
	 */
	public void loadInventory() 
	{
		readFromNBT(envelope.getTagCompound());
	}

	/**
	 * Saves the actual content of the inventory to the NBT.
	 */
	public void saveInventory() 
	{
		writeToNBT();
		setNBT();
	}

	/**
	 * Writes a NBT Node with inventory.
	 * 
	 * @param outerTag
	 *            The NBT Node to write to.
	 * @return The written NBT Node.
	 */

	protected void readFromNBT(NBTTagCompound compound) 
	{
		reading = true;
		NBTTagCompound nbt = NBTHelper.getCompoundTag(envelope, "Package");
		if("".equals(uniqueID))
		{
			uniqueID = nbt.getString("UniqueID");
			if("".equals(uniqueID))
			{
				uniqueID = UUID.randomUUID().toString();
			}
		}	
		NBTTagList itemList = NBTHelper.getCompoundTag(envelope, "Package").getTagList("Items");
		for(int i = 0; i < itemList.tagCount(); i++) 
		{
			NBTTagCompound slotEntry = (NBTTagCompound) itemList.tagAt(i);
			int j = slotEntry.getByte("Slot") & 0xff;

			if(j >= 0 && j < getSizeInventory()) 
			{
				setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(slotEntry));
			}
		}
		reading = false;
	}

	protected void writeToNBT() 
	{
		NBTTagList itemList = new NBTTagList();
		for(int i = 0; i < getSizeInventory(); i++) 
		{
			if(getStackInSlot(i) != null) 
			{
				NBTTagCompound slotEntry = new NBTTagCompound();
				slotEntry.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(slotEntry);
				itemList.appendTag(slotEntry);
			}
		}
		NBTTagCompound inventory = new NBTTagCompound();
		inventory.setTag("Items", itemList);
		inventory.setString("UniqueID", uniqueID);
		NBTHelper.setCompoundTag(envelope, "Package", inventory);
	}
}