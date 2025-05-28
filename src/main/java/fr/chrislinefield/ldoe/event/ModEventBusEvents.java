package fr.chrislinefield.ldoe.event;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.entity.BoomerEntity;
import fr.chrislinefield.ldoe.common.init.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LDOEMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BOOMER.get(), BoomerEntity.createAttributes().build());
        event.put(ModEntities.CRAWLER_ZOMBIE.get(), BoomerEntity.createAttributes().build());
    }
}