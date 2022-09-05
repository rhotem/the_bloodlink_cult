package me.justacat.reveldemonplugin.commands;

import me.justacat.reveldemonplugin.items.RegisteredItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GetItemTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete (@NotNull CommandSender sender,@NotNull  Command command, @NotNull String label, @NotNull String[] args) {

        List<String> list = new ArrayList<>();

        if (args.length == 1) {
            for (RegisteredItems item : RegisteredItems.values()) {

                list.add(item.name());

            }
            return StringUtil.copyPartialMatches(args[0], list, new ArrayList<>());

        }

        return list;

    }
}
