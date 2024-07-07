package fr.chrislinefield.ldoe.common.block;

import fr.chrislinefield.ldoe.LDOEMod;
import fr.chrislinefield.ldoe.common.init.ModBlocks;
import fr.chrislinefield.ldoe.worldgen.portal.MiningWorldTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.jetbrains.annotations.NotNull;

public class DungeonPortalBlock extends Block {

    public DungeonPortalBlock(){
        super(Properties.of()
                .sound(SoundType.STONE)
                .noLootTable()
        );
    }

    private void teleportPlayer(ServerPlayer player, BlockPos pos){
        if(player.getVehicle() != null || player.isVehicle()){
            return;
        }
        MinecraftServer server = player.getServer();
        if (server == null) return;

        if(player.level().dimension().equals(LDOEMod.DUNGEON_WORLD)){
            player.changeDimension(server.overworld(),new MiningWorldTeleporter(pos));
        }else{
            ServerLevel miningWorld = player.server.getLevel(LDOEMod.DUNGEON_WORLD);
            if(miningWorld==null) return;
            player.changeDimension(miningWorld,new MiningWorldTeleporter(pos));
        }
    }
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if(player instanceof ServerPlayer && !player.isCrouching()){
            teleportPlayer((ServerPlayer)player,pos);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState state, Level level, @NotNull BlockPos pos, RandomSource random) {
        random.nextFloat();
        BlockState te = level.getBlockState(pos);
        if (te.is(ModBlocks.DUNGEON_PORTAL.get())){
            level.addParticle(ParticleTypes.PORTAL, pos.getX() +  (random.nextDouble() - 0.5) * 1.5, pos.getY() + 2, pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 1.5, 0, 0, 0);
            level.addParticle(ParticleTypes.ENCHANT, pos.getX() + (random.nextDouble() - 0.5) * 1.5, pos.getY() + 2, pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 1.5, 0, 0, 0);
        }
    }
}
