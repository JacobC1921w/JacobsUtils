package dev.c0b.jacobsutils

import dev.c0b.jacobsutils.commands.*
import org.bukkit.plugin.java.JavaPlugin

class JacobsUtils : JavaPlugin() {
    override fun onEnable() {

        getCommand("cc")?.setExecutor(CC())
        getCommand("coords")?.setExecutor(Coords())
        getCommand("cw")?.setExecutor(CW())
        getCommand("g2f")?.setExecutor(G2F())
        getCommand("gt")?.setExecutor(GT())
        getCommand("h2f")?.setExecutor(H2F())
    }


    override fun onDisable() {
    }
}
