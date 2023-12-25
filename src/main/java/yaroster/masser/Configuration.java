package yaroster.masser;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_20_R2.CraftWorld;
import yaroster.masser.common.Manipulation;
import yaroster.masser.stockers.Dinger;

import java.util.Map;

public class Configuration
{
    public boolean acceptConnections = false;
    public int maximumBuyMoney = 1000;
    public int maximumKillMoney = 500;
    public int maximumPlayers = 100;
    public Location spawnPoint = new Location(Bukkit.getWorld("world"), 0, 64, 0); // Exemple de valeur par défaut
    public boolean whiteList = false;
    public int defaultLanguage = 1; // ID de langue par défaut
    public int killMoneyPourcentage = 10;
    public int killPourcentageRandom = 5;
    public Dinger rimeInterval = new Dinger(2400, 4800); // Valeurs par défaut pour Dinger
    public int protectedSpawnTime = 600; // 30 secondes * 20 ticks
    public int minimumLengthTerrain = 10;
    public boolean mobKillEachOther = false;
    public int maximumGroupGamer = 10;
    public int restartTime = 144000; // 2 heures * 20 ticks * 60 * 60
    public int stopTime = 6000; // 5 minutes * 20 ticks * 60
    public int saveInterval = 12000; // 10 minutes * 20 ticks * 60
    public int whitelistMax = 100;
    public int maximumLengthTerrain = 50;
    public int clanCollision = 5;
    public int minimumLengthClan = 15;
    public int alertRestClan = 10;
    public int clanMinimumInteract = 3;
    public int maximumClanMembers = 30;
    public boolean checkSession = true;
    public int fightMinimumReco = 1200; // 60 secondes * 20 ticks
    public int fightInterval = 6000; // 5 minutes * 20 ticks * 60
    public boolean restart = true;

    private static boolean parseBoolean(String value, boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static int parseInt(String value, int defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    private Location parseLocation(String locationString, Location defaultValue) {
        if (locationString == null || locationString.isEmpty()) {
            return defaultValue;
        }

        String[] parts = locationString.split(",");
        if (parts.length != 4) {
            return defaultValue;
        }

        String worldName = parts[0];
        try {
            double x = Double.parseDouble(parts[1]);
            double y = Double.parseDouble(parts[2]);
            double z = Double.parseDouble(parts[3]);
            return new Location(Bukkit.getWorld(worldName), x, y, z);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private Dinger parseDinger(String dingerString, Dinger defaultValue) {
        if (dingerString == null || dingerString.isEmpty()) {
            return defaultValue;
        }

        String[] parts = dingerString.split(";");
        if (parts.length != 2) {
            return defaultValue;
        }

        try {
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            return new Dinger(part1, part2);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }





    public Configuration(Map<String, String> variables) {
        // Utiliser les méthodes parseBoolean et parseInt ici avec les valeurs par défaut déjà définies
        this.acceptConnections = parseBoolean(variables.get("acceptConnections"), this.acceptConnections);
        this.maximumBuyMoney = parseInt(variables.get("maximumBuyMoney"), this.maximumBuyMoney);
        this.maximumKillMoney = parseInt(variables.get("maximumKillMoney"), this.maximumKillMoney);
        this.maximumPlayers = parseInt(variables.get("maximumPlayers"), this.maximumPlayers);

        // Vous devez implémenter une méthode pour analyser les valeurs de Location et Dinger
        this.spawnPoint = parseLocation(variables.get("spawnPoint"), this.spawnPoint);
        this.whiteList = parseBoolean(variables.get("whiteList"), this.whiteList);
        this.defaultLanguage = parseInt(variables.get("defaultLanguage"), this.defaultLanguage);
        this.killMoneyPourcentage = parseInt(variables.get("killMoneyPourcentage"), this.killMoneyPourcentage);
        this.killPourcentageRandom = parseInt(variables.get("killPourcentageRandom"), this.killPourcentageRandom);

        this.rimeInterval = parseDinger(variables.get("rimeInterval"), this.rimeInterval);
        this.protectedSpawnTime = parseInt(variables.get("protectedSpawnTime"), this.protectedSpawnTime) * 20;
        this.minimumLengthTerrain = parseInt(variables.get("minimumLengthTerrain"), this.minimumLengthTerrain);
        this.mobKillEachOther = parseBoolean(variables.get("mobKillEachOther"), this.mobKillEachOther);
        this.maximumGroupGamer = parseInt(variables.get("maximumGroupGamer"), this.maximumGroupGamer);
        this.restartTime = parseInt(variables.get("restartTime"), this.restartTime) * 20;
        this.stopTime = parseInt(variables.get("stopTime"), this.stopTime) * 20;
        this.saveInterval = parseInt(variables.get("saveInterval"), this.saveInterval) * 20;
        this.whitelistMax = parseInt(variables.get("whitelistMax"), this.whitelistMax);
        this.maximumLengthTerrain = parseInt(variables.get("maximumLengthTerrain"), this.maximumLengthTerrain);
        this.clanCollision = parseInt(variables.get("clanCollision"), this.clanCollision);
        this.minimumLengthClan = parseInt(variables.get("minimumLengthClan"), this.minimumLengthClan);
        this.alertRestClan = parseInt(variables.get("alertRestClan"), this.alertRestClan);
        this.clanMinimumInteract = parseInt(variables.get("clanMinimumInteract"), this.clanMinimumInteract);
        this.maximumClanMembers = parseInt(variables.get("maximumClanMembers"), this.maximumClanMembers);
        this.checkSession = parseBoolean(variables.get("checkSession"), this.checkSession);
        this.fightMinimumReco = parseInt(variables.get("fightMinimumReco"), this.fightMinimumReco);
        this.fightInterval = parseInt(variables.get("fightInterval"), this.fightInterval);
        this.restart = parseBoolean(variables.get("restart"), this.restart);
    }

}
