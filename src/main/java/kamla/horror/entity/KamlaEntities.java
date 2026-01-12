package kamla.horror.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import kamla.horror.Kamla;

public class KamlaEntities {
    public static final EntityType<KamlaEntity> KAMLA = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Kamla.MOD_ID, "kamla"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KamlaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 2.0f))
                    .build()
    );

    public static void registerEntities() {
    }
}
