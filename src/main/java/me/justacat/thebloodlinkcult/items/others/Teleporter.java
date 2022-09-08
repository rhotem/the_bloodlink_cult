package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.world.CustomChunkGenerator;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.List;

public class Teleporter extends CustomItem {

    public Teleporter() {
        super(Material.RED_CONCRETE, "Teleporter");
    }

    @Override
    public void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        WorldCreator worldCreator = new WorldCreator("CultistWorld");
        World world = worldCreator.generateStructures(false).generator(new CustomChunkGenerator()).createWorld();

        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);

        Location location = player.getLocation();

        if (player.getWorld().equals(world)) {

            location.setWorld(Bukkit.getWorlds().get(0));



        } else {
            location.setWorld(world);

        }


        e.getPlayer().teleport(location);

        if (location.getBlock().getType() != Material.AIR) {

            location.getBlock().setType(Material.AIR);
            location.add(0, 1, 0).getBlock().setType(Material.AIR);
            location.add(0, -1, 0).getBlock().setType(Material.AIR);

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
        return "&cTeleporter";
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
