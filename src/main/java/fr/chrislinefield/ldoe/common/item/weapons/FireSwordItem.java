package fr.chrislinefield.ldoe.common.item.weapons;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import javax.annotation.ParametersAreNonnullByDefault;

public class FireSwordItem extends BaseSwordItem
{
    public FireSwordItem(Tier tier, int damage, float speed, SoundEvent hitSound, Properties properties) {
        super(tier, damage, speed, hitSound, properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity user) {
        enemy.setSecondsOnFire(4);

        return super.hurtEnemy(stack, enemy, user);
    }
}
