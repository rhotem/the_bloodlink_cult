package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MagicWand extends CustomItem {
    public MagicWand() {
        super(Material.STICK, "MagicWand");
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        int random = ThreadLocalRandom.current().nextInt(1, 4);

        switch (random) {
            case 1 -> player.launchProjectile(Snowball.class);
            case 2 -> player.launchProjectile(Fireball.class);
            case 3 -> player.launchProjectile(DragonFireball.class);
        }

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
        return "&bMagic Wand";
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
