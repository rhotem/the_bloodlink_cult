package me.justacat.thebloodlinkcult.listeners;

import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.items.armors.TheBladeBreaker;
import me.justacat.thebloodlinkcult.items.armors.TheRedShield;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import java.util.concurrent.ThreadLocalRandom;

public class ClickEvent implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {



        CustomItem item = CustomItem.getCustomItem(e.getItem());

        if (item == null) return;

        if (e.getHand() == EquipmentSlot.HAND || (e.getHand() == EquipmentSlot.OFF_HAND && item.getType() == Material.SHIELD)) {


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

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Player player) {
            CustomItem item = CustomItem.getCustomItem(player.getInventory().getItemInMainHand());

            if (item == null) return;

            item.onAttack(e);

        }


    }


    @EventHandler
    public void entityAttacksEntity(EntityDamageByEntityEvent e) {

        if (e.getEntity() instanceof Player player && e.getDamager() instanceof Player attacker) {

            if (player.getItemInUse() == null) return;

            CustomItem item = CustomItem.getCustomItem(player.getItemInUse());

            if (item == null) return;

            if (item instanceof TheBladeBreaker) {

                ItemStack attackersItem = attacker.getInventory().getItemInMainHand();

                if (attackersItem.getItemMeta() instanceof Damageable meta) {

                    meta.setDamage(meta.getDamage() + 10);
                    attackersItem.setItemMeta(meta);

                    Damageable damageable = (Damageable) item.getItemMeta();
                    damageable.setDamage(damageable.getDamage() - 10);
                    attackersItem.setItemMeta(damageable);




                }


            }


        }

    }


}
