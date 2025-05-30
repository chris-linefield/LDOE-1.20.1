package fr.chrislinefield.ldoe.common.item.weapons;

import fr.chrislinefield.ldoe.common.item.weapons.base.BaseBatItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class SteelBatItem extends BaseBatItem
{
    public SteelBatItem(Tier tier, int damage, float speed, float knockback, SoundEvent hitSound, Properties properties) {
        super(tier, damage, speed, knockback, hitSound, properties);
    }

    public static short getCharge(ItemStack stack) {
        if (stack.getTag() == null) stack.setTag(new CompoundTag());

        return stack.getTag().getShort("steel_bat.charge");
    }

    public static void setCharge(ItemStack stack, short charge) {
        if (stack.getTag() == null) stack.setTag(new CompoundTag());

        stack.getTag().putShort("steel_bat.charge", charge);
    }

    @ParametersAreNonnullByDefault
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity user) {
        Level level = user.level();

        if (level.isThundering()) setCharge(stack, (short) (getCharge(stack) + 1));
        else {
            if (getCharge(stack) < 1) setCharge(stack, (short) 0);
            else setCharge(stack, (short) (getCharge(stack) - 1));
        }

        if (getCharge(stack) > 3 && level.isThundering()) {
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);

            bolt.setPos(new Vec3(enemy.getX(), enemy.getY(), enemy.getZ()));

            level.addFreshEntity(bolt);

            setCharge(stack, (short) 0);
        }

        return super.hurtEnemy(stack, enemy, user);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltips, TooltipFlag flag) {
        MutableComponent chargeComp = Component.literal(String.valueOf(getCharge(stack)));
        MutableComponent levelComp = Component.literal(String.valueOf(getLevelWeapon()));
        MutableComponent attackComp = Component.literal(String.valueOf(getAttackDamage()));
        MutableComponent attackSpeedComp = Component.literal(String.valueOf(getAttackSpeed()));

        tooltips.add(Component.translatable("tooltip.ldoemod.steel_bat_desc").withStyle(ChatFormatting.WHITE));
        tooltips.add(Component.translatable(""));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_level").append(levelComp).withStyle(ChatFormatting.DARK_PURPLE));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_damage").append(attackComp).withStyle(ChatFormatting.AQUA));
        tooltips.add(Component.translatable("tooltip.ldoemod.bat_attackspeed").append(attackSpeedComp).withStyle(ChatFormatting.YELLOW));

        switch (getCharge(stack)) {
            case 0 -> chargeComp.withStyle(ChatFormatting.GREEN);
            case 1 -> chargeComp.withStyle(ChatFormatting.DARK_GREEN);
            case 2 -> chargeComp.withStyle(ChatFormatting.YELLOW);
            case 3 -> chargeComp.withStyle(ChatFormatting.RED);

            default -> chargeComp.withStyle(ChatFormatting.GOLD);
        }

        tooltips.add(Component.translatable("tooltip.ldoemod.steel_bat_charge").append(chargeComp));

        super.appendHoverText(stack, level, tooltips, flag);
    }

    private int getLevelWeapon()
    {
        return 2;
    }

    public static int getAttackDamage()
    {
        return 8;
    }

    public static float getAttackSpeed() {
        return -2.0f;
    }
}
