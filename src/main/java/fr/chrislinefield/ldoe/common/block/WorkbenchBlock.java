package fr.chrislinefield.ldoe.common.block;

import fr.chrislinefield.ldoe.common.block.entity.WorkbenchBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.level.block.*;

import static net.minecraft.world.level.block.DirectionalBlock.FACING;

public class WorkbenchBlock extends BaseEntityBlock
{
    protected static final VoxelShape SHAPE_UP = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    protected static final VoxelShape SHAPE_DOWN = Block.box(8.0D, 15.0D, 0.0D, -8.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPE_NORTH = Block.box(24.0D, 0.0D, 0.0D, -7.0D, 21.0D, 14.0D);
    protected static final VoxelShape SHAPE_SOUTH = Block.box(24.0D, 1.0D, 1.0D, -8.0D, 21.0D, 16.0D);
    protected static final VoxelShape SHAPE_WEST = Block.box(15.0D, 0.0D, -7.0D, 0.0D, 21.0D, 23.0D);
    protected static final VoxelShape SHAPE_EAST = Block.box(16.0D, -1.0D, -8.0D, -1.0D, 21.0D, 23.0D);

    public WorkbenchBlock() {
        super(Properties.of()
                .strength(2F)
                .sound(SoundType.WOOD)
                .mapColor(MapColor.WOOD)
                .noOcclusion()
        );
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)){
            default:
            case DOWN:
                return SHAPE_DOWN;
            case UP:
                return SHAPE_UP;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            case NORTH:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new WorkbenchBlockEntity(pPos, pState);
    }
}
