package fr.chrislinefield.ldoe.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;

import fr.chrislinefield.ldoe.worldgen.inventory.AssaultBackpackMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AssaultBackpackScreen extends AbstractContainerScreen<AssaultBackpackMenu> {
    private static final HashMap<String, Object> guiState = new HashMap<>();
    private final Level world;
    private final int x;
    private final int y;
    private final int z;
    private final Player player;
    private static final ResourceLocation texture;

    public AssaultBackpackScreen(AssaultBackpackMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.player = container.player;
        this.imageWidth = 215;
        this.imageHeight = 172;
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
        guiGraphics.blit(new ResourceLocation("ldoemod:textures/gui/screen/assault_backpack.png"), this.leftPos + 152, this.topPos + 10, 0.0F, 0.0F, 38, 42, 38, 42);
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
        guiState.putAll(AssaultBackpackMenu.guiState);
        texture = new ResourceLocation("ldoemod:textures/gui/screen/assault_backpack_screen.png");
    }
}

