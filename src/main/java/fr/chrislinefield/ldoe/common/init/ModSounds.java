package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.LDOEMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LDOEMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");
    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");
    public static final RegistryObject<SoundEvent> INFECTED_MUTATED_IDLE = registerSoundEvents("infectedmutatedidle");
    public static final RegistryObject<SoundEvent> INFECTED_MUTATED_HURT = registerSoundEvents("infectedmutatedhurt");
    public static final RegistryObject<SoundEvent> INFECTED_MUTATED_DEATH = registerSoundEvents("infectedmutateddeath");
    public static final RegistryObject<SoundEvent> BOOMER_HURT = registerSoundEvents("boomer_hurt");
    public static final RegistryObject<SoundEvent> BOOMER_DEATH = registerSoundEvents("boomer_death");
    public static final RegistryObject<SoundEvent> BOOMER_AMBIENT = registerSoundEvents("boomer_ambient");
    public static final RegistryObject<SoundEvent> WOODEN_BAT_HIT = registerSoundEvents("wooden_bat_hit");
    public static final RegistryObject<SoundEvent> METAL_BAT_HIT = registerSoundEvents("metal_bat_hit");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(LDOEMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
