package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.cheezelzz.compasstrack.UI.PlayersUI;
import me.cheezelzz.compasstrack.Utils.Utils;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onChooseTarget(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS
                    && e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                            .contains("Tracking")
                    || e.getPlayer().getInventory().getItemInOffHand().getType() == Material.COMPASS
                            && e.getPlayer().getInventory().getItemInOffHand().getItemMeta().getDisplayName()
                                    .contains("Tracking")) {
                Utils.resetTrackingStatus(e.getPlayer());
                e.getPlayer().openInventory(PlayersUI.GUI(e.getPlayer()));
                return;
            }
        }
    }
}
