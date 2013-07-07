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

public class BlockCouch extends BlockMountable
{
	protected BlockCouch(int i, int j, Material material)
	{
		super(i, j, material);
		this.setBlockBounds(0F, 0.0F, 0F, 1F, 0.6F, 1F);
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
		return ClientProxyFurniture.renderCouch;
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
	
	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		int l = par1World.getBlockMetadata(i, j, k);
		if(l == 0) //Front
		{	
			setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.75F, 0.6F, 0.0F, 1F, 1.2F, 1F); //Back Rest
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			
			if(par1World.isAirBlock(i, j, k - 1) && !par1World.isAirBlock(i, j, k + 1) && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(!par1World.isAirBlock(i, j, k - 1) && par1World.isAirBlock(i, j, k + 1) && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i - 1, j, k) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);

			}
			else if(!par1World.isAirBlock(i, j, k - 1) | !par1World.isAirBlock(i, j, k + 1))
			{
				if(par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i - 1, j, k) == 2)
					{
						setBlockBounds(0.0F, 0.6F, 0.75F, 0.75F, 1.2F, 1F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i - 1, j, k) == 3)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 0.75F, 1.2F, 0.25F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i - 1, j, k) == 0 | par1World.getBlockMetadata(i - 1, j, k) == 1 && !par1World.isAirBlock(i, j, k + 1))
					{
						setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i - 1, j, k) == 0 | par1World.getBlockMetadata(i - 1, j, k) == 1 && !par1World.isAirBlock(i, j, k - 1))
					{
						setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
			}
			else if (par1World.isAirBlock(i, j, k - 1) && par1World.isAirBlock(i, j, k + 1))
			{
				if(par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i - 1, j, k) == 2)
					{
						setBlockBounds(0.0F, 0.6F, 0.75F, 0.75F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else if(par1World.getBlockMetadata(i - 1, j, k) == 3)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 0.75F, 1.2F, 0.25F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else
					{
						setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
						setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
				else
				{
					setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
				}
			}
		}
		
		if(l == 2) //Right
		{
			setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.0F, 0.6F, 0.75F, 1F, 1.2F, 1F); //Back Rest
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			
			if(par1World.isAirBlock(i + 1, j, k) && !par1World.isAirBlock(i - 1, j, k) && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(par1World.isAirBlock(i - 1, j, k) && !par1World.isAirBlock(i + 1, j, k) && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i, j, k - 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(!par1World.isAirBlock(i + 1, j, k) | !par1World.isAirBlock(i - 1, j, k))
			{
				if(par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i, j, k - 1) == 1)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 0.75F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k - 1) == 0)
					{
						setBlockBounds(0.75F, 0.6F, 0.0F, 1.0F, 1.2F, 0.75F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k - 1) == 2 | par1World.getBlockMetadata(i, j, k - 1) == 3 && !par1World.isAirBlock(i - 1, j, k))
					{
						setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k - 1) == 2 | par1World.getBlockMetadata(i, j, k - 1) == 3 && !par1World.isAirBlock(i + 1, j, k))
					{
						setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
			}
			else if (par1World.isAirBlock(i + 1, j, k) && par1World.isAirBlock(i - 1, j, k))
			{
				if(par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i, j, k - 1) == 1)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 0.75F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else if(par1World.getBlockMetadata(i, j, k - 1) == 0)
					{
						setBlockBounds(0.75F, 0.6F, 0.0F, 1.0F, 1.2F, 0.75F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else
					{
						setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
						setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
				else
				{
					setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
				}
			}
		}


		if(l == 1) //Behind
		{
			setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 1.0F); //Back Rest
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			
			if(par1World.isAirBlock(i, j, k - 1) && !par1World.isAirBlock(i, j, k + 1) && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(!par1World.isAirBlock(i, j, k - 1) && par1World.isAirBlock(i, j, k + 1) && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i + 1, j, k) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(!par1World.isAirBlock(i, j, k + 1) | !par1World.isAirBlock(i, j, k - 1))
			{
				if(par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i + 1, j, k) == 2)
					{
						setBlockBounds(0.0F, 0.6F, 0.75F, 1F, 1.2F, 1F); //Base
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i + 1, j, k) == 3)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 1F, 1.2F, 0.25F); //Base
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i + 1, j, k) == 1 | par1World.getBlockMetadata(i + 1, j, k) == 0 && !par1World.isAirBlock(i, j, k + 1))
					{
						setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i + 1, j, k) == 1 | par1World.getBlockMetadata(i + 1, j, k) == 0 && !par1World.isAirBlock(i, j, k - 1))
					{
						setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
			}
			else if (par1World.isAirBlock(i, j, k - 1) && par1World.isAirBlock(i, j, k + 1))
			{
				if(par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i + 1, j, k) == 2)
					{
						setBlockBounds(0.0F, 0.6F, 0.75F, 1.0F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else if(par1World.getBlockMetadata(i + 1, j, k) == 3)
					{
						setBlockBounds(0.0F, 0.6F, 0.0F, 1.0F, 1.2F, 0.25F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else
					{
						setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
						setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
				else
				{
					setBlockBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					setBlockBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
				}
			}
		}
		if(l == 3) //Left
		{
			setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			setBlockBounds(0.0F, 0.6F, 0.F, 1F, 1.2F, 0.25F); //Back Rest
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			
			if(par1World.isAirBlock(i + 1, j, k) && !par1World.isAirBlock(i - 1, j, k) && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(par1World.isAirBlock(i - 1, j, k) && !par1World.isAirBlock(i + 1, j, k) && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchBlack.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchBrown.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchGreen.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchRed.blockID && par1World.getBlockId(i, j, k + 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
				super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			}
			else if(!par1World.isAirBlock(i + 1, j, k) | !par1World.isAirBlock(i - 1, j, k))
			{
				if(par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i, j, k + 1) == 0)
					{
						setBlockBounds(0.75F, 0.6F, 0.25F, 1.0F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k + 1) == 1)
					{
						setBlockBounds(0.0F, 0.6F, 0.25F, 0.25F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k + 1) == 2 | par1World.getBlockMetadata(i, j, k + 1) == 3 && !par1World.isAirBlock(i - 1, j, k))
					{
						setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					if(par1World.getBlockMetadata(i, j, k + 1) == 2 | par1World.getBlockMetadata(i, j, k + 1) == 3 && !par1World.isAirBlock(i + 1, j, k))
					{
						setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
			}
			else if(par1World.isAirBlock(i + 1, j, k) && par1World.isAirBlock(i - 1, j, k))
			{
				if(par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchBlack.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchBrown.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchGreen.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchRed.blockID | par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					if(par1World.getBlockMetadata(i, j, k + 1) == 0)
					{
						setBlockBounds(0.75F, 0.6F, 0.25F, 1.0F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else if(par1World.getBlockMetadata(i, j, k + 1) == 1)
					{
						setBlockBounds(0.0F, 0.6F, 0.25F, 0.25F, 1.2F, 1.0F); //Back Rest
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
					else
					{
						setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
						setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
						super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					}
				}
				else
				{
					setBlockBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
					setBlockBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
					super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
				}
			}
		}
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.6F, 1F);
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
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		if(blockID == MrCrayfishFurnitureMod.couchWhite.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchWhite.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchGreen.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchGreen.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchBrown.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchBrown.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchRed.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchRed.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchBlack.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchBlack.itemID;
		}
		return blockID;
    }

	public int idDropped(int i, Random random, int j)
	{
		if(blockID == MrCrayfishFurnitureMod.couchWhite.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchWhite.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchGreen.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchGreen.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchBrown.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchBrown.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchRed.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchRed.itemID;
		}
		if(blockID == MrCrayfishFurnitureMod.couchBlack.blockID)
		{
			return MrCrayfishFurnitureMod.itemCouchBlack.itemID;
		}
		return blockID;
	}
}
