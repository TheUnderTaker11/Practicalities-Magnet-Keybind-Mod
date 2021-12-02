package com.theundertaker11.magnetkeybind.packets;

import com.theundertaker11.magnetkeybind.util.ModUtils;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class SendToggleMagnet implements IMessage{

    public SendToggleMagnet() { }

    @Override
    public void fromBytes(ByteBuf buf){}

    @Override
    public void toBytes(ByteBuf buf){}

    public static class Handler implements IMessageHandler<SendToggleMagnet, IMessage> {

        @Override
        public IMessage onMessage(final SendToggleMagnet message, final MessageContext ctx) {

            EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
            ItemStack magnet = ModUtils.findMagnet(serverPlayer);
            if(!ModUtils.isStackEmpty(magnet)) {
                ModUtils.toggleMagnetWithMessage(magnet, serverPlayer);
            }

            return null; // no response
        }
    }
}
