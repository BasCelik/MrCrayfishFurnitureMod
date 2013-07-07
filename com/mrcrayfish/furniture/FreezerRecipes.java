// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package com.mrcrayfish.furniture;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item

public class FreezerRecipes
{

    public static final FreezerRecipes solidifying()
    {
        return solidifyingBase;
    }

    private FreezerRecipes()
    {
        solidifyingList = new HashMap();
        addSolidifying(Item.bucketLava.itemID, new ItemStack(Block.obsidian));
        addSolidifying(Item.bucketWater.itemID, new ItemStack(Block.ice));
        addSolidifying(Item.slimeBall.itemID, new ItemStack(Item.snowball));
        addSolidifying(Item.poisonousPotato.itemID, new ItemStack(Item.potato));
        addSolidifying(Item.rottenFlesh.itemID, new ItemStack(MrCrayfishFurnitureMod.itemFlesh));
    }

    public void addSolidifying(int i, ItemStack itemstack)
    {
        solidifyingList.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack getSolidifyingResult(int i)
    {
        return (ItemStack)solidifyingList.get(Integer.valueOf(i));
    }

    public Map getSolidifyingList()
    {
        return solidifyingList;
    }

    private static final FreezerRecipes solidifyingBase = new FreezerRecipes();
    private Map solidifyingList;

}