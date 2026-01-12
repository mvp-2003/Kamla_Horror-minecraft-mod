package kamla.horror;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import kamla.horror.entity.KamlaEntity;
import kamla.horror.entity.KamlaRenderer;
import kamla.horror.entity.KamlaEntities;
import kamla.horror.model.KamlaModel;

public class KamlaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(KamlaEntities.KAMLA, KamlaRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(KamlaRenderer.LAYER_LOCATION, KamlaModel::getTexturedModelData);
	}
}