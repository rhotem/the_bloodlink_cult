package me.justacat.thebloodlinkcult.listeners;

import me.justacat.thebloodlinkcult.misc.Chat;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Arrays;

public class GhoulEvents implements Listener {


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Enderman enderman && e.getEntity() instanceof Player player) {

            if (enderman.hasMetadata("CrimsonGhoul")) {

                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 2, true, true, true));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 2, true, true, true));

                enderman.setHealth(enderman.getHealth() + e.getFinalDamage());

                enderman.getWorld().spawnParticle(Particle.HEART, enderman.getLocation(), 10, 1.5, 3, 1.5, 0);

                Vector kb = enderman.getLocation().clone().add(player.getLocation().multiply(-1)).toVector();

                player.setVelocity(player.getVelocity().add(kb.normalize().multiply(0.2)));

            }


        }


    }

    @EventHandler
    public void onDeath(EntityDeathEvent e) {

        if (e.getEntity().hasMetadata("CrimsonGhoul")) {

            ItemStack hide = new ItemStack(Material.LEATHER);

            ItemMeta meta = hide.getItemMeta();

            meta.setDisplayName(Chat.colorMessage("&4&kA &4&lCrimson Hide &4&kA"));
            meta.setLore(Chat.colorList(Arrays.asList("&0", "&7Right click to open crafting menu!")));

            hide.setItemMeta(meta);

            e.getDrops().clear();
            e.getDrops().add(hide);

        }

    }

}
