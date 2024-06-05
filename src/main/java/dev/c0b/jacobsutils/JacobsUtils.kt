package dev.c0b.jacobsutils

import dev.c0b.jacobsutils.commands.CC
import dev.c0b.jacobsutils.commands.Coords
import org.bukkit.plugin.java.JavaPlugin

class JacobsUtils : JavaPlugin() {
    override fun onEnable() {

        getCommand("cc")?.setExecutor(CC())
        getCommand("coords")?.setExecutor(Coords())
    }


    override fun onDisable() {
    }
}
