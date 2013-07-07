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

public class BlockBirdBath extends Block
{

	protected BlockBirdBath(int i, Material material)
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
		return ClientProxyFurniture.renderBirdBath;
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
		setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.1F, 0.75F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.3125F, 0.1F, 0.3125F, 0.6875F, 0.7F, 0.6875F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.0F, 0.7F, 0.0F, 1.0F, 0.8F, 1.0F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);

		setBlockBounds(0.0F, 0.8F, 0.0F, 0.1F, 0.9F, 1.0F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.1F, 0.7F, 0.0F, 0.9F, 0.9F, 0.1F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.1F, 0.7F, 0.9F, 0.9F, 0.9F, 1.0F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.9F, 0.8F, 0.0F, 1.0F, 0.9F, 1.0F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,0.9F,1.0F);
	}
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,0.9F,1.0F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemBirdBath.itemID;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemBirdBath.itemID;
	}
}
