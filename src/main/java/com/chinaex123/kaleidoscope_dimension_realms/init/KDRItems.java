package com.chinaex123.kaleidoscope_dimension_realms.init;

import com.chinaex123.kaleidoscope_dimension_realms.KaleidoscopeDimensionRealms;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface KDRItems {
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(KaleidoscopeDimensionRealms.MODID);


    static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
