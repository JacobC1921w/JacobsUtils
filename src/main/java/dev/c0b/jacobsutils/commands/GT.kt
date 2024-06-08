package dev.c0b.jacobsutils.commands

import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GT: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user.hasPermission("JacobsUtils.gt")) {
            if (args != null && args.isNotEmpty()) {
                if (user is Player) {
                    user.sendMessage(args.joinToString(prefix = "§a> ", separator = " "))
                } else {
                    user.server.broadcast(Component.text(args.joinToString(prefix = "§a> ",separator = " ")))
                }
            } else {
                user.sendMessage("§f[ §cJacobsUtils §f] This command requires additional arguments!")
            }
        } else {
            user.sendMessage("§f[ §cJacobsUtils §f] You don't have permission to execute this command!")
        }

        return true
    }
}