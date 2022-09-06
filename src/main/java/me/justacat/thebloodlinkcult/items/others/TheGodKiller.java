package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TheGodKiller extends CustomItem {

    public static List<UUID> charged = new ArrayList<>();

    public TheGodKiller() {
        super(Material.NETHERITE_AXE, "TheGodKiller");
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

        UUID uuid = e.getPlayer().getUniqueId();

        if (!charged.contains(uuid)) charged.add(uuid);


    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e) {

        Player player = (Player) e.getDamager();

        if (charged.contains(player.getUniqueId())) {

            player.getWorld().createExplosion(e.getEntity().getLocation(), 7, true, true, player);

        }

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
    public HashMap<Enchantment, Integer> getEnchants() {
        HashMap<Enchantment, Integer> map = new HashMap<>();

        map.put(Enchantment.DAMAGE_ALL, 10);
        map.put(Enchantment.FIRE_ASPECT, 5);

        return map;
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }
}
