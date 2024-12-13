package org.kp.ex_portals.worldgen.biomes;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.kp.ex_portals.Ex_portals;
import terrablender.api.*;

public class biomeRegistration implements TerraBlenderApi {
    public static final RegistryKey<Biome> Rift_forest= registers("rift_forest",8);

    @Override
    public void onTerraBlenderInitialized() {
        Ex_portals.logger.debug("Adding Ex_portals biomes");
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,Ex_portals.ModID,addRules.makeRules());
        TerraBlenderApi.super.onTerraBlenderInitialized();
    }
    private static RegistryKey<Biome> registers(String str,int Weight){
        RegistryKey<Biome> biome = RegistryKey.of(RegistryKeys.BIOME,new Identifier(Ex_portals.ModID,str));
        Regions.register(new Regione(biome.getRegistry(),Weight));
        return biome;
    }
}
