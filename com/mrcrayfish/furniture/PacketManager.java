package com.mrcrayfish.furniture;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import net.minecraft.entity.*;

public class PacketManager implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		if(packet.channel.equals("sitting"))
		{
			try{
				float x = inputStream.readFloat();
				float y = inputStream.readFloat();
				float z = inputStream.readFloat();
				String username = inputStream.readUTF();
				System.out.println(x + " " + y + " " + z + " " + username);
				EntityPlayer entityplayer = (EntityPlayer)player;
				if(entityplayer.username.equals(username))
				{
					entityplayer.updateRidden();
				}
			}catch(IOException e){e.printStackTrace();}
		}
	}

	public static void updatePlayerPostionOnCouch(float x, float y, float z, int ID, EntityPlayer player)
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		try
		{
			data.writeFloat(x);
			data.writeFloat(y);
			data.writeFloat(z);
			data.writeUTF(player.username);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "sitting";
		pkt.data = bytes.toByteArray();
		pkt.length = pkt.data.length;
		pkt.isChunkDataPacket = true;
		PacketDispatcher.sendPacketToAllPlayers(pkt);
	}

	protected static void writeNBTTagCompound(NBTTagCompound par0NBTTagCompound, DataOutputStream par1DataOutputStream) throws IOException
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		par1DataOutputStream = new DataOutputStream(bytes);

		if (par0NBTTagCompound == null)
		{
			par1DataOutputStream.writeShort(-1);
		}
		else
		{
			byte[] abyte = CompressedStreamTools.compress(par0NBTTagCompound);
			par1DataOutputStream.writeShort((short)abyte.length);
			par1DataOutputStream.write(abyte);


			Packet250CustomPayload pkt = new Packet250CustomPayload();
			pkt.channel = "Letter";
			pkt.data = bytes.toByteArray();
			pkt.length = pkt.data.length;
			pkt.isChunkDataPacket = true;
			PacketDispatcher.sendPacketToServer(pkt);
		}
	}

	public static void sendMailBoxPacket(TileEntityMailBox tileEntityMailBox, int ID, String ownerName)
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		try
		{
			data.writeInt(tileEntityMailBox.xCoord);
			data.writeInt(tileEntityMailBox.yCoord);
			data.writeInt(tileEntityMailBox.zCoord);
			data.writeInt(ID);

			if(ID == 0)
			{
				data.writeUTF(ownerName);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "MailBox";
		pkt.data = bytes.toByteArray();
		pkt.length = pkt.data.length;
		pkt.isChunkDataPacket = true;
		PacketDispatcher.sendPacketToAllPlayers(pkt);
	}

	public static void sendMail(TileEntityMailBox tileEntityMailBox, int ID, ItemStack itemStack)
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);

		try
		{
			data.writeInt(tileEntityMailBox.xCoord);
			data.writeInt(tileEntityMailBox.yCoord);
			data.writeInt(tileEntityMailBox.zCoord);
			data.writeInt(ID);

			if(ID == 1)
			{
				data.writeInt(itemStack.itemID);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		Packet250CustomPayload pkt = new Packet250CustomPayload();
		pkt.channel = "MailBox";
		pkt.data = bytes.toByteArray();
		pkt.length = pkt.data.length;
		pkt.isChunkDataPacket = true;
		PacketDispatcher.sendPacketToAllPlayers(pkt);
	}
}