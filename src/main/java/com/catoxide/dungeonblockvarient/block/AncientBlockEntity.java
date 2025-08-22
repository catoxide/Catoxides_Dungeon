package com.catoxide.dungeonblockvarient.block;

import com.catoxide.dungeonblockvarient.client.model.AncientBakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class AncientBlockEntity extends BlockEntity {
    @Nullable
    private Block wrapped;
    private static final Logger LOGGER = LoggerFactory.getLogger(AncientBlockEntity.class);

    public AncientBlockEntity(BlockPos p, BlockState s) {
        super(ModBlockEntities.REINFORCED.get(), p, s);
    }

    @Nullable
    public Block getWrapped() {
        return wrapped;
    }

    public void setWrapped(Block wrapped) {
        // 保护机制：确保不会设置被禁止的方块
        if (isBlockForbidden(wrapped)) {
            LOGGER.debug("Attempted to set forbidden wrapped block: {}", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
            this.wrapped = Blocks.STONE; // 回退到石头
        } else {
            this.wrapped = wrapped;
        }
        LOGGER.debug("Set wrapped block to: {}", BuiltInRegistries.BLOCK.getKey(this.wrapped).toString());
        setChanged(); // 标记数据更改

        if (level != null) {
            // 请求重新渲染
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);

            // 强制更新模型数据
            requestModelDataUpdate();
        }
    }
    @Override
    public void requestModelDataUpdate() {
        super.requestModelDataUpdate();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    // 检查方块是否被禁止包装
    private boolean isBlockForbidden(Block block) {
        // 禁止包装 Ancient Block 自身
        if (block instanceof AncientBlock) {
            return true;
        }

        // 禁止包装空气和屏障等特殊方块
        if (block == Blocks.AIR || block == Blocks.BARRIER || block == Blocks.STRUCTURE_VOID) {
            return true;
        }

        return false;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (wrapped != null) {
            tag.putString("Wrapped", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Wrapped")) {
            String id = tag.getString("Wrapped");
            ResourceLocation rl = ResourceLocation.tryParse(id);
            if (rl != null) {
                Block loadedBlock = BuiltInRegistries.BLOCK.get(rl);

                // 保护机制：确保不会加载被禁止的方块
                if (isBlockForbidden(loadedBlock)) {
                    LOGGER.debug("Attempted to load forbidden wrapped block: {}", id);
                    this.wrapped = Blocks.STONE; // 回退到石头
                } else {
                    this.wrapped = loadedBlock;
                }

                LOGGER.debug("Loaded wrapped block: {}", BuiltInRegistries.BLOCK.getKey(this.wrapped).toString());
            }
        }
    }

    // 添加同步方法
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);

        // 强制客户端重新渲染
        if (level != null && level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    // 创建数据包用于同步
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    // 处理从服务器接收到的更新
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }

    // 提供模型数据
    @Nonnull
    @Override
    public ModelData getModelData() {
        return ModelData.builder()
                .with(AncientBakedModel.WRAPPED_BLOCK, Optional.ofNullable(wrapped).map(Block::defaultBlockState))
                .build();
    }
}