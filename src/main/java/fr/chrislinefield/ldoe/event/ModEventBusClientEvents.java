package fr.chrislinefield.ldoe.event;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.client.ModModelLayers;
import fr.chrislinefield.ldoe.client.model.GhillieSuitModel;
import fr.chrislinefield.ldoe.client.model.entity.BoomerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LDOEMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BOOMER_LAYER, BoomerModel::createBodyLayer);
        event.registerLayerDefinition(GhillieSuitModel.LAYER_LOCATION, GhillieSuitModel::createBodyLayer);
    }

}
