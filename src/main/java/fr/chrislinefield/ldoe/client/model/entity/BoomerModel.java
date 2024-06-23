package fr.chrislinefield.ldoe.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.chrislinefield.ldoe.client.animations.ModAnimationDefinitions;
import fr.chrislinefield.ldoe.common.entity.BoomerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class BoomerModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart main;
	private final ModelPart mainsplat;
	private final ModelPart splat9;
	private final ModelPart splat10;
	private final ModelPart splat11;
	private final ModelPart splat12;
	private final ModelPart splat13;
	private final ModelPart splat14;
	private final ModelPart splat15;
	private final ModelPart splat16;
	private final ModelPart splat17;
	private final ModelPart splat;
	private final ModelPart splat1;
	private final ModelPart splat6;
	private final ModelPart splat7;
	private final ModelPart splat8;
	private final ModelPart splat2;
	private final ModelPart splat3;
	private final ModelPart splat4;
	private final ModelPart splat5;
	private final ModelPart body;
	private final ModelPart fat;
	private final ModelPart head;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart lowerbody;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public BoomerModel(ModelPart root) {
		this.main = root.getChild("main");
		this.mainsplat = main.getChild("mainsplat");
		this.splat9 = mainsplat.getChild("splat9");
		this.splat10 = splat9.getChild("splat10");
		this.splat11 = splat9.getChild("splat11");
		this.splat12 = splat9.getChild("splat12");
		this.splat13 = splat9.getChild("splat13");
		this.splat14 = splat9.getChild("splat14");
		this.splat15 = splat9.getChild("splat15");
		this.splat16 = splat9.getChild("splat16");
		this.splat17 = splat9.getChild("splat17");
		this.splat = mainsplat.getChild("splat");
		this.splat1 = splat.getChild("splat1");
		this.splat6 = splat.getChild("splat6");
		this.splat7 = splat.getChild("splat7");
		this.splat8 = splat.getChild("splat8");
		this.splat2 = splat.getChild("splat2");
		this.splat3 = splat.getChild("splat3");
		this.splat4 = splat.getChild("splat4");
		this.splat5 = splat.getChild("splat5");
		this.body = main.getChild("body");
		this.fat = body.getChild("fat");
		this.head = body.getChild("head");
		this.left_arm = body.getChild("left_arm");
		this.right_arm = body.getChild("right_arm");
		this.lowerbody = main.getChild("lowerbody");
		this.left_leg = lowerbody.getChild("left_leg");
		this.right_leg = lowerbody.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mainsplat = main.addOrReplaceChild("mainsplat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition splat9 = mainsplat.addOrReplaceChild("splat9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition splat10 = splat9.addOrReplaceChild("splat10", CubeListBuilder.create().texOffs(97, 100).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition splat11 = splat9.addOrReplaceChild("splat11", CubeListBuilder.create().texOffs(67, 100).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -13.0F, -2.0F));

		PartDefinition splat12 = splat9.addOrReplaceChild("splat12", CubeListBuilder.create().texOffs(100, 45).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -13.0F, -2.0F));

		PartDefinition splat13 = splat9.addOrReplaceChild("splat13", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -3.5F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -13.0F, 2.0F));

		PartDefinition splat14 = splat9.addOrReplaceChild("splat14", CubeListBuilder.create().texOffs(90, 25).addBox(-4.0F, -3.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -14.0F, 0.0F));

		PartDefinition splat15 = splat9.addOrReplaceChild("splat15", CubeListBuilder.create().texOffs(23, 88).addBox(-4.0F, -3.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -14.0F, 0.0F));

		PartDefinition splat16 = splat9.addOrReplaceChild("splat16", CubeListBuilder.create().texOffs(86, 0).addBox(-4.0F, -3.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 2.0F));

		PartDefinition splat17 = splat9.addOrReplaceChild("splat17", CubeListBuilder.create().texOffs(83, 81).addBox(-4.0F, -3.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -2.0F));

		PartDefinition splat = mainsplat.addOrReplaceChild("splat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition splat1 = splat.addOrReplaceChild("splat1", CubeListBuilder.create().texOffs(0, 82).addBox(-4.0F, -4.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition splat6 = splat.addOrReplaceChild("splat6", CubeListBuilder.create().texOffs(53, 81).addBox(-4.0F, -4.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -13.0F, -2.0F));

		PartDefinition splat7 = splat.addOrReplaceChild("splat7", CubeListBuilder.create().texOffs(78, 13).addBox(-4.0F, -4.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -13.0F, -2.0F));

		PartDefinition splat8 = splat.addOrReplaceChild("splat8", CubeListBuilder.create().texOffs(77, 52).addBox(-4.0F, -4.0F, -3.5F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -13.0F, 2.0F));

		PartDefinition splat2 = splat.addOrReplaceChild("splat2", CubeListBuilder.create().texOffs(30, 74).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -14.0F, 0.0F));

		PartDefinition splat3 = splat.addOrReplaceChild("splat3", CubeListBuilder.create().texOffs(72, 38).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -14.0F, 0.0F));

		PartDefinition splat4 = splat.addOrReplaceChild("splat4", CubeListBuilder.create().texOffs(0, 68).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 2.0F));

		PartDefinition splat5 = splat.addOrReplaceChild("splat5", CubeListBuilder.create().texOffs(61, 67).addBox(-4.0F, -5.0F, -3.5F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -2.0F));

		PartDefinition body = main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 108).addBox(-7.0F, -12.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(107, 72).addBox(6.0F, -12.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(-6.0F, -14.0F, -4.0F, 12.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(116, 0).addBox(-5.0F, -14.0F, 4.0F, 10.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(113, 85).addBox(-5.0F, -14.0F, -5.0F, 10.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(89, 93).addBox(-8.0F, -6.0F, 7.0F, 16.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 93).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 112).addBox(6.0F, 0.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(36, 44).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(92, 110).addBox(-7.0F, 0.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-7.0F, -9.0F, -7.0F, 14.0F, 3.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(41, 93).addBox(-8.0F, -9.0F, -6.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(91, 64).addBox(7.0F, -9.0F, -6.0F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.0F, -2.0F, 14.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -4.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition fat = body.addOrReplaceChild("fat", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 58).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(84, 64).addBox(-5.0F, -3.0F, -6.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 121).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 108).addBox(-2.0F, -2.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -10.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 121).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(108, 12).addBox(-4.0F, -2.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition lowerbody = main.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(42, 24).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-5.0F, -2.0F, -4.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(70, 110).addBox(6.0F, -1.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(110, 27).addBox(-7.0F, -1.0F, -5.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition left_leg = lowerbody.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 118).addBox(-0.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(105, 58).addBox(-1.9F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition right_leg = lowerbody.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-3.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 104).addBox(-4.1F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -2.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.BOOMER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((BoomerEntity) entity).idleAnimationState, ModAnimationDefinitions.BOOMER_IDLE, ageInTicks, 1f);
		this.animate(((BoomerEntity) entity).attackAnimationState, ModAnimationDefinitions.BOOMER_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return main;
	}
}