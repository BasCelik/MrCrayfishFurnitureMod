/*package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class BlockFridge extends BlockContainer
{
	private boolean blockType;
	private Random random;
	private Random freezerRand;
    private final boolean isActive;
    private static boolean keepFreezerInventory = false;

	protected BlockFridge(int i, boolean flag)
	{
		super(i, Material.rock);
		random = new Random();
		isActive = flag;
	}

	private int Front = ModLoader.addOverride("/terrain.png", "/furniture/bottomfront.png");
	private int Side1 = ModLoader.addOverride("/terrain.png", "/furniture/bottomside1.png");
	private int Side2 = ModLoader.addOverride("/terrain.png", "/furniture/bottomside2.png");
	private int Bottom = ModLoader.addOverride("/terrain.png", "/furniture/bottombottom.png");
	private int Back = ModLoader.addOverride("/terrain.png", "/furniture/bottomback.png");
	private int Top = ModLoader.addOverride("/terrain.png", "/furniture/toptoptop.png");

	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if (i == 1)
        {
            return Top;
        }
        if (i == 0)
        {
            return Bottom;
        }

        //Front
        if (j == 0 && i == 1)
        {
            return Top;
        }
        if (j == 0 && i == 3)
        {
            return Side2;
        }
        if (j == 0 && i == 2)
        {
            return Side1;
        }
        if (j == 0 && i == 5)
        {
            return Back;
        }
        if (j == 0 && i == 4)
        {
            return Front;
        }

        //Right
        if (j == 2 && i == 1)
        {
            return Top;
        }
        if (j == 2 && i == 3)
        {
            return Back;
        }
        if (j == 2 && i == 2)
        {
            return Front;
        }
        if (j == 2 && i == 5)
        {
            return Side1;
        }
        if (j == 2 && i == 4)
        {
            return Side2;
        }

        //Behind
        if (j == 1 && i == 1)
        {
            return Top;
        }
        if (j == 1 && i == 3)
        {
            return Side1;
        }
        if (j == 1 && i == 2)
        {
            return Side2;
        }
        if (j == 1 && i == 5)
        {
            return Front;
        }
        if (j == 1 && i == 4)
        {
            return Back;
        }

        //Left
        if (j == 3 && i == 1)
        {
            return Top;
        }
        if (j == 3 && i == 3)
        {
            return Front;
        }
        if (j == 3 && i == 2)
        {
            return Back;
        }
        if (j == 3 && i == 5)
        {
            return Side2;
        }
        if (j == 3 && i == 4)
        {
            return Side1;
        }
        else
        {
            return blockIndexInTexture;
        }
    }

    public int getBlockTextureFromSide(int i)
    {
    	if (i == 1)
        {
            return Top;
        }
        if (i == 3)
        {
            return Side2;
        }
        if (i == 2)
        {
            return Side1;
        }
        if (i == 5)
        {
            return Back;
        }
        if (i == 4)
        {
            return Front;
        }
        else
        {
            return Top;
        }
    }

    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
        int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(i, j, k, l);
    }

    public int idDropped(int i, Random random, int j)
    {
        return mod_Furniture.itemFridge.shiftedIndex;
    }

    public void onBlockRemoval(World world, int i, int j, int k)
	{
		TileEntityFreezer tileentityfreezer = (TileEntityFreezer)world.getBlockTileEntity(i, j, k);
		if (tileentityfreezer != null)
		{
			for (int l = 0; l < tileentityfreezer.getSizeInventory(); l++)
			{
				ItemStack itemstack = tileentityfreezer.getStackInSlot(l);
				if (itemstack == null)
				{
					continue;
				}
				float f = random.nextFloat() * 0.8F + 0.1F;
				float f1 = random.nextFloat() * 0.8F + 0.1F;
				float f2 = random.nextFloat() * 0.8F + 0.1F;
				while (itemstack.stackSize > 0)
				{
					int i1 = random.nextInt(21) + 10;
					if (i1 > itemstack.stackSize)
					{
						i1 = itemstack.stackSize;
					}
					itemstack.stackSize -= i1;
					EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
					float f3 = 0.05F;
					entityitem.motionX = (float)random.nextGaussian() * f3;
					entityitem.motionY = (float)random.nextGaussian() * f3 + 0.2F;
					entityitem.motionZ = (float)random.nextGaussian() * f3;
					if (itemstack.hasTagCompound())
					{
						entityitem.item.setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
					}
					world.spawnEntityInWorld(entityitem);
				}
			}
		}
		world.setBlockWithNotify(i, j + 1, k, 0);
		super.onBlockRemoval(world, i, j, k);
	}

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.isRemote)
        {
            return true;
        } else
        {
            TileEntityFreezer tileentityfreezer = (TileEntityFreezer)world.getBlockTileEntity(i, j, k);
            ModLoader.openGUI(entityplayer, new GuiFreezer(entityplayer.inventory, tileentityfreezer));
            return true;
        }
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntityFreezer();
    }

    public static void updateFreezerBlockState(boolean flag, World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        TileEntity tileentity = world.getBlockTileEntity(i, j, k);
        keepFreezerInventory = true;
        if (flag)
        {
            world.setBlockWithNotify(i, j, k, mod_Furniture.fridge.blockID);
        }
        else
        {
            world.setBlockWithNotify(i, j, k, mod_Furniture.fridge.blockID);
        }
        keepFreezerInventory = false;
        world.setBlockMetadataWithNotify(i, j, k, l);
        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(i, j, k, tileentity);
        }
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
		return mod_Furniture.RenderFridge;
	}

	public boolean func_48204_b(IBlockAccess par1IBlockAccess, int par2, int par3, int i)
    {
        return true;
    }
} */

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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFreezer extends BlockContainer
{
	/**
	 * Is the random generator used by freezer to drop the inventory contents in random directions.
	 */
	private Random freezerRand;

	/** True if this is an active freezer, false if idle */
	private final boolean isActive;

	/**
	 * This flag is used to prevent the freezer inventory to be dropped upon block removal, is used internally when the
	 * freezer block changes from idle to active and vice-versa.
	 */
	private static boolean keepFreezerInventory = false;

	protected BlockFreezer(int par1, boolean par2)
	{
		super(par1, Material.rock);
		freezerRand = new Random();
		isActive = par2;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MrCrayfishFurnitureMod.itemFridge.itemID;
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
		keepFreezerInventory = true;

		if (par0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, MrCrayfishFurnitureMod.fridge.blockID, 0);
		}
		else
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, MrCrayfishFurnitureMod.fridge.blockID, 0);
		}

		keepFreezerInventory = false;
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
		TileEntityFreezer var7 = (TileEntityFreezer)par1World.getBlockTileEntity(par2, par3, par4);

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
		par1World.setBlockToAir(par2, par3 + 1, par4);
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}


	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityFreezer();
	}
	
	public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return MrCrayfishFurnitureMod.itemFridge.itemID;
    }
}

