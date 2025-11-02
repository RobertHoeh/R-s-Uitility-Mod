package com.rsutils.commands

import com.mojang.brigadier.arguments.IntegerArgumentType
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.server.command.CommandManager
import net.minecraft.text.Text
import org.apache.logging.log4j.core.util.Integers

object ModCommands {
    fun initialize() {
        TestCommand.initialize()
    }
}