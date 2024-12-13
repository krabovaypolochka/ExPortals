package org.kp.ex_portals.worldgen.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.*;

import java.util.function.Consumer;

public class Regione extends Region {

    public Regione(Identifier Name, int weight) {
        super(Name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder().build().forEach((point) -> {
            builder.add(point, biomeRegistration.Rift_forest);
        });
        builder.build().forEach(mapper);
        super.addBiomes(registry, mapper);
    }
}
