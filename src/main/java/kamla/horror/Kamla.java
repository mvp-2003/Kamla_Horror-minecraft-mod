package kamla.horror;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kamla.horror.entity.KamlaEntity;
import kamla.horror.entity.KamlaEntities;
import kamla.horror.sound.KamlaSounds;
import kamla.horror.item.KamlaItems;
import kamla.horror.event.KamlaSpawnHandler;

public class Kamla implements ModInitializer {
	public static final String MOD_ID = "kamla";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		KamlaSounds.registerSounds();
		KamlaEntities.registerEntities();
		KamlaItems.registerItems();
		KamlaSpawnHandler.registerSpawns();
		FabricDefaultAttributeRegistry.register(KamlaEntities.KAMLA, KamlaEntity.createKamlaAttributes());

		LOGGER.info("Kamla Horror Mod initialized!");
	}
}