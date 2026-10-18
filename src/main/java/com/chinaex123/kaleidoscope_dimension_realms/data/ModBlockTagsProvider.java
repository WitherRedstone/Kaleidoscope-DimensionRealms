package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlockTags;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KaleidoscopeDimensionRealms.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.LOGS_THAT_BURN)
                .add(KDRBlocks.PURPLE_FUJI_LOG.get())
                .add(KDRBlocks.PURPLE_FUJI_WOOD.get())
                .add(KDRBlocks.STRIPPED_PURPLE_FUJI_LOG.get())
                .add(KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD.get());
        tag(BlockTags.LEAVES)
                .add(KDRBlocks.PURPLE_FUJI_LEAVES.get());
        tag(BlockTags.PLANKS)
                .add(KDRBlocks.PURPLE_FUJI_PLANKS.get());

        tag(KDRBlockTags.GRAPEORIA_DIRT)
                .add(KDRBlocks.PURPLE_FUJI_TURF.get())
                .add(KDRBlocks.PURPLE_FUJI_SOIL.get());
    }
}
