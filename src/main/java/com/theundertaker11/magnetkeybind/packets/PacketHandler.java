package com.theundertaker11.magnetkeybind.packets;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("bettermagnets");

    public static void init(){
        INSTANCE.registerMessage(SendToggleMagnet.Handler.class, SendToggleMagnet.class, 0, Side.SERVER);
    }
}
