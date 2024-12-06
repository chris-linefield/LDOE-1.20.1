package fr.chrislinefield.ldoe.common.block;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.block.entity.MiningBlockEntity;
import fr.chrislinefield.ldoe.common.init.ModBlocks;
import fr.chrislinefield.ldoe.worldgen.dimension.MiningDimensionTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.jetbrains.annotations.NotNull;

public class MiningBlock extends Block implements EntityBlock {

    public MiningBlock(){
        super(Properties.of()
                .sound(SoundType.STONE)
                .noLootTable()
        );
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player instanceof ServerPlayer) {
            teleportPlayer((ServerPlayer) player, pos);
        }
        return InteractionResult.SUCCESS;
    }

    public boolean teleportPlayer(ServerPlayer player, BlockPos pos) {
        if (player.getVehicle() != null || player.isVehicle()) {
            return false;
        }

        if (player.level().dimension().equals(LDOEMod.MINING_DIMENSION)) {
            ServerLevel teleportWorld = player.server.getLevel(Level.OVERWORLD);
            if (teleportWorld == null) {
                LDOEMod.LOGGER.error("Could not find the Overworld dimension.");
                return false;
            }
            player.changeDimension(teleportWorld, new MiningDimensionTeleporter(pos));
        } else if (player.level().dimension().equals(Level.OVERWORLD)) {
            ServerLevel teleportWorld = player.server.getLevel(LDOEMod.MINING_DIMENSION);
            if (teleportWorld == null) {
                LDOEMod.LOGGER.error("Could not find the mining dimension.");
                return false;
            }
            player.changeDimension(teleportWorld, new MiningDimensionTeleporter(pos));
        } else {
            player.displayClientMessage(Component.translatable("message.wrong_dimension"), true);
        }

        //Command TP : /execute in the_end run tp <player> <location>
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState state, Level level, @NotNull BlockPos pos, RandomSource random) {
        random.nextFloat();
        BlockState te = level.getBlockState(pos);
        if (te.is(ModBlocks.MINING_PORTAL.get())){
            level.addParticle(ParticleTypes.PORTAL, pos.getX() +  (random.nextDouble() - 0.5) * 1.5, pos.getY() + 2, pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 1.5, 0, 0, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.getX() + (random.nextDouble() - 0.5) * 1.5, pos.getY() + 2, pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 1.5, 0, 0, 0);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MiningBlockEntity(pos, state);
    }
}
