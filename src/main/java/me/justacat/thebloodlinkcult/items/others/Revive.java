package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;

public class Revive extends CustomItem {
    public Revive() {
        super(Material.PINK_CONCRETE, "Revive");
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.getWorld().spawnParticle(Particle.HEART, player.getLocation(), 10, 1, 1, 1, 0);
        player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

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
    public String getName() {
        return null;
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
