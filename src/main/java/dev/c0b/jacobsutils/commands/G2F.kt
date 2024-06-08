package dev.c0b.jacobsutils.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.Bukkit.getLogger

class G2F: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.g2f")) {
                if (user.inventory.itemInMainHand.type == Material.GRAVEL) {
                    val materialAmount = user.inventory.itemInMainHand.amount

                    user.inventory.setItemInMainHand(ItemStack(Material.FLINT, materialAmount))
                } else {

                    user.sendMessage("§f[ §eJacobsUtils §f] You aren't holding any §dgravel§f!")
                }
            } else {
                user.sendMessage("§f[ §cJacobsUtils §f] You don't have permission to execute this command!")
            }
        } else {
            getLogger().warning("[ JacobsUtils ] This command cannot be executed in console!")
        }

        return true
    }
}