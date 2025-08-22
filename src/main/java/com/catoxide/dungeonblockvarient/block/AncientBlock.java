package com.catoxide.dungeonblockvarient.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.List;

public class AncientBlock extends Block implements EntityBlock {
    public static final float HARD_MULT = 4f;
    public static final float RESIST_MULT = 1f;
    private static final Logger LOGGER = LoggerFactory.getLogger(AncientBlock.class);

    public AncientBlock(Properties p) {
        super(p);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientBlockEntity) {
            Block wrapped = ((AncientBlockEntity) be).getWrapped();
            if (wrapped != null) {
                return wrapped.getShape(state, level, pos, ctx);
            }
        }
        return super.getShape(state, level, pos, ctx);
    }

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientBlockEntity) {
            Block wrapped = ((AncientBlockEntity) be).getWrapped();
            if (wrapped != null) {
                return wrapped.getSoundType(state, level, pos, entity);
            }
        }
        return super.getSoundType(state, level, pos, entity);
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientBlockEntity) {
            Block wrapped = ((AncientBlockEntity) be).getWrapped();
            if (wrapped != null) {
                float original = wrapped.getDestroyProgress(wrapped.defaultBlockState(), player, level, pos);
                return original / HARD_MULT;
            }
        }
        return super.getDestroyProgress(state, player, level, pos);
    }

    @Override
    public float getExplosionResistance(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientBlockEntity) {
            Block wrapped = ((AncientBlockEntity) be).getWrapped();
            if (wrapped != null) {
                return wrapped.getExplosionResistance(state, level, pos, explosion) * RESIST_MULT;
            }
        }
        return super.getExplosionResistance(state, level, pos, explosion);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        return List.of(); // 不掉落
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AncientBlockEntity(pos, state);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        // 强制方块更新外观
        level.sendBlockUpdated(pos, state, state, 2);
    }

    // 添加客户端外观获取方法
// 在 AncientBlock.java 中添加或更新以下方法
    @Override
    public BlockState getAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, @Nullable BlockState queryState, @Nullable BlockPos queryPos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientBlockEntity) {
            Block wrapped = ((AncientBlockEntity) be).getWrapped();
            if (wrapped != null) {
                return wrapped.defaultBlockState();
            }
        }
        return super.getAppearance(state, level, pos, side, queryState, queryPos);
    }
}