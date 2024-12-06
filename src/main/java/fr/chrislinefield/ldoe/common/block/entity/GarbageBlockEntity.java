package fr.chrislinefield.ldoe.common.block.entity;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.block.GarbageBlock;
import fr.chrislinefield.ldoe.common.init.ModBlockEntities;
import fr.chrislinefield.ldoe.config.ServerConfig;
import fr.chrislinefield.ldoe.util.LootUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class GarbageBlockEntity extends BlockEntity
{
    private long lootTime = -1;

    public GarbageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GARBAGE_BE.get(), pos, state);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void load(@NotNull CompoundTag compound) {
        super.load(compound);
        lootTime = compound.getLong("lootTime");
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.putLong("lootTime", lootTime);
    }

    public void dropLoot(ServerLevel level, BlockPos pos, ServerPlayer player) {
        BlockState state = level.getBlockState(pos);
        if (state.getValue(GarbageBlock.VISIBLE)) {
            level.sendParticles(ParticleTypes.POOF, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, 6, 0.25F, 0.25F, 0.25F, 0F);
            level.setBlock(pos, state.setValue(GarbageBlock.VISIBLE, false), 3);
            for (ItemStack stack : LootUtils.generateLoot(new ResourceLocation(LDOEMod.MOD_ID, "garbage"), player)) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack));
            }
            lootTime = level.getGameTime();
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, GarbageBlockEntity ilbEntity) {
        if (!state.getValue(GarbageBlock.VISIBLE) && level.getGameTime() >= ilbEntity.lootTime + ServerConfig.loot_renew_ticks.get()) {
            ilbEntity.lootTime = -1;
            level.setBlock(pos, state.setValue(GarbageBlock.VISIBLE, true), 3);
        }
    }
}
