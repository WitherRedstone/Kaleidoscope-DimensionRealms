package com.chinaex123.kaleidoscope_dimension_realms.worldgen.biome;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

/** 紫葡平原 */
public class PurpleFujiPlains {

    public static final ResourceKey<Biome> PURPLE_FUJI_PLAINS_BIOME = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, "purple_fuji_plains"));

    /**
     * 构建 紫葡平原 实例。
     *
     * @param context 数据包引导上下文，提供已放置特征与雕刻器的注册表查询
     * @return 构建完成的虚空群系
     */
    public static Biome purpleFujiPlainsBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();

        // 怪物生成
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.SPIDER, 100, 4, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.ZOMBIE, 95, 4, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.SKELETON, 100, 4, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.CREEPER, 100, 4, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.SLIME, 100, 4, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.ENDERMAN, 10, 1, 4));
//        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
//                EntityType.WITCH, 5, 1, 1));
        // 被动生物
        spawnSettings.creatureGenerationProbability(0.3f);

        // 地形生成设置：使用上下文中的已放置特征与配置雕刻器
        BiomeGenerationSettings.Builder generationSettings =
                new BiomeGenerationSettings.Builder(
                        context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        // 植被装饰阶段
//        generationSettings.addFeature(
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                ModPlacementFeatures.PURPLE_FUJI_TREE_PLACED_KEY
//        );

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true) // 是否降水
                .temperature(0.8f) // 温度
                .downfall(0.4f) // 湿度
                .generationSettings(generationSettings.build()) // 地形生成设置
                .mobSpawnSettings(spawnSettings.build()) // 生物生成设置
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(16766185) // 天空颜色
                        .fogColor(16772854) // 雾颜色
                        .waterColor(16487397) // 水颜色
                        .waterFogColor(16631025) // 水雾颜色
                        .build())
                .build();
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(PURPLE_FUJI_PLAINS_BIOME, purpleFujiPlainsBiome(context));
    }
}
