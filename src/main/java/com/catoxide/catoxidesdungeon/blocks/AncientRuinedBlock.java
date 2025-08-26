package com.catoxide.catoxidesdungeon.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class AncientRuinedBlock extends FallingBlock {
    public AncientRuinedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
        super.onLand(level, pos, fallingState, hitState, fallingBlock);
        // 废墟方块落地后不做任何恢复操作
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        super.onBrokenAfterFall(level, pos, fallingBlock);

        // 当废墟方块摔碎时，检查是否有原始方块信息
        CompoundTag blockData = fallingBlock.blockData;
        if (blockData != null && blockData.contains("OriginalBlock")) {
            ResourceLocation blockId = new ResourceLocation(blockData.getString("OriginalBlock"));
            Block originalBlock = ForgeRegistries.BLOCKS.getValue(blockId);
            if (originalBlock != null) {
                Block.popResource(level, pos, new ItemStack(originalBlock));
            }
        }
    }
}