package yaroster.masser;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import yaroster.masser.common.Manipulation;
import yaroster.masser.stockers.Dinger;

import java.util.Map;

public class Configuration {
    public boolean acceptConnections = true;
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


    public Configuration(Map<String, String> variables) {
//
//        this.acceptConnections = Manipulation.isTrue(variables.get("acceptConnections"));
//
//        this.maximumBuyMoney = Integer.parseInt(variables.get("maximumBuyMoney"));
//
//        this.maximumKillMoney = Integer.parseInt(variables.get("maximumKillMoney"));
//
//        this.maximumPlayers = Integer.parseInt(variables.get("maximumPlayers"));
//
//        this.spawnPoint = Manipulation.getLocationWorld(variables.get("spawnPoint"), true);
//
//        this.whiteList = Manipulation.isTrue(variables.get("whiteList"));
//
//        this.defaultLanguage = Integer.parseInt(variables.get("defaultLanguage"));
//
//        this.rimeInterval = Manipulation.getDinger(variables.get("rimeInterval"), true);
//
//        this.killMoneyPourcentage = Integer.parseInt(variables.get("killmoneypourcentage"));
//
//        this.killPourcentageRandom = Integer.parseInt(variables.get("killpourcentagerandom")); //avoir le pourcentage qui varie entre random(killPourcentageRandom-ca, killPourcentageRandom+ca)
//
//        this.protectedSpawnTime = Integer.parseInt(variables.get("protectedspawntime")) * 20; //multiplication par 20 pour les tick scheduler
//
//        this.minimumLengthTerrain = Integer.parseInt(variables.get("minimumlengthterrain"));
//
//        this.mobKillEachOther = Boolean.parseBoolean(variables.get("mobkilleachother"));
//
//        this.maximumGroupGamer = Integer.parseInt(variables.get("maximumGroupGamer"));
//
//        this.restartTime = Integer.parseInt(variables.get("restartTime")) * 20;
//
//        this.stopTime = Integer.parseInt(variables.get("stopTime")) * 20;
//
//        this.saveInterval = Integer.parseInt(variables.get("saveInterval")) * 20;
//
//        this.whitelistMax = Integer.parseInt(variables.get("whitelistMax"));
//
//        this.maximumLengthTerrain = Integer.parseInt(variables.get("maximumlengthterrain"));
//
//        this.clanCollision = Integer.parseInt(variables.get("clanCollision"));
//
//        this.minimumLengthClan = Integer.parseInt(variables.get("minimumLengthClan"));
//
//        this.alertRestClan = Integer.parseInt(variables.get("alertRestClan"));
//
//        this.clanMinimumInteract = Integer.parseInt(variables.get("clanMinimumInteract"));
//
//        this.maximumClanMembers = Integer.parseInt(variables.get("maximumClanMembers"));
//
//        this.checkSession = Boolean.parseBoolean(variables.get("checkSession"));
//
//        this.fightMinimumReco = Integer.parseInt(variables.get("fightMinimumReco"));
//
//        this.fightInterval = Integer.parseInt(variables.get("fightInterval"));
//
//        this.restart = Boolean.parseBoolean(variables.get("restart"));
    }
}
