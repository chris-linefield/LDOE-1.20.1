package fr.chrislinefield.ldoe.client.model.entity;

import fr.chrislinefield.ldoe.common.entity.InfectedMutatedEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InfectedMutatedModel extends GeoModel<InfectedMutatedEntity>
{
    public ResourceLocation getAnimationResource(InfectedMutatedEntity entity) {
        return new ResourceLocation("ldoemod", "animations/infectedmutatedr.animation.json");
    }

    public ResourceLocation getModelResource(InfectedMutatedEntity entity) {
        return new ResourceLocation("ldoemod", "geo/infectedmutatedr.geo.json");
    }

    public ResourceLocation getTextureResource(InfectedMutatedEntity entity) {
        return new ResourceLocation("ldoemod", "textures/entity/" + entity.getTexture() + ".png");
    }
}
