// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package com.mrcrayfish.furniture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item

public class OvenRecipes
{
	private static final OvenRecipes cookingBase = new OvenRecipes();
    private Map cookingList;
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();

    public static final OvenRecipes cooking()
    {
        return cookingBase;
    }

    private OvenRecipes()
    {
        cookingList = new HashMap();
        this.addFoodToCookable(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
        this.addFoodToCookable(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
        this.addFoodToCookable(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
        this.addFoodToCookable(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
        this.addFoodToCookable(Item.potato.itemID, new ItemStack(Item.bakedPotato));
        this.addFoodToCookable(MrCrayfishFurnitureMod.itemFlesh.itemID, new ItemStack(MrCrayfishFurnitureMod.itemCookedFlesh));
    }

    public void addFoodToCookable(int i, ItemStack itemstack)
    {
        cookingList.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack getCookingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)cookingList.get(Integer.valueOf(item.itemID));
    }

    public Map getCookingList()
    {
        return cookingList;
    }
}