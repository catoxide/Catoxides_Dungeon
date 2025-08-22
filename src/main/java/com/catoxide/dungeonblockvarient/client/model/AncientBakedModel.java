package com.catoxide.dungeonblockvarient.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class AncientBakedModel implements BakedModel {
    public static final ModelProperty<Optional<BlockState>> WRAPPED_BLOCK = new ModelProperty<>();

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand) {
        return getQuads(state, side, rand, ModelData.EMPTY, null);
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData data, @Nullable RenderType renderType) {
        // 尝试从模型数据中获取包裹的方块状态
        Optional<BlockState> wrappedBlockState = data.get(WRAPPED_BLOCK);

        if (wrappedBlockState != null && wrappedBlockState.isPresent()) {
            BlockState wrappedState = wrappedBlockState.get();
            BakedModel wrappedModel = Minecraft.getInstance().getBlockRenderer().getBlockModel(wrappedState);

            // 使用包裹方块的模型
            return wrappedModel.getQuads(wrappedState, side, rand, data, renderType);
        }

        // 如果没有包裹方块，使用默认的石头模型
        BakedModel stoneModel = Minecraft.getInstance().getBlockRenderer().getBlockModel(net.minecraft.world.level.block.Blocks.STONE.defaultBlockState());
        return stoneModel.getQuads(net.minecraft.world.level.block.Blocks.STONE.defaultBlockState(), side, rand, data, renderType);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return Minecraft.getInstance().getBlockRenderer().getBlockModel(net.minecraft.world.level.block.Blocks.STONE.defaultBlockState()).getParticleIcon();
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }

    @Override
    public ItemTransforms getTransforms() {
        return ItemTransforms.NO_TRANSFORMS;
    }
}