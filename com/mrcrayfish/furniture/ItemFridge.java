package com.mrcrayfish.furniture;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFridge extends Item{

	protected ItemFridge(int i) 
	{
		super(i);
		maxStackSize = 8;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{  
		int rotate = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		
		if(!par2EntityPlayer.isSneaking())
		{
			if(rotate == 0)
			{
				if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
				{
					par3World.setBlock(par4, par5 + 1, par6, MrCrayfishFurnitureMod.freezer.blockID, 2, 3);
					par3World.setBlock(par4, par5 + 2, par6, MrCrayfishFurnitureMod.fridge.blockID, 2, 3);
					par1ItemStack.stackSize--;
				}
			}
			if(rotate == 1)
			{
				if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
				{
					par3World.setBlock(par4, par5 + 1, par6, MrCrayfishFurnitureMod.freezer.blockID, 1, 3);
					par3World.setBlock(par4, par5 + 2, par6,MrCrayfishFurnitureMod.fridge.blockID, 1, 3);
					par1ItemStack.stackSize--;
				}
			}
			if(rotate == 2)
			{
				if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
				{			
					par3World.setBlock(par4, par5 + 1, par6, MrCrayfishFurnitureMod.freezer.blockID, 3, 3);
					par3World.setBlock(par4, par5 + 2, par6, MrCrayfishFurnitureMod.fridge.blockID, 3, 3);
					par1ItemStack.stackSize--;
				}
			}
			if(rotate == 3)
			{
				if(par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6))
				{
					par3World.setBlock(par4, par5 + 1, par6, MrCrayfishFurnitureMod.freezer.blockID, 0, 3);
					par3World.setBlock(par4, par5 + 2, par6, MrCrayfishFurnitureMod.fridge.blockID, 0, 3);
					par1ItemStack.stackSize--;
				}
			} 
		}
		else
		{
			System.out.println("ID: " + par3World.getBlockId(par4, par5, par6));
			System.out.println("Metadata: " + par3World.getBlockMetadata(par4, par5, par6));
		}
		return true; 

	} 
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.itemIcon = par1IconRegister.registerIcon("cfm:itemfridge");
    }

}
