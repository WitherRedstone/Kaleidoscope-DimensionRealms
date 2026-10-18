package com.chinaex123.kaleidoscope_dimension_realms.worldgen.dimension;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.biome.PurpleFujiPlains;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.noise.PlainsNoiseGeneratorSettings;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.OptionalLong;

/** 果葡乐园 */
public class Grapeoria {

    /** 维度整体 */
    public static final ResourceKey<LevelStem> GRAPEORIA_LEVEL_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, "grapeoria"));
    /** 维度 */
    public static final ResourceKey<Level> GRAPEORIA_KEY = ResourceKey.create(Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, "grapeoria"));
    /** 维度类型 */
    public static final ResourceKey<DimensionType> GRAPEORIA_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, "grapeoria_type"));

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        context.register(GRAPEORIA_DIMENSION_TYPE, new DimensionType(
                OptionalLong.empty(),
                true, // 是否有天空光照
                false, // 是否有天花板
                false, // 水是否会蒸发
                true, // 是否自然维度
                1.0, // 坐标缩放比例
                true, // 床是否能正常使用
                false, // 重生锚是否可用
                -64, // 最低建筑高度
                384, // 总高度
                384, // 逻辑高度
                BlockTags.INFINIBURN_OVERWORLD, // 无限燃烧方块标签
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // 环境效果位置
                0.0f, // 环境光照强度
                new DimensionType.MonsterSettings(
                        false, // 猪灵是否会僵尸化
                        false, // 是否会发生袭击
                        UniformInt.of(0, 7), // 怪物生成的光照条件
                        0 // 方块光照上限
                )));
    }

    public static void bootstrapLevelStem(BootstrapContext<LevelStem> context) {
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);

        Holder<Biome> purpleFujiPlains = biomes.getOrThrow(PurpleFujiPlains.PURPLE_FUJI_PLAINS_BIOME);
        FixedBiomeSource biomeSource = new FixedBiomeSource(purpleFujiPlains);

        Holder<NoiseGeneratorSettings> overworldSettings = noiseSettings.getOrThrow(PlainsNoiseGeneratorSettings.GRAPEORIA_NOISE);

        ChunkGenerator generator = new NoiseBasedChunkGenerator(biomeSource, overworldSettings);

        context.register(GRAPEORIA_LEVEL_KEY, new LevelStem(dimTypes.getOrThrow(GRAPEORIA_DIMENSION_TYPE), generator));
    }
}
