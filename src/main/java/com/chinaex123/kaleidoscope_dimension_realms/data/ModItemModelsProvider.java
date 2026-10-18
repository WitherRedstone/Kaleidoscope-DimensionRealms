package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaleidoscopeDimensionRealms.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockItem(KDRBlocks.PURPLE_FUJI_SAPLING);
        blockItem(KDRBlocks.POTTED_PURPLE_FUJI_FLOWER);
    }

    private <T extends Block> void blockItem(DeferredBlock<T> block) {
        withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", KaleidoscopeDimensionRealms.id("block/" + block.getId().getPath()));
    }
}
