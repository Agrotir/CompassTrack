package me.cheezelzz.compasstrack.Listeners;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.cheezelzz.compasstrack.Main;

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
                                        .map(Map.Entry::getKey).forEach(trackingPlayer -> {
                                                if (trackingPlayer.getWorld().getEnvironment()
                                                                .equals(e.getPlayer().getWorld().getEnvironment())) {
                                                        trackingPlayer.setCompassTarget(new Location(
                                                                        trackingPlayer.getWorld(),
                                                                        e.getPlayer().getLocation().getX(),
                                                                        e.getPlayer().getLocation().getY(),
                                                                        e.getPlayer().getLocation().getZ()));
                                                }
                                        });
                }
        }
}
