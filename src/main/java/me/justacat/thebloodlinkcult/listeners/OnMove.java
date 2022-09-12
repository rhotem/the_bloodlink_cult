package me.justacat.thebloodlinkcult.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (player.getWorld().getName().equals("CultistWorld")) {

            //need to replace near barriers with shulker boxes/churches

        }

    }

}
