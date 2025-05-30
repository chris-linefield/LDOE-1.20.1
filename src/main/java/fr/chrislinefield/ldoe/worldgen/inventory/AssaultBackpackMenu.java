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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AssaultBackpackMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public static final HashMap<String, Object> guiState = new HashMap<>();
    public final Level world;
    public final Player player;
    public int x;
    public int y;
    public int z;
    private ContainerLevelAccess access;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots;
    private boolean bound;
    private Supplier<Boolean> boundItemMatcher;
    private Entity boundEntity;
    private BlockEntity boundBlockEntity;

    public AssaultBackpackMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(ModMenuTypes.ASSAULT_BACKPACK_MENU.get(), id);
        this.access = ContainerLevelAccess.NULL;
        this.customSlots = new HashMap<>();
        this.bound = false;
        this.boundItemMatcher = null;
        this.boundEntity = null;
        this.boundBlockEntity = null;
        this.player = inv.player;
        this.world = inv.player.level();
        this.internal = new ItemStackHandler(42);
        BlockPos pos = null;

        if (extraData != null) {
            pos = extraData.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
            this.access = ContainerLevelAccess.create(this.world, pos);
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

            this.customSlots.put(0, this.addSlot(new SlotItemHandler(this.internal, 0, 27, 7)));
            this.customSlots.put(1, this.addSlot(new SlotItemHandler(this.internal, 1, 45, 7)));
            this.customSlots.put(2, this.addSlot(new SlotItemHandler(this.internal, 2, 63, 7)));
            this.customSlots.put(3, this.addSlot(new SlotItemHandler(this.internal, 3, 81, 7)));
            this.customSlots.put(4, this.addSlot(new SlotItemHandler(this.internal, 4, 99, 7)));
            this.customSlots.put(5, this.addSlot(new SlotItemHandler(this.internal, 5, 117, 7)));
            this.customSlots.put(6, this.addSlot(new SlotItemHandler(this.internal, 6, 135, 7)));
            this.customSlots.put(7, this.addSlot(new SlotItemHandler(this.internal, 7, 27, 25)));
            this.customSlots.put(8, this.addSlot(new SlotItemHandler(this.internal, 8, 45, 25)));
            this.customSlots.put(9, this.addSlot(new SlotItemHandler(this.internal, 9, 63, 25)));
            this.customSlots.put(10, this.addSlot(new SlotItemHandler(this.internal, 10, 81, 25)));
            this.customSlots.put(11, this.addSlot(new SlotItemHandler(this.internal, 11, 99, 25)));
            this.customSlots.put(12, this.addSlot(new SlotItemHandler(this.internal, 12, 117, 25)));
            this.customSlots.put(13, this.addSlot(new SlotItemHandler(this.internal, 13, 135, 25)));
            this.customSlots.put(14, this.addSlot(new SlotItemHandler(this.internal, 14, 27, 43)));
            this.customSlots.put(15, this.addSlot(new SlotItemHandler(this.internal, 15, 45, 43)));
            this.customSlots.put(16, this.addSlot(new SlotItemHandler(this.internal, 16, 63, 43)));
            this.customSlots.put(17, this.addSlot(new SlotItemHandler(this.internal, 17, 81, 43)));
            this.customSlots.put(18, this.addSlot(new SlotItemHandler(this.internal, 18, 99, 43)));
            this.customSlots.put(19, this.addSlot(new SlotItemHandler(this.internal, 19, 117, 43)));
            this.customSlots.put(20, this.addSlot(new SlotItemHandler(this.internal, 20, 135, 43)));
            this.customSlots.put(21, this.addSlot(new SlotItemHandler(this.internal, 21, 27, 61)));
            this.customSlots.put(22, this.addSlot(new SlotItemHandler(this.internal, 22, 45, 61)));
            this.customSlots.put(23, this.addSlot(new SlotItemHandler(this.internal, 23, 63, 61)));
            this.customSlots.put(24, this.addSlot(new SlotItemHandler(this.internal, 24, 81, 61)));
            this.customSlots.put(25, this.addSlot(new SlotItemHandler(this.internal, 25, 99, 61)));
            this.customSlots.put(26, this.addSlot(new SlotItemHandler(this.internal, 26, 117, 61)));
            this.customSlots.put(27, this.addSlot(new SlotItemHandler(this.internal, 27, 135, 61)));
            this.customSlots.put(28, this.addSlot(new SlotItemHandler(this.internal, 28, 153, 61)));
            this.customSlots.put(29, this.addSlot(new SlotItemHandler(this.internal, 29, 171, 61)));
            this.customSlots.put(30, this.addSlot(new SlotItemHandler(this.internal, 30, 6, 7)));
            this.customSlots.put(31, this.addSlot(new SlotItemHandler(this.internal, 31, 6, 25)));
            this.customSlots.put(32, this.addSlot(new SlotItemHandler(this.internal, 32, 6, 43)));
            this.customSlots.put(33, this.addSlot(new SlotItemHandler(this.internal, 33, 6, 61)));
            this.customSlots.put(34, this.addSlot(new SlotItemHandler(this.internal, 34, 191, 7)));
            this.customSlots.put(35, this.addSlot(new SlotItemHandler(this.internal, 35, 191, 25)));
            this.customSlots.put(36, this.addSlot(new SlotItemHandler(this.internal, 36, 191, 43)));
            this.customSlots.put(37, this.addSlot(new SlotItemHandler(this.internal, 37, 191, 61)));
            this.customSlots.put(38, this.addSlot(new SlotItemHandler(this.internal, 38, 6, 95)));
            this.customSlots.put(39, this.addSlot(new SlotItemHandler(this.internal, 39, 191, 95)));
            this.customSlots.put(40, this.addSlot(new SlotItemHandler(this.internal, 40, 6, 113)));
            this.customSlots.put(41, this.addSlot(new SlotItemHandler(this.internal, 41, 191, 113)));

            for (int si = 0; si < 3; ++si) {
                for (int sj = 0; sj < 9; ++sj) {
                    this.addSlot(new Slot(inv, sj + (si + 1) * 9, 28 + sj * 18, 87 + si * 18));
                }
            }

            for (int si = 0; si < 9; ++si) {
                this.addSlot(new Slot(inv, si, 28 + si * 18, 145));
            }
        }
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.bound) {
            if (this.boundItemMatcher != null) {
                return this.boundItemMatcher.get();
            }

            if (this.boundBlockEntity != null) {
                return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
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
            if (index < 42) {
                if (!this.moveItemStackTo(slotItemStack, 42, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, 42, false)) {
                if (index < 69) {
                    if (!this.moveItemStackTo(slotItemStack, 69, this.slots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(slotItemStack, 42, 69, false)) {
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
                    if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4 && j != 5 && j != 6 && j != 7 && j != 8 && j != 9 && j != 10 && j != 11 && j != 12 && j != 13 && j != 14 && j != 15 && j != 16 && j != 17 && j != 18 && j != 19 && j != 20 && j != 21 && j != 22 && j != 23 && j != 24 && j != 25 && j != 26 && j != 27 && j != 28 && j != 29 && j != 30 && j != 31 && j != 32 && j != 33 && j != 34 && j != 35 && j != 36 && j != 37 && j != 38 && j != 39 && j != 40 && j != 41) {
                        player.drop(this.internal.extractItem(j, this.internal.getStackInSlot(j).getCount(), false), false);
                    }
                }
            } else {
                for (int j = 0; j < this.internal.getSlots(); ++j) {
                    if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4 && j != 5 && j != 6 && j != 7 && j != 8 && j != 9 && j != 10 && j != 11 && j != 12 && j != 13 && j != 14 && j != 15 && j != 16 && j != 17 && j != 18 && j != 19 && j != 20 && j != 21 && j != 22 && j != 23 && j != 24 && j != 25 && j != 26 && j != 27 && j != 28 && j != 29 && j != 30 && j != 31 && j != 32 && j != 33 && j != 34 && j != 35 && j != 36 && j != 37 && j != 38 && j != 39 && j != 40 && j != 41) {
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
