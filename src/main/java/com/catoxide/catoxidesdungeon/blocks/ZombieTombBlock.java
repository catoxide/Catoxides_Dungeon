package com.catoxide.catoxidesdungeon.blocks;

import com.catoxide.catoxidesdungeon.ModBlockEntities;
import com.catoxide.catoxidesdungeon.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ZombieTombBlock extends Block implements EntityBlock {
    public static final IntegerProperty SPAWN_COOLDOWN = IntegerProperty.create("spawn_cooldown", 0, 200);
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 1, 5); // 1-5级
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    private static final int[] MAX_ZOMBIES_BY_LEVEL = {3, 5, 7, 10, 15}; // 不同等级的最大僵尸数量
    private static final int SPAWN_RANGE = 10; // 检测僵尸的范围
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING; // 使用原版的水平朝向属性

    // 不同等级的生成冷却时间（ticks）
    private static final int[] SPAWN_COOLDOWN_BY_LEVEL = {200, 180, 160, 140, 120};

    // 不同等级的僵尸血量倍率
    private static final double[] HEALTH_MULTIPLIER_BY_LEVEL = {1.0, 1.5, 2.0, 2.5, 3.0};

    // 不同等级的僵尸攻击力倍率
    private static final double[] DAMAGE_MULTIPLIER_BY_LEVEL = {1.0, 1.2, 1.5, 1.8, 2.2};

    public ZombieTombBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SPAWN_COOLDOWN, 0)
                .setValue(FACING, Direction.NORTH)
                .setValue(LEVEL, 1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SPAWN_COOLDOWN);
        builder.add(FACING);
        builder.add(LEVEL);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ZombieNestBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : (lvl, pos, st, blockEntity) -> {
            if (blockEntity instanceof ZombieNestBlockEntity nest) {
                nest.tick();
            }
        };
    }

    // 检查特殊破坏条件
    public static boolean shouldBreak(Level level, BlockPos pos) {
        // 检查是否有岩浆试图流向这个方块
        for (Direction direction : Direction.values()) {
            BlockPos adjacentPos = pos.relative(direction);
            BlockState adjacentState = level.getBlockState(adjacentPos);

            // 检查相邻方块是否是岩浆
            if (adjacentState.getBlock() == Blocks.LAVA) {
                // 检查岩浆是否会流向这个位置
                if (canLavaFlowTo(level, adjacentPos, pos)) {
                    return true;
                }
            }
        }

        // 检查是否被铁砧砸中
        if (level.getBlockState(pos.above()).getBlock() == Blocks.ANVIL) {
            return true;
        }

        // 检查是否被废墟方块砸中
        if (level.getBlockState(pos.above()).getBlock() instanceof AncientRuinedBlock) {
            return true;
        }

        // 检查是否有下坠的废墟方块实体
        AABB area = new AABB(pos).inflate(0.5);
        List<FallingBlockEntity> fallingBlocks = level.getEntitiesOfClass(FallingBlockEntity.class, area);
        for (FallingBlockEntity fallingBlock : fallingBlocks) {
            if (fallingBlock.getBlockState().getBlock() instanceof AncientRuinedBlock) {
                return true;
            }
        }

        // 检查是否被混凝土粉末砸中
        if (level.getBlockState(pos.above()).getBlock() == Blocks.WHITE_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.ORANGE_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.MAGENTA_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.LIGHT_BLUE_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.YELLOW_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.LIME_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.PINK_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.GRAY_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.LIGHT_GRAY_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.CYAN_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.PURPLE_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.BLUE_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.BROWN_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.GREEN_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.RED_CONCRETE_POWDER ||
                level.getBlockState(pos.above()).getBlock() == Blocks.BLACK_CONCRETE_POWDER) {
            return true;
        }

        return false;
    }

    // 检查岩浆是否会流向指定位置
    private static boolean canLavaFlowTo(Level level, BlockPos lavaPos, BlockPos targetPos) {
        BlockState lavaState = level.getBlockState(lavaPos);

        // 检查是否是岩浆源
        if (lavaState.getFluidState().isSource()) {
            // 岩浆源会向所有方向流动（除了向上）
            for (Direction direction : Direction.values()) {
                if (direction != Direction.UP) {
                    BlockPos flowPos = lavaPos.relative(direction);
                    if (flowPos.equals(targetPos)) {
                        return true;
                    }
                }
            }
        } else {
            // 流动的岩浆会沿着重力方向流动
            // 检查目标位置是否在岩浆的下方或水平方向
            BlockPos belowLava = lavaPos.below();
            if (belowLava.equals(targetPos)) {
                return true;
            }

            // 检查水平方向
            for (Direction horizontalDir : Direction.Plane.HORIZONTAL) {
                BlockPos horizontalPos = lavaPos.relative(horizontalDir);
                if (horizontalPos.equals(targetPos)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 方块实体类
    public static class ZombieNestBlockEntity extends BlockEntity {
        private int spawnCooldown = 0;
        private int currentZombieCount = 0;
        private int resetTimer = 0;
        private static final int RESET_TIME = 12000; // 10分钟（12000 ticks）

        public ZombieNestBlockEntity(BlockPos pos, BlockState state) {
            super(ModBlockEntities.ZOMBIE_NEST.get(), pos, state);
        }

        @Override
        public void load(CompoundTag tag) {
            super.load(tag);
            this.currentZombieCount = tag.getInt("CurrentZombieCount");
            this.resetTimer = tag.getInt("ResetTimer");
        }

        @Override
        protected void saveAdditional(CompoundTag tag) {
            super.saveAdditional(tag);
            tag.putInt("CurrentZombieCount", this.currentZombieCount);
            tag.putInt("ResetTimer", this.resetTimer);
        }

        public void tick() {
            if (level == null || level.isClientSide) return;

            ServerLevel serverLevel = (ServerLevel) level;
            BlockPos pos = getBlockPos();
            BlockState state = getBlockState();
            int levelValue = state.getValue(LEVEL);

            // 检查特殊破坏条件
            if (ZombieTombBlock.shouldBreak(level, pos)) {
                level.destroyBlock(pos, false);
                return;
            }

            // 如果达到最大数量，启动重置计时器
            if (currentZombieCount >= MAX_ZOMBIES_BY_LEVEL[levelValue - 1]) {
                if (resetTimer < RESET_TIME) {
                    resetTimer++;
                    return;
                } else {
                    // 重置计时器完成，重置计数
                    currentZombieCount = 0;
                    resetTimer = 0;
                }
            }

            // 更新冷却时间
            if (spawnCooldown > 0) {
                spawnCooldown--;
                level.setBlock(pos, state.setValue(SPAWN_COOLDOWN, spawnCooldown), 3);
                return;
            }

            // 检测周围僵尸数量
            AABB area = new AABB(pos).inflate(SPAWN_RANGE);
            List<Zombie> zombies = level.getEntitiesOfClass(Zombie.class, area);

            // 如果僵尸数量少于最大值，尝试生成僵尸
            if (zombies.size() < MAX_ZOMBIES_BY_LEVEL[levelValue - 1]) {
                // 尝试在正上方生成僵尸
                BlockPos spawnPos = pos.above();
                if (level.isEmptyBlock(spawnPos) && level.isEmptyBlock(spawnPos.above())) {
                    Zombie zombie = EntityType.ZOMBIE.create(serverLevel);
                    if (zombie != null) {
                        zombie.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5,
                                level.random.nextFloat() * 360.0F, 0.0F);
                        zombie.finalizeSpawn(serverLevel, level.getCurrentDifficultyAt(spawnPos),
                                MobSpawnType.SPAWNER, null, null);

                        // 根据等级增强僵尸属性
                        enhanceZombie(zombie, levelValue);

                        // 检查是否达到最大数量，如果是则设置无掉落物
                        if (currentZombieCount >= MAX_ZOMBIES_BY_LEVEL[levelValue - 1] - 1) {
                            // 设置僵尸无掉落物
                            zombie.addTag("no_loot");
                        }

                        serverLevel.addFreshEntity(zombie);
                        currentZombieCount++;

                        // 设置冷却时间（根据等级）
                        spawnCooldown = SPAWN_COOLDOWN_BY_LEVEL[levelValue - 1];
                        level.setBlock(pos, state.setValue(SPAWN_COOLDOWN, spawnCooldown), 3);

                        // TODO: 在这里添加生成动画效果
                    }
                }
            }
        }

        // 根据等级增强僵尸属性
        private void enhanceZombie(Zombie zombie, int zombieLevel) {
            // 使用NBT数据增强僵尸
            CompoundTag nbt = new CompoundTag();

            // 增加血量
            double healthMultiplier = HEALTH_MULTIPLIER_BY_LEVEL[zombieLevel - 1];
            double newMaxHealth = zombie.getMaxHealth() * healthMultiplier;
            zombie.getAttribute(Attributes.MAX_HEALTH).setBaseValue(newMaxHealth);
            zombie.setHealth((float) newMaxHealth);

            // 增加攻击伤害
            double damageMultiplier = DAMAGE_MULTIPLIER_BY_LEVEL[zombieLevel - 1];
            double baseDamage = zombie.getAttributeBaseValue(Attributes.ATTACK_DAMAGE);
            zombie.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(baseDamage * damageMultiplier);

            // 存储等级信息到NBT
            nbt.putInt("ZombieLevel", zombieLevel);
            zombie.readAdditionalSaveData(nbt);

            // 高等级僵尸可能有额外能力
            if (zombieLevel >= 3) {
                // 3级以上僵尸有几率穿戴装备
                if (level.random.nextFloat() < 0.3f) {
                    // TODO: 给僵尸随机装备
                }

                if (zombieLevel >= 4) {
                    // 4级以上僵尸有几率成为僵尸村民
                    if (level.random.nextFloat() < 0.2f) {
                        // TODO: 设置为僵尸村民
                    }

                    if (zombieLevel >= 5) {
                        // 5级僵尸有几率成为特殊变种
                        if (level.random.nextFloat() < 0.1f) {
                            // TODO: 生成特殊变种僵尸（如Husk等）
                        }
                    }
                }
            }
        }

        // 获取当前僵尸数量
        public int getCurrentZombieCount() {
            return currentZombieCount;
        }

        // 获取最大僵尸数量
        public int getMaxZombies() {
            int levelValue = getBlockState().getValue(LEVEL);
            return MAX_ZOMBIES_BY_LEVEL[levelValue - 1];
        }

        // 获取重置进度（0.0到1.0）
        public float getResetProgress() {
            return (float) resetTimer / RESET_TIME;
        }
    }
}