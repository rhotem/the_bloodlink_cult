package me.justacat.reveldemonplugin.items.armors;

import me.justacat.reveldemonplugin.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BloodLinkBoots extends CustomItem {


    public BloodLinkBoots() {
        super(Material.NETHERITE_BOOTS, "BloodLinkBoots");

        ItemMeta meta = getItemMeta();

        meta.getAttributeModifiers(EquipmentSlot.FEET).put(Attribute.GENERIC_ARMOR, new AttributeModifier("BloodLinkBoots", 15, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 10, true);

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
        return "&4The Bloodlink Boots";
    }

    @Override
    public List<String> getCustomLore() {
        return List.of("&7Protects it's wearer from fall damage!");
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }
}
