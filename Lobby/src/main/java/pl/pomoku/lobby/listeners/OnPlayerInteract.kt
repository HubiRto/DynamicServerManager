package pl.pomoku.lobby.listeners

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import pl.pomoku.lobby.menu.ModeOptionMenu

class OnPlayerInteract : Listener {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if(!e.action.isRightClick) return

        val type = e.player.inventory.itemInMainHand.type
        if (type.isAir) return

        when (type) {
            Material.COMPASS -> ModeOptionMenu(e.player).open()
            else -> return
        }
    }
}
