package me.refraction.firstmod.listener;

import me.refraction.firstmod.FirstMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Refraction on 27/10/2017.
 */
public class Listener {

    private FirstMod mod;

    public Listener(FirstMod mod) {
        this.mod = mod;
    }

    @SubscribeEvent
    public void onLivingJumpEvent(final LivingEvent.LivingJumpEvent event) {
        if(event.entityLiving instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) event.entityLiving;
            if(p.getUniqueID().toString().equals(Minecraft.getMinecraft().thePlayer.getUniqueID().toString())) {
                Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText("meme"));
            }
        }
    }

}
