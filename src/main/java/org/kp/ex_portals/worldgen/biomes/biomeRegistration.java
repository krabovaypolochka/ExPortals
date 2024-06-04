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
    public static final RegistryKey<Biome> Rift_forest = RegistryKey.of(RegistryKeys.BIOME,new Identifier(Ex_portals.ModID,"rift_forest"));

    public static void reg(){
        Regions.register(new Regione(Rift_forest.getRegistry(),5));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,Ex_portals.ModID ,addRulls.makeRules());
    }
}
