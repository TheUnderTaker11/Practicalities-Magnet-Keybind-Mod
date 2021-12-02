package com.theundertaker11.magnetkeybind.util;

import com.theundertaker11.magnetkeybind.Reference;

import jotato.practicalities.items.ItemMagnet;
import jotato.practicalities.items.MyItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

public class ModUtils {

    public static boolean isStackEmpty(ItemStack stack) {
        return stack == null;
    }

    /**
     * Toggles magnet, puts message in player's chat window on new status of magnet (enabled or disabled)
     * @param stack
     * @param player
     */
    public static void toggleMagnetWithMessage(ItemStack stack, EntityPlayer player) {
        if(toggleMagnet(stack)) {
            player.addChatMessage(new ChatComponentText("Magnet enabled"));
        } else {
            player.addChatMessage(new ChatComponentText("Magnet disabled"));
        }
    }
    /**
     *
     * @param stack
     * @return True if magnet is now on, false if it is now off
     */
    public static boolean toggleMagnet(ItemStack stack) {
        if (!isStackEmpty(stack)) {
            stack.setItemDamage(stack.getItemDamage() == 0 ? 1 : 0);
            return stack.getItemDamage() == 1;
        }
        return false;
    }
    /**
     * Has a sanity check for if the stack is actually a magnet so feel free to use carelessly!
     * Throw em everywhere if you have to idc.
     * @param stack
     */
    public static void disableMagnet(ItemStack stack) {
        if (!isStackEmpty(stack) && stack.getItem() instanceof ItemMagnet) {
            getTag(stack).setBoolean(Reference.KEY, false);
        }
    }

    public static boolean isMagnetActive(ItemStack stack) {
        return getTag(stack).getBoolean(Reference.KEY);
    }

    public static ItemStack findMagnet(EntityPlayer player) {
        for(int i=0;i<player.inventory.getSizeInventory();i++) {
            ItemStack stack = player.inventory.getStackInSlot(i);
            if(isItemPracticalitiesMagnet(stack))
                return stack;
        }
        return null;
    }

    public static boolean isItemPracticalitiesMagnet(ItemStack stack) {
        if(!ModUtils.isStackEmpty(stack)) {
            if(stack.getItem() instanceof ItemMagnet || stack.getItem() == MyItems.getInstance().itemMagnet || stack.getItem() == MyItems.getInstance().rareMagnet)
                return true;
        }
        return false;
    }

    public static NBTTagCompound getTag(ItemStack stack) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        return stack.getTagCompound();
    }
}
