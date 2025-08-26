package com.catoxide.catoxidesdungeon;

import com.catoxide.catoxidesdungeon.blocks.AncientRuinedBlockEntity;
import com.catoxide.catoxidesdungeon.blocks.ZombieTombBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

import static com.mojang.text2speech.Narrator.LOGGER;

@Mod(CatoxidesDungeon.MODID)
@Mod.EventBusSubscriber
public class CatoxidesDungeon {
    public static final String MODID = "catoxidesdungeon";

    public CatoxidesDungeon() {
        // 注册方块和物品
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        com.catoxide.catoxidesdungeon.ModBlockEntities.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());


        // 注册其他事件监听器
        MinecraftForge.EVENT_BUS.register(this);

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {
                System.out.println("Setting up render layers for " + ModBlocks.BLOCKS.getEntries().size() + " blocks");

                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TRIPWIRE.get(), RenderType.tripwire());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GRASS_BLOCK.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_IRON_BARS.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GLASS_PANE.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TRIPWIRE_HOOK.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HOPPER.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHAIN.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_JUNGLE_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_OAK_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPRUCE_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ACACIA_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHERRY_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIRCH_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DARK_OAK_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_AZALEA_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FLOWERING_AZALEA_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_ROOTS.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_LEAVES.get(), RenderType.cutoutMipped());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_OAK_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPRUCE_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIRCH_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_JUNGLE_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ACACIA_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHERRY_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DARK_OAK_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GLASS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WHITE_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ORANGE_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MAGENTA_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_BLUE_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_YELLOW_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIME_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PINK_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GRAY_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_GRAY_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CYAN_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PURPLE_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLUE_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BROWN_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GREEN_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RED_BED.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLACK_BED.get(), RenderType.cutout());
                // ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POWERED_RAIL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DETECTOR_RAIL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_COBWEB.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GRASS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FERN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SEAGRASS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TALL_SEAGRASS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DANDELION.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POPPY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLUE_ORCHID.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ALLIUM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_AZURE_BLUET.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RED_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ORANGE_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WHITE_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PINK_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_OXEYE_DAISY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CORNFLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WITHER_ROSE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LILY_OF_THE_VALLEY.get(), RenderType.cutout());
                //  ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BROWN_MUSHROOM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RED_MUSHROOM.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TORCH.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WALL_TORCH.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SOUL_TORCH.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SOUL_WALL_TORCH.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FIRE.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SOUL_FIRE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPAWNER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_REDSTONE_WIRE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WHEAT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_OAK_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LADDER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RAIL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_IRON_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_REDSTONE_TORCH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_REDSTONE_WALL_TORCH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CACTUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SUGAR_CANE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_REPEATER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_OAK_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPRUCE_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIRCH_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_JUNGLE_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ACACIA_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHERRY_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DARK_OAK_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CRIMSON_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WARPED_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BAMBOO_TRAPDOOR.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ATTACHED_PUMPKIN_STEM.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ATTACHED_MELON_STEM.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PUMPKIN_STEM.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MELON_STEM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_VINE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GLOW_LICHEN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LILY_PAD.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_NETHER_WART.get(), RenderType.cutout());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BREWING_STAND.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_COCOA.get(), RenderType.cutout());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BEACON.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FLOWER_POT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_OAK_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_SPRUCE_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_BIRCH_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_JUNGLE_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_ACACIA_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_CHERRY_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_DARK_OAK_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_MANGROVE_PROPAGULE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_FERN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_DANDELION.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_POPPY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_BLUE_ORCHID.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_ALLIUM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_AZURE_BLUET.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_RED_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_ORANGE_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_WHITE_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_PINK_TULIP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_OXEYE_DAISY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_CORNFLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_LILY_OF_THE_VALLEY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_WITHER_ROSE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_RED_MUSHROOM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_BROWN_MUSHROOM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_DEAD_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_CACTUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_AZALEA.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_FLOWERING_AZALEA.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_TORCHFLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CARROTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTATOES.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_COMPARATOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ACTIVATOR_RAIL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_IRON_TRAPDOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SUNFLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LILAC.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ROSE_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PEONY.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TALL_GRASS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LARGE_FERN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPRUCE_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIRCH_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_JUNGLE_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ACACIA_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHERRY_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DARK_OAK_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BAMBOO_DOOR.get(), RenderType.cutout());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_END_ROD.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHORUS_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CHORUS_FLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TORCHFLOWER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TORCHFLOWER_CROP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PITCHER_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PITCHER_CROP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BEETROOTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_KELP.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_KELP_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TURTLE_EGG.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_TUBE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BRAIN_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BUBBLE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_FIRE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_HORN_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TUBE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BRAIN_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BUBBLE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FIRE_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HORN_CORAL.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_TUBE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BRAIN_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BUBBLE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_FIRE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_HORN_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TUBE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BRAIN_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BUBBLE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FIRE_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HORN_CORAL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_TUBE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BRAIN_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_BUBBLE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_FIRE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_DEAD_HORN_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TUBE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BRAIN_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BUBBLE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FIRE_CORAL_WALL_FAN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HORN_CORAL_WALL_FAN.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SEA_PICKLE.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CONDUIT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BAMBOO_SAPLING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BAMBOO.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_BAMBOO.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SCAFFOLDING.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_STONECUTTER.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LANTERN.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SOUL_LANTERN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CAMPFIRE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SOUL_CAMPFIRE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SWEET_BERRY_BUSH.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WEEPING_VINES.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WEEPING_VINES_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TWISTING_VINES.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TWISTING_VINES_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_NETHER_SPROUTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CRIMSON_FUNGUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WARPED_FUNGUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CRIMSON_ROOTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WARPED_ROOTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_CRIMSON_FUNGUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_WARPED_FUNGUS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_CRIMSON_ROOTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POTTED_WARPED_ROOTS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CRIMSON_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WARPED_DOOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_POINTED_DRIPSTONE.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SMALL_AMETHYST_BUD.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MEDIUM_AMETHYST_BUD.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LARGE_AMETHYST_BUD.get(), RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_AMETHYST_CLUSTER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHTNING_ROD.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CAVE_VINES.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CAVE_VINES_PLANT.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SPORE_BLOSSOM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FLOWERING_AZALEA.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_AZALEA.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MOSS_CARPET.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PINK_PETALS.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIG_DRIPLEAF.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BIG_DRIPLEAF_STEM.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SMALL_DRIPLEAF.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HANGING_ROOTS.get(), RenderType.cutout());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SCULK_SENSOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CALIBRATED_SCULK_SENSOR.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SCULK_VEIN.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SCULK_SHRIEKER.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_PROPAGULE.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MANGROVE_LOG.get(), RenderType.cutout());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FROGSPAWN.get(), RenderType.cutout());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ICE.get(), RenderType.translucent());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_NETHER_PORTAL.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WHITE_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ORANGE_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MAGENTA_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_BLUE_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_YELLOW_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIME_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PINK_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GRAY_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_GRAY_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CYAN_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PURPLE_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLUE_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BROWN_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GREEN_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RED_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLACK_STAINED_GLASS.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_WHITE_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_ORANGE_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_MAGENTA_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_BLUE_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_YELLOW_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIME_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PINK_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GRAY_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_LIGHT_GRAY_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_CYAN_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_PURPLE_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLUE_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BROWN_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_GREEN_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_RED_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BLACK_STAINED_GLASS_PANE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_SLIME_BLOCK.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_HONEY_BLOCK.get(), RenderType.translucent());
                //ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_FROSTED_ICE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_BUBBLE_COLUMN.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModBlocks.ANCIENT_TINTED_GLASS.get(), RenderType.translucent());

            });
        }
    }
    // 初始化可转换方块集合
    private static final Set<Block> CONVERTIBLE_BLOCKS = new HashSet<>();
    // 添加一个处理中的标记，防止递归调用
    private static final Set<BlockPos> PROCESSING_POSITIONS = new HashSet<>();

    private void initializeConvertibleBlocks() {
        // 添加需要转换为废墟方块的方块
        CONVERTIBLE_BLOCKS.add(ModBlocks.ANCIENT_STONE.get());
        CONVERTIBLE_BLOCKS.add(ModBlocks.ANCIENT_COBBLESTONE.get());
        CONVERTIBLE_BLOCKS.add(ModBlocks.ANCIENT_BRICKS.get());
        // 添加更多需要转换的方块...

        LOGGER.info("Initialized {} convertible blocks", CONVERTIBLE_BLOCKS.size());
    }

    // 监听玩家破坏事件 - 使用高优先级确保在其他处理前执行
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        BlockState state = event.getState();
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();

        // 防止递归调用
        if (PROCESSING_POSITIONS.contains(pos)) {
            return;
        }

        // 检查是否是僵尸巢穴
        if (state.getBlock() instanceof ZombieTombBlock) {
            // 检查是否使用特殊方式破坏
            if (!ZombieTombBlock.shouldBreak(level, pos)) {
                // 如果不是特殊方式，取消破坏事件
                event.setCanceled(true);
                // 可以给玩家提示
                if (player != null) {
                    player.displayClientMessage(Component.translatable("message.catoxidesdungeon.zombie_nest_resistant"), true);
                }
            }
            // 如果是特殊方式破坏，让事件正常进行
            return;
        }

        // 记录被破坏的方块信息
        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(state.getBlock());

        // 检查是否是模组内的方块且不是废墟方块
        if (blockId != null && blockId.getNamespace().equals(CatoxidesDungeon.MODID) &&
                !state.getBlock().equals(ModBlocks.ANCIENT_RUINED_BLOCK.get())) {

            // 检查是否在可转换列表中
            if (CONVERTIBLE_BLOCKS.contains(state.getBlock())) {
                LOGGER.info("Player breaking convertible block: {} at {}", blockId, pos);

                // 检查是否使用精准采集
                boolean usingSilkTouch = player != null &&
                        player.getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH) > 0;

                if (!usingSilkTouch) {
                    // 取消原事件
                    event.setCanceled(true);

                    // 标记为正在处理，防止递归
                    PROCESSING_POSITIONS.add(pos.immutable());

                    // 概率生成废墟方块 (例如 30% 概率)
                    if (level.random.nextFloat() < 0.3f) {
                        LOGGER.info("Creating ruined block from player break");
                        // 先移除原方块，再设置新方块
                        level.removeBlock(pos, false);
                        level.setBlock(pos, ModBlocks.ANCIENT_RUINED_BLOCK.get().defaultBlockState(), 3);

                        // 设置方块实体数据
                        if (level.getBlockEntity(pos) instanceof AncientRuinedBlockEntity ruinedEntity) {
                            ruinedEntity.setOriginalBlock(state.getBlock());
                        }
                    } else {
                        // 直接破坏方块，触发正常的掉落
                        level.destroyBlock(pos, true, player);
                    }

                    // 处理完成，移除标记
                    PROCESSING_POSITIONS.remove(pos);
                }
            }
        }
    }

    // 监听爆炸事件 - 使用高优先级
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onExplosionDetonate(ExplosionEvent.Detonate event) {
        Level level = event.getLevel();
        Explosion explosion = event.getExplosion();

        LOGGER.info("Explosion detected at {}", explosion.getPosition());

        // 创建一个列表来存储需要处理的方块位置
        Set<BlockPos> blocksToProcess = new HashSet<>();

        // 检查爆炸影响的方块
        for (BlockPos pos : event.getAffectedBlocks()) {
            // 防止递归调用
            if (PROCESSING_POSITIONS.contains(pos)) {
                continue;
            }

            BlockState state = level.getBlockState(pos);
            ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(state.getBlock());

            // 检查是否是僵尸巢穴
            if (state.getBlock() instanceof ZombieTombBlock) {
                // 僵尸巢穴可以被爆炸破坏
                PROCESSING_POSITIONS.add(pos.immutable());
                level.destroyBlock(pos, false);
                PROCESSING_POSITIONS.remove(pos);
                continue;
            }

            // 检查是否是模组内的可转换方块且不是废墟方块
            if (blockId != null && blockId.getNamespace().equals(CatoxidesDungeon.MODID) &&
                    !state.getBlock().equals(ModBlocks.ANCIENT_RUINED_BLOCK.get()) &&
                    CONVERTIBLE_BLOCKS.contains(state.getBlock())) {

                LOGGER.info("Mod block {} will be destroyed by explosion at {}", blockId, pos);
                blocksToProcess.add(pos.immutable()); // 使用不可变的位置
            }
        }

        // 从爆炸影响列表中移除这些方块，防止被爆炸破坏
        event.getAffectedBlocks().removeAll(blocksToProcess);

        // 处理这些方块
        for (BlockPos pos : blocksToProcess) {
            // 标记为正在处理
            PROCESSING_POSITIONS.add(pos.immutable());

            BlockState originalState = level.getBlockState(pos);

            // 概率生成废墟方块
            if (level.random.nextFloat() < 0.3f) {
                // 先移除原方块
                level.removeBlock(pos, false);
                level.setBlock(pos, ModBlocks.ANCIENT_RUINED_BLOCK.get().defaultBlockState(), 3);

                if (level.getBlockEntity(pos) instanceof AncientRuinedBlockEntity ruinedEntity) {
                    ruinedEntity.setOriginalBlock(originalState.getBlock());
                    LOGGER.info("Set original block in ruined entity from explosion: {}",
                            ForgeRegistries.BLOCKS.getKey(originalState.getBlock()));
                }
            } else {
                // 直接破坏方块
                level.destroyBlock(pos, false); // 不掉落物品，因为爆炸通常不会掉落物品
            }

            // 处理完成，移除标记
            PROCESSING_POSITIONS.remove(pos);
        }
    }

}