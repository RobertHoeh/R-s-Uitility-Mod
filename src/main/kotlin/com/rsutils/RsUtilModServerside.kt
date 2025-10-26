package com.rsutils

import com.rsutils.block.ModBlocks
import com.rsutils.item.ModItems
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils
import net.fabricmc.api.ModInitializer
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object RsUtilModServerside : ModInitializer {
    const val MOD_ID: String = "rsutils"
    private val logger = LoggerFactory.getLogger(MOD_ID)

    val itemGroupKey: RegistryKey<ItemGroup> = RegistryKey<ItemGroup>.of(
        Registries.ITEM_GROUP.key,
        Identifier.of(MOD_ID, "item_group")
    )

    val itemGroup = PolymerItemGroupUtils.builder()
        .icon { ItemStack(ModItems.SUSPICIOUS_SUBSTANCE) }
        .displayName(Text.translatable("itemGroup.rsutils"))
        .build()

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world From Server")

        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(MOD_ID, "item_group"), itemGroup)

        ModItems.initialize()
        ModBlocks.initialize()
	}
}