package fr.chrislinefield.ldoe.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("RETURN"), method = "createTitle", cancellable = true)
    private void createTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(cir.getReturnValue().replace("Minecraft", "Last Days on Earth").replaceFirst("\\*", ""));
    }
}
