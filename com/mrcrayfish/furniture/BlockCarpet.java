package com.mrcrayfish.furniture;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpet extends Block
{
	private Icon icon1;
	private Icon icon2;
	private Icon icon3;
	private Icon icon4;
	private Icon icon5;

	protected BlockCarpet(int i, Material material)
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
		return ClientProxyFurniture.renderCarpet;
	}

	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean canRenderInPass(int pass)
	{
		ClientProxyFurniture.renderPass = pass;
		return true;
	}

	public int idDropped(int i, Random random, int j)
	{
		if(i == 1)
		{
			return MrCrayfishFurnitureMod.itemCarpetBlack.itemID;
		}
		if(i == 2)
		{
			return MrCrayfishFurnitureMod.itemCarpetBrown.itemID;
		}
		if(i == 3)
		{
			return MrCrayfishFurnitureMod.itemCarpetRed.itemID;
		}
		if(i == 4)
		{
			return MrCrayfishFurnitureMod.itemCarpetWhite.itemID;
		}
		if(i == 5)
		{
			return MrCrayfishFurnitureMod.itemCarpetGreen.itemID;
		}
		return i;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		if(par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			return MrCrayfishFurnitureMod.itemCarpetBlack.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 2)
		{
			return MrCrayfishFurnitureMod.itemCarpetBrown.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 3)
		{
			return MrCrayfishFurnitureMod.itemCarpetRed.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 4)
		{
			return MrCrayfishFurnitureMod.itemCarpetWhite.itemID;
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 5)
		{
			return MrCrayfishFurnitureMod.itemCarpetGreen.itemID;
		}
		return par2;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		setBlockBounds(0F, 0F, 0F, 1F, 0.001F, 1F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
	{
		return true;
	}
	
	public void registerIcons(IconRegister par1IconRegister)
	{
		System.out.println("Registering carpet textures");
		icon1 = par1IconRegister.registerIcon("cloth_15");
		icon2 = par1IconRegister.registerIcon("cloth_12");
		icon3 = par1IconRegister.registerIcon("cloth_14");
		icon4 = par1IconRegister.registerIcon("cloth_0");
		icon5 = par1IconRegister.registerIcon("cloth_13");
	}

	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		System.out.println(par2);
		if(par2 == 1)
		{
			this.blockIcon = icon1;
		}
		if(par2 == 2)
		{
			this.blockIcon = icon2;
		}
		if(par2 == 3)
		{
			this.blockIcon = icon3;
		}
		if(par2 == 4)
		{
			this.blockIcon = icon4;
		}
		if(par2 == 5)
		{
			this.blockIcon = icon5;
		}
		return this.blockIcon;
	}

}
