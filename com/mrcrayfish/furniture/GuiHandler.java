package com.mrcrayfish.furniture;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityFridge)
		{
			return new ContainerFridge(player.inventory, (TileEntityFridge) tile_entity);
		}
		if(tile_entity instanceof TileEntityFreezer)
		{
			return new ContainerFreezer(player.inventory, (TileEntityFreezer) tile_entity);
		}
		if(tile_entity instanceof TileEntityCabinet)
		{
			return new ContainerCabinet(player.inventory, (TileEntityCabinet) tile_entity);
		}
		if(tile_entity instanceof TileEntityBedsideCabinet)
		{
			return new ContainerBedsideCabinet(player.inventory, (TileEntityBedsideCabinet) tile_entity);
		}
		if(tile_entity instanceof TileEntityOven)
		{
			return new ContainerOven(player.inventory, (TileEntityOven) tile_entity);
		}
		if(tile_entity instanceof TileEntityMailBox)
		{
			return new ContainerMailBox(player.inventory, (TileEntityMailBox) tile_entity);
		}
		if(id == 5)
		{
			return new ContainerEnvelope(player.inventory, ItemEnvelope.getInv(player));
		}
		if(id == 6)
		{
			return new ContainerPackage(player.inventory, ItemPackage.getInv(player));
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityFridge)
		{
			return new GuiFridge(player.inventory, (TileEntityFridge) tile_entity);
		}
		if(tile_entity instanceof TileEntityFreezer)
		{
			return new GuiFreezer(player.inventory, (TileEntityFreezer) tile_entity);
		}
		if(tile_entity instanceof TileEntityCabinet)
		{
			return new GuiCabinet(player.inventory, (TileEntityCabinet) tile_entity);
		}
		if(tile_entity instanceof TileEntityBedsideCabinet)
		{
			return new GuiBedsideCabinet(player.inventory, (TileEntityBedsideCabinet) tile_entity);
		}
		if(tile_entity instanceof TileEntityOven)
		{
			return new GuiOven(player.inventory, (TileEntityOven) tile_entity);
		}
		if(tile_entity instanceof TileEntityMailBox && id == 0)
		{
			return new GuiMailBox(player.inventory, (TileEntityMailBox) tile_entity);
		}
		if(id == 5)
		{
			return new GuiEnvelope(player.inventory, ItemEnvelope.getInv(player));
		}
		if(id == 6)
		{
			return new GuiPackage(player.inventory, ItemPackage.getInv(player));
		}
		return null;
	}
}