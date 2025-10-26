package com.rsutils.item

import com.rsutils.RsUtilModServerside
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function

object ModItems {
    val SUSPICIOUS_SUBSTANCE = register("suspicious_substance", ::SuspiciousSubstance, Item.Settings())

    fun register(name: String, itemFactory: Function<Item.Settings, Item>, settings: Item.Settings) : Item {
        val itemKey: RegistryKey<Item> = RegistryKey.of(
            RegistryKeys.ITEM,
            Identifier.of(
                RsUtilModServerside.MOD_ID,
                name
            )
        )

        val item: Item = itemFactory.apply(settings.registryKey(itemKey))

        Registry.register(Registries.ITEM, itemKey, item)

        return item
    }

    fun initialize() {
        ItemGroupEvents.modifyEntriesEvent(RsUtilModServerside.itemGroupKey)
            .register { it.add(SUSPICIOUS_SUBSTANCE) }
    }
}