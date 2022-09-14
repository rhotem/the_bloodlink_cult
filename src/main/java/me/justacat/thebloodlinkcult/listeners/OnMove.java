package me.justacat.thebloodlinkcult.listeners;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EditSessionBuilder;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import me.justacat.thebloodlinkcult.TheBloodLinkCult;
import me.justacat.thebloodlinkcult.items.RegisteredItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ThreadLocalRandom;

public class OnMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        if (player.getWorld().getName().equals("CultistWorld")) {

            Location playerLoc = player.getLocation();
            Location location = player.getLocation().clone();

            for (int x = -30; x < 30; x++) {

                location.setX(playerLoc.getX() + x);

                for (int z = -30; z < 30; z++) {

                    location.setZ(playerLoc.getZ() + z);

                    for (int y = -10; y < 10; y++) {

                        location.setY(playerLoc.getY() + y);

                        if (location.getBlock().getType() == Material.BARRIER) {

                            Block block = location.getBlock();

                            int luck = ThreadLocalRandom.current().nextInt(1, 100);

                            int amount = 0;

                            if (luck > 97) {

                                File file = new File(TheBloodLinkCult.instance.getDataFolder(), "church.schem");





                                ClipboardFormat format = ClipboardFormats.findByFile(file);


                                try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {

                                    Clipboard clipboard = reader.read();


                                    EditSessionBuilder editSessionBuilder = WorldEdit.getInstance().newEditSessionBuilder();

                                    EditSession session = editSessionBuilder.world(BukkitAdapter.adapt(location.getWorld())).build();

                                    Operation operation = new ClipboardHolder(clipboard)
                                            .createPaste(session)
                                            .to(BlockVector3.at(location.getX(), location.getY(), location.getZ()))
                                            .ignoreAirBlocks(true)
                                            .build();


                                    Operations.complete(operation);
                                    session.close();

                                } catch (Exception ex) {
                                    System.out.println("error!");
                                    ex.printStackTrace();
                                }

                            } else {

                                block.setType(Material.RED_SHULKER_BOX);

                                ShulkerBox state = (ShulkerBox) block.getState();

                                ItemStack[] array = new ItemStack[27];

                                int i = 0;

                                for (RegisteredItems item : RegisteredItems.values()) {


                                    if (ThreadLocalRandom.current().nextInt(1, 200) < luck + 50) {

                                        if (amount > 7) {
                                            array[i] = new ItemStack(Material.AIR);
                                        } else {
                                            array[i] = item.getItem();
                                            amount++;
                                        }


                                    } else {

                                        array[i] = new ItemStack(Material.AIR);

                                    }

                                    i++;

                                    if (i >= 27) i = 0;

                                }
                                state.getInventory().setContents(array);


                            }


                        }



                    }

                }

            }

        }

    }

}
