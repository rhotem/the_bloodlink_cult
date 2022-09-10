package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.TheBloodLinkCult;
import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TheSacrifice extends CustomItem {

    List<UUID> activeOn = new ArrayList<>();

    public TheSacrifice() {
        super(Material.IRON_SWORD, "TheSacrifice");
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

    }

    @Override
    public void onLeftClick(PlayerInteractEvent e) {

    }

    @Override
    public void whileOnUse(Player player) {

    }

    @Override
    public void whileInInventory(Player player) {

    }

    @Override
    public void onMine(BlockBreakEvent e) {

    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e) {

        if (activeOn.contains(e.getEntity().getUniqueId())) return;
        activeOn.add(e.getEntity().getUniqueId());
        damageAttack(1, e);



    }

    public void damageAttack(int number, EntityDamageByEntityEvent e) {

        if (number > 3) {
            activeOn.remove(e.getEntity().getUniqueId());
            return;
        }

        if (e.getEntity() instanceof LivingEntity entity) {

            Bukkit.getScheduler().runTaskLater(TheBloodLinkCult.instance, () -> {
                entity.damage(e.getFinalDamage(), e.getDamager());

                Vector direction = entity.getLocation().toVector().add(e.getDamager().getLocation().toVector().multiply(-1));

                entity.setVelocity(entity.getVelocity().add(direction.normalize().multiply(0.3)));

                entity.getWorld().spawnParticle(Particle.SWEEP_ATTACK, entity.getLocation(), 1);

                damageAttack(number + 1, e);

            }, 5);


        }
    }

    @Override
    public String getName() {
        return "&4The Sacrifice";
    }

    @Override
    public List<String> getCustomLore() {
        return null;
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }
}
