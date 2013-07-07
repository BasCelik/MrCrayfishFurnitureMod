package com.mrcrayfish.instant;

import com.mrcrayfish.furniture.MrCrayfishFurnitureMod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBuilding extends BlockContainer
{
	protected BlockBuilding(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		par5EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 0, par1World, par2, par3, par4);
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityBuildingBlock();
	}

}
