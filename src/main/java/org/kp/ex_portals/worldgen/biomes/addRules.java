package org.kp.ex_portals.worldgen.biomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class addRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule Stone = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule Air = makeStateRule(Blocks.AIR);
    protected static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.waterWithStoneDepth(1,1);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK));
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.surface(), grassSurface),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Stone),
                MaterialRules.condition(MaterialRules.biome(biomeRegistration.Rift_forest), Air)
        );
    }
    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
