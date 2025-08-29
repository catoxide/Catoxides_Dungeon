package com.catoxide.catoxidesdungeon;

import com.catoxide.catoxidesdungeon.blocks.AncientRuinedBlock;
import com.catoxide.catoxidesdungeon.blocks.AncientTowerBlock;
import com.catoxide.catoxidesdungeon.blocks.ZombieTombBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.grower.*;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

import static com.catoxide.catoxidesdungeon.CatoxidesDungeon.MODID;
import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }
    private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return (boolean)true;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }
    public static final RegistryObject<Block> ANCIENT_AIR =
            BLOCKS.register("ancient_air", () -> new AirBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().air()));
    public static final RegistryObject<Block> ANCIENT_STONE =
            BLOCKS.register("ancient_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_GRANITE =
            BLOCKS.register("ancient_granite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_GRANITE =
            BLOCKS.register("ancient_polished_granite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DIORITE =
            BLOCKS.register("ancient_diorite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DIORITE =
            BLOCKS.register("ancient_polished_diorite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_ANDESITE =
            BLOCKS.register("ancient_andesite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_ANDESITE =
            BLOCKS.register("ancient_polished_andesite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_GRASS_BLOCK =
            BLOCKS.register("ancient_grass_block", () -> new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_DIRT =
            BLOCKS.register("ancient_dirt", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ANCIENT_COARSE_DIRT =
            BLOCKS.register("ancient_coarse_dirt", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ANCIENT_PODZOL =
            BLOCKS.register("ancient_podzol", () -> new SnowyDirtBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ANCIENT_COBBLESTONE =
            BLOCKS.register("ancient_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_OAK_PLANKS =
            BLOCKS.register("ancient_oak_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_PLANKS =
            BLOCKS.register("ancient_spruce_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BIRCH_PLANKS =
            BLOCKS.register("ancient_birch_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_PLANKS =
            BLOCKS.register("ancient_jungle_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ACACIA_PLANKS =
            BLOCKS.register("ancient_acacia_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CHERRY_PLANKS =
            BLOCKS.register("ancient_cherry_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_PLANKS =
            BLOCKS.register("ancient_dark_oak_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_PLANKS =
            BLOCKS.register("ancient_mangrove_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_PLANKS =
            BLOCKS.register("ancient_bamboo_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.BAMBOO_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_MOSAIC =
            BLOCKS.register("ancient_bamboo_mosaic", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.BAMBOO_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_OAK_SAPLING =
            BLOCKS.register("ancient_oak_sapling", () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_SAPLING =
            BLOCKS.register("ancient_spruce_sapling", () -> new SaplingBlock(new SpruceTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BIRCH_SAPLING =
            BLOCKS.register("ancient_birch_sapling", () -> new SaplingBlock(new BirchTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_SAPLING =
            BLOCKS.register("ancient_jungle_sapling", () -> new SaplingBlock(new JungleTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ACACIA_SAPLING =
            BLOCKS.register("ancient_acacia_sapling", () -> new SaplingBlock(new AcaciaTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CHERRY_SAPLING =
            BLOCKS.register("ancient_cherry_sapling", () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().randomTicks().instabreak().sound(SoundType.CHERRY_SAPLING).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_SAPLING =
            BLOCKS.register("ancient_dark_oak_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_PROPAGULE =
            BLOCKS.register("ancient_mangrove_propagule", () -> new MangrovePropaguleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BEDROCK =
            BLOCKS.register("ancient_bedrock", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(-1.0F, 3600000.0F).noLootTable().isValidSpawn(ModBlocks::never)));
    public static final RegistryObject<Block> ANCIENT_WATER =
            BLOCKS.register("ancient_water", () -> new LiquidBlock(Fluids.WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).replaceable().noCollission().strength(100.0F).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY)));
    public static final RegistryObject<Block> ANCIENT_SAND =
            BLOCKS.register("ancient_sand", () -> new SandBlock(14406560, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_SUSPICIOUS_SAND =
            BLOCKS.register("ancient_suspicious_sand", () -> new BrushableBlock(SAND, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED));
    public static final RegistryObject<Block> ANCIENT_RED_SAND =
            BLOCKS.register("ancient_red_sand", () -> new SandBlock(11098145, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_GRAVEL =
            BLOCKS.register("ancient_gravel", () -> new GravelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ANCIENT_SUSPICIOUS_GRAVEL =
            BLOCKS.register("ancient_suspicious_gravel", () -> new BrushableBlock(GRAVEL, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_GRAVEL).pushReaction(PushReaction.DESTROY), SoundEvents.BRUSH_GRAVEL, SoundEvents.BRUSH_GRAVEL_COMPLETED));
    public static final RegistryObject<Block> ANCIENT_GOLD_ORE =
            BLOCKS.register("ancient_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_GOLD_ORE =
            BLOCKS.register("ancient_deepslate_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(GOLD_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_IRON_ORE =
            BLOCKS.register("ancient_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_IRON_ORE =
            BLOCKS.register("ancient_deepslate_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(IRON_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_COAL_ORE =
            BLOCKS.register("ancient_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(0, 2)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_COAL_ORE =
            BLOCKS.register("ancient_deepslate_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(COAL_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(0, 2)));
    public static final RegistryObject<Block> ANCIENT_NETHER_GOLD_ORE =
            BLOCKS.register("ancient_nether_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_GOLD_ORE), UniformInt.of(0, 1)));
    private static RotatedPillarBlock log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }
    private static RotatedPillarBlock log(MapColor pTopMapColor, MapColor pSideMapColor, SoundType pSoundType) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((p_258972_) -> {
            return p_258972_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(pSoundType).ignitedByLava());
    }
    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }
    public static final RegistryObject<Block> ANCIENT_OAK_LOG =
            BLOCKS.register("ancient_oak_log", () -> log(MapColor.WOOD, MapColor.PODZOL));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_LOG =
            BLOCKS.register("ancient_spruce_log", () -> log(MapColor.PODZOL, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> ANCIENT_BIRCH_LOG =
            BLOCKS.register("ancient_birch_log", () -> log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_LOG =
            BLOCKS.register("ancient_jungle_log", () -> log(MapColor.DIRT, MapColor.PODZOL));
    public static final RegistryObject<Block> ANCIENT_ACACIA_LOG =
            BLOCKS.register("ancient_acacia_log", () -> log(MapColor.COLOR_ORANGE, MapColor.STONE));
    public static final RegistryObject<Block> ANCIENT_CHERRY_LOG =
            BLOCKS.register("ancient_cherry_log", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_GRAY, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_LOG =
            BLOCKS.register("ancient_dark_oak_log", () -> log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_LOG =
            BLOCKS.register("ancient_mangrove_log", () -> log(MapColor.COLOR_RED, MapColor.PODZOL));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_ROOTS =
            BLOCKS.register("ancient_mangrove_roots", () -> new MangroveRootsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(0.7F).randomTicks().sound(SoundType.MANGROVE_ROOTS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MUDDY_MANGROVE_ROOTS =
            BLOCKS.register("ancient_muddy_mangrove_roots", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).strength(0.7F).sound(SoundType.MUDDY_MANGROVE_ROOTS)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_BLOCK =
            BLOCKS.register("ancient_bamboo_block", () -> log(MapColor.COLOR_YELLOW, MapColor.PLANT, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_SPRUCE_LOG =
            BLOCKS.register("ancient_stripped_spruce_log", () -> log(MapColor.PODZOL, MapColor.PODZOL));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_BIRCH_LOG =
            BLOCKS.register("ancient_stripped_birch_log", () -> log(MapColor.SAND, MapColor.SAND));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_JUNGLE_LOG =
            BLOCKS.register("ancient_stripped_jungle_log", () -> log(MapColor.DIRT, MapColor.DIRT));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_ACACIA_LOG =
            BLOCKS.register("ancient_stripped_acacia_log", () -> log(MapColor.COLOR_ORANGE, MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_CHERRY_LOG =
            BLOCKS.register("ancient_stripped_cherry_log", () -> log(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_PINK, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_DARK_OAK_LOG =
            BLOCKS.register("ancient_stripped_dark_oak_log", () -> log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_OAK_LOG =
            BLOCKS.register("ancient_stripped_oak_log", () -> log(MapColor.WOOD, MapColor.WOOD));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_MANGROVE_LOG =
            BLOCKS.register("ancient_stripped_mangrove_log", () -> log(MapColor.COLOR_RED, MapColor.COLOR_RED));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_BAMBOO_BLOCK =
            BLOCKS.register("ancient_stripped_bamboo_block", () -> log(MapColor.COLOR_YELLOW, MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> ANCIENT_OAK_WOOD =
            BLOCKS.register("ancient_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_WOOD =
            BLOCKS.register("ancient_spruce_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BIRCH_WOOD =
            BLOCKS.register("ancient_birch_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_WOOD =
            BLOCKS.register("ancient_jungle_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ACACIA_WOOD =
            BLOCKS.register("ancient_acacia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CHERRY_WOOD =
            BLOCKS.register("ancient_cherry_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_WOOD =
            BLOCKS.register("ancient_dark_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_WOOD =
            BLOCKS.register("ancient_mangrove_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_OAK_WOOD =
            BLOCKS.register("ancient_stripped_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_SPRUCE_WOOD =
            BLOCKS.register("ancient_stripped_spruce_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_BIRCH_WOOD =
            BLOCKS.register("ancient_stripped_birch_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_JUNGLE_WOOD =
            BLOCKS.register("ancient_stripped_jungle_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_ACACIA_WOOD =
            BLOCKS.register("ancient_stripped_acacia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_CHERRY_WOOD =
            BLOCKS.register("ancient_stripped_cherry_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_DARK_OAK_WOOD =
            BLOCKS.register("ancient_stripped_dark_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_MANGROVE_WOOD =
            BLOCKS.register("ancient_stripped_mangrove_wood", () -> log(MapColor.COLOR_RED, MapColor.COLOR_RED));
    private static LeavesBlock leaves(SoundType pType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(pType).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false));
    }
    public static final RegistryObject<Block> ANCIENT_OAK_LEAVES =
            BLOCKS.register("ancient_oak_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_LEAVES =
            BLOCKS.register("ancient_spruce_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> ANCIENT_BIRCH_LEAVES =
            BLOCKS.register("ancient_birch_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_LEAVES =
            BLOCKS.register("ancient_jungle_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> ANCIENT_ACACIA_LEAVES =
            BLOCKS.register("ancient_acacia_leaves", () -> leaves(SoundType.GRASS));
    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return (boolean)(p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
    }
    public static final RegistryObject<Block> ANCIENT_CHERRY_LEAVES =
            BLOCKS.register("ancient_cherry_leaves", () -> new CherryLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.2F).randomTicks().sound(SoundType.CHERRY_LEAVES).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_LEAVES =
            BLOCKS.register("ancient_dark_oak_leaves", () -> leaves(SoundType.GRASS));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_LEAVES =
            BLOCKS.register("ancient_mangrove_leaves", () -> new MangroveLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(ModBlocks::ocelotOrParrot).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_AZALEA_LEAVES =
            BLOCKS.register("ancient_azalea_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryObject<Block> ANCIENT_FLOWERING_AZALEA_LEAVES =
            BLOCKS.register("ancient_flowering_azalea_leaves", () -> leaves(SoundType.AZALEA_LEAVES));
    public static final RegistryObject<Block> ANCIENT_SPONGE =
            BLOCKS.register("ancient_sponge", () -> new SpongeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_WET_SPONGE =
            BLOCKS.register("ancient_wet_sponge", () -> new WetSpongeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_GLASS =
                    BLOCKS.register("ancient_glass", () -> new GlassBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ModBlocks::always).isRedstoneConductor((state, getter, pos) -> false).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_LAPIS_ORE =
            BLOCKS.register("ancient_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_LAPIS_ORE =
            BLOCKS.register("ancient_deepslate_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(LAPIS_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> ANCIENT_LAPIS_BLOCK =
            BLOCKS.register("ancient_lapis_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.LAPIS).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_DISPENSER =
            BLOCKS.register("ancient_dispenser", () -> new DispenserBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F)));
    public static final RegistryObject<Block> ANCIENT_SANDSTONE =
            BLOCKS.register("ancient_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_SANDSTONE =
            BLOCKS.register("ancient_chiseled_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_CUT_SANDSTONE =
            BLOCKS.register("ancient_cut_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_NOTE_BLOCK =
            BLOCKS.register("ancient_note_block", () -> new NoteBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(0.8F).ignitedByLava()));
    private static BedBlock bed(DyeColor pColor) {
        return new BedBlock(pColor, BlockBehaviour.Properties.of().mapColor((p_284863_) -> {
            return p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? pColor.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }
    public static final RegistryObject<Block> ANCIENT_WHITE_BED =
            BLOCKS.register("ancient_white_bed", () -> bed(DyeColor.WHITE));
    public static final RegistryObject<Block> ANCIENT_ORANGE_BED =
            BLOCKS.register("ancient_orange_bed", () -> bed(DyeColor.ORANGE));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_BED =
            BLOCKS.register("ancient_magenta_bed", () -> bed(DyeColor.MAGENTA));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_BED =
            BLOCKS.register("ancient_light_blue_bed", () -> bed(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> ANCIENT_YELLOW_BED =
            BLOCKS.register("ancient_yellow_bed", () -> bed(DyeColor.YELLOW));
    public static final RegistryObject<Block> ANCIENT_LIME_BED =
            BLOCKS.register("ancient_lime_bed", () -> bed(DyeColor.LIME));
    public static final RegistryObject<Block> ANCIENT_PINK_BED =
            BLOCKS.register("ancient_pink_bed", () -> bed(DyeColor.PINK));
    public static final RegistryObject<Block> ANCIENT_GRAY_BED =
            BLOCKS.register("ancient_gray_bed", () -> bed(DyeColor.GRAY));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_BED =
            BLOCKS.register("ancient_light_gray_bed", () -> bed(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> ANCIENT_CYAN_BED =
            BLOCKS.register("ancient_cyan_bed", () -> bed(DyeColor.CYAN));
    public static final RegistryObject<Block> ANCIENT_PURPLE_BED =
            BLOCKS.register("ancient_purple_bed", () -> bed(DyeColor.PURPLE));
    public static final RegistryObject<Block> ANCIENT_BLUE_BED =
            BLOCKS.register("ancient_blue_bed", () -> bed(DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_BROWN_BED =
            BLOCKS.register("ancient_brown_bed", () -> bed(DyeColor.BROWN));
    public static final RegistryObject<Block> ANCIENT_GREEN_BED =
            BLOCKS.register("ancient_green_bed", () -> bed(DyeColor.GREEN));
    public static final RegistryObject<Block> ANCIENT_RED_BED =
            BLOCKS.register("ancient_red_bed", () -> bed(DyeColor.RED));
    public static final RegistryObject<Block> ANCIENT_BLACK_BED =
            BLOCKS.register("ancient_black_bed", () -> bed(DyeColor.BLACK));
//    public static final RegistryObject<Block> ANCIENT_POWERED_RAIL =
//            BLOCKS.register("ancient_powered_rail", () -> new PoweredRailBlock(BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.METAL), true));
    public static final RegistryObject<Block> ANCIENT_DETECTOR_RAIL =
            BLOCKS.register("ancient_detector_rail", () -> new DetectorRailBlock(BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.METAL)));
    private static PistonBaseBlock pistonBase(boolean pSticky) {
        BlockBehaviour.StatePredicate blockbehaviour$statepredicate = (p_152641_, p_152642_, p_152643_) -> {
            return !p_152641_.getValue(PistonBaseBlock.EXTENDED);
        };
        return new PistonBaseBlock(pSticky, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.5F).isRedstoneConductor((state, getter, pos) -> false).isSuffocating(blockbehaviour$statepredicate).isViewBlocking(blockbehaviour$statepredicate).pushReaction(PushReaction.BLOCK));
    }
    public static final RegistryObject<Block> ANCIENT_STICKY_PISTON =
            BLOCKS.register("ancient_sticky_piston", () -> pistonBase(true));
    public static final RegistryObject<Block> ANCIENT_COBWEB =
            BLOCKS.register("ancient_cobweb", () -> new WebBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).forceSolidOn().noCollission().requiresCorrectToolForDrops().strength(4.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_GRASS =
            BLOCKS.register("ancient_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FERN =
            BLOCKS.register("ancient_fern", () -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DEAD_BUSH =
            BLOCKS.register("ancient_dead_bush", () -> new DeadBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SEAGRASS =
            BLOCKS.register("ancient_seagrass", () -> new SeagrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).replaceable().noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TALL_SEAGRASS =
            BLOCKS.register("ancient_tall_seagrass", () -> new TallSeagrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).replaceable().noCollission().instabreak().sound(SoundType.WET_GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PISTON =
            BLOCKS.register("ancient_piston", () -> pistonBase(false));
    public static final RegistryObject<Block> ANCIENT_PISTON_HEAD =
            BLOCKS.register("ancient_piston_head", () -> new PistonHeadBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.5F).noLootTable().pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_WHITE_WOOL =
            BLOCKS.register("ancient_white_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ORANGE_WOOL =
            BLOCKS.register("ancient_orange_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_WOOL =
            BLOCKS.register("ancient_magenta_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_WOOL =
            BLOCKS.register("ancient_light_blue_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_YELLOW_WOOL =
            BLOCKS.register("ancient_yellow_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIME_WOOL =
            BLOCKS.register("ancient_lime_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PINK_WOOL =
            BLOCKS.register("ancient_pink_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GRAY_WOOL =
            BLOCKS.register("ancient_gray_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_WOOL =
            BLOCKS.register("ancient_light_gray_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CYAN_WOOL =
            BLOCKS.register("ancient_cyan_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PURPLE_WOOL =
            BLOCKS.register("ancient_purple_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLUE_WOOL =
            BLOCKS.register("ancient_blue_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BROWN_WOOL =
            BLOCKS.register("ancient_brown_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GREEN_WOOL =
            BLOCKS.register("ancient_green_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_WOOL =
            BLOCKS.register("ancient_red_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLACK_WOOL =
            BLOCKS.register("ancient_black_wool", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MOVING_PISTON =
            BLOCKS.register("ancient_moving_piston", () -> new MovingPistonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().strength(-1.0F).dynamicShape().noLootTable().noOcclusion().isRedstoneConductor((state, getter, pos) -> false).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_DANDELION =
            BLOCKS.register("ancient_dandelion", () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TORCHFLOWER =
            BLOCKS.register("ancient_torchflower", () -> new FlowerBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_POPPY =
            BLOCKS.register("ancient_poppy", () -> new FlowerBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BLUE_ORCHID =
            BLOCKS.register("ancient_blue_orchid", () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ALLIUM =
            BLOCKS.register("ancient_allium", () -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 4, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_AZURE_BLUET =
            BLOCKS.register("ancient_azure_bluet", () -> new FlowerBlock(MobEffects.BLINDNESS, 8, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_RED_TULIP =
            BLOCKS.register("ancient_red_tulip", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_TULIP =
            BLOCKS.register("ancient_orange_tulip", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WHITE_TULIP =
            BLOCKS.register("ancient_white_tulip", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PINK_TULIP =
            BLOCKS.register("ancient_pink_tulip", () -> new FlowerBlock(MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_OXEYE_DAISY =
            BLOCKS.register("ancient_oxeye_daisy", () -> new FlowerBlock(MobEffects.REGENERATION, 8, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CORNFLOWER =
            BLOCKS.register("ancient_cornflower", () -> new FlowerBlock(MobEffects.JUMP, 6, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WITHER_ROSE =
            BLOCKS.register("ancient_wither_rose", () -> new WitherRoseBlock(MobEffects.WITHER, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_LILY_OF_THE_VALLEY =
            BLOCKS.register("ancient_lily_of_the_valley", () -> new FlowerBlock(MobEffects.POISON, 12, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_RED_MUSHROOM =
            BLOCKS.register("ancient_red_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, getter, pos) -> true).pushReaction(PushReaction.DESTROY), TreeFeatures.HUGE_RED_MUSHROOM));
    public static final RegistryObject<Block> ANCIENT_GOLD_BLOCK =
            BLOCKS.register("ancient_gold_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BELL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_IRON_BLOCK =
            BLOCKS.register("ancient_iron_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_BRICKS =
            BLOCKS.register("ancient_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_TNT =
            BLOCKS.register("ancient_tnt", () -> new TntBlock(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).instabreak().sound(SoundType.GRASS).ignitedByLava().isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_BOOKSHELF =
            BLOCKS.register("ancient_bookshelf", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CHISELED_BOOKSHELF =
            BLOCKS.register("ancient_chiseled_bookshelf", () -> new ChiseledBookShelfBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(1.5F).sound(SoundType.CHISELED_BOOKSHELF).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MOSSY_COBBLESTONE =
            BLOCKS.register("ancient_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_OBSIDIAN =
            BLOCKS.register("ancient_obsidian", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final RegistryObject<Block> ANCIENT_SPAWNER =
            BLOCKS.register("ancient_spawner", () -> new SpawnerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_OAK_STAIRS =
            BLOCKS.register("ancient_oak_stairs", () -> new StairBlock(OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(OAK_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_WIRE =
            BLOCKS.register("ancient_redstone_wire", () -> new RedStoneWireBlock(BlockBehaviour.Properties.of().noCollission().instabreak().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DIAMOND_ORE =
            BLOCKS.register("ancient_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_DIAMOND_ORE =
            BLOCKS.register("ancient_deepslate_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ANCIENT_DIAMOND_BLOCK =
            BLOCKS.register("ancient_diamond_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_CRAFTING_TABLE =
            BLOCKS.register("ancient_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_WHEAT =
            BLOCKS.register("ancient_wheat", () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FARMLAND =
            BLOCKS.register("ancient_farmland", () -> new FarmBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).randomTicks().strength(0.6F).sound(SoundType.GRAVEL).isViewBlocking((state, getter, pos) -> true).isSuffocating((state, getter, pos) -> true)));
    public static final RegistryObject<Block> ANCIENT_FURNACE =
            BLOCKS.register("ancient_furnace", () -> new FurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13))));
    public static final RegistryObject<Block> ANCIENT_OAK_SIGN =
            BLOCKS.register("ancient_oak_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_SIGN =
            BLOCKS.register("ancient_spruce_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_SIGN =
            BLOCKS.register("ancient_birch_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_ACACIA_SIGN =
            BLOCKS.register("ancient_acacia_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_SIGN =
            BLOCKS.register("ancient_cherry_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_SIGN =
            BLOCKS.register("ancient_jungle_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_SIGN =
            BLOCKS.register("ancient_dark_oak_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_SIGN =
            BLOCKS.register("ancient_mangrove_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_SIGN =
            BLOCKS.register("ancient_bamboo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_OAK_DOOR =
            BLOCKS.register("ancient_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> ANCIENT_LADDER =
            BLOCKS.register("ancient_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of().forceSolidOff().strength(0.4F).sound(SoundType.LADDER).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_RAIL =
            BLOCKS.register("ancient_rail", () -> new RailBlock(BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_COBBLESTONE_STAIRS =
            BLOCKS.register("ancient_cobblestone_stairs", () -> new StairBlock(COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLESTONE)));
    public static final RegistryObject<Block> ANCIENT_OAK_WALL_SIGN =
            BLOCKS.register("ancient_oak_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(OAK_SIGN).ignitedByLava(), WoodType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_WALL_SIGN =
            BLOCKS.register("ancient_spruce_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(SPRUCE_SIGN).ignitedByLava(), WoodType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_WALL_SIGN =
            BLOCKS.register("ancient_birch_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(BIRCH_SIGN).ignitedByLava(), WoodType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_ACACIA_WALL_SIGN =
            BLOCKS.register("ancient_acacia_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(ACACIA_SIGN).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_WALL_SIGN =
            BLOCKS.register("ancient_cherry_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(CHERRY_SIGN).ignitedByLava(), WoodType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_WALL_SIGN =
            BLOCKS.register("ancient_jungle_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(JUNGLE_SIGN).ignitedByLava(), WoodType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_WALL_SIGN =
            BLOCKS.register("ancient_dark_oak_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(DARK_OAK_SIGN).ignitedByLava(), WoodType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_WALL_SIGN =
            BLOCKS.register("ancient_mangrove_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(MANGROVE_SIGN).ignitedByLava(), WoodType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_WALL_SIGN =
            BLOCKS.register("ancient_bamboo_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(BAMBOO_SIGN), WoodType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_OAK_HANGING_SIGN =
            BLOCKS.register("ancient_oak_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_HANGING_SIGN =
            BLOCKS.register("ancient_spruce_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_HANGING_SIGN =
            BLOCKS.register("ancient_birch_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_ACACIA_HANGING_SIGN =
            BLOCKS.register("ancient_acacia_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_HANGING_SIGN =
            BLOCKS.register("ancient_cherry_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_HANGING_SIGN =
            BLOCKS.register("ancient_jungle_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_HANGING_SIGN =
            BLOCKS.register("ancient_dark_oak_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_HANGING_SIGN =
            BLOCKS.register("ancient_crimson_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F), WoodType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_HANGING_SIGN =
            BLOCKS.register("ancient_warped_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F), WoodType.WARPED));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_HANGING_SIGN =
            BLOCKS.register("ancient_mangrove_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_HANGING_SIGN =
            BLOCKS.register("ancient_bamboo_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), WoodType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_OAK_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_oak_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(OAK_HANGING_SIGN), WoodType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_spruce_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(SPRUCE_HANGING_SIGN).ignitedByLava(), WoodType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_birch_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(BIRCH_HANGING_SIGN).ignitedByLava(), WoodType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_ACACIA_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_acacia_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(ACACIA_HANGING_SIGN), WoodType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_cherry_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(CHERRY_HANGING_SIGN), WoodType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_jungle_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(JUNGLE_HANGING_SIGN), WoodType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_dark_oak_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(DARK_OAK_HANGING_SIGN), WoodType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_mangrove_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_LOG.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(MANGROVE_HANGING_SIGN), WoodType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_crimson_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(CRIMSON_HANGING_SIGN), WoodType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_warped_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).dropsLike(WARPED_HANGING_SIGN), WoodType.WARPED));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_WALL_HANGING_SIGN =
            BLOCKS.register("ancient_bamboo_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(BAMBOO_HANGING_SIGN), WoodType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_LEVER =
            BLOCKS.register("ancient_lever", () -> new LeverBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_STONE_PRESSURE_PLATE =
            BLOCKS.register("ancient_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.STONE));
    public static final RegistryObject<Block> ANCIENT_IRON_DOOR =
            BLOCKS.register("ancient_iron_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F).noOcclusion().pushReaction(PushReaction.DESTROY), BlockSetType.IRON));
    public static final RegistryObject<Block> ANCIENT_OAK_PRESSURE_PLATE =
            BLOCKS.register("ancient_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(OAK_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_PRESSURE_PLATE =
            BLOCKS.register("ancient_spruce_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(SPRUCE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_PRESSURE_PLATE =
            BLOCKS.register("ancient_birch_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(BIRCH_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_PRESSURE_PLATE =
            BLOCKS.register("ancient_jungle_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(JUNGLE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_ACACIA_PRESSURE_PLATE =
            BLOCKS.register("ancient_acacia_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(ACACIA_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_PRESSURE_PLATE =
            BLOCKS.register("ancient_cherry_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_PRESSURE_PLATE =
            BLOCKS.register("ancient_dark_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(DARK_OAK_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_PRESSURE_PLATE =
            BLOCKS.register("ancient_mangrove_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MANGROVE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_PRESSURE_PLATE =
            BLOCKS.register("ancient_bamboo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_ORE =
            BLOCKS.register("ancient_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().randomTicks().lightLevel(litBlockEmission(9)).strength(3.0F, 3.0F)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_REDSTONE_ORE =
            BLOCKS.register("ancient_deepslate_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(REDSTONE_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_TORCH =
            BLOCKS.register("ancient_redstone_torch", () -> new RedstoneTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_WALL_TORCH =
            BLOCKS.register("ancient_redstone_wall_torch", () -> new RedstoneWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.WOOD).dropsLike(REDSTONE_TORCH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_STONE_BUTTON =
            BLOCKS.register("ancient_stone_button", () -> stoneButton());
    public static final RegistryObject<Block> ANCIENT_SNOW_BLOCK =
            BLOCKS.register("ancient_snow_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> ANCIENT_CACTUS =
            BLOCKS.register("ancient_cactus", () -> new CactusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().strength(0.4F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CLAY =
            BLOCKS.register("ancient_clay", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).instrument(NoteBlockInstrument.FLUTE).strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> ANCIENT_SUGAR_CANE =
            BLOCKS.register("ancient_sugar_cane", () -> new SugarCaneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_JUKEBOX =
            BLOCKS.register("ancient_jukebox", () -> new JukeboxBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 6.0F).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_OAK_FENCE =
            BLOCKS.register("ancient_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(OAK_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PUMPKIN =
            BLOCKS.register("ancient_pumpkin", () -> new PumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_NETHERRACK =
            BLOCKS.register("ancient_netherrack", () -> new NetherrackBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> ANCIENT_SOUL_SAND =
            BLOCKS.register("ancient_soul_sand", () -> new SoulSandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.COW_BELL).strength(0.5F).speedFactor(0.4F).sound(SoundType.SOUL_SAND).isValidSpawn(ModBlocks::always).isRedstoneConductor((state, getter, pos) -> true).isViewBlocking((state, getter, pos) -> true).isSuffocating((state, getter, pos) -> true)));
    public static final RegistryObject<Block> ANCIENT_SOUL_SOIL =
            BLOCKS.register("ancient_soul_soil", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.5F).sound(SoundType.SOUL_SOIL)));
    public static final RegistryObject<Block> ANCIENT_BASALT =
            BLOCKS.register("ancient_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BASALT =
            BLOCKS.register("ancient_polished_basalt", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> ANCIENT_CARVED_PUMPKIN =
            BLOCKS.register("ancient_carved_pumpkin", () -> new EquipableCarvedPumpkinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD).isValidSpawn(ModBlocks::always).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CAKE =
            BLOCKS.register("ancient_cake", () -> new CakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_REPEATER =
            BLOCKS.register("ancient_repeater", () -> new RepeaterBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return (boolean)false;
    }
    private static StainedGlassBlock stainedGlass(DyeColor pColor) {
        return new StainedGlassBlock(pColor, BlockBehaviour.Properties.of().mapColor(pColor).instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ModBlocks::never).isRedstoneConductor((state, getter, pos) -> false).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false));
    }
    public static final RegistryObject<Block> ANCIENT_WHITE_STAINED_GLASS =
            BLOCKS.register("ancient_white_stained_glass", () -> stainedGlass(DyeColor.WHITE));
    public static final RegistryObject<Block> ANCIENT_ORANGE_STAINED_GLASS =
            BLOCKS.register("ancient_orange_stained_glass", () -> stainedGlass(DyeColor.ORANGE));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_STAINED_GLASS =
            BLOCKS.register("ancient_magenta_stained_glass", () -> stainedGlass(DyeColor.MAGENTA));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_STAINED_GLASS =
            BLOCKS.register("ancient_light_blue_stained_glass", () -> stainedGlass(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> ANCIENT_YELLOW_STAINED_GLASS =
            BLOCKS.register("ancient_yellow_stained_glass", () -> stainedGlass(DyeColor.YELLOW));
    public static final RegistryObject<Block> ANCIENT_LIME_STAINED_GLASS =
            BLOCKS.register("ancient_lime_stained_glass", () -> stainedGlass(DyeColor.LIME));
    public static final RegistryObject<Block> ANCIENT_PINK_STAINED_GLASS =
            BLOCKS.register("ancient_pink_stained_glass", () -> stainedGlass(DyeColor.PINK));
    public static final RegistryObject<Block> ANCIENT_GRAY_STAINED_GLASS =
            BLOCKS.register("ancient_gray_stained_glass", () -> stainedGlass(DyeColor.GRAY));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_STAINED_GLASS =
            BLOCKS.register("ancient_light_gray_stained_glass", () -> stainedGlass(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> ANCIENT_CYAN_STAINED_GLASS =
            BLOCKS.register("ancient_cyan_stained_glass", () -> stainedGlass(DyeColor.CYAN));
    public static final RegistryObject<Block> ANCIENT_PURPLE_STAINED_GLASS =
            BLOCKS.register("ancient_purple_stained_glass", () -> stainedGlass(DyeColor.PURPLE));
    public static final RegistryObject<Block> ANCIENT_BLUE_STAINED_GLASS =
            BLOCKS.register("ancient_blue_stained_glass", () -> stainedGlass(DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_BROWN_STAINED_GLASS =
            BLOCKS.register("ancient_brown_stained_glass", () -> stainedGlass(DyeColor.BROWN));
    public static final RegistryObject<Block> ANCIENT_GREEN_STAINED_GLASS =
            BLOCKS.register("ancient_green_stained_glass", () -> stainedGlass(DyeColor.GREEN));
    public static final RegistryObject<Block> ANCIENT_RED_STAINED_GLASS =
            BLOCKS.register("ancient_red_stained_glass", () -> stainedGlass(DyeColor.RED));
    public static final RegistryObject<Block> ANCIENT_BLACK_STAINED_GLASS =
            BLOCKS.register("ancient_black_stained_glass", () -> stainedGlass(DyeColor.BLACK));
    public static final RegistryObject<Block> ANCIENT_OAK_TRAPDOOR =
            BLOCKS.register("ancient_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_TRAPDOOR =
            BLOCKS.register("ancient_spruce_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_TRAPDOOR =
            BLOCKS.register("ancient_birch_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_TRAPDOOR =
            BLOCKS.register("ancient_jungle_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_ACACIA_TRAPDOOR =
            BLOCKS.register("ancient_acacia_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_TRAPDOOR =
            BLOCKS.register("ancient_cherry_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_TRAPDOOR =
            BLOCKS.register("ancient_dark_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_TRAPDOOR =
            BLOCKS.register("ancient_mangrove_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_TRAPDOOR =
            BLOCKS.register("ancient_bamboo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICKS =
            BLOCKS.register("ancient_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE_BRICKS =
            BLOCKS.register("ancient_mossy_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_STONE_BRICKS =
            BLOCKS.register("ancient_cracked_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_STONE_BRICKS =
            BLOCKS.register("ancient_chiseled_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PACKED_MUD =
            BLOCKS.register("ancient_packed_mud", () -> new Block(BlockBehaviour.Properties.copy(DIRT).strength(1.0F, 3.0F).sound(SoundType.PACKED_MUD)));
    public static final RegistryObject<Block> ANCIENT_MUD_BRICKS =
            BLOCKS.register("ancient_mud_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_STONE =
            BLOCKS.register("ancient_infested_stone", () -> new InfestedBlock(STONE, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_COBBLESTONE =
            BLOCKS.register("ancient_infested_cobblestone", () -> new InfestedBlock(COBBLESTONE, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_STONE_BRICKS =
            BLOCKS.register("ancient_infested_stone_bricks", () -> new InfestedBlock(STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_MOSSY_STONE_BRICKS =
            BLOCKS.register("ancient_infested_mossy_stone_bricks", () -> new InfestedBlock(MOSSY_STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_CRACKED_STONE_BRICKS =
            BLOCKS.register("ancient_infested_cracked_stone_bricks", () -> new InfestedBlock(CRACKED_STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_CHISELED_STONE_BRICKS =
            BLOCKS.register("ancient_infested_chiseled_stone_bricks", () -> new InfestedBlock(CHISELED_STONE_BRICKS, BlockBehaviour.Properties.of().mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> ANCIENT_BROWN_MUSHROOM_BLOCK =
            BLOCKS.register("ancient_brown_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_MUSHROOM_BLOCK =
            BLOCKS.register("ancient_red_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MUSHROOM_STEM =
            BLOCKS.register("ancient_mushroom_stem", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_IRON_BARS =
            BLOCKS.register("ancient_iron_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_CHAIN =
            BLOCKS.register("ancient_chain", () -> new ChainBlock(BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_GLASS_PANE =
            BLOCKS.register("ancient_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_MELON =
            BLOCKS.register("ancient_melon", () -> new MelonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_VINE =
            BLOCKS.register("ancient_vine", () -> new VineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().randomTicks().strength(0.2F).sound(SoundType.VINE).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_GLOW_LICHEN =
            BLOCKS.register("ancient_glow_lichen", () -> new GlowLichenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GLOW_LICHEN).replaceable().noCollission().strength(0.2F).sound(SoundType.GLOW_LICHEN).lightLevel(GlowLichenBlock.emission(7)).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_OAK_FENCE_GATE =
            BLOCKS.register("ancient_oak_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(OAK_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.OAK));
    public static final RegistryObject<Block> ANCIENT_BRICK_STAIRS =
            BLOCKS.register("ancient_brick_stairs", () -> new StairBlock(BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(BRICKS)));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICK_STAIRS =
            BLOCKS.register("ancient_stone_brick_stairs", () -> new StairBlock(STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(STONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_MUD_BRICK_STAIRS =
            BLOCKS.register("ancient_mud_brick_stairs", () -> new StairBlock(MUD_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(MUD_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_MYCELIUM =
            BLOCKS.register("ancient_mycelium", () -> new MyceliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_LILY_PAD =
            BLOCKS.register("ancient_lily_pad", () -> new WaterlilyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.LILY_PAD).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_NETHER_BRICKS =
            BLOCKS.register("ancient_nether_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_NETHER_BRICK_FENCE =
            BLOCKS.register("ancient_nether_brick_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_NETHER_BRICK_STAIRS =
            BLOCKS.register("ancient_nether_brick_stairs", () -> new StairBlock(NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_NETHER_WART =
            BLOCKS.register("ancient_nether_wart", () -> new NetherWartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().sound(SoundType.NETHER_WART).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CAULDRON =
            BLOCKS.register("ancient_cauldron", () -> new CauldronBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_WATER_CAULDRON =
            BLOCKS.register("ancient_water_cauldron", () -> new LayeredCauldronBlock(BlockBehaviour.Properties.copy(CAULDRON), LayeredCauldronBlock.RAIN, CauldronInteraction.WATER));
    public static final RegistryObject<Block> ANCIENT_POWDER_SNOW_CAULDRON =
            BLOCKS.register("ancient_powder_snow_cauldron", () -> new PowderSnowCauldronBlock(BlockBehaviour.Properties.copy(CAULDRON), LayeredCauldronBlock.SNOW, CauldronInteraction.POWDER_SNOW));
    public static final RegistryObject<Block> ANCIENT_END_STONE =
            BLOCKS.register("ancient_end_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_LAMP =
            BLOCKS.register("ancient_redstone_lamp", () -> new RedstoneLampBlock(BlockBehaviour.Properties.of().lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.GLASS).isValidSpawn(ModBlocks::always)));
    public static final RegistryObject<Block> ANCIENT_COCOA =
            BLOCKS.register("ancient_cocoa", () -> new CocoaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().strength(0.2F, 3.0F).sound(SoundType.WOOD).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SANDSTONE_STAIRS =
            BLOCKS.register("ancient_sandstone_stairs", () -> new StairBlock(SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_EMERALD_ORE =
            BLOCKS.register("ancient_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_EMERALD_ORE =
            BLOCKS.register("ancient_deepslate_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(EMERALD_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ANCIENT_TRIPWIRE_HOOK =
            BLOCKS.register("ancient_tripwire_hook", () -> new TripWireHookBlock(BlockBehaviour.Properties.of().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TRIPWIRE =
            BLOCKS.register("ancient_tripwire", () -> new TripWireBlock((TripWireHookBlock)TRIPWIRE_HOOK, BlockBehaviour.Properties.of().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_EMERALD_BLOCK =
            BLOCKS.register("ancient_emerald_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_STAIRS =
            BLOCKS.register("ancient_spruce_stairs", () -> new StairBlock(SPRUCE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(SPRUCE_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_BIRCH_STAIRS =
            BLOCKS.register("ancient_birch_stairs", () -> new StairBlock(BIRCH_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(BIRCH_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_STAIRS =
            BLOCKS.register("ancient_jungle_stairs", () -> new StairBlock(JUNGLE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(JUNGLE_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_COMMAND_BLOCK =
            BLOCKS.register("ancient_command_block", () -> new CommandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).noLootTable(), false));
    public static final RegistryObject<Block> ANCIENT_COBBLESTONE_WALL =
            BLOCKS.register("ancient_cobblestone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLESTONE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_MOSSY_COBBLESTONE_WALL =
            BLOCKS.register("ancient_mossy_cobblestone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLESTONE).forceSolidOn()));
    private static FlowerPotBlock flowerPot(Block pContent, FeatureFlag... pRequiredFeatures) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (pRequiredFeatures.length > 0) {
            blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(pRequiredFeatures);
        }

        return new FlowerPotBlock(pContent, blockbehaviour$properties);
    }
    public static final RegistryObject<Block> ANCIENT_FLOWER_POT =
            BLOCKS.register("ancient_flower_pot", () -> flowerPot(AIR));
    public static final RegistryObject<Block> ANCIENT_POTTED_TORCHFLOWER =
            BLOCKS.register("ancient_potted_torchflower", () -> flowerPot(TORCHFLOWER));
    public static final RegistryObject<Block> ANCIENT_POTTED_OAK_SAPLING =
            BLOCKS.register("ancient_potted_oak_sapling", () -> flowerPot(OAK_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_SPRUCE_SAPLING =
            BLOCKS.register("ancient_potted_spruce_sapling", () -> flowerPot(SPRUCE_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_BIRCH_SAPLING =
            BLOCKS.register("ancient_potted_birch_sapling", () -> flowerPot(BIRCH_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_JUNGLE_SAPLING =
            BLOCKS.register("ancient_potted_jungle_sapling", () -> flowerPot(JUNGLE_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_ACACIA_SAPLING =
            BLOCKS.register("ancient_potted_acacia_sapling", () -> flowerPot(ACACIA_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_CHERRY_SAPLING =
            BLOCKS.register("ancient_potted_cherry_sapling", () -> flowerPot(CHERRY_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_DARK_OAK_SAPLING =
            BLOCKS.register("ancient_potted_dark_oak_sapling", () -> flowerPot(DARK_OAK_SAPLING));
    public static final RegistryObject<Block> ANCIENT_POTTED_MANGROVE_PROPAGULE =
            BLOCKS.register("ancient_potted_mangrove_propagule", () -> flowerPot(MANGROVE_PROPAGULE));
    public static final RegistryObject<Block> ANCIENT_POTTED_FERN =
            BLOCKS.register("ancient_potted_fern", () -> flowerPot(FERN));
    public static final RegistryObject<Block> ANCIENT_POTTED_DANDELION =
            BLOCKS.register("ancient_potted_dandelion", () -> flowerPot(DANDELION));
    public static final RegistryObject<Block> ANCIENT_POTTED_POPPY =
            BLOCKS.register("ancient_potted_poppy", () -> flowerPot(POPPY));
    public static final RegistryObject<Block> ANCIENT_POTTED_BLUE_ORCHID =
            BLOCKS.register("ancient_potted_blue_orchid", () -> flowerPot(BLUE_ORCHID));
    public static final RegistryObject<Block> ANCIENT_POTTED_ALLIUM =
            BLOCKS.register("ancient_potted_allium", () -> flowerPot(ALLIUM));
    public static final RegistryObject<Block> ANCIENT_POTTED_AZURE_BLUET =
            BLOCKS.register("ancient_potted_azure_bluet", () -> flowerPot(AZURE_BLUET));
    public static final RegistryObject<Block> ANCIENT_POTTED_RED_TULIP =
            BLOCKS.register("ancient_potted_red_tulip", () -> flowerPot(RED_TULIP));
    public static final RegistryObject<Block> ANCIENT_POTTED_ORANGE_TULIP =
            BLOCKS.register("ancient_potted_orange_tulip", () -> flowerPot(ORANGE_TULIP));
    public static final RegistryObject<Block> ANCIENT_POTTED_WHITE_TULIP =
            BLOCKS.register("ancient_potted_white_tulip", () -> flowerPot(WHITE_TULIP));
    public static final RegistryObject<Block> ANCIENT_POTTED_PINK_TULIP =
            BLOCKS.register("ancient_potted_pink_tulip", () -> flowerPot(PINK_TULIP));
    public static final RegistryObject<Block> ANCIENT_POTTED_OXEYE_DAISY =
            BLOCKS.register("ancient_potted_oxeye_daisy", () -> flowerPot(OXEYE_DAISY));
    public static final RegistryObject<Block> ANCIENT_POTTED_CORNFLOWER =
            BLOCKS.register("ancient_potted_cornflower", () -> flowerPot(CORNFLOWER));
    public static final RegistryObject<Block> ANCIENT_POTTED_LILY_OF_THE_VALLEY =
            BLOCKS.register("ancient_potted_lily_of_the_valley", () -> flowerPot(LILY_OF_THE_VALLEY));
    public static final RegistryObject<Block> ANCIENT_POTTED_WITHER_ROSE =
            BLOCKS.register("ancient_potted_wither_rose", () -> flowerPot(WITHER_ROSE));
    public static final RegistryObject<Block> ANCIENT_POTTED_RED_MUSHROOM =
            BLOCKS.register("ancient_potted_red_mushroom", () -> flowerPot(RED_MUSHROOM));
    public static final RegistryObject<Block> ANCIENT_POTTED_BROWN_MUSHROOM =
            BLOCKS.register("ancient_potted_brown_mushroom", () -> flowerPot(BROWN_MUSHROOM));
    public static final RegistryObject<Block> ANCIENT_POTTED_DEAD_BUSH =
            BLOCKS.register("ancient_potted_dead_bush", () -> flowerPot(DEAD_BUSH));
    public static final RegistryObject<Block> ANCIENT_POTTED_CACTUS =
            BLOCKS.register("ancient_potted_cactus", () -> flowerPot(CACTUS));
    public static final RegistryObject<Block> ANCIENT_CARROTS =
            BLOCKS.register("ancient_carrots", () -> new CarrotBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_POTATOES =
            BLOCKS.register("ancient_potatoes", () -> new PotatoBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    private static ButtonBlock woodenButton(BlockSetType pSetType, FeatureFlag... pRequiredFeatures) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (pRequiredFeatures.length > 0) {
            blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(pRequiredFeatures);
        }

        return new ButtonBlock(blockbehaviour$properties, pSetType, 30, true);
    }
    public static final RegistryObject<Block> ANCIENT_OAK_BUTTON =
            BLOCKS.register("ancient_oak_button", () -> woodenButton(BlockSetType.OAK));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_BUTTON =
            BLOCKS.register("ancient_spruce_button", () -> woodenButton(BlockSetType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_BUTTON =
            BLOCKS.register("ancient_birch_button", () -> woodenButton(BlockSetType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_BUTTON =
            BLOCKS.register("ancient_jungle_button", () -> woodenButton(BlockSetType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_ACACIA_BUTTON =
            BLOCKS.register("ancient_acacia_button", () -> woodenButton(BlockSetType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_BUTTON =
            BLOCKS.register("ancient_cherry_button", () -> woodenButton(BlockSetType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_BUTTON =
            BLOCKS.register("ancient_dark_oak_button", () -> woodenButton(BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_BUTTON =
            BLOCKS.register("ancient_mangrove_button", () -> woodenButton(BlockSetType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_BUTTON =
            BLOCKS.register("ancient_bamboo_button", () -> woodenButton(BlockSetType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_SKELETON_SKULL =
            BLOCKS.register("ancient_skeleton_skull", () -> new SkullBlock(SkullBlock.Types.SKELETON, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.SKELETON).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SKELETON_WALL_SKULL =
            BLOCKS.register("ancient_skeleton_wall_skull", () -> new WallSkullBlock(SkullBlock.Types.SKELETON, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(SKELETON_SKULL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WITHER_SKELETON_SKULL =
            BLOCKS.register("ancient_wither_skeleton_skull", () -> new WitherSkullBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.WITHER_SKELETON).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WITHER_SKELETON_WALL_SKULL =
            BLOCKS.register("ancient_wither_skeleton_wall_skull", () -> new WitherWallSkullBlock(BlockBehaviour.Properties.of().strength(1.0F).dropsLike(WITHER_SKELETON_SKULL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ZOMBIE_HEAD =
            BLOCKS.register("ancient_zombie_head", () -> new SkullBlock(SkullBlock.Types.ZOMBIE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.ZOMBIE).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ZOMBIE_WALL_HEAD =
            BLOCKS.register("ancient_zombie_wall_head", () -> new WallSkullBlock(SkullBlock.Types.ZOMBIE, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(ZOMBIE_HEAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PLAYER_HEAD =
            BLOCKS.register("ancient_player_head", () -> new PlayerHeadBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CUSTOM_HEAD).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PLAYER_WALL_HEAD =
            BLOCKS.register("ancient_player_wall_head", () -> new PlayerWallHeadBlock(BlockBehaviour.Properties.of().strength(1.0F).dropsLike(PLAYER_HEAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CREEPER_HEAD =
            BLOCKS.register("ancient_creeper_head", () -> new SkullBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.CREEPER).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CREEPER_WALL_HEAD =
            BLOCKS.register("ancient_creeper_wall_head", () -> new WallSkullBlock(SkullBlock.Types.CREEPER, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(CREEPER_HEAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DRAGON_HEAD =
            BLOCKS.register("ancient_dragon_head", () -> new SkullBlock(SkullBlock.Types.DRAGON, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.DRAGON).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DRAGON_WALL_HEAD =
            BLOCKS.register("ancient_dragon_wall_head", () -> new WallSkullBlock(SkullBlock.Types.DRAGON, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(DRAGON_HEAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PIGLIN_HEAD =
            BLOCKS.register("ancient_piglin_head", () -> new SkullBlock(SkullBlock.Types.PIGLIN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.PIGLIN).strength(1.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PIGLIN_WALL_HEAD =
            BLOCKS.register("ancient_piglin_wall_head", () -> new PiglinWallSkullBlock(BlockBehaviour.Properties.of().strength(1.0F).dropsLike(PIGLIN_HEAD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ANVIL =
            BLOCKS.register("ancient_anvil", () -> new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_CHIPPED_ANVIL =
            BLOCKS.register("ancient_chipped_anvil", () -> new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_DAMAGED_ANVIL =
            BLOCKS.register("ancient_damaged_anvil", () -> new AnvilBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 1200.0F).sound(SoundType.ANVIL).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_TRAPPED_CHEST =
            BLOCKS.register("ancient_trapped_chest", () -> new TrappedChestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_WEIGHTED_PRESSURE_PLATE =
            BLOCKS.register("ancient_light_weighted_pressure_plate", () -> new WeightedPressurePlateBlock(15, BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn().requiresCorrectToolForDrops().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.GOLD));
    public static final RegistryObject<Block> ANCIENT_HEAVY_WEIGHTED_PRESSURE_PLATE =
            BLOCKS.register("ancient_heavy_weighted_pressure_plate", () -> new WeightedPressurePlateBlock(150, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().requiresCorrectToolForDrops().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.IRON));
    public static final RegistryObject<Block> ANCIENT_COMPARATOR =
            BLOCKS.register("ancient_comparator", () -> new ComparatorBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DAYLIGHT_DETECTOR =
            BLOCKS.register("ancient_daylight_detector", () -> new DaylightDetectorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_REDSTONE_BLOCK =
            BLOCKS.register("ancient_redstone_block", () -> new PoweredBlock(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_NETHER_QUARTZ_ORE =
            BLOCKS.register("ancient_nether_quartz_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.NETHER_ORE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> ANCIENT_HOPPER =
            BLOCKS.register("ancient_hopper", () -> new HopperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 4.8F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_QUARTZ_BLOCK =
            BLOCKS.register("ancient_quartz_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_QUARTZ_BLOCK =
            BLOCKS.register("ancient_chiseled_quartz_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_QUARTZ_PILLAR =
            BLOCKS.register("ancient_quartz_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_QUARTZ_STAIRS =
            BLOCKS.register("ancient_quartz_stairs", () -> new StairBlock(QUARTZ_BLOCK.defaultBlockState(), BlockBehaviour.Properties.copy(QUARTZ_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_ACTIVATOR_RAIL =
            BLOCKS.register("ancient_activator_rail", () -> new PoweredRailBlock(BlockBehaviour.Properties.of().noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ANCIENT_DROPPER =
            BLOCKS.register("ancient_dropper", () -> new DropperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F)));
    public static final RegistryObject<Block> ANCIENT_WHITE_TERRACOTTA =
            BLOCKS.register("ancient_white_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_TERRACOTTA =
            BLOCKS.register("ancient_orange_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_TERRACOTTA =
            BLOCKS.register("ancient_magenta_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_TERRACOTTA =
            BLOCKS.register("ancient_light_blue_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_TERRACOTTA =
            BLOCKS.register("ancient_yellow_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_LIME_TERRACOTTA =
            BLOCKS.register("ancient_lime_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_PINK_TERRACOTTA =
            BLOCKS.register("ancient_pink_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_GRAY_TERRACOTTA =
            BLOCKS.register("ancient_gray_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_TERRACOTTA =
            BLOCKS.register("ancient_light_gray_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_CYAN_TERRACOTTA =
            BLOCKS.register("ancient_cyan_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_TERRACOTTA =
            BLOCKS.register("ancient_purple_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_BLUE_TERRACOTTA =
            BLOCKS.register("ancient_blue_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_BROWN_TERRACOTTA =
            BLOCKS.register("ancient_brown_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_GREEN_TERRACOTTA =
            BLOCKS.register("ancient_green_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_RED_TERRACOTTA =
            BLOCKS.register("ancient_red_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_BLACK_TERRACOTTA =
            BLOCKS.register("ancient_black_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_WHITE_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_white_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_ORANGE_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_orange_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_magenta_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_light_blue_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_YELLOW_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_yellow_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_LIME_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_lime_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIME, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_PINK_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_pink_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.PINK, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_GRAY_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_gray_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_light_gray_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_CYAN_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_cyan_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_PURPLE_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_purple_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_BLUE_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_blue_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_BROWN_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_brown_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_GREEN_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_green_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_RED_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_red_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.RED, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_BLACK_STAINED_GLASS_PANE =
            BLOCKS.register("ancient_black_stained_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_ACACIA_STAIRS =
            BLOCKS.register("ancient_acacia_stairs", () -> new StairBlock(ACACIA_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(ACACIA_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_CHERRY_STAIRS =
            BLOCKS.register("ancient_cherry_stairs", () -> new StairBlock(CHERRY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(CHERRY_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_STAIRS =
            BLOCKS.register("ancient_dark_oak_stairs", () -> new StairBlock(DARK_OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_STAIRS =
            BLOCKS.register("ancient_mangrove_stairs", () -> new StairBlock(MANGROVE_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(MANGROVE_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_STAIRS =
            BLOCKS.register("ancient_bamboo_stairs", () -> new StairBlock(BAMBOO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(BAMBOO_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_MOSAIC_STAIRS =
            BLOCKS.register("ancient_bamboo_mosaic_stairs", () -> new StairBlock(BAMBOO_MOSAIC.defaultBlockState(), BlockBehaviour.Properties.copy(BAMBOO_MOSAIC)));
    public static final RegistryObject<Block> ANCIENT_SLIME_BLOCK =
            BLOCKS.register("ancient_slime_block", () -> new SlimeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).friction(0.8F).sound(SoundType.SLIME_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_BARRIER =
            BLOCKS.register("ancient_barrier", () -> new BarrierBlock(BlockBehaviour.Properties.of().strength(-1.0F, 3600000.8F).noLootTable().noOcclusion().isValidSpawn(ModBlocks::never).noParticlesOnBreak().pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_LIGHT =
            BLOCKS.register("ancient_light", () -> new LightBlock(BlockBehaviour.Properties.of().replaceable().strength(-1.0F, 3600000.8F).noLootTable().noOcclusion().lightLevel(LightBlock.LIGHT_EMISSION)));
    public static final RegistryObject<Block> ANCIENT_IRON_TRAPDOOR =
            BLOCKS.register("ancient_iron_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F).noOcclusion().isValidSpawn(ModBlocks::never), BlockSetType.IRON));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE =
            BLOCKS.register("ancient_prismarine", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_BRICKS =
            BLOCKS.register("ancient_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DARK_PRISMARINE =
            BLOCKS.register("ancient_dark_prismarine", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_STAIRS =
            BLOCKS.register("ancient_prismarine_stairs", () -> new StairBlock(PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(PRISMARINE)));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_BRICK_STAIRS =
            BLOCKS.register("ancient_prismarine_brick_stairs", () -> new StairBlock(PRISMARINE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(PRISMARINE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_DARK_PRISMARINE_STAIRS =
            BLOCKS.register("ancient_dark_prismarine_stairs", () -> new StairBlock(DARK_PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(DARK_PRISMARINE)));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_SLAB =
            BLOCKS.register("ancient_prismarine_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_BRICK_SLAB =
            BLOCKS.register("ancient_prismarine_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DARK_PRISMARINE_SLAB =
            BLOCKS.register("ancient_dark_prismarine_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_HAY_BLOCK =
            BLOCKS.register("ancient_hay_block", () -> new HayBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BANJO).strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_WHITE_CARPET =
            BLOCKS.register("ancient_white_carpet", () -> new WoolCarpetBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ORANGE_CARPET =
            BLOCKS.register("ancient_orange_carpet", () -> new WoolCarpetBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_CARPET =
            BLOCKS.register("ancient_magenta_carpet", () -> new WoolCarpetBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_CARPET =
            BLOCKS.register("ancient_light_blue_carpet", () -> new WoolCarpetBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_YELLOW_CARPET =
            BLOCKS.register("ancient_yellow_carpet", () -> new WoolCarpetBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIME_CARPET =
            BLOCKS.register("ancient_lime_carpet", () -> new WoolCarpetBlock(DyeColor.LIME, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PINK_CARPET =
            BLOCKS.register("ancient_pink_carpet", () -> new WoolCarpetBlock(DyeColor.PINK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GRAY_CARPET =
            BLOCKS.register("ancient_gray_carpet", () -> new WoolCarpetBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_CARPET =
            BLOCKS.register("ancient_light_gray_carpet", () -> new WoolCarpetBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CYAN_CARPET =
            BLOCKS.register("ancient_cyan_carpet", () -> new WoolCarpetBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PURPLE_CARPET =
            BLOCKS.register("ancient_purple_carpet", () -> new WoolCarpetBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLUE_CARPET =
            BLOCKS.register("ancient_blue_carpet", () -> new WoolCarpetBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BROWN_CARPET =
            BLOCKS.register("ancient_brown_carpet", () -> new WoolCarpetBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GREEN_CARPET =
            BLOCKS.register("ancient_green_carpet", () -> new WoolCarpetBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_CARPET =
            BLOCKS.register("ancient_red_carpet", () -> new WoolCarpetBlock(DyeColor.RED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLACK_CARPET =
            BLOCKS.register("ancient_black_carpet", () -> new WoolCarpetBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(0.1F).sound(SoundType.WOOL).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_TERRACOTTA =
            BLOCKS.register("ancient_terracotta", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F)));
    public static final RegistryObject<Block> ANCIENT_COAL_BLOCK =
            BLOCKS.register("ancient_coal_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PACKED_ICE =
            BLOCKS.register("ancient_packed_ice", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).instrument(NoteBlockInstrument.CHIME).friction(0.98F).strength(0.5F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ANCIENT_SUNFLOWER =
            BLOCKS.register("ancient_sunflower", () -> new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_LILAC =
            BLOCKS.register("ancient_lilac", () -> new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ROSE_BUSH =
            BLOCKS.register("ancient_rose_bush", () -> new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PEONY =
            BLOCKS.register("ancient_peony", () -> new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TALL_GRASS =
            BLOCKS.register("ancient_tall_grass", () -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_LARGE_FERN =
            BLOCKS.register("ancient_large_fern", () -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WHITE_BANNER =
            BLOCKS.register("ancient_white_banner", () -> new BannerBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ORANGE_BANNER =
            BLOCKS.register("ancient_orange_banner", () -> new BannerBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_BANNER =
            BLOCKS.register("ancient_magenta_banner", () -> new BannerBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_BANNER =
            BLOCKS.register("ancient_light_blue_banner", () -> new BannerBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_YELLOW_BANNER =
            BLOCKS.register("ancient_yellow_banner", () -> new BannerBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIME_BANNER =
            BLOCKS.register("ancient_lime_banner", () -> new BannerBlock(DyeColor.LIME, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PINK_BANNER =
            BLOCKS.register("ancient_pink_banner", () -> new BannerBlock(DyeColor.PINK, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GRAY_BANNER =
            BLOCKS.register("ancient_gray_banner", () -> new BannerBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_BANNER =
            BLOCKS.register("ancient_light_gray_banner", () -> new BannerBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CYAN_BANNER =
            BLOCKS.register("ancient_cyan_banner", () -> new BannerBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PURPLE_BANNER =
            BLOCKS.register("ancient_purple_banner", () -> new BannerBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLUE_BANNER =
            BLOCKS.register("ancient_blue_banner", () -> new BannerBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BROWN_BANNER =
            BLOCKS.register("ancient_brown_banner", () -> new BannerBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GREEN_BANNER =
            BLOCKS.register("ancient_green_banner", () -> new BannerBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_BANNER =
            BLOCKS.register("ancient_red_banner", () -> new BannerBlock(DyeColor.RED, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLACK_BANNER =
            BLOCKS.register("ancient_black_banner", () -> new BannerBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_WHITE_WALL_BANNER =
            BLOCKS.register("ancient_white_wall_banner", () -> new WallBannerBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(WHITE_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ORANGE_WALL_BANNER =
            BLOCKS.register("ancient_orange_wall_banner", () -> new WallBannerBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(ORANGE_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_WALL_BANNER =
            BLOCKS.register("ancient_magenta_wall_banner", () -> new WallBannerBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(MAGENTA_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_WALL_BANNER =
            BLOCKS.register("ancient_light_blue_wall_banner", () -> new WallBannerBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(LIGHT_BLUE_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_YELLOW_WALL_BANNER =
            BLOCKS.register("ancient_yellow_wall_banner", () -> new WallBannerBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(YELLOW_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIME_WALL_BANNER =
            BLOCKS.register("ancient_lime_wall_banner", () -> new WallBannerBlock(DyeColor.LIME, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(LIME_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PINK_WALL_BANNER =
            BLOCKS.register("ancient_pink_wall_banner", () -> new WallBannerBlock(DyeColor.PINK, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(PINK_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GRAY_WALL_BANNER =
            BLOCKS.register("ancient_gray_wall_banner", () -> new WallBannerBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(GRAY_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_WALL_BANNER =
            BLOCKS.register("ancient_light_gray_wall_banner", () -> new WallBannerBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(LIGHT_GRAY_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CYAN_WALL_BANNER =
            BLOCKS.register("ancient_cyan_wall_banner", () -> new WallBannerBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(CYAN_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_PURPLE_WALL_BANNER =
            BLOCKS.register("ancient_purple_wall_banner", () -> new WallBannerBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(PURPLE_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLUE_WALL_BANNER =
            BLOCKS.register("ancient_blue_wall_banner", () -> new WallBannerBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(BLUE_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BROWN_WALL_BANNER =
            BLOCKS.register("ancient_brown_wall_banner", () -> new WallBannerBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(BROWN_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GREEN_WALL_BANNER =
            BLOCKS.register("ancient_green_wall_banner", () -> new WallBannerBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(GREEN_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_WALL_BANNER =
            BLOCKS.register("ancient_red_wall_banner", () -> new WallBannerBlock(DyeColor.RED, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(RED_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BLACK_WALL_BANNER =
            BLOCKS.register("ancient_black_wall_banner", () -> new WallBannerBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(BLACK_BANNER).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_RED_SANDSTONE =
            BLOCKS.register("ancient_red_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_RED_SANDSTONE =
            BLOCKS.register("ancient_chiseled_red_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_CUT_RED_SANDSTONE =
            BLOCKS.register("ancient_cut_red_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    public static final RegistryObject<Block> ANCIENT_RED_SANDSTONE_STAIRS =
            BLOCKS.register("ancient_red_sandstone_stairs", () -> new StairBlock(RED_SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(RED_SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_OAK_SLAB =
            BLOCKS.register("ancient_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_SLAB =
            BLOCKS.register("ancient_spruce_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BIRCH_SLAB =
            BLOCKS.register("ancient_birch_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_SLAB =
            BLOCKS.register("ancient_jungle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_ACACIA_SLAB =
            BLOCKS.register("ancient_acacia_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_CHERRY_SLAB =
            BLOCKS.register("ancient_cherry_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.CHERRY_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_SLAB =
            BLOCKS.register("ancient_dark_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_SLAB =
            BLOCKS.register("ancient_mangrove_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_SLAB =
            BLOCKS.register("ancient_bamboo_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.BAMBOO_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_MOSAIC_SLAB =
            BLOCKS.register("ancient_bamboo_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.BAMBOO_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STONE_SLAB =
            BLOCKS.register("ancient_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_STONE_SLAB =
            BLOCKS.register("ancient_smooth_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SANDSTONE_SLAB =
            BLOCKS.register("ancient_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CUT_SANDSTONE_SLAB =
            BLOCKS.register("ancient_cut_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PETRIFIED_OAK_SLAB =
            BLOCKS.register("ancient_petrified_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_COBBLESTONE_SLAB =
            BLOCKS.register("ancient_cobblestone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_BRICK_SLAB =
            BLOCKS.register("ancient_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICK_SLAB =
            BLOCKS.register("ancient_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_MUD_BRICK_SLAB =
            BLOCKS.register("ancient_mud_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_NETHER_BRICK_SLAB =
            BLOCKS.register("ancient_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_QUARTZ_SLAB =
            BLOCKS.register("ancient_quartz_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_RED_SANDSTONE_SLAB =
            BLOCKS.register("ancient_red_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CUT_RED_SANDSTONE_SLAB =
            BLOCKS.register("ancient_cut_red_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PURPUR_SLAB =
            BLOCKS.register("ancient_purpur_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_STONE =
            BLOCKS.register("ancient_smooth_stone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_SANDSTONE =
            BLOCKS.register("ancient_smooth_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_QUARTZ =
            BLOCKS.register("ancient_smooth_quartz", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_RED_SANDSTONE =
            BLOCKS.register("ancient_smooth_red_sandstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_FENCE_GATE =
            BLOCKS.register("ancient_spruce_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_FENCE_GATE =
            BLOCKS.register("ancient_birch_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(BIRCH_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_FENCE_GATE =
            BLOCKS.register("ancient_jungle_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_ACACIA_FENCE_GATE =
            BLOCKS.register("ancient_acacia_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(ACACIA_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_FENCE_GATE =
            BLOCKS.register("ancient_cherry_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_FENCE_GATE =
            BLOCKS.register("ancient_dark_oak_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_FENCE_GATE =
            BLOCKS.register("ancient_mangrove_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_FENCE_GATE =
            BLOCKS.register("ancient_bamboo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_FENCE =
            BLOCKS.register("ancient_spruce_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_BIRCH_FENCE =
            BLOCKS.register("ancient_birch_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(BIRCH_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_FENCE =
            BLOCKS.register("ancient_jungle_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_ACACIA_FENCE =
            BLOCKS.register("ancient_acacia_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(ACACIA_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_CHERRY_FENCE =
            BLOCKS.register("ancient_cherry_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.CHERRY_WOOD)));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_FENCE =
            BLOCKS.register("ancient_dark_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_FENCE =
            BLOCKS.register("ancient_mangrove_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_FENCE =
            BLOCKS.register("ancient_bamboo_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.BAMBOO_WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SPRUCE_DOOR =
            BLOCKS.register("ancient_spruce_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(SPRUCE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> ANCIENT_BIRCH_DOOR =
            BLOCKS.register("ancient_birch_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(BIRCH_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.BIRCH));
    public static final RegistryObject<Block> ANCIENT_JUNGLE_DOOR =
            BLOCKS.register("ancient_jungle_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(JUNGLE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.JUNGLE));
    public static final RegistryObject<Block> ANCIENT_ACACIA_DOOR =
            BLOCKS.register("ancient_acacia_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(ACACIA_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.ACACIA));
    public static final RegistryObject<Block> ANCIENT_CHERRY_DOOR =
            BLOCKS.register("ancient_cherry_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.CHERRY));
    public static final RegistryObject<Block> ANCIENT_DARK_OAK_DOOR =
            BLOCKS.register("ancient_dark_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(DARK_OAK_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> ANCIENT_MANGROVE_DOOR =
            BLOCKS.register("ancient_mangrove_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MANGROVE_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.MANGROVE));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_DOOR =
            BLOCKS.register("ancient_bamboo_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(BAMBOO_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> ANCIENT_CHORUS_PLANT =
            BLOCKS.register("ancient_chorus_plant", () -> new ChorusPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).forceSolidOff().strength(0.4F).sound(SoundType.WOOD).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CHORUS_FLOWER =
            BLOCKS.register("ancient_chorus_flower", () -> new ChorusFlowerBlock((ChorusPlantBlock)CHORUS_PLANT, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).forceSolidOff().randomTicks().strength(0.4F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(ModBlocks::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_PURPUR_BLOCK =
            BLOCKS.register("ancient_purpur_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PURPUR_PILLAR =
            BLOCKS.register("ancient_purpur_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_PURPUR_STAIRS =
            BLOCKS.register("ancient_purpur_stairs", () -> new StairBlock(PURPUR_BLOCK.defaultBlockState(), BlockBehaviour.Properties.copy(PURPUR_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_END_STONE_BRICKS =
            BLOCKS.register("ancient_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 9.0F)));
    public static final RegistryObject<Block> ANCIENT_TORCHFLOWER_CROP =
            BLOCKS.register("ancient_torchflower_crop", () -> new TorchflowerCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PITCHER_CROP =
            BLOCKS.register("ancient_pitcher_crop", () -> new PitcherCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PITCHER_PLANT =
            BLOCKS.register("ancient_pitcher_plant", () -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BEETROOTS =
            BLOCKS.register("ancient_beetroots", () -> new BeetrootBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DIRT_PATH =
            BLOCKS.register("ancient_dirt_path", () -> new DirtPathBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.65F).sound(SoundType.GRASS).isViewBlocking((state, getter, pos) -> true).isSuffocating((state, getter, pos) -> true)));
    public static final RegistryObject<Block> ANCIENT_REPEATING_COMMAND_BLOCK =
            BLOCKS.register("ancient_repeating_command_block", () -> new CommandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).noLootTable(), false));
    public static final RegistryObject<Block> ANCIENT_CHAIN_COMMAND_BLOCK =
            BLOCKS.register("ancient_chain_command_block", () -> new CommandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).noLootTable(), true));
    public static final RegistryObject<Block> ANCIENT_NETHER_WART_BLOCK =
            BLOCKS.register("ancient_nether_wart_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(1.0F).sound(SoundType.WART_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_RED_NETHER_BRICKS =
            BLOCKS.register("ancient_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_BONE_BLOCK =
            BLOCKS.register("ancient_bone_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.XYLOPHONE).requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_STRUCTURE_VOID =
            BLOCKS.register("ancient_structure_void", () -> new StructureVoidBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().noParticlesOnBreak().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_OBSERVER =
            BLOCKS.register("ancient_observer", () -> new ObserverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(3.0F).requiresCorrectToolForDrops().isRedstoneConductor((state, getter, pos) -> false)));
    private static ShulkerBoxBlock shulkerBox(DyeColor pColor, BlockBehaviour.Properties pProperties) {
        BlockBehaviour.StatePredicate blockbehaviour$statepredicate = (p_278209_, p_278210_, p_278211_) -> {
            BlockEntity blockentity = p_278210_.getBlockEntity(p_278211_);
            if (blockentity instanceof ShulkerBoxBlockEntity shulkerboxblockentity) {
                return shulkerboxblockentity.isClosed();
            } else {
                return true;
            }
        };
        return new ShulkerBoxBlock(pColor, pProperties.forceSolidOn().strength(2.0F).dynamicShape().noOcclusion().isSuffocating(blockbehaviour$statepredicate).isViewBlocking(blockbehaviour$statepredicate).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> true));
    }
    public static final RegistryObject<Block> ANCIENT_SHULKER_BOX =
            BLOCKS.register("ancient_shulker_box", () -> shulkerBox((DyeColor)null, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> ANCIENT_WHITE_SHULKER_BOX =
            BLOCKS.register("ancient_white_shulker_box", () -> shulkerBox(DyeColor.WHITE, BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_SHULKER_BOX =
            BLOCKS.register("ancient_orange_shulker_box", () -> shulkerBox(DyeColor.ORANGE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_SHULKER_BOX =
            BLOCKS.register("ancient_magenta_shulker_box", () -> shulkerBox(DyeColor.MAGENTA, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_SHULKER_BOX =
            BLOCKS.register("ancient_light_blue_shulker_box", () -> shulkerBox(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_SHULKER_BOX =
            BLOCKS.register("ancient_yellow_shulker_box", () -> shulkerBox(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> ANCIENT_LIME_SHULKER_BOX =
            BLOCKS.register("ancient_lime_shulker_box", () -> shulkerBox(DyeColor.LIME, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> ANCIENT_PINK_SHULKER_BOX =
            BLOCKS.register("ancient_pink_shulker_box", () -> shulkerBox(DyeColor.PINK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> ANCIENT_GRAY_SHULKER_BOX =
            BLOCKS.register("ancient_gray_shulker_box", () -> shulkerBox(DyeColor.GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_SHULKER_BOX =
            BLOCKS.register("ancient_light_gray_shulker_box", () -> shulkerBox(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> ANCIENT_CYAN_SHULKER_BOX =
            BLOCKS.register("ancient_cyan_shulker_box", () -> shulkerBox(DyeColor.CYAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_SHULKER_BOX =
            BLOCKS.register("ancient_purple_shulker_box", () -> shulkerBox(DyeColor.PURPLE, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final RegistryObject<Block> ANCIENT_BLUE_SHULKER_BOX =
            BLOCKS.register("ancient_blue_shulker_box", () -> shulkerBox(DyeColor.BLUE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> ANCIENT_BROWN_SHULKER_BOX =
            BLOCKS.register("ancient_brown_shulker_box", () -> shulkerBox(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> ANCIENT_GREEN_SHULKER_BOX =
            BLOCKS.register("ancient_green_shulker_box", () -> shulkerBox(DyeColor.GREEN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> ANCIENT_RED_SHULKER_BOX =
            BLOCKS.register("ancient_red_shulker_box", () -> shulkerBox(DyeColor.RED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ANCIENT_BLACK_SHULKER_BOX =
            BLOCKS.register("ancient_black_shulker_box", () -> shulkerBox(DyeColor.BLACK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> ANCIENT_WHITE_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_white_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_orange_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_magenta_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_light_blue_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_yellow_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_LIME_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_lime_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_PINK_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_pink_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_GRAY_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_gray_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_light_gray_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_CYAN_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_cyan_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_purple_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_BLUE_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_blue_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_BROWN_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_brown_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_GREEN_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_green_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_RED_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_red_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_BLACK_GLAZED_TERRACOTTA =
            BLOCKS.register("ancient_black_glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY)));
    public static final RegistryObject<Block> ANCIENT_WHITE_CONCRETE =
            BLOCKS.register("ancient_white_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_CONCRETE =
            BLOCKS.register("ancient_orange_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_CONCRETE =
            BLOCKS.register("ancient_magenta_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_CONCRETE =
            BLOCKS.register("ancient_light_blue_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_CONCRETE =
            BLOCKS.register("ancient_yellow_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_LIME_CONCRETE =
            BLOCKS.register("ancient_lime_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_PINK_CONCRETE =
            BLOCKS.register("ancient_pink_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_GRAY_CONCRETE =
            BLOCKS.register("ancient_gray_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_CONCRETE =
            BLOCKS.register("ancient_light_gray_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_CYAN_CONCRETE =
            BLOCKS.register("ancient_cyan_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_CONCRETE =
            BLOCKS.register("ancient_purple_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_BLUE_CONCRETE =
            BLOCKS.register("ancient_blue_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_BROWN_CONCRETE =
            BLOCKS.register("ancient_brown_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_GREEN_CONCRETE =
            BLOCKS.register("ancient_green_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_RED_CONCRETE =
            BLOCKS.register("ancient_red_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_BLACK_CONCRETE =
            BLOCKS.register("ancient_black_concrete", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F)));
    public static final RegistryObject<Block> ANCIENT_WHITE_CONCRETE_POWDER =
            BLOCKS.register("ancient_white_concrete_powder", () -> new ConcretePowderBlock(WHITE_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_CONCRETE_POWDER =
            BLOCKS.register("ancient_orange_concrete_powder", () -> new ConcretePowderBlock(ORANGE_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_CONCRETE_POWDER =
            BLOCKS.register("ancient_magenta_concrete_powder", () -> new ConcretePowderBlock(MAGENTA_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_CONCRETE_POWDER =
            BLOCKS.register("ancient_light_blue_concrete_powder", () -> new ConcretePowderBlock(LIGHT_BLUE_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_CONCRETE_POWDER =
            BLOCKS.register("ancient_yellow_concrete_powder", () -> new ConcretePowderBlock(YELLOW_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_LIME_CONCRETE_POWDER =
            BLOCKS.register("ancient_lime_concrete_powder", () -> new ConcretePowderBlock(LIME_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_PINK_CONCRETE_POWDER =
            BLOCKS.register("ancient_pink_concrete_powder", () -> new ConcretePowderBlock(PINK_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_GRAY_CONCRETE_POWDER =
            BLOCKS.register("ancient_gray_concrete_powder", () -> new ConcretePowderBlock(GRAY_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_CONCRETE_POWDER =
            BLOCKS.register("ancient_light_gray_concrete_powder", () -> new ConcretePowderBlock(LIGHT_GRAY_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_CYAN_CONCRETE_POWDER =
            BLOCKS.register("ancient_cyan_concrete_powder", () -> new ConcretePowderBlock(CYAN_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_CONCRETE_POWDER =
            BLOCKS.register("ancient_purple_concrete_powder", () -> new ConcretePowderBlock(PURPLE_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_BLUE_CONCRETE_POWDER =
            BLOCKS.register("ancient_blue_concrete_powder", () -> new ConcretePowderBlock(BLUE_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_BROWN_CONCRETE_POWDER =
            BLOCKS.register("ancient_brown_concrete_powder", () -> new ConcretePowderBlock(BROWN_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_GREEN_CONCRETE_POWDER =
            BLOCKS.register("ancient_green_concrete_powder", () -> new ConcretePowderBlock(GREEN_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_RED_CONCRETE_POWDER =
            BLOCKS.register("ancient_red_concrete_powder", () -> new ConcretePowderBlock(RED_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_BLACK_CONCRETE_POWDER =
            BLOCKS.register("ancient_black_concrete_powder", () -> new ConcretePowderBlock(BLACK_CONCRETE, BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> ANCIENT_KELP =
            BLOCKS.register("ancient_kelp", () -> new KelpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_KELP_PLANT =
            BLOCKS.register("ancient_kelp_plant", () -> new KelpPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DRIED_KELP_BLOCK =
            BLOCKS.register("ancient_dried_kelp_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.5F, 2.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_TURTLE_EGG =
            BLOCKS.register("ancient_turtle_egg", () -> new TurtleEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).forceSolidOn().strength(0.5F).sound(SoundType.METAL).randomTicks().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SNIFFER_EGG =
            BLOCKS.register("ancient_sniffer_egg", () -> new SnifferEggBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.5F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_DEAD_TUBE_CORAL_BLOCK =
            BLOCKS.register("ancient_dead_tube_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DEAD_BRAIN_CORAL_BLOCK =
            BLOCKS.register("ancient_dead_brain_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DEAD_BUBBLE_CORAL_BLOCK =
            BLOCKS.register("ancient_dead_bubble_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DEAD_FIRE_CORAL_BLOCK =
            BLOCKS.register("ancient_dead_fire_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_DEAD_HORN_CORAL_BLOCK =
            BLOCKS.register("ancient_dead_horn_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_TUBE_CORAL_BLOCK =
            BLOCKS.register("ancient_tube_coral_block", () -> new CoralBlock(DEAD_TUBE_CORAL_BLOCK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_BRAIN_CORAL_BLOCK =
            BLOCKS.register("ancient_brain_coral_block", () -> new CoralBlock(DEAD_BRAIN_CORAL_BLOCK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_BUBBLE_CORAL_BLOCK =
            BLOCKS.register("ancient_bubble_coral_block", () -> new CoralBlock(DEAD_BUBBLE_CORAL_BLOCK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_FIRE_CORAL_BLOCK =
            BLOCKS.register("ancient_fire_coral_block", () -> new CoralBlock(DEAD_FIRE_CORAL_BLOCK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_HORN_CORAL_BLOCK =
            BLOCKS.register("ancient_horn_coral_block", () -> new CoralBlock(DEAD_HORN_CORAL_BLOCK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_DEAD_TUBE_CORAL =
            BLOCKS.register("ancient_dead_tube_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_BRAIN_CORAL =
            BLOCKS.register("ancient_dead_brain_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_BUBBLE_CORAL =
            BLOCKS.register("ancient_dead_bubble_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_FIRE_CORAL =
            BLOCKS.register("ancient_dead_fire_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_HORN_CORAL =
            BLOCKS.register("ancient_dead_horn_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_TUBE_CORAL =
            BLOCKS.register("ancient_tube_coral", () -> new CoralPlantBlock(DEAD_TUBE_CORAL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BRAIN_CORAL =
            BLOCKS.register("ancient_brain_coral", () -> new CoralPlantBlock(DEAD_BRAIN_CORAL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BUBBLE_CORAL =
            BLOCKS.register("ancient_bubble_coral", () -> new CoralPlantBlock(DEAD_BUBBLE_CORAL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FIRE_CORAL =
            BLOCKS.register("ancient_fire_coral", () -> new CoralPlantBlock(DEAD_FIRE_CORAL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_HORN_CORAL =
            BLOCKS.register("ancient_horn_coral", () -> new CoralPlantBlock(DEAD_HORN_CORAL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DEAD_TUBE_CORAL_FAN =
            BLOCKS.register("ancient_dead_tube_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_BRAIN_CORAL_FAN =
            BLOCKS.register("ancient_dead_brain_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_BUBBLE_CORAL_FAN =
            BLOCKS.register("ancient_dead_bubble_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_FIRE_CORAL_FAN =
            BLOCKS.register("ancient_dead_fire_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_DEAD_HORN_CORAL_FAN =
            BLOCKS.register("ancient_dead_horn_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak()));
    public static final RegistryObject<Block> ANCIENT_TUBE_CORAL_FAN =
            BLOCKS.register("ancient_tube_coral_fan", () -> new CoralFanBlock(DEAD_TUBE_CORAL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BRAIN_CORAL_FAN =
            BLOCKS.register("ancient_brain_coral_fan", () -> new CoralFanBlock(DEAD_BRAIN_CORAL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BUBBLE_CORAL_FAN =
            BLOCKS.register("ancient_bubble_coral_fan", () -> new CoralFanBlock(DEAD_BUBBLE_CORAL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FIRE_CORAL_FAN =
            BLOCKS.register("ancient_fire_coral_fan", () -> new CoralFanBlock(DEAD_FIRE_CORAL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_HORN_CORAL_FAN =
            BLOCKS.register("ancient_horn_coral_fan", () -> new CoralFanBlock(DEAD_HORN_CORAL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_DEAD_TUBE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_dead_tube_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak().dropsLike(DEAD_TUBE_CORAL_FAN)));
    public static final RegistryObject<Block> ANCIENT_DEAD_BRAIN_CORAL_WALL_FAN =
            BLOCKS.register("ancient_dead_brain_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak().dropsLike(DEAD_BRAIN_CORAL_FAN)));
    public static final RegistryObject<Block> ANCIENT_DEAD_BUBBLE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_dead_bubble_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak().dropsLike(DEAD_BUBBLE_CORAL_FAN)));
    public static final RegistryObject<Block> ANCIENT_DEAD_FIRE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_dead_fire_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak().dropsLike(DEAD_FIRE_CORAL_FAN)));
    public static final RegistryObject<Block> ANCIENT_DEAD_HORN_CORAL_WALL_FAN =
            BLOCKS.register("ancient_dead_horn_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak().dropsLike(DEAD_HORN_CORAL_FAN)));
    public static final RegistryObject<Block> ANCIENT_TUBE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_tube_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_TUBE_CORAL_WALL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(TUBE_CORAL_FAN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BRAIN_CORAL_WALL_FAN =
            BLOCKS.register("ancient_brain_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_BRAIN_CORAL_WALL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(BRAIN_CORAL_FAN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BUBBLE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_bubble_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_BUBBLE_CORAL_WALL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(BUBBLE_CORAL_FAN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FIRE_CORAL_WALL_FAN =
            BLOCKS.register("ancient_fire_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_FIRE_CORAL_WALL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(FIRE_CORAL_FAN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_HORN_CORAL_WALL_FAN =
            BLOCKS.register("ancient_horn_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_HORN_CORAL_WALL_FAN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(HORN_CORAL_FAN).pushReaction(PushReaction.DESTROY)));
//    public static final RegistryObject<Block> ANCIENT_SEA_PICKLE =
//            BLOCKS.register("ancient_sea_pickle", () -> new SeaPickleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).lightLevel((p_152680_) -> { return SeaPickleBlock.isDead(p_152680_) ? 0 : 3 + 3 * p_152680_.getValue(SeaPickleBlock.PICKLES);
    public static final RegistryObject<Block> ANCIENT_BLUE_ICE =
            BLOCKS.register("ancient_blue_ice", () -> new HalfTransparentBlock(BlockBehaviour.Properties.of().mapColor(MapColor.ICE).strength(2.8F).friction(0.989F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO_SAPLING =
            BLOCKS.register("ancient_bamboo_sapling", () -> new BambooSaplingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().randomTicks().instabreak().noCollission().strength(1.0F).sound(SoundType.BAMBOO_SAPLING).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BAMBOO =
            BLOCKS.register("ancient_bamboo", () -> new BambooStalkBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOn().randomTicks().instabreak().strength(1.0F).sound(SoundType.BAMBOO).noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_POTTED_BAMBOO =
            BLOCKS.register("ancient_potted_bamboo", () -> flowerPot(BAMBOO));
    public static final RegistryObject<Block> ANCIENT_VOID_AIR =
            BLOCKS.register("ancient_void_air", () -> new AirBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().air()));
    public static final RegistryObject<Block> ANCIENT_CAVE_AIR =
            BLOCKS.register("ancient_cave_air", () -> new AirBlock(BlockBehaviour.Properties.of().replaceable().noCollission().noLootTable().air()));
    public static final RegistryObject<Block> ANCIENT_BUBBLE_COLUMN =
            BLOCKS.register("ancient_bubble_column", () -> new BubbleColumnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).replaceable().noCollission().noLootTable().pushReaction(PushReaction.DESTROY).liquid().sound(SoundType.EMPTY)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_GRANITE_STAIRS =
            BLOCKS.register("ancient_polished_granite_stairs", () -> new StairBlock(POLISHED_GRANITE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GRANITE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_RED_SANDSTONE_STAIRS =
            BLOCKS.register("ancient_smooth_red_sandstone_stairs", () -> new StairBlock(SMOOTH_RED_SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_RED_SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE_BRICK_STAIRS =
            BLOCKS.register("ancient_mossy_stone_brick_stairs", () -> new StairBlock(MOSSY_STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DIORITE_STAIRS =
            BLOCKS.register("ancient_polished_diorite_stairs", () -> new StairBlock(POLISHED_DIORITE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_DIORITE)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_COBBLESTONE_STAIRS =
            BLOCKS.register("ancient_mossy_cobblestone_stairs", () -> new StairBlock(MOSSY_COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(MOSSY_COBBLESTONE)));
    public static final RegistryObject<Block> ANCIENT_END_STONE_BRICK_STAIRS =
            BLOCKS.register("ancient_end_stone_brick_stairs", () -> new StairBlock(END_STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(END_STONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_STONE_STAIRS =
            BLOCKS.register("ancient_stone_stairs", () -> new StairBlock(STONE.defaultBlockState(), BlockBehaviour.Properties.copy(STONE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_SANDSTONE_STAIRS =
            BLOCKS.register("ancient_smooth_sandstone_stairs", () -> new StairBlock(SMOOTH_SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_QUARTZ_STAIRS =
            BLOCKS.register("ancient_smooth_quartz_stairs", () -> new StairBlock(SMOOTH_QUARTZ.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_QUARTZ)));
    public static final RegistryObject<Block> ANCIENT_GRANITE_STAIRS =
            BLOCKS.register("ancient_granite_stairs", () -> new StairBlock(GRANITE.defaultBlockState(), BlockBehaviour.Properties.copy(GRANITE)));
    public static final RegistryObject<Block> ANCIENT_ANDESITE_STAIRS =
            BLOCKS.register("ancient_andesite_stairs", () -> new StairBlock(ANDESITE.defaultBlockState(), BlockBehaviour.Properties.copy(ANDESITE)));
    public static final RegistryObject<Block> ANCIENT_RED_NETHER_BRICK_STAIRS =
            BLOCKS.register("ancient_red_nether_brick_stairs", () -> new StairBlock(RED_NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_ANDESITE_STAIRS =
            BLOCKS.register("ancient_polished_andesite_stairs", () -> new StairBlock(POLISHED_ANDESITE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_ANDESITE)));
    public static final RegistryObject<Block> ANCIENT_DIORITE_STAIRS =
            BLOCKS.register("ancient_diorite_stairs", () -> new StairBlock(DIORITE.defaultBlockState(), BlockBehaviour.Properties.copy(DIORITE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_GRANITE_SLAB =
            BLOCKS.register("ancient_polished_granite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GRANITE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_RED_SANDSTONE_SLAB =
            BLOCKS.register("ancient_smooth_red_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_RED_SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE_BRICK_SLAB =
            BLOCKS.register("ancient_mossy_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(MOSSY_STONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DIORITE_SLAB =
            BLOCKS.register("ancient_polished_diorite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_DIORITE)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_COBBLESTONE_SLAB =
            BLOCKS.register("ancient_mossy_cobblestone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(MOSSY_COBBLESTONE)));
    public static final RegistryObject<Block> ANCIENT_END_STONE_BRICK_SLAB =
            BLOCKS.register("ancient_end_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(END_STONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_SANDSTONE_SLAB =
            BLOCKS.register("ancient_smooth_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SANDSTONE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_QUARTZ_SLAB =
            BLOCKS.register("ancient_smooth_quartz_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_QUARTZ)));
    public static final RegistryObject<Block> ANCIENT_GRANITE_SLAB =
            BLOCKS.register("ancient_granite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GRANITE)));
    public static final RegistryObject<Block> ANCIENT_ANDESITE_SLAB =
            BLOCKS.register("ancient_andesite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ANDESITE)));
    public static final RegistryObject<Block> ANCIENT_RED_NETHER_BRICK_SLAB =
            BLOCKS.register("ancient_red_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_ANDESITE_SLAB =
            BLOCKS.register("ancient_polished_andesite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_ANDESITE)));
    public static final RegistryObject<Block> ANCIENT_DIORITE_SLAB =
            BLOCKS.register("ancient_diorite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(DIORITE)));
    public static final RegistryObject<Block> ANCIENT_BRICK_WALL =
            BLOCKS.register("ancient_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_PRISMARINE_WALL =
            BLOCKS.register("ancient_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(PRISMARINE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_RED_SANDSTONE_WALL =
            BLOCKS.register("ancient_red_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RED_SANDSTONE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE_BRICK_WALL =
            BLOCKS.register("ancient_mossy_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(MOSSY_STONE_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_GRANITE_WALL =
            BLOCKS.register("ancient_granite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GRANITE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICK_WALL =
            BLOCKS.register("ancient_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(STONE_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_MUD_BRICK_WALL =
            BLOCKS.register("ancient_mud_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(MUD_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_NETHER_BRICK_WALL =
            BLOCKS.register("ancient_nether_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_ANDESITE_WALL =
            BLOCKS.register("ancient_andesite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ANDESITE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_RED_NETHER_BRICK_WALL =
            BLOCKS.register("ancient_red_nether_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RED_NETHER_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_SANDSTONE_WALL =
            BLOCKS.register("ancient_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SANDSTONE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_END_STONE_BRICK_WALL =
            BLOCKS.register("ancient_end_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(END_STONE_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_DIORITE_WALL =
            BLOCKS.register("ancient_diorite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(DIORITE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_SCAFFOLDING =
            BLOCKS.register("ancient_scaffolding", () -> new ScaffoldingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).noCollission().sound(SoundType.SCAFFOLDING).dynamicShape().isValidSpawn(ModBlocks::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_LOOM =
            BLOCKS.register("ancient_loom", () -> new LoomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BARREL =
            BLOCKS.register("ancient_barrel", () -> new BarrelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SMOKER =
            BLOCKS.register("ancient_smoker", () -> new SmokerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13))));
    public static final RegistryObject<Block> ANCIENT_BLAST_FURNACE =
            BLOCKS.register("ancient_blast_furnace", () -> new BlastFurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13))));
    public static final RegistryObject<Block> ANCIENT_CARTOGRAPHY_TABLE =
            BLOCKS.register("ancient_cartography_table", () -> new CartographyTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_FLETCHING_TABLE =
            BLOCKS.register("ancient_fletching_table", () -> new FletchingTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_GRINDSTONE =
            BLOCKS.register("ancient_grindstone", () -> new GrindstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_LECTERN =
            BLOCKS.register("ancient_lectern", () -> new LecternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SMITHING_TABLE =
            BLOCKS.register("ancient_smithing_table", () -> new SmithingTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_STONECUTTER =
            BLOCKS.register("ancient_stonecutter", () -> new StonecutterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F)));
    public static final RegistryObject<Block> ANCIENT_BELL =
            BLOCKS.register("ancient_bell", () -> new BellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).forceSolidOn().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CAMPFIRE =
            BLOCKS.register("ancient_campfire", () -> new CampfireBlock(true, 1, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(15)).noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SOUL_CAMPFIRE =
            BLOCKS.register("ancient_soul_campfire", () -> new CampfireBlock(false, 2, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).lightLevel(litBlockEmission(10)).noOcclusion().ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_SWEET_BERRY_BUSH =
            BLOCKS.register("ancient_sweet_berry_bush", () -> new SweetBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    private static Block netherStem(MapColor pMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((p_152620_) -> {
            return pMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM));
    }
    public static final RegistryObject<Block> ANCIENT_WARPED_STEM =
            BLOCKS.register("ancient_warped_stem", () -> netherStem(MapColor.WARPED_STEM));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_WARPED_STEM =
            BLOCKS.register("ancient_stripped_warped_stem", () -> netherStem(MapColor.WARPED_STEM));
    public static final RegistryObject<Block> ANCIENT_WARPED_HYPHAE =
            BLOCKS.register("ancient_warped_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM)));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_WARPED_HYPHAE =
            BLOCKS.register("ancient_stripped_warped_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM)));
    public static final RegistryObject<Block> ANCIENT_WARPED_NYLIUM =
            BLOCKS.register("ancient_warped_nylium", () -> new NyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static final RegistryObject<Block> ANCIENT_WARPED_FUNGUS =
            BLOCKS.register("ancient_warped_fungus", () -> new FungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instabreak().noCollission().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY), TreeFeatures.WARPED_FUNGUS_PLANTED, WARPED_NYLIUM));
    public static final RegistryObject<Block> ANCIENT_WARPED_WART_BLOCK =
            BLOCKS.register("ancient_warped_wart_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).strength(1.0F).sound(SoundType.WART_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_WARPED_ROOTS =
            BLOCKS.register("ancient_warped_roots", () -> new RootsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).replaceable().noCollission().instabreak().sound(SoundType.ROOTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_NETHER_SPROUTS =
            BLOCKS.register("ancient_nether_sprouts", () -> new NetherSproutsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).replaceable().noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_STEM =
            BLOCKS.register("ancient_crimson_stem", () -> netherStem(MapColor.CRIMSON_STEM));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_CRIMSON_STEM =
            BLOCKS.register("ancient_stripped_crimson_stem", () -> netherStem(MapColor.CRIMSON_STEM));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_HYPHAE =
            BLOCKS.register("ancient_crimson_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM)));
    public static final RegistryObject<Block> ANCIENT_STRIPPED_CRIMSON_HYPHAE =
            BLOCKS.register("ancient_stripped_crimson_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_NYLIUM =
            BLOCKS.register("ancient_crimson_nylium", () -> new NyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_FUNGUS =
            BLOCKS.register("ancient_crimson_fungus", () -> new FungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instabreak().noCollission().sound(SoundType.FUNGUS).pushReaction(PushReaction.DESTROY), TreeFeatures.CRIMSON_FUNGUS_PLANTED, CRIMSON_NYLIUM));
    public static final RegistryObject<Block> ANCIENT_WEEPING_VINES =
            BLOCKS.register("ancient_weeping_vines", () -> new WeepingVinesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_WEEPING_VINES_PLANT =
            BLOCKS.register("ancient_weeping_vines_plant", () -> new WeepingVinesPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TWISTING_VINES =
            BLOCKS.register("ancient_twisting_vines", () -> new TwistingVinesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TWISTING_VINES_PLANT =
            BLOCKS.register("ancient_twisting_vines_plant", () -> new TwistingVinesPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_ROOTS =
            BLOCKS.register("ancient_crimson_roots", () -> new RootsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).replaceable().noCollission().instabreak().sound(SoundType.ROOTS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_PLANKS =
            BLOCKS.register("ancient_crimson_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_WARPED_PLANKS =
            BLOCKS.register("ancient_warped_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_SLAB =
            BLOCKS.register("ancient_crimson_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_WARPED_SLAB =
            BLOCKS.register("ancient_warped_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_PRESSURE_PLATE =
            BLOCKS.register("ancient_crimson_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_PRESSURE_PLATE =
            BLOCKS.register("ancient_warped_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_FENCE =
            BLOCKS.register("ancient_crimson_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_WARPED_FENCE =
            BLOCKS.register("ancient_warped_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_TRAPDOOR =
            BLOCKS.register("ancient_crimson_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never), BlockSetType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_TRAPDOOR =
            BLOCKS.register("ancient_warped_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never), BlockSetType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_FENCE_GATE =
            BLOCKS.register("ancient_crimson_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F), WoodType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_FENCE_GATE =
            BLOCKS.register("ancient_warped_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F), WoodType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_STAIRS =
            BLOCKS.register("ancient_crimson_stairs", () -> new StairBlock(CRIMSON_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(CRIMSON_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_WARPED_STAIRS =
            BLOCKS.register("ancient_warped_stairs", () -> new StairBlock(WARPED_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(WARPED_PLANKS)));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_BUTTON =
            BLOCKS.register("ancient_crimson_button", () -> woodenButton(BlockSetType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_BUTTON =
            BLOCKS.register("ancient_warped_button", () -> woodenButton(BlockSetType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_DOOR =
            BLOCKS.register("ancient_crimson_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY), BlockSetType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_DOOR =
            BLOCKS.register("ancient_warped_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY), BlockSetType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_SIGN =
            BLOCKS.register("ancient_crimson_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().strength(1.0F), WoodType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_SIGN =
            BLOCKS.register("ancient_warped_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().strength(1.0F), WoodType.WARPED));
    public static final RegistryObject<Block> ANCIENT_CRIMSON_WALL_SIGN =
            BLOCKS.register("ancient_crimson_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(CRIMSON_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().strength(1.0F).dropsLike(CRIMSON_SIGN), WoodType.CRIMSON));
    public static final RegistryObject<Block> ANCIENT_WARPED_WALL_SIGN =
            BLOCKS.register("ancient_warped_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(WARPED_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).forceSolidOn().noCollission().strength(1.0F).dropsLike(WARPED_SIGN), WoodType.WARPED));
    public static final RegistryObject<Block> ANCIENT_STRUCTURE_BLOCK =
            BLOCKS.register("ancient_structure_block", () -> new StructureBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_JIGSAW =
            BLOCKS.register("ancient_jigsaw", () -> new JigsawBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_COMPOSTER =
            BLOCKS.register("ancient_composter", () -> new ComposterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_TARGET =
            BLOCKS.register("ancient_target", () -> new TargetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ANCIENT_BEE_NEST =
            BLOCKS.register("ancient_bee_nest", () -> new BeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(0.3F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_BEEHIVE =
            BLOCKS.register("ancient_beehive", () -> new BeehiveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> ANCIENT_HONEY_BLOCK =
            BLOCKS.register("ancient_honey_block", () -> new HoneyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).speedFactor(0.4F).jumpFactor(0.5F).noOcclusion().sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_HONEYCOMB_BLOCK =
            BLOCKS.register("ancient_honeycomb_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.6F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_NETHERITE_BLOCK =
            BLOCKS.register("ancient_netherite_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_ANCIENT_DEBRIS =
            BLOCKS.register("ancient_ancient_debris", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)));
//    public static final RegistryObject<Block> ANCIENT_RESPAWN_ANCHOR =
//            BLOCKS.register("ancient_respawn_anchor", () -> new RespawnAnchorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).lightLevel((p_152639_) -> { return RespawnAnchorBlock.getScaledChargeLevel(p_152639_, 15);
    public static final RegistryObject<Block> ANCIENT_POTTED_CRIMSON_FUNGUS =
            BLOCKS.register("ancient_potted_crimson_fungus", () -> flowerPot(CRIMSON_FUNGUS));
    public static final RegistryObject<Block> ANCIENT_POTTED_WARPED_FUNGUS =
            BLOCKS.register("ancient_potted_warped_fungus", () -> flowerPot(WARPED_FUNGUS));
    public static final RegistryObject<Block> ANCIENT_POTTED_CRIMSON_ROOTS =
            BLOCKS.register("ancient_potted_crimson_roots", () -> flowerPot(CRIMSON_ROOTS));
    public static final RegistryObject<Block> ANCIENT_POTTED_WARPED_ROOTS =
            BLOCKS.register("ancient_potted_warped_roots", () -> flowerPot(WARPED_ROOTS));
    public static final RegistryObject<Block> ANCIENT_LODESTONE =
            BLOCKS.register("ancient_lodestone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LODESTONE).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> ANCIENT_BLACKSTONE =
            BLOCKS.register("ancient_blackstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_BLACKSTONE_STAIRS =
            BLOCKS.register("ancient_blackstone_stairs", () -> new StairBlock(BLACKSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(BLACKSTONE)));
    public static final RegistryObject<Block> ANCIENT_BLACKSTONE_WALL =
            BLOCKS.register("ancient_blackstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(BLACKSTONE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_BLACKSTONE_SLAB =
            BLOCKS.register("ancient_blackstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLACKSTONE).strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE =
            BLOCKS.register("ancient_polished_blackstone", () -> new Block(BlockBehaviour.Properties.copy(BLACKSTONE).strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_BRICKS =
            BLOCKS.register("ancient_polished_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_POLISHED_BLACKSTONE_BRICKS =
            BLOCKS.register("ancient_cracked_polished_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_CHISELED_POLISHED_BLACKSTONE =
            BLOCKS.register("ancient_chiseled_polished_blackstone", () -> new Block(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_BRICK_SLAB =
            BLOCKS.register("ancient_polished_blackstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE_BRICKS).strength(2.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_BRICK_STAIRS =
            BLOCKS.register("ancient_polished_blackstone_brick_stairs", () -> new StairBlock(POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_BRICK_WALL =
            BLOCKS.register("ancient_polished_blackstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_GILDED_BLACKSTONE =
            BLOCKS.register("ancient_gilded_blackstone", () -> new Block(BlockBehaviour.Properties.copy(BLACKSTONE).sound(SoundType.GILDED_BLACKSTONE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_STAIRS =
            BLOCKS.register("ancient_polished_blackstone_stairs", () -> new StairBlock(POLISHED_BLACKSTONE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_SLAB =
            BLOCKS.register("ancient_polished_blackstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_PRESSURE_PLATE =
            BLOCKS.register("ancient_polished_blackstone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.POLISHED_BLACKSTONE));
    private static ButtonBlock stoneButton() {
        return new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.STONE, 20, false);
    }
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_BUTTON =
            BLOCKS.register("ancient_polished_blackstone_button", () -> stoneButton());
    public static final RegistryObject<Block> ANCIENT_POLISHED_BLACKSTONE_WALL =
            BLOCKS.register("ancient_polished_blackstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_BLACKSTONE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_CHISELED_NETHER_BRICKS =
            BLOCKS.register("ancient_chiseled_nether_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_NETHER_BRICKS =
            BLOCKS.register("ancient_cracked_nether_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_QUARTZ_BRICKS =
            BLOCKS.register("ancient_quartz_bricks", () -> new Block(BlockBehaviour.Properties.copy(QUARTZ_BLOCK)));
    private static CandleBlock candle(MapColor pMapColor) {
        return new CandleBlock(BlockBehaviour.Properties.of().mapColor(pMapColor).noOcclusion().strength(0.1F).sound(SoundType.CANDLE).lightLevel(CandleBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY));
    }
    public static final RegistryObject<Block> ANCIENT_CANDLE =
            BLOCKS.register("ancient_candle", () -> candle(MapColor.SAND));
    public static final RegistryObject<Block> ANCIENT_WHITE_CANDLE =
            BLOCKS.register("ancient_white_candle", () -> candle(MapColor.WOOL));
    public static final RegistryObject<Block> ANCIENT_ORANGE_CANDLE =
            BLOCKS.register("ancient_orange_candle", () -> candle(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_CANDLE =
            BLOCKS.register("ancient_magenta_candle", () -> candle(MapColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_CANDLE =
            BLOCKS.register("ancient_light_blue_candle", () -> candle(MapColor.COLOR_LIGHT_BLUE));
    public static final RegistryObject<Block> ANCIENT_YELLOW_CANDLE =
            BLOCKS.register("ancient_yellow_candle", () -> candle(MapColor.COLOR_YELLOW));
    public static final RegistryObject<Block> ANCIENT_LIME_CANDLE =
            BLOCKS.register("ancient_lime_candle", () -> candle(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistryObject<Block> ANCIENT_PINK_CANDLE =
            BLOCKS.register("ancient_pink_candle", () -> candle(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> ANCIENT_GRAY_CANDLE =
            BLOCKS.register("ancient_gray_candle", () -> candle(MapColor.COLOR_GRAY));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_CANDLE =
            BLOCKS.register("ancient_light_gray_candle", () -> candle(MapColor.COLOR_LIGHT_GRAY));
    public static final RegistryObject<Block> ANCIENT_CYAN_CANDLE =
            BLOCKS.register("ancient_cyan_candle", () -> candle(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> ANCIENT_PURPLE_CANDLE =
            BLOCKS.register("ancient_purple_candle", () -> candle(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> ANCIENT_BLUE_CANDLE =
            BLOCKS.register("ancient_blue_candle", () -> candle(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> ANCIENT_BROWN_CANDLE =
            BLOCKS.register("ancient_brown_candle", () -> candle(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> ANCIENT_GREEN_CANDLE =
            BLOCKS.register("ancient_green_candle", () -> candle(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> ANCIENT_RED_CANDLE =
            BLOCKS.register("ancient_red_candle", () -> candle(MapColor.COLOR_RED));
    public static final RegistryObject<Block> ANCIENT_BLACK_CANDLE =
            BLOCKS.register("ancient_black_candle", () -> candle(MapColor.COLOR_BLACK));
    public static final RegistryObject<Block> ANCIENT_CANDLE_CAKE =
            BLOCKS.register("ancient_candle_cake", () -> new CandleCakeBlock(CANDLE, BlockBehaviour.Properties.copy(CAKE).lightLevel(litBlockEmission(3))));
    public static final RegistryObject<Block> ANCIENT_WHITE_CANDLE_CAKE =
            BLOCKS.register("ancient_white_candle_cake", () -> new CandleCakeBlock(WHITE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_ORANGE_CANDLE_CAKE =
            BLOCKS.register("ancient_orange_candle_cake", () -> new CandleCakeBlock(ORANGE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_MAGENTA_CANDLE_CAKE =
            BLOCKS.register("ancient_magenta_candle_cake", () -> new CandleCakeBlock(MAGENTA_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_BLUE_CANDLE_CAKE =
            BLOCKS.register("ancient_light_blue_candle_cake", () -> new CandleCakeBlock(LIGHT_BLUE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_YELLOW_CANDLE_CAKE =
            BLOCKS.register("ancient_yellow_candle_cake", () -> new CandleCakeBlock(YELLOW_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_LIME_CANDLE_CAKE =
            BLOCKS.register("ancient_lime_candle_cake", () -> new CandleCakeBlock(LIME_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_PINK_CANDLE_CAKE =
            BLOCKS.register("ancient_pink_candle_cake", () -> new CandleCakeBlock(PINK_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_GRAY_CANDLE_CAKE =
            BLOCKS.register("ancient_gray_candle_cake", () -> new CandleCakeBlock(GRAY_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_LIGHT_GRAY_CANDLE_CAKE =
            BLOCKS.register("ancient_light_gray_candle_cake", () -> new CandleCakeBlock(LIGHT_GRAY_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_CYAN_CANDLE_CAKE =
            BLOCKS.register("ancient_cyan_candle_cake", () -> new CandleCakeBlock(CYAN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_PURPLE_CANDLE_CAKE =
            BLOCKS.register("ancient_purple_candle_cake", () -> new CandleCakeBlock(PURPLE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_BLUE_CANDLE_CAKE =
            BLOCKS.register("ancient_blue_candle_cake", () -> new CandleCakeBlock(BLUE_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_BROWN_CANDLE_CAKE =
            BLOCKS.register("ancient_brown_candle_cake", () -> new CandleCakeBlock(BROWN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_GREEN_CANDLE_CAKE =
            BLOCKS.register("ancient_green_candle_cake", () -> new CandleCakeBlock(GREEN_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_RED_CANDLE_CAKE =
            BLOCKS.register("ancient_red_candle_cake", () -> new CandleCakeBlock(RED_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_BLACK_CANDLE_CAKE =
            BLOCKS.register("ancient_black_candle_cake", () -> new CandleCakeBlock(BLACK_CANDLE, BlockBehaviour.Properties.copy(CANDLE_CAKE)));
    public static final RegistryObject<Block> ANCIENT_AMETHYST_BLOCK =
            BLOCKS.register("ancient_amethyst_block", () -> new AmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_BUDDING_AMETHYST =
            BLOCKS.register("ancient_budding_amethyst", () -> new BuddingAmethystBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_TUFF =
            BLOCKS.register("ancient_tuff", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_CALCITE =
            BLOCKS.register("ancient_calcite", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.75F)));
    public static final RegistryObject<Block> ANCIENT_TINTED_GLASS =
            BLOCKS.register("ancient_tinted_glass", () -> new TintedGlassBlock(BlockBehaviour.Properties.copy(GLASS).mapColor(MapColor.COLOR_GRAY).noOcclusion().isValidSpawn(ModBlocks::never).isRedstoneConductor((state, getter, pos) -> false).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_POWDER_SNOW =
            BLOCKS.register("ancient_powder_snow", () -> new PowderSnowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.25F).sound(SoundType.POWDER_SNOW).dynamicShape().isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_CALIBRATED_SCULK_SENSOR =
            BLOCKS.register("ancient_calibrated_sculk_sensor", () -> new CalibratedSculkSensorBlock(BlockBehaviour.Properties.copy(SCULK_SENSOR)));
    public static final RegistryObject<Block> ANCIENT_SCULK =
            BLOCKS.register("ancient_sculk", () -> new SculkBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(0.2F).sound(SoundType.SCULK)));
    public static final RegistryObject<Block> ANCIENT_SCULK_VEIN =
            BLOCKS.register("ancient_sculk_vein", () -> new SculkVeinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).forceSolidOn().noCollission().strength(0.2F).sound(SoundType.SCULK_VEIN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SCULK_SHRIEKER =
            BLOCKS.register("ancient_sculk_shrieker", () -> new SculkShriekerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3.0F, 3.0F).sound(SoundType.SCULK_SHRIEKER)));
    public static final RegistryObject<Block> ANCIENT_OXIDIZED_COPPER =
            BLOCKS.register("ancient_oxidized_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> ANCIENT_WEATHERED_COPPER =
            BLOCKS.register("ancient_weathered_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> ANCIENT_EXPOSED_COPPER =
            BLOCKS.register("ancient_exposed_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> ANCIENT_COPPER_BLOCK =
            BLOCKS.register("ancient_copper_block", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> ANCIENT_COPPER_ORE =
            BLOCKS.register("ancient_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(IRON_ORE)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_COPPER_ORE =
            BLOCKS.register("ancient_deepslate_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(COPPER_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_OXIDIZED_CUT_COPPER =
            BLOCKS.register("ancient_oxidized_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(OXIDIZED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WEATHERED_CUT_COPPER =
            BLOCKS.register("ancient_weathered_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(WEATHERED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_EXPOSED_CUT_COPPER =
            BLOCKS.register("ancient_exposed_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(EXPOSED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_CUT_COPPER =
            BLOCKS.register("ancient_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(COPPER_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_OXIDIZED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_oxidized_cut_copper_stairs", () -> new WeatheringCopperStairBlock(WeatheringCopper.WeatherState.OXIDIZED, OXIDIZED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(OXIDIZED_CUT_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WEATHERED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_weathered_cut_copper_stairs", () -> new WeatheringCopperStairBlock(WeatheringCopper.WeatherState.WEATHERED, WEATHERED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(WEATHERED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_EXPOSED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_exposed_cut_copper_stairs", () -> new WeatheringCopperStairBlock(WeatheringCopper.WeatherState.EXPOSED, EXPOSED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(EXPOSED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_cut_copper_stairs", () -> new WeatheringCopperStairBlock(WeatheringCopper.WeatherState.UNAFFECTED, CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(COPPER_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_OXIDIZED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_oxidized_cut_copper_slab", () -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(OXIDIZED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_WEATHERED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_weathered_cut_copper_slab", () -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(WEATHERED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_EXPOSED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_exposed_cut_copper_slab", () -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(EXPOSED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_cut_copper_slab", () -> new WeatheringCopperSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_WAXED_COPPER_BLOCK =
            BLOCKS.register("ancient_waxed_copper_block", () -> new Block(BlockBehaviour.Properties.copy(COPPER_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_WAXED_WEATHERED_COPPER =
            BLOCKS.register("ancient_waxed_weathered_copper", () -> new Block(BlockBehaviour.Properties.copy(WEATHERED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_EXPOSED_COPPER =
            BLOCKS.register("ancient_waxed_exposed_copper", () -> new Block(BlockBehaviour.Properties.copy(EXPOSED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_OXIDIZED_COPPER =
            BLOCKS.register("ancient_waxed_oxidized_copper", () -> new Block(BlockBehaviour.Properties.copy(OXIDIZED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_OXIDIZED_CUT_COPPER =
            BLOCKS.register("ancient_waxed_oxidized_cut_copper", () -> new Block(BlockBehaviour.Properties.copy(OXIDIZED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_WEATHERED_CUT_COPPER =
            BLOCKS.register("ancient_waxed_weathered_cut_copper", () -> new Block(BlockBehaviour.Properties.copy(WEATHERED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_EXPOSED_CUT_COPPER =
            BLOCKS.register("ancient_waxed_exposed_cut_copper", () -> new Block(BlockBehaviour.Properties.copy(EXPOSED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_CUT_COPPER =
            BLOCKS.register("ancient_waxed_cut_copper", () -> new Block(BlockBehaviour.Properties.copy(COPPER_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_WAXED_OXIDIZED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_waxed_oxidized_cut_copper_stairs", () -> new StairBlock(WAXED_OXIDIZED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(OXIDIZED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_WEATHERED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_waxed_weathered_cut_copper_stairs", () -> new StairBlock(WAXED_WEATHERED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(WEATHERED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_EXPOSED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_waxed_exposed_cut_copper_stairs", () -> new StairBlock(WAXED_EXPOSED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(EXPOSED_COPPER)));
    public static final RegistryObject<Block> ANCIENT_WAXED_CUT_COPPER_STAIRS =
            BLOCKS.register("ancient_waxed_cut_copper_stairs", () -> new StairBlock(WAXED_CUT_COPPER.defaultBlockState(), BlockBehaviour.Properties.copy(COPPER_BLOCK)));
    public static final RegistryObject<Block> ANCIENT_WAXED_OXIDIZED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_waxed_oxidized_cut_copper_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WAXED_OXIDIZED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_WAXED_WEATHERED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_waxed_weathered_cut_copper_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WAXED_WEATHERED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_WAXED_EXPOSED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_waxed_exposed_cut_copper_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WAXED_EXPOSED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_WAXED_CUT_COPPER_SLAB =
            BLOCKS.register("ancient_waxed_cut_copper_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WAXED_CUT_COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ANCIENT_LIGHTNING_ROD =
            BLOCKS.register("ancient_lightning_rod", () -> new LightningRodBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_POINTED_DRIPSTONE =
            BLOCKS.register("ancient_pointed_dripstone", () -> new PointedDripstoneBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).noOcclusion().sound(SoundType.POINTED_DRIPSTONE).randomTicks().strength(1.5F, 3.0F).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));
    public static final RegistryObject<Block> ANCIENT_DRIPSTONE_BLOCK =
            BLOCKS.register("ancient_dripstone_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops().strength(1.5F, 1.0F)));
    public static final RegistryObject<Block> ANCIENT_CAVE_VINES =
            BLOCKS.register("ancient_cave_vines", () -> new CaveVinesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().lightLevel(CaveVines.emission(14)).instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_CAVE_VINES_PLANT =
            BLOCKS.register("ancient_cave_vines_plant", () -> new CaveVinesPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().lightLevel(CaveVines.emission(14)).instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SPORE_BLOSSOM =
            BLOCKS.register("ancient_spore_blossom", () -> new SporeBlossomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noCollission().sound(SoundType.SPORE_BLOSSOM).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_AZALEA =
            BLOCKS.register("ancient_azalea", () -> new AzaleaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.AZALEA).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_FLOWERING_AZALEA =
            BLOCKS.register("ancient_flowering_azalea", () -> new AzaleaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.FLOWERING_AZALEA).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_MOSS_CARPET =
            BLOCKS.register("ancient_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_PINK_PETALS =
            BLOCKS.register("ancient_pink_petals", () -> new PinkPetalsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_MOSS_BLOCK =
            BLOCKS.register("ancient_moss_block", () -> new MossBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BIG_DRIPLEAF =
            BLOCKS.register("ancient_big_dripleaf", () -> new BigDripleafBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().strength(0.1F).sound(SoundType.BIG_DRIPLEAF).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_BIG_DRIPLEAF_STEM =
            BLOCKS.register("ancient_big_dripleaf_stem", () -> new BigDripleafStemBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.1F).sound(SoundType.BIG_DRIPLEAF).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_SMALL_DRIPLEAF =
            BLOCKS.register("ancient_small_dripleaf", () -> new SmallDripleafBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.SMALL_DRIPLEAF).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_HANGING_ROOTS =
            BLOCKS.register("ancient_hanging_roots", () -> new HangingRootsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).replaceable().noCollission().instabreak().sound(SoundType.HANGING_ROOTS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_ROOTED_DIRT =
            BLOCKS.register("ancient_rooted_dirt", () -> new RootedDirtBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> ANCIENT_MUD =
            BLOCKS.register("ancient_mud", () -> new MudBlock(BlockBehaviour.Properties.copy(DIRT).mapColor(MapColor.TERRACOTTA_CYAN).isValidSpawn(ModBlocks::always).isRedstoneConductor((state, getter, pos) -> true).isViewBlocking((state, getter, pos) -> true).isSuffocating((state, getter, pos) -> true).sound(SoundType.MUD)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE =
            BLOCKS.register("ancient_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_COBBLED_DEEPSLATE =
            BLOCKS.register("ancient_cobbled_deepslate", () -> new Block(BlockBehaviour.Properties.copy(DEEPSLATE).strength(3.5F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_COBBLED_DEEPSLATE_STAIRS =
            BLOCKS.register("ancient_cobbled_deepslate_stairs", () -> new StairBlock(COBBLED_DEEPSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_COBBLED_DEEPSLATE_SLAB =
            BLOCKS.register("ancient_cobbled_deepslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_COBBLED_DEEPSLATE_WALL =
            BLOCKS.register("ancient_cobbled_deepslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DEEPSLATE =
            BLOCKS.register("ancient_polished_deepslate", () -> new Block(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE).sound(SoundType.POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DEEPSLATE_STAIRS =
            BLOCKS.register("ancient_polished_deepslate_stairs", () -> new StairBlock(POLISHED_DEEPSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DEEPSLATE_SLAB =
            BLOCKS.register("ancient_polished_deepslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_POLISHED_DEEPSLATE_WALL =
            BLOCKS.register("ancient_polished_deepslate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_DEEPSLATE).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_TILES =
            BLOCKS.register("ancient_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_TILE_STAIRS =
            BLOCKS.register("ancient_deepslate_tile_stairs", () -> new StairBlock(DEEPSLATE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(DEEPSLATE_TILES)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_TILE_SLAB =
            BLOCKS.register("ancient_deepslate_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(DEEPSLATE_TILES)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_TILE_WALL =
            BLOCKS.register("ancient_deepslate_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(DEEPSLATE_TILES).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_BRICKS =
            BLOCKS.register("ancient_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_BRICK_STAIRS =
            BLOCKS.register("ancient_deepslate_brick_stairs", () -> new StairBlock(DEEPSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_BRICK_SLAB =
            BLOCKS.register("ancient_deepslate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_DEEPSLATE_BRICK_WALL =
            BLOCKS.register("ancient_deepslate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(DEEPSLATE_BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> ANCIENT_CHISELED_DEEPSLATE =
            BLOCKS.register("ancient_chiseled_deepslate", () -> new Block(BlockBehaviour.Properties.copy(COBBLED_DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_DEEPSLATE_BRICKS =
            BLOCKS.register("ancient_cracked_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.copy(DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> ANCIENT_CRACKED_DEEPSLATE_TILES =
            BLOCKS.register("ancient_cracked_deepslate_tiles", () -> new Block(BlockBehaviour.Properties.copy(DEEPSLATE_TILES)));
    public static final RegistryObject<Block> ANCIENT_INFESTED_DEEPSLATE =
            BLOCKS.register("ancient_infested_deepslate", () -> new InfestedRotatedPillarBlock(DEEPSLATE, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> ANCIENT_SMOOTH_BASALT =
            BLOCKS.register("ancient_smooth_basalt", () -> new Block(BlockBehaviour.Properties.copy(BASALT)));
    public static final RegistryObject<Block> ANCIENT_RAW_IRON_BLOCK =
            BLOCKS.register("ancient_raw_iron_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_RAW_COPPER_BLOCK =
            BLOCKS.register("ancient_raw_copper_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_RAW_GOLD_BLOCK =
            BLOCKS.register("ancient_raw_gold_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));
    public static final RegistryObject<Block> ANCIENT_POTTED_AZALEA =
            BLOCKS.register("ancient_potted_azalea_bush", () -> flowerPot(AZALEA));
    public static final RegistryObject<Block> ANCIENT_POTTED_FLOWERING_AZALEA =
            BLOCKS.register("ancient_potted_flowering_azalea_bush", () -> flowerPot(FLOWERING_AZALEA));
    public static final RegistryObject<Block> ANCIENT_FROGSPAWN =
            BLOCKS.register("ancient_frogspawn", () -> new FrogspawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).instabreak().noOcclusion().noCollission().sound(SoundType.FROGSPAWN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ANCIENT_REINFORCED_DEEPSLATE =
            BLOCKS.register("ancient_reinforced_deepslate", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE).strength(55.0F, 1200.0F)));
    public static final RegistryObject<Block> ANCIENT_DECORATED_POT =
            BLOCKS.register("ancient_decorated_pot", () -> new DecoratedPotBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion()));




    public static final RegistryObject<Block> ANCIENT_RUINED_BLOCK = BLOCKS.register(
            "ancient_ruined_block",
            () -> new AncientRuinedBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
                    .strength(0.5f) // 比原方块更容易破坏
                    .sound(SoundType.SAND))
    );
    public static final RegistryObject<Block> RUINED_WOOD = BLOCKS.register(
            "ruined_wood", () -> new AncientRuinedBlock(BlockBehaviour.Properties.copy(OAK_WOOD).strength(0.5f) .sound(SoundType.WOOD))
    );
    public static final RegistryObject<Block> RUINED_COBBLESTONE = BLOCKS.register(
            "ruined_cobblestone", () -> new AncientRuinedBlock(BlockBehaviour.Properties.copy(COBBLESTONE).strength(0.5f) .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> ANCIENT_TOWER_BLOCK = BLOCKS.register(
            "ancient_tower_block",
            () -> new AncientTowerBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.0f, 6.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> ZOMBIE_TOMB = BLOCKS.register(
            "zombie_tomb",
            () -> new ZombieTombBlock(BlockBehaviour.Properties.copy(Blocks.SPAWNER)
                    .strength(25.0f, 6.0f) // 高抗爆性，但可以被特殊方式破坏
                    .sound(SoundType.METAL)
                    .noOcclusion())
    );
}