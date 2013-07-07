package com.mrcrayfish.furniture;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraft.client.audio.SoundManager;

public class SoundHandler
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
            event.manager.soundPoolSounds.addSound("sound/doorbell.wav");     
            event.manager.soundPoolSounds.addSound("sound/hey.ogg");
            event.manager.soundPoolSounds.addSound("sound/nyan.ogg");
            System.out.println("Loaded sound");
        } 
        catch (Exception e)
        {
            System.err.println("Failed to register one or more sounds.");
        }
    }
}