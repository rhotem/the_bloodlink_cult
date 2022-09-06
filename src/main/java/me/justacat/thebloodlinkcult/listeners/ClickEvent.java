package me.justacat.thebloodlinkcult.listeners;

import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.items.armors.TheRedShield;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.concurrent.ThreadLocalRandom;

public class ClickEvent implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        if (e.getHand() == EquipmentSlot.HAND) {


            CustomItem item = CustomItem.getCustomItem(e.getItem());

            if (item == null) return;

            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {

                item.onLeftClick(e);

            } else if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

                item.onRightClick(e);

            }


        }

    }

    @EventHandler
    public void itemDamage(PlayerItemDamageEvent e) {


        CustomItem item = CustomItem.getCustomItem(e.getItem());

        if (item == null) return;

        if (item instanceof TheRedShield) {

            if (ThreadLocalRandom.current().nextInt(1, 8) != 1) {

                e.setCancelled(true);

            }


        }

    }


}
