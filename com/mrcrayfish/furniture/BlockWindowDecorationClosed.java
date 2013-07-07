package com.mrcrayfish.furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWindowDecorationClosed extends Block
{
	int timer = 0;

	protected BlockWindowDecorationClosed(int i, Material material)
	{
		super(i, material);
		setLightOpacity(255);
		opaqueCubeLookup[i] = true;
	}
	public int getRenderType()
	{
		return ClientProxyFurniture.renderWindowDecoration;
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

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		/*int blinds = MrCrayfishFurnitureMod.blinds.blockID;
		if(par1World.getBlockMetadata(par2 + 1, par3, par4) == 2 || par1World.getBlockMetadata(par2, par3 + 1, par4) == 2 || par1World.getBlockMetadata(par2, par3, par4 + 1) == 2 || par1World.getBlockMetadata(par2, par3 - 1, par4) == 2 || par1World.getBlockMetadata(par2 - 1, par3, par4) == 2 || par1World.getBlockMetadata(par2, par3, par4 - 1) == 2 || par1World.getBlockMetadata(par2, par3, par4) == 2)
		{
			if(par1World.getBlockId(par2 + 1, par3, par4) == blinds || par1World.getBlockId(par2, par3 + 1, par4) == blinds || par1World.getBlockId(par2, par3, par4 + 1) == blinds || par1World.getBlockId(par2, par3 - 1, par4) == blinds || par1World.getBlockId(par2 - 1, par3, par4) == blinds || par1World.getBlockId(par2, par3, par4 - 1) == blinds || par1World.getBlockId(par2, par3, par4) == blinds)
			{
				par1World.setBlock(par2, par3, par4, MrCrayfishFurnitureMod.blinds.blockID, 2, 0);
			}
		}*/

	}

	public void addCollidingBlockToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		int l = par1World.getBlockMetadata(i, j, k);
		if (l == 0)
		{
			setBlockBounds(0.0F, 0.0F, 0.9F, 1F, 1F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if (l == 2)
		{
			setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 0.1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if (l == 1)
		{
			setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		else if (l == 3)
		{
			setBlockBounds(0.9F, 0.0F, 0.0F, 1F, 1F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);
		if (l == 0)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.9F, 1F, 1F, 1F); //Base
			super.getSelectedBoundingBoxFromPool(world, i, j, k);
		}
		else if (l == 2)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 0.1F); //Base
			super.getSelectedBoundingBoxFromPool(world, i, j, k);
		}
		else if (l == 1)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1F, 1F); //Base
			super.getSelectedBoundingBoxFromPool(world, i, j, k);
		}
		else if (l == 3)
		{
			this.setBlockBounds(0.9F, 0.0F, 0.0F, 1F, 1F, 1F); //Base
			super.getSelectedBoundingBoxFromPool(world, i, j, k);
		}
		return super.getSelectedBoundingBoxFromPool(world, i, j, k);
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		if (l == 0)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.9F, 1F, 1F, 1F); //Base
		}
		else if (l == 2)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 0.1F); //Base
		}
		else if (l == 1)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1F, 1F); //Base
		}
		else if (l == 3)
		{
			this.setBlockBounds(0.9F, 0.0F, 0.0F, 1F, 1F, 1F); //Base
		}
    }

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{
		int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		if (l == 0)
		{
			world.setBlockMetadataWithNotify(i, j, k, 2, 0);
		}
		if (l == 1)
		{
			world.setBlockMetadataWithNotify(i, j, k, 1, 0);
		}
		if (l == 2)
		{
			world.setBlockMetadataWithNotify(i, j, k, 3, 0);
		}
		if (l == 3)
		{
			world.setBlockMetadataWithNotify(i, j, k, 0, 0);
		}
	}

	public int idDropped(int i, Random random, int j)
	{
		if(blockID == MrCrayfishFurnitureMod.blindsClosed.blockID)
		{
			return MrCrayfishFurnitureMod.itemBlinds.itemID;
		} 
		if(blockID == MrCrayfishFurnitureMod.curtainsClosed.blockID)
		{
			return MrCrayfishFurnitureMod.itemCurtains.itemID;
		}
		return 0;
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		if(this.blockID == MrCrayfishFurnitureMod.blindsClosed.blockID)
		{
			par1World.setBlock(par2, par3, par4, MrCrayfishFurnitureMod.blinds.blockID, l, 3);
		}
		if(this.blockID == MrCrayfishFurnitureMod.curtainsClosed.blockID)
		{
			par1World.setBlock(par2, par3, par4, MrCrayfishFurnitureMod.curtains.blockID, l, 3);
		}
		return true;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		if(blockID == MrCrayfishFurnitureMod.blindsClosed.blockID)
		{
			return MrCrayfishFurnitureMod.itemBlinds.itemID;
		} 
		if(blockID == MrCrayfishFurnitureMod.curtainsClosed.blockID)
		{
			return MrCrayfishFurnitureMod.itemCurtains.itemID;
		}
		return blockID;
	}
}
