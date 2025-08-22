package com.catoxide.dungeonblockvarient.client;

import com.catoxide.dungeonblockvarient.DungeonBlockVarient;
import com.catoxide.dungeonblockvarient.block.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DungeonBlockVarient.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // 在这里注册任何客户端特定的设置
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // 对于不需要特殊渲染的方块实体，可以不注册渲染器
        // 或者使用默认的方块实体渲染器
        // 对于 AncientBlockEntity，我们不需要特殊渲染，所以可以注释掉这行
        // event.registerBlockEntityRenderer(ModBlockEntities.REINFORCED.get(), context -> null);
    }
}