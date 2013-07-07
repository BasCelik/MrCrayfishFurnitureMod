package com.mrcrayfish.furniture;

import java.util.ArrayList;
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
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;

public class BlockChair extends BlockMountable
{

	protected BlockChair(int i, int j, Material material)
	{
		super(i, j, material);
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
		return ClientProxyFurniture.renderChair;
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
		return onBlockActivated(world, i, j, k, entityplayer, 0.5F, 0.6F, 0.5F, 0, 0, 0, 0);
    }
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
	}

	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		int l = par1World.getBlockMetadata(i, j, k);
		if (l == 0)
		{
			setBlockBounds(0.8F, 0.6F, 0.1F, 0.9F, 1.2F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);

		}
		else if (l == 1)
		{
			setBlockBounds(0.1F, 0.6F, 0.1F, 0.2F, 1.2F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if (l == 2)
		{
			setBlockBounds(0.1F, 0.6F, 0.8F, 0.9F, 1.2F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if (l == 3)
		{
			setBlockBounds(0.1F, 0.6F, 0.1F, 0.9F, 1.2F, 0.2F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
	}
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.2F, 0.9F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

	public int idDropped(int i, Random random, int j)
    {
		if(blockID == MrCrayfishFurnitureMod.chairWood.blockID)
		{
			return MrCrayfishFurnitureMod.itemChairWood.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.chairStone.blockID)
		{
			return MrCrayfishFurnitureMod.itemChairStone.itemID;
		}
		return i;
    }
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		if(blockID == MrCrayfishFurnitureMod.chairWood.blockID)
		{
			return MrCrayfishFurnitureMod.itemChairWood.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.chairStone.blockID)
		{
			return MrCrayfishFurnitureMod.itemChairStone.itemID;
		}
		return blockID;
    }
	
}
