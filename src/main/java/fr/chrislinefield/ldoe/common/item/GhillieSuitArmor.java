package fr.chrislinefield.ldoe.common.item;

import fr.chrislinefield.ldoe.client.model.GhillieSuitModel;
import fr.chrislinefield.ldoe.common.init.ModArmorItem;
import fr.chrislinefield.ldoe.common.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class GhillieSuitArmor extends ModArmorItem {
    public GhillieSuitArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(
                new IClientItemExtensions() {
                    private GhillieSuitModel<LivingEntity> model = null;
                    @Override
                    public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                        if(model == null){
                            model = new GhillieSuitModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(GhillieSuitModel.LAYER_LOCATION));
                        }
                        model.bootL.visible = livingEntity.getItemBySlot(EquipmentSlot.FEET).is(ModItems.GHILLIE_BOOTS.get());
                        model.bootR.visible = livingEntity.getItemBySlot(EquipmentSlot.FEET).is(ModItems.GHILLIE_BOOTS.get());
                        return model;
                    }
                }
        );
    }
}
