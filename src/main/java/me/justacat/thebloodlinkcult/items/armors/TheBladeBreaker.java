package me.justacat.thebloodlinkcult.items.armors;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TheBladeBreaker extends CustomItem {
    public TheBladeBreaker(boolean bloodTrooper) {
        super(Material.SHIELD, bloodTrooper ? "TheBladeBreaker" : "TheBloodyPainting");

        ItemMeta meta = getItemMeta();

        meta.addEnchant(Enchantment.THORNS, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);


        setItemMeta(meta);

        BlockStateMeta blockStateMeta = (BlockStateMeta) getItemMeta();

        Banner banner = (Banner) blockStateMeta.getBlockState();

        banner.setBaseColor(DyeColor.RED);
        banner.update();

        blockStateMeta.setBlockState(banner);
        setItemMeta(blockStateMeta);


    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        player.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(2).add(player.getVelocity()));

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

        if (getID().equals("TheBloodyPainting")) {
            return "&4The Bloody Painting";
        } else {
            return "&4The Blade Breaker";

        }
    }

    @Override
    public List<String> getCustomLore() {
        return null;
    }

    @Override
    public EquipmentSlot[] getActiveSlots() {
        return new EquipmentSlot[0];
    }

    @Override
    public boolean unbreakable() {
        return getID().equals("TheBloodyPainting");
    }
}
