package com.chinaex123.kaleidoscope_dimension_realms.util;

import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;

public final class FluidColors {

    private static final Map<ResourceLocation, Vector3f> FOG = new HashMap<>();

    static {
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "grape_juice"), rgb(0x7B3F9E));
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "ice_grape_juice"), rgb(0x9AD0EC));
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "gold_grape_juice"), rgb(0xE8C547));
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "green_grape_juice"), rgb(0x6FBF73));
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "sweet_berries_juice"), rgb(0xC0392B));
        FOG.put(ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "glow_berries_juice"), rgb(0xF39C12));
    }

    private FluidColors() {}

    private static final Vector3f DEFAULT = new Vector3f(1f, 1f, 1f);

    public static Vector3f getFogColor(ResourceLocation id) {
        return FOG.getOrDefault(id, DEFAULT);
    }

    private static Vector3f rgb(int hex) {
        return new Vector3f(
                ((hex >> 16) & 0xFF) / 255f,
                ((hex >> 8) & 0xFF) / 255f,
                (hex & 0xFF) / 255f
        );
    }
}