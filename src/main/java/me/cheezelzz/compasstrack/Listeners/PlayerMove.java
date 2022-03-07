package me.cheezelzz.compasstrack.Listeners;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.CompassMeta;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.PlayerMapKey;

public class PlayerMove implements Listener {
        // DONE
        @EventHandler
        public void onMove(PlayerMoveEvent e) {
                if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getY() != e.getTo().getY()
                                || e.getFrom().getZ() != e.getTo().getZ()) {

                        Main.playerToPositionMap.entrySet().stream()
                                        .filter(Pmk -> Pmk.getKey().getPlayerName().equals(e.getPlayer().getName())
                                                        && Pmk.getKey().getEnvironment()
                                                                        .equals(e.getPlayer().getWorld()
                                                                                        .getEnvironment()))
                                        .forEach(o -> {
                                                o.getValue().setLocation(e.getPlayer().getLocation());
                                        });

                        Main.playerToPlayerTrackMap.entrySet().stream()
                                        .filter(entry -> entry.getValue().getDisplayName()
                                                        .equals(e.getPlayer().getDisplayName()))
                                        .map(Map.Entry::getKey).forEach(tracker -> {
                                                if (tracker.getWorld().getEnvironment()
                                                                .equals(e.getPlayer().getWorld().getEnvironment())) {
                                                        Arrays.asList(tracker.getInventory().getContents())
                                                                        .stream()
                                                                        .filter(item -> item != null && item
                                                                                        .getType() == Material.COMPASS
                                                                                        && item.getItemMeta()
                                                                                                        .getDisplayName()
                                                                                                        .contains("Tracking"))
                                                                        .forEach(item -> {
                                                                                CompassMeta compassMeta = (CompassMeta) item
                                                                                                .getItemMeta();

                                                                                compassMeta.setLodestone(
                                                                                                Main.playerToPositionMap
                                                                                                                .get(new PlayerMapKey(
                                                                                                                                e.getPlayer().getDisplayName(),
                                                                                                                                tracker.getWorld()
                                                                                                                                                .getEnvironment()))
                                                                                                                .getLocation(tracker));

                                                                                item.setItemMeta(compassMeta);
                                                                        });
                                                }
                                        });
                }
        }
}
