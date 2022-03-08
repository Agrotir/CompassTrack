package me.cheezelzz.compasstrack.Utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.PlayerMapKey;

public class Utils {

    public static ItemStack getDefaultCompass() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        compassMeta.setDisplayName("Tracking Compass");
        compass.setItemMeta(compassMeta);

        return compass;
    }

    public static void resetTrackingStatus(Player p) {

        Arrays.asList(p.getInventory().getContents()).stream()
                .filter(item -> item != null && item.getType() == Material.COMPASS
                        && item.getItemMeta().getDisplayName().contains("Tracking"))
                .forEach(item -> {
                    item.setItemMeta(Utils.getDefaultCompass().getItemMeta());
                });
    }

    public static boolean hasTrackingCompassEquipped(Player p) {

        if (p.getInventory().getItemInMainHand().getType() == Material.COMPASS && p
                .getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Tracking")) {
            return true;
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.COMPASS && p
                .getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Tracking")) {
            return true;
        }

        return false;
    }

    public static void initTracking(Player tracker, Player tracked) {
        if (tracker.getWorld().getEnvironment()
                .equals(tracked.getWorld().getEnvironment())) {

            Main.playerToPlayerTrackMap.putIfAbsent(tracker, tracked);
            updatePlayersCompassPointPlayerLocation(tracker, tracked);

        } else {
            if (Main.playerToPositionMap
                    .containsKey(new PlayerMapKey(tracked.getDisplayName(),
                            tracker.getWorld().getEnvironment()))) {

                Main.playerToPlayerTrackMap.putIfAbsent(tracker, tracked);
                updatePlayersCompassPointPlayerLocation(tracker, tracked);

            } else {
                tracker.sendMessage("Target player has not entered this world type");
            }
        }
    }

    public static void updatePlayersCompassPointPlayerLocation(Player tracker, Player tracked) {

        Arrays.asList(tracker.getInventory().getContents()).stream()
                .filter(item -> item != null && item.getType() == Material.COMPASS
                        && item.getItemMeta().getDisplayName().contains("Tracking"))
                .forEach(item -> {
                    CompassMeta compassMeta = (CompassMeta) item.getItemMeta();

                    compassMeta.setDisplayName("Tracking " + tracked.getDisplayName());
                    compassMeta.setLodestone(Main.playerToPositionMap
                            .get(new PlayerMapKey(tracked.getDisplayName(), tracker.getWorld().getEnvironment()))
                            .getLocation(tracker));
                    compassMeta.setLodestoneTracked(false);

                    item.setItemMeta(compassMeta);
                });
    }

    public static void updatePlayersCompassPointBedSpawnLocation(Player tracker, Player tracked) {

        Arrays.asList(tracker.getInventory().getContents()).stream()
                .filter(item -> item != null && item.getType() == Material.COMPASS
                        && item.getItemMeta().getDisplayName().contains("Tracking"))
                .forEach(item -> {
                    CompassMeta compassMeta = (CompassMeta) item.getItemMeta();

                    compassMeta.setDisplayName("Tracking " + tracked.getDisplayName() + "'s Respawn Point");
                    compassMeta.setLodestone(Main.playerToPositionMap
                            .get(new PlayerMapKey(tracked.getDisplayName(), tracker.getWorld().getEnvironment()))
                            .getLocation(tracker));
                    compassMeta.setLodestoneTracked(false);

                    item.setItemMeta(compassMeta);
                });
    }
}
