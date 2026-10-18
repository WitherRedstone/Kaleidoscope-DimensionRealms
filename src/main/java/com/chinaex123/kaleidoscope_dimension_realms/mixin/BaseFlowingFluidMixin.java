package com.chinaex123.kaleidoscope_dimension_realms.mixin;

import com.chinaex123.kaleidoscope_dimension_realms.init.KDRFluidBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseFlowingFluid.class)
public abstract class BaseFlowingFluidMixin {

    @Unique
    private static DeferredBlock<LiquidBlock> kaleidoscope$blockFor(BaseFlowingFluid fluid) {
        ResourceLocation key = BuiltInRegistries.FLUID.getKey(fluid);
        if (!key.getNamespace().equals("kaleidoscope_tavern")) return null;

        String path = key.getPath();
        if (path.startsWith("flowing_")) {
            path = path.substring("flowing_".length());
        }

        return switch (path) {
            case "grape_juice" -> KDRFluidBlocks.GRAPE_JUICE_BLOCK;
            case "ice_grape_juice" -> KDRFluidBlocks.ICE_GRAPE_JUICE_BLOCK;
            case "gold_grape_juice" -> KDRFluidBlocks.GOLD_GRAPE_JUICE_BLOCK;
            case "green_grape_juice" -> KDRFluidBlocks.GREEN_GRAPE_JUICE_BLOCK;
            case "sweet_berries_juice" -> KDRFluidBlocks.SWEET_BERRIES_JUICE_BLOCK;
            case "glow_berries_juice" -> KDRFluidBlocks.GLOW_BERRIES_JUICE_BLOCK;
            default -> null;
        };
    }

    @Inject(method = "createLegacyBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private void kaleidoscope$injectJuiceBlock(FluidState state, CallbackInfoReturnable<BlockState> cir) {
        BaseFlowingFluid fluid = (BaseFlowingFluid) (Object) this;
        DeferredBlock<LiquidBlock> block = kaleidoscope$blockFor(fluid);
        if (block == null) return;

        int levelValue;
        if (state.isSource()) {
            levelValue = 0;
        } else {
            levelValue = 8 - Math.min(state.getAmount(), 8);
            if (state.getValue(FlowingFluid.FALLING)) {
                levelValue += 8;
            }
        }

        BlockState liquidState = block.get()
                .defaultBlockState()
                .setValue(LiquidBlock.LEVEL, levelValue);

        cir.setReturnValue(liquidState);
    }

    @Inject(method = "getTickDelay", at = @At("HEAD"), cancellable = true, remap = false)
    private void kaleidoscope$slowDownJuice(LevelReader level, CallbackInfoReturnable<Integer> cir) {
        BaseFlowingFluid fluid = (BaseFlowingFluid) (Object) this;
        if (kaleidoscope$blockFor(fluid) == null) return;
        cir.setReturnValue(15);
    }
}