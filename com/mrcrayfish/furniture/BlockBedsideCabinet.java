package com.mrcrayfish.furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class BlockBedsideCabinet extends BlockContainer
{
	private Random random;

	protected BlockBedsideCabinet(int i, Material material)
	{
		super(i, material);
		random = new Random();
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
		return ClientProxyFurniture.renderBedsideCabinet;
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

	public boolean canProvidePower()
	{
		return true;
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		if(par1World.getBlockId(par2, par3 + 1, par4) == MrCrayfishFurnitureMod.lampOn.blockID)
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3, par3, this.blockID);
		}
		else
		{
			par1World.notifyBlocksOfNeighborChange(par2, par3, par3, this.blockID);
		}
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{

	}

	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if(par1IBlockAccess.getBlockId(par2, par3 + 1, par4) == MrCrayfishFurnitureMod.lampOn.blockID)
		{
			return 15;
		}
		else
		{
			return 0;
		}
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 1);
		}
		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 1);
		}
		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 1);
		}
		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 1);
		}
		int id = par1World.getBlockId(par2, par3, par4);
		par1World.notifyBlockChange(par2, par3, par4, id);
	}

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemBedsideCabinet.itemID;
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		TileEntityBedsideCabinet var7 = (TileEntityBedsideCabinet)par1World.getBlockTileEntity(par2, par3, par4);

		if (var7 != null)
		{
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
			{
				ItemStack var9 = var7.getStackInSlot(var8);

				if (var9 != null)
				{
					float var10 = this.random.nextFloat() * 0.8F + 0.1F;
					float var11 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem var14;

					for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
					{
						int var13 = this.random.nextInt(21) + 10;

						if (var13 > var9.stackSize)
						{
							var13 = var9.stackSize;
						}

						var9.stackSize -= var13;
						var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
						float var15 = 0.05F;
						var14.motionX = (double)((float)this.random.nextGaussian() * var15);
						var14.motionY = (double)((float)this.random.nextGaussian() * var15 + 0.2F);
						var14.motionZ = (double)((float)this.random.nextGaussian() * var15);

						if (var9.hasTagCompound())
						{
							var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
						}
					}
				}
			}
		}

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

	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityBedsideCabinet();
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemBedsideCabinet.itemID;
	}

}
