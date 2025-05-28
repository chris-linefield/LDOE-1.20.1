package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.item.GhillieSuitArmor;
import fr.chrislinefield.ldoe.common.item.MetalDetectorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LDOEMod.MOD_ID);

    //BLOCK
    //public static RegistryObject<BlockItem> GARBAGE = ITEMS.register("garbage_item", () -> new BlockItem(ModBlocks.GARBAGE_BLOCK.get(), new Item.Properties()));

    //INGREDIENTS
    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NAILS = ITEMS.register("nails",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAN_OPENER = ITEMS.register("can_opener",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_METAL = ITEMS.register("scrap_metal",
            ()-> new Item(new Item.Properties()));

    //WEAPONS
    public static final RegistryObject<Item> BAT = ITEMS.register("bat",
            ()-> new SwordItem(Tiers.WOOD, 5, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> DAGGER = ITEMS.register("dagger",
            ()-> new SwordItem(Tiers.IRON, 2, -1, new Item.Properties()));
    public static final RegistryObject<Item> SWORD = ITEMS.register("sword",
            ()-> new SwordItem(Tiers.IRON, 4, -2, new Item.Properties()));
    public static final RegistryObject<Item> BIG_SWORD = ITEMS.register("big_sword",
            ()-> new SwordItem(Tiers.DIAMOND, 6, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> FIRE_AXE = ITEMS.register("fire_axe",
            ()-> new AxeItem(Tiers.IRON, 9, -3.2f, new Item.Properties()));
    public static final RegistryObject<Item> BIG_AXE = ITEMS.register("big_axe",
            ()-> new AxeItem(Tiers.DIAMOND, 12, -3.2f, new Item.Properties()));

    //ARMOR
    public static final RegistryObject<Item> SCRAP_HELMET = ITEMS.register("scrap_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_CHESTPLATE = ITEMS.register("scrap_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_LEGGINGS = ITEMS.register("scrap_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCRAP_BOOTS = ITEMS.register("scrap_boots",
            () -> new ModArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> GHILLIE_HELMET = ITEMS.register("ghillie_helmet",
            () -> new GhillieSuitArmor(ModArmorMaterials.GHILLIE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GHILLIE_CHESTPLATE = ITEMS.register("ghillie_chestplate",
            () -> new GhillieSuitArmor(ModArmorMaterials.GHILLIE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GHILLIE_LEGGINGS = ITEMS.register("ghillie_leggings",
            () -> new GhillieSuitArmor(ModArmorMaterials.GHILLIE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GHILLIE_BOOTS = ITEMS.register("ghillie_boots",
            () -> new GhillieSuitArmor(ModArmorMaterials.GHILLIE, ArmorItem.Type.BOOTS, new Item.Properties()));


    //FOODS
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties()));

    //TOOLS
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(60)));

    //MISC
    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(6, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1), 2440));

    //SPAWNEGG
    public static final RegistryObject<Item> BOOMER_SPANW_EGG = ITEMS.register("boomer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BOOMER, 0x7e9680, 0xc5d1c5, new Item.Properties()));
    public static final RegistryObject<Item> CRAWLER_SPANW_EGG = ITEMS.register("crawler_zombie_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRAWLER_ZOMBIE, 0x7e9680, 0xc5d1c5, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
