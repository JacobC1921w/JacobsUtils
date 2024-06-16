package dev.c0b.jacobsutils.listeners

import dev.c0b.jacobsutils.JacobsUtils
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

class OnCreeperExplodeEvent(private val mainInstance: JacobsUtils) : Listener {
    @EventHandler
    fun onCreeperExplode(event: EntityExplodeEvent) {
        // Make sure a creeper did the exploding
        if (event.entity.type == EntityType.CREEPER) {
            // Check if the config isn't disabled
            if (mainInstance.config.get("creepersDamageBlocks") == false) {
                // Clear the list of blocks meant to be removed, disabling the blocks breaking,
                // while still dealing damage
                event.blockList().clear()
            }
        }
    }
}
