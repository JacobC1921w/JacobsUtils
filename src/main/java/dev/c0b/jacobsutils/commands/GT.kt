package dev.c0b.jacobsutils.commands

import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class GT : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Make sure they have permission to use this command, and that they have supplied a
        // non-null or empty argument
        if (user.hasPermission("JacobsUtils.gt")) {
            if (args != null && args.isNotEmpty()) {
                // Send message to all players
                user.server.broadcast(
                    Component.text(args.joinToString(prefix = "§a> ", separator = " "))
                )
            } else {
                user.sendMessage(
                    "§f[ §cJacobsUtils §f] This command requires additional arguments!"
                )
            }
        } else {
            user.sendMessage(
                "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
            )
        }

        return true
    }
}
