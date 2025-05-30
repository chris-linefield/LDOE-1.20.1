package fr.chrislinefield.ldoe.worldgen.inventory;

import fr.chrislinefield.ldoe.common.init.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BackpackMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>>
{
    public static final HashMap<String, Object> guiState = new HashMap<>();
    public final Level world;
    public final Player player;
    public int x;
    public int y;
    public int z;
    private ContainerLevelAccess containerAccess;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots;
    private boolean bound;
    private Supplier<Boolean> boundItemMatcher;
    private Entity boundEntity;
    private BlockEntity boundBlockEntity;

    public BackpackMenu(int id, Inventory playerInventory, FriendlyByteBuf extraData) {
        super(ModMenuTypes.BACKPACK_MENU.get(), id);
        this.containerAccess = ContainerLevelAccess.NULL;
        this.customSlots = new HashMap<>();
        this.bound = false;
        this.boundItemMatcher = null;
        this.boundEntity = null;
        this.boundBlockEntity = null;
        this.player = playerInventory.player;
        this.world = playerInventory.player.level();
        this.internal = new ItemStackHandler(18);
        BlockPos pos = null;
        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            this.containerAccess = ContainerLevelAccess.create(world, pos);
        }

        if (pos != null) {
            if (extraData.readableBytes() == 1) {
                byte hand = extraData.readByte();
                ItemStack itemStack = hand == 0 ? this.player.getMainHandItem() : this.player.getOffhandItem();
                this.boundItemMatcher = () -> itemStack == (hand == 0 ? this.player.getMainHandItem() : this.player.getOffhandItem());
                itemStack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent((capability) -> {
                    this.internal = capability;
                    this.bound = true;
                });
            } else if (extraData.readableBytes() > 1) {
                extraData.readByte();
                this.boundEntity = this.world.getEntity(extraData.readVarInt());
                if (this.boundEntity != null) {
                    this.boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent((capability) -> {
                        this.internal = capability;
                        this.bound = true;
                    });
                }
            } else {
                this.boundBlockEntity = this.world.getBlockEntity(pos);
                if (this.boundBlockEntity != null) {
                    this.boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent((capability) -> {
                        this.internal = capability;
                        this.bound = true;
                    });
                }
            }
        }

        this.customSlots.put(0, this.addSlot(new SlotItemHandler(this.internal, 0, 61, 8)));
        this.customSlots.put(1, this.addSlot(new SlotItemHandler(this.internal, 1, 79, 8)));
        this.customSlots.put(2, this.addSlot(new SlotItemHandler(this.internal, 2, 97, 8)));
        this.customSlots.put(3, this.addSlot(new SlotItemHandler(this.internal, 3, 115, 8)));
        this.customSlots.put(4, this.addSlot(new SlotItemHandler(this.internal, 4, 133, 8)));
        this.customSlots.put(5, this.addSlot(new SlotItemHandler(this.internal, 5, 151, 8)));
        this.customSlots.put(6, this.addSlot(new SlotItemHandler(this.internal, 6, 61, 26)));
        this.customSlots.put(7, this.addSlot(new SlotItemHandler(this.internal, 7, 79, 26)));
        this.customSlots.put(8, this.addSlot(new SlotItemHandler(this.internal, 8, 97, 26)));
        this.customSlots.put(9, this.addSlot(new SlotItemHandler(this.internal, 9, 115, 26)));
        this.customSlots.put(10, this.addSlot(new SlotItemHandler(this.internal, 10, 133, 26)));
        this.customSlots.put(11, this.addSlot(new SlotItemHandler(this.internal, 11, 151, 26)));
        this.customSlots.put(12, this.addSlot(new SlotItemHandler(this.internal, 12, 61, 44)));
        this.customSlots.put(13, this.addSlot(new SlotItemHandler(this.internal, 13, 79, 44)));
        this.customSlots.put(14, this.addSlot(new SlotItemHandler(this.internal, 14, 97, 44)));
        this.customSlots.put(15, this.addSlot(new SlotItemHandler(this.internal, 15, 115, 44)));
        this.customSlots.put(16, this.addSlot(new SlotItemHandler(this.internal, 16, 133, 44)));
        this.customSlots.put(17, this.addSlot(new SlotItemHandler(this.internal, 17, 151, 44)));

        for (int si = 0; si < 3; ++si) {
            for (int sj = 0; sj < 9; ++sj) {
                this.addSlot(new Slot(playerInventory, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
            }
        }

        for (int si = 0; si < 9; ++si) {
            this.addSlot(new Slot(playerInventory, si, 8 + si * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.bound) {
            if (this.boundItemMatcher != null) {
                return this.boundItemMatcher.get();
            }

            if (this.boundBlockEntity != null) {
                return AbstractContainerMenu.stillValid(this.containerAccess, player, this.boundBlockEntity.getBlockState().getBlock());
            }

            if (this.boundEntity != null) {
                return this.boundEntity.isAlive();
            }
        }

        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack slotItemStack = slot.getItem();
            itemStack = slotItemStack.copy();
            if (index < 18) {
                if (!this.moveItemStackTo(slotItemStack, 18, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, 18, false)) {
                if (index < 45) {
                    if (!this.moveItemStackTo(slotItemStack, 45, this.slots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(slotItemStack, 18, 45, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotItemStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotItemStack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotItemStack);
        }

        return itemStack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack itemStack, int startIndex, int endIndex, boolean reverseDirection) {
        boolean success = false;
        int currentIndex = startIndex;
        if (reverseDirection) {
            currentIndex = endIndex - 1;
        }

        Slot slot;
        ItemStack existingItemStack;
        if (itemStack.isStackable()) {
            while (!itemStack.isEmpty()) {
                if (reverseDirection) {
                    if (currentIndex < startIndex) {
                        break;
                    }
                } else if (currentIndex >= endIndex) {
                    break;
                }

                slot = this.slots.get(currentIndex);
                existingItemStack = slot.getItem();
                if (!existingItemStack.isEmpty() && ItemStack.isSameItemSameTags(itemStack, existingItemStack)) {
                    int combinedCount = existingItemStack.getCount() + itemStack.getCount();
                    int maxSize = Math.min(slot.getMaxStackSize(), itemStack.getMaxStackSize());
                    if (combinedCount <= maxSize) {
                        itemStack.setCount(0);
                        existingItemStack.setCount(combinedCount);
                        slot.set(existingItemStack);
                        success = true;
                    } else if (existingItemStack.getCount() < maxSize) {
                        itemStack.shrink(maxSize - existingItemStack.getCount());
                        existingItemStack.setCount(maxSize);
                        slot.set(existingItemStack);
                        success = true;
                    }
                }

                if (reverseDirection) {
                    --currentIndex;
                } else {
                    ++currentIndex;
                }
            }
        }

        if (!itemStack.isEmpty()) {
            if (reverseDirection) {
                currentIndex = endIndex - 1;
            } else {
                currentIndex = startIndex;
            }

            while (true) {
                if (reverseDirection) {
                    if (currentIndex < startIndex) {
                        break;
                    }
                } else if (currentIndex >= endIndex) {
                    break;
                }

                slot = this.slots.get(currentIndex);
                existingItemStack = slot.getItem();
                if (existingItemStack.isEmpty() && slot.mayPlace(itemStack)) {
                    if (itemStack.getCount() > slot.getMaxStackSize()) {
                        slot.set(itemStack.split(slot.getMaxStackSize()));
                    } else {
                        slot.set(itemStack.split(itemStack.getCount()));
                    }

                    slot.setChanged();
                    success = true;
                    break;
                }

                if (reverseDirection) {
                    --currentIndex;
                } else {
                    ++currentIndex;
                }
            }
        }

        return success;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!this.bound && player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
                for (int j = 0; j < this.internal.getSlots(); ++j) {
                    if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4 && j != 5 && j != 6 && j != 7 && j != 8 && j != 9 && j != 10 && j != 11 && j != 12 && j != 13 && j != 14 && j != 15 && j != 16 && j != 17) {
                        player.drop(this.internal.extractItem(j, this.internal.getStackInSlot(j).getCount(), false), false);
                    }
                }
            } else {
                for (int j = 0; j < this.internal.getSlots(); ++j) {
                    if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4 && j != 5 && j != 6 && j != 7 && j != 8 && j != 9 && j != 10 && j != 11 && j != 12 && j != 13 && j != 14 && j != 15 && j != 16 && j != 17) {
                        player.getInventory().placeItemBackInInventory(this.internal.extractItem(j, this.internal.getStackInSlot(j).getCount(), false));
                    }
                }
            }
        }
    }

    @Override
    public Map<Integer, Slot> get() {
        return this.customSlots;
    }

}
