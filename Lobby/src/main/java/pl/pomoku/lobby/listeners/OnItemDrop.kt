package pl.pomoku.lobby.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent

class OnItemDrop : Listener {
    @EventHandler
    fun onDrop(e : PlayerDropItemEvent) {
        if (!e.player.hasPermission("lobby.drop")) e.isCancelled = true
    }
}