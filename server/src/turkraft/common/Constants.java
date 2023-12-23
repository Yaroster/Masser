package turkraft.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

// This class is responsible for managing constants. It reads key-value pairs from a file and stores them in a map.
public class Constants {
	private Map<String, String> values; // Stores the key-value pairs.
	private Logs log; // Logging utility.

	// Constructor: Initializes the logger and reads constants from the specified file.
	public Constants(Logs log, String fileName) {
		this.log = log; // Set the logger.
		this.values = new Hashtable<String, String>(); // Initialize the map.

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName)); // Open file for reading.

			String line;

			while ((line = reader.readLine()) != null) { // Read each line of the file.
				String[] parse = line.split("="); // Split line into key-value pair.
				values.put(parse[0], parse[1]); // Store the pair in the map.
			}

			reader.close(); // Close the file reader.
		} catch (IOException ex) {
			this.log.error("Reading variables file from name " + fileName + ", stack trace: " + ex); // Log any IO exceptions.
		}
	}

	// Method to get a value for a given key.
	public String get(String variable) {
		try {
			return this.values.get(variable); // Return the value for the specified key.
		} catch (Exception ex) {
			this.log.error("Get constants error for variable name: " + variable + ", stack trace: " + ex); // Log any exceptions.
			return "error"; // Return "error" if there's an exception.
		}
	}
}
