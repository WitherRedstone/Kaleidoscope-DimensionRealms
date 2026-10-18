package com.chinaex123.kaleidoscope_dimension_realms.data;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KaleidoscopeDimensionRealms.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // ==================== 紫葡平原 ====================
        // 地物
        simpleBlock(KDRBlocks.PURPLE_FUJI_FLOWER.get(), models().cross("purple_fuji_flower", modLoc("block/purple_fuji_flower")).renderType("cutout"));
        pottedFlower(KDRBlocks.POTTED_PURPLE_FUJI_FLOWER, "purple_fuji_flower");
        // 树相关方块
        logBlock((RotatedPillarBlock) KDRBlocks.PURPLE_FUJI_LOG.get());
        axisBlock((RotatedPillarBlock) KDRBlocks.PURPLE_FUJI_WOOD.get(), blockTexture(KDRBlocks.PURPLE_FUJI_LOG.get()), blockTexture(KDRBlocks.PURPLE_FUJI_LOG.get()));
        axisBlock((RotatedPillarBlock) KDRBlocks.STRIPPED_PURPLE_FUJI_LOG.get(), KaleidoscopeDimensionRealms.id("block/stripped_purple_fuji_log"),
                KaleidoscopeDimensionRealms.id("block/stripped_purple_fuji_log_top"));
        axisBlock((RotatedPillarBlock) KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD.get(), KaleidoscopeDimensionRealms.id("block/stripped_purple_fuji_log"),
                KaleidoscopeDimensionRealms.id("block/stripped_purple_fuji_log_top"));
        blockItem(KDRBlocks.PURPLE_FUJI_LOG);
        blockItem(KDRBlocks.PURPLE_FUJI_WOOD);
        blockItem(KDRBlocks.STRIPPED_PURPLE_FUJI_LOG);
        blockItem(KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD);
        simpleBlockWithItem(KDRBlocks.PURPLE_FUJI_PLANKS.get(), cubeAll(KDRBlocks.PURPLE_FUJI_PLANKS.get()));
        simpleBlockWithItem(KDRBlocks.PURPLE_FUJI_LEAVES.get(),
                models().cubeAll("purple_fuji_leaves", modLoc("block/purple_fuji_leaves")).renderType("cutout"));
        simpleBlock(KDRBlocks.PURPLE_FUJI_SAPLING.get(),
                models().cross("purple_fuji_sapling", modLoc("block/purple_fuji_sapling")).renderType("cutout"));

    }

    private <T extends Block> void pottedFlower(DeferredBlock<T> block, String name) {
        simpleBlock(block.get(), models().withExistingParent(block.getId().getPath(), mcLoc("block/flower_pot_cross"))
                .texture("plant", modLoc("block/" + name)).renderType("cutout"));
    }

    private void blockItem(DeferredBlock<?> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(KaleidoscopeDimensionRealms.MODID + ":block/" + block.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> block, String append) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(KaleidoscopeDimensionRealms.MODID + ":block/" + block.getId().getPath() + append));
    }
}
