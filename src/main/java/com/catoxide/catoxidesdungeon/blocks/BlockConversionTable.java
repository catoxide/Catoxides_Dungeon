package com.catoxide.catoxidesdungeon.blocks;

import com.catoxide.catoxidesdungeon.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class BlockConversionTable {
    private static final Map<Block, Block> CONVERSION_TABLE = new HashMap<>();

    // 初始化转换表
    static {
        CONVERSION_TABLE.put(ModBlocks.ANCIENT_STONE.get(), ModBlocks.ANCIENT_RUINED_BLOCK.get());
        CONVERSION_TABLE.put(ModBlocks.ANCIENT_TOWER_BLOCK.get(), ModBlocks.ANCIENT_RUINED_BLOCK.get());
        // 这里添加您的方块转换规则
        // 例如：CONVERSION_TABLE.put(Blocks.STONE, ModBlocks.RUINED_STONE.get());
        // 您需要在 ModBlocks 中注册对应的废墟方块
    }

    /**
     * 注册方块转换规则
     * @param originalBlock 原始方块
     * @param ruinedBlock 对应的废墟方块
     */
    public static void registerConversion(Block originalBlock, Block ruinedBlock) {
        CONVERSION_TABLE.put(originalBlock, ruinedBlock);
    }

    /**
     * 获取方块对应的废墟方块
     * @param originalBlock 原始方块
     * @return 对应的废墟方块，如果没有找到则返回默认废墟方块
     */
    public static Block getRuinedBlock(Block originalBlock) {
        return CONVERSION_TABLE.getOrDefault(originalBlock, ModBlocks.ANCIENT_RUINED_BLOCK.get());
    }

    /**
     * 检查是否有对应的废墟方块
     * @param originalBlock 原始方块
     * @return 是否有对应的废墟方块
     */
    public static boolean hasRuinedBlock(Block originalBlock) {
        return CONVERSION_TABLE.containsKey(originalBlock);
    }
}