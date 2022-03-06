package me.cheezelzz.compasstrack.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.PlayerMapKey;

public class Utils {

    public static void resetTrackingStatus(Player p) {
        Main.playerToPlayerTrackMap.keySet().removeIf(o -> o.equals(p));
        p.setCompassTarget(p.getWorld().getSpawnLocation());

        if (hasTrackingCompass(p)) {
            p.getInventory().getItem(p.getInventory().first(Material.COMPASS))
                    .setItemMeta(getDefaultCompass().getItemMeta());
        }
    }

    public static ItemStack getDefaultCompass() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName("Tracking Compass");
        compass.setItemMeta(compassMeta);

        return compass;
    }

    public static boolean hasTrackingCompass(Player p) {

        if (p.getInventory().contains(Material.COMPASS)) {
            if (p.getInventory().getItem(p.getInventory().first(Material.COMPASS)).getItemMeta()
                    .getDisplayName().contains("Tracking")) {
                return true;
            }
        }

        return false;
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

    public static void updateCompassNameNewTrack(Player tracker, String compassMessage) {
        if (hasTrackingCompass(tracker)) {
            ItemMeta compassMeta = getDefaultCompass().getItemMeta();
            compassMeta.setDisplayName(compassMessage);

            tracker.getInventory().getItem(tracker.getInventory().first(Material.COMPASS))
                    .setItemMeta(compassMeta);
        }
    }

    public static void initTracking(Player tracker, Player tracked) {
        System.out.println("Calleddd");
        if (tracker.getWorld().getEnvironment()
                .equals(tracked.getWorld().getEnvironment())) {

            updateCompassNameNewTrack(tracker, "Tracking " + tracked.getDisplayName());
            Main.playerToPlayerTrackMap.putIfAbsent(tracker, tracked);
            updatePlayersCompassPointLocation(tracker, tracked);

        } else {
            if (Main.playerToPositionMap
                    .containsKey(new PlayerMapKey(tracked.getDisplayName(),
                            tracker.getWorld().getEnvironment()))) {

                updateCompassNameNewTrack(tracker, "Tracking " + tracked.getDisplayName());
                Main.playerToPlayerTrackMap.putIfAbsent(tracker, tracked);
                updatePlayersCompassPointLocation(tracker, tracked);

            } else {
                tracker.sendMessage("Target player has not entered this world type");
            }
        }
    }

    public static void updatePlayersCompassPointLocation(Player tracker, Player tracked) {
        tracker.setCompassTarget(new Location(
                tracker.getWorld(),
                Main.playerToPositionMap
                        .get(new PlayerMapKey(tracked.getDisplayName(), tracker.getWorld().getEnvironment()))
                        .getX(),
                Main.playerToPositionMap
                        .get(new PlayerMapKey(tracked.getDisplayName(), tracker.getWorld().getEnvironment()))
                        .getY(),
                Main.playerToPositionMap
                        .get(new PlayerMapKey(tracked.getDisplayName(), tracker.getWorld().getEnvironment()))
                        .getZ()));
    }
}
