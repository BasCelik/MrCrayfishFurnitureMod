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

public class BlockTap extends Block
{

	protected BlockTap(int i, Material material)
	{
		super(i, material);
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
		return ClientProxyFurniture.renderTap;
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

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		boolean isWaterInTheRightPosition = false;
		if(world.getBlockId(i, j - 2, k) == Block.waterStill.blockID)
		{
			if(world.getBlockId(i, j - 2, k + 1) == Block.waterStill.blockID)
			{
				if(world.getBlockId(i, j - 2, k - 1) == Block.waterStill.blockID)
				{
					if(world.getBlockId(i + 1, j - 2, k - 1) == Block.waterStill.blockID)
					{
						if(world.getBlockId(i + 1, j - 2, k + 1) == Block.waterStill.blockID)
						{
							if(world.getBlockId(i + 1, j - 2, k) == Block.waterStill.blockID)
							{
								if(world.getBlockId(i - 1, j - 2, k - 1) == Block.waterStill.blockID)
								{
									if(world.getBlockId(i - 1, j - 2, k + 1) == Block.waterStill.blockID)
									{
										if(world.getBlockId(i - 1, j - 2, k) == Block.waterStill.blockID)
										{
											isWaterInTheRightPosition = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(isWaterInTheRightPosition)
		{
			int l = world.getBlockMetadata(i, j, k);
			if(l == 3) world.setBlock(i - 1, j, k, Block.waterStill.blockID);
			if(l == 1) world.setBlock(i + 1, j, k, Block.waterStill.blockID);
			if(l == 2) world.setBlock(i, j, k + 1, Block.waterStill.blockID);
			if(l == 0) world.setBlock(i, j, k - 1, Block.waterStill.blockID);

		}
		else if(!world.isRemote)
		{
			entityplayer.addChatMessage("Place 3x3 water block sources under the layer the tap is on, with the tap in the middle");
		}
		return true;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
	}

	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.8F, 0.5625F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		
		int l = par1World.getBlockMetadata(i, j, k);			
		if(l == 3)
		{
			setBlockBounds(0.125F, 0.8F, 0.4375F, 0.5625F, 0.9F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.125F, 0.7F, 0.4375F, 0.25F, 0.8F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 1)
		{
			setBlockBounds(0.4375F, 0.8F, 0.4375F, 0.875F, 0.9F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.75F, 0.7F, 0.4375F, 0.875F, 0.8F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 2)
		{
			setBlockBounds(0.4375F, 0.8F, 0.4375F, 0.5625F, 0.9F, 0.875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.4375F, 0.7F, 0.75F, 0.5625F, 0.8F, 0.875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 0)
		{
			setBlockBounds(0.4375F, 0.8F, 0.125F, 0.5625F, 0.9F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.4375F, 0.7F, 0.125F, 0.5625F, 0.8F, 0.25F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		if(l == 3)
		{
			this.setBlockBounds(0.125F, 0.0F, 0.4F, 0.5625F, 1.0F, 0.6F);
		}
		if(l == 1)
		{
			this.setBlockBounds(0.4375F, 0.0F, 0.4F, 0.875F, 1.0F, 0.6F);
		}
		if(l == 2)
		{
			this.setBlockBounds(0.4F, 0.0F, 0.4375F, 0.6F, 1.0F, 0.875F);
		}
		if(l == 0)
		{
			this.setBlockBounds(0.4F, 0.0F, 0.125F, 0.6F, 1.0F, 0.5625F);
		}
    }

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemTap.itemID;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemTap.itemID;
	}
}
