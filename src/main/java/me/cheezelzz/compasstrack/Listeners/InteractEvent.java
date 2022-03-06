package me.cheezelzz.compasstrack.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.cheezelzz.compasstrack.UI.PlayersUI;
import me.cheezelzz.compasstrack.Utils.Utils;

public class InteractEvent implements Listener {
    @EventHandler
    public void onChooseTarget(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (Utils.hasTrackingCompassEquipped(e.getPlayer())) {
                Utils.resetTrackingStatus(e.getPlayer());
                e.getPlayer().openInventory(PlayersUI.GUI(e.getPlayer()));
                return;
            }
        }
    }
}
