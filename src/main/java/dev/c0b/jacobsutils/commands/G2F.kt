package dev.c0b.jacobsutils.commands

import com.destroystokyo.paper.utils.PaperPluginLogger
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class G2F : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender is player or console
        if (user is Player) {
            // Make sure they have permission to execute this command, and that they're actually
            // holding gravel
            if (user.hasPermission("JacobsUtils.g2f")) {
                if (user.inventory.itemInMainHand.type == Material.GRAVEL) {

                    // Get amount of gravel in hand, and replace it with flint
                    val materialAmount = user.inventory.itemInMainHand.amount

                    user.inventory.setItemInMainHand(ItemStack(Material.FLINT, materialAmount))
                } else {

                    user.sendMessage("§f[ §cJacobsUtils §f] You aren't holding any §dgravel§f!")
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
