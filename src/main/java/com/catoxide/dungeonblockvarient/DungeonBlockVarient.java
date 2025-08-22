package com.catoxide.dungeonblockvarient;

import com.catoxide.dungeonblockvarient.block.AncientBlock;
import com.catoxide.dungeonblockvarient.block.AncientBlockItem;
import com.catoxide.dungeonblockvarient.block.ModBlockEntities;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(DungeonBlockVarient.MODID)
public class DungeonBlockVarient {
    public static final String MODID = "dungeonblockvarient";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<AncientBlock> ANCIENT_BLOCK = BLOCKS.register("ancient_block",
            () -> new AncientBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<AncientBlockItem> ANCIENT_BLOCK_ITEM = ITEMS.register("ancient_block", () ->
            new AncientBlockItem(ANCIENT_BLOCK.get(), new Item.Properties()));

    public DungeonBlockVarient() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 注册Deferred Register
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        // 注册事件总线
        MinecraftForge.EVENT_BUS.register(this);
    }
}