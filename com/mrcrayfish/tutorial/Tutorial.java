package com.mrcrayfish.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;

import com.mrcrayfish.instant.MrCrayfishBuildingsMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

import com.mrcrayfish.furnitureapi.*;

@Mod(modid = "tutorial", name = "Tutorial", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Tutorial
{	
	@Instance("Tutorial")
	public static Tutorial instance = new Tutorial();
	
	@SidedProxy(clientSide = "com.mrcrayfish.tutorial.ClientProxy", serverSide = "com.mrcrayfish.tutorial.CommonProxy")
	public static CommonProxy proxy;
	
	//Item and Block IDs
	int itemTestID;
	int blockTestID;
	
	//Items and Blocks
	public static Item itemTest;
	public static Block blockTest;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		//Configuration
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		itemTestID = config.getItem("ItemTest", 30000).getInt();
		blockTestID = config.getBlock("BlockOvenOverhead", 1000).getInt();
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		//Proxy Thingo
		proxy.registerRenderers();
		
		//Intialise Items and Blocks
		itemTest = new Item(itemTestID).setUnlocalizedName("apple").setCreativeTab(this.tabTutorial);
		blockTest = new Block(blockTestID, Material.grass).setUnlocalizedName("stone").setCreativeTab(this.tabTutorial);
		
		//Register Block
		GameRegistry.registerBlock(blockTest, "BlockTest");
		
		//Register Names
		LanguageRegistry.addName(itemTest, "Test Item");
		LanguageRegistry.addName(blockTest, "Test Block");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTutorial", "en_US", "Tutorial");
		
		FreezerRecipesAPI.instance().addSolidifying(this.itemTest.itemID, new ItemStack(this.blockTest));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(this.blockTest.blockID, new ItemStack(this.itemTest));
		
	}
	
	public static CreativeTabs tabTutorial = new CreativeTabs("tabTutorial") 
	{
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(Item.helmetIron, 1, 0);
		}
	};
	
}