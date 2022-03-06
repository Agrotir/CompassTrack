package me.cheezelzz.compasstrack.Listeners;

import java.util.Map;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.Utils.Utils;

public class PlayerLeave implements Listener {
    // DONE
    @EventHandler
    public void playerLeave(PlayerQuitEvent e) {

        Utils.resetTrackingStatus(e.getPlayer());

        Main.playerToPlayerTrackMap.entrySet().stream()
                .filter(o -> o.getValue().getDisplayName().equals(e.getPlayer().getDisplayName()))
                .map(Map.Entry::getKey).forEach(trackingPlayer -> {
                    trackingPlayer.sendMessage("Tracked player has left");

                    Utils.resetTrackingStatus(trackingPlayer);
                });

        Main.playerToPlayerTrackMap.values().removeIf(o -> o.equals(e.getPlayer()));
    }
}