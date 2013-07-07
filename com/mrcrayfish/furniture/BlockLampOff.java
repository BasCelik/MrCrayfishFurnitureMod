package com.mrcrayfish.furniture;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLampOff extends Block
{

	public BlockLampOff(int i, Material material)
	{
		super(i, material);
		float f = 0.375F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return ClientProxyFurniture.renderLamp;
	}
	
	@Override
	public boolean canRenderInPass(int pass)
	{
		ClientProxyFurniture.renderPass = pass;
		return true;
	}
	
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		if(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) )
		{
			par1World.setBlock(par2, par3, par4, MrCrayfishFurnitureMod.lampOn.blockID, 0, 3);
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) | par1World.getBlockId(par2, par3 - 1, par4) == MrCrayfishFurnitureMod.bedsideCabinet.blockID)
		{
			par1World.setBlock(par2, par3, par4, MrCrayfishFurnitureMod.lampOn.blockID, 0, 0);
			par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		}
		else
		{
			par5EntityPlayer.addChatMessage("Make sure lamp is powered by redstone or is on bedside cabinet.");
		}
		return true;
	}

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemLamp.itemID;
	}
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		return MrCrayfishFurnitureMod.itemLamp.itemID;
    }
}
