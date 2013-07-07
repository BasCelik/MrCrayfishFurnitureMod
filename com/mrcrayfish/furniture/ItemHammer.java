package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemHammer extends Item
{

	public ItemHammer(int par1) 
	{
		super(par1);
		this.setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		TileEntity tile_entity = (TileEntity)par3World.getBlockTileEntity(par4, par5, par6);
		if(tile_entity instanceof TileEntityMailBox)
		{
			TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
			if(tileEntityMailBox.locked && !par3World.isRemote)
			{
				par2EntityPlayer.addChatMessage("[FORCED] Mail Box is now unlocked");
				tileEntityMailBox.locked = false;
			}
			else if(!tileEntityMailBox.locked && !par3World.isRemote)
			{
				par2EntityPlayer.addChatMessage("[FORCED] Mail Box is now locked");
				tileEntityMailBox.locked = true;
			}
		}
		return true;
    }
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.itemIcon = par1IconRegister.registerIcon("cfm:itemhammer");
    }

}
