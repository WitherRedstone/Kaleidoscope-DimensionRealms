package com.chinaex123.kaleidoscope_dimension_realms.worldgen;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacementFeatures {
    public static final ResourceKey<PlacedFeature> PURPLE_FUJI_TREE_PLACED_KEY = createKey("purple_fuji_tree_placed");
    public static final ResourceKey<PlacedFeature> PURPLE_FUJI_FLOWER_PLACED_KEY = createKey("purple_purple_fuji_flower");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        /* 紫藤树 */
        PlacementUtils.register(context, PURPLE_FUJI_TREE_PLACED_KEY, holderGetter.getOrThrow(ModConfiguredFeatures.PURPLE_FUJI_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), KDRBlocks.PURPLE_FUJI_SAPLING.get()));

        /* 紫藤花 */
        PlacementUtils.register(context, PURPLE_FUJI_FLOWER_PLACED_KEY, holderGetter.getOrThrow(ModConfiguredFeatures.PURPLE_FUJI_FLOWER_KEY),
                RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    }

    public static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, key));
    }
}
