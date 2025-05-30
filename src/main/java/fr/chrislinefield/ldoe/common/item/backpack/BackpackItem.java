package fr.chrislinefield.ldoe.common.item.backpack;

import fr.chrislinefield.ldoe.capability.BackpackInventoryCapability;
import fr.chrislinefield.ldoe.worldgen.inventory.BackpackMenu;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import io.netty.buffer.Unpooled;
import javax.annotation.Nullable;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BackpackItem extends Item implements ICurioItem
{
    public BackpackItem() {
        super((new Properties()).stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> result = super.use(world, entity, hand);
        ItemStack itemStack = result.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) entity;
            NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.literal("Backpack");
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                    packetBuffer.writeBlockPos(entity.blockPosition());
                    packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                    return new BackpackMenu(id, inventory, packetBuffer);
                }
            }, (buf) -> {
                buf.writeBlockPos(entity.blockPosition());
                buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
            });
        }

        //BACKPACKCuandoSeHaceClicConElBotonDerechoProcedure.execute(world, x, y, z);
        return result;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new BackpackInventoryCapability();
    }

    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag nbt = super.getShareTag(stack);
        if (nbt != null) {
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent((capability) -> {
                nbt.put("Inventory", ((ItemStackHandler) capability).serializeNBT());
            });
        }
        return nbt;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent((capability) -> {
                ((ItemStackHandler) capability).deserializeNBT((CompoundTag) nbt.get("Inventory"));
            });
        }
    }
}
