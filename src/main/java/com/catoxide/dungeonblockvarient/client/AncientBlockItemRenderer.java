package com.catoxide.dungeonblockvarient.client;

import com.catoxide.dungeonblockvarient.block.AncientBlockItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class AncientBlockItemRenderer extends BlockEntityWithoutLevelRenderer {
    public AncientBlockItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        if (stack.getItem() instanceof AncientBlockItem) {
            AncientBlockItem item = (AncientBlockItem) stack.getItem();
            Block wrapped = item.readWrapped(stack);

            if (wrapped != null) {
                // 渲染 wrapped 方块的模型
                Minecraft.getInstance().getItemRenderer().renderStatic(
                        new ItemStack(wrapped),
                        transformType,
                        combinedLight,
                        combinedOverlay,
                        poseStack,
                        buffer,
                        Minecraft.getInstance().level,
                        0
                );
                return;
            }
        }

        // 默认渲染
        super.renderByItem(stack, transformType, poseStack, buffer, combinedLight, combinedOverlay);
    }
}