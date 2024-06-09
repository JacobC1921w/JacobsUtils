## JacobsUtils - Minecraft 1.20.4 Utility Plugin (Kotlin)

This plugin adds a variety of helpful commands and an event handler to enhance your Minecraft 1.20.4 Paper server experience!

### Features

* **10 Useful Commands:** Perform quick actions and receive informative messages.
* **Customizable Creeper Explosions:** Toggle block breaking for a balanced gameplay experience.
* **Easy Integration:** Works seamlessly with Paper servers.
* **Kotlin Made:** Efficient and modern development language.

### Commands

* **/cc**  - Converts held andesite, diorite, or granite into cobblestone.
* **/cw [wood type]** - Converts currently held wood block to another type. (e.g., `/cw warped` for warped wood) 
* **/coords** - Displays your current coordinates in the main chat.
* **/g2f** - Converts held gravel into flint.
* **/gt [message]** - Generates a greentext-styled message in the main chat.
* **/h2f** - Converts half-blocks into their full- block variant.
* **/list** - Lists currently online players.
* **/p2l** - Converts held planks back to their respective logs.
* **/s2p** - Converts sticks back to oak planks.
* **/tce*** - Enables/disables creeper explosions breaking blocks. (Blocks remain intact, damage still occurs, requires OP)


### Event Handler

* **onCreeperExplode:** This event handler allows creeper explosions to break blocks even with `mobGriefing` disabled, enabling villager farms in auto farms.

### Installation

1. Download the JacobsUtils.jar file (place link here when available).
2. Place the jar file in your Paper server's `plugins` folder.
3. Restart your server.

**Compatibility:**

This plugin is designed for Paper servers running Minecraft version 1.20.4.

### Development

JacobsUtils is written in Kotlin, a modern and efficient language for plugin development. If you're interested in contributing, feel free to clone the repository (place link here when available) and submit a pull request!

### License

This plugin is licensed under the MIT License (see LICENSE file for details).
