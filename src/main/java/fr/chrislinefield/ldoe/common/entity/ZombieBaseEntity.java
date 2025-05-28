package fr.chrislinefield.ldoe.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ZombieBaseEntity extends Monster
{
    public int lightLevelPrev = -1;
    AttributeInstance speed;
    AttributeInstance range;
    AttributeInstance armor;
    AttributeInstance attack;

    protected Vec3 corpseRotation = Vec3.ZERO;
    protected Vec3 corpseTranslation = Vec3.ZERO;

    public ZombieBaseEntity(EntityType<? extends ZombieBaseEntity> type, Level world) {
        super(type, world);
        this.xpReward = 10;
    }

    @Override
    public void tick() {
        super.tick();

        if (speed == null) {
            speed = this.getAttribute(Attributes.MOVEMENT_SPEED);
        }

        if (range == null) {
            range = this.getAttribute(Attributes.FOLLOW_RANGE);
        }

        if (armor == null) {
            armor = this.getAttribute(Attributes.ARMOR);
        }

        if (attack == null) {
            attack = this.getAttribute(Attributes.ATTACK_DAMAGE);
        }
    }

    public float getDigSpeed(BlockState p_36282_, @Nullable BlockPos pos) {
        float f = this.getMainHandItem().getDestroySpeed(p_36282_);
        if (f > 1.0F) {
            int i = EnchantmentHelper.getBlockEfficiency(this);
            ItemStack itemstack = this.getMainHandItem();
            if (i > 0 && !itemstack.isEmpty()) {
                f += (float)(i * i + 1);
            }
        }

        if (MobEffectUtil.hasDigSpeed(this)) {
            f *= 1.0F + (float)(MobEffectUtil.getDigSpeedAmplification(this) + 1) * 0.2F;
        }

        if (this.hasEffect(MobEffects.DIG_SLOWDOWN)) {
            float f1 = switch (this.getEffect(MobEffects.DIG_SLOWDOWN).getAmplifier()) {
                case 0 -> 0.3F;
                case 1 -> 0.09F;
                case 2 -> 0.0027F;
                case 3 -> 8.1E-4F;
                default -> 8.1E-4F;
            };

            f *= f1;
        }

        if (this.isEyeInFluid(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(this)) {
            f /= 5.0F;
        }

        if (!this.onGround()) {
            f /= 5.0F;
        }

        return f;
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("LightLevelPrev", lightLevelPrev);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.lightLevelPrev = compoundTag.getInt("LightLevelPrev");
    }

    public Vec3 corpseRotation() {
        return corpseRotation;
    }

    public Vec3 corpseTranslation() {
        return corpseTranslation;
    }

    public boolean customCorpseTransform() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ZOMBIE_AMBIENT;
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource p_184601_1_) {
        return SoundEvents.ZOMBIE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(@NotNull BlockPos p_180429_1_, @NotNull BlockState p_180429_2_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void die(@NotNull DamageSource damageSource) {
        super.die(damageSource);
    }

    @Override
    public void startSeenByPlayer(@NotNull ServerPlayer player) {
        super.startSeenByPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(@NotNull ServerPlayer player) {
        super.stopSeenByPlayer(player);
    }
}
