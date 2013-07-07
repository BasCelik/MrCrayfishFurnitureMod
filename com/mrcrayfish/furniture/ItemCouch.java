package com.mrcrayfish.furniture;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemCouch extends Item
{
    /** The ID of the block the reed will spawn when used from inventory bar. */
    private int spawnID;
    private int metadata;

    public ItemCouch(int par1, int blockID)
    {
        super(par1);
        this.spawnID = blockID;
        maxStackSize = 8;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int var11 = par3World.getBlockId(par4, par5, par6);
        metadata = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if(metadata == 0) metadata = 2;
        else if(metadata == 2) metadata = 3;
        else if(metadata == 3) metadata = 0;

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

            return true;
        }
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
		if(itemID == MrCrayfishFurnitureMod.itemCouchWhite.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcouchwhite");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCouchGreen.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcouchgreen");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCouchBrown.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcouchbrown");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCouchRed.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcouchred");
		}
		if(itemID == MrCrayfishFurnitureMod.itemCouchBlack.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon("cfm:itemcouchblack");
		}
    }
}

