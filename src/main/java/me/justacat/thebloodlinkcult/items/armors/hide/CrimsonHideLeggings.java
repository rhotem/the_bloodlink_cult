package me.justacat.thebloodlinkcult.items.armors.hide;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CrimsonHideLeggings extends CustomItem {

    public CrimsonHideLeggings() {
        super(Material.LEATHER_LEGGINGS, "CrimsonHideLeggings");

        ItemMeta meta = getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID().toString(), 3, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID().toString(), 3, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID().toString(), 2, AttributeModifier.Operation.ADD_NUMBER));


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
        return "&4Crimson Hide Leggings";
    }

    @Override
    public List<String> getCustomLore() {
        return null;
    }

    @Override
    public HashMap<Enchantment, Integer> getEnchants() {

        HashMap<Enchantment, Integer> map = new HashMap<>();

        map.put(Enchantment.BINDING_CURSE, 1);
        map.put(Enchantment.PROTECTION_ENVIRONMENTAL, 10);

        return map;

    }

}
