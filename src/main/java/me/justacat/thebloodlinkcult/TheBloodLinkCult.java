package me.justacat.thebloodlinkcult;

import me.justacat.thebloodlinkcult.commands.GetItemCommand;
import me.justacat.thebloodlinkcult.commands.GetItemTabComplete;
import me.justacat.thebloodlinkcult.commands.SpawnCrimsonGhoul;
import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.listeners.ClickEvent;
import me.justacat.thebloodlinkcult.listeners.GhoulEvents;
import me.justacat.thebloodlinkcult.listeners.JoinQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBloodLinkCult extends JavaPlugin {

    public static TheBloodLinkCult instance;

    public static NamespacedKey drainKey;

    @Override
    public void onEnable() {

        instance = this;

        drainKey = new NamespacedKey(this, "Drain");

        CustomItem.customItemKey = new NamespacedKey(this, "CustomItem");
        CustomItem.uuidKey = new NamespacedKey(this, "DrillUUID");

        getCommand("GetItem").setExecutor(new GetItemCommand());
        getCommand("GetItem").setTabCompleter(new GetItemTabComplete());
        getCommand("SpawnCrimsonGhoul").setExecutor(new SpawnCrimsonGhoul());

        Bukkit.getPluginManager().registerEvents(new ClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new GhoulEvents(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
