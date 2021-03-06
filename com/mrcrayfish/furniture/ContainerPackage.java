package com.mrcrayfish.furniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPackage extends Container
{
    private int numRows;
    private ItemStack mail;

    public ContainerPackage(IInventory par1IInventory, IInventory par2IInventory)
    {
    	par2IInventory.openChest();
        int var3 = (this.numRows - 4) * 18;

        this.addSlotToContainer(new SlotMail(par2IInventory, 0, 8 + 0 * 18 + 54, 18 + 0 * 18 - 3));
        this.addSlotToContainer(new SlotMail(par2IInventory, 1, 8 + 0 * 18 + 54, 18 + 1 * 18 - 3));
        this.addSlotToContainer(new SlotMail(par2IInventory, 2, 8 + 1 * 18 + 54, 18 + 0 * 18 - 3));
        this.addSlotToContainer(new SlotMail(par2IInventory, 3, 8 + 1 * 18 + 54, 18 + 1 * 18 - 3));
        this.addSlotToContainer(new SlotMail(par2IInventory, 4, 8 + 2 * 18 + 54, 18 + 0 * 18 - 3));
        this.addSlotToContainer(new SlotMail(par2IInventory, 5, 8 + 2 * 18 + 54, 18 + 1 * 18 - 3));

        for (int var4 = 0; var4 < 3; ++var4)
        {
            for (int var5 = 0; var5 < 9; ++var5)
            {
                this.addSlotToContainer(new Slot(par1IInventory, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3 + 53));
            }
        }

        for (int var4 = 0; var4 < 9; ++var4)
        {
            this.addSlotToContainer(new Slot(par1IInventory, var4, 8 + var4 * 18, 161 + var3 + 53));
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 < this.numRows * 9)
            {
                if (!this.mergeItemStack(var5, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 0, this.numRows * 9, false))
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


    /**
     * Callback for when the crafting gui is closed.
     */
    public void onCraftGuiClosed(EntityPlayer par1EntityPlayer)
    {
        super.onCraftGuiClosed(par1EntityPlayer);
    }
    
}
