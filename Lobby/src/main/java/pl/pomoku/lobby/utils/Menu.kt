package pl.pomoku.lobby.utils

import lombok.Getter
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class Menu(private var player: Player) : InventoryHolder {
    @Getter
    private var inventory: Inventory? = null
    abstract val menuName: Component?
    abstract val slots: Int

    abstract fun handleMenu(e: InventoryClickEvent?)
    abstract fun closeHandleMenu(e: InventoryCloseEvent?)
    abstract fun setMenuItems()
    fun open() {
        inventory = Bukkit.createInventory(this, slots, menuName!!)
        setMenuItems()
        player.openInventory(inventory!!)
    }
}