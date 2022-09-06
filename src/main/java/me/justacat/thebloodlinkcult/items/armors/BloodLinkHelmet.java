package me.justacat.thebloodlinkcult.items.armors;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

public class BloodLinkHelmet extends CustomItem {


    public BloodLinkHelmet() {
        super(Material.PLAYER_HEAD, "BloodLinkHelmet");

        SkullMeta meta = (SkullMeta) getItemMeta();

        meta.getAttributeModifiers(EquipmentSlot.HEAD).put(Attribute.GENERIC_ARMOR, new AttributeModifier("BloodLinkHelmet", 15, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("9f02d27d-1193-49a6-a226-ddec820831fa")));
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
