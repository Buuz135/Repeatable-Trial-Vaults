package com.buuz135.repeatabletrialvaults;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "repeatable_trial_vaults";
	public static final String MOD_NAME = "Repeatable Trial Vaults";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static final TagKey<Item> CAN_RESET_TRIAL_VAULTS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "can_reset_trial_vaults"));
}