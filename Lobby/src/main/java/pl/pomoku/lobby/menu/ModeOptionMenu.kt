package pl.pomoku.lobby.menu

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.jetbrains.annotations.NotNull
import pl.pomoku.lobby.utils.ItemBuilder
import pl.pomoku.lobby.utils.Menu

class ModeOptionMenu(@NotNull player: Player) :
    Menu(player, 9, MiniMessage.miniMessage().deserialize("<dark_gray><bold>WYBIERZ TRYB"), true) {

    override fun handleMenu(e: InventoryClickEvent) {

    }

    override fun closeHandleMenu(e: InventoryCloseEvent) {

    }

    override fun setMenuItems() {
        inv?.setItem(4, survivalModeItem())
    }

    override fun getInventory(): Inventory {
        TODO("Not yet implemented")
    }

    private fun survivalModeItem(): ItemStack {
        return ItemBuilder(Material.GRASS_BLOCK)
            .name(" ")
            .lore(
                " <dark_gray>x <gray>Serwer: <#BFDAA7>Survival",
                " <dark_gray>x <gray>Online jest <#BFDAA7>0 graczy</#BFDAA7>.",
                " ",
                " <dark_gray>>> <#BFDAA7>Buduj cokolwiek zechcesz, bez",
                " <dark_gray>>> <#BFDAA7>jakichkolwiek ograniczeń.",
                " <dark_gray>>> <#BFDAA7>Główna wersja serwera to <gray>1.20.2</gray>.",
                " <dark_gray>>> <#BFDAA7>Serwer wspiera wersje <gray>1.8 - 1.20.2</gray>."
            )
            .build()
    }
}