package com.chinaex123.kaleidoscope_dimension_realms.init;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class KDRCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaleidoscopeDimensionRealms.MODID);

    public static final Supplier<CreativeModeTab> KALEIDOSPE_REALMS_TAB =
            CREATIVE_MODE_TAB.register("kaleidoscope_dimension_realms_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(KDRBlocks.PURPLE_FUJI_TURF.get()))
                    .title(Component.translatable("itemGroup.kaleidoscope_dimension_realms"))
                    .displayItems((parameters, output) -> {

                        // ==================== 紫葡平原 ====================
                        // 地表方块
                        output.accept(KDRBlocks.PURPLE_FUJI_TURF.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_SOIL.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_SAND.get());
                        // 地下方块
                        output.accept(KDRBlocks.PURPLE_FUJI_STONE.get());
                        output.accept(KDRBlocks.FERMENTED_FUJI_GRAPE_BLOCK.get());
                        // 地物
                        output.accept(KDRBlocks.PURPLE_FUJI_VINE_CLUSTER.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_BERRY_BUSH.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_FLOWER.get());
                        // 树相关方块
                        output.accept(KDRBlocks.PURPLE_FUJI_SAPLING.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_LOG.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_WOOD.get());
                        output.accept(KDRBlocks.STRIPPED_PURPLE_FUJI_LOG.get());
                        output.accept(KDRBlocks.STRIPPED_PURPLE_FUJI_WOOD.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_LEAVES.get());
                        output.accept(KDRBlocks.PURPLE_FUJI_PLANKS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
