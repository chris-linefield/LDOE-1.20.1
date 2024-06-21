package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.item.MetalDetectorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LDOEMod.MOD_ID);

    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NAILS = ITEMS.register("nails",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAN_OPENER = ITEMS.register("can_opener",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BAT = ITEMS.register("bat",
            ()-> new SwordItem(Tiers.WOOD, 5, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> SWORD = ITEMS.register("sword",
            ()-> new SwordItem(Tiers.IRON, 4, -2, new Item.Properties()));
    public static final RegistryObject<Item> BIG_SWORD = ITEMS.register("big_sword",
            ()-> new SwordItem(Tiers.DIAMOND, 6, -2.5f, new Item.Properties()));
    public static final RegistryObject<Item> FIRE_AXE = ITEMS.register("fire_axe",
            ()-> new AxeItem(Tiers.IRON, 9, -3.2f, new Item.Properties()));
    public static final RegistryObject<Item> BIG_AXE = ITEMS.register("big_axe",
            ()-> new AxeItem(Tiers.DIAMOND, 12, -3.2f, new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(60)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
