package com.chinaex123.kaleidoscope_dimension_realms.worldgen;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_FUJI_TREE_KEY = createKey("purple_fuji_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPLE_FUJI_FLOWER_KEY = createKey("purple_fuji_flower");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        /* 紫藤树 */
        FeatureUtils.register(context, PURPLE_FUJI_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(KDRBlocks.PURPLE_FUJI_LOG.get()),
                        new StraightTrunkPlacer(4, 2, 1),
                        BlockStateProvider.simple(KDRBlocks.PURPLE_FUJI_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .dirt(BlockStateProvider.simple(KDRBlocks.PURPLE_FUJI_TURF.get()))
                        .forceDirt()
                        .build());

        /* 紫藤花 */
        FeatureUtils.register(context, PURPLE_FUJI_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 4, 3,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(KDRBlocks.PURPLE_FUJI_FLOWER.get())))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, name));
    }
}