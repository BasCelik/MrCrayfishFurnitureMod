package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemFurniture extends Item 
{

	public ItemFurniture(int par1) 
	{
		super(par1);
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.itemIcon = par1IconRegister.registerIcon("cfm:itemcoolpack");
    }
}
