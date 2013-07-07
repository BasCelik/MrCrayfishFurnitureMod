package com.mrcrayfish.furniture;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mrcrayfish.furnitureapi.FreezerRecipesAPI;

public class ContainerFreezer extends Container
{
    private TileEntityFreezer freezer;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerFreezer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityFreezer)
    {
        this.freezer = tileentityFreezer;
        this.addSlotToContainer(new Slot(tileentityFreezer, 0, 63, 27));
        this.addSlotToContainer(new Slot(tileentityFreezer, 1, 32, 27));
        this.addSlotToContainer(new SlotFreezer(inventoryplayer.player, tileentityFreezer, 2, 123, 27));
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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.freezer.freezerCoolTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.freezer.freezerFreezeTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.freezer.currentItemCoolTime);
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

            if (this.lastCookTime != this.freezer.freezerCoolTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.freezer.freezerCoolTime);
            }

            if (this.lastBurnTime != this.freezer.freezerFreezeTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.freezer.freezerFreezeTime);
            }

            if (this.lastItemBurnTime != this.freezer.currentItemCoolTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.freezer.currentItemCoolTime);
            }
        }

        this.lastCookTime = this.freezer.freezerCoolTime;
        this.lastBurnTime = this.freezer.freezerFreezeTime;
        this.lastItemBurnTime = this.freezer.currentItemCoolTime;
    }

    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.freezer.freezerCoolTime = par2;
        }

        if (par1 == 1)
        {
            this.freezer.freezerFreezeTime = par2;
        }

        if (par1 == 2)
        {
            this.freezer.currentItemCoolTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.freezer.isUseableByPlayer(par1EntityPlayer);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FreezerRecipesAPI.instance().getSolidifyingResult(var5.getItem().itemID) != null)
                {
                    if (!this.mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFreezer.isItemFuel(var5))
                {
                    if (!this.mergeItemStack(var5, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 3, 39, false))
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

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}
