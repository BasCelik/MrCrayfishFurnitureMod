package com.mrcrayfish.furniture;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.ENTITY;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FurnitureRenderer implements ISimpleBlockRenderingHandler 
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}

	@SideOnly(Side.CLIENT)
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,Block block, int modelId, RenderBlocks renderer) 
	{
		if(modelId == ClientProxyFurniture.renderBedsideCabinet)
		{
			renderer.renderAllFaces = true;
			double var1 = 0, var2 = 0, var3 = 0, var4 = 0, var5 = 0, var6 = 0, var7 = 0, var8 = 0;
			
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				var1 = 0.0F; var2 = 0.125F; var3 = 0.0625F; var4 = 0.875F; var5 = -0.03F; var6 = 0.375F; var7 = 0.0625; var8 = 0.625F;
			}
			if(world.getBlockMetadata(x, y, z) == 2)
			{
				var1 = 0.125F; var2 = 0.0F; var3 = 0.875; var4 = 0.0625; var5 = 0.375; var6 = -0.03F; var7 = 0.625F; var8 = 0.0625;
			}
			if(world.getBlockMetadata(x, y, z) == 1)
			{
				var1 = 0.9375F; var2 = 0.125F; var3 = 1.0F; var4 = 0.875F; var5 = 1.0F; var6 = 0.375F; var7 = 1.03F; var8 = 0.625F;
			}			
			if(world.getBlockMetadata(x, y, z) == 3)
			{
				var1 = 0.125F; var2 = 0.9375F; var3 = 0.875; var4 = 1.0F; var5 = 0.375F; var6 = 0.375F; var7 = 0.625F; var8 = 1.03F;
			}
			
			//Draws
			renderer.overrideBlockTexture = Block.planks.getIcon(1, 1);
			renderer.setRenderBounds(var1, 0.125F, var2, var3, 0.4375F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(var1, 0.5625F, var2, var3, 0.870F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
			renderer.setRenderBounds(var5, 0.25F, var6, var7, 0.3125F, var8);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(var5, 0.6875F, var6, var7, 0.75F, var8);
			renderer.renderStandardBlock(block, x, y, z);
			
			//Base
			renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.0625F, 0.1F, 0.0625F, 0.9375F, 0.9F, 0.9375F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.wood.getBlockTextureFromSide(2);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.0F, 0.9F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return false;
		}
		if(modelId == ClientProxyFurniture.renderCabinet)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.planks.getIcon(1, 2);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F); //Base
			renderer.renderStandardBlock(block, x, y, z);
			if(world.getBlockMetadata(x, y, z) == 1)
			{
				renderer.overrideBlockTexture = Block.planks.getIcon(1, 1);
				renderer.setRenderBounds(0.5F, 0.0625F, 0.0625F, 1.0625F, 0.9375F, 0.9375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.9375F, 0.375F, 0.8125F, 1.1F, 0.75F, 0.875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.6875F, 0.75F, 1.1F, 0.75F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.375F, 0.75F, 1.1F, 0.4375F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 2)
			{
				renderer.overrideBlockTexture = Block.planks.getIcon(1, 1);
				renderer.setRenderBounds(0.0625F, 0.0625F, 0.5F, 0.9375F, 0.9375F, 1.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.125F, 0.375F, 0.9375F, 0.1875F, 0.75F, 1.1F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.375F, 0.9375F, 0.25F, 0.4375F, 1.1F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.6875F, 0.9375F, 0.25F, 0.75F, 1.1F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 3)
			{
				renderer.overrideBlockTexture = Block.planks.getIcon(1, 1);
				renderer.setRenderBounds(-0.0625F, 0.0625F, 0.0625F, 0.5F, 0.9375F, 0.9375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(-0.1F, 0.375F, 0.125F, 0.0625F, 0.75F, 0.1875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(-0.1F, 0.375F, 0.1875F, 0.0625F, 0.4375F, 0.25F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(-0.1F, 0.6875F, 0.1875F, 0.0625F, 0.75F, 0.25F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				renderer.overrideBlockTexture = Block.planks.getIcon(1, 1);
				renderer.setRenderBounds(0.0625F, 0.0625F, -0.0625F, 0.9375F, 0.9375F, 0.5F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.8125F, 0.375F, -0.1F, 0.875F, 0.75F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.375F, -0.1F, 0.8125F, 0.4375F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.6875F, -0.1F, 0.8125F, 0.75F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;	
		}
		if(modelId == ClientProxyFurniture.renderCarpet)
		{
			renderer.renderAllFaces = true;
			int l = world.getBlockMetadata(x, y, z);
			if(l == 1)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
			}
			if(l == 2)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 12);
			}
			if(l == 3)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
			}
			if(l == 4)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
			}
			if(l == 5)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 13);
			}
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 0.01F, 1F); //Base
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderChair)
		{
			int l = world.getBlockMetadata(x, y, z);

			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.chairWood.blockID) 
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
			}
			else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.chairStone.blockID)
			{
				renderer.overrideBlockTexture = Block.cobblestone.getBlockTextureFromSide(1);	
			}
			renderer.renderAllFaces = true;

			if(l == 0)
			{
				renderer.setRenderBounds(0.8F, 0.6F, 0.1F, 0.9F, 1.2F, 0.9F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}
			if (l == 1)
			{
				renderer.setRenderBounds(0.1F, 0.6F, 0.1F, 0.2F, 1.2F, 0.9F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}
			if (l == 2)
			{
				renderer.setRenderBounds(0.1F, 0.6F, 0.8F, 0.9F, 1.2F, 0.9F); //Back Rest (X+, ?, Y+, X+, ? , Y+)
				renderer.renderStandardBlock(block, x, y, z);
			}
			if (l == 3)
			{
				renderer.setRenderBounds(0.1F, 0.6F, 0.1F, 0.9F, 1.2F, 0.2F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.setRenderBounds(0.1F, 0.0F, 0.1F, 0.2F, 0.5F, 0.2F); //Leg
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.8F, 0.0F, 0.8F, 0.9F, 0.5F, 0.9F); //Leg
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.8F, 0.0F, 0.1F, 0.9F, 0.5F, 0.2F); //leg
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1F, 0.0F, 0.8F, 0.2F, 0.5F, 0.9F); //leg
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1F, 0F, 0.1F, 0.9F, 1.2F, 0.9F);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderCoffeeTable)
		{
			renderer.renderAllFaces = true;
			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.4F, 0.0F, 1F, 0.5F, 1F);
				renderer.renderStandardBlock(block, x, y, z);
				if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					//TOP LEFT
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM LEFT
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					//BOTTOM RIGHT
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//TOP RIGHT
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Right
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Left
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Left
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Behind
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				//Left && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				//All
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableWood.blockID)
				{

				}
				else
				{
					//TOP LEFT
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM LEFT
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM RIGHT
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//TOP RIGHT
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
			{
				renderer.overrideBlockTexture = Block.cobblestone.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.4F, 0.0F, 1F, 0.5F, 1F);
				renderer.renderStandardBlock(block, x, y, z);
				if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					//TOP LEFT
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM LEFT
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					//BOTTOM RIGHT
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//TOP RIGHT
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Right
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Left
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Left
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Behind
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				//Left && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				//All
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.coffeeTableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.coffeeTableStone.blockID)
				{

				}
				else
				{
					//TOP LEFT
					renderer.setRenderBounds(0.9F, 0.0F, 0.0F, 1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM LEFT
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.1F, 0.4F, 0.1F);
					renderer.renderStandardBlock(block, x, y, z);
					//BOTTOM RIGHT
					renderer.setRenderBounds(0.0F, 0.0F, 0.9F, 0.1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//TOP RIGHT
					renderer.setRenderBounds(0.9F, 0.0F, 0.9F, 1F, 0.4F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderCouch)
		{
			int l = world.getBlockMetadata(x, y, z);
			renderer.renderAllFaces = true;
			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.couchWhite.blockID)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
			} 
			else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.couchGreen.blockID)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 13);
			} 
			else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.couchBrown.blockID)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 12);
			} 
			else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.couchRed.blockID)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
			} 
			else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.couchBlack.blockID)
			{
				renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
			}
			if(l == 0) //Front
			{	
				if(world.isAirBlock(x, y, z - 1) && !world.isAirBlock(x, y, z + 1) && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(!world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1) && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
					renderer.renderStandardBlock(block, x, y, z);

				}
				else if(!world.isAirBlock(x, y, z - 1) | !world.isAirBlock(x, y, z + 1))
				{
					if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x - 1, y, z) == 2)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.75F, 0.75F, 1.2F, 1F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x - 1, y, z) == 3)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 0.75F, 1.2F, 0.25F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x - 1, y, z) == 0 | world.getBlockMetadata(x - 1, y, z) == 1 && !world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1))
						{
							renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x - 1, y, z) == 0 | world.getBlockMetadata(x - 1, y, z) == 1 && !world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1))
						{
							renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
				}
				else if (world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1))
				{
					if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x - 1, y, z) == 2)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.75F, 0.75F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x - 1, y, z) == 3)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 0.75F, 1.2F, 0.25F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else
						{
							renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
							renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
					else
					{
						renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Left
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F);//Arm Rest Right
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.6F, 0.0F, 1F, 1.2F, 1F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 2) //Right
			{
				if(world.isAirBlock(x + 1, y, z) && !world.isAirBlock(x - 1, y, z) && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.isAirBlock(x - 1, y, z) && !world.isAirBlock(x + 1, y, z) && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(!world.isAirBlock(x + 1, y, z) | !world.isAirBlock(x - 1, y, z))
				{
					if(world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x, y, z - 1) == 1)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 0.75F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x, y, z - 1) == 0)
						{
							renderer.setRenderBounds(0.75F, 0.6F, 0.0F, 1.0F, 1.2F, 0.75F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x, y, z - 1) == 2 | world.getBlockMetadata(x, y, z - 1) == 3 && !world.isAirBlock(x - 1, y, z) && world.isAirBlock(x + 1, y, z))
						{
							renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x, y, z - 1) == 2 | world.getBlockMetadata(x, y, z - 1) == 3 && !world.isAirBlock(x + 1, y, z) && world.isAirBlock(x - 1, y, z))
						{
							renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
				}
				else if (world.isAirBlock(x + 1, y, z) && world.isAirBlock(x - 1, y, z))
				{
					if(world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x, y, z - 1) == 1)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 0.75F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x, y, z - 1) == 0)
						{
							renderer.setRenderBounds(0.75F, 0.6F, 0.0F, 1.0F, 1.2F, 0.75F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else
						{
							renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
							renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
					else
					{
						renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Left
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F);//Arm Rest Right
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0F, 0.6F, 0.75F, 1F, 1.2F, 1F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}


			if(l == 1) //Behind
			{
				if(world.isAirBlock(x, y, z - 1) && !world.isAirBlock(x, y, z + 1) && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(!world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1) && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(!world.isAirBlock(x, y, z + 1) | !world.isAirBlock(x, y, z - 1))
				{
					if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x + 1, y, z) == 2)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.75F, 1F, 1.2F, 1F); //Base
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x + 1, y, z) == 3)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 1F, 1.2F, 0.25F); //Base
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x + 1, y, z) == 1 | world.getBlockMetadata(x + 1, y, z) == 0 && !world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1))
						{
							renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x + 1, y, z) == 1 | world.getBlockMetadata(x + 1, y, z) == 0 && !world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1))
						{
							renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
				}
				else if (world.isAirBlock(x, y, z - 1) && world.isAirBlock(x, y, z + 1))
				{
					if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x + 1, y, z) == 2)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.75F, 1.0F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x + 1, y, z) == 3)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 1.0F, 1.2F, 0.25F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else
						{
							renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
							renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
					else
					{
						renderer.setRenderBounds(-0.001F, 0.5F, 0.95F, 1.001F, 0.9F, 1.2F); //Arm Rest Left
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(-0.001F, 0.5F, -0.2F, 1.001F, 0.9F, 0.05F); //Arm Rest Right
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0F, 0.6F, 0.0F, 0.25F, 1.2F, 1.0F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 3) //Left
			{
				if(world.isAirBlock(x + 1, y, z) && !world.isAirBlock(x - 1, y, z) && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.isAirBlock(x - 1, y, z) && !world.isAirBlock(x + 1, y, z) && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchBlack.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchBrown.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchGreen.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchRed.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.couchWhite.blockID)
				{
					renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(!world.isAirBlock(x + 1, y, z) | !world.isAirBlock(x - 1, y, z))
				{
					if(world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x, y, z + 1) == 0)
						{
							renderer.setRenderBounds(0.75F, 0.6F, 0.25F, 1.0F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x, y, z + 1) == 1)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.25F, 0.25F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x, y, z + 1) == 2 | world.getBlockMetadata(x, y, z + 1) == 3 && !world.isAirBlock(x - 1, y, z) && world.isAirBlock(x + 1, y, z))
						{
							renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
						if(world.getBlockMetadata(x, y, z + 1) == 2 | world.getBlockMetadata(x, y, z + 1) == 3 && !world.isAirBlock(x + 1, y, z) && world.isAirBlock(x - 1, y, z))
						{
							renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
				}
				else if(world.isAirBlock(x + 1, y, z) && world.isAirBlock(x - 1, y, z))
				{
					if(world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchBlack.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchBrown.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchGreen.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchRed.blockID | world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.couchWhite.blockID)
					{
						if(world.getBlockMetadata(x, y, z + 1) == 0)
						{
							renderer.setRenderBounds(0.75F, 0.6F, 0.25F, 1.0F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else if(world.getBlockMetadata(x, y, z + 1) == 1)
						{
							renderer.setRenderBounds(0.0F, 0.6F, 0.25F, 0.25F, 1.2F, 1.0F); //Back Rest
							renderer.renderStandardBlock(block, x, y, z);
						}
						else
						{
							renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
							renderer.renderStandardBlock(block, x, y, z);
							renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
							renderer.renderStandardBlock(block, x, y, z);
						}
					}
					else
					{
						renderer.setRenderBounds(-0.2F, 0.5F, -0.001F, 0.05F, 0.9F, 1.001F); //Arm Rest Left
						renderer.renderStandardBlock(block, x, y, z);
						renderer.setRenderBounds(0.95F, 0.5F, -0.001F, 1.2F, 0.9F, 1.001F); //Arm Rest Right
						renderer.renderStandardBlock(block, x, y, z);
					}
				}
				renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1F, 0.6F, 1F); //Base
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0F, 0.6F, 0.F, 1F, 1.2F, 0.25F); //Back Rest
				renderer.renderStandardBlock(block, x, y, z);			
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderFridge)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
			renderer.renderStandardBlock(block, x, y, z);

			if(world.getBlockMetadata(x, y, z) == 1)
			{
				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.fridge.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(1F, 0.125F, 0.875F, 0.9375F, 0.75F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(1F, 0.6875F, 0.8125F, 0.9375F, 0.75F, 0.75F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(1F, 0.125F, 0.8125F, 0.9375F, 0.1875F, 0.75F);
					renderer.renderStandardBlock(block, x, y, z);	
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.03125F, 0.0F, 0.1875F, 0.0625F, 0.0625F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.03125F, 0.125F, 0.1875F, 0.0625F, 0.1875F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.03125F, 0.25F, 0.1875F, 0.0625F, 0.3125F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.03125F, 0.0625F, 0.1875F, 0.0625F, 0.125F, 0.25F );
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.03125F, 0.1875F, 0.75F, 0.0625F, 0.25F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(1F, 0.5F, 0.875F, 0.9375F, 0.8750F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(1F, 0.8125F, 0.8125F, 0.9375F, 0.875F, 0.75F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(1F, 0.5F, 0.8125F, 0.9375F, 0.5625F, 0.75F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0625F, 0.1875F, 0.0625F, 0.3125F, 0.8125F );
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.03125F, 0.9375F, 0.75F, 0.0625F, 1.0F, 0.8125F );
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Pipes Connecters Left
				renderer.setRenderBounds(0.03125F, 0.3125F, 0.1875F, 0.0625F, 0.375F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.5625F, 0.1875F, 0.0625F, 0.625F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.8125F, 0.1875F, 0.0625F, 0.875F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes Connecters Right
				renderer.setRenderBounds(0.03125F, 0.4375F, 0.75F, 0.0625F, 0.5F, 0.8125F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.6875F, 0.75F, 0.0625F, 0.75F, 0.8125F );
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes
				renderer.setRenderBounds(0.03125F, 0.375F, 0.1875F, 0.0625F, 0.4375F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.5F, 0.1875F, 0.0625F, 0.5625F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.6250F, 0.1875F, 0.0625F, 0.6875F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.75F, 0.1875F, 0.0625F, 0.8125F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.03125F, 0.875F, 0.1875F, 0.0625F, 0.9375F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 2)
			{
				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.fridge.blockID)
				{
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.8125F, 0.125F, 0.0F, 0.8750F, 0.8125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.75F, 0.0F, 0.8125F, 0.8125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.125F, 0.0F, 0.8125F, 0.1875F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.1875F, 0.0F, 0.9375F, 0.8125F, 0.0625F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.125F, 0.9375F, 0.8125F, 0.1875F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.25F, 0.9375F, 0.8125F, 0.3F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.06255F, 0.9375F, 0.25F, 0.125F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.1875F, 0.9375F, 0.8125F, 0.25F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{				
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.8125F, 0.5F, 0.0F, 0.875F, 0.8750F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.5F, 0.0F, 0.8125F, 0.5625F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.8125F, 0.0F, 0.8125F, 0.8750F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.75F, 0.9375F, 0.9375F, 0.8125F, 1.0F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.0625F, 0.9375F, 0.8125F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Pipes Connecters Left
				renderer.setRenderBounds(0.1875F, 0.3125F, 0.9375F, 0.25F, 0.3750F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.5625F, 0.9375F, 0.25F, 0.6250F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.8125F, 0.9375F, 0.25F, 0.875F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes Connecters Right
				renderer.setRenderBounds(0.75F, 0.4375F, 0.9375F, 0.8125F, 0.5F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.6875F, 0.9375F, 0.8125F, 0.75F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes
				renderer.setRenderBounds(0.1875F, 0.375F, 0.9375F, 0.8125F, 0.4375F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.5F, 0.9375F, 0.8125F, 0.5625F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.6250F, 0.9375F, 0.8125F, 0.6875F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.75F, 0.9375F, 0.8125F, 0.8125F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.875F, 0.9375F, 0.8125F, 0.9375F, 0.96875F);
				renderer.renderStandardBlock(block, x, y, z);

			}

			if(world.getBlockMetadata(x, y, z) == 3)
			{
				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.fridge.blockID)
				{
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.125F, 0.125F, 0.9375F, 0.1875F, 0.75F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.125F, 0.9375F, 0.25F, 0.1875F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.6875F, 0.9375F, 0.25F, 0.75F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					//renderer.overrideBlockTexture = this.topBack;
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.1875F, 0.0F, 0.03125F, 0.8125F, 0.0625F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.125F, 0.03125F, 0.8125F, 0.1875F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.25F, 0.03125F, 0.8125F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.0F, 0.03125F, 0.8125F, 0.0625F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.1875F, 0.03125F, 0.8125F, 0.25F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.0625F, 0.03125F, 0.25F, 0.125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.125F, 0.5F, 0.9375F, 0.1875F, 0.8750F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.5F, 0.9375F, 0.25F, 0.5625F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.8125F, 0.9375F, 0.25F, 0.8750F, 1F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.75F, 0.9375F, 0.9375F, 0.8125F, 1.0F, 0.96875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.1875F, 0.0625F, 0.0F, 0.8125F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.9375F, 0.03125F, 0.8125F, 1.0F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);

				}
				//Pipes Connecters Left
				renderer.setRenderBounds(0.1875F, 0.3125F, 0.03125F, 0.25F, 0.3750F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.5625F, 0.03125F, 0.25F, 0.6250F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.8125F, 0.03125F, 0.25F, 0.875F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes Connecters Right
				renderer.setRenderBounds(0.75F, 0.4375F, 0.03125F, 0.8125F, 0.5F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.6875F, 0.03125F, 0.8125F, 0.75F, 00.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes
				renderer.setRenderBounds(0.1875F, 0.375F, 0.03125F, 0.8125F, 0.4375F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.5F, 0.03125F, 0.8125F, 0.5625F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.6250F, 0.03125F, 0.8125F, 0.6875F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.75F, 0.03125F, 0.8125F, 0.8125F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.1875F, 0.875F, 0.03125F, 0.8125F, 0.9375F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.fridge.blockID)
				{
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.0F, 0.125F, 0.125F, 0.0625F, 0.75F, 0.1875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.1875F, 0.0625F, 0.1875F, 0.25F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.6875F, 0.1875F, 0.0625F, 0.75F, 0.25F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.0F, 0.1875F, 0.96875F, 0.0625F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.125F, 0.1875F, 0.96875F, 0.1875F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.25F, 0.1875F, 0.96875F, 0.3125F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.0625F, 0.1875F, 0.96875F, 0.125F, 0.25F );
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.1875F, 0.75F, 0.96875F, 0.25F, 0.8125F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					//Handle
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
					renderer.setRenderBounds(0.0F, 0.5F, 0.125F, 0.0625F, 0.8750F, 0.1875F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.1875F, 0.0625F, 0.5625F, 0.25F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.8125F, 0.1875F, 0.0625F, 0.8750F, 0.25F);
					renderer.renderStandardBlock(block, x, y, z);
					//Back
					renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.0625F, 0.1875F, 1.0F, 0.3125F, 0.8125F );
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.9375F, 0.75F, 0.96875F, 1.0F, 0.8125F );
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Pipes Connecters Left
				renderer.setRenderBounds(0.9375F, 0.3125F, 0.1875F, 0.96875F, 0.375F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.5625F, 0.1875F, 0.96875F, 0.625F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.8125F, 0.1875F, 0.96875F, 0.875F, 0.25F );
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes Connecters Right
				renderer.setRenderBounds(0.9375F, 0.4375F, 0.75F, 0.96875F, 0.5F, 0.8125F );
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.6875F, 0.75F, 0.96875F, 0.75F, 0.8125F );
				renderer.renderStandardBlock(block, x, y, z);
				//Pipes
				renderer.setRenderBounds(0.9375F, 0.375F, 0.1875F, 0.96875F, 0.4375F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.5F, 0.1875F, 0.96875F, 0.5625F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.6250F, 0.1875F, 0.96875F, 0.6875F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.75F, 0.1875F, 0.96875F, 0.8125F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.9375F, 0.875F, 0.1875F, 0.96875F, 0.9375F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderLamp)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
			renderer.setRenderBounds(0.3F, 0.85F, 0.3F, 0.7F, 0.90F, 0.7F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.2F, 0.8F, 0.2F, 0.8F, 0.85F, 0.8F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.15F, 0.7F, 0.15F, 0.85F, 0.80F, 0.85F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1F, 0.5F, 0.1F, 0.9F, 0.7F, 0.9F);
			renderer.renderStandardBlock(block, x, y, z);
			//Neck
			renderer.overrideBlockTexture = Block.obsidian.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.45F, 0.0F, 0.45F, 0.55F, 0.6F, 0.55F);
			renderer.renderStandardBlock(block, x, y, z);
			//Base
			renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.3125F, 0.75F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderOven)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.blockNetherQuartz.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1F, 0.9375F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.obsidian.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.1875F, 0.5F, 0.1875F, 0.4325F, 1.0625F, 0.4375F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1875F, 0.5F, 0.5625F, 0.4325F, 1.0625F, 0.8125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.5625F, 0.5F, 0.1875F, 0.8125F, 1.0625F, 0.4375F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.5625F, 0.5F, 0.5625F, 0.8125F, 1.0625F, 0.8125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.blockNetherQuartz.getBlockTextureFromSide(1);

			if(world.getBlockMetadata(x, y, z) == 0) //Right
			{
				renderer.setRenderBounds(0.0625F, 0.0F, 0.8749F, 0.9376F, 1.1875F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.2F, 0.2F, 0.0F, 0.8F, 0.8125F, 0.0625F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 2) //Left
			{
				renderer.setRenderBounds(0.0624F, 0.0F, 0.0F, 0.9376F, 1.1875F, 0.125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.2F, 0.2F, 0.9375F, 0.8F, 0.8125F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 1) //Behind
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.0624F, 0.125F, 1.1875F, 0.9376F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.9375F, 0.2F, 0.2F, 1.0F, 0.8125F, 0.8F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 3) //Front
			{
				renderer.setRenderBounds(0.875F, 0.0F, 0.0624F, 1.0F, 1.1875F, 0.9376F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.2F, 0.2F, 0.0625F, 0.8125F, 0.8F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return false;
		}
		if(modelId == ClientProxyFurniture.renderOvenOverhead)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.stoneSingleSlab.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			if(world.getBlockMetadata(x, y, z) == 0) //Right
			{
				renderer.setRenderBounds(0.2F, 0.2F, 0.5F, 0.8F, 1.0F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 2) //Left
			{
				renderer.setRenderBounds(0.2F, 0.2F, 0.0F, 0.8F, 1.0F, 0.5F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 1) //Behind
			{
				renderer.setRenderBounds(0.0F, 0.2F, 0.2F, 0.5F, 1.0F, 0.8F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 3) //Front
			{
				renderer.setRenderBounds(0.5F, 0.2F, 0.2F, 1.0F, 1.0F, 0.8F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return false;
		}
		if(modelId == ClientProxyFurniture.renderTable)
		{
			renderer.renderAllFaces = true;
			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.tableWood.blockID)
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.375F, 0.425F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.375F, 0.825F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.175F, 0.625F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.575F, 0.625F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Right
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.175F, 0.425F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Left
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.575F, 0.425F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Left
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.575F, 0.825F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.175F, 0.825F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Behind
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				//Left && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				//All
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.375F, 0.825F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.375F, 0.425F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.375F, 0.825F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.175F, 0.625F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.575F, 0.625F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Right
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.175F, 0.425F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Left
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.575F, 0.425F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Left
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.575F, 0.825F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.175F, 0.825F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Behind
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				//Left && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				//All
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableWood.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableWood.blockID)
				{

				}
				else
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.tableStone.blockID)
			{
				renderer.overrideBlockTexture = Block.cobblestone.getBlockTextureFromSide(1);

				if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.375F, 0.425F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.375F, 0.825F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.175F, 0.625F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.575F, 0.625F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Right
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.175F, 0.425F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Left
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.175F, 0.0F, 0.575F, 0.425F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Left
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.575F, 0.825F, 0.9F, 0.825F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Behind && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.175F, 0.825F, 0.9F, 0.425F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				//Front && Behind
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				//Left && Right
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				//All
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) != MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				else if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID && world.getBlockId(x, y, z - 1) != MrCrayfishFurnitureMod.tableStone.blockID)
				{

				}
				else if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.tableStone.blockID)
				{
					renderer.setRenderBounds(0.575F, 0.0F, 0.375F, 0.825F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
				else
				{
					renderer.setRenderBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.9F, 0.625F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			renderer.setRenderBounds(0F, 0.9F, 0F, 1F, 1F, 1F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderWindowDecoration)
		{
			int l = world.getBlockMetadata(x, y, z);
			renderer.renderAllFaces = true;

			if(l == 0) //Front
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.875F, 0.875F, 1.0F, 1.0F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blinds.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.9375F, 1.0F, 0.0625F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.9375F, 1.0F, 0.1875F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.25F, 0.9375F, 1.0F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.375F, 0.9375F, 1.0F, 0.4375F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.9375F, 1.0F, 0.5625F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.625F, 0.9375F, 1.0F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.75F, 0.9375F, 1.0F, 0.8125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.921875F, 0.125F, 0.90625F, 0.953125F, 0.875F, 0.9375F);
					renderer.renderStandardBlock(block, x, y, z);				
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blindsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.9375F, 1.0F, 0.875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.921875F, 0.5F, 0.90625F, 0.953125F, 0.875F, 0.9375F);
					renderer.renderStandardBlock(block, x, y, z);				
				}


				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtains.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.8125F, 0.125F, 0.9375F, 1.0F, 0.25F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.875F, 0.3125F, 0.9375F, 1.0F, 0.3750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.8125F, 0.3750F, 0.9375F, 1.0F, 0.5F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.5F, 0.9375F, 1.0F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.6875F, 0.6875F, 0.9375F, 1.0F, 0.8750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.9375F, 0.1875F, 0.25F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3125F, 0.9375F, 0.125F, 0.3750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3750F, 0.9375F, 0.1875F, 0.5F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.9375F, 0.25F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.6875F, 0.9375F, 0.3125F, 0.8750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.875F, 0.25F, 0.9375, 1.0F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.25F, 0.9375F, 0.125F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);	
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtainsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.0F, 0.0625F, 0.9375F, 1.0F, 0.875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.1875F, 0.9374F, 1.0001F, 0.3125F, 0.9999F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(-0.0001F, 0.1875F, 0.9374F, 0.0626F, 0.3125F, 0.9999F);
					renderer.renderStandardBlock(block, x, y, z);
				}


			}
			if(l == 2) //Right
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.8750F, 0.0F, 1.0F, 1.0F, 0.125F);
				renderer.renderStandardBlock(block, x, y, z);

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blinds.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.0F, 1.0F, 0.1875F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 1.0F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.375F, 0.0F, 1.0F, 0.4375F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.0F, 1.0F, 0.5625F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.625F, 0.0F, 1.0F, 0.6875F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.75F, 0.0F, 1.0F, 0.8125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.046875F, 0.125F, 0.0625F, 0.078125F, 0.875F, 0.09375F);
					renderer.renderStandardBlock(block, x, y, z);				
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blindsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.046875F, 0.5F, 0.0625F, 0.078125F, 0.875F, 0.09375F);
					renderer.renderStandardBlock(block, x, y, z);				
				}

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtains.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.8125F, 0.125F, 0.0F, 1.0F, 0.25F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.875F, 0.3125F, 0.0F, 1.0F, 0.3750F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.8125F, 0.3750F, 0.0F, 1.0F, 0.5F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.75F, 0.5F, 0.0F, 1.0F, 0.6875F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.6875F, 0.6875F, 0.0F, 1.0F, 0.8750F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.0F, 0.1875F, 0.25F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3125F, 0.0F, 0.125F, 0.3750F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3750F, 0.0F, 0.1875F, 0.5F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.0F, 0.25F, 0.6875F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.6875F, 0.0F, 0.3125F, 0.8750F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.875F, 0.25F, 0.0F, 1.0F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 0.125F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);	
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtainsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.0F, 0.0625F, 0.0F, 1.0F, 0.875F, 0.0625F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.1875F, 0.0001F, 1.0001F, 0.3125F, 0.0626F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(-0.0001F, 0.1875F, 0.0001F, 0.0626F, 0.3125F, 0.0626F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			if(l == 1) //Behind
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0F, 0.8750F, 0.0F, 0.125F, 1.0F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blinds.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.0625F, 0.0625F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.0F, 0.0625F, 0.1875F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 0.0625F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.375F, 0.0F, 0.0625F, 0.4375F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.0F, 0.0625F, 0.5625F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.625F, 0.0F, 0.0625F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.75F, 0.0F, 0.0625F, 0.8125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.09375, 0.125F, 0.953125F, 0.0625F, 0.875F, 0.921875F);
					renderer.renderStandardBlock(block, x, y, z);				
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blindsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 0.0625F, 0.875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.09375, 0.5F, 0.953125F, 0.0625F, 0.875F, 0.921875F);
					renderer.renderStandardBlock(block, x, y, z);					
				}

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtains.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.0F, 0.125F, 0.0F, 0.0625F, 0.25F, 0.1875F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3125F, 0.0F, 0.0625F, 0.3750F, 0.125F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3750F, 0.0F, 0.0625F, 0.5F, 0.1875F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.0F, 0.0625F, 0.6875F, 0.25F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.6875F, 0.0F, 0.0625F, 0.8750F, 0.3125F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.125F, 0.8125F, 0.0625F, 0.25F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3125F, 0.875F, 0.0625F, 0.3750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.3750F, 0.8125F, 0.0625F, 0.5F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.5F, 0.75F, 0.0625F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0F, 0.6875F, 0.6875F, 0.0625F, 0.8750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0001F, 0.25F, 0.0F, 0.0626F, 0.3125F, 0.125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0001F, 0.25F, 0.875F, 0.0626F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);	
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtainsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.0F, 0.0625F, 0.0F, 0.0625F, 0.875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.0001F, 0.1875F, -0.0001F, 0.0626F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.0001F, 0.1875F, 0.9375F, 0.0626F, 0.3125F, 1.0001F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			if(l == 3) //Left
			{
				renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.875F, 0.8750F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blinds.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.125F, 0.0F, 1.0F, 0.1875F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.25F, 0.0F, 1.0F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.375F, 0.0F, 1.0F, 0.4375F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.5F, 0.0F, 1.0F, 0.5625F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.625F, 0.0F, 1.0F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375f, 0.75F, 0.0F, 1.0F, 0.8125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.90625, 0.124F, 0.046875F, 0.9375F, 0.875F, 0.078125F);
					renderer.renderStandardBlock(block, x, y, z);				
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.blindsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9375F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 0);
					renderer.setRenderBounds(0.90625F, 0.5F, 0.046875F, 0.9375F, 0.875F, 0.078125F);
					renderer.renderStandardBlock(block, x, y, z);				
				}

				if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtains.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.9375F, 0.125F, 0.0F, 1.0F, 0.25F, 0.1875F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.3125F, 0.0F, 1.0F, 0.3750F, 0.125F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.3750F, 0.0F, 1.0F, 0.5F, 0.1875F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.5F, 0.0F, 1.0F, 0.6875F, 0.25F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.6875F, 0.0F, 1.0F, 0.8750F, 0.3125F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.125F, 0.8125F, 1.0F, 0.25F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.3125F, 0.875F, 1.0F, 0.3750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.3750F, 0.8125F, 1.0F, 0.5F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.5F, 0.75F, 1.0F, 0.6875F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9375F, 0.6875F, 0.6875F, 1.0F, 0.8750F, 1.0F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9374F, 0.25F, 0.0F, 0.9999F, 0.3125F, 0.125F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9374F, 0.25F, 0.875F, 0.9999F, 0.3125F, 1.0F);
					renderer.renderStandardBlock(block, x, y, z);	
				}
				else if(world.getBlockId(x, y, z) == MrCrayfishFurnitureMod.curtainsClosed.blockID)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 14);
					renderer.setRenderBounds(0.9375F, 0.0625F, 0.0F, 1.0F, 0.875F, 1.0001F);	
					renderer.renderStandardBlock(block, x, y, z);
					renderer.overrideBlockTexture = Block.blockGold.getBlockTextureFromSide(1);
					renderer.setRenderBounds(0.9374F, 0.1875F, -0.0001F, 0.9999F, 0.3125F, 0.0625F);
					renderer.renderStandardBlock(block, x, y, z);
					renderer.setRenderBounds(0.9374F, 0.1875F, 0.9375F, 0.9999F, 0.3125F, 1.00011F);
					renderer.renderStandardBlock(block, x, y, z);
				}
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderHedge)
		{
			renderer.renderAllFaces = true;
			renderer.setRenderBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
			renderer.renderStandardBlock(block, x, y, z);
			if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.hedge.blockID | world.getBlockId(x + 1, y, z) == block.fenceGate.blockID | world.isBlockNormalCube(x + 1, y, z))
			{
				renderer.setRenderBounds(0.8125F, 0.0F, 0.1875F, 1.0F, 1.0F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.hedge.blockID | world.getBlockId(x - 1, y, z) == block.fenceGate.blockID | world.isBlockNormalCube(x - 1, y, z))
			{
				renderer.setRenderBounds(0.0F, 0.0F, 0.1875F, 0.1875F, 1.0F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.hedge.blockID | world.getBlockId(x, y, z + 1) == block.fenceGate.blockID | world.isBlockNormalCube(x, y, z + 1))
			{
				renderer.setRenderBounds(0.1875F, 0.0F, 0.8125F, 0.8125F, 1.0F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.hedge.blockID | world.getBlockId(x, y, z - 1) == block.fenceGate.blockID | world.isBlockNormalCube(x, y, z - 1))
			{
				renderer.setRenderBounds(0.1875F, 0.0F, 0.0F, 0.8125F, 1.0F, 0.1875F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderBirdBath)
		{
			Tessellator tessellator = Tessellator.instance;
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
			float f = 1.0F;
			int l = block.colorMultiplier(world, x, y, z);
			float f1 = (float)(l >> 16 & 255) / 255.0F;
			float f2 = (float)(l >> 8 & 255) / 255.0F;
			float f3 = (float)(l & 255) / 255.0F;
			float f4;

			if (EntityRenderer.anaglyphEnable)
			{
				float f5 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
				f4 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
				float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
				f1 = f5;
				f2 = f4;
				f3 = f6;
			}

			tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);

			Icon icon2 = BlockFluid.func_94424_b("water");
			renderer.setRenderBounds(0.1F, 0.8F, 0.1F, 0.9F, 0.85F, 0.9F);
			renderer.renderFaceYPos(block, (double)x, (double)y, (double)z, icon2);

			renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.1F, 0.75F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.3125F, 0.1F, 0.3125F, 0.6875F, 0.7F, 0.6875F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.0F, 0.7F, 0.0F, 1.0F, 0.8F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setRenderBounds(0.0F, 0.8F, 0.0F, 0.1F, 0.9F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1F, 0.7F, 0.0F, 0.9F, 0.9F, 0.1F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.1F, 0.7F, 0.9F, 0.9F, 0.9F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.9F, 0.8F, 0.0F, 1.0F, 0.9F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = null;
			return true;

		}
		if(modelId == ClientProxyFurniture.renderStonePath)
		{
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.0625F, 0.0F, 0.0625F, 0.375F, 0.03125F, 0.375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.125F, 0.0F, 0.5F, 0.375F, 0.03125F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0625F, 0.0F, 0.8125F, 0.1875F, 0.03125F, 0.9275F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.4375F, 0.0F, 0.25F, 0.75F, 0.03125F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.4375F, 0.0F, 0.75F, 0.625F, 0.03125F, 0.9375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.625F, 0.0F, 0.0625F, 0.75F, 0.03125F, 0.1875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.6875F, 0.0F, 0.625F, 0.875F, 0.03125F, 0.8125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.8125F, 0.0F, 0.25F, 0.9375F, 0.03125F, 0.375F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockMetadata(x, y, z) == 1)
			{
				renderer.overrideBlockTexture = Block.stone.getBlockTextureFromSide(1);
				renderer.setRenderBounds(0.1875F, 0.0F, 0.0625F, 0.375F, 0.03125F, 0.25F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0625F, 0.0F, 0.375F, 0.3125F, 0.03125F, 0.625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.125F, 0.0F, 0.6875F, 0.3125F, 0.03125F, 0.875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.4375F, 0.0F, 0.5625F, 0.5625F, 0.03125F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5F, 0.0F, 0.8125F, 0.625F, 0.03125F, 0.9375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.625F, 0.0F, 0.125F, 0.875F, 0.03125F, 0.375F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.6875F, 0.0F, 0.4375F, 0.875F, 0.03125F, 0.625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.6875F, 0.0F, 0.6875F, 0.9375F, 0.03125F, 0.9375F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
		}
		if(modelId == ClientProxyFurniture.renderWhiteFence)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.blockNetherQuartz.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.1F, 0.5625F);
			renderer.renderStandardBlock(block, x, y, z);			
			if(world.getBlockId(x + 1, y, z) == MrCrayfishFurnitureMod.whiteFence.blockID | world.getBlockId(x + 1, y, z) == block.fenceGate.blockID | world.isBlockNormalCube(x + 1, y, z))
			{
				renderer.setRenderBounds(0.75F, 0.0F, 0.46875F, 0.875F, 1.0F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5F, 0.125F, 0.46875F, 1.0F, 0.25F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.5F, 0.75F, 0.46875F, 1.0F, 0.875F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x - 1, y, z) == MrCrayfishFurnitureMod.whiteFence.blockID | world.getBlockId(x - 1, y, z) == block.fenceGate.blockID | world.isBlockNormalCube(x - 1, y, z))
			{
				renderer.setRenderBounds(0.125F, 0.0F, 0.46875F, 0.25F, 1.0F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0F, 0.125F, 0.46875F, 0.5F, 0.25F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.0F, 0.75F, 0.46875F, 0.5F, 0.875F, 0.53125F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x, y, z + 1) == MrCrayfishFurnitureMod.whiteFence.blockID | world.getBlockId(x, y, z + 1) == block.fenceGate.blockID | world.isBlockNormalCube(x, y, z + 1))
			{
				renderer.setRenderBounds(0.46875F, 0.0F, 0.75F, 0.53125F, 1.0F, 0.875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.46875F, 0.125F, 0.5F, 0.53125F, 0.25F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.46875F, 0.75F, 0.5F, 0.53125F, 0.875F, 1.0F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(world.getBlockId(x, y, z - 1) == MrCrayfishFurnitureMod.whiteFence.blockID | world.getBlockId(x, y, z - 1) == block.fenceGate.blockID | world.isBlockNormalCube(x, y, z - 1))
			{
				renderer.setRenderBounds(0.46875F, 0.0F, 0.125F, 0.53125F, 1.0F, 0.25F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.46875F, 0.125F, 0.0F, 0.53125F, 0.25F, 0.5F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.46875F, 0.75F, 0.0F, 0.53125F, 0.875F, 0.5F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
			return true;
		}
		if(modelId == ClientProxyFurniture.renderTap)
		{
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.stoneSingleSlab.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.8F, 0.5625F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
			renderer.setRenderBounds(0.46875F, 0.9F, 0.46875F, 0.53125F, 0.95F, 0.53125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.38875F, 0.95F, 0.46875F, 0.61125F, 1.0F, 0.53125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(0.46875F, 0.95F, 0.38875F, 0.53125F, 1.0F, 0.61125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.stoneSingleSlab.getBlockTextureFromSide(1);

			int l = world.getBlockMetadata(x, y, z);			
			if(l == 3)
			{
				renderer.setRenderBounds(0.125F, 0.8F, 0.4375F, 0.5625F, 0.9F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.125F, 0.7F, 0.4375F, 0.25F, 0.8F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 1)
			{
				renderer.setRenderBounds(0.4375F, 0.8F, 0.4375F, 0.875F, 0.9F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.75F, 0.7F, 0.4375F, 0.875F, 0.8F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 2)
			{
				renderer.setRenderBounds(0.4375F, 0.8F, 0.4375F, 0.5625F, 0.9F, 0.875F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.4375F, 0.7F, 0.75F, 0.5625F, 0.8F, 0.875F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 0)
			{
				renderer.setRenderBounds(0.4375F, 0.8F, 0.125F, 0.5625F, 0.9F, 0.5625F);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0.4375F, 0.7F, 0.125F, 0.5625F, 0.8F, 0.25F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
		}
		if(modelId == ClientProxyFurniture.renderMailBox)
		{
			TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
			if(tile_entity instanceof TileEntityMailBox)
			{
				TileEntityMailBox mailBox = (TileEntityMailBox)tile_entity;
			}
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
			//Pole
			renderer.setRenderBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.8F, 0.5625F);
			renderer.renderStandardBlock(block, x, y, z);

			int l = world.getBlockMetadata(x, y, z);
			if(l == 3)
			{
				//Left Side
				renderer.setRenderBounds(0.25F, 0.8625F, 0.25F, 0.75F, 1.16F, 0.3125F);
				renderer.renderStandardBlock(block, x, y, z);	
				//Right Side
				renderer.setRenderBounds(0.25F, 0.8625F, 0.6875F, 0.75F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Back
				renderer.setRenderBounds(0.6875F, 0.8625F, 0.3125F, 0.75F, 1.16F, 0.6875F);
				renderer.renderStandardBlock(block, x, y, z);
				//Front
				renderer.setRenderBounds(0.25F, 0.8625F, 0.3125F, 0.3125F, 1.0F, 0.6875F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 1)
			{
				//Left Side
				renderer.setRenderBounds(0.25F, 0.8625F, 0.25F, 0.75F, 1.16F, 0.3125F);
				renderer.renderStandardBlock(block, x, y, z);	
				//Right Side
				renderer.setRenderBounds(0.25F, 0.8625F, 0.6875F, 0.75F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Back
				renderer.setRenderBounds(0.6875F, 0.8625F, 0.3125F, 0.75F, 1.0F, 0.6875F);
				renderer.renderStandardBlock(block, x, y, z);
				//Front
				renderer.setRenderBounds(0.25F, 0.8625F, 0.3125F, 0.3125F, 1.16F, 0.6875F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 2)
			{
				//Left Side
				renderer.setRenderBounds(0.3125F, 0.8625F, 0.25F, 0.6875F, 1.16F, 0.3125F);
				renderer.renderStandardBlock(block, x, y, z);	
				//Right Side
				renderer.setRenderBounds(0.3125F, 0.8625F, 0.6875F, 0.6875F, 1.0F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Back
				renderer.setRenderBounds(0.6875F, 0.8625F, 0.25F, 0.75F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Front
				renderer.setRenderBounds(0.25F, 0.8625F, 0.25F, 0.3125F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(l == 0)
			{
				//Left Side
				renderer.setRenderBounds(0.3125F, 0.8625F, 0.25F, 0.6875F, 1.0F, 0.3125F);
				renderer.renderStandardBlock(block, x, y, z);	
				//Right Side
				renderer.setRenderBounds(0.3125F, 0.8625F, 0.6875F, 0.6875F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Back
				renderer.setRenderBounds(0.6875F, 0.8625F, 0.25F, 0.75F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
				//Front
				renderer.setRenderBounds(0.25F, 0.8625F, 0.25F, 0.3125F, 1.16F, 0.75F);
				renderer.renderStandardBlock(block, x, y, z);
			}
			
			renderer.overrideBlockTexture = Block.wood.getBlockTextureFromSide(2);
			//Base
			renderer.setRenderBounds(0.25F, 0.8F, 0.25F, 0.75F, 0.8625F, 0.75F);
			renderer.renderStandardBlock(block, x, y, z);
			//Roof
			renderer.setRenderBounds(0.1875F, 1.1F, 0.1875F, 0.8125F, 1.1625F, 0.8125F);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
		}
		/*if(modelId == ClientProxyFurniture.renderTV)
		{
			double var1 = 0, var2 = 0, var3 = 0, var4 = 0, var5 = 0, var6 = 0, var7 = 0, var8 = 0, var9 = 0, var10 = 0, var11 = 0, var12 = 0;
			double var13 = 0, var14 = 0, var15 = 0, var16 = 0;
			if(world.getBlockMetadata(x, y, z) == 3)
			{
				var1 = 0.1F; var2 = 0.1F; var3 = 0.6F; var4 = 0.9F; //Base & Top
				var5 = 0.6F; var6 = 0.2F; var7 = var1; var8 = 0.8F; //Sides
				var9 = 0.2F; var10 = var9; var11 = 0.5F; var12 = 0.8F; //Screen
				var13 = var11; var14 = var9; var15 = 0.9F; var16 = 0.8F;
			}
			if(world.getBlockMetadata(x, y, z) == 1)
			{
				var1 = 0.4F; var2 = 0.1F; var3 = 0.9F; var4 = 0.9F;
				var5 = 0.9F; var6 = 0.2F; var7 = var1; var8 = 0.8F;
				var9 = 0.4F; var10 = 0.2F; var11 = 0.8F; var12 = 0.8F;
				var13 = 0.1F; var14 = 0.2F; var15 = var9; var16 = 0.8F;
			}
			if(world.getBlockMetadata(x, y, z) == 2)
			{
				var1 = 0.1F; var2 = 0.4F; var3 = 0.9F; var4 = var3;
				var5 = 0.2F; var6 = 0.9F; var7 = 0.8F; var8 = 0.4F;
				var9 = 0.2F; var10 = 0.4F; var11 = 0.8F; var12 = 0.8F;
				var13 = 0.2F; var14 = 0.1F; var15 = 0.8F; var16 = 0.4F;
				
			}
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				var1 = 0.1F; var2 = 0.1F; var3 = 0.9F; var4 = 0.6F;
				var5 = 0.2F; var6 = 0.6F; var7 = 0.8F; var8 = 0.1F;
				var9 = 0.2F; var10 = 0.2F; var11 = 0.8F; var12 = 0.6F;
				var13 = 0.2F; var14 = 0.6F; var15 = 0.8F; var16 = 0.9F;
			}
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.wood.getBlockTextureFromSide(2);
			//Base & Top
			renderer.setRenderBounds(var1, 0.0F, var2, var3, 0.1F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(var1, 0.7F, var2, var3, 0.8F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			
			//Sides
			renderer.setRenderBounds(var1, 0.1F, var2, var5, 0.7F, var6);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.setRenderBounds(var7, 0.1F, var8, var3, 0.7F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			
			renderer.unlockBlockBounds();
			TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
			if(tile_entity instanceof TileEntityTV)
			{
				TileEntityTV tileEntityTV = (TileEntityTV)tile_entity;
				int tvChannel = tileEntityTV.getTVChannel();
				if(tvChannel == 0)
				{
					renderer.overrideBlockTexture = Block.cloth.getIcon(1, 15);
				}
				if(tvChannel == 1)
				{
					renderer.overrideBlockTexture = MrCrayfishFurnitureMod.hey.getBlockTextureFromSide(1);
				}
				if(tvChannel == 2)
				{
					renderer.overrideBlockTexture = MrCrayfishFurnitureMod.nyan.getBlockTextureFromSide(1);
				}
				if(tvChannel == 3)
				{
					renderer.overrideBlockTexture = MrCrayfishFurnitureMod.creeper.getBlockTextureFromSide(1);
				}
			}
			renderer.setRenderBounds(var9, 0.1F, var10, var11, 0.7F, var12);
			renderer.renderStandardBlock(block, x, y, z);
			
			//Back
			renderer.overrideBlockTexture = Block.planks.getBlockTextureFromSide(1);
			renderer.setRenderBounds(var13, 0.0625F, var14, var15, 0.7F, var16);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
		}*/
		if(modelId == ClientProxyFurniture.renderDoorBell)
		{
			int l = world.getBlockMetadata(x, y, z);

			float var1 = 0, var2 = 0, var3 = 0, var4 = 0, var5 = 0, var6 = 0, var7 = 0, var8 = 0;

			if(l == 3 | l == 11)
			{
				var1 = 0.9F; var2 = 0.4F; var3 = 1.0F; var4 = 0.6F;
				var5 = 0.85F; var6 = 0.45F; var7 = 0.9F; var8 = 0.55F; 
				if(l == 11)
				{
					var5 = 0.89F;
				}
			}
			if(l == 1 | l == 9)
			{
				var1 = 0.0F; var2 = 0.4F; var3 = 0.1F; var4 = 0.6F;
				var5 = 0.1F; var6 = 0.45F; var7 = 0.15F; var8 = 0.55F; 
				if(l == 9)
				{
					var7 = 0.11F;
				}
			}
			if(l == 2 | l == 10)
			{
				var1 = 0.4F; var2 = 0.0F; var3 = 0.6F; var4 = 0.1F;
				var5 = 0.45F; var6 = 0.1F; var7 = 0.55F; var8 = 0.15F; 
				if(l == 10)
				{
					var8 = 0.11F;
				}
			}
			if(l == 0 | l == 8)
			{
				var1 = 0.4F; var2 = 0.9F; var3 = 0.6F; var4 = 1.0F;
				var5 = 0.45F; var6 = 0.85F; var7 = 0.55F; var8 = 0.9F; 
				if(l == 8)
				{
					var6 = 0.89F;
				}
			}	
			renderer.renderAllFaces = true;
			renderer.overrideBlockTexture = Block.wood.getBlockTextureFromSide(2);
			renderer.setRenderBounds(var1, 0.3F, var2, var3, 0.7F, var4);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.overrideBlockTexture = Block.blockIron.getBlockTextureFromSide(1);
			renderer.setRenderBounds(var5, 0.45F, var6, var7, 0.55F, var8);
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderAllFaces = false;
			renderer.overrideBlockTexture = null;
		}
		return false;
	}


	@Override
	public boolean shouldRender3DInInventory() 
	{
		return false;
	}

	@Override
	public int getRenderId() 
	{
		return 0;
	}

}
