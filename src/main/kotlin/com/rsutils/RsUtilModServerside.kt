package com.rsutils

import com.rsutils.block.ModBlocks
import com.rsutils.events.ModEvents
import com.rsutils.events.OnTick
import com.rsutils.item.ModItems
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object RsUtilModServerside : ModInitializer {
    const val MOD_ID: String = "rsutils"
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    val itemGroupKey: RegistryKey<ItemGroup> = RegistryKey<ItemGroup>.of(
        Registries.ITEM_GROUP.key,
        Identifier.of(MOD_ID, "item_group")
    )

    val itemGroup: ItemGroup = PolymerItemGroupUtils.builder()
        .icon { ItemStack(ModItems.SUSPICIOUS_SUBSTANCE) }
        .displayName(Text.translatable("itemGroup.rsutils"))
        .build()

	override fun onInitialize() {
		logger.info("Hello Fabric world From Server")

        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(MOD_ID, "item_group"), itemGroup)
        PolymerResourcePackUtils.addModAssets(MOD_ID)
        PolymerResourcePackUtils.markAsRequired()

        ModItems.initialize()
        ModBlocks.initialize()
        ModEvents.initialize()
    }


}