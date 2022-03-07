package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClickAnvil implements Listener {
    // DONE
    @EventHandler
    public void playerRename(InventoryClickEvent e) {
        if (e.getView().getType() == InventoryType.ANVIL) {
            if (e.getRawSlot() == 2) {
                if (e.getView().getItem(0).getType() != Material.AIR
                        && e.getView().getItem(2).getType() != Material.AIR) {
                    if (!e.getView().getItem(0).getItemMeta().getDisplayName()
                            .equals(e.getView().getItem(2).getItemMeta()
                                    .getDisplayName())) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}