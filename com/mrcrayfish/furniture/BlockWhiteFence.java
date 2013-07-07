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

public class BlockWhiteFence extends Block
{

	protected BlockWhiteFence(int i, Material material)
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
		return ClientProxyFurniture.renderWhiteFence;
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
		setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.5F, 0.5625F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		if(par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.whiteFence.blockID | par1World.getBlockId(i + 1, j, k) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i + 1, j, k))
		{
			setBlockBounds(0.4375F, 0.0F, 0.4375F, 1.0F, 1.5F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.whiteFence.blockID | par1World.getBlockId(i - 1, j, k) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i - 1, j, k))
		{
			setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5625F, 1.5F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.whiteFence.blockID | par1World.getBlockId(i, j, k + 1) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i, j, k + 1))
		{
			setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.5F, 1.0F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.whiteFence.blockID | par1World.getBlockId(i, j, k - 1) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i, j, k - 1))
		{
			setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.5F, 0.5625F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
		float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        
		if(par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == MrCrayfishFurnitureMod.whiteFence.blockID | par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2 + 1, par3, par4))
		{
			f1 = 1.0F;
		}
		if(par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == MrCrayfishFurnitureMod.whiteFence.blockID | par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2 - 1, par3, par4))
		{
			f = 0.0F;
		}
		if(par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == MrCrayfishFurnitureMod.whiteFence.blockID | par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2, par3, par4 + 1))
		{
			f3 = 1.0F;
		}
		if(par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == MrCrayfishFurnitureMod.whiteFence.blockID | par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2, par3, par4 - 1))
		{
			f2 = 0.0F;
		}
		
		this.setBlockBounds(f, 0.0F, f2, f1, 1.1F, f3);
    }

	public int idDropped(int i, Random random, int j)
    {
		return MrCrayfishFurnitureMod.itemWhiteFence.itemID;
    }
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		return MrCrayfishFurnitureMod.itemWhiteFence.itemID;
    }
}
