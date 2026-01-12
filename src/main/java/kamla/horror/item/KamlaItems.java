package kamla.horror.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import kamla.horror.Kamla;
import kamla.horror.entity.KamlaEntities;

public class KamlaItems {
    public static final SpawnEggItem KAMLA_SPAWN_EGG = new SpawnEggItem(
            KamlaEntities.KAMLA,
            0x8B4545,
            0xFFFFFF,
            new net.minecraft.item.Item.Settings()
    );

    public static final ItemGroup KAMLA_GROUP = FabricItemGroup.builder()
            .displayName(Text.literal("Kamla"))
            .icon(() -> new ItemStack(KAMLA_SPAWN_EGG))
            .entries((displayContext, entries) -> {
                entries.add(KAMLA_SPAWN_EGG);
            })
            .build();

    public static void registerItems() {
        Registry.register(Registries.ITEM, Identifier.of(Kamla.MOD_ID, "kamla_spawn_egg"), KAMLA_SPAWN_EGG);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Kamla.MOD_ID, "kamla_group"), KAMLA_GROUP);
    }
}
