package yaroster.masser.events;

import yaroster.masser.Masser;
import yaroster.masser.common.Manipulation;

// This class is responsible for scheduling and managing a repeating task, likely related to broadcasting rimes (poems or verses) in the game.
public class Rimer {
	public Masser main; // Instance of the main plugin class.
	private boolean loop; // Flag to control the repeating task.
	private int taskID; // ID of the scheduled task.

	// Constructor: Initializes the Rimer with a reference to the main plugin class.
	public Rimer(Masser main) {
		this.main = main;
		this.loop = false; // Initially, the loop is set to false.
	}

	// Method to start the repeating task.
	public void start() {
		this.loop = true; // Set the loop flag to true.
		this.repeat(); // Start the repeating process.
	}

	// Private method to schedule and execute the repeating task.
	private void repeat() {
		// Schedule a delayed task with a random delay.
		this.taskID = this.main.getServer().getScheduler().scheduleSyncDelayedTask(this.main, new Runnable() {
			public void run() {
				int selected = randomSelect(); // Randomly select a rime.
				main.broadcastRimeText(selected); // Broadcast the selected rime.

				if (loop) {
					repeat(); // If the loop flag is still true, repeat the task.
				}
			}
		}, Manipulation.random(this.main.configuration.rimeInterval.x, this.main.configuration.rimeInterval.y));
	}

	// Method to stop the repeating task.
	public void stop() {
		this.loop = false; // Set the loop flag to false.
		this.main.getServer().getScheduler().cancelTask(this.taskID); // Cancel the scheduled task.
	}

	// Private method to randomly select a rime.
	private int randomSelect() {
		// Return a random rime ID.
		return this.main.getRimeIdByIndex(Manipulation.random(0, this.main.countRimes()));
	}
}
