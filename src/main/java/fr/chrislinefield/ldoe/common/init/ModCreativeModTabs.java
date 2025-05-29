package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LDOEMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WEAPONS_TAB = CREATIVE_MODE_TABS.register("weapon_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.WOODEN_BAT.get()))
                    .title(Component.translatable("creativetab.weapon_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WOODEN_BAT.get());
                        pOutput.accept(ModItems.STEEL_BAT.get());
                        pOutput.accept(ModItems.APOCALYPTIC_BAT.get());
                        pOutput.accept(ModItems.FIRE_SWORD.get());
                        pOutput.accept(ModItems.FIRE_AXE.get());
                        pOutput.accept(ModItems.BIG_AXE.get());
                        pOutput.accept(ModItems.SWORD.get());
                        pOutput.accept(ModItems.BIG_SWORD.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ARMOR_TAB = CREATIVE_MODE_TABS.register("armor_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SCRAP_CHESTPLATE.get()))
                    .title(Component.translatable("creativetab.armor_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SCRAP_CHESTPLATE.get());
                        pOutput.accept(ModItems.SCRAP_BOOTS.get());
                        pOutput.accept(ModItems.SCRAP_HELMET.get());
                        pOutput.accept(ModItems.SCRAP_LEGGINGS.get());
                        pOutput.accept(ModItems.GHILLIE_CHESTPLATE.get());
                        pOutput.accept(ModItems.GHILLIE_BOOTS.get());
                        pOutput.accept(ModItems.GHILLIE_HELMET.get());
                        pOutput.accept(ModItems.GHILLIE_LEGGINGS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BLOCK_TAB = CREATIVE_MODE_TABS.register("block_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.BARBED_WIRE.get()))
                    .title(Component.translatable("creativetab.block_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BARBED_WIRE.get());
                        pOutput.accept(ModBlocks.QUICKSAND.get());
                        pOutput.accept(ModBlocks.RADIOACTIVE_BLOCK.get());
                        pOutput.accept(ModBlocks.WORKBENCH.get());
                        pOutput.accept(ModBlocks.MINING_PORTAL.get());
                        pOutput.accept(ModBlocks.GARBAGE_BLOCK.get());
                        pOutput.accept(ModBlocks.BIGGARBAGE_BLOCK.get());
                        pOutput.accept(ModBlocks.TRASHCAN_BLOCK.get());
                        pOutput.accept(ModBlocks.GUNSHELF_BLOCK.get());
                        pOutput.accept(ModBlocks.ARROWSTORAGE_BLOCK.get());
                        pOutput.accept(ModBlocks.WOODGUNSHELF_BLOCK.get());
                        pOutput.accept(ModBlocks.WALLGUN_BLOCK.get());
                        pOutput.accept(ModBlocks.WISHBONEBAR_BLOCK.get());
                        pOutput.accept(ModBlocks.KNIFEBOX_BLOCK.get());
                        pOutput.accept(ModBlocks.LONGGUNSHELF_BLOCK.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> TOOL_TAB = CREATIVE_MODE_TABS.register("tool_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.METAL_DETECTOR.get()))
                    .title(Component.translatable("creativetab.tool_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> INGREDIENT_TAB = CREATIVE_MODE_TABS.register("ingredient_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.NAILS.get()))
                    .title(Component.translatable("creativetab.ingredient_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BATTERY.get());
                        pOutput.accept(ModItems.NAILS.get());
                        pOutput.accept(ModItems.SCRAP_METAL.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("food_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.STRAWBERRY.get()))
                    .title(Component.translatable("creativetab.food_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MISC_TAB = CREATIVE_MODE_TABS.register("misc_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC.get()))
                    .title(Component.translatable("creativetab.misc_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
