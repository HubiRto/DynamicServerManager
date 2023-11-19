package pl.pomoku.dynamicservercontroller

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

@Plugin(id = "dynamicservercontroller", name = "DynamicServerController", version = BuildConstants.VERSION)
class DynamicServerController {
    @Inject
    private val logger: Logger? = null
    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent?) {
    }
}
