package com.rsutils.block

import com.rsutils.RsUtilModServerside
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import java.util.function.Function

object ModBlocks {
    val CONDENSED_DIRT: Block = register(
        "condensed_dirt",
        ::CondensedDirt,
        AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS),
        true
    )

    fun register(
        name: String, blockFactory:
        Function<AbstractBlock.Settings, Block>,
        settings: AbstractBlock.Settings,
        shouldRegisterItem: Boolean
    ): Block {
        val blockKey: RegistryKey<Block> = keyOfBlock(name)
        val block: Block = blockFactory.apply(settings.registryKey(blockKey))

        if (shouldRegisterItem) {
            val itemKey: RegistryKey<Item> = keyOfItem(name)

            val blockItem: BlockItem = BlockItem(block, Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey())
            Registry.register(Registries.ITEM, itemKey, blockItem)
        }

        return Registry.register(Registries.BLOCK, blockKey, block)
    }

    fun keyOfBlock(name: String): RegistryKey<Block> {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RsUtilModServerside.MOD_ID, name))
    }

    fun keyOfItem(name: String): RegistryKey<Item> {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RsUtilModServerside.MOD_ID, name))
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(RsUtilModServerside.itemGroupKey).register {
            it.add(ModBlocks.CONDENSED_DIRT.asItem())
        }
    }
}