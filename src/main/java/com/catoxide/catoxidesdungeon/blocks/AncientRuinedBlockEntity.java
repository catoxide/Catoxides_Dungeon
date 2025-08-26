package com.catoxide.catoxidesdungeon.blocks;

import com.catoxide.catoxidesdungeon.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class AncientRuinedBlockEntity extends BlockEntity {
    private Block originalBlock;

    public AncientRuinedBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ANCIENT_RUINED_BLOCK.get(), pos, state);
    }

    public void setOriginalBlock(Block originalBlock) {
        this.originalBlock = originalBlock;
        setChanged();
    }

    public Block getOriginalBlock() {
        return originalBlock;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (originalBlock != null) {
            tag.putString("OriginalBlock", ForgeRegistries.BLOCKS.getKey(originalBlock).toString());
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("OriginalBlock")) {
            ResourceLocation blockId = new ResourceLocation(tag.getString("OriginalBlock"));
            originalBlock = ForgeRegistries.BLOCKS.getValue(blockId);
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }
}