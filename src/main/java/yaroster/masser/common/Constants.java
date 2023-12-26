package yaroster.masser.common;

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
        this.log = log;
        this.values = new Hashtable<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Vérifier que la ligne n'est pas vide
                    String[] parse = line.split("=", 2); // Diviser en deux parties maximum
                    if (parse.length == 2) {
                        values.put(parse[0].trim(), parse[1].trim()); // Ajouter la clé et la valeur à la map
                    } else {
                        log.error("Ligne mal formatée dans le fichier de constants : " + line);
                    }
                }
            }

            reader.close();
        } catch (IOException ex) {
            log.error("Erreur de lecture du fichier de constants '" + fileName + "': " + ex.getMessage());
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
