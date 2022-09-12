package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Collections;
import java.util.List;

public class BoomBow extends CustomItem {
    public BoomBow() {
        super(Material.BOW, "BoomBow");
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
        return "&4Boom Bow";
    }

    @Override
    public List<String> getCustomLore() {
        return Collections.singletonList("&7Shoots explosive arrows!");
    }
}
