// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package com.mrcrayfish.furniture;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import com.mrcrayfish.furnitureapi.FreezerRecipesAPI;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, Item, BlockFurnace, 
//            FurnaceRecipes, Block, Material, ModLoader, 
//            EntityPlayer

public class TileEntityFreezer extends TileEntity implements IInventory
{
	private ItemStack freezerItemStacks[];
	public int freezerFreezeTime;
	public int currentItemCoolTime;
	public int freezerCoolTime;

	public TileEntityFreezer()
	{
		freezerItemStacks = new ItemStack[3];
		freezerFreezeTime = 0;
		currentItemCoolTime = 0;
		freezerCoolTime = 0;
	}

	public int getSizeInventory()
	{
		return freezerItemStacks.length;
	}

	public ItemStack getStackInSlot(int i)
	{
		return freezerItemStacks[i];
	}

	public ItemStack decrStackSize(int i, int j)
	{
		if(freezerItemStacks[i] != null)
		{
			if(freezerItemStacks[i].stackSize <= j)
			{
				ItemStack itemstack = freezerItemStacks[i];
				freezerItemStacks[i] = null;
				return itemstack;
			}
			ItemStack itemstack1 = freezerItemStacks[i].splitStack(j);
			if(freezerItemStacks[i].stackSize == 0)
			{
				freezerItemStacks[i] = null;
			}
			return itemstack1;
		} else
		{
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (freezerItemStacks[par1] != null)
		{
			ItemStack itemstack = freezerItemStacks[par1];
			freezerItemStacks[par1] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		this.freezerItemStacks[i] = itemstack;
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	public String getInvName()
	{
		return "Freezer";
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		freezerItemStacks = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound.getByte("Slot");

			if (byte0 >= 0 && byte0 < freezerItemStacks.length)
			{
				freezerItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		freezerCoolTime = par1NBTTagCompound.getShort("CoolTime");
		freezerFreezeTime = par1NBTTagCompound.getShort("FreezeTime");
		currentItemCoolTime = getItemFreezeTime(freezerItemStacks[1]);
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("CoolTime", (short)freezerCoolTime);
		par1NBTTagCompound.setShort("FreezeTime", (short)freezerFreezeTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < freezerItemStacks.length; i++)
		{
			if (freezerItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				freezerItemStacks[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public int getCoolProgressScaled(int i)
	{
		return (freezerCoolTime * i) / 200;
	}

	public int getFreezeTimeRemainingScaled(int i)
	{
		if(currentItemCoolTime == 0)
		{
			currentItemCoolTime = 200;
		}
		return (this.freezerFreezeTime * i) / currentItemCoolTime;
	}

	public boolean isFreezing()
	{
		return freezerFreezeTime > 0;
	}

	public void updateEntity()
	{
		boolean flag = freezerFreezeTime > 0;
		boolean flag1 = false;

		if (freezerFreezeTime > 0)
		{
			freezerFreezeTime--;
		}

		if (!worldObj.isRemote)
		{
			if (freezerFreezeTime == 0 && canSolidify())
			{
				currentItemCoolTime = freezerFreezeTime = getItemFreezeTime(freezerItemStacks[1]);

				if (freezerFreezeTime > 0)
				{
					flag1 = true;

					if (freezerItemStacks[1] != null)
					{
						freezerItemStacks[1].stackSize--;

						if (freezerItemStacks[1].stackSize == 0)
						{
							freezerItemStacks[1] = null;
						}
					}
				}
			}

			if (isFreezing() && canSolidify())
			{
				freezerCoolTime++;

				if (freezerCoolTime == 200)
				{
					freezerCoolTime = 0;
					solidifyItem();
					flag1 = true;
				}
			}
			else
			{
				freezerCoolTime = 0;
			}

		}
		if (flag != (freezerFreezeTime > 0))
		{
			flag1 = true;
		}
		if (flag1)
		{
			onInventoryChanged();
		}
	}

	private boolean canSolidify()
	{
		if (this.freezerItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = FreezerRecipesAPI.instance().getSolidifyingResult(this.freezerItemStacks[0].getItem().itemID);
            return var1 == null ? false : (this.freezerItemStacks[2] == null ? true : (!this.freezerItemStacks[2].isItemEqual(var1) ? false : (this.freezerItemStacks[2].stackSize < this.getInventoryStackLimit() && this.freezerItemStacks[2].stackSize < this.freezerItemStacks[2].getMaxStackSize() ? true : this.freezerItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
	}

	public void solidifyItem()
	{
		if(!canSolidify())
		{
			return;
		}
		ItemStack itemstack = FreezerRecipesAPI.instance().getSolidifyingResult(freezerItemStacks[0].getItem().itemID);
		if(freezerItemStacks[2] == null)
		{
			freezerItemStacks[2] = itemstack.copy();
		} else
			if(freezerItemStacks[2].itemID == itemstack.itemID)
			{
				freezerItemStacks[2].stackSize += itemstack.stackSize;
			}
		if(freezerItemStacks[0].getItem().hasContainerItem())
		{
			freezerItemStacks[0] = new ItemStack(freezerItemStacks[0].getItem().getContainerItem());
		} else
		{
			freezerItemStacks[0].stackSize--;
		}
		if(freezerItemStacks[0].stackSize <= 0)
		{
			freezerItemStacks[0] = null;
		}
	}

	private static int getItemFreezeTime(ItemStack itemstack)
	{
		if(itemstack == null)
		{
			return 0;
		}
		int i = itemstack.getItem().itemID;
		if (i == MrCrayfishFurnitureMod.itemCoolPack.itemID)
		{
			return 2500;
		}
		else if (i == Block.ice.blockID)
		{
			return 5000;
		}
		else
		{
			return 0;
		}
	}

	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemFreezeTime(itemstack) > 0;
	}

	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		 return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openChest(){}

	public void closeChest(){}

	public boolean isInvNameLocalized() 
	{
		return false;
	}


	public boolean isStackValidForSlot(int var1, ItemStack var2) 
	{
		return false;
	}
}