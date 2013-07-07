package com.mrcrayfish.furniture;

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

public class BlockOven extends BlockContainer
{
	/**
	 * Is the random generator used by freezer to drop the inventory contents in random directions.
	 */
	private Random ovenRand;

	/** True if this is an active freezer, false if idle */
	private final boolean isActive;

	/**
	 * This flag is used to prevent the freezer inventory to be dropped upon block removal, is used internally when the
	 * freezer block changes from idle to active and vice-versa.
	 */
	private static boolean keepOvenInventory = false;

	protected BlockOven(int par1, boolean par2)
	{
		super(par1, Material.rock);
		ovenRand = new Random();
		isActive = par2;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MrCrayfishFurnitureMod.itemOven.itemID;
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
		return ClientProxyFurniture.renderOven;
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

	public static void updateFreezerBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int i = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepOvenInventory = true;

		if (par0)
		{
			//par1World.setBlockMetadataWithNotify(par2, par3, par4, MrCrayfishFurnitureMod.oven.blockID, 0);
		}
		else
		{
			//par1World.setBlockMetadataWithNotify(par2, par3, par4, MrCrayfishFurnitureMod.oven.blockID, 0);
		}

		keepOvenInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, i, 0);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int i = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;

		if (i == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 10);
		}

		if (i == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 10);
		}

		if (i == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 10);
		}

		if (i == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 10);
		}
	}

	/**
	 * Called whenever the block is removed.
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		TileEntityOven var7 = (TileEntityOven)par1World.getBlockTileEntity(par2, par3, par4);

		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = this.ovenRand.nextFloat() * 0.8F + 0.1F;
					float var11 = this.ovenRand.nextFloat() * 0.8F + 0.1F;
					float var12 = this.ovenRand.nextFloat() * 0.8F + 0.1F;

					while (var9.stackSize > 0)
					{
						int var13 = this.ovenRand.nextInt(21) + 10;

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
						var14.motionX = (double)((float)this.ovenRand.nextGaussian() * var15);
						var14.motionY = (double)((float)this.ovenRand.nextGaussian() * var15 + 0.2F);
						var14.motionZ = (double)((float)this.ovenRand.nextGaussian() * var15);
						par1World.spawnEntityInWorld(var14);
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}


	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityOven();
	}
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
		return MrCrayfishFurnitureMod.itemOven.itemID;
    }
}

