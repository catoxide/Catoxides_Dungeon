package com.catoxide.catoxidesdungeon.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AncientRuinedBlock extends FallingBlock {
    // 伤害参数 - 可以根据需要在注册不同废墟方块时调整这些值
    private final float fallDamagePerDistance;
    private final int fallDamageMax;

    public AncientRuinedBlock(Properties properties, float fallDamagePerDistance, int fallDamageMax) {
        super(properties);
        this.fallDamagePerDistance = fallDamagePerDistance;
        this.fallDamageMax = fallDamageMax;
    }

    // 简化构造函数，使用默认伤害值
    public AncientRuinedBlock(Properties properties) {
        this(properties, 2.0F, 40); // 默认伤害值
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide && FallingBlock.isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight()) {
            // 创建普通的下落方块实体
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(level, pos, state);

            // 设置伤害参数
            fallingBlockEntity.setHurtsEntities(this.fallDamagePerDistance, this.fallDamageMax);

            // 移除原方块
            level.removeBlock(pos, false);
        }
    }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
        super.onLand(level, pos, fallingState, hitState, fallingBlock);
        // 废墟方块落地后不做任何恢复操作
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        super.onBrokenAfterFall(level, pos, fallingBlock);
        // 当废墟方块摔碎时，不需要掉落任何物品
    }
}