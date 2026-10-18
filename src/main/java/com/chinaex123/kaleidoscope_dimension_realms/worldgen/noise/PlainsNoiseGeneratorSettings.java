package com.chinaex123.kaleidoscope_dimension_realms.worldgen.noise;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRFluidBlocks;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.biome.PurpleFujiPlains;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

// 定义平原噪声生成设置类
public class PlainsNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> GRAPEORIA_NOISE =
            ResourceKey.create(Registries.NOISE_SETTINGS, KaleidoscopeDimensionRealms.id("grapeoria_noise"));

    // 引导方法：在数据生成阶段注册自定义噪声生成设置
    public static void bootstrapNoise(BootstrapContext<NoiseGeneratorSettings> context) {
        // 获取原版 OVERWORLD 作为地形骨架模板
        NoiseGeneratorSettings vanilla = NoiseGeneratorSettings.overworld(context, false, false);

        // 获取原版噪声路由
        NoiseRouter vanillaRouter = vanilla.noiseRouter();
        // 提取原版的最终密度函数
        DensityFunction originalFinalDensity = vanillaRouter.finalDensity();

        // 将原版密度乘以 0.3，使地形整体变得更平缓（起伏减小）
        DensityFunction flattenedDensity = DensityFunctions.mul(DensityFunctions.constant(0.3), originalFinalDensity);

        // 将密度值限制，防止地形过于极端
        DensityFunction clampedDensity = flattenedDensity.clamp(-0.5, 0.5);

        // 构建自定义噪声路由，复用原版的大部分噪声函数，仅替换最终密度
        NoiseRouter customRouter = new NoiseRouter(
                vanillaRouter.barrierNoise(),                   // 屏障噪声
                vanillaRouter.fluidLevelFloodednessNoise(),     // 流体淹没程度噪声
                vanillaRouter.fluidLevelSpreadNoise(),          // 流体扩散噪声
                DensityFunctions.constant(0),             // 岩浆噪声
                vanillaRouter.temperature(),                    // 温度噪声
                vanillaRouter.vegetation(),                     // 植被噪声
                vanillaRouter.continents(),                     // 大陆性噪声
                vanillaRouter.erosion(),                        // 侵蚀噪声
                vanillaRouter.depth(),                          // 深度噪声
                vanillaRouter.ridges(),                         // 山脊噪声
                vanillaRouter.initialDensityWithoutJaggedness(),// 初始密度
                clampedDensity,                                 // 自定义的最终密度
                vanillaRouter.veinToggle(),                     // 矿脉开关噪声
                vanillaRouter.veinRidged(),                     // 矿脉脊状噪声
                vanillaRouter.veinGap()                         // 矿脉间隙噪声
        );

        // 构建自定义地表规则
        SurfaceRules.RuleSource customSurface = buildCustomSurfaceRule(context);

        // 创建自定义噪声生成设置
        NoiseGeneratorSettings custom = new NoiseGeneratorSettings(
                vanilla.noiseSettings(),           // 噪声设置
                vanilla.defaultBlock(),            // 默认方块
                KDRFluidBlocks.GRAPE_JUICE_BLOCK.get().defaultBlockState(), // 默认流体
                customRouter,                      // 自定义噪声路由
                customSurface,                     // 自定义地表规则
                vanilla.spawnTarget(),             // 生成目标
                vanilla.seaLevel(),                // 海平面高度
                vanilla.disableMobGeneration(),    // 是否禁用生物生成
                vanilla.isAquifersEnabled(),       // 是否启用含水层
                false,                             // 是否启用矿脉
                vanilla.useLegacyRandomSource()    // 是否使用旧版随机源
        );

        // 将自定义噪声生成设置注册到注册表中
        context.register(GRAPEORIA_NOISE, custom);
    }

    /*
     * 自定义地表规则
     */
    private static SurfaceRules.RuleSource buildCustomSurfaceRule(BootstrapContext<?> context) {
        SurfaceRules.RuleSource turf = SurfaceRules.state(KDRBlocks.PURPLE_FUJI_TURF.get().defaultBlockState());
        SurfaceRules.RuleSource soil = SurfaceRules.state(KDRBlocks.PURPLE_FUJI_SOIL.get().defaultBlockState());
        SurfaceRules.RuleSource sand = SurfaceRules.state(KDRBlocks.PURPLE_FUJI_SAND.get().defaultBlockState());
        SurfaceRules.RuleSource stone = SurfaceRules.state(KDRBlocks.PURPLE_FUJI_STONE.get().defaultBlockState());

        // 紫葡平原的地表分层
        SurfaceRules.RuleSource purpleFujiSurface = SurfaceRules.sequence(
                // 地表 1 格
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), turf),
                // 往下 4 格
                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(4, false, CaveSurface.FLOOR), soil),
                stone
        );

        // 返回组合后的完整地表规则
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(PurpleFujiPlains.PURPLE_FUJI_PLAINS_BIOME), purpleFujiSurface), stone);
    }
}