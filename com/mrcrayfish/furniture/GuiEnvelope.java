package com.mrcrayfish.furniture;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.CreativeCrafting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEnvelope extends GuiContainer
{
	private static final ResourceLocation gui = new ResourceLocation("textures/gui/envelope.png");
	
	public GuiEnvelope(InventoryPlayer inventoryplayer, IInventory inventoryMail)
	{
		super(new ContainerEnvelope(inventoryplayer, inventoryMail));
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRenderer.drawString("Envelope", xSize / 2 - 22, 5, 9999999);
		this.fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(gui);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		this.drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
	}
}
