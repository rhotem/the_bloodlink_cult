package me.justacat.thebloodlinkcult.world;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {

    private final FastNoiseLite terrainNoise = new FastNoiseLite();
    private final FastNoiseLite detailNoise = new FastNoiseLite();



    public CustomChunkGenerator() {


        terrainNoise.SetFrequency(0.002f);
        detailNoise.SetFrequency(0.05f);


        terrainNoise.SetFractalType(FastNoiseLite.FractalType.FBm);
        terrainNoise.SetFractalOctaves(8);



    }

    @Override
    public void generateNoise(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkGenerator.ChunkData chunkData) {
        for (int y = chunkData.getMinHeight(); y < 320 && y < chunkData.getMaxHeight(); y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    float noise2 = (terrainNoise.GetNoise(x + (chunkX * 16), z + (chunkZ * 16)) * 2) + (detailNoise.GetNoise(x + (chunkX * 16), z + (chunkZ * 16)) / 50);



                    if (65 + (40 * noise2) > y) {
                        if (Math.random() < 0.001) {

                            chunkData.setBlock(x, y, z, Material.BARRIER);

                        } else {
                            chunkData.setBlock(x, y, z, Material.RED_SANDSTONE);
                        }

                    } else if (y < terrainNoise.GetNoise(x + (chunkX * 16), z + (chunkZ * 16)) * 60) {
                        if (Math.random() < 0.001) {

                            chunkData.setBlock(x, y, z, Material.BARRIER);

                        } else {
                            chunkData.setBlock(x, y, z, Material.RED_SANDSTONE);
                        }

                    } else {
                        chunkData.setBlock(x, y, z, Material.AIR);
                    }
                }
            }
        }
    }
    



    public static boolean isInfinityWorld(World world) {
        return world.getName().equals("InfinityWorld");
    }

    public static boolean isInfinityWorld(Player player) {
        return isInfinityWorld(player.getWorld());
    }

}
