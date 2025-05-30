package fr.chrislinefield.ldoe.common.item.weapons;

import fr.chrislinefield.ldoe.common.item.weapons.base.BaseBatItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class WoodenBatItem extends BaseBatItem
{
    public WoodenBatItem(Tier tier, int damage, float speed, float knockback, SoundEvent hitSound, Properties properties) {
        super(tier, damage, speed, knockback, hitSound, properties);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltips, TooltipFlag flag) {
        MutableComponent levelComp = Component.literal(String.valueOf(getLevelWeapon()));
        MutableComponent attackComp = Component.literal(String.valueOf(getAttackDamage()));
        MutableComponent attackSpeedComp = Component.literal(String.valueOf(getAttackSpeed()));

        tooltips.add(Component.translatable("tooltip.ldoemod.wooden_bat_desc").withStyle(ChatFormatting.WHITE));
        tooltips.add(Component.translatable(""));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_level").append(levelComp).withStyle(ChatFormatting.DARK_PURPLE));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_damage").append(attackComp).withStyle(ChatFormatting.AQUA));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_attackspeed").append(attackSpeedComp).withStyle(ChatFormatting.YELLOW));
    }

    private int getLevelWeapon()
    {
        return 1;
    }

    public static int getAttackDamage()
    {
        return 4;
    }

    public static float getAttackSpeed() {
        return -2.0f;
    }
}
