// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package com.mrcrayfish.furniture.src;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item

public class FreezerRecipesAPI
{
	private static final FreezerRecipesAPI solidifyingBase = new FreezerRecipesAPI();
    private Map solidifyingList;
    
    /**
     * Returns an instance of FreezerRecipesAPI;
     */
    public static final FreezerRecipesAPI instance()
    {
        return solidifyingBase;
    }
    
    /**
     * Initialize recipeList;
     */
    private FreezerRecipesAPI()
    {
        solidifyingList = new HashMap();
    }
    
    /**
     * Adds item to freezer solidifying list.
     */
    public void addSolidifying(int i, ItemStack itemstack)
    {
        solidifyingList.put(Integer.valueOf(i), itemstack);
    }
    
    /**
     * Returns the result of the item froze.
     */
    public ItemStack getSolidifyingResult(int i)
    {
        return (ItemStack)solidifyingList.get(Integer.valueOf(i));
    }
    
    /**
     * Returns the solidifying list.
     */
    public Map getSolidifyingList()
    {
        return solidifyingList;
    }

}