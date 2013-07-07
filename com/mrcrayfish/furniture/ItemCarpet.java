package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCarpet extends Item
{
	private int colour;

	public ItemCarpet(int i, int metadata)
	{
		super(i);
		colour = metadata;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(par3World.isAirBlock(par4, par5 + 1, par6))
		{
			par3World.setBlock(par4, par5 + 1, par6, MrCrayfishFurnitureMod.carpet.blockID, colour, 3);
		}
		par1ItemStack.stackSize--;
		return true;
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		if(itemID == MrCrayfishFurnitureMod.itemCarpetBlack.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcarpetblack");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCarpetBrown.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcarpetbrown");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCarpetRed.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcarpetred");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCarpetGreen.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcarpetgreen");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCarpetWhite.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcarpetwhite");
		}
    }

}
