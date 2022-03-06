package me.cheezelzz.compasstrack.UI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayersUI {

    public static int inv_rows = 54;

    public static Inventory GUI(Player p) {
        Inventory toReturn = Bukkit.getServer().createInventory(null, inv_rows, "Tracking Menu");
        int slot = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!p.equals(player)) {
                ItemStack playerSkull = new ItemStack(Material.PLAYER_HEAD);
                ItemMeta playerSkullMeta = playerSkull.getItemMeta();
                playerSkullMeta.setDisplayName(ChatColor.WHITE + player.getDisplayName());
                ((SkullMeta) playerSkullMeta).setOwningPlayer(player);
                playerSkull.setItemMeta(playerSkullMeta);
                toReturn.setItem(slot + 9 * (slot % 9), playerSkull);

                ItemStack bedItem = new ItemStack(Material.RED_BED);
                ItemMeta bedMeta = bedItem.getItemMeta();
                bedMeta.setDisplayName(ChatColor.WHITE + player.getDisplayName() + "'s Respawn Point");
                bedItem.setItemMeta(bedMeta);
                toReturn.setItem(slot + 9 * (slot % 9) + 9, bedItem);
                slot++;
            }
        }
        return toReturn;
    }
}
