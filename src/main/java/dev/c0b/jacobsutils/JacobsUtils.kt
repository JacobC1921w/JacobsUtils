package dev.c0b.jacobsutils

import dev.c0b.jacobsutils.commands.*
import dev.c0b.jacobsutils.listeners.OnCreeperExplodeEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class JacobsUtils : JavaPlugin() {

    override fun onEnable() {

        // If not config files exist (i.e. on first run) we'll save the default one
        saveDefaultConfig()

        // Set command handlers
        getCommand("cc")?.setExecutor(CC())
        getCommand("coords")?.setExecutor(Coords())
        getCommand("cw")?.setExecutor(CW())
        getCommand("g2f")?.setExecutor(G2F())
        getCommand("gt")?.setExecutor(GT())
        getCommand("h2f")?.setExecutor(H2F())
        getCommand("list")?.setExecutor(List())
        getCommand("p2l")?.setExecutor(P2L())
        getCommand("s2p")?.setExecutor(S2P())
        getCommand("tce")?.setExecutor(TCE(this))

        // Set event listeners
        Bukkit.getPluginManager().registerEvents(OnCreeperExplodeEvent(this), this)
    }
}
