package com.catoxide.dungeonblockvarient.client;

import com.catoxide.dungeonblockvarient.DungeonBlockVarient;
import com.catoxide.dungeonblockvarient.client.model.AncientModelLoader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DungeonBlockVarient.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {
    @SubscribeEvent
    public static void registerModelLoaders(ModelEvent.RegisterGeometryLoaders event) {
        event.register("ancient_block", AncientModelLoader.INSTANCE);
    }
}