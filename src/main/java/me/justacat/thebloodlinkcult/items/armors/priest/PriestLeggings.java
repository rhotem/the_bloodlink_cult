package me.justacat.thebloodlinkcult.items.armors.priest;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.HashMap;
import java.util.List;

public class PriestLeggings extends CustomItem {


    public PriestLeggings() {
        super(Material.LEATHER_LEGGINGS, "PriestLeggings");

        LeatherArmorMeta meta = (LeatherArmorMeta) getItemMeta();

        meta.setColor(Color.RED);

        setItemMeta(meta);

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
    public String getName() {
        return "&4Bloodlink Priest Leggings";
    }

    @Override
    public List<String> getCustomLore() {
        return null;
    }

    @Override
    public HashMap<Enchantment, Integer> getEnchants() {

        HashMap<Enchantment, Integer> map = new HashMap<>();

        map.put(Enchantment.BINDING_CURSE, 1);

        return map;

    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }

}
