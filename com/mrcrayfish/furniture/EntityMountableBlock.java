package com.mrcrayfish.furniture;

import com.google.common.io.ByteArrayDataInput;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

/*ITOS:
 *This class acts as a bridge between the mountable block and the player.
 *This entity is what the player actually mounts instead of the block.
 *An entity of this class is created by the mountable block upon activation
 *and is killed when it's no longer used.
*/

public class EntityMountableBlock extends Entity
{
	
	//These variables keep track of the block that created the entity.
	protected int orgBlockPosX;
	protected int orgBlockPosY;
	protected int orgBlockPosZ;
	protected int orgBlockID;
	
	public EntityMountableBlock (World world)
	{
		super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0F;
        height = 0F;
	}
	
	public EntityMountableBlock (World world, double d, double d1, double d2)
	{
        super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0F;
        height = 0F;
        setPosition(d, d1, d2);
	}

	//This constructor is called by the mountable block.
	public EntityMountableBlock (World world, EntityPlayer entityplayer, int i, int j, int k, float mountingX, float mountingY, float mountingZ)
	{
		super(world);
        noClip = true;
        preventEntitySpawning = true;
        width = 0.0F;
        height = 0.0F;
        
    	orgBlockPosX = i;
    	orgBlockPosY = j;
    	orgBlockPosZ = k;
    	orgBlockID = world.getBlockId(i, j, k);
    	
        setPosition(mountingX, mountingY, mountingZ);
        updatePos(mountingX, mountingY, mountingZ, entityplayer);
	}
	
	public void updatePos(float x, float y, float z, EntityPlayer player)
	{
		PacketManager.updatePlayerPostionOnCouch(x, y, z, 0, player);
	}
	
	//This method handles mounting and dismounting.
	public boolean interact(EntityPlayer entityplayer)
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityplayer)
        {
        	return true;
        }
        else
        {
        	entityplayer.mountEntity(this);
        	return true;
        }
    }
    
	//This method is mostly a simplified version of the one in Entity but it also deletes unused EMBs.
    @Override
    public void onEntityUpdate()
    {
    	this.worldObj.theProfiler.startSection("entityBaseTick");
        if(riddenByEntity == null || riddenByEntity.isDead)
        {
			this.setDead();
        }
        else if(worldObj.getBlockId(orgBlockPosX, orgBlockPosY, orgBlockPosZ) != orgBlockID)
		{
        	this.interact((EntityPlayer) riddenByEntity);
		}
        ticksExisted++;
        this.worldObj.theProfiler.endSection();
    }
    
    //The following methods are required by the Entity class but I don't know what they are for.
    @Override
    public void entityInit() {}
    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {}
    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {}

	
}
