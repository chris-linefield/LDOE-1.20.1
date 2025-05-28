package fr.chrislinefield.ldoe.common.block;

import fr.chrislinefield.ldoe.common.block.entity.ArrowStorageBlockEntity;
import fr.chrislinefield.ldoe.common.init.ModBlockEntities;
import fr.chrislinefield.ldoe.util.LootUtils;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ArrowStorageBlock extends BaseEntityBlock
{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty VISIBLE = BooleanProperty.create("visible");

    private final Map<Direction, VoxelShape> shapeCache;

    public ArrowStorageBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).strength(50F));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(VISIBLE, true));
        this.shapeCache = Util.make(new HashMap<>(), map -> {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                map.put(direction, LootUtils.rotateShape(Direction.NORTH, direction, Shapes.box(0.28125, 0, 0.25, 0.71875, 0.25, 0.75)));
            }
        });
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return state.getValue(VISIBLE) ? RenderShape.MODEL : RenderShape.INVISIBLE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter plevel, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityContext) {
            Entity entity = entityContext.getEntity();
            if (entity instanceof LivingEntity livingEntity) {
                ItemStack heldItem = livingEntity.getMainHandItem();
                if (heldItem.getItem() instanceof BlockItem) {
                    return Shapes.block();
                }
            }
        }
        return state.getValue(VISIBLE) ? shapeCache.get(state.getValue(FACING)) : Shapes.empty();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, VISIBLE);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ArrowStorageBlockEntity libbe)
                libbe.dropLoot((ServerLevel) level, pos, (ServerPlayer) player);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ArrowStorageBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, @NotNull BlockEntityType<T> type) {
        return level.isClientSide ? null : (BlockEntityTicker<T>) BaseEntityBlock.createTickerHelper((BlockEntityType<ArrowStorageBlockEntity>) type, ModBlockEntities.ARROWSTORAGE_BE.get(), ArrowStorageBlockEntity::tick);
    }

}
