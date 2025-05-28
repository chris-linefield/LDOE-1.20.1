package fr.chrislinefield.ldoe.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig
{
    public static ForgeConfigSpec.BooleanValue thirst;
    public static ForgeConfigSpec.IntValue damageDecayRate;
    public static ForgeConfigSpec.IntValue loot_renew_ticks;

    public static void init(ForgeConfigSpec.Builder server) {
        thirst = server.comment("Controls whether the thirst mechanic should be enabled")
                .define("player.thirst", true);
        loot_renew_ticks = server.comment("Loot renew time in ticks (20 ticks = 1 sec), (12000 ticks = 10 min)")
                .defineInRange("loot_renew_ticks", 12000, 0, Integer.MAX_VALUE);
        damageDecayRate = server.comment("The rate of damaged blocks decay, how often does the decay update (12000 = every 12000 ticks - twice a day). Non-positive values disable the decay. Can be overridden by the damageDecayRate gamerule")
                .defineInRange("world.damageDecayRate", 12000, -1,
                Integer.MAX_VALUE);
    }
}
