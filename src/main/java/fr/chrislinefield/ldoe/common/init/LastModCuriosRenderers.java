package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.client.model.item.BackpackModel;
import fr.chrislinefield.ldoe.client.render.item.AssaultBackpackRenderer;
import fr.chrislinefield.ldoe.client.render.item.BackpackRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class LastModCuriosRenderers
{
    @SubscribeEvent
    public static void registerLayers(RegisterLayerDefinitions evt)
    {
        evt.registerLayerDefinition(ModLayerDefinitions.BACKPACK, BackpackModel::createBodyLayer);
        evt.registerLayerDefinition(ModLayerDefinitions.ASSAULT_BACKPACK, BackpackModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent evt)
    {
        CuriosRendererRegistry.register(ModItems.BACKPACK.get(), BackpackRenderer::new);
        CuriosRendererRegistry.register(ModItems.ASSAULT_BACKPACK.get(), AssaultBackpackRenderer::new);
    }
}
