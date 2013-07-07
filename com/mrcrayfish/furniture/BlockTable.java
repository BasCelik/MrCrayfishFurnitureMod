package com.mrcrayfish.furniture;

import static net.minecraftforge.common.ForgeDirection.UP;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
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
import net.minecraftforge.common.ForgeDirection;

public class BlockTable extends Block
{
	protected BlockTable(int i, Material material)
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
		return ClientProxyFurniture.renderTable;
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
			return MrCrayfishFurnitureMod.itemTableWood.itemID;
		}
		if(i == 2)
		{
			return MrCrayfishFurnitureMod.itemTableStone.itemID;
		}
		return i;
    }

	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		return false;
    }
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		if(par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			return MrCrayfishFurnitureMod.itemTableWood.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 2)
		{
			return MrCrayfishFurnitureMod.itemTableStone.itemID;
		}
		return blockID;
    }
	
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
    {
		if (side == UP)
        {
            return true;
        }
		return isBlockNormalCube(world, x, y, z);
    }
	
	
    
}
