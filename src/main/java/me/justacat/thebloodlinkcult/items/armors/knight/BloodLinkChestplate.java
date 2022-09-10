package me.justacat.thebloodlinkcult.items.armors.knight;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BloodLinkChestplate extends CustomItem {

    public BloodLinkChestplate(boolean bloodTrooper) {
        super(Material.NETHERITE_CHESTPLATE, bloodTrooper ? "BloodLinkChestplate" : "BloodLinkChestplatePlus");

        ItemMeta meta = getItemMeta();

        meta.getAttributeModifiers(EquipmentSlot.CHEST).put(Attribute.GENERIC_ARMOR, new AttributeModifier("BloodLinkChestplate", 40, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.THORNS, 6, true);
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);

        if (bloodTrooper) {
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
            meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10, true);
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 10, true);
            meta.addEnchant(Enchantment.THORNS, 10, true);

        }

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
        return "&4The Bloodlink Chestplate";
    }

    @Override
    public List<String> getCustomLore() {
        return new ArrayList<>();
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }
}
