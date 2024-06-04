package org.kp.ex_portals.worldgen.biomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.registry.Registries;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import terrablender.api.SurfaceRuleManager;

public class addRulls {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule Stone = makeStateRule(Blocks.STONE);


    protected static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.waterWithStoneDepth(-1,0);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, DIRT));

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), GRASS_BLOCK),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Stone),
                MaterialRules.condition(MaterialRules.surface(), grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
