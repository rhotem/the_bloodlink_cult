package me.justacat.thebloodlinkcult.gui;

import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.items.armors.hide.CrimsonHideBoots;
import me.justacat.thebloodlinkcult.items.armors.hide.CrimsonHideChestplate;
import me.justacat.thebloodlinkcult.items.armors.hide.CrimsonHideHelmet;
import me.justacat.thebloodlinkcult.items.armors.hide.CrimsonHideLeggings;
import me.justacat.thebloodlinkcult.misc.Chat;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CrimsonHideShop implements Listener {


    public static void openShop(Player player) {

        GuiBuilder builder = new GuiBuilder(player);

        builder.setTitle("&4Crimson Hide Shop");

        builder.setEmpty(Material.GRAY_STAINED_GLASS_PANE, 1, "&0", null, true);

        builder.setSize(27);

        ItemStack boots = new CrimsonHideBoots();

        ItemMeta bootsMeta = boots.getItemMeta();

        bootsMeta.setLore(Chat.colorList(Arrays.asList("&7Price:", "&7x4 crimson hide", "&7x1 fighter boots")));

        boots.setItemMeta(bootsMeta);



        ItemStack leggings = new CrimsonHideLeggings();

        ItemMeta leggingsMeta = leggings.getItemMeta();

        leggingsMeta.setLore(Chat.colorList(Arrays.asList("&7Price:", "&7x7 crimson hide", "&7x1 fighter leggings")));

        leggings.setItemMeta(leggingsMeta);



        ItemStack chest = new CrimsonHideChestplate();

        ItemMeta chestMeta = chest.getItemMeta();

        chestMeta.setLore(Chat.colorList(Arrays.asList("&7Price:", "&7x8 crimson hide", "&7x1 fighter chestplate")));

        chest.setItemMeta(chestMeta);



        ItemStack helmet = new CrimsonHideChestplate();

        ItemMeta helmetMeta = helmet.getItemMeta();

        helmetMeta.setLore(Chat.colorList(Arrays.asList("&7Price:", "&7x5 crimson hide", "&7x1 fighter helmet")));

        helmet.setItemMeta(helmetMeta);

        builder.setItem(10, boots);
        builder.setItem(12, leggings);
        builder.setItem(14, chest);
        builder.setItem(16, helmet);

        player.openInventory(builder.toInventory());







    }


    @EventHandler
    public void onShopClick(InventoryClickEvent e) {

        if (e.getView().getTitle().contains("Crimson Hide Shop")) {

            e.setCancelled(true);

            CustomItem item = CustomItem.getCustomItem(e.getCurrentItem());

            if (item == null) return;

            ItemStack hide = new ItemStack(Material.LEATHER);

            ItemMeta meta = hide.getItemMeta();

            meta.setDisplayName(Chat.colorMessage("&4&kA &4&lCrimson Hide &4&kA"));
            meta.setLore(Chat.colorList(Arrays.asList("&0", "&7Right click to open crafting menu!")));

            hide.setItemMeta(meta);

            PlayerInventory playerInventory = e.getWhoClicked().getInventory();

            if (item instanceof CrimsonHideHelmet) {



                if (playerInventory.contains(CustomItem.getCustomItem("FighterHelmet"))) {

                    if (checkAndTake(playerInventory, hide, 5)) {

                        playerInventory.addItem(new CrimsonHideHelmet());

                    }

                }

            } else if (item instanceof CrimsonHideChestplate) {

                if (playerInventory.contains(CustomItem.getCustomItem("FighterChestplate"))) {

                    if (checkAndTake(playerInventory, hide, 8)) {

                        playerInventory.addItem(new CrimsonHideChestplate());

                    }

                }

            } else if (item instanceof CrimsonHideLeggings) {

                if (playerInventory.contains(CustomItem.getCustomItem("FighterLeggings"))) {

                    if (checkAndTake(playerInventory, hide, 7)) {

                        playerInventory.addItem(new CrimsonHideLeggings());

                    }

                }

            } else if (item instanceof CrimsonHideBoots) {

                if (playerInventory.contains(CustomItem.getCustomItem("FighterBoots"))) {

                    if (checkAndTake(playerInventory, hide, 4)) {

                        playerInventory.addItem(new CrimsonHideBoots());

                    }

                }

            }


        }

    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack hide = new ItemStack(Material.LEATHER);

            ItemMeta meta = hide.getItemMeta();

            meta.setDisplayName(Chat.colorMessage("&4&kA &4&lCrimson Hide &4&kA"));
            meta.setLore(Chat.colorList(Arrays.asList("&0", "&7Right click to open crafting menu!")));

            hide.setItemMeta(meta);


            if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(hide)) {
                openShop(e.getPlayer());

            }
        }



    }

    public boolean checkAndTake(PlayerInventory inventory, ItemStack item, int amount) {

        HashMap<Integer, ? extends ItemStack> map = inventory.all(item.getType());

        int found = 0;

        List<Integer> list = new ArrayList<>();

        for (int slot : map.keySet()) {

            if (map.get(slot).isSimilar(item)) {

                found = found + map.get(slot).getAmount();
                list.add(slot);

                if (found >= amount) break;

            }

        }

        if (found < amount) {
            return false;
        }

        for (int slot : list) {

            inventory.setItem(slot, new ItemStack(Material.AIR));

        }

        if (found > amount) {
            item.setAmount(found - amount);

            inventory.addItem(item);
        }
        return true;


    }

}
