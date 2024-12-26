package org.kp.ex_portals.worldgen.ore;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.kp.ex_portals.Ex_portals;

    public class ModOre {
        public static final RegistryKey<PlacedFeature> Portal_TRANSM_SPAWN = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Ex_portals.ModID,"stable_portal_transm"));
        public static void reg()
        {
            Ex_portals.logger.debug("Initializing ores");
        }
    }
