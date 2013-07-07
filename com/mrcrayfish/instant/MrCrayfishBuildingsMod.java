package com.mrcrayfish.instant;

import com.mrcrayfish.instant.GuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "cibm", name = "MrCrayfish's Instant Buildings Mod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class MrCrayfishBuildingsMod
{	
	@Instance("cibm")
	public static MrCrayfishBuildingsMod instance = new MrCrayfishBuildingsMod();
	private GuiHandler guiHandler = new GuiHandler();
	
	@SidedProxy(clientSide="com.mrcrayfish.instant.ClientProxy", serverSide="com.mrcrayfish.instant.CommonProxy")
	public static CommonProxy proxy;
	
	int medievalHouseID;
	int medievalFarmID;
	int medievalWindmillID;
	int medievalTowerID;
	int medievalWallID;
	int medievalWallTowerID;
			
	int medievalBlockID;
	
	public static Item medievalHouse;
	public static Item medievalFarm;
	public static Item medievalWindmill;
	public static Item medievalTower;
	public static Item medievalWall;
	public static Item medievalWallTower;
	
	public static Block medievalBlock;

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		medievalBlockID = config.getBlock("BlockMedieval", 580).getInt();
		medievalHouseID = config.getItem("ItemMedievalHouse", 24000).getInt();
		medievalFarmID = config.getItem("ItemMedievalFarm", 24001).getInt();
		medievalWindmillID = config.getItem("ItemMedievalWindmill", 24002).getInt();
		medievalTowerID = config.getItem("ItemMedievalTower", 24003).getInt();
		medievalWallID = config.getItem("ItemMedievalWall", 24004).getInt();
		medievalWallTowerID = config.getItem("ItemMedievalWallTower", 24005).getInt();
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		//medievalBlock = new BlockMedieval(medievalBlockID, Material.wood).setUnlocalizedName("blockMedieval").setCreativeTab(tabInstantBuilding);
		
		/*blockHouse = new Block(blockHouseID, Material.wood).setUnlocalizedName("blockHouse").setCreativeTab(tabInstantBuilding);
		blockFarm = new Block(blockFarmID, Material.wood).setUnlocalizedName("blockFarm").setCreativeTab(tabInstantBuilding);
		blockWindmill = new Block(blockWindmillID, Material.wood).setUnlocalizedName("blockWindmill").setCreativeTab(tabInstantBuilding);
		blockTower = new Block(blockTowerID, Material.wood).setUnlocalizedName("blockTower").setCreativeTab(tabInstantBuilding);*/
		
		///LanguageRegistry.addName(medievalBlock, "House");
		//LanguageRegistry.addName(blockFarm, "Farm");
		//LanguageRegistry.addName(blockWindmill, "Windmill");
		//LanguageRegistry.addName(blockTower, "Guard Tower");	
		
		//GameRegistry.registerBlock(medievalBlock, "BlockMedieval");
		//GameRegistry.registerBlock(blockFarm, "BlockFarm");
		//GameRegistry.registerBlock(blockWindmill, "BlockWindmill");
		//GameRegistry.registerBlock(blockTower, "BlockTower");
				
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabInstantBuilding", "en_US", "MrCrayfish's Instant Buildings Mod");
	}
	
	public static CreativeTabs tabInstantBuilding = new CreativeTabs("tabInstantBuilding") 
	{
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(Item.diamond, 1, 0);
		}
	};
	
}
