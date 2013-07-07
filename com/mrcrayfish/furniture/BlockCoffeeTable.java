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

public class BlockCoffeeTable extends Block{
	protected BlockCoffeeTable(int i, Material material)
	{
		super(i, material);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
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
		return ClientProxyFurniture.renderCoffeeTable;
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

	public int idDropped(int i, Random random, int j)
    {
		if(i == 1)
		{
			return MrCrayfishFurnitureMod.itemCoffeeTableWood.itemID;
		}
		if(i == 2)
		{
			return MrCrayfishFurnitureMod.itemCoffeeTableStone.itemID;
		}
		return i;
    }
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		if(par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			return MrCrayfishFurnitureMod.itemCoffeeTableWood.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 2)
		{
			return MrCrayfishFurnitureMod.itemCoffeeTableStone.itemID;
		}
		return blockID;
    }
	
}
