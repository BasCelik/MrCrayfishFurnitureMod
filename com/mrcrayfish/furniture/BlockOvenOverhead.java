package com.mrcrayfish.furniture;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOvenOverhead extends Block
{

	protected BlockOvenOverhead(int i, Material material)
	{
		super(i, material);
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.6F, 1F);
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
		return ClientProxyFurniture.renderOvenOverhead;
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
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
	}

	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		int l = par1World.getBlockMetadata(i, j, k);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		if(par1World.getBlockMetadata(i, j, k) == 0) //Right
		{
			setBlockBounds(0.2F, 0.2F, 0.5F, 0.8F, 1.0F, 1.0F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if(par1World.getBlockMetadata(i, j, k) == 2) //Left
		{
			setBlockBounds(0.2F, 0.2F, 0.0F, 0.8F, 1.0F, 0.5F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if(par1World.getBlockMetadata(i, j, k) == 1) //Behind
		{
			setBlockBounds(0.0F, 0.2F, 0.2F, 0.5F, 1.0F, 0.8F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if(par1World.getBlockMetadata(i, j, k) == 3) //Front
		{
			setBlockBounds(0.5F, 0.2F, 0.2F, 1.0F, 1.0F, 0.8F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.6F, 1F);
	}

	public int idDropped(int i, Random random, int j)
    {
		return MrCrayfishFurnitureMod.itemOvenOverhead.itemID;
    }
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		return MrCrayfishFurnitureMod.itemOvenOverhead.itemID;
    }
}
