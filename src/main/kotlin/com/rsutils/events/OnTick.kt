package com.rsutils.events

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text

object OnTick {

    fun onTick(server: MinecraftServer) {
        getPlayerPositions(server)
    }

    fun getPlayerPositions(server: MinecraftServer) {
        val playerNames = server.playerNames

        for (playerName in playerNames) {
            val player = server.playerManager.getPlayer(playerName)
            if (player?.isPlayer == true) {
                //tellPlayerLocation(player)
            }
        }
    }

    fun tellPlayerLocation(player: ServerPlayerEntity) {
        player.sendMessage(Text.of("Your current location is ${player.lastX} ${player.lastY} ${player.lastZ}"))
    }
}
