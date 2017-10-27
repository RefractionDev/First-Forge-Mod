package me.refraction.firstmod;

import me.refraction.firstmod.commands.Commands;
import me.refraction.firstmod.listener.Listener;
import me.refraction.firstmod.render.GUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.ICommand;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@Mod(modid = FirstMod.MODID, version = FirstMod.VERSION, name = FirstMod.NAME)
public class FirstMod
{
    public static final String MODID = "refractionfirstmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "First Mod";

    private String commandMessage = EnumChatFormatting.BLUE + "Test Command";
    private boolean guiOpen;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand((ICommand)new Commands(this));
        MinecraftForge.EVENT_BUS.register(new Listener(this));
        MinecraftForge.EVENT_BUS.register(this);
        this.loadConfig();
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if(guiOpen) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen) new GUI());
            this.guiOpen = false;
            return;
        }
    }

    public void openGUI() {
        this.guiOpen = true;
    }

    public String getMessage() {
        return this.commandMessage;
    }

    public void saveConfig() {
        try {
            final File file = new File(Minecraft.getMinecraft().mcDataDir + File.separator + "FirstMod", "values.cfg");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            final FileWriter writer = new FileWriter(file, false);
            writer.write(this.getMessage());
            writer.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void loadConfig() {
        try {
            final File file = new File(Minecraft.getMinecraft().mcDataDir + File.separator + "FirstMod", "values.cfg");
            if (!file.exists()) {
                return;
            }
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                switch (++i) {
                    case 1: {
                        this.commandMessage = line;
                        continue;
                    }
                }
            }
            reader.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
