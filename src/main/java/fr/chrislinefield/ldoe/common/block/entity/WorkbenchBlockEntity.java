package fr.chrislinefield.ldoe.common.block.entity;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WorkbenchBlockEntity extends BlockEntity
{
    private int counter;

    public WorkbenchBlockEntity(BlockPos pPos, BlockState pBlockState)
    {
        super(ModBlockEntities.WORKBENCH_BE.get(), pPos, pBlockState);
    }

    @Override
    public void load(CompoundTag nbt)
    {
        super.load(nbt);

        CompoundTag ldoemodData = nbt.getCompound(LDOEMod.MOD_ID);
        this.counter = ldoemodData.getInt("Counter");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt)
    {
        super.saveAdditional(nbt);

        var ldoemodData = new CompoundTag();
        ldoemodData.putInt("Counter", this.counter);
        nbt.put(LDOEMod.MOD_ID, ldoemodData);
    }

    public int incrementCounter()
    {
        this.counter++;
        setChanged();
        return this.counter;
    }

    public int getCounter()
    {
        return this.counter;
    }
}