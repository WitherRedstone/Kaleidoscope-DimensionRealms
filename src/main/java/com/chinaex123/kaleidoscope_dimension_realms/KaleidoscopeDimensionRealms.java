package com.chinaex123.kaleidoscope_dimension_realms;

import com.chinaex123.kaleidoscope_dimension_realms.init.KDRBlocks;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRCreativeTabs;
import com.chinaex123.kaleidoscope_dimension_realms.init.KDRItems;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(KaleidoscopeDimensionRealms.MODID)
public class KaleidoscopeDimensionRealms {
    public static final String MODID = "kaleidoscope_dimension_realms";
    public static final Logger LOGGER = LogUtils.getLogger();

    public KaleidoscopeDimensionRealms(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        KDRCreativeTabs.register(modEventBus);
        KDRItems.register(modEventBus);
        KDRBlocks.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(KDRBlocks.PURPLE_FUJI_FLOWER.getId(), KDRBlocks.POTTED_PURPLE_FUJI_FLOWER);
        });
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
