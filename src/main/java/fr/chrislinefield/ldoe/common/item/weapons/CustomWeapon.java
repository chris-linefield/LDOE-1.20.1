package fr.chrislinefield.ldoe.common.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomWeapon extends SwordItem
{
    public CustomWeapon(Tier tier, int i, float v, Properties properties) {
        super(new Tier() {
            @Override
            public int getUses() {
                return 60;
            }

            @Override
            public float getSpeed() {
                return 4.0F;
            }

            @Override
            public float getAttackDamageBonus() {
                return 5.0F;
            }

            @Override
            public int getLevel() {
                return 1;
            }

            @Override
            public int getEnchantmentValue() {
                return 12;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 3, -3.0F, new Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, components, tooltipFlag);

        // Ajouter une description
        components.add(Component.translatable("tooltip.customsword.description").withStyle(ChatFormatting.DARK_GRAY));

        // Ajouter les dégâts de l'arme
        components.add(Component.literal("tooltip.customsword.damage " + (this.getAttackDamage())).withStyle(ChatFormatting.DARK_RED));

        // Ajouter la vitesse d'attaque
        components.add(Component.literal("tooltip.customsword.attackspeed " + this.getAttackSpeed()).withStyle(ChatFormatting.YELLOW));

        // Ajouter la durabilité
        components.add(Component.literal("tooltip.customsword.durability " + (stack.getMaxDamage() - stack.getDamageValue())).withStyle(ChatFormatting.DARK_GREEN));

        // Ajouter la rareté
        components.add(Component.literal("tooltip.customsword.rarity " + this.getRarity(stack).name()));
    }

    private int getAttackDamage() {
        return 3;
    }

    private float getAttackSpeed() {
        return -2.0F;
    }

    public Rarity getRarity(ItemStack stack) {
        return Rarity.COMMON;
    }
}
