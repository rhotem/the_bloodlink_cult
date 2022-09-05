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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class BloodLinkHelmet extends CustomItem {


    public BloodLinkHelmet() {
        super(Material.PLAYER_HEAD, "BloodLinkHelmet");

        ItemMeta meta = getItemMeta();

        meta.getAttributeModifiers(EquipmentSlot.HEAD).put(Attribute.GENERIC_ARMOR, new AttributeModifier("BloodLinkHelmet", 15, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);

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
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 10, false, false, false));
    }

    @Override
    public void whileInInventory(Player player) {

    }

    @Override
    public void onMine(BlockBreakEvent e) {

    }

    @Override
    public String getName() {
        return "&4The Bloodlink Knight Helm";
    }

    @Override
    public List<String> getCustomLore() {
        return List.of("&7Gives the wearer night vision!");
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }
}
