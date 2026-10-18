package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, KaleidoscopeDimensionRealms.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(KDRBlocks.PURPLE_FUJI_LOG.get().asItem())
                .add(KDRBlocks.PURPLE_FUJI_WOOD.get().asItem())
                .add(KDRBlocks.STRIPPED_PURPLE_FUJI_LOG.get().asItem())
                .add(KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD.get().asItem());
        tag(ItemTags.LEAVES)
                .add(KDRBlocks.PURPLE_FUJI_LEAVES.get().asItem());
        tag(ItemTags.PLANKS)
                .add(KDRBlocks.PURPLE_FUJI_PLANKS.get().asItem());
    }
}
