package com.mrcrayfish.furniture;

import java.util.ArrayList;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFridge extends BlockContainer
{
	private Random freezerRand = new Random();;

	protected BlockFridge(int i)
	{
		super(i, Material.iron);
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
		return ClientProxyFurniture.renderFridge;
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

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
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

	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l, int l1)
	{
		dropBlockAsItem_do(world, i, (j - 1), k, (new ItemStack(0, 0, 0)));
	}

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemFridge.itemID;
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{

		TileEntityFridge var7 = (TileEntityFridge)par1World.getBlockTileEntity(par2, par3, par4);

		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = this.freezerRand.nextFloat() * 0.8F + 0.1F;
					float var11 = this.freezerRand.nextFloat() * 0.8F + 0.1F;
					float var12 = this.freezerRand.nextFloat() * 0.8F + 0.1F;

					while (var9.stackSize > 0)
					{
						int var13 = this.freezerRand.nextInt(21) + 10;

						if (var13 > var9.stackSize)
						{
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

						if (var9.hasTagCompound())
						{
							var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
						}

						float var15 = 0.05F;
						var14.motionX = (double)((float)this.freezerRand.nextGaussian() * var15);
						var14.motionY = (double)((float)this.freezerRand.nextGaussian() * var15 + 0.2F);
						var14.motionZ = (double)((float)this.freezerRand.nextGaussian() * var15);
						par1World.spawnEntityInWorld(var14);
					}
				}
			}
		}
		par1World.setBlockToAir(par2, par3 - 1, par4);
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		TileEntity tile_entity = par1World.getBlockTileEntity(par2, par3, par4);
		if(tile_entity == null || par5EntityPlayer.isSneaking())
		{
			return false;
		}
		par5EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 0, par1World, par2, par3, par4);
		return true;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemFridge.itemID;
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return  new TileEntityFridge();
	}
}
