package com.chinaex123.kaleidoscope_dimension_realms.init;

import com.github.ysbbbbbb.kaleidoscopetavern.init.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

import static com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks.BLOCKS;

public interface KDRFluidBlocks {

    /** 葡萄汁 */
    DeferredBlock<LiquidBlock> GRAPE_JUICE_BLOCK = register("grape_juice_block", ModFluids.GRAPE_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);
    /** 冰葡萄汁 */
    DeferredBlock<LiquidBlock> ICE_GRAPE_JUICE_BLOCK = register("ice_grape_juice_block", ModFluids.ICE_GRAPE_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);
    /** 黄金葡萄汁 */
    DeferredBlock<LiquidBlock> GOLD_GRAPE_JUICE_BLOCK = register("gold_grape_juice_block", ModFluids.GOLD_GRAPE_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);
    /** 青提葡萄汁 */
    DeferredBlock<LiquidBlock> GREEN_GRAPE_JUICE_BLOCK = register("green_grape_juice_block", ModFluids.GREEN_GRAPE_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);
    /** 甜浆果汁 */
    DeferredBlock<LiquidBlock> SWEET_BERRIES_JUICE_BLOCK = register("sweet_berries_juice_block", ModFluids.SWEET_BERRIES_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);
    /** 发光浆果汁 */
    DeferredBlock<LiquidBlock> GLOW_BERRIES_JUICE_BLOCK = register("glow_berries_juice_block", ModFluids.GLOW_BERRIES_JUICE, 100.0F, 0.8F, 0.5F, 0.5F, MapColor.WATER);

    private static DeferredBlock<LiquidBlock> register(String name, Supplier<? extends BaseFlowingFluid.Source> fluid,
                                                       float hardness, float friction, float speedFactor, float jumpFactor, MapColor mapColor) {
        return BLOCKS.register(name, () -> new LiquidBlock(fluid.get(), BlockBehaviour.Properties.of()
                .noLootTable().liquid().replaceable().noCollission().strength(hardness).friction(friction)
                .speedFactor(speedFactor).jumpFactor(jumpFactor).mapColor(mapColor).sound(SoundType.EMPTY)));
    }
}
