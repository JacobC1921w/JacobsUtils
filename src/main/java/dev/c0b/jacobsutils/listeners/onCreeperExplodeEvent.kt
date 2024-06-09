package dev.c0b.jacobsutils.listeners

import dev.c0b.jacobsutils.JacobsUtils
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent

class onCreeperExplodeEvent(private val mainInstance: JacobsUtils): Listener {
    @EventHandler
    fun onCreeperExplode(event: EntityExplodeEvent) {
        if(event.entity.type == EntityType.CREEPER) {
            if (mainInstance.config.get("creepersDamageBlocks") == false) {
                event.blockList().clear()
            }
        }
    }
}