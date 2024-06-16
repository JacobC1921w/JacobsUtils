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

class S2P : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender is a player or console
        if (user is Player) {
            // Make sure we have permission, and if we're actually holding sticks
            if (user.hasPermission("JacobsUtils.s2p")) {
                if (user.inventory.itemInMainHand.type == Material.STICK) {

                    // Do some maths with conversion to planks, and the remainder we'll return as
                    // sticks
                    val planks =
                        ItemStack(
                            Material.OAK_PLANKS,
                            floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt()
                        )
                    val sticks =
                        ItemStack(
                            Material.STICK,
                            ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt()
                        )

                    // Remove currently held sticks, and give them the planks, with remaining sticks
                    user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                    user.inventory.addItem(planks)
                    user.inventory.addItem(sticks)
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
