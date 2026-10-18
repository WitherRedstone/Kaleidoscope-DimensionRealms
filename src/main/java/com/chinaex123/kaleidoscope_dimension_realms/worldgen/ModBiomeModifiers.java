package com.chinaex123.kaleidoscope_dimension_realms.worldgen;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.biome.PurpleFujiPlains;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_PURPLE_FUJI_TREE = registerKey("add_purple_fuji_tree");
    public static final ResourceKey<BiomeModifier> ADD_PURPLE_FUJI_FLOWER = registerKey("add_purple_fuji_flower");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        /* 紫藤树 */
        context.register(ADD_PURPLE_FUJI_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(PurpleFujiPlains.PURPLE_FUJI_PLAINS_BIOME)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacementFeatures.PURPLE_FUJI_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        /* 紫藤花 */
        context.register(ADD_PURPLE_FUJI_FLOWER, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(PurpleFujiPlains.PURPLE_FUJI_PLAINS_BIOME),
                HolderSet.direct(biomes.getOrThrow(PurpleFujiPlains.PURPLE_FUJI_PLAINS_BIOME)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacementFeatures.PURPLE_FUJI_FLOWER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, name));
    }
}