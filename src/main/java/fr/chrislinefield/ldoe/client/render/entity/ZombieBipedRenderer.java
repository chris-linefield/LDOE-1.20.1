package fr.chrislinefield.ldoe.client.render.entity;

import fr.chrislinefield.ldoe.common.entity.ZombieBipedEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import org.jetbrains.annotations.NotNull;

public abstract class ZombieBipedRenderer<T extends ZombieBipedEntity, M extends HumanoidModel<T>>
        extends HumanoidMobRenderer<T, M> {

    public ZombieBipedRenderer(EntityRendererProvider.Context manager, ModelLayerLocation modelLayerLocation) {
        this(manager,modelLayerLocation,0.5f);
    }

    public ZombieBipedRenderer(EntityRendererProvider.Context manager, ModelLayerLocation modelLayerLocation, float shadow) {
        super(manager, (M) new HumanoidModel(manager.bakeLayer(modelLayerLocation)), shadow);
    }

    protected boolean isShaking(@NotNull T p_230495_1_) {
        return false;
    }

}
