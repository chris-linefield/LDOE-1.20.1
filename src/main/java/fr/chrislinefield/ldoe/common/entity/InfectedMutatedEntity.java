package fr.chrislinefield.ldoe.common.entity;

import fr.chrislinefield.ldoe.common.init.ModEntities;
import fr.chrislinefield.ldoe.common.init.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class InfectedMutatedEntity extends Monster implements GeoEntity
{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public static final EntityDataAccessor<Boolean> SHOOT;
    public static final EntityDataAccessor<String> ANIMATION;
    public static final EntityDataAccessor<String> TEXTURE;

    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationProcedure;
    String prevAnim;

    public InfectedMutatedEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntities.INFECTED_MUTATED.get(), world);
    }

    public InfectedMutatedEntity(EntityType<? extends InfectedMutatedEntity> entityType, Level level) {
        super(entityType, level);
        this.animationProcedure = "empty";
        this.prevAnim = "empty";
        this.xpReward = 5;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "infectedmutatedr");
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, false, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
        this.targetSelector.addGoal(2, new BreakDoorGoal(this, difficulty -> true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Villager.class, false, false));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Skeleton.class, false, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Creeper.class, false, false));

        this.goalSelector.addGoal(9, new MeleeAttackGoal(this, 1.2D, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(10, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(11, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(12, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(13, new FloatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ModSounds.INFECTED_MUTATED_IDLE.get();
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ModSounds.INFECTED_MUTATED_HURT.get();
    }

    @Override
    public SoundEvent getDeathSound() {
        return ModSounds.INFECTED_MUTATED_DEATH.get();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(1.1F);
    }

    private <E extends GeoEntity> PlayState movementPredicate(AnimationState<E> event) {
        if (this.animationProcedure.equals("empty")) {
            if (!event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F) {
                return this.isDeadOrDying() ? event.setAndContinue(RawAnimation.begin().thenPlay("animation.infectedmutatedr.death")) : event.setAndContinue(RawAnimation.begin().thenLoop("animation.infectedmutatedr.idle"));
            } else {
                return event.setAndContinue(RawAnimation.begin().thenLoop("animation.infectedmutatedr.walk"));
            }
        } else {
            return PlayState.STOP;
        }
    }

    private <E extends GeoEntity> PlayState attackingPredicate(AnimationState<E> event) {
        double dx = this.getX() - this.xo;
        double dz = this.getZ() - this.zo;
        float velocity = (float) Math.sqrt(dx * dx + dz * dz);
        if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
        }

        if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
            this.swinging = false;
        }

        if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().forceAnimationReset();
            return event.setAndContinue(RawAnimation.begin().thenPlay("animation.infectedmutatedr.attack"));
        } else {
            return PlayState.CONTINUE;
        }
    }

    private <E extends GeoEntity> PlayState procedurePredicate(AnimationState<E> event) {
        if ((this.animationProcedure.equals("empty") || event.getController().getAnimationState() != AnimationController.State.STOPPED) && (this.animationProcedure.equals(this.prevAnim) || this.animationProcedure.equals("empty"))) {
            if (this.animationProcedure.equals("empty")) {
                this.prevAnim = "empty";
                return PlayState.STOP;
            }
        } else {
            if (!this.animationProcedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }

            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationProcedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationProcedure = "empty";
                event.getController().forceAnimationReset();
            }
        }

        this.prevAnim = this.animationProcedure;
        return PlayState.CONTINUE;
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropExperience();
        }
    }

    public String getSyncedAnimation() {
        return this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        controllers.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
        controllers.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.21D)
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 8.0D)
                .add(Attributes.ARMOR, 24.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 2.0D)
                .add(Attributes.FOLLOW_RANGE, 100.0D);
    }

    public static void init() {
        SpawnPlacements.register(
                ModEntities.INFECTED_MUTATED.get(),
                SpawnPlacements.Type.NO_RESTRICTIONS,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Mob::checkMobSpawnRules);
    }

    static {
        SHOOT = SynchedEntityData.defineId(InfectedMutatedEntity.class, EntityDataSerializers.BOOLEAN);
        ANIMATION = SynchedEntityData.defineId(InfectedMutatedEntity.class, EntityDataSerializers.STRING);
        TEXTURE = SynchedEntityData.defineId(InfectedMutatedEntity.class, EntityDataSerializers.STRING);
    }
}
