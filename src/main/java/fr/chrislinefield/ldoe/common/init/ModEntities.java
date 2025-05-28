package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.entity.BoomerEntity;
import fr.chrislinefield.ldoe.common.entity.CrawlerZombieEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LDOEMod.MOD_ID);

    public static final RegistryObject<EntityType<BoomerEntity>> BOOMER =
            ENTITY_TYPES.register("boomer", () -> EntityType.Builder.of(BoomerEntity::new, MobCategory.MONSTER)
                    .sized(2.5f, 2.5f).build("boomer"));

    public static final RegistryObject<EntityType<CrawlerZombieEntity>> CRAWLER_ZOMBIE = ENTITY_TYPES.register(
            "crawler",
            () -> EntityType.Builder
                    .of((EntityType.EntityFactory<CrawlerZombieEntity>) CrawlerZombieEntity::new,
                            MobCategory.MONSTER)
                    .sized(0.9f, 0.33F)
                    .build("crawler"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}