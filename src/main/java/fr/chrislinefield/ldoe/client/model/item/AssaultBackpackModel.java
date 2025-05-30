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

public class AssaultBackpackModel <T extends Entity> extends EntityModel<T>
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ldoemod", "assault_backpack"), "main");
    public final ModelPart body;
    public final ModelPart rightArm;
    public final ModelPart leftArm;

    public AssaultBackpackModel(ModelPart root) {
        this.body = root.getChild("Body");
        this.rightArm = root.getChild("RightArm");
        this.leftArm = root.getChild("LeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("Body",
                CubeListBuilder.create()
                        .texOffs(26, 0).addBox(-4.5F, 0.1F, 2.1F, 9.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 52).addBox(-4.4F, 9.392F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(58, 39).addBox(0.4F, 9.401F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(26, 59).addBox(0.4F, 8.101F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(52, 24).addBox(-4.4F, 8.092F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(58, 61).addBox(0.4F, 5.501F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 54).addBox(-4.4F, 5.492F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(36, 59).addBox(0.4F, 6.801F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(52, 26).addBox(-4.4F, 6.792F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(46, 59).addBox(0.4F, 2.901F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(52, 28).addBox(-4.4F, 2.892F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 59).addBox(0.4F, 1.601F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 53).addBox(-4.4F, 1.592F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 60).addBox(0.4F, 4.201F, 1.708F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(52, 53).addBox(-4.4F, 4.192F, 1.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(42, 31).addBox(-4.0F, 11.7F, 2.7F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(44, 16).addBox(4.0F, 0.5F, 2.5F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(12, 32).addBox(-5.0F, 0.5F, 2.3F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(26, 16).addBox(-3.0F, -1.1F, 2.5F, 6.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(26, 31).addBox(-2.5F, -0.9F, 2.2F, 5.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 32).addBox(-2.1F, -1.3F, 3.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 0).addBox(-4.0F, 0.4F, 2.8F, 8.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 16).addBox(-4.0F, 0.4F, 1.9F, 8.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(42, 42).addBox(-4.0F, 11.0F, 5.6F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(42, 35).addBox(-3.5F, 5.0F, 7.7F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(58, 35).addBox(-0.3F, 9.7F, 7.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 22).addBox(-0.3F, 8.3F, 7.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 56).addBox(-0.3F, 6.9F, 7.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 0).addBox(-0.3F, 5.5F, 7.8F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 2).addBox(-3.7F, 5.492F, 7.808F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 4).addBox(-3.7F, 6.892F, 7.808F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 58).addBox(-3.7F, 8.292F, 7.808F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(58, 37).addBox(-3.7F, 9.692F, 7.808F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 6).addBox(-3.7F, 1.292F, 7.608F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 8).addBox(-0.3F, 1.3F, 7.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 10).addBox(-0.3F, 2.6F, 7.6F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 12).addBox(-3.7F, 2.592F, 7.608F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 48).addBox(-3.5F, 1.0F, 7.5F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r1",
                CubeListBuilder.create()
                        .texOffs(64, 14).addBox(3.8F, 4.692F, 6.9F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.7F, -0.1F, 0.0F, -0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r2",
                CubeListBuilder.create()
                        .texOffs(62, 41).addBox(-4.8F, 4.692F, 6.9F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.7F, -0.1F, 0.0F, 0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r3",
                CubeListBuilder.create()
                        .texOffs(28, 65).addBox(-4.9F, 8.392F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(24, 65).addBox(-4.9F, 7.092F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.8F, 0.1F, 0.0F, 0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r4",
                CubeListBuilder.create()
                        .texOffs(4, 66).addBox(3.9F, 8.392F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 2).addBox(3.9F, 7.092F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.8F, 0.1F, 0.0F, -0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r5",
                CubeListBuilder.create()
                        .texOffs(64, 57).addBox(-4.9F, 8.692F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 55).addBox(-4.9F, 10.092F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 59).addBox(-4.9F, 11.492F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 41).addBox(-4.9F, 12.892F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -3.2F, 0.3F, 0.0F, 0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r6",
                CubeListBuilder.create()
                        .texOffs(66, 0).addBox(3.9F, 8.392F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 66).addBox(3.9F, 9.792F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 63).addBox(3.9F, 11.192F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 43).addBox(3.9F, 12.592F, 6.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -2.9F, 0.3F, 0.0F, -0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r7",
                CubeListBuilder.create()
                        .texOffs(58, 63).addBox(-4.8F, 4.992F, 6.9F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.0F, 0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r8",
                CubeListBuilder.create()
                        .texOffs(62, 63).addBox(3.8F, 4.692F, 6.9F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.3F, 0.1F, 0.0F, -0.1396F, 0.0F));

        body.addOrReplaceChild("cube_r9",
                CubeListBuilder.create()
                        .texOffs(0, 52).addBox(-3.5F, -0.7F, 7.3F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, -0.192F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r10",
                CubeListBuilder.create()
                        .texOffs(64, 53).addBox(-0.492F, 11.3F, 5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 51).addBox(-3.5F, 11.2F, 5.3F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.3F, 0.1F, 0.192F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r11",
                CubeListBuilder.create()
                        .texOffs(16, 50).addBox(-3.5F, 4.6F, 6.4F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.192F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r12",
                CubeListBuilder.create()
                        .texOffs(40, 49).addBox(-3.5F, 2.9F, 8.2F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.3F, 0.1F, -0.192F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r13",
                CubeListBuilder.create()
                        .texOffs(34, 46).addBox(-5.3F, 0.392F, 4.9F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.0F, 0.1571F, 0.0F));

        body.addOrReplaceChild("cube_r14",
                CubeListBuilder.create()
                        .texOffs(64, 20).addBox(5.0F, 3.592F, 6.05F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 4).addBox(5.0F, 8.492F, 6.55F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 24).addBox(5.4F, 8.292F, 4.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(18, 58).addBox(5.2F, 8.392F, 4.35F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.2F, -0.0893F, -0.2439F, 0.0109F));

        body.addOrReplaceChild("cube_r15",
                CubeListBuilder.create()
                        .texOffs(16, 66).addBox(5.0F, 3.392F, 6.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 12).addBox(5.0F, 8.292F, 6.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(8, 66).addBox(5.4F, 8.492F, 4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(26, 61).addBox(5.2F, 8.392F, 4.4F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, -0.0893F, -0.2439F, 0.0109F));

        body.addOrReplaceChild("cube_r16",
                CubeListBuilder.create()
                        .texOffs(56, 14).addBox(-5.16F, 8.692F, 2.36F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.0F, 0.1F, -0.0168F, -0.018F, -0.0115F));

        body.addOrReplaceChild("cube_r17",
                CubeListBuilder.create()
                        .texOffs(40, 55).addBox(-5.18F, 8.68F, 2.28F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.5F, 0.2F, -0.0168F, -0.018F, -0.0115F));

        body.addOrReplaceChild("cube_r18",
                CubeListBuilder.create()
                        .texOffs(56, 55).addBox(3.86F, 8.792F, 2.26F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.1F, -5.0F, 0.1F, -0.0168F, 0.0169F, -0.0121F));

        body.addOrReplaceChild("cube_r19",
                CubeListBuilder.create()
                        .texOffs(48, 55).addBox(3.87F, 8.792F, 2.2F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.1F, -5.5F, 0.2F, -0.0168F, 0.0169F, -0.0121F));

        body.addOrReplaceChild("cube_r20",
                CubeListBuilder.create()
                        .texOffs(12, 66).addBox(-6.4F, 8.392F, 6.53F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 65).addBox(-6.4F, 13.392F, 6.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 22).addBox(-6.8F, 13.192F, 4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(8, 62).addBox(-6.6F, 13.292F, 4.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 18).addBox(-6.7F, 8.192F, 4.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 49).addBox(-6.5F, 8.292F, 4.35F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.5F, 0.2F, -0.0892F, 0.243F, -0.0322F));

        body.addOrReplaceChild("cube_r21",
                CubeListBuilder.create()
                        .texOffs(24, 67).addBox(-6.4F, 8.192F, 6.58F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(32, 67).addBox(-6.4F, 13.192F, 7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(28, 67).addBox(-6.8F, 13.392F, 4.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 62).addBox(-6.6F, 13.292F, 4.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 10).addBox(-6.7F, 8.392F, 4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(50, 61).addBox(-6.5F, 8.292F, 4.4F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.0F, 0.1F, -0.0892F, 0.243F, -0.0322F));

        body.addOrReplaceChild("cube_r22",
                CubeListBuilder.create()
                        .texOffs(66, 8).addBox(5.4F, 8.492F, 4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(42, 61).addBox(5.2F, 8.392F, 4.4F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.0F, 0.1F, -0.0893F, -0.2439F, 0.0109F));

        body.addOrReplaceChild("cube_r23",
                CubeListBuilder.create()
                        .texOffs(28, 52).addBox(5.4F, 8.292F, 4.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(56, 18).addBox(5.2F, 8.392F, 4.35F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.5F, 0.2F, -0.0893F, -0.2439F, 0.0109F));

        body.addOrReplaceChild("cube_r24",
                CubeListBuilder.create()
                        .texOffs(60, 45).addBox(-5.19F, 8.292F, 2.91F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, -0.0866F, -0.0178F, -0.0091F));

        body.addOrReplaceChild("cube_r25",
                CubeListBuilder.create()
                        .texOffs(10, 58).addBox(-5.2F, 8.31F, 2.86F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.5F, 0.2F, -0.0866F, -0.0178F, -0.0091F));

        body.addOrReplaceChild("cube_r26",
                CubeListBuilder.create()
                        .texOffs(34, 61).addBox(3.87F, 8.392F, 2.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.1F, -0.5F, 0.2F, -0.0866F, 0.0169F, -0.0121F));

        body.addOrReplaceChild("cube_r27",
                CubeListBuilder.create()
                        .texOffs(0, 62).addBox(3.86F, 8.392F, 2.86F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.1F, 0.0F, 0.1F, -0.0866F, 0.0169F, -0.0121F));

        body.addOrReplaceChild("cube_r28",
                CubeListBuilder.create()
                        .texOffs(20, 32).addBox(4.3F, 0.392F, 4.9F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.0F, -0.1571F, 0.0F));

        body.addOrReplaceChild("cube_r29",
                CubeListBuilder.create()
                        .texOffs(12, 54).addBox(-4.2F, -2.0F, 2.408F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.2F, 0.1F, 0.0F, 0.0F, -0.4538F));

        body.addOrReplaceChild("cube_r30",
                CubeListBuilder.create()
                        .texOffs(22, 54).addBox(2.3F, -2.0F, 2.408F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.2F, 0.1F, 0.0F, 0.0F, 0.4538F));

        body.addOrReplaceChild("cube_r31",
                CubeListBuilder.create()
                        .texOffs(18, 46).addBox(-2.9F, -3.1F, 4.9F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(42, 45).addBox(-3.4F, -3.0F, 4.5F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.2F, 0.1F, -0.4538F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r32",
                CubeListBuilder.create()
                        .texOffs(52, 12).addBox(4.7F, 0.5F, 4.3F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.1F, 0.0F, 0.1F, 0.0F, -0.192F, 0.0F));

        body.addOrReplaceChild("cube_r33",
                CubeListBuilder.create()
                        .texOffs(52, 0).addBox(-5.8F, 0.5F, 4.2F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 51).addBox(3.1F, 4.2F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 49).addBox(3.1F, 1.6F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 32).addBox(3.1F, 2.9F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 30).addBox(3.1F, 6.8F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(66, 6).addBox(3.1F, 5.5F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 28).addBox(3.1F, 8.1F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 26).addBox(3.1F, 9.4F, 2.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.0F, 0.192F, 0.0F));

        body.addOrReplaceChild("cube_r34",
                CubeListBuilder.create()
                        .texOffs(0, 46).addBox(-3.992F, 12.5F, 2.2F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.1F, 0.2618F, 0.0F, 0.0F));

        body.addOrReplaceChild("cube_r35",
                CubeListBuilder.create()
                        .texOffs(52, 65).addBox(-4.1F, 9.4F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(48, 65).addBox(-4.1F, 6.8F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(44, 65).addBox(-4.1F, 8.1F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(40, 65).addBox(-4.1F, 12.0F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(20, 66).addBox(-4.1F, 10.7F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(36, 65).addBox(-4.1F, 13.3F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(32, 65).addBox(-4.1F, 14.6F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -5.2F, 0.1F, 0.0F, -0.192F, 0.0F));

        PartDefinition rightArm = partDefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
        PartDefinition leftArm = partDefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
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
