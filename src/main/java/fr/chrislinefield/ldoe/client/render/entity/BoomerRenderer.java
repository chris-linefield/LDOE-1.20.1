package fr.chrislinefield.ldoe.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.client.ModModelLayers;
import fr.chrislinefield.ldoe.client.model.entity.BoomerModel;
import fr.chrislinefield.ldoe.common.entity.BoomerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BoomerRenderer extends MobRenderer<BoomerEntity, BoomerModel<BoomerEntity>>
{

    public BoomerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BoomerModel<>(pContext.bakeLayer(ModModelLayers.BOOMER_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(BoomerEntity boomerEntity) {
        return new ResourceLocation(LDOEMod.MOD_ID, "textures/entity/boomer.png");
    }

    @Override
    public void render(BoomerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
