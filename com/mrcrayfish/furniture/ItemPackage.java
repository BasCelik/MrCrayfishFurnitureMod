package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemPackage extends Item implements IMail
{
	public ItemPackage(int par1) 
	{
		super(par1);
		this.maxStackSize = 1;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		TileEntity tile_entity = par3World.getBlockTileEntity(par4, par5, par6);
		if(tile_entity instanceof TileEntityMailBox)
		{
			TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
			if(tileEntityMailBox.isMailBoxFull() == false && par2EntityPlayer.isSneaking())
			{
				ItemStack itemStack = par1ItemStack.copy();
				tileEntityMailBox.addMail(itemStack);
				par1ItemStack.stackSize--;
			}
		}
		return true;    
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(!par2World.isRemote)
		{
			par3EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 6, par2World, 0, 0, 0);
		}
		return par1ItemStack;
	}

	public static IInventory getInv(EntityPlayer par1EntityPlayer) 
	{
		ItemStack itemStackPackage = par1EntityPlayer.getCurrentEquippedItem();
		InventoryPackage invPackage = null;
		if(itemStackPackage != null && itemStackPackage.getItem() instanceof ItemPackage)
		{
			invPackage = new InventoryPackage(par1EntityPlayer, itemStackPackage);
		}
		return invPackage;
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.itemIcon = par1IconRegister.registerIcon("cfm:itempackage");
    }
}