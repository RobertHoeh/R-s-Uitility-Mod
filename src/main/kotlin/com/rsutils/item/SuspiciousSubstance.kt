package com.rsutils.item

import com.rsutils.RsUtilModServerside
import net.minecraft.component.type.TooltipDisplayComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import java.util.function.Consumer

class SuspiciousSubstance (settings: Item.Settings) : Item(settings) {
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
}