package me.justacat.thebloodlinkcult;

import me.justacat.thebloodlinkcult.commands.GetItemCommand;
import me.justacat.thebloodlinkcult.commands.GetItemTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class TheBloodLinkCult extends JavaPlugin {

    public static TheBloodLinkCult instance;

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
