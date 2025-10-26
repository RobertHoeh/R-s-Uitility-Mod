package com.rsutils

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import java.util.function.Function

object ModItems {
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
}