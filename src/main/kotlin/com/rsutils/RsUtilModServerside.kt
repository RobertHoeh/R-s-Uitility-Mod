package com.rsutils

import com.rsutils.block.ModBlocks
import com.rsutils.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object RsUtilModServerside : ModInitializer {
    const val MOD_ID: String = "rsutils"
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world From Server")

        ModItems.initialize()
        ModBlocks.initialize()
	}
}