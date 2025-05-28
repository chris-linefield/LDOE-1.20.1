package fr.chrislinefield.ldoe.mixins;

import fr.chrislinefield.ldoe.LDOEMod;
import net.minecraft.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.LanguageSelectScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    private static final ResourceLocation DISCORD_BUTTON = new ResourceLocation(LDOEMod.MOD_ID, "textures/gui/title/discordbutton.png");

    protected TitleScreenMixin(Component pTitle) {
        super(pTitle);
    }

    @Inject(
            method = "init",
            at = @At("HEAD")
    )
    private void ldoemod$init(CallbackInfo callback) {
        int l = this.height / 4 + 48;

        this.addRenderableWidget(new ImageButton(this.width / 2 - 124, l + 48, 20, 20, 0, 0, 20, DISCORD_BUTTON, 20, 40,
                (p_280830_) -> {Util.getPlatform().openUri("https://discord.gg/7zhCSKKNDQ");}, Component.translatable("menu.discord")));
    }
}
