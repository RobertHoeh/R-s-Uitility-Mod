package com.rsutils.block

import com.rsutils.RsUtilModServerside
import com.rsutils.mixin.SettingsAccessor
import eu.pb4.polymer.blocks.api.BlockModelType
import eu.pb4.polymer.blocks.api.PolymerBlockModel
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock
import eu.pb4.polymer.core.api.block.PolymerBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.util.Identifier
import xyz.nucleoid.packettweaker.PacketContext
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents

class CondensedDirt(settings: Settings) : Block(settings), PolymerTexturedBlock {
    private val blockModel = PolymerBlockModel.of(
        (this.settings as SettingsAccessor).registryKey.value.withPrefixedPath("block/")
    )

    val blockState = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, blockModel)

    override fun getPolymerBlockState(state: BlockState?, context: PacketContext?): BlockState? {
        return this.blockState
    }
}