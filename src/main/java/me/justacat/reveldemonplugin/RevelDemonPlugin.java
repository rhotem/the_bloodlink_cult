package me.justacat.reveldemonplugin;

import me.justacat.reveldemonplugin.commands.GetItemCommand;
import me.justacat.reveldemonplugin.commands.GetItemTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class RevelDemonPlugin extends JavaPlugin {

    public static RevelDemonPlugin instance;

    @Override
    public void onEnable() {

        instance = this;

        getCommand("GetItem").setExecutor(new GetItemCommand());
        getCommand("GetItem").setTabCompleter(new GetItemTabComplete());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
