package me.refraction.firstmod;

import me.refraction.firstmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FirstMod.MODID, version = FirstMod.VERSION, name = FirstMod.NAME)
public class FirstMod
{
    public static final String MODID = "refractionfirstmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "First Mod";

    @SidedProxy(clientSide = "me.refraction.firstmod.proxy.ClientProxy", serverSide = "me.refraction.firstmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static FirstMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
