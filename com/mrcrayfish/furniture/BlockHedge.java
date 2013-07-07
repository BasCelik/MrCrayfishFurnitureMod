package com.mrcrayfish.furniture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.common.IShearable;

public class BlockHedge extends BlockLeavesBase implements IShearable
{
	public static final String[] LEAF_TYPES = new String[] {"oak", "spruce", "birch", "jungle"};
    public static final String[][] field_94396_b = new String[][] {{"leaves", "leaves_spruce", "leaves", "leaves_jungle"}, {"leaves_opaque", "leaves_spruce_opaque", "leaves_opaque", "leaves_jungle_opaque"}};
    @SideOnly(Side.CLIENT)
    private int field_94394_cP;
    private Icon[][] iconArray = new Icon[2][];
    int[] adjacentTreeBlocks;

	protected BlockHedge(int par1)
	{
		super(par1, Material.leaves, false);
	}

	@SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerFoliage.getFoliageColor(d0, d1);
    }

	public int getRenderColor(int par1)
	{
		return (par1 & 3) == 1 ? ColorizerFoliage.getFoliageColorPine() : ((par1 & 3) == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic());
	}

	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		if(l == 1)
		{
			return ColorizerFoliage.getFoliageColorPine();
		}
		else if(l == 2)
		{
		return ColorizerFoliage.getFoliageColorBirch();
		}
		else
        {
            int i1 = 0;
            int j1 = 0;
            int k1 = 0;

            for (int l1 = -1; l1 <= 1; ++l1)
            {
                for (int i2 = -1; i2 <= 1; ++i2)
                {
                    int j2 = par1IBlockAccess.getBiomeGenForCoords(par2 + i2, par4 + l1).getBiomeFoliageColor();
                    i1 += (j2 & 16711680) >> 16;
                    j1 += (j2 & 65280) >> 8;
                    k1 += j2 & 255;
                }
            }

            return (i1 / 9 & 255) << 16 | (j1 / 9 & 255) << 8 | k1 / 9 & 255;
        }
	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && par5Random.nextInt(15) == 1)
		{
			double d0 = (double)((float)par2 + par5Random.nextFloat());
			double d1 = (double)par3 - 0.05D;
			double d2 = (double)((float)par4 + par5Random.nextFloat());
			par1World.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(par1 == 0)
		{
			return MrCrayfishFurnitureMod.itemHedgeBasic.itemID;
		}
		if(par1 == 1)
		{
			return MrCrayfishFurnitureMod.itemHedgeSpruce.itemID;
		}
		if(par1 == 2)
		{
			return MrCrayfishFurnitureMod.itemHedgeBirch.itemID;
		}
		if(par1 == 3)
		{
			return MrCrayfishFurnitureMod.itemHedgeJungle.itemID;
		}
		return par1;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		if(l == 0)
		{
			return MrCrayfishFurnitureMod.itemHedgeBasic.itemID;
		}
		if(l == 1)
		{
			return MrCrayfishFurnitureMod.itemHedgeSpruce.itemID;
		}
		if(l == 2)
		{
			return MrCrayfishFurnitureMod.itemHedgeBirch.itemID;
		}
		if(l == 3)
		{
			return MrCrayfishFurnitureMod.itemHedgeJungle.itemID;
		}
		return 0;
	}

	/**
	 * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
	 * block and l is the block's subtype/damage.
	 */
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int par1)
	{
		return par1 & 3;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return ClientProxyFurniture.renderHedge;
	}

	public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockId(par2, par3, par4);

		if (l != this.blockID && l != Block.fenceGate.blockID)
		{
			Block block = Block.blocksList[l];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		}
		else
		{
			return true;
		}
	}

	public void addCollisionBoxesToList(World par1World, int i, int j, int k, AxisAlignedBB par5AxisAlignedBB, List arrayList, Entity par7Entity)
	{
		setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.5F, 0.8125F);
		super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		if(par1World.getBlockId(i + 1, j, k) == MrCrayfishFurnitureMod.hedge.blockID | par1World.getBlockId(i + 1, j, k) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i + 1, j, k))
		{
			setBlockBounds(0.8125F, 0.0F, 0.1875F, 1.0F, 1.5F, 0.8125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i - 1, j, k) == MrCrayfishFurnitureMod.hedge.blockID | par1World.getBlockId(i - 1, j, k) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i - 1, j, k))
		{
			setBlockBounds(0.0F, 0.0F, 0.1875F, 0.1875F, 1.5F, 0.8125F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i, j, k + 1) == MrCrayfishFurnitureMod.hedge.blockID | par1World.getBlockId(i, j, k + 1) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i, j, k + 1))
		{
			setBlockBounds(0.1875F, 0.0F, 0.8125F, 0.8125F, 1.5F, 1.0F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
		if(par1World.getBlockId(i, j, k - 1) == MrCrayfishFurnitureMod.hedge.blockID | par1World.getBlockId(i, j, k - 1) == Block.fenceGate.blockID | par1World.isBlockNormalCube(i, j, k - 1))
		{
			setBlockBounds(0.1875F, 0.0F, 0.0F, 0.8125F, 1.5F, 0.1875F);
			super.addCollisionBoxesToList(par1World, i, j, k, par5AxisAlignedBB, arrayList, par7Entity);
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		float f = 0.1875F;
		float f1 = 0.8125F;
		float f2 = 0.1875F;
		float f3 = 0.8125F;

		if(par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == MrCrayfishFurnitureMod.hedge.blockID  | par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2 + 1, par3, par4))
		{
			f1 = 1.0F;
		}
		if(par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == MrCrayfishFurnitureMod.hedge.blockID | par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2 - 1, par3, par4))
		{
			f = 0.0F;
		}
		if(par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == MrCrayfishFurnitureMod.hedge.blockID | par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2, par3, par4 + 1))
		{
			f3 = 1.0F;
		}
		if(par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == MrCrayfishFurnitureMod.hedge.blockID | par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == Block.fenceGate.blockID | par1IBlockAccess.isBlockNormalCube(par2, par3, par4 - 1))
		{
			f2 = 0.0F;
		}

		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	 * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	 */
	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(this.blockID, 1, par1 & 3);
	}

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z)
	{
		return true;
	}

	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}
	
	public Icon getIcon(int par1, int par2)
    {
        return (par2 & 3) == 1 ? this.iconArray[this.field_94394_cP][1] : ((par2 & 3) == 3 ? this.iconArray[this.field_94394_cP][3] : this.iconArray[this.field_94394_cP][0]);
    }
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        for (int i = 0; i < field_94396_b.length; ++i)
        {
            this.iconArray[i] = new Icon[field_94396_b[i].length];

            for (int j = 0; j < field_94396_b[i].length; ++j)
            {
                this.iconArray[i][j] = par1IconRegister.registerIcon(field_94396_b[i][j]);
            }
        }
    }


	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
}
