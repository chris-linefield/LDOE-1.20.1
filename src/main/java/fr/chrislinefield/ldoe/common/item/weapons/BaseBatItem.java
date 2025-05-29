package fr.chrislinefield.ldoe.common.item.weapons;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

public class BaseBatItem extends TieredItem
{
    public static final UUID BASE_DAMAGE_UUID = BASE_ATTACK_DAMAGE_UUID;
    public static final UUID BASE_SPEED_UUID = BASE_ATTACK_SPEED_UUID;
    public static final UUID BASE_KNOCKBACK_UUID = UUID.fromString("4b472947-a9e4-4083-8e46-339d66d2a7ab");

    private final int damage;
    private final float speed;
    private final float knockback;

    private final SoundEvent hitSound;

    public BaseBatItem(Tier tier, int damage, float speed, float knockback, SoundEvent hitSound, Properties properties) {
        super(tier, properties);

        this.hitSound = hitSound;

        this.damage = damage;
        this.speed = speed;
        this.knockback = knockback;
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity user) {
        Level level = user.level();

        level.playSeededSound(null, user.getX(), user.getY(), user.getZ(),
                this.getHitSound(), SoundSource.PLAYERS, 1,
                level.getRandom().nextInt(10, 20) / 10f, 0);

        enemy.addDeltaMovement(new Vec3(0, this.getKnockback() / 5, 0));

        stack.hurtAndBreak(1, user, (user1) -> user1.broadcastBreakEvent(EquipmentSlot.MAINHAND));

        return true;
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.MAINHAND;
    }

    public SoundEvent getHitSound() {
        return hitSound;
    }

    public int getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }

    public float getKnockback() {
        return knockback;
    }
}
