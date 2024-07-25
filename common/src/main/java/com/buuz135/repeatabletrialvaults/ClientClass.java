package com.buuz135.repeatabletrialvaults;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ClientClass {

    public static void onTooltip(ItemStack stack, Item.TooltipContext tooltipContext, TooltipFlag tooltipType, List<Component> lines){
        if (stack.is(Constants.CAN_RESET_TRIAL_VAULTS)){
            lines.add(Component.translatable("tooltip.rtv.can_reset_vaults").withStyle(ChatFormatting.GOLD));
        }
    }

}
