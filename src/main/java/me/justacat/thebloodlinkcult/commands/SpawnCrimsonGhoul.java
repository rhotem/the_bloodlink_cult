package me.justacat.thebloodlinkcult.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCrimsonGhoul implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            spawnCrimsonGhoul(player.getLocation());
        }
        return true;
    }

    public static void spawnCrimsonGhoul(Location location) {

    }
}
