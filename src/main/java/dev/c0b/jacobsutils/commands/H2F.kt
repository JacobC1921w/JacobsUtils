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

class H2F: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.h2f")) {
                if (user.inventory.itemInMainHand.type.name.contains("SLAB")) {
                    val itemTotal = floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt()
                    val itemRemainder = ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt()
                    val itemHalfBlock = user.inventory.itemInMainHand.type
                    val itemFullBlock: Material?

                    if (itemHalfBlock.name in arrayOf("OAK_SLAB", "SPRUCE_SLAB", "BIRCH_SLAB", "JUNGLE_SLAB", "ACACIA_SLAB", "DARK_OAK_SLAB", "MANGROVE_SLAB", "CHERRY_SLAB", "BAMBOO_SLAB", "CRIMSON_SLAB", "WARPED_SLAB")) {
                        itemFullBlock = Material.getMaterial(itemHalfBlock.name.dropLast(5) + "_PLANKS")
                    } else if (itemHalfBlock.name in arrayOf("STONE_BRICK_SLAB", "MOSSY_STONE_BRICK_SLAB", "DEEPSLATE_BRICK_SLAB", "DEEPSLATE_TILE_SLAB", "BRICK_SLAB", "MUD_BRICK_SLAB", "PRISMARINE_BRICK_SLAB", "NETHER_BRICK_SLAB", "RED_NETHER_BRICK_SLAB", "POLISHED_BLACKSTONE_BRICK_SLAB", "END_STONE_BRICK_SLAB")) {
                        itemFullBlock = Material.getMaterial(itemHalfBlock.name.dropLast(5) + "S")
                    } else if (itemHalfBlock.name in arrayOf("PURPUR_SLAB", "QUARTZ_SLAB")) {
                        itemFullBlock = Material.getMaterial(itemHalfBlock.name.dropLast(5) + "_BLOCK")
                    } else {
                        itemFullBlock = Material.getMaterial(itemHalfBlock.name.dropLast(5))
                    }
                    Material.QUARTZ_SLAB

                    if (itemFullBlock != null) {
                        user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                        user.inventory.addItem(ItemStack(itemFullBlock, itemTotal))
                        user.inventory.addItem(ItemStack(itemHalfBlock, itemRemainder))
                    } else {
                        user.sendMessage("§f[ §5JacobsUtils §f] Plugin error, please give this code to developer!")
                        user.sendMessage("§f[ §5JacobsUtils §f] H2F" + itemHalfBlock.name)
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