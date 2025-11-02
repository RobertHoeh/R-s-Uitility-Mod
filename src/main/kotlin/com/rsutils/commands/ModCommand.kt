package com.rsutils.commands

import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.ServerCommandSource

interface ModCommand {
    fun initialize()

    fun test_command(context: CommandContext<ServerCommandSource>): Int
}