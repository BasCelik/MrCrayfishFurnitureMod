package com.mrcrayfish.furniture;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockCustom extends Item
{
	private int spawnID;
	private int metadata;
	private int metadata2;

	public ItemBlockCustom(int par1, int blockID, int metadata)
	{
		super(par1);
		this.spawnID = blockID;
		this.metadata = metadata;
		maxStackSize = 64;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(itemID == MrCrayfishFurnitureMod.itemStonePath.itemID)
		{
			Random rand = new Random();
			metadata2 = rand.nextInt(this.metadata);
			System.out.print(metadata2);
		}
		int var11 = par3World.getBlockId(par4, par5, par6);

		if (var11 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
		{
			par7 = 1;
		}
		else if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID)
		{
			if (par7 == 0)
			{
				--par5;
			}

			if (par7 == 1)
			{
				++par5;
			}

			if (par7 == 2)
			{
				--par6;
			}

			if (par7 == 3)
			{
				++par6;
			}

			if (par7 == 4)
			{
				--par4;
			}

			if (par7 == 5)
			{
				++par4;
			}
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else if (par1ItemStack.stackSize == 0)
		{
			return false;
		}
		else
		{
			if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
			{
				Block var12 = Block.blocksList[this.spawnID];
				int var13 = var12.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
				if(itemID == MrCrayfishFurnitureMod.itemStonePath.itemID)
				{
					if (par3World.setBlock(par4, par5, par6, this.spawnID, metadata2, 3))
					{
						if (par3World.getBlockId(par4, par5, par6) == this.spawnID)
						{
							Block.blocksList[this.spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
							Block.blocksList[this.spawnID].onPostBlockPlaced(par3World, par4, par5, par6, metadata2);
						}

						par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var12.stepSound.getPlaceSound(), (var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
						--par1ItemStack.stackSize;
					}
				}
				else
				{
					if (par3World.setBlock(par4, par5, par6, this.spawnID, metadata, 3))
					{
						if (par3World.getBlockId(par4, par5, par6) == this.spawnID)
						{
							Block.blocksList[this.spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
							Block.blocksList[this.spawnID].onPostBlockPlaced(par3World, par4, par5, par6, metadata);
						}

						par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var12.stepSound.getPlaceSound(), (var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
						--par1ItemStack.stackSize;
					}
				}
			}

			return true;
		}
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		if(itemID == MrCrayfishFurnitureMod.itemTableWood.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemtablewood");
		}
		if(itemID == MrCrayfishFurnitureMod.itemTableStone.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemtablestone");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCoffeeTableWood.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcoffeetablewood");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCoffeeTableStone.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcoffeetablestone");
		}
		if(itemID == MrCrayfishFurnitureMod.itemLamp.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemlamp");
		}
		if(itemID == MrCrayfishFurnitureMod.itemBedsideCabinet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itembedsidecabinet");
		}
		if(itemID == MrCrayfishFurnitureMod.itemHedgeBasic.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemhedgebasic");
		}
		if(itemID == MrCrayfishFurnitureMod.itemHedgeSpruce.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemhedgespruce");
		}
		if(itemID == MrCrayfishFurnitureMod.itemHedgeBirch.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemhedgebirch");
		}
		if(itemID == MrCrayfishFurnitureMod.itemHedgeJungle.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemhedgejungle");
		}
		if(itemID == MrCrayfishFurnitureMod.itemBirdBath.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itembirdbath");
		}
		if(itemID == MrCrayfishFurnitureMod.itemStonePath.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemstonepath");
		}
		if(itemID == MrCrayfishFurnitureMod.itemWhiteFence.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemwhitefence");
		}
    }
}

