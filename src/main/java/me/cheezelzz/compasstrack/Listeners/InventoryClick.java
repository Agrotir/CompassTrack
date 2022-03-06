package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import me.cheezelzz.compasstrack.Utils.Utils;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Tracking Menu")) {
            if (e.getCurrentItem() != null) {
                Player trackingPlayer = (Player) e.getWhoClicked();
                ItemMeta clickedItemMeta = e.getCurrentItem().getItemMeta();

                trackingPlayer.closeInventory();

                if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    String trackedPlayerName = ChatColor.stripColor(clickedItemMeta.getDisplayName());
                    Player trackedPlayer = Bukkit.getPlayer(trackedPlayerName);

                    Utils.initTracking(trackingPlayer, trackedPlayer);

                }
                // else if (e.getCurrentItem().getType() == Material.RED_BED) {

                // String trackedPlayerName =
                // ChatColor.stripColor(clickedItemMeta.getDisplayName())
                // .split("'s ")[0];
                // Player trackedPlayer = Bukkit.getPlayer(trackedPlayerName);

                // if (trackingPlayer.getInventory().getItemInMainHand().getType() ==
                // Material.COMPASS) {
                // if
                // (trackingPlayer.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                // .contains("Tracking")) {
                // ItemMeta compassMeta =
                // trackingPlayer.getInventory().getItemInMainHand().getItemMeta();
                // compassMeta.setDisplayName("Tracking " + trackedPlayerName + "'s Respawn
                // Point");
                // trackingPlayer.getInventory().getItemInMainHand().setItemMeta(compassMeta);
                // }
                // } else if (trackingPlayer.getInventory().getItemInOffHand().getType() ==
                // Material.COMPASS) {
                // if
                // (trackingPlayer.getInventory().getItemInOffHand().getItemMeta().getDisplayName()
                // .contains("Tracking")) {
                // ItemMeta compassMeta =
                // trackingPlayer.getInventory().getItemInOffHand().getItemMeta();
                // compassMeta.setDisplayName("Tracking " + trackedPlayerName + "'s Respawn
                // Point");
                // trackingPlayer.getInventory().getItemInOffHand().setItemMeta(compassMeta);
                // }
                // }
                // if (trackingPlayer.getBedSpawnLocation() != null) {
                // trackingPlayer.setCompassTarget(trackedPlayer.getBedSpawnLocation());
                // } else {
                // trackingPlayer.setCompassTarget(trackedPlayer.getWorld().getSpawnLocation());
                // }

                // if (Main.playerToPlayerTrackMap.containsKey(trackingPlayer)) {
                // Main.playerToPlayerTrackMap.remove(trackingPlayer);
                // }

                // }
                e.setCancelled(true);
            }
        }
    }
}
