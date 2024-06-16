package dev.c0b.jacobsutils.commands

import com.destroystokyo.paper.utils.PaperPluginLogger
import dev.c0b.jacobsutils.JacobsUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TCE(private val mainInstance: JacobsUtils) : CommandExecutor {

    override fun onCommand(
        user: CommandSender,
        cmd: Command,
        p2: String,
        args: Array<out String>?
    ): Boolean {

        // Make sure we have permission to change the config
        if (user.hasPermission("JacobsUtils.tce")) {
            // Flip the value of the config and save
            val flippedStatus: Boolean = mainInstance.config.get("creepersDamageBlocks") != true
            mainInstance.config.set("creepersDamageBlocks", flippedStatus)
            mainInstance.saveConfig()

            // Return the new value
            if (user is Player) {
                user.sendMessage(
                    "§f[ §aJacobsUtils §f] creepersDamageBlocks set to §e$flippedStatus"
                )
            } else {
                PaperPluginLogger.getGlobal()
                    .info("[ JacobsUtils ] creepersDamageBlocks set to $flippedStatus")
            }
        } else {
            user.sendMessage(
                "§f[ §cJacobsUtils §f] You don't have permission to execute this command!"
            )
        }

        return true
    }
}
