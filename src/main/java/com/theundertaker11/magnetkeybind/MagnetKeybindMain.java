package com.theundertaker11.magnetkeybind;

import com.theundertaker11.magnetkeybind.packets.PacketHandler;
import com.theundertaker11.magnetkeybind.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = "Better Magnets")
public class MagnetKeybindMain
{

    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.SERVERPROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public static MagnetKeybindMain instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        PacketHandler.init();
        if(event.getSide()==Side.CLIENT) {
            KeybindHandler.init();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (event.getSide() == Side.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new KeybindHandler());
            FMLCommonHandler.instance().bus().register(new KeybindHandler());
        }
    }
}
