package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.ModConfiguredFeatures;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.ModPlacementFeatures;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.biome.PurpleFujiPlains;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.dimension.Grapeoria;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.ModBiomeModifiers;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.noise.PlainsNoiseGeneratorSettings;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.BIOME, PurpleFujiPlains::bootstrap)
            .add(Registries.DIMENSION_TYPE, Grapeoria::bootstrap)
            .add(Registries.LEVEL_STEM, Grapeoria::bootstrapLevelStem)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacementFeatures::bootstrap)
            .add(Registries.NOISE_SETTINGS, PlainsNoiseGeneratorSettings::bootstrapNoise)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(KaleidoscopeDimensionRealms.MODID));
    }
}
