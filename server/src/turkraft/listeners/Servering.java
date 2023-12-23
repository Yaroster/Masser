package turkraft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.server.ServerListPingEvent;
import turkraft.Turkraft;

// The Servering class extends Listening and is responsible for handling server-related events.
public class Servering extends Listening {

	// Constructor: Calls the super constructor of the Listening class.
	public Servering(Turkraft main) {
		super(main);
	}

	// Event handler for ServerListPingEvent.
	@EventHandler (priority = EventPriority.NORMAL)
	public void onServerListPing(ServerListPingEvent event) {
		// Sets the message of the day (MOTD) that players see in their server list.
		event.setMotd("Please use the Turkraft launcher!");

		// The following line is commented out, but it would normally set the maximum number of players.
		// Event.setMaxPlayers(this.main.configuration.maximumPlayers);
	}
}
