package me.justacat.thebloodlinkcult;

import me.justacat.thebloodlinkcult.commands.GetItemCommand;
import me.justacat.thebloodlinkcult.commands.GetItemTabComplete;
import me.justacat.thebloodlinkcult.items.CustomItem;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBloodLinkCult extends JavaPlugin {

    public static TheBloodLinkCult instance;

    @Override
    public void onEnable() {

        instance = this;

        CustomItem.customItemKey = new NamespacedKey(this, "CustomItem");
        CustomItem.uuidKey = new NamespacedKey(this, "DrillUUID");

        getCommand("GetItem").setExecutor(new GetItemCommand());
        getCommand("GetItem").setTabCompleter(new GetItemTabComplete());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
