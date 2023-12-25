package yaroster.masser.listeners;

import org.bukkit.event.Listener;
import yaroster.masser.Masser;

// The Listening class serves as a base for event listener classes in the Masser plugin.
public class Listening implements Listener {
    public Masser main;

    // Constructor: Registers this listener with the server's plugin manager.
    public Listening(Masser main) {
        this.main = main;
        // Register the event listener with the main plugin class.
        this.main.getServer().getPluginManager().registerEvents(this, this.main);
    }
}
