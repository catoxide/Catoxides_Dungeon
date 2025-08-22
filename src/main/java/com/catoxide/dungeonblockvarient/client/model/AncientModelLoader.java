package com.catoxide.dungeonblockvarient.client.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IGeometryLoader;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;

import java.util.function.Function;

public class AncientModelLoader implements IGeometryLoader<AncientModelLoader.AncientModelGeometry> {
    public static final AncientModelLoader INSTANCE = new AncientModelLoader();

    @Override
    public AncientModelGeometry read(JsonObject jsonObject, JsonDeserializationContext deserializationContext) {
        return new AncientModelGeometry();
    }

    public static class AncientModelGeometry implements IUnbakedGeometry<AncientModelGeometry> {
        @Override
        public BakedModel bake(IGeometryBakingContext context, ModelBaker baker, Function<Material, net.minecraft.client.renderer.texture.TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation) {
            // 直接返回我们的自定义模型
            return new AncientBakedModel();
        }
    }
}