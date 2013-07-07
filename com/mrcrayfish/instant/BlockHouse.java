package com.mrcrayfish.instant;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockHouse extends Block 
{
	public BlockHouse(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = ((MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 3);
        System.out.println(l);
    }

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		par1World.setBlockToAir(par2, par3, par4);
		MedievalSchematics.generateHouse(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4));
		return false;
	}

}
