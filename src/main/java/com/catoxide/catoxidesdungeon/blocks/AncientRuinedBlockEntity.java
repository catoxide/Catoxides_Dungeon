//package com.catoxide.catoxidesdungeon.blocks;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.item.FallingBlockEntity;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.registries.ForgeRegistries;
//
//public class AncientRuinedBlockEntity extends FallingBlockEntity {
//    private Block originalBlock;
//
//    public AncientRuinedBlockEntity(EntityType<? extends FallingBlockEntity> type, Level level) {
//        super(type, level);
//        // 设置伤害参数
//        this.setHurtsEntities(2.0F, 40);
//    }
//
//    public AncientRuinedBlockEntity(Level level, double x, double y, double z, BlockState state, Block originalBlock) {
//        this(EntityType.FALLING_BLOCK, level);
//
//        // 使用反射或其他方法来设置 blockState
//        // 由于 blockState 是私有的，我们需要使用反射或创建一个新的 FallingBlockEntity 实例
//        // 这里我们使用反射来设置 blockState
//        try {
//            java.lang.reflect.Field blockStateField = FallingBlockEntity.class.getDeclaredField("blockState");
//            blockStateField.setAccessible(true);
//            blockStateField.set(this, state);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        this.blocksBuilding = true;
//        this.setPos(x, y, z);
//        this.setDeltaMovement(net.minecraft.world.phys.Vec3.ZERO);
//        this.xo = x;
//        this.yo = y;
//        this.zo = z;
//        this.setStartPos(this.blockPosition());
//        this.originalBlock = originalBlock;
//
//        // 保存原始方块信息到 blockData
//        if (this.blockData == null) {
//            this.blockData = new CompoundTag();
//        }
//        if (originalBlock != null) {
//            this.blockData.putString("OriginalBlock",
//                    ForgeRegistries.BLOCKS.getKey(originalBlock).toString());
//        }
//
//        // 设置伤害参数
//        this.setHurtsEntities(2.0F, 40);
//    }
//
//    public void setOriginalBlock(Block originalBlock) {
//        this.originalBlock = originalBlock;
//        // 更新 blockData
//        if (this.blockData == null) {
//            this.blockData = new CompoundTag();
//        }
//        if (originalBlock != null) {
//            this.blockData.putString("OriginalBlock",
//                    ForgeRegistries.BLOCKS.getKey(originalBlock).toString());
//        }
//    }
//
//    public Block getOriginalBlock() {
//        return originalBlock;
//    }
//
//    @Override
//    public void tick() {
//        super.tick();
//
//        // 在这里添加自定义的着陆和破碎逻辑
//        if (this.onGround()) {
//            // 着陆后的处理
//            this.handleLanding();
//        }
//    }
//
//    private void handleLanding() {
//        // 废墟方块落地后不做任何恢复操作
//        // 这里可以添加其他着陆后的逻辑
//    }
//
//    @Override
//    protected void addAdditionalSaveData(CompoundTag tag) {
//        super.addAdditionalSaveData(tag);
//        if (originalBlock != null) {
//            tag.putString("OriginalBlock", ForgeRegistries.BLOCKS.getKey(originalBlock).toString());
//        }
//    }
//
//    @Override
//    protected void readAdditionalSaveData(CompoundTag tag) {
//        super.readAdditionalSaveData(tag);
//        if (tag.contains("OriginalBlock")) {
//            ResourceLocation blockId = new ResourceLocation(tag.getString("OriginalBlock"));
//            originalBlock = ForgeRegistries.BLOCKS.getValue(blockId);
//        }
//    }
//}