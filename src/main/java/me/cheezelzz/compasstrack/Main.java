package me.cheezelzz.compasstrack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

        // Gson gson = new Gson();

        // try {
        // Reader reader =
        // Files.newBufferedReader(Paths.get(this.getDataFolder().getCanonicalPath() +
        // "/test.json"));
        // HashMap<?, ?> test = gson.fromJson(reader, HashMap.class);

        try {
            File file = new File(this.getDataFolder().getCanonicalPath() + "/playerToPositionMap.json");

            if (file.exists()) {
                Reader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);

                Type type = new TypeToken<HashMap<PlayerMapKey, PlayerPosition>>() {
                }.getType();
                HashMap<PlayerMapKey, PlayerPosition> test = new Gson().fromJson(br.readLine(), type);

                br.close();

                test.entrySet().forEach(entry -> {
                    System.out.println(entry.getKey().getPlayerName() + ", "
                            + entry.getKey().getEnvironment() + " -> ["
                            + entry.getValue().getX().intValue() + "]["
                            + entry.getValue().getY().intValue() + "]["
                            + entry.getValue().getZ().intValue() + "]");
                });
            } else {
                playerToPositionMap = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDisable() {
        try {
            File file = new File(this.getDataFolder().getCanonicalPath() + "/playerToPositionMap.json");
            file.getParentFile().mkdir();
            file.createNewFile();

            Writer writer = new FileWriter(file, false);
            new Gson().toJson(playerToPositionMap, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
