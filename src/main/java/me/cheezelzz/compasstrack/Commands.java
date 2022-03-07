package me.cheezelzz.compasstrack;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.cheezelzz.compasstrack.Utils.Utils;

public class Commands implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // DONE
        if (cmd.getName().equalsIgnoreCase("track")) {
            if (sender instanceof Player) {
                Player player = ((Player) sender);

                if (Arrays.asList(player.getInventory().getContents()).stream()
                        .filter(item -> item != null && item.getType() == Material.COMPASS
                                && item.getItemMeta().getDisplayName().contains("Tracking"))
                        .collect(Collectors.toList()).size() == 0) {
                    player.getInventory().addItem(Utils.getDefaultCompass());
                }
                return true;
            }
        } else if (cmd.getName().equalsIgnoreCase("debug")) {
            System.out.println("playerToPlayerTrackMap");
            Main.playerToPlayerTrackMap.entrySet().forEach(entry -> {
                System.out.println(entry.getKey().getDisplayName() + "-> " + entry.getValue().getDisplayName());
            });

            System.out.println();

            System.out.println("playerToPositionMap");
            Main.playerToPositionMap.entrySet().forEach(entry -> {
                System.out.println(entry.getKey().getPlayerName() + ", " + entry.getKey().getEnvironment() + " -> ["
                        + entry.getValue().getX().intValue() + "]["
                        + entry.getValue().getY().intValue() + "]["
                        + entry.getValue().getZ().intValue() + "]");
            });

            return true;
        }
        return false;
    }

}
