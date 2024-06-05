package dev.c0b.jacobsutils.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.Bukkit.getLogger

class CC: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.inventory.itemInMainHand.type in arrayOf(Material.ANDESITE, Material.DIORITE, Material.GRANITE)) {
                val materialAmount = user.inventory.itemInMainHand.amount

                user.inventory.setItemInMainHand(ItemStack(Material.COBBLESTONE, materialAmount))
            } else {
                user.sendMessage("§cYou aren't holding any andesite, diorite or granite!")
            }
        } else {
            getLogger().warning("This command cannot be execute in console!");
        }

        return true;
    }
}