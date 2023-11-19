package pl.pomoku.lobby.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent

class OnDamage : Listener {
    @EventHandler
    fun onKill(e: PlayerDeathEvent) {
        if (!e.player.hasPermission("lobby.kill")) e.isCancelled = true
    }

    @EventHandler
    fun onDamage(e: EntityDamageEvent){
        val player = e.entity as? Player
        if(player != null && !player.hasPermission("lobby.damage")) e.isCancelled = true
    }

    @EventHandler
    fun onDamageAnotherPlayer(e: EntityDamageByEntityEvent) {
        val player = e.damager as? Player
        if(player != null && !player.hasPermission("lobby.damageAnother")) e.isCancelled = true
    }
}