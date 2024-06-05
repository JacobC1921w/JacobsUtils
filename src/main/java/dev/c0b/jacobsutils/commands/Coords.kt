package dev.c0b.jacobsutils.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.Bukkit.getLogger
import kotlin.math.roundToInt

class Coords: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            val location = user.location

            user.server.broadcastMessage("<" + user.name + "> " + location.x.roundToInt().toString() + " / " + location.y.roundToInt().toString() + " / " + location.z.roundToInt().toString())
        } else {
            getLogger().warning("This command cannot be execute in console!");
        }

        return true;
    }
}