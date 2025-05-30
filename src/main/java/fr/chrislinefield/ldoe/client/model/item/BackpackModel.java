package fr.chrislinefield.ldoe.client.model.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class BackpackModel <T extends Entity> extends EntityModel<T>
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ldoemod", "model_backpack"), "main");
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;

    public BackpackModel(ModelPart root) {
        this.body = root.getChild("Body");
        this.rightArm = root.getChild("RightArm");
        this.leftArm = root.getChild("LeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("Body",
                CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, 1.0F, 2.4F, 8.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 25).addBox(-3.8F, 1.492F, 1.908F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(17, 24).addBox(-0.2F, 1.5F, 1.9F, 4.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(22, 3).addBox(-3.392F, 0.4F, 3.1F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(22, 11).addBox(-3.392F, 0.8F, 2.1F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 22).addBox(-3.4F, 10.4F, 2.9F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 13).addBox(-3.4F, 3.4F, 4.6F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(22, 6).addBox(-2.8F, 6.0F, 6.1F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(27, 24).addBox(-2.3F, 5.8F, 5.2F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 10).addBox(1.4F, 7.2F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 6).addBox(-1.9F, 7.2F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(10, 40).addBox(1.408F, 7.4F, 6.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 3).addBox(-1.908F, 7.4F, 6.2F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r1",
                CubeListBuilder.create()
                        .texOffs(10, 25).addBox(-4.7F, 1.5F, 1.9F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0F, 0.0873F, 0.0F));

        body.addOrReplaceChild("cube_r2",
                CubeListBuilder.create()
                        .texOffs(16, 13).addBox(-5.3F, 5.5F, 2.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(18, 34).addBox(-5.3F, 2.5F, 2.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.4F, 2.2F, 0.2F, 0.0F, 0.0873F, 0.0F));

        body.addOrReplaceChild("cube_r3",
                CubeListBuilder.create()
                        .texOffs(35, 0).addBox(3.7F, 5.5F, 2.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(38, 15).addBox(3.7F, 2.5F, 2.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.3F, 2.2F, 0.2F, 0.0F, -0.0873F, 0.0F));

        body.addOrReplaceChild("cube_r4",
                CubeListBuilder.create()
                        .texOffs(37, 0).addBox(-5.7F, 5.992F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(8, 37).addBox(-5.7F, 2.992F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.4F, 1.7F, 0.2F, 0.0F, 0.2094F, 0.0F));

        body.addOrReplaceChild("cube_r5",
                CubeListBuilder.create()
                        .texOffs(37, 34).addBox(4.1F, 5.992F, 3.2F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(37, 37).addBox(4.1F, 2.992F, 3.2F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.3F, 1.7F, 0.2F, 0.0F, -0.2094F, 0.0F));

        body.addOrReplaceChild("cube_r6",
                CubeListBuilder.create()
                        .texOffs(27, 28).addBox(3.8F, 1.5F, 1.9F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0F, -0.0873F, 0.0F));

        body.addOrReplaceChild("cube_r7",
                CubeListBuilder.create()
                        .texOffs(14, 34).addBox(4.0F, 3.892F, 3.3F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.4F, 0.0F, -0.1745F, 0.0F));

        body.addOrReplaceChild("cube_r8",
                CubeListBuilder.create()
                        .texOffs(20, 34).addBox(-4.9F, 3.892F, 3.3F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.4F, 0.0F, 0.1745F, 0.0F));

        body.addOrReplaceChild("cube_r9",
                CubeListBuilder.create()
                        .texOffs(19, 0).addBox(-3.4F, 11.2F, 1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.3F, 0.2618F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r10",
                CubeListBuilder.create()
                        .texOffs(16, 21).addBox(-3.4F, 2.0F, 4.9F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.3F, -0.2618F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r11",
                CubeListBuilder.create()
                        .texOffs(32, 21).addBox(-2.3F, 2.8F, 7.8F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.3F, -0.4363F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r12",
                CubeListBuilder.create()
                        .texOffs(27, 28).addBox(-2.592F, 4.78F, 2.97F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(4, 39).addBox(1.908F, 4.78F, 2.97F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(18, 13).addBox(-3.392F, 3.98F, 2.77F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.3316F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r13",
                CubeListBuilder.create()
                        .texOffs(39, 23).addBox(1.899F, 5.78F, 4.77F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(26, 39).addBox(-2.591F, 5.78F, 4.77F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(34, 15).addBox(-2.593F, 4.68F, 4.57F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(4, 35).addBox(1.9F, 4.68F, 4.57F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(36, 6).addBox(-2.592F, 3.98F, 4.47F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(36, 11).addBox(1.908F, 3.98F, 4.47F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0175F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r14",
                CubeListBuilder.create()
                        .texOffs(18, 17).addBox(-3.4F, 2.8F, 1.9F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.5236F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r15",
                CubeListBuilder.create()
                        .texOffs(33, 28).addBox(-3.792F, 4.2F, 1.8F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(33, 31).addBox(-2.092F, 4.2F, 1.8F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.6283F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r16",
                CubeListBuilder.create()
                        .texOffs(33, 34).addBox(-1.8F, 1.501F, 3.7F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0F, -0.733F, 0.0F));

        body.addOrReplaceChild("cube_r17",
                CubeListBuilder.create()
                        .texOffs(0, 35).addBox(0.8F, 1.501F, 3.7F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, 0.0F, 0.733F, 0.0F));

        PartDefinition rightArm = partDefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
        PartDefinition leftArm = partDefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks) {
    }

    public void prepareMobModel(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
