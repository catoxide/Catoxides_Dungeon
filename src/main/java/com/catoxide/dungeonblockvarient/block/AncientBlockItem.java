package com.catoxide.dungeonblockvarient.block;

import com.catoxide.dungeonblockvarient.client.AncientBlockItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class AncientBlockItem extends BlockItem {
    private static final String TAG_WRAPPED = "Wrapped";
    private static final Logger LOGGER = LoggerFactory.getLogger(AncientBlockItem.class);

    public AncientBlockItem(Block b, Properties p) {
        super(b, p);
    }

    public ItemStack withWrapped(Block wrapped) {
        ItemStack stack = new ItemStack(this);
        CompoundTag tag = stack.getOrCreateTag();
        tag.putString(TAG_WRAPPED, BuiltInRegistries.BLOCK.getKey(wrapped).toString());
        LOGGER.info("Wrapped block: {}", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
        return stack;
    }

    @Nullable
    public Block readWrapped(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag == null || !tag.contains(TAG_WRAPPED)) {
            LOGGER.debug("No wrapped block found in item stack");
            return Blocks.STONE; // 默认返回石头
        }
        String id = tag.getString(TAG_WRAPPED);
        ResourceLocation rl = ResourceLocation.tryParse(id);
        if (rl == null) {
            LOGGER.warn("Invalid resource location: {}", id);
            return Blocks.STONE;
        }
        Block wrapped = BuiltInRegistries.BLOCK.get(rl);
        LOGGER.debug("Read wrapped block: {}", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
        return wrapped;
    }
    public boolean hasValidWrapped(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null && tag.contains(TAG_WRAPPED);
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        Player player = ctx.getPlayer();

        if (player == null) return InteractionResult.PASS;

        // 只在玩家下蹲（潜行）时执行包装操作
        if (player.isCrouching()) {
            LOGGER.info("Player is crouching, performing wrap operation");

            Block target = level.getBlockState(ctx.getClickedPos()).getBlock();
            LOGGER.info("Target block: {}", BuiltInRegistries.BLOCK.getKey(target).toString());

            // 保护机制：检查目标方块是否是 Ancient Block 或其他不应该被包装的方块
            if (isBlockForbidden(target)) {
                LOGGER.warn("Attempted to wrap forbidden block: {}", BuiltInRegistries.BLOCK.getKey(target).toString());

                if (level.isClientSide) {
                    player.displayClientMessage(Component.literal("Cannot wrap this type of block"), true);
                }

                return InteractionResult.FAIL;
            }

            if (level.isClientSide) return InteractionResult.SUCCESS;

            ItemStack newStack = withWrapped(target);
            player.setItemInHand(ctx.getHand(), newStack);

            // 显示包装成功的提示
            player.displayClientMessage(Component.literal("Wrapped: " + target.getName().getString()), true);

            return InteractionResult.CONSUME;
        } else {
            // 如果玩家没有下蹲，执行默认的放置行为
            LOGGER.info("Player is not crouching, performing default placement");

            // 在客户端显示提示信息
            if (level.isClientSide) {
                player.displayClientMessage(Component.literal("Sneak + Right-click to wrap a block"), true);
            }

            return super.useOn(ctx);
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

        // 可以根据需要添加其他禁止包装的方块
        // 例如：if (block == Blocks.COMMAND_BLOCK) return true;

        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        Block b = readWrapped(stack);
        tooltip.add(Component.literal("Wrapped: " + b.getName().getString()));
        tooltip.add(Component.literal("Sneak + Right-click to wrap a block"));
        tooltip.add(Component.literal("Right-click to place"));
        tooltip.add(Component.literal("Cannot wrap Ancient Blocks"));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new AncientBlockItemRenderer();
            }
        });
    }

    // 重写此方法以在放置时传递 wrapped 方块信息
    @Override
    protected boolean updateCustomBlockEntityTag(BlockPos pos, Level level, @Nullable Player player, ItemStack stack, BlockState state) {
        LOGGER.debug("updateCustomBlockEntityTag called at position: {}", pos);

        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof AncientBlockEntity) {
                Block wrapped = readWrapped(stack);

                // 再次检查，确保不会放置被禁止的方块
                if (isBlockForbidden(wrapped)) {
                    LOGGER.warn("Attempted to place forbidden wrapped block: {}", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
                    wrapped = Blocks.STONE; // 回退到石头
                }

                LOGGER.debug("Setting wrapped block to: {}", BuiltInRegistries.BLOCK.getKey(wrapped).toString());
                ((AncientBlockEntity) blockEntity).setWrapped(wrapped);
                blockEntity.setChanged(); // 标记为已更改

                // 强制同步到客户端
                level.sendBlockUpdated(pos, state, state, 3);
                return true;
            } else {
                LOGGER.warn("BlockEntity is not AncientBlockEntity or is null");
            }
        }
        return super.updateCustomBlockEntityTag(pos, level, player, stack, state);
    }
}