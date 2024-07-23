package org.kp.ex_portals.worldgen.biomes;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.kp.ex_portals.Ex_portals;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class biomeRegistration implements TerraBlenderApi {
    public static final RegistryKey<Biome> Rift_forest = registers("rift_forest",7);

    public static void reg(){
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,Ex_portals.ModID ,addRulls.makeRules());
    }
    private static RegistryKey<Biome> registers(String str,int weight){
        RegistryKey<Biome> biome = RegistryKey.of(RegistryKeys.BIOME,new Identifier(Ex_portals.ModID, str));
        Regions.register(new Regione(biome.getRegistry(),weight));
        return biome;
    }
}
