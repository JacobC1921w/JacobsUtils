package dev.c0b.jacobsutils.commands

import org.bukkit.Bukkit.getLogger
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import kotlin.math.ceil
import kotlin.math.floor

class S2P: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.s2p")) {
                    if (user.inventory.itemInMainHand.type == Material.STICK) {
                        val planks = ItemStack(Material.OAK_PLANKS, floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt())
                        val sticks = ItemStack(Material.STICK, ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt())

                        user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                        user.inventory.addItem(planks)
                        user.inventory.addItem(sticks)
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