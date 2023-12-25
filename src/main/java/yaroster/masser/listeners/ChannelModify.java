package yaroster.masser.listeners;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import yaroster.masser.Masser;
import yaroster.masser.stockers.Gamer;

// This class listens for specific plugin messages and performs actions based on those messages.
public class ChannelModify implements PluginMessageListener {
    Masser main;

    // Constructor: Initializes with a reference to the main plugin class.
    public ChannelModify(Masser main) {
        this.main = main;
    }

    // Method called when a plugin message is received.
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        Gamer gamer = this.main.getGamer(player.getName(), true); // Get the Gamer instance for the player.
        String content = new String(message); // Convert the message to a String.

        // Check if the content of the message indicates cheating (e.g., x-ray usage).
        if (content.equalsIgnoreCase("1") || content.equalsIgnoreCase("2")) {
            // Broadcast a cheating message and ban the player.
            this.main.broadcastTextAbbrev("ban.cheat.xray", "<" + gamer.source.getDisplayName() + ">");
            gamer.ban(); // Ban the player.
        }
    }
}
