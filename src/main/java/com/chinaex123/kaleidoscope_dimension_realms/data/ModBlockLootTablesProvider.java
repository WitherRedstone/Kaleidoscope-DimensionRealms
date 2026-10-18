package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // ==================== 紫葡平原 ====================
        // 地物
        dropSelf(KDRBlocks.PURPLE_FUJI_FLOWER.get());
        add(KDRBlocks.POTTED_PURPLE_FUJI_FLOWER.get(), createPotFlowerItemTable(KDRBlocks.POTTED_PURPLE_FUJI_FLOWER.get()));
        // 地表方块
        dropSelf(KDRBlocks.PURPLE_FUJI_TURF.get());
        dropSelf(KDRBlocks.PURPLE_FUJI_SOIL.get());
        dropSelf(KDRBlocks.PURPLE_FUJI_SAND.get());
        // 地下方块
        dropSelf(KDRBlocks.PURPLE_FUJI_STONE.get());
        dropSelf(KDRBlocks.FERMENTED_FUJI_GRAPE_BLOCK.get());
        // 地物
        dropSelf(KDRBlocks.PURPLE_FUJI_FLOWER.get());
        // 树相关方块
        dropSelf(KDRBlocks.PURPLE_FUJI_LOG.get());
        dropSelf(KDRBlocks.PURPLE_FUJI_WOOD.get());
        dropSelf(KDRBlocks.STRIPPED_PURPLE_FUJI_LOG.get());
        dropSelf(KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD.get());
        dropSelf(KDRBlocks.PURPLE_FUJI_PLANKS.get());
        add(KDRBlocks.PURPLE_FUJI_LEAVES.get(), createLeavesDrops(KDRBlocks.PURPLE_FUJI_LEAVES.get(), KDRBlocks.PURPLE_FUJI_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(KDRBlocks.PURPLE_FUJI_SAPLING.get());
    }
}
