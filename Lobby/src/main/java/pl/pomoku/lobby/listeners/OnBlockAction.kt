package pl.pomoku.lobby.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent

class OnBlockAction : Listener {
    @EventHandler
    fun onBreak(e: BlockBreakEvent) {
        if (!e.player.hasPermission("lobby.blockBreak")) e.isCancelled = true
    }

    @EventHandler
    fun onPlace(e: BlockPlaceEvent) {
        if (!e.player.hasPermission("lobby.blockPlace")) e.isCancelled = true
    }
}