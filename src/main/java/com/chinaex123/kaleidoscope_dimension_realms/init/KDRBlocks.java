package com.chinaex123.kaleidoscope_dimension_realms.init;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import com.chinaex123.kaleidoscope_dimension_realms.block.ModLeavesBlock;
import com.chinaex123.kaleidoscope_dimension_realms.block.ModPlankBlock;
import com.chinaex123.kaleidoscope_dimension_realms.block.ModRotatedPillarBlock;
import com.chinaex123.kaleidoscope_dimension_realms.block.ModSaplingBlock;
import com.chinaex123.kaleidoscope_dimension_realms.worldgen.tree.ModTreeGrower;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class KDRBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(KaleidoscopeDimensionRealms.MODID);

    // ==================== 紫葡平原 ====================

    // 地表方块
    /** 紫藤覆层 */
    public static final DeferredBlock<Block> PURPLE_FUJI_TURF = registerBlocks("purple_fuji_turf",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.0F).mapColor(MapColor.STONE).sound(SoundType.GRAVEL).requiresCorrectToolForDrops()));
    /** 紫藤土 */
    public static final DeferredBlock<Block> PURPLE_FUJI_SOIL = registerBlocks("purple_fuji_soil",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).mapColor(MapColor.DIRT).sound(SoundType.GRAVEL).requiresCorrectToolForDrops()));
    /** 紫藤砂 */
    public static final DeferredBlock<Block> PURPLE_FUJI_SAND = registerBlocks("purple_fuji_sand",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).mapColor(MapColor.SAND).sound(SoundType.SAND).requiresCorrectToolForDrops()));

    // 地下方块
    /** 紫藤石 */
    public static final DeferredBlock<Block> PURPLE_FUJI_STONE = registerBlocks("purple_fuji_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    /** 发酵紫藤块 */
    public static final DeferredBlock<Block> FERMENTED_FUJI_GRAPE_BLOCK = registerBlocks("fermented_fuji_grape_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.5F).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).requiresCorrectToolForDrops()));

    // 地物
    /** 紫藤藤丛 */
    public static final DeferredBlock<Block> PURPLE_FUJI_VINE_CLUSTER = registerBlocks("purple_fuji_vine_cluster",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.2F).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.GRASS).noOcclusion()));
    /** 紫藤浆果丛 */
    public static final DeferredBlock<Block> PURPLE_FUJI_BERRY_BUSH = registerBlocks("purple_fuji_berry_bush",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.2F).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.GRASS).noOcclusion()));
    /** 紫藤花 */
    public static final DeferredBlock<Block> PURPLE_FUJI_FLOWER = registerBlocks("purple_fuji_flower",
            () -> new FlowerBlock(MobEffects.NIGHT_VISION, 4f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    /** 盆栽紫藤花 */
    public static final DeferredBlock<Block> POTTED_PURPLE_FUJI_FLOWER = BLOCKS.register("potted_purple_fuji_flower",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_FUJI_FLOWER, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));

    // 树相关方块
    /** 紫藤木树苗 */
    public static final DeferredBlock<ModSaplingBlock> PURPLE_FUJI_SAPLING = registerBlocks("purple_fuji_sapling",
            () -> new ModSaplingBlock(ModTreeGrower.PURPLE_FUJI_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    /** 紫藤原木 */
    public static final DeferredBlock<ModRotatedPillarBlock> PURPLE_FUJI_LOG = registerBlocks("purple_fuji_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    /** 紫藤木 */
    public static final DeferredBlock<ModRotatedPillarBlock> PURPLE_FUJI_WOOD = registerBlocks("purple_fuji_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));;
    /** 去皮紫藤原木 */
    public static final DeferredBlock<ModRotatedPillarBlock> STRIPPED_PURPLE_FUJI_LOG = registerBlocks("stripped_purple_fuji_log",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    /** 去皮紫藤木 */
    public static final DeferredBlock<ModRotatedPillarBlock> STRIPPED_PURPLE_FUJI_WOOD = registerBlocks("stripped_purple_fuji_wood",
            () -> new ModRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    /** 紫藤树叶 */
    public static final DeferredBlock<ModLeavesBlock> PURPLE_FUJI_LEAVES = registerBlocks("purple_fuji_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    /** 紫藤木板 */
    public static final DeferredBlock<ModPlankBlock> PURPLE_FUJI_PLANKS = registerBlocks("purple_fuji_planks",
            () -> new ModPlankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));







    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        KDRItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> block) {
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}