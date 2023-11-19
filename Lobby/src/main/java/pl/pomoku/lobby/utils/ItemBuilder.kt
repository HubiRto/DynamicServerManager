package pl.pomoku.lobby.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.SkullMeta
import org.jetbrains.annotations.NotNull
import java.util.*

class ItemBuilder(@NotNull material: Material) {
    private val item: ItemStack
    private val material: Material
    private var itemMeta: ItemMeta? = null
    private var skullMeta: SkullMeta? = null
    private var name: Component? = null
    private val lore: MutableList<Component> = ArrayList()

    init {
        this.material = material
        item = ItemStack(material)
        if (material == Material.PLAYER_HEAD) skullMeta = item.itemMeta as SkullMeta
    }

    fun name(@NotNull text: Component): ItemBuilder {
        name = text
        return this
    }

    fun name(@NotNull text: String): ItemBuilder {
        return name(MiniMessage.miniMessage().deserialize(text))
    }

    fun lore(@NotNull text: Component): ItemBuilder {
        lore.add(text)
        return this
    }

    fun lore(@NotNull text: String): ItemBuilder {
        return lore(MiniMessage.miniMessage().deserialize(text))
    }

    fun lore(@NotNull lore: List<String>): ItemBuilder {
        lore.stream().map { line: String -> MiniMessage.miniMessage().deserialize(line) }
            .forEach { e: Component -> this.lore.add(e) }
        return this
    }

    fun lore(@NotNull vararg lore: String): ItemBuilder {
        Arrays.stream(lore).map { line: String -> MiniMessage.miniMessage().deserialize(line) }
            .forEach { e: Component -> this.lore.add(e) }
        return this
    }

    fun build(): ItemStack {
        item.setType(material)
        if (skullMeta != null) item.setItemMeta(skullMeta)
        if (itemMeta == null) itemMeta = item.itemMeta
        if (name != null) itemMeta!!.displayName(name)
        if (!lore.isEmpty()) itemMeta!!.lore(lore)
        item.setItemMeta(itemMeta)
        return item
    }
}
