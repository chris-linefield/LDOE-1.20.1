package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.client.gui.AssaultBackpackScreen;
import fr.chrislinefield.ldoe.client.gui.BackpackScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ModMenuScreen
{
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.BACKPACK_MENU.get(), BackpackScreen::new);
            MenuScreens.register(ModMenuTypes.ASSAULT_BACKPACK_MENU.get(), AssaultBackpackScreen::new);
        });
    }
}
