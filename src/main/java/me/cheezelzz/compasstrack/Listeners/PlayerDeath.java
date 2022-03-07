package me.cheezelzz.compasstrack.Listeners;

import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.cheezelzz.compasstrack.Utils.Utils;

public class PlayerDeath implements Listener {
    // DONE
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Utils.resetTrackingStatus(e.getEntity());
        e.getDrops().stream()
                .filter(item -> item.getType() == Material.COMPASS
                        && item.getItemMeta().getDisplayName().contains("Tracking"))
                .collect(Collectors.toList())
                .forEach(o -> o.setAmount(0));
    }
}
