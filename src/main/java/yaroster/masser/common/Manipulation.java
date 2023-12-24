package yaroster.masser.common;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import yaroster.masser.Masser;
import yaroster.masser.stockers.Dinger;
import yaroster.masser.stockers.Plot;

import java.util.ArrayList;
import java.util.Arrays;

// This class provides various utility methods for manipulation and conversion of data.
// (This class is not used in the plugin, but it is used in the server.)

public class Manipulation {
	public static String separator = "#"; // A common separator used in string manipulation.
	public static char[] chars = new char[] { /*...*/ }; // Array of characters used for generating strings.

	// Method to convert a string to a Location object.
	public static Location getLocationWorld(String text, boolean add) {
		// If the text doesn't contain the separator, return null.
		if (!text.contains(separator)) {
			return null;
		}

		// Split the text and create a Location object.
		String[] splits = text.split(separator);
		Location location = new Location(Bukkit.getWorld(splits[0]), Double.parseDouble(splits[1]), Double.parseDouble(splits[2]) + (add ? 1 : 0), Double.parseDouble(splits[3]));
		location.setYaw(Float.parseFloat(splits[4]));
		return location;
	}

	// Overloaded method for getLocationWorld without the 'add' parameter.
	public static Location getLocationWorld(String text) {
		return getLocationWorld(text, false);
	}

	// Method to convert a Location object to a string.
	public static String getLocationWorld(Location location, boolean remove) {
		if (location == null) {
			return "";
		}
		return location.getWorld().getName() + separator + location.getX() + separator + (location.getY() + (remove ? -1 : 0)) + separator + location.getZ() + separator + location.getYaw();
	}

	// Overloaded method for getLocationWorld without the 'remove' parameter.
	public static String getLocationWorld(Location location) {
		return getLocationWorld(location, false);
	}

	// Method to convert a string to a Dinger object.
	public static Dinger getDinger(String text, boolean toTimeL) {
		String[] splits = text.split(separator);
		if (!toTimeL)
			return new Dinger(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));

		return new Dinger(Integer.parseInt(splits[0]) * 20, Integer.parseInt(splits[1]) * 20);
	}

	// Method to convert a Dinger object to a string.
	public static String getDinger(Dinger dinger) {
		return dinger.x + separator + dinger.y;
	}

	//...

	// Method to generate a random integer between min and max (inclusive).
	public static int random(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	// Method to check if a given string represents a "true" value.
	public static boolean isTrue(String text) {
		return text.equalsIgnoreCase("1");
	}

	// Method to get the current date and time in a specific format.
	public static String getDateTime() {
		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
	}

	// Method to concatenate array elements into a single string, separated by a given separator.
	public static String charsFromArraySeparator(String[] items, String separator) {
		return charsFromArraySeparator(0, items, separator);
	}

	// Overloaded method for charsFromArraySeparator with an additional 'from' index parameter.
	public static String charsFromArraySeparator(int from, String[] items, String separator) {
		StringBuilder toReturn = new StringBuilder();
		int remove = 0;

		for (int i = from; i < items.length; i++) {
			if (items[i].equalsIgnoreCase("") || items[i].equalsIgnoreCase(" ")) {
				remove++;
				continue;
			}
			toReturn.append(items[i]).append(separator);
		}

		if (items.length - remove > 0) {
			toReturn = new StringBuilder(toReturn.substring(0, toReturn.length() - separator.length()));
		}

		return toReturn.toString();
	}

	// Method to convert a string representation of a plot to a Plot object.
	public static Plot plotFromString(Masser main, String configuration) {
		String[] split = configuration.split(separator);
		String[] point1 = split[1].split(":");
		String[] point2 = split[2].split(":");

		return new Plot(
				new Location(main.getServer().getWorld(split[0]), Integer.parseInt(point1[0]), 0, Integer.parseInt(point1[1])),
				new Location(main.getServer().getWorld(split[0]), Integer.parseInt(point2[0]), 0, Integer.parseInt(point2[1]))
		);
	}

	// Method to convert a Plot object to its string representation.
	public static String plotLocationToString(Plot plot) {
		return plot.pointA.getWorld().getName() + separator + plot.pointA.getBlockX() + ":" + plot.pointA.getBlockZ() + separator + plot.pointB.getBlockX() + ":" + plot.pointB.getBlockZ();
	}

	// Method to determine if a given EntityType is an animal.
	public static boolean isAnimal(EntityType Element) {
		// A list of entity types considered as animals.
		return Element == EntityType.COW || Element == EntityType.CHICKEN
				|| Element == EntityType.PIG || Element == EntityType.SHEEP
				|| Element == EntityType.MUSHROOM_COW || Element == EntityType.WOLF
				|| Element == EntityType.OCELOT || Element == EntityType.SNOWMAN
				|| Element == EntityType.BAT || Element == EntityType.IRON_GOLEM;
	}

	// Method to split a string by a separator and return it as an ArrayList.
	public static ArrayList<String> stringArrayFromSplit(String text, String separator) {
		return new ArrayList<>(Arrays.asList(text.split(separator)));
	}

	// Method to format chat messages with a specific color and structure.
	public static String chatFormat(ChatColor color, String sayer, String content) {
		return chatFormat(color, sayer, content, true);
	}

	// Overloaded chatFormat method with an additional 'bracket' flag.
	public static String chatFormat(ChatColor color, String sayer, String content, boolean bracket) {
		if (bracket) {
			return "<" + sayer + ChatColor.WHITE + "> " + color + content;
		} else {
			return sayer + ChatColor.WHITE + " " + color + content;
		}
	}

	// Method to capitalize the first letter of each word in a string.
	public static String capitalizeFirst(String text) {
		StringBuilder newText = new StringBuilder(text);

		for (int i = 0; i < newText.length(); i++) {
			if (i == 0 || !Character.isLetterOrDigit(newText.charAt(i - 1))) {
				newText.setCharAt(i, Character.toUpperCase(newText.charAt(i)));
			}
		}

		return newText.toString();
	}

	// Method to determine if a given material is a sword.
	public static boolean isSword(Material material) {
		// A list of materials that are considered swords.
		return material == Material.WOODEN_SWORD || material == Material.STONE_SWORD
				|| material == Material.IRON_SWORD || material == Material.DIAMOND_SWORD;
	}

	// Method to determine if a given material is a hoe.
	public static boolean isHoe(Material material) {
		// A list of materials that are considered hoes.
		return material == Material.WOODEN_HOE || material == Material.STONE_HOE
				|| material == Material.IRON_HOE || material == Material.DIAMOND_HOE
				|| material == Material.GOLDEN_HOE;
	}

	// Method to calculate damage based on the type of hoe.
	public static int damageFromHoe(Material material) {
		// Damage ranges are defined for different types of hoes.
		if (material == Material.WOODEN_HOE) {
			return random(1, 3);
		} else if (material == Material.STONE_HOE) {
			return random(1, 7);
		} else if (material == Material.GOLDEN_HOE) {
			return random(1, 9);
		} else if (material == Material.IRON_HOE) {
			return random(2, 14);
		} else if (material == Material.DIAMOND_HOE) {
			return random(3, 17);
		}

		return 0; // Return 0 if the material is not a hoe.
	}

	// Method to generate a random word of a specified length.
	public static String generateWord(int min, int max) {
		StringBuilder text = new StringBuilder();
		int count = random(min, max);

		for (int i = 0; i < count; i++) {
			text.append(chars[random(0, chars.length - 1)]);
		}

		return text.toString();
	}

	// Method to generate a string of random words with specified word and sentence lengths.
	public static String generateWords(int minWords, int maxWords, int minWordLength, int maxWordLength) {
		StringBuilder text = new StringBuilder();
		int count = random(minWords, maxWords);

		for (int i = 0; i < count; i++) {
			text.append(generateWord(minWordLength, maxWordLength)).append(" ");
		}

		return text.toString().trim();
	}
}
