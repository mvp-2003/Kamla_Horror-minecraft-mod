package kamla.horror.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.geom.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import kamla.horror.entity.KamlaEntity;

public class KamlaModel extends BipedEntityModel<KamlaEntity> {
    public KamlaModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = BipedEntityModel.getModelData(1.0F);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setAngles(KamlaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        if (entity.isAttacking()) {
            this.rightArm.pitch = -1.5f;
            this.leftArm.pitch = -1.5f;
        }
    }
}
