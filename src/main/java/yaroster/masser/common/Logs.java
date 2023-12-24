package yaroster.masser.common;

import yaroster.masser.Masser;
import org.fusesource.jansi.Ansi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

// This class handles logging functionalities.
public class Logs {
	// Basic logging method.
	public void log(String file, String text) {
		this.log(file, text, Masser.DEBUG);
	}

	// Overloaded logging method with a debug flag.
	public void log(String file, String text, boolean debug) {
		if (!debug) {
			return; // Do not log if debug is false.
		}

		try {
			FileWriter writer = new FileWriter("logs/" + file + ".txt", true);
			BufferedWriter output = new BufferedWriter(writer);

			output.write("[" + new Date() + "] " + text + "\r\n"); // Write log entry with timestamp.
			output.flush();
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace(); // Print stack trace for IOException.
		}
	}

	// Method to log informational messages.
	public void information(String text) {
		this.log("informations", text, true);
	}

	// Method to log error messages.
	public void error(String text) {
		System.out.print(Ansi.ansi().fg(Ansi.Color.RED).bold().toString() + text + Ansi.ansi().fg(Ansi.Color.WHITE).boldOff().toString()); // Print error in red color.
		this.log("errors", text, true); // Log the error.
	}

	// Method to log exceptions.
	public void error(Exception exception) {
		exception.printStackTrace(); // Print stack trace.
		this.error(exception.toString()); // Log the exception.
	}

	// Method to log errors with additional text.
	public void error(String text, Exception exception) {
		this.error("[" + text + "] " + exception.toString()); // Log the error with additional text.
		exception.printStackTrace(); // Print stack trace.
	}
}
