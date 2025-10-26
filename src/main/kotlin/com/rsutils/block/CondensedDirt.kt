package com.rsutils.block

import eu.pb4.polymer.core.api.block.PolymerBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import xyz.nucleoid.packettweaker.PacketContext

class CondensedDirt(settings: Settings) : Block(settings), PolymerBlock {
    override fun getPolymerBlockState(state: BlockState?, context: PacketContext?): BlockState? {
        return Blocks.COARSE_DIRT.getStateWithProperties(state)
    }
}