package dev.c0b.jacobsutils.commands

import com.destroystokyo.paper.utils.PaperPluginLogger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class List : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender has permission
        if (user.hasPermission("JacobsUtils.list")) {
            // Check if the sender is a player
            if (user is Player) {
                user.sendMessage("§f[ §aJacobsUtils §f] Online players:")

                // Iterate over online players
                for (player in user.server.onlinePlayers) {
                    if (player.name == "JacobC1921") {
                        // I'm special :)
                        user.sendMessage(
                            "§f[ §aJacobsUtils §f] - §kiii§r §l§6J§ea§2c§ao§bb§3C§11§99§d2§51§r §kiii"
                        )
                    } else {
                        user.sendMessage("§f[ §aJacobsUtils §f] - " + player.name)
                    }
                }
            } else {
                // Log to console all online players
                PaperPluginLogger.getGlobal().info("[ JacobsUtils ] Online players:")

                // Iterate over online players, and display their names
                for (player in user.server.onlinePlayers) {
                    PaperPluginLogger.getGlobal().info("[ JacobsUtils ] - " + player.name)
                }
            }
        } else {
            user.sendMessage(
                "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
            )
        }

        return true
    }
}
