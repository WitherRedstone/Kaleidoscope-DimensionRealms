package com.chinaex123.kaleidoscope_dimension_realms.worldgen.tree;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower {
    public static final TreeGrower PURPLE_FUJI_TREE = new TreeGrower(KaleidoscopeDimensionRealms.MODID + ":ice_ether_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PURPLE_FUJI_TREE_KEY), Optional.empty());
}
