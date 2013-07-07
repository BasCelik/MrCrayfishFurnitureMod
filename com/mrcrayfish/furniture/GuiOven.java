package com.mrcrayfish.furniture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiOven extends GuiContainer
{
    private TileEntityOven OvenInventory;
    private static final ResourceLocation gui = new ResourceLocation("textures/gui/oven.png");

    public GuiOven(InventoryPlayer inventoryplayer, TileEntityOven tileEntityFreezer)
    {
        super(new ContainerOven(inventoryplayer, tileEntityFreezer));
        this.OvenInventory = tileEntityFreezer;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	this.fontRenderer.drawString("Oven", 75, 6, 4210752);
    	this.fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.func_110434_K().func_110577_a(gui);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        this.drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        int var7;
        
        var7 = this.OvenInventory.getCookProgressScaled(24);
        drawTexturedModalRect(l + 75, i1 + 20, 176, 14, var7 + 1, 16);
        drawTexturedModalRect(l + 66, (i1 + 40), 176, 0, 14, 14);
        drawTexturedModalRect(l + 81, (i1 + 40), 176, 0, 14, 14);
        drawTexturedModalRect(l + 96, (i1 + 40), 176, 0, 14, 14);
    }
}
