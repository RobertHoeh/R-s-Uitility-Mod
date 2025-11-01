package com.rsutils.events

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents

object ModEvents {
    fun initialize() {
        ServerTickEvents.END_SERVER_TICK.register { OnTick.onTick(it) }
    }
}