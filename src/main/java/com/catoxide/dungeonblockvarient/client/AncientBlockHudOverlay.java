package com.catoxide.dungeonblockvarient.client;

import com.catoxide.dungeonblockvarient.block.AncientBlockItem;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class AncientBlockHudOverlay implements IGuiOverlay {
    private static final ResourceLocation WIDGETS = new ResourceLocation("textures/gui/widgets.png");

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.options.hideGui) return;

        // 获取玩家手中的物品
        ItemStack mainHandItem = minecraft.player.getMainHandItem();
        ItemStack offHandItem = minecraft.player.getOffhandItem();

        // 检查主手或副手是否持有 Ancient Block
        ItemStack ancientBlockItem = null;
        if (mainHandItem.getItem() instanceof AncientBlockItem) {
            ancientBlockItem = mainHandItem;
        } else if (offHandItem.getItem() instanceof AncientBlockItem) {
            ancientBlockItem = offHandItem;
        }

        if (ancientBlockItem != null) {
            AncientBlockItem item = (AncientBlockItem) ancientBlockItem.getItem();

            // 读取 wrapped 方块
            net.minecraft.world.level.block.Block wrapped = item.readWrapped(ancientBlockItem);

            // 设置渲染状态
            RenderSystem.enableBlend();

            // 绘制背景
            int x = screenWidth / 2 - 91; // 屏幕中央偏左
            int y = screenHeight - 80;    // 屏幕底部，略高于快捷栏

            // 绘制背景框
            guiGraphics.blit(WIDGETS, x, y, 0, 0, 182, 22);

            // 绘制文本显示当前 wrapped 方块
            String displayText = "Wrapped: " + wrapped.getName().getString();
            int textWidth = minecraft.font.width(displayText);
            int textX = x + (182 - textWidth) / 2;
            int textY = y + 7;

            guiGraphics.drawString(minecraft.font, Component.literal(displayText), textX, textY, 0xFFFFFF);

            // 添加操作提示
            String hintText = "Sneak + Right-click to wrap a block";
            int hintWidth = minecraft.font.width(hintText);
            int hintX = x + (182 - hintWidth) / 2;
            int hintY = y - 12;

            guiGraphics.drawString(minecraft.font, Component.literal(hintText), hintX, hintY, 0xFFFFFF);

            // 添加保护机制提示
            String protectionText = "Cannot wrap Ancient Blocks";
            int protectionWidth = minecraft.font.width(protectionText);
            int protectionX = x + (182 - protectionWidth) / 2;
            int protectionY = y - 24;

            guiGraphics.drawString(minecraft.font, Component.literal(protectionText), protectionX, protectionY, 0xFF5555);

            RenderSystem.disableBlend();
        }
    }

}