package me.justacat.thebloodlinkcult.items.armors.fighter;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.List;

public class FighterHelmet extends CustomItem {

    public FighterHelmet() {
        super(Material.PLAYER_HEAD, "FighterHelmet");

        SkullMeta meta = (SkullMeta) getItemMeta();

        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Reveldemon"));


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
        return "&4Bloodlink Fighter Helmet";
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
