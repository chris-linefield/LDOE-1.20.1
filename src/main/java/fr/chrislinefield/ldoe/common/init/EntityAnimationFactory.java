package fr.chrislinefield.ldoe.common.init;

import fr.chrislinefield.ldoe.common.entity.InfectedMutatedEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event)
    {
        if (event != null && event.getEntity() != null) {
            LivingEntity var2 = event.getEntity();
            String animation;

            var2 = event.getEntity();
            if (var2 instanceof InfectedMutatedEntity) {
                InfectedMutatedEntity syncable = (InfectedMutatedEntity) var2;
                animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationProcedure = animation;
                }
            }
        }
    }
}