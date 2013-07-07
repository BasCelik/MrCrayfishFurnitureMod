package com.mrcrayfish.furniture;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMailBox extends BlockContainer
{
	private Random random;
	private String username;
	private int x;

	protected BlockMailBox(int i, Material material)
	{
		super(i, material);
		random = new Random();
		this.setHardness(0.5F);
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
		return ClientProxyFurniture.renderMailBox;
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

	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		//Pole
		setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.8F, 0.5625F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);

		int l = par1World.getBlockMetadata(i, j, k);
		if(l == 3)
		{
			//Left Side
			setBlockBounds(0.25F, 0.8625F, 0.25F, 0.75F, 1.1624F, 0.3125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);	
			//Right Side
			setBlockBounds(0.25F, 0.8625F, 0.6875F, 0.75F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Back
			setBlockBounds(0.6875F, 0.8625F, 0.3125F, 0.75F, 1.1624F, 0.6875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Front
			setBlockBounds(0.25F, 0.8625F, 0.3125F, 0.3125F, 1.0F, 0.6875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 1)
		{
			//Left Side
			setBlockBounds(0.25F, 0.8625F, 0.25F, 0.75F, 1.1624F, 0.3125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);	
			//Right Side
			setBlockBounds(0.25F, 0.8625F, 0.6875F, 0.75F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Back
			setBlockBounds(0.6875F, 0.8625F, 0.3125F, 0.75F, 1.0F, 0.6875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Front
			setBlockBounds(0.25F, 0.8625F, 0.3125F, 0.3125F, 1.1624F, 0.6875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 2)
		{
			//Left Side
			setBlockBounds(0.3125F, 0.8625F, 0.25F, 0.6875F, 1.1624F, 0.3125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);	
			//Right Side
			setBlockBounds(0.3125F, 0.8625F, 0.6875F, 0.6875F, 1.0F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Back
			setBlockBounds(0.6875F, 0.8625F, 0.25F, 0.75F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Front
			setBlockBounds(0.25F, 0.8625F, 0.25F, 0.3125F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(l == 0)
		{
			//Left Side
			setBlockBounds(0.3125F, 0.8625F, 0.25F, 0.6875F, 1.0F, 0.3125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);	
			//Right Side
			setBlockBounds(0.3125F, 0.8625F, 0.6875F, 0.6875F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Back
			setBlockBounds(0.6875F, 0.8625F, 0.25F, 0.75F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
			//Front
			setBlockBounds(0.25F, 0.8625F, 0.25F, 0.3125F, 1.1624F, 0.75F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}

		//Base
		setBlockBounds(0.25F, 0.8F, 0.25F, 0.75F, 0.8625F, 0.75F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		//Roof
		setBlockBounds(0.1875F, 1.1F, 0.1875F, 0.8125F, 1.1625F, 0.8125F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.1625F, 0.8125F);
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.1625F, 0.8125F);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		TileEntity tile_entity = (TileEntity)par1World.getBlockTileEntity(par2, par3, par4);
		if(tile_entity instanceof TileEntityMailBox)
		{
			TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
			tileEntityMailBox.setOwner((EntityPlayer)par5EntityLivingBase);
		}
	}

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemMailBox.itemID;
	}

	public float getExplosionResistance(Entity entity)
	{
		if (entity instanceof EntityCreeper) 
		{ 
			return 1000; 
		}
		return this.blockResistance / 5.0F;
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		TileEntityMailBox var7 = (TileEntityMailBox)par1World.getBlockTileEntity(par2, par3, par4);

		if ((var7 != null && !var7.locked))
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
			super.breakBlock(par1World, par2, par3, par4, par5, par6);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, this.blockID, par1World.getBlockMetadata(par2, par3, par4), 3);
		}
	}

	public ItemStack[] destroyItems(World world, int i, int j, int k, ItemStack[] chestContents)
	{
		return chestContents;
	}

	public TileEntity createNewTileEntity(World world) 
	{
		System.out.println("Creating mailbox");
		return new TileEntityMailBox();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		//TileEntity tile_entity = (TileEntity)par1World.getBlockTileEntity(par2, par3, par4);

		/*if(tile_entity instanceof TileEntityMailBox)
		{
			TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
			par5EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 0, par1World, par2, par3, par4);
		}
		return true;*/
		TileEntity tile_entity = (TileEntity)par1World.getBlockTileEntity(par2, par3, par4);
		if(!par1World.isRemote)
		{
			if(tile_entity instanceof TileEntityMailBox && !par5EntityPlayer.isSneaking())
			{
				TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
				if(tileEntityMailBox.canOpen(tileEntityMailBox, par5EntityPlayer) && tileEntityMailBox.locked)
				{
					par5EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 0, par1World, par2, par3, par4);
				}
				else if(!par1World.isRemote && tileEntityMailBox.locked)
				{
					par5EntityPlayer.addChatMessage("This mail box belongs to " + tileEntityMailBox.ownerName);
				}
				else if(!tileEntityMailBox.locked)
				{
					par5EntityPlayer.openGui(MrCrayfishFurnitureMod.instance, 0, par1World, par2, par3, par4);
				}
			}
			else if(tile_entity instanceof TileEntityMailBox && par5EntityPlayer.isSneaking())
			{
				TileEntityMailBox tileEntityMailBox = (TileEntityMailBox)tile_entity;
				if(tileEntityMailBox.canOpen(tileEntityMailBox, par5EntityPlayer))
				{
					if(tileEntityMailBox.locked)
					{
						tileEntityMailBox.locked = false;
						par5EntityPlayer.addChatMessage("Mailbox unlocked!");
					}
					else if(!tileEntityMailBox.locked)
					{
						tileEntityMailBox.locked = true;
						par5EntityPlayer.addChatMessage("Mailbox locked!");
					}
				}
				else
				{
					par5EntityPlayer.addChatMessage("You don't have an envelope or package in your hand.");
				}
			}
		}
		return false;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemMailBox.itemID;
	}

}
