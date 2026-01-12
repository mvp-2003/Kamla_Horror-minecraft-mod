package kamla.horror.entity;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.util.Identifier;
import kamla.horror.Kamla;
import kamla.horror.model.KamlaModel;

public class KamlaRenderer extends BipedEntityRenderer<KamlaEntity, KamlaModel> {
    private static final Identifier TEXTURE = Identifier.of(Kamla.MOD_ID, "textures/entity/kamla.png");
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            Identifier.of(Kamla.MOD_ID, "kamla"), "main"
    );

    public KamlaRenderer(EntityRendererFactory.Context context) {
        super(context, new KamlaModel(context.getPart(LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(KamlaEntity entity) {
        return TEXTURE;
    }
}
