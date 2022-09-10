package me.justacat.thebloodlinkcult.commands;

import me.justacat.thebloodlinkcult.TheBloodLinkCult;
import me.justacat.thebloodlinkcult.misc.Chat;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
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

        Enderman enderman = (Enderman) location.getWorld().spawnEntity(location, EntityType.ENDERMAN, false);

        enderman.setMetadata("CrimsonGhoul", new FixedMetadataValue(TheBloodLinkCult.instance, true));
        enderman.setCustomName(Chat.colorMessage("&4&lThe Crimson Ghoul"));
        enderman.setCustomNameVisible(true);

        enderman.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(200);
        enderman.setHealth(100);

        enderman.setGlowing(true);




    }
}
