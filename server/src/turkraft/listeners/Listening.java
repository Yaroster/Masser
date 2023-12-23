package turkraft.listeners;

import org.bukkit.event.Listener;
import turkraft.Turkraft;

// The Listening class serves as a base for event listener classes in the Turkraft plugin.
public class Listening implements Listener {
	public Turkraft main;

	// Constructor: Registers this listener with the server's plugin manager.
	public Listening(Turkraft main) {
		this.main = main;
		// Register the event listener with the main plugin class.
		this.main.getServer().getPluginManager().registerEvents(this, this.main);
	}
}
