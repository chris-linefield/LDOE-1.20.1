package fr.chrislinefield.ldoe.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.chrislinefield.ldoe.worldgen.inventory.BackpackMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class BackpackScreen extends AbstractContainerScreen<BackpackMenu>
{
    private static final HashMap<String, Object> guiState = new HashMap<>();
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player player;
    private static ResourceLocation texture;

    public BackpackScreen(BackpackMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.player = container.player;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        guiGraphics.blit(new ResourceLocation("ldoemod:textures/gui/screen/backpack.png"), this.leftPos + 8, this.topPos + 10, 0.0F, 0.0F, 48, 56, 48, 56);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int scanCode, int modifiers) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        } else {
            return super.keyPressed(key, scanCode, modifiers);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void init() {
        super.init();
    }

    static {
        guiState.putAll(BackpackScreen.guiState);
        texture = new ResourceLocation("ldoemod:textures/gui/screen/backpack_screen.png");
    }
}
