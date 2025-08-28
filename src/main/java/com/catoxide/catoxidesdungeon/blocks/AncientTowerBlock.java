package com.catoxide.catoxidesdungeon.blocks;

import com.catoxide.catoxidesdungeon.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class AncientTowerBlock extends Block {
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 0, 3);

    // 完整方块的碰撞箱
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public AncientTowerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return getDistance(level, pos) <= 3;
    }

    private int getDistance(LevelReader level, BlockPos pos) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        mutablePos.set(pos);

        // 检查下方是否有支撑
        mutablePos.move(Direction.DOWN);
        BlockState belowState = level.getBlockState(mutablePos);

        // 如果下方是废墟方块，不视为有效支撑
        if (belowState.getBlock() instanceof AncientRuinedBlock) {
            return 4; // 返回最大值，表示没有有效支撑
        }

        // 如果下方是其他塔方块，直接继承其距离（纵向无限支撑）
        if (belowState.getBlock() instanceof AncientTowerBlock) {
            return belowState.getValue(DISTANCE); // 直接继承，不+1
        }

        // 如果是其他坚实方块，距离为0
        if (belowState.isFaceSturdy(level, mutablePos, Direction.UP)) {
            return 0;
        }

        // 如果不是直接支撑，检查周围是否有其他远古塔楼方块
        int minDistance = 4; // 初始设置为最大值+1

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            mutablePos.set(pos).move(direction);
            BlockState adjacentState = level.getBlockState(mutablePos);
            if (adjacentState.getBlock() instanceof AncientTowerBlock) {
                int adjacentDistance = adjacentState.getValue(DISTANCE);
                if (adjacentDistance < minDistance) {
                    minDistance = adjacentDistance;
                }
            }
        }

        return minDistance < 4 ? minDistance + 1 : 4;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int distance = getDistance(level, pos);
        if (distance > 3) {
            // 距离超过3，转换为废墟方块
            convertToRuinedBlock(level, pos, state);
        } else if (state.getValue(DISTANCE) != distance) {
            // 更新距离值
            level.setBlock(pos, state.setValue(DISTANCE, Integer.valueOf(distance)), 3);
        }
    }

    private void convertToRuinedBlock(ServerLevel level, BlockPos pos, BlockState state) {
        // 使用转换表获取对应的废墟方块
        Block ruinedBlock = BlockConversionTable.getRuinedBlock(state.getBlock());
        BlockState ruinedState = ruinedBlock.defaultBlockState();

        // 替换方块
        level.setBlock(pos, ruinedState, 3);

        // 创建下坠实体
        if (level.isEmptyBlock(pos.below())) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(level, pos, ruinedState);
            // 设置伤害值
            fallingBlockEntity.setHurtsEntities(2.0F, 40);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        // 安排方块更新以重新计算距离
        if (!level.isClientSide()) {
            level.scheduleTick(pos, this, 1);
        }

        return state;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        int distance = getDistance(level, pos);

        if (distance > 3) {
            return null; // 不能放置，距离支撑点太远
        }

        return this.defaultBlockState().setValue(DISTANCE, Integer.valueOf(distance));
    }

    // 重写方法，使其不能攀爬
    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, net.minecraft.world.entity.LivingEntity entity) {
        return false;
    }
}