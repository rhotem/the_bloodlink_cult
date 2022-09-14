package me.justacat.thebloodlinkcult;

import me.justacat.thebloodlinkcult.commands.GetItemCommand;
import me.justacat.thebloodlinkcult.commands.GetItemTabComplete;
import me.justacat.thebloodlinkcult.commands.SpawnCrimsonGhoul;
import me.justacat.thebloodlinkcult.gui.CrimsonHideShop;
import me.justacat.thebloodlinkcult.items.CustomItem;
import me.justacat.thebloodlinkcult.listeners.ClickEvent;
import me.justacat.thebloodlinkcult.listeners.GhoulEvents;
import me.justacat.thebloodlinkcult.listeners.JoinQuitEvent;
import me.justacat.thebloodlinkcult.listeners.OnMove;
import me.justacat.thebloodlinkcult.world.CustomChunkGenerator;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBloodLinkCult extends JavaPlugin {

    public static TheBloodLinkCult instance;

    public static NamespacedKey drainKey;

    public static World customWorld;

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
        Bukkit.getPluginManager().registerEvents(new CrimsonHideShop(), this);
        Bukkit.getPluginManager().registerEvents(new OnMove(), this);

        if (!getDataFolder().exists()) getDataFolder().mkdirs();

        WorldCreator worldCreator = new WorldCreator("CultistWorld");
        customWorld = worldCreator.generateStructures(false).generator(new CustomChunkGenerator()).createWorld();
        customWorld.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
