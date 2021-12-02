package com.theundertaker11.magnetkeybind;

import org.lwjgl.input.Keyboard;

import com.theundertaker11.magnetkeybind.packets.PacketHandler;
import com.theundertaker11.magnetkeybind.packets.SendToggleMagnet;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;


public class KeybindHandler {

    public static KeyBinding keybindToggleMagnet;

    public static void init()
    {
        keybindToggleMagnet = new KeyBinding("Toggle Magnet", Keyboard.KEY_M, "Magnet Keybind");
        ClientRegistry.registerKeyBinding(keybindToggleMagnet);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void clientPlayerTick(PlayerTickEvent event) {
        if(KeybindHandler.keybindToggleMagnet.isPressed())
        {
            PacketHandler.INSTANCE.sendToServer(new SendToggleMagnet());
        }
    }
}