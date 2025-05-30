package fr.chrislinefield.ldoe.common.item.weapons;

import fr.chrislinefield.ldoe.common.item.weapons.base.BaseSwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

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

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltips, TooltipFlag flag) {
        MutableComponent levelComp = Component.literal(String.valueOf(getLevelWeapon()));
        MutableComponent attackComp = Component.literal(String.valueOf(getAttackDamage()));
        MutableComponent attackSpeedComp = Component.literal(String.valueOf(getAttackSpeed()));

        tooltips.add(Component.translatable("tooltip.ldoemod.fire_sword_desc").withStyle(ChatFormatting.WHITE));
        tooltips.add(Component.translatable(""));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_level").append(levelComp).withStyle(ChatFormatting.DARK_PURPLE));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_damage").append(attackComp).withStyle(ChatFormatting.AQUA));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_attackspeed").append(attackSpeedComp).withStyle(ChatFormatting.YELLOW));
    }

    private int getLevelWeapon()
    {
        return 2;
    }

    public static int getAttackDamage()
    {
        return 7;
    }

    public static float getAttackSpeed() {
        return -1.6f;
    }
}
