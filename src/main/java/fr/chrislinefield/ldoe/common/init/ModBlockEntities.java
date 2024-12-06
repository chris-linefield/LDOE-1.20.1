package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.block.entity.GarbageBlockEntity;
import fr.chrislinefield.ldoe.common.block.entity.MiningBlockEntity;
import fr.chrislinefield.ldoe.common.block.entity.WorkbenchBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LDOEMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH_BE =
            BLOCK_ENTITIES.register("workbench_be", () ->
                    BlockEntityType.Builder.of(WorkbenchBlockEntity::new,
                            ModBlocks.WORKBENCH.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> MININGBLOCK_BE =
            BLOCK_ENTITIES.register("miningblock_be", () ->
                    BlockEntityType.Builder.of(MiningBlockEntity::new,
                            ModBlocks.MINING_PORTAL.get()).build(null));
    public static RegistryObject<BlockEntityType<GarbageBlockEntity>> GARBAGE_BE =
            BLOCK_ENTITIES.register("garbage_be", () -> BlockEntityType.Builder.of(GarbageBlockEntity::new,
                    ModBlocks.GARBAGE_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
