package me.cheezelzz.compasstrack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.google.gson.Gson;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cheezelzz.compasstrack.Listeners.InteractEvent;
import me.cheezelzz.compasstrack.Listeners.InventoryClick;
import me.cheezelzz.compasstrack.Listeners.PlayerChangedWorld;
import me.cheezelzz.compasstrack.Listeners.PlayerDeath;
import me.cheezelzz.compasstrack.Listeners.PlayerDropItem;
import me.cheezelzz.compasstrack.Listeners.PlayerJoin;
import me.cheezelzz.compasstrack.Listeners.PlayerLeave;
import me.cheezelzz.compasstrack.Listeners.PlayerMove;

public class Main extends JavaPlugin {

    public static HashMap<PlayerMapKey, PlayerPosition> playerToPositionMap;
    public static HashMap<Player, Player> playerToPlayerTrackMap;

    public void onEnable() {
        getCommand("track").setExecutor(new Commands());
        getCommand("debug").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChangedWorld(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItem(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeave(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);

        playerToPlayerTrackMap = new HashMap<>();

        playerToPositionMap = new HashMap<>();

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(this.getDataFolder().getCanonicalPath() + "/test.json"));
            HashMap<?, ?> test = gson.fromJson(reader, HashMap.class);

            test.entrySet().forEach(entry -> {
                System.out.println(((PlayerMapKey) entry.getKey()).getPlayerName() + ", "
                        + ((PlayerMapKey) entry.getKey()).getEnvironment() + " -> ["
                        + ((PlayerPosition) entry.getValue()).getX().intValue() + "]["
                        + ((PlayerPosition) entry.getValue()).getY().intValue() + "]["
                        + ((PlayerPosition) entry.getValue()).getZ().intValue() + "]");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDisable() {
        try {
            Gson gson = new Gson();
            File file = new File(this.getDataFolder().getCanonicalPath() + "/test.json");
            file.getParentFile().mkdir();
            file.createNewFile();
            Writer writer = new FileWriter(file, false);
            gson.toJson(playerToPositionMap, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
