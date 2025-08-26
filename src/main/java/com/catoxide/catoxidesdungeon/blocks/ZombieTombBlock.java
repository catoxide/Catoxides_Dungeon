package com.catoxide.catoxidesdungeon.blocks;

import com.catoxide.catoxidesdungeon.ModBlockEntities;
import com.catoxide.catoxidesdungeon.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class ZombieTombBlock extends Block implements EntityBlock {
    public static final IntegerProperty SPAWN_COOLDOWN = IntegerProperty.create("spawn_cooldown", 0, 200);
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    private static final int MAX_ZOMBIES = 5; // 周围最大僵尸数量
    private static final int SPAWN_RANGE = 10; // 检测僵尸的范围
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING; // 使用原版的水平朝向属性

    public ZombieTombBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SPAWN_COOLDOWN, 0).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SPAWN_COOLDOWN);
        builder.add(FACING); // 注册朝向属性
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
        // 检查是否被岩浆覆盖
        if (level.getBlockState(pos.above()).getBlock() == Blocks.LAVA) {
            return true;
        }

        // 检查是否被铁砧砸中
        if (level.getBlockState(pos.above()).getBlock() == Blocks.ANVIL) {
            return true;
        }

        // 检查是否被废墟方块砸中
        if (level.getBlockState(pos.above()).getBlock() == ModBlocks.ANCIENT_RUINED_BLOCK.get()) {
            return true;
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

    // 方块实体类
    public static class ZombieNestBlockEntity extends BlockEntity {
        private int spawnCooldown = 0;

        public ZombieNestBlockEntity(BlockPos pos, BlockState state) {
            super(ModBlockEntities.ZOMBIE_NEST.get(), pos, state);
        }

        public void tick() {
            if (level == null || level.isClientSide) return;

            ServerLevel serverLevel = (ServerLevel) level;
            BlockPos pos = getBlockPos();

            // 检查特殊破坏条件
            if (ZombieTombBlock.shouldBreak(level, pos)) {
                level.destroyBlock(pos, false);
                return;
            }

            // 更新冷却时间
            if (spawnCooldown > 0) {
                spawnCooldown--;
                level.setBlock(pos, level.getBlockState(pos).setValue(SPAWN_COOLDOWN, spawnCooldown), 3);
                return;
            }

            // 检测周围僵尸数量
            AABB area = new AABB(pos).inflate(SPAWN_RANGE);
            List<Zombie> zombies = level.getEntitiesOfClass(Zombie.class, area);

            // 如果僵尸数量少于最大值，尝试生成僵尸
            if (zombies.size() < MAX_ZOMBIES) {
                // 尝试在正上方生成僵尸
                BlockPos spawnPos = pos.above();
                if (level.isEmptyBlock(spawnPos) && level.isEmptyBlock(spawnPos.above())) {
                    Zombie zombie = EntityType.ZOMBIE.create(serverLevel);
                    if (zombie != null) {
                        zombie.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5,
                                level.random.nextFloat() * 360.0F, 0.0F);
                        zombie.finalizeSpawn(serverLevel, level.getCurrentDifficultyAt(spawnPos),
                                MobSpawnType.SPAWNER, null, null);
                        serverLevel.addFreshEntity(zombie);

                        // 设置冷却时间
                        spawnCooldown = 200; // 10秒冷却（20 ticks/秒）
                        level.setBlock(pos, level.getBlockState(pos).setValue(SPAWN_COOLDOWN, spawnCooldown), 3);

                        // TODO: 在这里添加生成动画效果
                    }
                }
            }
        }
    }
}