package pl.pomoku.lobby.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent

class OnItemPickup : Listener {
    @EventHandler
    fun onPickup(e : EntityPickupItemEvent) {
        val player = e.entity as? Player
        if (player != null) {
            if (!player.hasPermission("lobby.pickup")) e.isCancelled = true
        }
    }
}