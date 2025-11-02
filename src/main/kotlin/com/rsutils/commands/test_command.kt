package com.rsutils.commands

import com.mojang.brigadier.context.CommandContext
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.Text

fun test_command(context: CommandContext<ServerCommandSource>): Int {
    context.source.sendFeedback({ -> Text.literal("Called /test_command")}, false)
    return 1
}