package com.chinaex123.kaleidoscope_dimension_realms.init;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface KDRBlockTags {

    TagKey<Block> GRAPEORIA_DIRT = mcBlockTag("grapeoria_dirt");

    static TagKey<Block> mcBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(KaleidoscopeDimensionRealms.MODID, name));
    }
}
