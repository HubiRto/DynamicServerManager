package pl.pomoku.lobby

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections

class Lobby : JavaPlugin() {
    override fun onEnable() {
        loadListeners()
    }

    private fun loadListeners() {
        val packageName = javaClass.getPackage().name
        for(clazz in  Reflections("$packageName.listeners").getSubTypesOf(Listener::class.java)) {
            val listener: Listener = clazz.getDeclaredConstructor().newInstance() as Listener
            server.pluginManager.registerEvents(listener, this)
        }
    }
}
