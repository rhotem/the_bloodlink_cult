package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TheSacrifice extends CustomItem {

    public static HashMap<UUID, Integer> hits = new HashMap<>();


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

        int thisHits = hits.getOrDefault(e.getDamager().getUniqueId(), 0);

        if (thisHits < 3) {

            hits.put(e.getDamager().getUniqueId(), thisHits + 1);
            Bukkit.getPluginManager().callEvent(e);


        } else {
            hits.put(e.getDamager().getUniqueId(), 0);

        }


    }

    @Override
    public String getName() {
        return "&4TheSacrifice";
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
