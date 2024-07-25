package com.buuz135.repeatabletrialvaults;


import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@Mod(Constants.MOD_ID)
public class RTVMod {

    public RTVMod(IEventBus eventBus, ModContainer container) {
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void tooltip(ItemTooltipEvent event){
        ClientClass.onTooltip(event.getItemStack(), event.getContext(), event.getFlags(), event.getToolTip());
    }
}