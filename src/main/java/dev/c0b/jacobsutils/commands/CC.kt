package dev.c0b.jacobsutils.commands

import org.bukkit.Bukkit.getLogger
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class CC : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {

        // Check if the sender is user or server
        if (user is Player) {

            // Check if user has permission to use this command
            if (user.hasPermission("JacobsUtils.cc")) {

                // Check if they're holding andesite, diorite, or granite
                if (
                    user.inventory.itemInMainHand.type in
                    arrayOf(Material.ANDESITE, Material.DIORITE, Material.GRANITE)
                ) {
                    // Get amount of (andes/dior/gran)ite in hand, and replace it with cobblestone
                    val materialAmount = user.inventory.itemInMainHand.amount

                    user.inventory.setItemInMainHand(
                        ItemStack(Material.COBBLESTONE, materialAmount)
                    )
                } else {

                    user.sendMessage(
                        "§f[ §cJacobsUtils §f] You aren't holding any §dandesite§f, §ddiorite§f, or §dgranite§f!"
                    )
                }
            } else {
                user.sendMessage(
                    "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
                )
            }
        } else {
            // If sender is console, warn them, as they don't have an inventory
            getLogger().warning("[ JacobsUtils ] This command cannot be executed in console!")
        }

        return true
    }
}
