package fr.chrislinefield.ldoe.client.model.armor;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.init.ModItems;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class GhillieSuitModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(LDOEMod.MOD_ID, "ghillie_suit"), "main");
    public ModelPart bootL;
    public ModelPart bootR;



    public GhillieSuitModel(ModelPart root) {
        super(root, RenderType::entityCutoutNoCull);
        bootL = root.getChild("left_leg").getChild("armorLeftBoot");
        bootR = root.getChild("right_leg").getChild("armorRightBoot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bipedHead = partdefinition.getChild("head");
        PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create().texOffs(1, 177).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 0.0F));
        PartDefinition head_r1 = armorHead.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(53, 131).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -9.0F, 2.0F, -0.5236F, 0.0F, -0.2182F));
        PartDefinition head_r2 = armorHead.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(53, 131).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -9.0F, -1.0F, -0.5236F, 0.0F, 0.2182F));
        PartDefinition head_r3 = armorHead.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(47, 178).mirror().addBox(0.0F, -4.5F, -4.5F, 0.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.3F, 0.25F, 0.3F, 0.0873F, 0.0F, 0.2182F));
        PartDefinition head_r4 = armorHead.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(47, 178).addBox(0.0F, -4.5F, -4.5F, 0.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3F, 0.25F, 0.3F, 0.0873F, 0.0F, -0.2182F));

        PartDefinition bipedBody = partdefinition.getChild("body");
        PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(1, 113).addBox(-4.75F, -0.25F, -2.5F, 9.0F, 12.5F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, 0.0F, 0.0F));
        PartDefinition body_r1 = armorBody.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(51, 72).addBox(-3.75F, -3.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, 9.0F, 3.25F, 0.0F, 0.2618F, 0.0F));
        PartDefinition body_r2 = armorBody.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(53, 72).addBox(-3.75F, -3.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 4.0F, 3.25F, 0.0F, -0.2618F, 0.0F));
        PartDefinition body_r3 = armorBody.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(53, 72).addBox(-3.75F, -3.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 9.0F, -3.25F, 0.0F, 0.2618F, 0.0F));
        PartDefinition body_r4 = armorBody.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(53, 72).addBox(-3.75F, -3.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, 4.0F, -3.25F, 0.0F, -0.2618F, 0.0F));

        PartDefinition bipedRightArm = partdefinition.getChild("right_arm");
        PartDefinition armorRightArm = bipedRightArm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(45, 113).mirror().addBox(-4.5F + 1f, -2.25F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition right_arm_r1 = armorRightArm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(53, 66).mirror().addBox(-3.25F + 1f, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.25F, 1.75F, -0.25F, 0.0F, 0.0F, -0.0873F));

        PartDefinition bipedLeftArm = partdefinition.getChild("left_arm");
        PartDefinition armorLeftArm = bipedLeftArm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(45, 113).addBox(-0.75F - 1f, -1.5F, -2.25F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.25F, -0.75F, 0.0F));
        PartDefinition left_arm_r1 = armorLeftArm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(53, 66).addBox(-3.25F - 1f, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 5.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition bipedLeftLeg = partdefinition.getChild("left_leg");
        PartDefinition armorLeftLeg = bipedLeftLeg.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create().texOffs(66, 149).mirror().addBox(1.25F- 4f, 0.5F, -2.25F, 5.0F, 9.0F, 5.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offset(0.25F, -1.0F, -0.25F));
        PartDefinition left_leg_r1 = armorLeftLeg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(86, 155).mirror().addBox(-1.5F- 4f, -2.0F, -1.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(6.5F, 4.0F, -0.45F, 0.0F, 0.3927F, 0.0F));
        PartDefinition armorLeftBoot = bipedLeftLeg.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(1, 25).mirror().addBox(2.0F- 4f, 8.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false)
                .texOffs(23, 30).mirror().addBox(2.0F- 4f, 10.5F, -3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(0.0F, -0.5F, 0.0F));
        PartDefinition left_leg_r2 = armorLeftBoot.addOrReplaceChild("left_leg_r2", CubeListBuilder.create().texOffs(1, 18).mirror().addBox(-2.5F- 4f, -1.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.0F, 8.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition bipedRightLeg = partdefinition.getChild("right_leg");
        PartDefinition armorRightLeg = bipedRightLeg.addOrReplaceChild("armorRightLeg", CubeListBuilder.create().texOffs(66, 149).addBox(-6.75F + 4f, 0.5F, -2.25F, 5.0F, 9.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offset(0.25F, -1.0F, -0.25F));
        PartDefinition right_leg_r1 = armorRightLeg.addOrReplaceChild("right_leg_r1", CubeListBuilder.create().texOffs(86, 155).addBox(-0.5F + 4f, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-7.0F, 4.0F, -0.2F, 0.0F, -0.2618F, 0.0F));
        PartDefinition armorRightBoot = bipedRightLeg.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(23, 30).addBox(-6.0F + 4f, 10.5F, -3.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
                .texOffs(1, 25).addBox(-6.0F + 4f, 8.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -0.5F, 0.0F));
        PartDefinition right_leg_r2 = armorRightBoot.addOrReplaceChild("right_leg_r2", CubeListBuilder.create().texOffs(1, 18).addBox(-2.5F + 4f, -1.0F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.0F, 8.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

        return LayerDefinition.create(meshdefinition, 99, 196);
    }

    @Override
    public void prepareMobModel(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
        bootL.visible = pEntity.getItemBySlot(EquipmentSlot.FEET).is(ModItems.GHILLIE_BOOTS.get());
        bootR.visible = pEntity.getItemBySlot(EquipmentSlot.FEET).is(ModItems.GHILLIE_BOOTS.get());
        super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
    }


//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bipedLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bipedRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//	}
}
