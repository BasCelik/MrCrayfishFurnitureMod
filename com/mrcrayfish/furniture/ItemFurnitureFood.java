package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemFurnitureFood extends ItemFood
{

	public ItemFurnitureFood(int par1, int par2, boolean par3) 
	{
		super(par1, par2, par3);
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		if(itemID == MrCrayfishFurnitureMod.itemFlesh.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemflesh");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCookedFlesh.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemfleshcooked");
		}
    }

}
