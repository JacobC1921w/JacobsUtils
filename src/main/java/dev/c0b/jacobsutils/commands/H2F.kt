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

class H2F : CommandExecutor {
    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {
        // Check if sender is player or console
        if (user is Player) {
            // Make sure they have permission to use this command
            if (user.hasPermission("JacobsUtils.h2f")) {
                // Make sure they're holding something containing the word SLAB
                if (user.inventory.itemInMainHand.type.name.contains("SLAB")) {

                    // Convert half slab amount to full slab, accounting for remainders
                    val itemTotal =
                        floor((user.inventory.itemInMainHand.amount / 2).toDouble()).toInt()
                    val itemRemainder =
                        ceil((user.inventory.itemInMainHand.amount % 2).toDouble()).toInt()

                    val itemHalfBlock = user.inventory.itemInMainHand.type

                    // Convert slab names to their full block values. Values don't all use the same
                    // system for naming, so manually check all outliers
                    val itemFullBlock: Material? =
                        when (itemHalfBlock.name) {
                            in arrayOf(
                                "OAK_SLAB",
                                "SPRUCE_SLAB",
                                "BIRCH_SLAB",
                                "JUNGLE_SLAB",
                                "ACACIA_SLAB",
                                "DARK_OAK_SLAB",
                                "MANGROVE_SLAB",
                                "CHERRY_SLAB",
                                "BAMBOO_SLAB",
                                "CRIMSON_SLAB",
                                "WARPED_SLAB"
                            ) -> {
                                Material.getMaterial(itemHalfBlock.name.dropLast(5) + "_PLANKS")
                            }
                            in arrayOf(
                                "STONE_BRICK_SLAB",
                                "MOSSY_STONE_BRICK_SLAB",
                                "DEEPSLATE_BRICK_SLAB",
                                "DEEPSLATE_TILE_SLAB",
                                "BRICK_SLAB",
                                "MUD_BRICK_SLAB",
                                "PRISMARINE_BRICK_SLAB",
                                "NETHER_BRICK_SLAB",
                                "RED_NETHER_BRICK_SLAB",
                                "POLISHED_BLACKSTONE_BRICK_SLAB",
                                "END_STONE_BRICK_SLAB"
                            ) -> {
                                Material.getMaterial(itemHalfBlock.name.dropLast(5) + "S")
                            }
                            in arrayOf("PURPUR_SLAB", "QUARTZ_SLAB") -> {
                                Material.getMaterial(itemHalfBlock.name.dropLast(5) + "_BLOCK")
                            }
                            else -> {
                                Material.getMaterial(itemHalfBlock.name.dropLast(5))
                            }
                        }

                    // Make sure the full block name is valid, otherwise the half slab has to be
                    // parsed with the code above
                    if (itemFullBlock != null) {
                        // Remove current held item, and add the full block version, and any
                        // remaining half slabs
                        user.inventory.setItemInMainHand(ItemStack(Material.AIR, 0))
                        user.inventory.addItem(ItemStack(itemFullBlock, itemTotal))
                        user.inventory.addItem(ItemStack(itemHalfBlock, itemRemainder))
                    } else {
                        user.sendMessage(
                            "§f[ §5JacobsUtils §f] Plugin error, please give this code to developer!"
                        )
                        user.sendMessage("§f[ §5JacobsUtils §f] H2F" + itemHalfBlock.name)
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
