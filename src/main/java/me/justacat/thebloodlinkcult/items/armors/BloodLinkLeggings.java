package me.justacat.thebloodlinkcult.items.armors;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class BloodLinkLeggings extends CustomItem {


    public BloodLinkLeggings() {
        super(Material.NETHERITE_LEGGINGS, "BloodLinkLeggings");

        ItemMeta meta = getItemMeta();

        meta.getAttributeModifiers(EquipmentSlot.LEGS).put(Attribute.GENERIC_ARMOR, new AttributeModifier("BloodLinkLeggings", 30, AttributeModifier.Operation.ADD_NUMBER));
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
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 10, false, false, false));
    }

    @Override
    public void whileInInventory(Player player) {

    }

    @Override
    public void onMine(BlockBreakEvent e) {

    }

    @Override
    public String getName() {
        return "&4The Bloodlink Leggings";
    }

    @Override
    public List<String> getCustomLore() {
        return List.of("&7Makes the wearer immune to fire damage!");
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }


}
