package com.chinaex123.kaleidoscope_dimension_realms.mixin;

import com.chinaex123.kaleidoscope_dimension_realms.util.FluidColors;
import com.github.ysbbbbbb.kaleidoscopetavern.fluid.JuiceFluidType;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(JuiceFluidType.class)
public class JuiceFluidTypeMixin {

    @Inject(method = "initializeClient", at = @At("HEAD"), cancellable = true)
    private void kdr$injectFog(Consumer<IClientFluidTypeExtensions> consumer, CallbackInfo ci) {
        JuiceFluidType self = (JuiceFluidType) (Object) this;
        ResourceLocation id = self.getId();
        Vector3f fog = FluidColors.getFogColor(id);

        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/%s_still".formatted(id.getPath()));
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/%s_flow".formatted(id.getPath()));
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fog;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(0.5f);
                RenderSystem.setShaderFogEnd(4.0f);
            }
        });

        ci.cancel();
    }
}