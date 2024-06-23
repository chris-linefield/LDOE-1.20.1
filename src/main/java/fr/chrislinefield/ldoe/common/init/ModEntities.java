package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LDOEMod.MOD_ID);


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}