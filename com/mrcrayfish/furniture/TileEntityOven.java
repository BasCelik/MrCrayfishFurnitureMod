package com.mrcrayfish.furniture;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;
import com.mrcrayfish.furnitureapi.OvenRecipesAPI;

public class TileEntityOven extends TileEntity implements ISidedInventory, net.minecraftforge.common.ISidedInventory
{
	private static final int[] field_102010_d = new int[] {0};
	private static final int[] field_102011_e = new int[] {2, 1};
	private static final int[] field_102009_f = new int[] {1};

	/**
	 * The ItemStacks that hold the items currently being used in the furnace
	 */
	private ItemStack[] ovenItemStacks = new ItemStack[21];

	/** The number of ticks that the furnace will keep burning */
	public int ovenCookTime = 0;

	/**
	 * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	 */
	public int currentItemCookTime = 0;

	/** The number of ticks that the current item has been cooking for */
	public int ovenCookingTime = 0;
	private String field_94130_e;

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory()
	{
		return this.ovenItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1)
	{
		return this.ovenItemStacks[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.ovenItemStacks[par1] != null)
		{
			ItemStack itemstack;

			if (this.ovenItemStacks[par1].stackSize <= par2)
			{
				itemstack = this.ovenItemStacks[par1];
				this.ovenItemStacks[par1] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.ovenItemStacks[par1].splitStack(par2);

				if (this.ovenItemStacks[par1].stackSize == 0)
				{
					this.ovenItemStacks[par1] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.ovenItemStacks[par1] != null)
		{
			ItemStack itemstack = this.ovenItemStacks[par1];
			this.ovenItemStacks[par1] = null;
			return itemstack;
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
		this.ovenItemStacks[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.field_94130_e : "container.furnace";
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
	 * language. Otherwise it will be used directly.
	 */
	public boolean isInvNameLocalized()
	{
		return this.field_94130_e != null && this.field_94130_e.length() > 0;
	}

	public void func_94129_a(String par1Str)
	{
		this.field_94130_e = par1Str;
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.ovenItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.ovenItemStacks.length)
			{
				this.ovenItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		this.ovenCookTime = par1NBTTagCompound.getShort("BurnTime");
		this.ovenCookingTime = par1NBTTagCompound.getShort("CookTime");
		this.currentItemCookTime = getItemBurnTime(this.ovenItemStacks[1]);

		if (par1NBTTagCompound.hasKey("CustomName"))
		{
			this.field_94130_e = par1NBTTagCompound.getString("CustomName");
		}
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("BurnTime", (short)this.ovenCookTime);
		par1NBTTagCompound.setShort("CookTime", (short)this.ovenCookingTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.ovenItemStacks.length; ++i)
		{
			if (this.ovenItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.ovenItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);

		if (this.isInvNameLocalized())
		{
			par1NBTTagCompound.setString("CustomName", this.field_94130_e);
		}
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns an integer between 0 and the passed value representing how close the current item is to being completely
	 * cooked
	 */
	public int getCookProgressScaled(int par1)
	{
		return this.ovenCookingTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
	 * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
	 */
	public int getBurnTimeRemainingScaled(int par1)
	{
		if (this.currentItemCookTime == 0)
		{
			this.currentItemCookTime = 200;
		}

		return this.ovenCookTime * par1 / this.currentItemCookTime;
	}

	/**
	 * Returns true if the furnace is currently burning
	 */
	public boolean isBurning()
	{
		return this.ovenCookTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
	 * ticks and creates a new spawn inside its implementation.
	 */
	public void updateEntity()
	{
		boolean flag = this.ovenCookTime > 0;
		boolean flag1 = false;

		if (this.ovenCookTime > 0)
		{
			--this.ovenCookTime;
		}

		if (!this.worldObj.isRemote)
		{
			if (this.ovenCookTime == 0 && this.canSmelt())
			{
				this.currentItemCookTime = this.ovenCookTime = getItemBurnTime(this.ovenItemStacks[1]);

				if (this.ovenCookTime > 0)
				{
					flag1 = true;

					if (this.ovenItemStacks[1] != null)
					{
						--this.ovenItemStacks[1].stackSize;

						if (this.ovenItemStacks[1].stackSize == 0)
						{
							this.ovenItemStacks[1] = this.ovenItemStacks[1].getItem().getContainerItemStack(ovenItemStacks[1]);
						}
					}
				}
			}

			if (this.canSmelt())
			{
				++this.ovenCookingTime;

				if (this.ovenCookingTime == 150)
				{
					this.ovenCookingTime = 0;
					this.solidifyItems();
					flag1 = true;
				}
			}
			else
			{
				this.ovenCookingTime = 0;
			}

			if (flag != this.ovenCookTime > 0)
			{
				flag1 = true;
			}
		}

		if (flag1)
		{
			this.onInventoryChanged();
		}
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canSmelt()
	{
		if (this.ovenItemStacks[3] == null && this.ovenItemStacks[6] == null && this.ovenItemStacks[9] == null && this.ovenItemStacks[4] == null && this.ovenItemStacks[7] == null && this.ovenItemStacks[10] == null && this.ovenItemStacks[5] == null && this.ovenItemStacks[8] == null && this.ovenItemStacks[11] == null)
		{
			return false;
		}
		else if (this.ovenItemStacks[3] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[3]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[12] == null) return true;
			if (!this.ovenItemStacks[12].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[12].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[6] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[6]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[15] == null) return true;
			if (!this.ovenItemStacks[15].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[15].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[9] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[9]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[18] == null) return true;
			if (!this.ovenItemStacks[18].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[18].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[4] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[4]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[13] == null) return true;
			if (!this.ovenItemStacks[13].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[13].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[7] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[7]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[16] == null) return true;
			if (!this.ovenItemStacks[16].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[16].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[10] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[10]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[19] == null) return true;
			if (!this.ovenItemStacks[19].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[19].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[5] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[5]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[14] == null) return true;
			if (!this.ovenItemStacks[14].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[14].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[8] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[8]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[17] == null) return true;
			if (!this.ovenItemStacks[17].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[17].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else if (this.ovenItemStacks[11] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[11]);
			if (itemstack == null) return false;
			if (this.ovenItemStacks[20] == null) return true;
			if (!this.ovenItemStacks[20].isItemEqual(itemstack)) return false;
			int result = ovenItemStacks[20].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
		else
		{
			return false;
		}
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	 */
	public void solidifyItems()
	{
		if (this.ovenItemStacks[3] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[3]);
			if (this.ovenItemStacks[12] == null)
			{
				this.ovenItemStacks[12] = itemstack.copy();
			}
			else if (this.ovenItemStacks[12].isItemEqual(itemstack))
			{
				ovenItemStacks[12].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[3].stackSize;
			if (this.ovenItemStacks[3].stackSize <= 0)
			{
				this.ovenItemStacks[3] = null;
			}
		}
		else if (this.ovenItemStacks[6] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[6]);
			if (this.ovenItemStacks[15] == null)
			{
				this.ovenItemStacks[15] = itemstack.copy();
			}
			else if (this.ovenItemStacks[15].isItemEqual(itemstack))
			{
				ovenItemStacks[15].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[6].stackSize;
			if (this.ovenItemStacks[6].stackSize <= 0)
			{
				this.ovenItemStacks[6] = null;
			}
		}
		else if (this.ovenItemStacks[9] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[9]);
			if (this.ovenItemStacks[18] == null)
			{
				this.ovenItemStacks[18] = itemstack.copy();
			}
			else if (this.ovenItemStacks[18].isItemEqual(itemstack))
			{
				ovenItemStacks[18].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[9].stackSize;
			if (this.ovenItemStacks[9].stackSize <= 0)
			{
				this.ovenItemStacks[9] = null;
			}
		}
		else if (this.ovenItemStacks[4] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[4]);
			if (this.ovenItemStacks[13] == null)
			{
				this.ovenItemStacks[13] = itemstack.copy();
			}
			else if (this.ovenItemStacks[13].isItemEqual(itemstack))
			{
				ovenItemStacks[13].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[4].stackSize;
			if (this.ovenItemStacks[4].stackSize <= 0)
			{
				this.ovenItemStacks[4] = null;
			}
		}
		else if (this.ovenItemStacks[7] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[7]);
			if (this.ovenItemStacks[16] == null)
			{
				this.ovenItemStacks[16] = itemstack.copy();
			}
			else if (this.ovenItemStacks[16].isItemEqual(itemstack))
			{
				ovenItemStacks[16].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[7].stackSize;
			if (this.ovenItemStacks[7].stackSize <= 0)
			{
				this.ovenItemStacks[7] = null;
			}
		}
		else if (this.ovenItemStacks[10] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[10]);
			if (this.ovenItemStacks[19] == null)
			{
				this.ovenItemStacks[19] = itemstack.copy();
			}
			else if (this.ovenItemStacks[19].isItemEqual(itemstack))
			{
				ovenItemStacks[19].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[10].stackSize;
			if (this.ovenItemStacks[10].stackSize <= 0)
			{
				this.ovenItemStacks[10] = null;
			}
		}
		else if (this.ovenItemStacks[5] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[5]);
			if (this.ovenItemStacks[14] == null)
			{
				this.ovenItemStacks[14] = itemstack.copy();
			}
			else if (this.ovenItemStacks[14].isItemEqual(itemstack))
			{
				ovenItemStacks[14].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[5].stackSize;
			if (this.ovenItemStacks[5].stackSize <= 0)
			{
				this.ovenItemStacks[5] = null;
			}
		}
		else if (this.ovenItemStacks[8] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[8]);
			if (this.ovenItemStacks[17] == null)
			{
				this.ovenItemStacks[17] = itemstack.copy();
			}
			else if (this.ovenItemStacks[17].isItemEqual(itemstack))
			{
				ovenItemStacks[17].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[8].stackSize;
			if (this.ovenItemStacks[8].stackSize <= 0)
			{
				this.ovenItemStacks[8] = null;
			}
		}
		else if (this.ovenItemStacks[11] != null)
		{
			ItemStack itemstack = OvenRecipesAPI.instance().getCookingResult(this.ovenItemStacks[11]);
			if (this.ovenItemStacks[20] == null)
			{
				this.ovenItemStacks[20] = itemstack.copy();
			}
			else if (this.ovenItemStacks[20].isItemEqual(itemstack))
			{
				ovenItemStacks[20].stackSize += itemstack.stackSize;
			}
			--this.ovenItemStacks[11].stackSize;
			if (this.ovenItemStacks[11].stackSize <= 0)
			{
				this.ovenItemStacks[11] = null;
			}
		}
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
	 * fuel
	 */
	public static int getItemBurnTime(ItemStack par0ItemStack)
	{
		return 0;
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack)
	{
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openChest() {}

	public void closeChest() {}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
	{
		return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
	}

	/**
	 * Get the size of the side inventory.
	 */
	public int[] getAccessibleSlotsFromSide(int par1)
	{
		return par1 == 0 ? field_102011_e : (par1 == 1 ? field_102010_d : field_102009_f);
	}

	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
	{
		return this.isStackValidForSlot(par1, par2ItemStack);
	}

	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
	{
		return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
	}

	/***********************************************************************************
	 * This function is here for compatibilities sake, Modders should Check for
	 * Sided before ContainerWorldly, Vanilla Minecraft does not follow the sided standard
	 * that Modding has for a while.
	 *
	 * In vanilla:
	 *
	 *   Top: Ores
	 *   Sides: Fuel
	 *   Bottom: Output
	 *
	 * Standard Modding:
	 *   Top: Ores
	 *   Sides: Output
	 *   Bottom: Fuel
	 *
	 * The Modding one is designed after the GUI, the vanilla one is designed because its
	 * intended use is for the hopper, which logically would take things in from the top.
	 *
	 * This will possibly be removed in future updates, and make vanilla the definitive
	 * standard.
	 */

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (ForgeDummyContainer.legacyFurnaceSides)
		{
			if (side == ForgeDirection.DOWN) return 1;
			if (side == ForgeDirection.UP) return 0;
			return 2;
		}
		else
		{
			if (side == ForgeDirection.DOWN) return 2;
			if (side == ForgeDirection.UP) return 0;
			return 1;
		}
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}
}



