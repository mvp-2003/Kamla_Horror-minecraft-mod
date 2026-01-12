package kamla.horror.event;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import kamla.horror.entity.KamlaEntity;
import kamla.horror.entity.KamlaEntities;

public class KamlaSpawnHandler {
    public static void registerSpawns() {
        SpawnRestriction.register(
                KamlaEntities.KAMLA,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (type, world, reason, pos, random) -> {
                    int lightLevel = world.getLightLevel(pos);
                    boolean isNight = !world.isDay();
                    return lightLevel <= 7 && isNight;
                }
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.all(),
                SpawnGroup.MONSTER,
                KamlaEntities.KAMLA,
                5,
                2,
                3
        );
    }
}
