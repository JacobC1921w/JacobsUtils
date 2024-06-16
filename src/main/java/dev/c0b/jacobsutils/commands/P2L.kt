package dev.c0b.jacobsutils.commands

import com.destroystokyo.paper.utils.PaperPluginLogger
import kotlin.math.ceil
import kotlin.math.floor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class P2L : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender is user or console
        if (user is Player) {
            // Make sure we have permission
            if (user.hasPermission("JacobsUtils.p2l")) {
                // Bamboo planks are handled differently
                if (user.inventory.itemInMainHand.type == Material.BAMBOO_PLANKS) {
                    // Calculate number of sticks and planks returned
                    val itemTotal =
                        floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt()
                    val itemRemainder =
                        ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt()

                    // Remove item in main hand, and give them planks and sticks
                    user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                    user.inventory.addItem(ItemStack(Material.BAMBOO_BLOCK, itemTotal))
                    user.inventory.addItem(ItemStack(Material.BAMBOO_PLANKS, itemRemainder))
                } else {
                    // Make sure they're holding a type of plank
                    if (user.inventory.itemInMainHand.type.name.contains("PLANK")) {
                        // Calculate number of sticks and planks returned
                        val itemTotal =
                            floor((user.inventory.itemInMainHand.amount / 4).toDouble()).toInt()
                        val itemRemainder =
                            ceil((user.inventory.itemInMainHand.amount % 4).toDouble()).toInt()

                        val plankType = user.inventory.itemInMainHand.type

                        // Crimson and warped types are named  differently
                        val logType: Material? =
                            if (
                                plankType in
                                arrayOf(Material.CRIMSON_PLANKS, Material.WARPED_PLANKS)
                            ) {
                                Material.getMaterial(plankType.name.dropLast(7) + "_STEM")
                            } else {
                                Material.getMaterial(plankType.name.dropLast(7) + "_LOG")
                            }

                        // Make sure the log name is valid, otherwise the plank has to be parsed
                        // with the code above
                        if (logType != null) {
                            // Remove current held item, and add the log version, and any remaining
                            // planks
                            user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                            user.inventory.addItem(ItemStack(logType, itemTotal))
                            user.inventory.addItem(ItemStack(plankType, itemRemainder))
                        } else {
                            user.sendMessage(
                                "§f[ §5JacobsUtils §f] Plugin error, please give this code to developer!"
                            )
                            user.sendMessage("§f[ §5JacobsUtils §f] P2L" + plankType.name)
                        }
                    }
                }
            } else {
                user.sendMessage(
                    "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
                )
            }
        } else {
            PaperPluginLogger.getGlobal()
                .warning("[ JacobsUtils ] This command cannot be executed in console!")
        }

        return true
    }
}
