package dev.c0b.jacobsutils.commands

import org.bukkit.Bukkit.getLogger
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

class CW: CommandExecutor {
    override fun onCommand(user: CommandSender, cmd: Command, p2: String, args: Array<out String>?): Boolean {
        if (user is Player) {
            if (user.hasPermission("JacobsUtils.CW")) {
                val boats = mutableMapOf<String, Material>()
                boats["acacia"] = Material.ACACIA_BOAT
                boats["birch"] = Material.BIRCH_BOAT
                boats["cherry"] = Material.CHERRY_BOAT
                boats["dark_oak"] = Material.DARK_OAK_BOAT
                boats["jungle"] = Material.JUNGLE_BOAT
                boats["mangrove"] = Material.MANGROVE_BOAT
                boats["oak"] = Material.OAK_BOAT
                boats["spruce"] = Material.SPRUCE_BOAT

                val boatChests = mutableMapOf<String, Material>()
                boatChests["acacia"] = Material.ACACIA_CHEST_BOAT
                boatChests["birch"] = Material.BIRCH_CHEST_BOAT
                boatChests["cherry"] = Material.CHERRY_CHEST_BOAT
                boatChests["dark_oak"] = Material.DARK_OAK_CHEST_BOAT
                boatChests["jungle"] = Material.JUNGLE_CHEST_BOAT
                boatChests["mangrove"] = Material.MANGROVE_CHEST_BOAT
                boatChests["oak"] = Material.OAK_CHEST_BOAT
                boatChests["spruce"] = Material.SPRUCE_CHEST_BOAT

                val buttons = mutableMapOf<String, Material>()
                buttons["acacia"] = Material.ACACIA_BUTTON
                buttons["birch"] = Material.BIRCH_BUTTON
                buttons["cherry"] = Material.CHERRY_BUTTON
                buttons["dark_oak"] = Material.DARK_OAK_BUTTON
                buttons["jungle"] = Material.JUNGLE_BUTTON
                buttons["mangrove"] = Material.MANGROVE_BUTTON
                buttons["oak"] = Material.OAK_BUTTON
                buttons["spruce"] = Material.SPRUCE_BUTTON

                val doors = mutableMapOf<String, Material>()
                doors["acacia"] = Material.ACACIA_DOOR
                doors["birch"] = Material.BIRCH_DOOR
                doors["cherry"] = Material.CHERRY_DOOR
                doors["dark_oak"] = Material.DARK_OAK_DOOR
                doors["jungle"] = Material.JUNGLE_DOOR
                doors["mangrove"] = Material.MANGROVE_DOOR
                doors["oak"] = Material.OAK_DOOR
                doors["spruce"] = Material.SPRUCE_DOOR

                val fences = mutableMapOf<String, Material>()
                fences["acacia"] = Material.ACACIA_FENCE
                fences["birch"] = Material.BIRCH_FENCE
                fences["cherry"] = Material.CHERRY_FENCE
                fences["dark_oak"] = Material.DARK_OAK_FENCE
                fences["jungle"] = Material.JUNGLE_FENCE
                fences["mangrove"] = Material.MANGROVE_FENCE
                fences["oak"] = Material.OAK_FENCE
                fences["spruce"] = Material.SPRUCE_FENCE

                val fenceGates = mutableMapOf<String, Material>()
                fenceGates["acacia"] = Material.ACACIA_FENCE_GATE
                fenceGates["birch"] = Material.BIRCH_FENCE_GATE
                fenceGates["cherry"] = Material.CHERRY_FENCE_GATE
                fenceGates["dark_oak"] = Material.DARK_OAK_FENCE_GATE
                fenceGates["jungle"] = Material.JUNGLE_FENCE_GATE
                fenceGates["mangrove"] = Material.MANGROVE_FENCE_GATE
                fenceGates["oak"] = Material.OAK_FENCE_GATE
                fenceGates["spruce"] = Material.SPRUCE_FENCE_GATE

                val hangingSigns = mutableMapOf<String, Material>()
                hangingSigns["acacia"] = Material.ACACIA_HANGING_SIGN
                hangingSigns["birch"] = Material.BIRCH_HANGING_SIGN
                hangingSigns["cherry"] = Material.CHERRY_HANGING_SIGN
                hangingSigns["dark_oak"] = Material.DARK_OAK_HANGING_SIGN
                hangingSigns["jungle"] = Material.JUNGLE_HANGING_SIGN
                hangingSigns["mangrove"] = Material.MANGROVE_HANGING_SIGN
                hangingSigns["oak"] = Material.OAK_HANGING_SIGN
                hangingSigns["spruce"] = Material.SPRUCE_HANGING_SIGN

                val logs = mutableMapOf<String, Material>()
                logs["acacia"] = Material.ACACIA_LOG
                logs["birch"] = Material.BIRCH_LOG
                logs["cherry"] = Material.CHERRY_LOG
                logs["dark_oak"] = Material.DARK_OAK_LOG
                logs["jungle"] = Material.JUNGLE_LOG
                logs["mangrove"] = Material.MANGROVE_LOG
                logs["oak"] = Material.OAK_LOG
                logs["spruce"] = Material.SPRUCE_LOG

                val planks = mutableMapOf<String, Material>()
                planks["acacia"] = Material.ACACIA_PLANKS
                planks["birch"] = Material.BIRCH_PLANKS
                planks["cherry"] = Material.CHERRY_PLANKS
                planks["dark_oak"] = Material.DARK_OAK_PLANKS
                planks["jungle"] = Material.JUNGLE_PLANKS
                planks["mangrove"] = Material.MANGROVE_PLANKS
                planks["oak"] = Material.OAK_PLANKS
                planks["spruce"] = Material.SPRUCE_PLANKS

                val pressurePlates = mutableMapOf<String, Material>()
                pressurePlates["acacia"] = Material.ACACIA_PRESSURE_PLATE
                pressurePlates["birch"] = Material.BIRCH_PRESSURE_PLATE
                pressurePlates["cherry"] = Material.CHERRY_PRESSURE_PLATE
                pressurePlates["dark_oak"] = Material.DARK_OAK_PRESSURE_PLATE
                pressurePlates["jungle"] = Material.JUNGLE_PRESSURE_PLATE
                pressurePlates["mangrove"] = Material.MANGROVE_PRESSURE_PLATE
                pressurePlates["oak"] = Material.OAK_PRESSURE_PLATE
                pressurePlates["spruce"] = Material.SPRUCE_PRESSURE_PLATE

                val signs = mutableMapOf<String, Material>()
                signs["acacia"] = Material.ACACIA_SIGN
                signs["birch"] = Material.BIRCH_SIGN
                signs["cherry"] = Material.CHERRY_SIGN
                signs["dark_oak"] = Material.DARK_OAK_SIGN
                signs["jungle"] = Material.JUNGLE_SIGN
                signs["mangrove"] = Material.MANGROVE_SIGN
                signs["oak"] = Material.OAK_SIGN
                signs["spruce"] = Material.SPRUCE_SIGN

                val slabs = mutableMapOf<String, Material>()
                slabs["acacia"] = Material.ACACIA_SLAB
                slabs["birch"] = Material.BIRCH_SLAB
                slabs["cherry"] = Material.CHERRY_SLAB
                slabs["dark_oak"] = Material.DARK_OAK_SLAB
                slabs["jungle"] = Material.JUNGLE_SLAB
                slabs["mangrove"] = Material.MANGROVE_SLAB
                slabs["oak"] = Material.OAK_SLAB
                slabs["spruce"] = Material.SPRUCE_SLAB

                val stairs = mutableMapOf<String, Material>()
                stairs["acacia"] = Material.ACACIA_STAIRS
                stairs["birch"] = Material.BIRCH_STAIRS
                stairs["cherry"] = Material.CHERRY_STAIRS
                stairs["dark_oak"] = Material.DARK_OAK_STAIRS
                stairs["jungle"] = Material.JUNGLE_STAIRS
                stairs["mangrove"] = Material.MANGROVE_STAIRS
                stairs["oak"] = Material.OAK_STAIRS
                stairs["spruce"] = Material.SPRUCE_STAIRS

                val strippedLogs = mutableMapOf<String, Material>()
                strippedLogs["acacia"] = Material.STRIPPED_ACACIA_LOG
                strippedLogs["birch"] = Material.STRIPPED_BIRCH_LOG
                strippedLogs["cherry"] = Material.STRIPPED_CHERRY_LOG
                strippedLogs["dark_oak"] = Material.STRIPPED_DARK_OAK_LOG
                strippedLogs["jungle"] = Material.STRIPPED_JUNGLE_LOG
                strippedLogs["mangrove"] = Material.STRIPPED_MANGROVE_LOG
                strippedLogs["oak"] = Material.STRIPPED_OAK_LOG
                strippedLogs["spruce"] = Material.STRIPPED_SPRUCE_LOG

                val strippedWood = mutableMapOf<String, Material>()
                strippedWood["acacia"] = Material.STRIPPED_ACACIA_WOOD
                strippedWood["birch"] = Material.STRIPPED_BIRCH_WOOD
                strippedWood["cherry"] = Material.STRIPPED_CHERRY_WOOD
                strippedWood["dark_oak"] = Material.STRIPPED_DARK_OAK_WOOD
                strippedWood["jungle"] = Material.STRIPPED_JUNGLE_WOOD
                strippedWood["mangrove"] = Material.STRIPPED_MANGROVE_WOOD
                strippedWood["oak"] = Material.STRIPPED_OAK_WOOD
                strippedWood["spruce"] = Material.STRIPPED_SPRUCE_WOOD

                val trapdoors = mutableMapOf<String, Material>()
                trapdoors["acacia"] = Material.ACACIA_TRAPDOOR
                trapdoors["birch"] = Material.BIRCH_TRAPDOOR
                trapdoors["cherry"] = Material.CHERRY_TRAPDOOR
                trapdoors["dark_oak"] = Material.DARK_OAK_TRAPDOOR
                trapdoors["jungle"] = Material.JUNGLE_TRAPDOOR
                trapdoors["mangrove"] = Material.MANGROVE_TRAPDOOR
                trapdoors["oak"] = Material.OAK_TRAPDOOR
                trapdoors["spruce"] = Material.SPRUCE_TRAPDOOR

                val wood = mutableMapOf<String, Material>()
                wood["acacia"] = Material.ACACIA_WOOD
                wood["birch"] = Material.BIRCH_WOOD
                wood["cherry"] = Material.CHERRY_WOOD
                wood["dark_oak"] = Material.DARK_OAK_WOOD
                wood["jungle"] = Material.JUNGLE_WOOD
                wood["mangrove"] = Material.MANGROVE_WOOD
                wood["oak"] = Material.OAK_WOOD
                wood["spruce"] = Material.SPRUCE_WOOD

                var specifiedWoodType = "oak"

                if (args != null && args.isNotEmpty()) {
                    specifiedWoodType = args[0].lowercase(Locale.getDefault())
                }

                if (boats.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(boats.getOrDefault(specifiedWoodType, Material.OAK_BOAT), user.inventory.itemInMainHand.amount))
                } else if (boatChests.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(boatChests.getOrDefault(specifiedWoodType, Material.OAK_CHEST_BOAT), user.inventory.itemInMainHand.amount))
                } else if (buttons.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(buttons.getOrDefault(specifiedWoodType, Material.OAK_BUTTON), user.inventory.itemInMainHand.amount))
                } else if (doors.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(doors.getOrDefault(specifiedWoodType, Material.OAK_DOOR), user.inventory.itemInMainHand.amount))
                } else if (fences.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(fences.getOrDefault(specifiedWoodType, Material.OAK_FENCE), user.inventory.itemInMainHand.amount))
                } else if (fenceGates.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(fenceGates.getOrDefault(specifiedWoodType, Material.OAK_FENCE_GATE), user.inventory.itemInMainHand.amount))
                } else if (hangingSigns.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(hangingSigns.getOrDefault(specifiedWoodType, Material.OAK_HANGING_SIGN), user.inventory.itemInMainHand.amount))
                } else if (logs.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(logs.getOrDefault(specifiedWoodType, Material.OAK_LOG), user.inventory.itemInMainHand.amount))
                } else if (planks.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(planks.getOrDefault(specifiedWoodType, Material.OAK_PLANKS), user.inventory.itemInMainHand.amount))
                } else if (pressurePlates.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(pressurePlates.getOrDefault(specifiedWoodType, Material.OAK_PRESSURE_PLATE), user.inventory.itemInMainHand.amount))
                } else if (signs.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(signs.getOrDefault(specifiedWoodType, Material.OAK_SIGN), user.inventory.itemInMainHand.amount))
                } else if (slabs.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(slabs.getOrDefault(specifiedWoodType, Material.OAK_SLAB), user.inventory.itemInMainHand.amount))
                } else if (stairs.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(stairs.getOrDefault(specifiedWoodType, Material.OAK_STAIRS), user.inventory.itemInMainHand.amount))
                } else if (strippedLogs.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(strippedLogs.getOrDefault(specifiedWoodType, Material.STRIPPED_OAK_LOG), user.inventory.itemInMainHand.amount))
                } else if (strippedWood.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(strippedWood.getOrDefault(specifiedWoodType, Material.STRIPPED_OAK_WOOD), user.inventory.itemInMainHand.amount))
                } else if (trapdoors.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(trapdoors.getOrDefault(specifiedWoodType, Material.OAK_TRAPDOOR), user.inventory.itemInMainHand.amount))
                } else if (wood.values.contains(user.inventory.itemInMainHand.type)) {
                    user.inventory.setItemInMainHand(ItemStack(wood.getOrDefault(specifiedWoodType, Material.OAK_WOOD), user.inventory.itemInMainHand.amount))
                } else {
                    user.sendMessage("§f[ §cJacobsUtils §f] You must be holding a wood-type block!")
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