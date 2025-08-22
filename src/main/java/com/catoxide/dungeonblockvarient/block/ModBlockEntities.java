package com.catoxide.dungeonblockvarient.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "dungeonblockvarient");

    // 使用延迟注册，避免在注册时立即获取方块实例
    public static final RegistryObject<BlockEntityType<AncientBlockEntity>> REINFORCED = BLOCK_ENTITIES.register("reinforced",
            () -> BlockEntityType.Builder.of(AncientBlockEntity::new,
                    com.catoxide.dungeonblockvarient.DungeonBlockVarient.ANCIENT_BLOCK.get()).build(null));
}