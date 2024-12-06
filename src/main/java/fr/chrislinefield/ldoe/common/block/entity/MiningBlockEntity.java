package fr.chrislinefield.ldoe.common.block.entity;

import fr.chrislinefield.ldoe.common.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MiningBlockEntity extends BlockEntity
{

    public MiningBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MININGBLOCK_BE.get(), pos, state);
    }
}
