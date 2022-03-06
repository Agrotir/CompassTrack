package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.cheezelzz.compasstrack.Main;
import me.cheezelzz.compasstrack.PlayerMapKey;
import me.cheezelzz.compasstrack.PlayerPosition;

public class PlayerJoin implements Listener {
        // DONE
        @EventHandler
        public void playerJoin(PlayerJoinEvent e) {
                PlayerMapKey playerMapKey = new PlayerMapKey(e.getPlayer().getName(),
                                e.getPlayer().getWorld().getEnvironment());
                PlayerPosition playerPosition = new PlayerPosition(e.getPlayer());
                Main.playerToPositionMap.putIfAbsent(playerMapKey, playerPosition);
        }
}
