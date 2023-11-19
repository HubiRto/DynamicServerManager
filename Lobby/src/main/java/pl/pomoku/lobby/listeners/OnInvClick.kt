package pl.pomoku.lobby.listeners

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.PlayerInventory
import pl.pomoku.lobby.menu.ModeOptionMenu
import pl.pomoku.lobby.utils.Menu

class OnInvClick : Listener {
    @EventHandler
    fun onClick(e : InventoryClickEvent) {
        if (!e.whoClicked.hasPermission("lobby.invClick")) e.isCancelled = true
        val holder = e.clickedInventory

        if(e.currentItem == null) return
        if(e.currentItem!!.type == Material.AIR) return

        if(holder is Menu){
            holder.handleMenu(e)
        }

    }
}