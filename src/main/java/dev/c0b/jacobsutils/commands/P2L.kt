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

class P2L: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.p2l")) {
                if (user.inventory.itemInMainHand.type == Material.BAMBOO_PLANKS) {
                    val itemTotal = floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt()
                    val itemRemainder = ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt()

                    user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                    user.inventory.addItem(ItemStack(Material.BAMBOO_BLOCK, itemTotal))
                    user.inventory.addItem(ItemStack(Material.BAMBOO_PLANKS, itemRemainder))
                } else {
                    if (user.inventory.itemInMainHand.type.name.contains("PLANK")) {
                        val itemTotal = floor((user.inventory.itemInMainHand.amount / 4).toDouble()).toInt()
                        val itemRemainder = ceil((user.inventory.itemInMainHand.amount % 4).toDouble()).toInt()
                        val plankType = user.inventory.itemInMainHand.type
                        val logType: Material?

                        if (plankType in arrayOf(Material.CRIMSON_PLANKS, Material.WARPED_PLANKS)) {
                            logType = Material.getMaterial(plankType.name.dropLast(7) + "_STEM")
                        } else {
                            logType = Material.getMaterial(plankType.name.dropLast(7) + "_LOG")
                        }
                        if (logType != null) {
                            user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                            user.inventory.addItem(ItemStack(logType, itemTotal))
                            user.inventory.addItem(ItemStack(plankType, itemRemainder))
                        } else {
                            user.sendMessage("§f[ §5JacobsUtils §f] Plugin error, please give this code to developer!")
                            user.sendMessage("§f[ §5JacobsUtils §f] P2L" + plankType.name)
                        }

                    }
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