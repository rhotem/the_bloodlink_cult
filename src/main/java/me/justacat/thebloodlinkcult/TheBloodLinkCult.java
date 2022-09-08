package me.justacat.thebloodlinkcult;

import me.justacat.thebloodlinkcult.commands.GetItemCommand;
import me.justacat.thebloodlinkcult.commands.GetItemTabComplete;
import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.listeners.ClickEvent;
import me.justacat.thebloodlinkcult.listeners.JoinQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBloodLinkCult extends JavaPlugin {

    public static TheBloodLinkCult instance;

    @Override
    public void onEnable() {

        instance = this;

        CustomItem.customItemKey = new NamespacedKey(this, "CustomItem");
        CustomItem.uuidKey = new NamespacedKey(this, "DrillUUID");
        Church.churchKey = new NamespacedKey(this, "Church");

        getCommand("GetItem").setExecutor(new GetItemCommand());
        getCommand("GetItem").setTabCompleter(new GetItemTabComplete());

        Bukkit.getPluginManager().registerEvents(new ClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuitEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
