package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemChair extends Item
{
	private int blockID;

	protected ItemChair(int i, int block) 
	{
		super(i);
		blockID = block;
		maxStackSize = 8;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{  
		int rotate = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		if(rotate == 0)
		{
			if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
			{
				par3World.setBlock(par4, par5 + 1, par6, blockID, 2, 3);
				par1ItemStack.stackSize--; 
			}
		}
		if(rotate == 1)
		{
			if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
			{			
				par3World.setBlock(par4, par5 + 1, par6, blockID, 1, 3);
				par1ItemStack.stackSize--; 
			}
		}
		if(rotate == 2)
		{
			if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
			{
				par3World.setBlock(par4, par5 + 1, par6, blockID, 3, 3);
				par1ItemStack.stackSize--; 
			}
		}
		if(rotate == 3)
		{
			if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
			{
				par3World.setBlock(par4, par5 + 1, par6, blockID, 0, 3);
				par1ItemStack.stackSize--; 
			}
		}
		return true; 
	} 
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		if(itemID == MrCrayfishFurnitureMod.itemChairWood.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemchairwood");
		}
		if(itemID == MrCrayfishFurnitureMod.itemChairStone.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemchairstone");
		}
    }
}
