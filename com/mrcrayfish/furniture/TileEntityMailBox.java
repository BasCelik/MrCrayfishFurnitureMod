package com.mrcrayfish.furniture;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMailBox extends TileEntity implements IInventory, IPacketReceiver
{
	public ItemStack[] mailBoxContents = new ItemStack[36];
	public String ownerName = "World";
	boolean locked = true;

	public int getSizeInventory()
	{
		return 27;
	}

	public void setOwner(EntityPlayer player)
	{
		this.ownerName = player.username;
	}

	public void setOwnerViaString(String username)
	{
		this.ownerName = username;
	}

	@Override
	public void handlePacketData(INetworkManager network, Packet250CustomPayload packet, EntityPlayer player, ByteArrayDataInput dataStream) 
	{
		int ID = dataStream.readInt();

		try
		{
			if(worldObj.isRemote && ID == 0)
			{
				this.ownerName = dataStream.readUTF().toString();
				System.out.println("TileEntityMailBox says: " + this.ownerName);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1)
	{
		return this.mailBoxContents[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.mailBoxContents[par1] != null)
		{
			ItemStack var3;

			if (this.mailBoxContents[par1].stackSize <= par2)
			{
				var3 = this.mailBoxContents[par1];
				this.mailBoxContents[par1] = null;
				this.onInventoryChanged();
				return var3;
			}
			else
			{
				var3 = this.mailBoxContents[par1].splitStack(par2);

				if (this.mailBoxContents[par1].stackSize == 0)
				{
					this.mailBoxContents[par1] = null;
				}

				this.onInventoryChanged();
				return var3;
			}
		}
		else
		{
			return null;
		}
	}
	
	public int getMailCount()
	{
		int count = 0;
		for(int i = 0; i < this.getSizeInventory(); i++)
		{
			if(mailBoxContents[i] != null)
			{
				count++;
			}
		}
		return count;
	}
	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.mailBoxContents[par1] != null)
		{
			ItemStack var2 = this.mailBoxContents[par1];
			this.mailBoxContents[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.mailBoxContents[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}

		this.onInventoryChanged();
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName()
	{
		return "Mail Box";
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList var2 = par1NBTTagCompound.getTagList("mailBoxItems");
		this.ownerName = par1NBTTagCompound.getString("OwnerName");
		System.out.println("Loaded Owner: " + this.ownerName);
		this.locked = par1NBTTagCompound.getBoolean("Locked");
		this.mailBoxContents = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
			int var5 = var4.getByte("mailBoxSlot") & 255;

			if (var5 >= 0 && var5 < this.mailBoxContents.length)
			{
				this.mailBoxContents[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList var2 = new NBTTagList();
		par1NBTTagCompound.setString("OwnerName", ownerName);
		par1NBTTagCompound.setBoolean("Locked", locked);

		for (int var3 = 0; var3 < this.mailBoxContents.length; ++var3)
		{
			if (this.mailBoxContents[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("mailBoxSlot", (byte)var3);
				this.mailBoxContents[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}
		par1NBTTagCompound.setTag("mailBoxItems", var2);
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	/**
	 * Causes the TileEntity to reset all it's cached values for it's container block, blockID, metaData and in the case
	 * of cabinets, the adjcacent cabinet check
	 */
	public void updateContainingBlockInfo()
	{
		super.updateContainingBlockInfo();
	}

	public boolean canOpen(TileEntityMailBox mailBox, EntityPlayer player)
	{
		if (mailBox instanceof TileEntityMailBox)
		{
			EntityPlayer owner = worldObj.getPlayerEntityByName(mailBox.ownerName);
			if (player == owner) return true;
		}
		return false;
	}

	public void addMail(ItemStack itemStack)
	{
		if(mailBoxContents[0] == null)
		{
			mailBoxContents[0] = itemStack;
		}
		else if(mailBoxContents[1] == null)
		{
			mailBoxContents[1] = itemStack;
		}
		else if(mailBoxContents[2] == null)
		{
			mailBoxContents[2] = itemStack;
		}
		else if(mailBoxContents[3] == null)
		{
			mailBoxContents[3] = itemStack;
		}
		else if(mailBoxContents[4] == null)
		{
			mailBoxContents[4] = itemStack;
		}
		else if(mailBoxContents[5] == null)
		{
			mailBoxContents[5] = itemStack;
		}
		this.onInventoryChanged();
	}
	
	public boolean isMailBoxFull()
	{
		boolean isFull = false;
		if(mailBoxContents[0] != null)
		{
			if(mailBoxContents[1] != null)
			{
				if(mailBoxContents[2] != null)
				{
					if(mailBoxContents[3] != null)
					{
						if(mailBoxContents[4] != null)
						{
							if(mailBoxContents[5] != null)
							{
								isFull = true;
							}
						}
					}
				}
			}
		}
		return isFull;
	}
	
	public void setContents(int slotNumber, ItemStack itemStack)
	{
		mailBoxContents[slotNumber] = itemStack;
		this.onInventoryChanged();
	}

	public void updateEntity()
	{
		super.updateEntity();
	}


	public void openChest(){}

	public void closeChest(){}

	/**
	 * invalidates a tile entity
	 */
	public void invalidate()
	{
		this.updateContainingBlockInfo();
		super.invalidate();
	}

	public String getOwner()
	{
		if (this.ownerName == null) return "null";
		return this.ownerName;
	}

	public boolean isInvNameLocalized() 
	{
		return false;
	}


	public boolean isStackValidForSlot(int var1, ItemStack var2) 
	{
		return false;
	}
}
