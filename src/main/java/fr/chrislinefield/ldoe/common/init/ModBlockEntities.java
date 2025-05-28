package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.block.entity.*;
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
    public static RegistryObject<BlockEntityType<TrashCanBlockEntity>> TRASHCAN_BE =
            BLOCK_ENTITIES.register("trashcan_be", () -> BlockEntityType.Builder.of(TrashCanBlockEntity::new,
                    ModBlocks.TRASHCAN_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<BigGarbageBlockEntity>> BIGGARBAGE_BE =
            BLOCK_ENTITIES.register("biggarbage_be", () -> BlockEntityType.Builder.of(BigGarbageBlockEntity::new,
                    ModBlocks.BIGGARBAGE_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<GunShelfBlockEntity>> GUNSHELF_BE =
            BLOCK_ENTITIES.register("gunshelf_be", () -> BlockEntityType.Builder.of(GunShelfBlockEntity::new,
                    ModBlocks.GUNSHELF_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<ArrowStorageBlockEntity>> ARROWSTORAGE_BE =
            BLOCK_ENTITIES.register("arrowstorage_be", () -> BlockEntityType.Builder.of(ArrowStorageBlockEntity::new,
                    ModBlocks.GARBAGE_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<WoodGunShelfBlockEntity>> WOODGUNSHELF_BE =
            BLOCK_ENTITIES.register("woodgunshelf_be", () -> BlockEntityType.Builder.of(WoodGunShelfBlockEntity::new,
                    ModBlocks.WOODGUNSHELF_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<WallGunBlockEntity>> WALLGUN_BE =
            BLOCK_ENTITIES.register("wallgun_be", () -> BlockEntityType.Builder.of(WallGunBlockEntity::new,
                    ModBlocks.WALLGUN_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<WishBoneBarBlockEntity>> WISHBONEBAR_BE =
            BLOCK_ENTITIES.register("wishbonebar_be", () -> BlockEntityType.Builder.of(WishBoneBarBlockEntity::new,
                    ModBlocks.WISHBONEBAR_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<KnifeBoxBlockEntity>> KNIFEBOX_BE =
            BLOCK_ENTITIES.register("knifebox_be", () -> BlockEntityType.Builder.of(KnifeBoxBlockEntity::new,
                    ModBlocks.KNIFEBOX_BLOCK.get()).build(null));
    public static RegistryObject<BlockEntityType<LongGunShelfBlockEntity>> LONGGUNSHELF_BE =
            BLOCK_ENTITIES.register("longgunshelf_be", () -> BlockEntityType.Builder.of(LongGunShelfBlockEntity::new,
                    ModBlocks.LONGGUNSHELF_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
