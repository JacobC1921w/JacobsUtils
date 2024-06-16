package dev.c0b.jacobsutils.commands

import kotlin.math.roundToInt
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit.getLogger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Coords : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender is player or console
        if (user is Player) {
            // Make sure sender has permission
            if (user.hasPermission("JacobsUtils.Coords")) {
                // Store their location to make next line not so illegible
                val location = user.location

                // Broadcast to everyone their location
                user.server.broadcast(
                    Component.text(
                        "<" +
                                user.name +
                                "> " +
                                location.x.roundToInt().toString() +
                                " / " +
                                location.y.roundToInt().toString() +
                                " / " +
                                location.z.roundToInt().toString()
                    )
                )
            } else {
                user.sendMessage(
                    "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
                )
            }
        } else {
            getLogger().warning("[ JacobsUtils ] This command cannot be executed in console!")
        }

        return true
    }
}
