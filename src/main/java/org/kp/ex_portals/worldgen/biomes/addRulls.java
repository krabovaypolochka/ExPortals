package org.kp.ex_portals.worldgen.biomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class addRulls {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule Stone = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule Air = makeStateRule(Blocks.AIR);
    private static final MaterialRules.MaterialRule Water = makeStateRule(Blocks.WATER);
    protected static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.waterWithStoneDepth(0,2);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, DIRT));
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), GRASS_BLOCK),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Stone),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), DIRT),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Air),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Water),
                MaterialRules.condition(MaterialRules.surface(), grassSurface)
        );
    }
    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
