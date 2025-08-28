package com.catoxide.catoxidesdungeon;

//import com.catoxide.catoxidesdungeon.blocks.AncientRuinedBlockEntity;
import com.catoxide.catoxidesdungeon.blocks.ZombieTombBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CatoxidesDungeon.MODID);

//    public static final RegistryObject<BlockEntityType<AncientRuinedBlockEntity>> ANCIENT_RUINED_BLOCK =
//            BLOCK_ENTITIES.register("ancient_ruined_block",
//                    () -> BlockEntityType.Builder.of(AncientRuinedBlockEntity::new, ModBlocks.ANCIENT_RUINED_BLOCK.get()).build(null));

    // 添加僵尸巢穴方块实体的注册
    public static final RegistryObject<BlockEntityType<ZombieTombBlock.ZombieNestBlockEntity>> ZOMBIE_NEST =
            BLOCK_ENTITIES.register("zombie_nest",
                    () -> BlockEntityType.Builder.of(ZombieTombBlock.ZombieNestBlockEntity::new, ModBlocks.ZOMBIE_TOMB.get()).build(null));
}