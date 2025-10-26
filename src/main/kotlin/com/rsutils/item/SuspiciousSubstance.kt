package com.rsutils.item

import com.rsutils.RsUtilModServerside
import eu.pb4.polymer.core.api.item.SimplePolymerItem
import net.minecraft.component.type.TooltipDisplayComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.thread.TaskQueue
import xyz.nucleoid.packettweaker.PacketContext
import java.util.function.Consumer

class SuspiciousSubstance (settings: Item.Settings) : SimplePolymerItem(settings) {
    init{

    }
    override fun appendTooltip(
        stack: ItemStack?,
        context: TooltipContext?,
        displayComponent: TooltipDisplayComponent?,
        textConsumer: Consumer<Text?>?,
        type: TooltipType?
    ) {
        textConsumer?.accept(Text.translatable("itemTooltip.${RsUtilModServerside.MOD_ID}.suspicious_substance")
            .formatted(Formatting.GOLD))
    }

    override fun getPolymerItem(itemStack: ItemStack?, context: PacketContext?): Item? {
        return Items.GUNPOWDER
    }
}