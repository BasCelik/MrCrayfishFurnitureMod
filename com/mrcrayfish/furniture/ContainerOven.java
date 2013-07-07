package com.mrcrayfish.furniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerOven extends Container
{
	private TileEntityOven oven;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerOven(InventoryPlayer inventoryplayer, TileEntityOven tileEntityOven)
	{
		this.oven = tileEntityOven;
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				this.addSlotToContainer(new Slot(tileEntityOven, x + y * 3 + 3, x * 18 + 7, y * 18 + 7));
			}
		}
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				this.addSlotToContainer(new SlotOven(inventoryplayer.player, tileEntityOven, x + y * 3 + 12, x * 18 + 117, y * 18 + 7));
			}
		}
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 9; k++)
			{
				this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (int j = 0; j < 9; j++)
		{
			this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.oven.ovenCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.oven.ovenCookingTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.oven.currentItemCookTime);
	}

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int var1 = 0; var1 < this.crafters.size(); ++var1)
		{
			ICrafting var2 = (ICrafting)this.crafters.get(var1);

			if (this.lastCookTime != this.oven.ovenCookTime)
			{
				var2.sendProgressBarUpdate(this, 0, this.oven.ovenCookTime);
			}

			if (this.lastBurnTime != this.oven.ovenCookingTime)
			{
				var2.sendProgressBarUpdate(this, 1, this.oven.ovenCookingTime);
			}

			if (this.lastItemBurnTime != this.oven.currentItemCookTime)
			{
				var2.sendProgressBarUpdate(this, 2, this.oven.currentItemCookTime);
			}
		}

		this.lastCookTime = this.oven.ovenCookTime;
		this.lastBurnTime = this.oven.ovenCookingTime;
		this.lastItemBurnTime = this.oven.currentItemCookTime;
	}

	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.oven.ovenCookTime = par2;
		}

		if (par1 == 1)
		{
			this.oven.ovenCookingTime = par2;
		}

		if (par1 == 2)
		{
			this.oven.currentItemCookTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return this.oven.isUseableByPlayer(par1EntityPlayer);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack var3 = null;
		Slot var4 = (Slot)this.inventorySlots.get(par2);
		if (var4 != null && var4.getHasStack())
		{
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();
			System.out.println(var5.getDisplayName());
			System.out.println(par2);
			if (par2 >= 0 && par2 <= 9)
			{
				if (!this.mergeItemStack(var5, 18, 53, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(var5, 0, 9, false))
			{
				return null;
			}

			if (var5.stackSize == 0)
			{
				var4.putStack((ItemStack)null);
			}
			else
			{
				var4.onSlotChanged();
			}
		}
		return var3;
	}
}
