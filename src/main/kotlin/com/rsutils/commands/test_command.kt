package com.rsutils.commands

import com.mojang.brigadier.arguments.IntegerArgumentType
import com.mojang.brigadier.context.CommandContext
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.argument.EntityArgumentType
import net.minecraft.command.suggestion.SuggestionProviders
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.command.SpreadPlayersCommand
import net.minecraft.text.Text

object TestCommand: ModCommand {
    override fun initialize() {
        CommandRegistrationCallback.EVENT.register { dispatcher, registryAccess, environment ->
            dispatcher.register(CommandManager.literal("test_command")
                .then(CommandManager.argument("value", IntegerArgumentType.integer())
                    .requires { source -> source.hasPermissionLevel(1) }
                    .executes(::test_command)))
        }
    }

    override fun test_command(context: CommandContext<ServerCommandSource>): Int {
        val value = IntegerArgumentType.getInteger(context, "value")
        context.source.sendFeedback(
            { -> Text.literal("Called /test_command with value $value") },
            false
        )
        return 1
    }
}