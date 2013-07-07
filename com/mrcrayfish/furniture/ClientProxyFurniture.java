package com.mrcrayfish.furniture;

import com.mrcrayfish.furniture.CommonProxyFurniture;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyFurniture extends CommonProxyFurniture 
{
	public static int renderPass;
	
	public static int renderTable;
	public static int renderChair;
	public static int renderCouch;
	public static int renderWindowDecoration;
	public static int renderCoffeeTable;
	public static int renderCarpet;
	public static int renderFridge;
	public static int renderCabinet;
	public static int renderLamp;
	public static int renderBedsideCabinet;
	public static int renderOven;
	public static int renderOvenOverhead;
	public static int renderHedge;
	public static int renderBirdBath;
	public static int renderStonePath;
	public static int renderWhiteFence;
	public static int renderTap;
	public static int renderMailBox;
	public static int renderTV;
	public static int renderComputer;
	public static int renderPrinter;
	public static int renderStereo;
	public static int renderCeilingLight;
	public static int renderStrobeLight;
	public static int renderDoorBell;
	
	@Override
	public void registerRenderThings()
	{
		
	}
	
	public static void setCustomRenderers()
	{
		renderTable = RenderingRegistry.getNextAvailableRenderId();
		renderChair = RenderingRegistry.getNextAvailableRenderId();
		renderCouch = RenderingRegistry.getNextAvailableRenderId();
		renderWindowDecoration = RenderingRegistry.getNextAvailableRenderId();
		renderCoffeeTable = RenderingRegistry.getNextAvailableRenderId();
		renderCarpet = RenderingRegistry.getNextAvailableRenderId();
		renderFridge = RenderingRegistry.getNextAvailableRenderId();
		renderCabinet = RenderingRegistry.getNextAvailableRenderId();
		renderLamp = RenderingRegistry.getNextAvailableRenderId();
		renderBedsideCabinet = RenderingRegistry.getNextAvailableRenderId();
		renderOven = RenderingRegistry.getNextAvailableRenderId();
		renderOvenOverhead = RenderingRegistry.getNextAvailableRenderId();		
		renderHedge = RenderingRegistry.getNextAvailableRenderId();	
		renderBirdBath = RenderingRegistry.getNextAvailableRenderId();	
		renderStonePath = RenderingRegistry.getNextAvailableRenderId();	
		renderWhiteFence = RenderingRegistry.getNextAvailableRenderId();	
		renderTap = RenderingRegistry.getNextAvailableRenderId();	
		renderMailBox = RenderingRegistry.getNextAvailableRenderId();
		renderTV = RenderingRegistry.getNextAvailableRenderId();
		renderComputer = RenderingRegistry.getNextAvailableRenderId();
		renderPrinter = RenderingRegistry.getNextAvailableRenderId();
		renderStereo = RenderingRegistry.getNextAvailableRenderId();
		renderCeilingLight = RenderingRegistry.getNextAvailableRenderId();
		renderStrobeLight = RenderingRegistry.getNextAvailableRenderId();
		renderDoorBell = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderTable, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderChair, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderCouch, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderWindowDecoration, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderCoffeeTable, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderCarpet, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderFridge, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderCabinet, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderLamp, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderBedsideCabinet, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderOven, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderOvenOverhead, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderHedge, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderBirdBath, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderStonePath, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderWhiteFence, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderTap, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderMailBox, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderTV, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderComputer, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderPrinter, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderStereo, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderCeilingLight, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderStrobeLight, new FurnitureRenderer());
		RenderingRegistry.registerBlockHandler(renderDoorBell, new FurnitureRenderer());
	}
}
