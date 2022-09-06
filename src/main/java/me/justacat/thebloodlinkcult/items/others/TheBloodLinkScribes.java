package me.justacat.thebloodlinkcult.items.others;

import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.misc.Chat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class TheBloodLinkScribes extends CustomItem {
    public TheBloodLinkScribes() {
        super(Material.BOOK, "TheBloodLinkScribes");

        BookMeta meta = (BookMeta) getItemMeta();


        meta.setAuthor(Chat.colorMessage("&4???"));

        String[] array = new  String[20];

        for (int i = 0; i < 20; i++) {



            array[i] = Chat.colorMessage("&4&k" + "0".repeat(250));

        }

        meta.setPages(array);

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
        return "&4The BloodLink Scribes";
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
