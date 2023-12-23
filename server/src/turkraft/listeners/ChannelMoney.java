package turkraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import turkraft.Turkraft;
import turkraft.stockers.Gamer;

// This class listens for plugin messages related to a player's money.
public class ChannelMoney implements PluginMessageListener {
	Turkraft main;

	// Constructor: Initializes with a reference to the main plugin class.
	public ChannelMoney(Turkraft main) {
		this.main = main;
	}

	// Method called when a plugin message is received.
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		Gamer gamer = this.main.getGamer(player.getName(), true); // Get the Gamer instance for the player.

		// Check if the gamer is in prison.
		if (!gamer.isPrison()) {
			// If not in prison, send data about the gamer's money.
			gamer.sendData("money", "%" + Integer.toString(gamer.information.money));
			return;
		}

		// If the gamer is in prison, send data about the time left in prison.
		gamer.sendData("money", "#" + Integer.toString(gamer.information.prisonLeft));
	}
}
