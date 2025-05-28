package fr.chrislinefield.ldoe.client.render.entity;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.client.ModModelLayers;
import fr.chrislinefield.ldoe.client.model.entity.CrawlerZombieModel;
import fr.chrislinefield.ldoe.common.entity.BoomerEntity;
import fr.chrislinefield.ldoe.common.entity.CrawlerZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CrawlerZombieRenderer<T extends CrawlerZombieEntity, M extends CrawlerZombieModel<T>>
        extends MobRenderer<T, M>
{
    @Override
    public ResourceLocation getTextureLocation(CrawlerZombieEntity crawlerZombie) {
        return new ResourceLocation(LDOEMod.MOD_ID, "textures/entity/crawler.png");
    }

    public CrawlerZombieRenderer(EntityRendererProvider.Context context) {
        super(context, (M) new CrawlerZombieModel(context.bakeLayer(ModModelLayers.CRAWLER_LAYER)), 0.5F);
    }

    protected boolean isShaking(@NotNull T p_230495_1_) {
        return false;
    }
}
