package me.cheezelzz.compasstrack.Listeners;

import java.util.Map;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.PlayerMapKey;
import me.cheezelzz.compasstrack.PlayerPosition;
import me.cheezelzz.compasstrack.Utils.Utils;

public class PlayerChangedWorld implements Listener {
        @EventHandler
        public void onPlayerChangedWorldEvent(PlayerChangedWorldEvent e) {
                PlayerMapKey playerMapKey = new PlayerMapKey(e.getPlayer().getName(),
                                e.getPlayer().getWorld().getEnvironment());
                PlayerPosition playerPosition = new PlayerPosition(e.getPlayer());
                Main.playerToPositionMap.putIfAbsent(playerMapKey, playerPosition);

                Main.playerToPlayerTrackMap.entrySet().stream()
                                .filter(entry -> entry.getValue().getDisplayName()
                                                .equals(e.getPlayer().getDisplayName()))
                                .map(Map.Entry::getKey).forEach(trackingPlayer -> {
                                        Utils.initTracking(trackingPlayer, e.getPlayer());
                                });
        }
}
