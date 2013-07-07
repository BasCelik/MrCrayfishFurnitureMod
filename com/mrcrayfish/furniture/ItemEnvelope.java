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

public class ItemEnvelope extends Item implements IMail
{
	public ItemEnvelope(int par1) 
	{
		super(par1);
		this.maxStackSize = 1;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		TileEntity tile_entity = par3World.getBlockTileEntity(par4, par5, par6);
		if(!par3World.isRemote)
		{
			if(par2EntityPlayer.capabilities.isCreativeMode && par2EntityPlayer.isSneaking())
			{
				par2EntityPlayer.addChatMessage("You cannot use this in creative.");
			}
			else if(tile_entity instanceof TileEntityMailBox)
			{
				TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
				if(tileEntityMailBox.isMailBoxFull() == false && par2EntityPlayer.isSneaking() && !par3World.isRemote)
				{
					ItemStack itemStack = par1ItemStack.copy();
					tileEntityMailBox.addMail(itemStack);
					par2EntityPlayer.addChatMessage("Thank you! - " + tileEntityMailBox.ownerName);
					par1ItemStack.stackSize--;
				}
				else if(tileEntityMailBox.isMailBoxFull() == true && par2EntityPlayer.isSneaking())
				{
					par2EntityPlayer.addChatMessage(tileEntityMailBox.ownerName + "'s mail box seems to be full. Try again later.");
				}
			}
		}
		return true;    
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(!par2World.isRemote)
		{
			par3EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 5, par2World, 0, 0, 0);
		}
		return par1ItemStack;
	}

	public static IInventory getInv(EntityPlayer par1EntityPlayer) 
	{
		ItemStack mail = par1EntityPlayer.getCurrentEquippedItem();
		InventoryEnvelope invMail = null;
		if(mail != null && mail.getItem() instanceof ItemEnvelope)
		{
			invMail = new InventoryEnvelope(par1EntityPlayer, mail);
		}
		return invMail;
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.itemIcon = par1IconRegister.registerIcon("cfm:itemenvelope");
    }
}