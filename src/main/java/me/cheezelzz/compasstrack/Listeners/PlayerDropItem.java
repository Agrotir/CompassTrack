package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.cheezelzz.compasstrack.Utils.Utils;

public class PlayerDropItem implements Listener {
    // DONE
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Tracking")) {
                Utils.resetTrackingStatus(e.getPlayer());
                e.getItemDrop().remove();
            }
        }
    }
}
