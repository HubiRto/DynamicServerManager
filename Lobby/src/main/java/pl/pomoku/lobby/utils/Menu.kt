package pl.pomoku.lobby.utils

import lombok.Getter
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.jetbrains.annotations.NotNull

abstract class Menu(
    @NotNull private val player: Player,
    @NotNull protected val slots: Int,
    @NotNull private val title: Component,
    @NotNull private val fill : Boolean
) : InventoryHolder {
    @Getter
    protected var inv: Inventory? = null
    protected val filter = ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).name(" ").build()
    abstract fun handleMenu(e: InventoryClickEvent)
    abstract fun closeHandleMenu(e: InventoryCloseEvent)
    abstract fun setMenuItems()
    fun open() {
        inv = Bukkit.createInventory(this, slots, title)
        setMenuItems()
        if(fill) fill()
        player.openInventory(inv!!)
    }

    private fun fill() {
        for(i in 0 until slots){
            val slotItem = inv?.getItem(i)
            if(slotItem == null) {
                inv?.setItem(i, filter)
            }
        }
    }
}