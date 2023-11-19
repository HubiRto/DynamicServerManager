package pl.pomoku.lobby.listeners

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import pl.pomoku.lobby.utils.ItemBuilder

class OnJoin : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val playerInv = event.player.inventory
        playerInv.clear()
        setToolbar(playerInv)
    }

    private fun setToolbar(inv: Inventory) {
        inv.setItem(0, getModeOptionItem())
    }

    private fun getModeOptionItem() : ItemStack {
        return ItemBuilder(Material.COMPASS)
            .name("<green>Wybierz tryb <gray>(PPM)")
            .lore("<gray>Kliknij prawy przycisk myszy", "<gray>, aby wybrać tryb.")
            .build()
    }
}