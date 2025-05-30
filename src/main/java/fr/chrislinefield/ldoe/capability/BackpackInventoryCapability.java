package fr.chrislinefield.ldoe.capability;

import fr.chrislinefield.ldoe.client.gui.BackpackScreen;
import fr.chrislinefield.ldoe.common.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

@EventBusSubscriber({Dist.CLIENT})
public class BackpackInventoryCapability implements ICapabilitySerializable<CompoundTag>
{
    private final LazyOptional<ItemStackHandler> inventory = LazyOptional.of(this::createItemHandler);

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemDropped(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() == ModItems.BACKPACK.get() &&
                Minecraft.getInstance().screen instanceof BackpackScreen) {
            Minecraft.getInstance().player.closeContainer();
        }
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        return capability == ForgeCapabilities.ITEM_HANDLER ? this.inventory.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.getItemHandler().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.getItemHandler().deserializeNBT(nbt);
    }

    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(18) {
            @Override
            public int getSlotLimit(int slot) {
                return 64;
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() != ModItems.BACKPACK.get();
            }

            @Override
            public void setSize(int size) {
            }
        };
    }

    private ItemStackHandler getItemHandler() {
        return this.inventory.orElseThrow(RuntimeException::new);
    }
}
