package dev.c0b.jacobsutils.commands

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit.getLogger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.math.roundToInt

class Coords: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.Coords")) {
                val location = user.location


                user.server.broadcast(Component.text("<" + user.name + "> " + location.x.roundToInt().toString() + " / " + location.y.roundToInt().toString() + " / " + location.z.roundToInt().toString()))
            } else {
                user.sendMessage("§f[ §cJacobsUtils §f] You don't have permission to execute this command!")
            }
        } else {
            getLogger().warning("[ JacobsUtils ] This command cannot be executed in console!")
        }

        return true
    }
}