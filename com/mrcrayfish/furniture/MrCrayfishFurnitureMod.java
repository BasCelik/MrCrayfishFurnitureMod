package com.mrcrayfish.furniture;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;

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
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import com.mrcrayfish.furnitureapi.*;

@Mod(modid = "cfm", name = "MrCrayfish's Furniture Mod", version = "2.8.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"sitting"}, packetHandler = PacketManager.class)

public class MrCrayfishFurnitureMod
{	
	@Instance("cfm")
	public static MrCrayfishFurnitureMod instance = new MrCrayfishFurnitureMod();

	private GuiHandler guiHandler = new GuiHandler();

	@SidedProxy(clientSide = "com.mrcrayfish.furniture.ClientProxyFurniture", serverSide = "com.mrcrayfish.furniture.CommonProxyFurniture")
	public static CommonProxyFurniture proxy;

	//ID Config
	int itemBedsideCabinetID;
	int itemTableWoodID;
	int itemChairWoodID;
	int itemCabinetID;
	int itemCoffeeTableWoodID;
	int itemFridgeID;
	int itemCouchWhiteID;
	int itemCouchGreenID;
	int itemCouchBrownID;
	int itemCouchRedID;
	int itemCouchBlackID;
	int itemBlindsID;
	int itemCurtainsID;
	int itemCarpetWhiteID;
	int itemCarpetGreenID;
	int itemCarpetBrownID;
	int itemCarpetRedID;
	int itemCarpetBlackID;
	int itemLampID;
	int itemCoolPackID;
	int itemChairStoneID;
	int itemTableStoneID;
	int itemCoffeeTableStoneID;
	int itemOvenID;
	int itemOvenOverheadID;
	int itemFleshID;
	int itemCookedFleshID;
	int itemHedgeBasicID;
	int itemHedgeSpruceID;
	int itemHedgeBirchID;
	int itemHedgeJungleID;
	int itemBirdBathID;
	int itemStonePathID;
	int itemWhiteFenceID;
	int itemTapID;
	int itemMailBoxID;
	int itemEnvelopeID;
	int itemPackageID;
	//int itemLetterID;
	//int itemLetterLockedID;
	int itemHammerID;
	//int itemTVID;
	//int itemComputerID;
	//int itemPrinterID;
	//int itemStereoID;
	//int itemCeilingLightID;
	//int itemDoorBellID;

	int ovenOverheadID;
	int ovenID;
	int bedsideCabinetID;
	int coffeeTableStoneID;
	int tableStoneID;
	int chairStoneID;
	int lampOnID;
	int lampOffID;
	int coffeeTableWoodID;
	int tableWoodID;
	int chairWoodID;
	int freezerID;
	int fridgeID;
	int cabinetID;
	int couchWhiteID;
	int couchGreenID;
	int couchBrownID;
	int couchRedID;
	int couchBlackID;
	int carpetID;
	int blindsID;
	int blindsClosedID;
	int curtainsID;
	int curtainsClosedID;
	int hedgeID;
	int birdBathID;
	int stonePathID;
	int whiteFenceID;
	int tapID;
	int mailBoxID;
	//int TVID;
	//int computerID;
	//int printerID;
	//int stereoID;
	//int ceilingLightID;
	//int doorBellID;

	public static Item itemTableWood;
	public static Item itemTableStone;
	public static Item itemChairWood;
	public static Item itemChairStone;
	public static Item itemCabinet;
	public static Item itemCoffeeTableWood;
	public static Item itemCoffeeTableStone;
	public static Item itemFridge;
	public static Item itemCouchWhite;
	public static Item itemCouchGreen;
	public static Item itemCouchBrown;
	public static Item itemCouchRed;
	public static Item itemCouchBlack;
	public static Item itemBlinds;
	public static Item itemCurtains;
	public static Item itemCarpetWhite;
	public static Item itemCarpetGreen;
	public static Item itemCarpetBrown;
	public static Item itemCarpetRed;
	public static Item itemCarpetBlack;
	public static Item itemLamp;
	public static Item itemBedsideCabinet;
	public static Item itemCoolPack;
	public static Item itemSlidingDoor;
	public static Item itemOven;
	public static Item itemOvenOverhead;
	public static Item itemFlesh;
	public static Item itemCookedFlesh;
	public static Item itemHedgeBasic;
	public static Item itemHedgeSpruce;
	public static Item itemHedgeBirch;
	public static Item itemHedgeJungle;
	public static Item itemBirdBath;
	public static Item itemStonePath;
	public static Item itemWhiteFence;
	public static Item itemTap;
	public static Item itemMailBox;
	public static Item itemEnvelope;
	public static Item itemPackage;
	//public static Item itemLetter;
	//public static Item itemLetterLocked;
	public static Item itemHammer;
	//public static Item itemTV;
	//public static Item itemComputer;
	//public static Item itemPrinter;
	//public static Item itemStereo;
	//public static Item itemCeilingLight;
	//public static Item itemDoorBell;

	public static Block lampOn;
	public static Block lampOff;
	public static Block coffeeTableWood;
	public static Block coffeeTableStone;
	public static Block tableWood;
	public static Block tableStone;
	public static Block chairWood;
	public static Block chairStone;
	public static Block freezer;
	public static Block fridge;
	public static Block cabinet;
	public static Block couchWhite;
	public static Block couchGreen;
	public static Block couchBrown;
	public static Block couchRed;
	public static Block couchBlack;
	public static Block carpet;
	public static Block blinds;
	public static Block blindsClosed;
	public static Block curtains;
	public static Block curtainsClosed;
	public static Block bedsideCabinet;
	public static Block oven;
	public static Block ovenOverhead;
	public static Block hedge;
	public static Block birdBath;
	public static Block stonePath;
	public static Block whiteFence;
	public static Block tap;
	public static Block mailBox;
	//public static Block TV;
	//public static Block computer;
	//public static Block printer;
	//public static Block stereo;
	//public static Block ceilingLight;
	//public static Block doorBell;
	
	//public static Block hey;
	//public static Block nyan;
	//public static Block creeper;

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		itemBedsideCabinetID = config.getItem("ItemBedsideCabinet", 23000).getInt();
		itemTableWoodID = config.getItem("ItemTableWood", 23001).getInt();
		itemChairWoodID = config.getItem("ItemChairWood", 23002).getInt();
		itemCabinetID = config.getItem("ItemCabinet", 23003).getInt();
		itemCoffeeTableWoodID = config.getItem("ItemCoffeeTableWood", 23004).getInt();
		itemFridgeID = config.getItem("ItemFridge", 23005).getInt();
		itemCouchWhiteID = config.getItem("ItemCouchWhite", 23006).getInt();
		itemCouchGreenID = config.getItem("ItemCouchGreen", 23007).getInt();
		itemCouchBrownID = config.getItem("ItemCouchBrown", 23008).getInt();
		itemCouchRedID = config.getItem("ItemCouchRed", 23009).getInt();
		itemCouchBlackID = config.getItem("ItemCouchBlack", 23010).getInt();
		itemBlindsID = config.getItem("ItemBlinds", 23011).getInt();
		itemCurtainsID = config.getItem("ItemCurtains", 23012).getInt();
		itemCarpetWhiteID = config.getItem("ItemCarpetWhite", 23013).getInt();
		itemCarpetGreenID = config.getItem("ItemCarpetGreen", 23014).getInt();
		itemCarpetBrownID = config.getItem("ItemCarpetBrown", 23015).getInt();
		itemCarpetRedID = config.getItem("ItemCarpetRed", 23016).getInt();
		itemCarpetBlackID = config.getItem("ItemCarpetBlack", 23017).getInt();
		itemLampID = config.getItem("ItemLamp", 23018).getInt();
		itemCoolPackID = config.getItem("ItemCoolPack", 23019).getInt();
		itemChairStoneID = config.getItem("ItemChairStone", 23020).getInt();
		itemTableStoneID = config.getItem("ItemTableStone", 23021).getInt();
		itemCoffeeTableStoneID = config.getItem("ItemCoffeeTableStone", 23022).getInt();
		itemOvenID = config.getItem("ItemOven", 23023).getInt();
		itemOvenOverheadID = config.getItem("ItemOvenOverhead", 23024).getInt();
		itemFleshID = config.getItem("ItemFlesh", 23025).getInt();
		itemCookedFleshID = config.getItem("ItemCookedFlesh", 23026).getInt();
		itemHedgeBasicID = config.getItem("ItemHedgeBasic", 23027).getInt();
		itemHedgeSpruceID = config.getItem("ItemHedgeSpruce", 23028).getInt();
		itemHedgeBirchID = config.getItem("ItemHedgeBirch", 23029).getInt();
		itemHedgeJungleID = config.getItem("ItemHedgeJungle", 23030).getInt();
		itemBirdBathID = config.getItem("ItemBirdBath", 23031).getInt();
		itemStonePathID = config.getItem("ItemStonePath", 23032).getInt();
		itemWhiteFenceID = config.getItem("ItemWhiteFence", 23033).getInt();
		itemTapID = config.getItem("ItemTap", 23034).getInt();
		itemMailBoxID = config.getItem("ItemMailBox", 23035).getInt();
		itemEnvelopeID = config.getItem("ItemEnvelope", 23036).getInt();
		itemPackageID = config.getItem("ItemPackage", 23037).getInt();
		//itemLetterID = config.getItem("ItemLetter", 23038).getInt();
		//itemLetterLockedID = config.getItem("ItemLetterLocked", 23039).getInt();
		itemHammerID = config.getItem("ItemHammer", 23040).getInt();
		//itemTVID = config.getItem("ItemTV", 23041).getInt();
		//itemComputerID = config.getItem("ItemComputer", 23042).getInt();
		//itemPrinterID = config.getItem("ItemPrinter", 23043).getInt();
		//itemStereoID = config.getItem("ItemStereo", 23044).getInt();
		//itemCeilingLightID = config.getItem("ItemCeilingLight", 23045).getInt();
		//itemDoorBellID = config.getItem("ItemDoorBell", 23046).getInt();

		ovenOverheadID = config.getBlock("BlockOvenOverhead", 500).getInt();
		ovenID = config.getBlock("BlockOven", 501).getInt();
		bedsideCabinetID = config.getBlock("BlockBedsideCabinet", 502).getInt();
		coffeeTableStoneID = config.getBlock("BlockCoffeTableStone", 503).getInt();
		tableStoneID = config.getBlock("BlockTableStone", 504).getInt();
		chairStoneID = config.getBlock("BlockChairStone", 505).getInt();
		lampOnID = config.getBlock("BlockLampOn", 506).getInt();
		lampOffID = config.getBlock("BlockLampOff", 507).getInt();
		coffeeTableWoodID = config.getBlock("BlockCoffeeTableWood", 508).getInt();
		tableWoodID = config.getBlock("BlockTableWood", 509).getInt();
		chairWoodID = config.getBlock("BlockChairWood", 510).getInt();
		freezerID = config.getBlock("BlockFreezer", 511).getInt();
		fridgeID = config.getBlock("BlockFridge", 512).getInt();
		cabinetID = config.getBlock("BlockCabinet", 513).getInt();
		couchWhiteID = config.getBlock("BlockCouchWhite", 514).getInt();
		couchGreenID = config.getBlock("BlockCouchGreen", 515).getInt();
		couchBrownID = config.getBlock("BlockCouchBrown", 516).getInt();
		couchRedID = config.getBlock("BlockCouchRed", 517).getInt();
		couchBlackID = config.getBlock("BlockCouchBlack", 518).getInt();
		carpetID = config.getBlock("BlockCarpet", 519).getInt();
		blindsID = config.getBlock("BlockBlinds", 520).getInt();
		blindsClosedID = config.getBlock("BlockBlindsClosed", 521).getInt();
		curtainsID = config.getBlock("BlockCurtains", 522).getInt();
		curtainsClosedID = config.getBlock("BlockCurtainsClosed", 523).getInt();
		hedgeID = config.getBlock("BlockHedge", 524).getInt();
		birdBathID = config.getBlock("BlockBirdBath", 525).getInt();
		stonePathID = config.getBlock("BlockStonePath", 526).getInt();
		whiteFenceID = config.getBlock("BlockWhiteFence", 527).getInt();
		tapID = config.getBlock("BlockTap", 528).getInt();
		mailBoxID = config.getBlock("BlockMailBox", 529).getInt();
		//TVID = config.getBlock("BlockTV", 530).getInt();
		//computerID = config.getBlock("BlockComputer", 531).getInt();
		//printerID = config.getBlock("BlockPrinter", 532).getInt();
		//stereoID = config.getBlock("BlockStereo", 533).getInt();
		//ceilingLightID = config.getBlock("BlockCeilingLight", 534).getInt();
		//doorBellID = config.getBlock("BlockDoorBell", 535).getInt();
		config.save();
		
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		
		//Items & Blocks
		itemTableWood = new ItemBlockCustom(itemTableWoodID, tableWoodID, 1).setUnlocalizedName("itemtablewood").setCreativeTab(this.tabFurniture);
		itemTableStone = new ItemBlockCustom(itemTableStoneID, tableStoneID, 2).setUnlocalizedName("itemtablestone").setCreativeTab(this.tabFurniture);
		itemChairWood = new ItemChair(itemChairWoodID, chairWoodID).setUnlocalizedName("itemchairwood").setCreativeTab(this.tabFurniture);
		itemChairStone = new ItemChair(itemChairStoneID, chairStoneID).setUnlocalizedName("itemchairstone").setCreativeTab(this.tabFurniture);
		itemCabinet = new ItemOven(itemCabinetID, cabinetID).setUnlocalizedName("itemcabinet").setCreativeTab(this.tabFurniture);
		itemCoffeeTableWood = new ItemBlockCustom(itemCoffeeTableWoodID, coffeeTableWoodID, 1).setUnlocalizedName("itemcoffeetablewood").setCreativeTab(this.tabFurniture);
		itemCoffeeTableStone = new ItemBlockCustom(itemCoffeeTableStoneID, coffeeTableStoneID, 2).setUnlocalizedName("itemcoffeetablestone").setCreativeTab(this.tabFurniture);
		itemFridge = new ItemFridge(itemFridgeID).setUnlocalizedName("itemfridge").setCreativeTab(this.tabFurniture);
		itemCouchWhite = new ItemCouch(itemCouchWhiteID, couchWhiteID).setUnlocalizedName("cfm:itemcouchwhite").setCreativeTab(this.tabFurniture);
		itemCouchGreen = new ItemCouch(itemCouchGreenID, couchGreenID).setUnlocalizedName("itemcouchgreen").setCreativeTab(this.tabFurniture);
		itemCouchBrown = new ItemCouch(itemCouchBrownID, couchBrownID).setUnlocalizedName("itemcouchbrown").setCreativeTab(this.tabFurniture);
		itemCouchRed = new ItemCouch(itemCouchRedID, couchRedID).setUnlocalizedName("itemcouchred").setCreativeTab(this.tabFurniture);
		itemCouchBlack = new ItemCouch(itemCouchBlackID, couchBlackID).setUnlocalizedName("itemcouchblack").setCreativeTab(this.tabFurniture);
		itemBlinds = new ItemOven(itemBlindsID, blindsID).setUnlocalizedName("itemblinds").setCreativeTab(this.tabFurniture);
		itemCurtains = new ItemOven(itemCurtainsID, curtainsID).setUnlocalizedName("itemcurtains").setCreativeTab(this.tabFurniture);
		itemCarpetWhite = new ItemCarpet(itemCarpetWhiteID, 4).setUnlocalizedName("itemcarpetwhite").setCreativeTab(this.tabFurniture);
		itemCarpetGreen = new ItemCarpet(itemCarpetGreenID, 5).setUnlocalizedName("itemcarpetgreen").setCreativeTab(this.tabFurniture);
		itemCarpetBrown = new ItemCarpet(itemCarpetBrownID, 2).setUnlocalizedName("itemcarpetbrown").setCreativeTab(this.tabFurniture);
		itemCarpetRed = new ItemCarpet(itemCarpetRedID, 3).setUnlocalizedName("itemcarpetred").setCreativeTab(this.tabFurniture);
		itemCarpetBlack = new ItemCarpet(itemCarpetBlackID, 1).setUnlocalizedName("itemcarpetblack").setCreativeTab(this.tabFurniture);
		itemLamp = new ItemBlockCustom(itemLampID, lampOffID, 0).setUnlocalizedName("itemlamp").setCreativeTab(this.tabFurniture);
		itemBedsideCabinet = new ItemBlockCustom(itemBedsideCabinetID, bedsideCabinetID, 0).setUnlocalizedName("itembedsidecabinet").setCreativeTab(this.tabFurniture);
		itemCoolPack = new ItemFurniture(itemCoolPackID).setUnlocalizedName("itemcoolpack").setCreativeTab(this.tabFurniture);
		itemOven = new ItemOven(itemOvenID, ovenID).setUnlocalizedName("itemoven").setCreativeTab(this.tabFurniture);
		itemOvenOverhead = new ItemOven(itemOvenOverheadID, ovenOverheadID).setUnlocalizedName("itemovenoverhead").setCreativeTab(this.tabFurniture);
		itemFlesh = new ItemFurnitureFood(itemFleshID, 2, false).setUnlocalizedName("itemflesh").setCreativeTab(this.tabFurniture);
		itemCookedFlesh = new ItemFurnitureFood(itemCookedFleshID, 4, false).setUnlocalizedName("itemfleshcooked").setCreativeTab(this.tabFurniture);
		itemHedgeBasic = new ItemBlockCustom(itemHedgeBasicID, hedgeID, 0).setUnlocalizedName("itemhedgebasic").setCreativeTab(this.tabFurniture);
		itemHedgeSpruce = new ItemBlockCustom(itemHedgeSpruceID, hedgeID, 1).setUnlocalizedName("itemhedgespruce").setCreativeTab(this.tabFurniture);
		itemHedgeBirch = new ItemBlockCustom(itemHedgeBirchID, hedgeID, 2).setUnlocalizedName("itemhedgebirch").setCreativeTab(this.tabFurniture);
		itemHedgeJungle = new ItemBlockCustom(itemHedgeJungleID, hedgeID, 3).setUnlocalizedName("itemhedgejungle").setCreativeTab(this.tabFurniture);
		itemBirdBath = new ItemBlockCustom(itemBirdBathID, birdBathID, 0).setUnlocalizedName("itembirdbath").setCreativeTab(this.tabFurniture);
		itemStonePath = new ItemBlockCustom(itemStonePathID, stonePathID, 2).setUnlocalizedName("itemstonepath").setCreativeTab(this.tabFurniture);
		itemWhiteFence = new ItemBlockCustom(itemWhiteFenceID, whiteFenceID, 0).setUnlocalizedName("itemwhitefence").setCreativeTab(this.tabFurniture);
		itemTap = new ItemOven(itemTapID, tapID).setUnlocalizedName("itemtap").setCreativeTab(this.tabFurniture);
		itemMailBox = new ItemOven(itemMailBoxID, mailBoxID).setUnlocalizedName("itemmailbox").setCreativeTab(this.tabFurniture);
		itemEnvelope = new ItemEnvelope(itemEnvelopeID).setUnlocalizedName("itemenvelope").setCreativeTab(this.tabFurniture);
		itemPackage = new ItemPackage(itemPackageID).setUnlocalizedName("itempackage").setCreativeTab(this.tabFurniture);
		//itemLetter = new ItemLetter(itemLetterID).setUnlocalizedName("itemletter").setCreativeTab(this.tabFurniture);
		//itemLetterLocked = new ItemLetterLocked(itemLetterLockedID).setUnlocalizedName("itemletter").setCreativeTab(this.tabFurniture);
		itemHammer = new ItemHammer(itemHammerID).setUnlocalizedName("itemhammer").setCreativeTab(this.tabFurniture);
		//itemTV = new ItemOven(itemTVID, TVID).setUnlocalizedName("itemtv").setCreativeTab(this.tabFurniture);
		//itemComputer = new ItemOven(itemComputerID, computerID).setUnlocalizedName("itemcomputer").setCreativeTab(this.tabFurniture);
		//itemPrinter = new ItemOven(itemPrinterID, printerID).setUnlocalizedName("itemprinter").setCreativeTab(this.tabFurniture);
		//itemStereo = new ItemOven(itemStereoID, stereoID).setUnlocalizedName("itemstereo").setCreativeTab(this.tabFurniture);
		//itemCeilingLight = new ItemLight(itemCeilingLightID).setUnlocalizedName("itemceilinglight").setCreativeTab(this.tabFurniture);
		//itemDoorBell = new ItemOven(itemDoorBellID, doorBellID).setUnlocalizedName("itemdoorbell").setCreativeTab(this.tabFurniture);
	}

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		ClientProxyFurniture.setCustomRenderers();
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityOven.class, "Oven");
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityFridge.class, "Fridge");
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityCabinet.class, "Cabinet");
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityFreezer.class, "Freezer");
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityBedsideCabinet.class, "Bedside Cabinet");
		GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityMailBox.class, "Mail Box");
		//GameRegistry.registerTileEntity(com.mrcrayfish.furniture.TileEntityTV.class, "TV");
		EntityRegistry.registerModEntity(EntityMountableBlock.class, "Mountable Block", 101, this, 250, 5, false);
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		lampOn = new BlockLampOn(lampOnID, Material.glass).setUnlocalizedName("obsidian").setLightValue(1.0F).setHardness(0.75F).setStepSound(Block.soundClothFootstep);
		lampOff = new BlockLampOff(lampOffID, Material.glass).setUnlocalizedName("obsidian").setHardness(0.75F).setStepSound(Block.soundClothFootstep);
		coffeeTableWood = new BlockCoffeeTable(coffeeTableWoodID, Material.wood).setUnlocalizedName("wood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		coffeeTableStone = new BlockCoffeeTable(coffeeTableStoneID, Material.rock).setUnlocalizedName("stonebrick").setHardness(1.5F).setStepSound(Block.soundStoneFootstep);
		tableWood = new BlockTable(tableWoodID, Material.wood).setUnlocalizedName("wood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		tableStone = new BlockTable(tableStoneID, Material.rock).setUnlocalizedName("stonebrick").setHardness(1.5F).setStepSound(Block.soundStoneFootstep);
		chairWood = new BlockChair(chairWoodID, 0, Material.wood).setUnlocalizedName("wood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		chairStone = new BlockChair(chairStoneID, 0, Material.rock).setUnlocalizedName("stonebrick").setHardness(1.5F).setStepSound(Block.soundStoneFootstep);
		freezer = new BlockFreezer(freezerID, false).setUnlocalizedName("blockIron").setHardness(2.0F).setStepSound(Block.soundMetalFootstep);
		fridge = new BlockFridge(fridgeID).setUnlocalizedName("blockIron").setHardness(2.0F).setStepSound(Block.soundMetalFootstep);
		cabinet = new BlockCabinet(cabinetID, Material.wood).setUnlocalizedName("wood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		couchWhite = new BlockCouch(couchWhiteID, 0, Material.cloth).setUnlocalizedName("cloth_0").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		couchGreen = new BlockCouch(couchGreenID, 0, Material.cloth).setUnlocalizedName("cloth_13").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		couchBrown = new BlockCouch(couchBrownID, 0, Material.cloth).setUnlocalizedName("cloth_12").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		couchRed = new BlockCouch(couchRedID, 0, Material.cloth).setUnlocalizedName("cloth_14").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		couchBlack = new BlockCouch(couchBlackID, 0, Material.cloth).setUnlocalizedName("cloth_15").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		carpet = new BlockCarpet(carpetID, Material.cloth).setUnlocalizedName("cloth_0").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		blinds = new BlockWindowDecoration(blindsID, Material.wood).setUnlocalizedName("wood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep);
		blindsClosed = new BlockWindowDecorationClosed(blindsClosedID, Material.glass).setUnlocalizedName("wood").setHardness(0.5F).setStepSound(Block.soundWoodFootstep);
		curtains = new BlockWindowDecoration(curtainsID, Material.cloth).setUnlocalizedName("cloth_14").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		curtainsClosed = new BlockWindowDecorationClosed(curtainsClosedID, Material.cloth).setUnlocalizedName("cloth_14").setHardness(0.5F).setStepSound(Block.soundClothFootstep);
		bedsideCabinet = new BlockBedsideCabinet(bedsideCabinetID, Material.wood).setUnlocalizedName("wood").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		oven = new BlockOven(ovenID, false).setUnlocalizedName("quartzblock_bottom").setHardness(1.0F).setStepSound(Block.soundMetalFootstep);
		ovenOverhead = new BlockOvenOverhead(ovenOverheadID, Material.rock).setUnlocalizedName("stoneslab_top").setHardness(0.5F).setStepSound(Block.soundMetalFootstep);;
		hedge = new BlockHedge(hedgeID).setUnlocalizedName("leaves").setHardness(0.2F).setStepSound(Block.soundGrassFootstep);
		birdBath = new BlockBirdBath(birdBathID, Material.rock).setUnlocalizedName("stone").setHardness(1.0F).setStepSound(Block.soundStoneFootstep);
		stonePath = new BlockStonePath(stonePathID, Material.rock).setUnlocalizedName("stone").setHardness(0.75F).setStepSound(Block.soundStoneFootstep);
		whiteFence = new BlockWhiteFence(whiteFenceID, Material.wood).setUnlocalizedName("quartzblock_bottom").setHardness(1.0F).setStepSound(Block.soundWoodFootstep);
		tap = new BlockTap(tapID, Material.rock).setUnlocalizedName("stone").setHardness(0.5F).setStepSound(Block.soundStoneFootstep);
		mailBox = new BlockMailBox(mailBoxID, Material.wood).setUnlocalizedName("wood").setStepSound(Block.soundWoodFootstep);
		//TV = new BlockTV(TVID, Material.wood).setUnlocalizedName("wood").setStepSound(Block.soundStoneFootstep);
		//doorBell = new BlockDoorBell(doorBellID, Material.wood).setUnlocalizedName("wood").setStepSound(Block.soundWoodFootstep);
		//hey = new Block(doorBellID + 1, Material.cake).setUnlocalizedName("hey").setCreativeTab(this.tabFurniture);
		//nyan = new Block(doorBellID + 2, Material.cake).setUnlocalizedName("nyan");
		//creeper = new Block(doorBellID + 3, Material.cake).setUnlocalizedName("creeper");
		
		//Names
		LanguageRegistry.addName(itemTableWood, "Wooden Table");
		LanguageRegistry.addName(itemTableStone, "Stone Table");
		LanguageRegistry.addName(itemChairWood, "Wooden Chair");
		LanguageRegistry.addName(itemChairStone, "Stone Chair");
		LanguageRegistry.addName(itemFridge, "Fridge");
		LanguageRegistry.addName(itemBlinds, "Blinds");
		LanguageRegistry.addName(itemCurtains, "Curtains");
		LanguageRegistry.addName(itemCouchWhite, "White Couch");
		LanguageRegistry.addName(itemCouchGreen, "Green Couch");
		LanguageRegistry.addName(itemCouchBrown, "Brown Couch");
		LanguageRegistry.addName(itemCouchRed, "Red Couch");
		LanguageRegistry.addName(itemCouchBlack, "Black Couch");
		LanguageRegistry.addName(itemCabinet, "Cabinet");
		LanguageRegistry.addName(itemCoolPack, "Cooling Pack");
		LanguageRegistry.addName(itemCoffeeTableWood, "Wooden Coffee Table");
		LanguageRegistry.addName(itemCoffeeTableStone, "Stone Coffee Table");
		LanguageRegistry.addName(itemCarpetWhite, "White Carpet");
		LanguageRegistry.addName(itemCarpetGreen, "Green Carpet");
		LanguageRegistry.addName(itemCarpetBrown, "Brown Carpet");
		LanguageRegistry.addName(itemCarpetRed, "Red Carpet");
		LanguageRegistry.addName(itemCarpetBlack, "Black Carpet");
		LanguageRegistry.addName(itemLamp, "Lamp");
		LanguageRegistry.addName(itemBedsideCabinet, "Bedside Cabinet");
		LanguageRegistry.addName(itemOven, "Oven");
		LanguageRegistry.addName(itemOvenOverhead, "Oven Overhead");
		LanguageRegistry.addName(itemFlesh, "Flesh");
		LanguageRegistry.addName(itemCookedFlesh, "Cooked Flesh");
		LanguageRegistry.addName(itemHedgeBasic, "Oak Hedge");
		LanguageRegistry.addName(itemHedgeSpruce, "Spruce Hedge");
		LanguageRegistry.addName(itemHedgeBirch, "Birch Hedge");
		LanguageRegistry.addName(itemHedgeJungle, "Jungle Hedge");
		LanguageRegistry.addName(itemBirdBath, "Bird Bath");
		LanguageRegistry.addName(itemStonePath, "Stone Path");
		LanguageRegistry.addName(itemWhiteFence, "White Fence");
		LanguageRegistry.addName(itemTap, "Tap");
		LanguageRegistry.addName(itemMailBox, "Mail Box");
		LanguageRegistry.addName(itemEnvelope, "Envelope");
		LanguageRegistry.addName(itemPackage, "Package");
		//LanguageRegistry.addName(itemLetter, "Letter");
		LanguageRegistry.addName(itemHammer, "Hammer");
		//LanguageRegistry.addName(itemTV, "TV");
		//LanguageRegistry.addName(itemComputer, "Computer");
		//LanguageRegistry.addName(itemPrinter, "Printer");
		//LanguageRegistry.addName(itemStereo, "Stereo");
		//LanguageRegistry.addName(itemCeilingLight, "Ceiling Light");
		//LanguageRegistry.addName(itemDoorBell, "Door Bell");

		LanguageRegistry.instance().addStringLocalization("itemGroup.tabFurniture", "en_US", "MrCrayfish's Furniture Mod");

		//Recipes
		GameRegistry.addRecipe(new ItemStack(itemTableWood, 1), new Object[]{"***", " * ", " * ", '*', Block.planks});
		GameRegistry.addRecipe(new ItemStack(itemTableStone, 1), new Object[]{"***", " * ", " * ", '*', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(itemChairWood, 1), new Object[]{"*  ", "***", "* *", '*', Block.planks});
		GameRegistry.addRecipe(new ItemStack(itemChairStone, 1), new Object[]{"*  ", "***", "* *", '*', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(itemCouchWhite, 1), new Object[]{"***", "***", '*', new ItemStack(Block.cloth, 1 , 0)});
		GameRegistry.addRecipe(new ItemStack(itemCouchGreen, 1), new Object[]{"***", "***", '*', new ItemStack(Block.cloth, 1 , 13)});
		GameRegistry.addRecipe(new ItemStack(itemCouchBrown, 1), new Object[]{"***", "***", '*', new ItemStack(Block.cloth, 1 , 12)});
		GameRegistry.addRecipe(new ItemStack(itemCouchRed, 1), new Object[]{"***", "***", '*', new ItemStack(Block.cloth, 1 , 14)});
		GameRegistry.addRecipe(new ItemStack(itemCouchBlack, 1), new Object[]{"***", "***", '*', new ItemStack(Block.cloth, 1 , 15)});
		GameRegistry.addRecipe(new ItemStack(itemFridge, 1), new Object[]{"***", "*#*", "*@*", '*', Block.blockIron, '#', Block.chest, '@', Block.furnaceIdle});
		GameRegistry.addRecipe(new ItemStack(itemCabinet, 1), new Object[]{"***", "*@*", "***", '*', Block.planks, '@', Block.chest});
		GameRegistry.addRecipe(new ItemStack(itemCurtains, 2), new Object[]{"@@@", "* *", "@ @", '*', Item.ingotGold, '@', new ItemStack(Block.cloth, 1 , 14)});
		GameRegistry.addRecipe(new ItemStack(itemBlinds, 2), new Object[]{"***", "***", "***", '*', Item.stick});
		GameRegistry.addRecipe(new ItemStack(itemCoolPack, 2), new Object[]{"***", "*@*", "***", '*', Block.glass, '@', Item.bucketWater});
		GameRegistry.addRecipe(new ItemStack(itemCoffeeTableWood, 1), new Object[]{"***", "* *", '*', Block.planks});
		GameRegistry.addRecipe(new ItemStack(itemCoffeeTableStone, 1), new Object[]{"***", "* *", '*', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(itemCarpetRed, 4), new Object[]{"**", '*', new ItemStack(Block.cloth, 1 , 14)});
		GameRegistry.addRecipe(new ItemStack(itemCarpetBrown, 4), new Object[]{"**", '*', new ItemStack(Block.cloth, 1 , 12)});
		GameRegistry.addRecipe(new ItemStack(itemCarpetGreen, 4), new Object[]{"**", '*', new ItemStack(Block.cloth, 1 , 13)});
		GameRegistry.addRecipe(new ItemStack(itemCarpetWhite, 4), new Object[]{"**", '*', new ItemStack(Block.cloth, 1 , 0)});
		GameRegistry.addRecipe(new ItemStack(itemCarpetBlack, 4), new Object[]{"**", '*', new ItemStack(Block.cloth, 1 , 15)});
		GameRegistry.addRecipe(new ItemStack(itemLamp, 2), new Object[]{"***", "*@*", " & ", '*', Block.cloth, '@', Block.glowStone, '&', Block.obsidian});
		GameRegistry.addRecipe(new ItemStack(itemBedsideCabinet, 1), new Object[] {"***", "*@*", "*@*", '*', Block.planks, '@', Block.chest});
		GameRegistry.addRecipe(new ItemStack(itemOven, 1), new Object[] {"***", "*@*", "***", '*', Block.blockIron, '@', Block.furnaceIdle});
		GameRegistry.addRecipe(new ItemStack(itemOvenOverhead, 1), new Object[] {" * ", " * ", "*@*", '*', itemBedsideCabinet.ingotIron, '@', Block.glowStone});
		GameRegistry.addRecipe(new ItemStack(itemHedgeBasic, 4), new Object[] {"***", "***", '*', new ItemStack(Block.leaves, 1 , 0)});
		GameRegistry.addRecipe(new ItemStack(itemHedgeSpruce, 4), new Object[] {"***", "***", '*', new ItemStack(Block.leaves, 1 , 1)});
		GameRegistry.addRecipe(new ItemStack(itemHedgeBirch, 4), new Object[] {"***", "***", '*', new ItemStack(Block.leaves, 1 , 2)});
		GameRegistry.addRecipe(new ItemStack(itemHedgeJungle, 4), new Object[] {"***", "***", '*', new ItemStack(Block.leaves, 1 , 3)});
		GameRegistry.addRecipe(new ItemStack(itemBirdBath, 1), new Object[] {"***", " * ", " * ", '*', Block.stone});
		GameRegistry.addRecipe(new ItemStack(itemStonePath, 8), new Object[] {"**", '*', Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(itemTap, 1), new Object[] {" @ ","***", "  *", '*', Block.stone, '@', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(itemMailBox, 1), new Object[] {"*@*", "***", " * ", '*', Block.planks, '@', Item.book});
		GameRegistry.addShapelessRecipe(new ItemStack(itemWhiteFence, 2), Block.fence, new ItemStack(Item.dyePowder, 1, 15));

		GameRegistry.addSmelting(this.itemFlesh.itemID, new ItemStack(this.itemCookedFlesh), 0.05F);
		
		//GameRegistry.registerBlock(hey, "BlockHey");
		
		OvenRecipesAPI.instance().addFoodToOvenRecipes(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(Item.potato.itemID, new ItemStack(Item.bakedPotato));
		OvenRecipesAPI.instance().addFoodToOvenRecipes(MrCrayfishFurnitureMod.itemFlesh.itemID, new ItemStack(MrCrayfishFurnitureMod.itemCookedFlesh));
		
		FreezerRecipesAPI.instance().addSolidifying(Item.bucketLava.itemID, new ItemStack(Block.obsidian));
		FreezerRecipesAPI.instance().addSolidifying(Item.bucketWater.itemID, new ItemStack(Block.ice));
		FreezerRecipesAPI.instance().addSolidifying(Item.slimeBall.itemID, new ItemStack(Item.snowball));
		FreezerRecipesAPI.instance().addSolidifying(Item.poisonousPotato.itemID, new ItemStack(Item.potato));
		FreezerRecipesAPI.instance().addSolidifying(Item.rottenFlesh.itemID, new ItemStack(MrCrayfishFurnitureMod.itemFlesh));
		
	}

	public static CreativeTabs tabFurniture = new CreativeTabs("tabFurniture") 
	{
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(MrCrayfishFurnitureMod.itemChairWood, 1, 0);
		}
	};

	/*public Entity spawnEntity(int entityId, World worldClient, double x, double y, double z) 
	{
		switch (entityId) 
		{
		case 101:
			return new EntityMountableBlock(worldClient, x, y, z);
		default:
			return null;
		}
	}

	@Override
	public Packet23VehicleSpawn getSpawnPacket(Entity entity, int type) 
	{
		if (entity instanceof EntityMountableBlock)
			return new Packet23VehicleSpawn(entity, type);
		else
			return null;
	}*/
}
