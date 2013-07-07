package com.mrcrayfish.furniture;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockStonePath extends Block
{

	protected BlockStonePath(int i, Material material)
	{
		super(i, material);
		setBlockBounds(0F, 0.0F, 0F, 1F, 0.03125F, 1F);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return ClientProxyFurniture.renderStonePath;
	}

	@Override
	public boolean canRenderInPass(int pass)
	{
		ClientProxyFurniture.renderPass = pass;
		return true;
	}

	public int getRenderBlockPass()
	{
		return 1;
	}

	public int idDropped(int i, Random random, int j)
	{
		return MrCrayfishFurnitureMod.itemStonePath.itemID;
	}

	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return MrCrayfishFurnitureMod.itemStonePath.itemID;
	}
}
