package fr.chrislinefield.ldoe;

import fr.chrislinefield.ldoe.client.render.entity.BoomerRenderer;
import fr.chrislinefield.ldoe.client.render.entity.CrawlerZombieRenderer;
import fr.chrislinefield.ldoe.common.init.*;
import fr.chrislinefield.ldoe.config.ConfigHelper;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LDOEMod.MOD_ID)
public class LDOEMod
{
    public static final String MOD_ID = "ldoemod";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static ResourceKey<Level> MINING_DIMENSION;
    public static ResourceKey<Level> OVERWORLD;

    public LDOEMod()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigHelper.serverConfig);
        ConfigHelper.loadConfig(ConfigHelper.serverConfig,
                FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-server.toml").toString());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHelper.commonConfig);
        ConfigHelper.loadConfig(ConfigHelper.commonConfig,
                FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-common.toml").toString());

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(this::doClientStuff);
        }

        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        MINING_DIMENSION = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(LDOEMod.MOD_ID,"mining"));
        OVERWORLD = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("minecraft:overworld"));
    }

    @OnlyIn(Dist.CLIENT)
    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GARBAGE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BIGGARBAGE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TRASHCAN_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GUNSHELF_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ARROWSTORAGE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WOODGUNSHELF_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALLGUN_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISHBONEBAR_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KNIFEBOX_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LONGGUNSHELF_BLOCK.get(), RenderType.translucent());
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.BOOMER_SPANW_EGG);
            event.accept(ModItems.CRAWLER_SPANW_EGG);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.BOOMER.get(), BoomerRenderer::new);
            EntityRenderers.register(ModEntities.CRAWLER_ZOMBIE.get(), CrawlerZombieRenderer::new);
        }
    }
}
