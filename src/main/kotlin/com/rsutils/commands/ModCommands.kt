package com.rsutils.commands

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import net.minecraft.text.Text

object ModCommands {
    fun initialize() {
        CommandRegistrationCallback.EVENT.register { dispatcher, registryAccess, environment ->
            dispatcher.register(CommandManager.literal("test_command")
                .requires { source -> source.hasPermissionLevel(1) }
                .executes(::test_command))
        }
    }
}