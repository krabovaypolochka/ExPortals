package org.kp.ex_portals.Inits.Blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.entity.RiftFuserEntity;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class modBlock {
    public static final Block RiftStone = registerItem(
            new Block(FabricBlockSettings.create()
                    .strength(2.0f)
                    .requiresTool()
                    .hardness(2.0f)
                    .resistance(2.0f))
            ,"rift_stone",
            new FabricItemSettings()
                    .rarity(Rarity.UNCOMMON)
                    .fireproof());
    public static final Block RiftCobblestone = registerItem(new Block(FabricBlockSettings.create()
                    .strength(1.0f)
                    .requiresTool()
                    .hardness(1.0f)
                    .resistance(2.0f))
            ,"rift_cobblestone",
            new FabricItemSettings()
                    .rarity(Rarity.UNCOMMON)
                    .fireproof());
    public static final Block StablePortalTransm = registerItem(new Block(FabricBlockSettings.create()
                    .strength(1.0f)
                    .requiresTool()
                    .hardness(1.0f)
                    .resistance(2.0f)
                    .luminance(3))
            ,"stable_portal_transm",
            new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof());
    public static final Block RIFT_INFUSER_T1 = registerItem(
            new RiftInfuserBlock(FabricBlockSettings.create()
                    .resistance(0.3f)
                    .hardness(0.4f)
            )
            ,"rift_infuser_t1",
            new FabricItemSettings()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .fireproof());
    public  static final BlockEntityType<RiftFuserEntity> Rift_Infuser_Type = Registry.register(Registries.BLOCK_ENTITY_TYPE, "tutorial:demo_block_entity", FabricBlockEntityTypeBuilder.create(RiftFuserEntity::new,RIFT_INFUSER_T1).build());

    public static Block registerItem(Block block, String ID,FabricItemSettings FIS){
        RiftItems.registerItem(new BlockItem(block,FIS),ID);
        return Registry.register(Registries.BLOCK,
                new Identifier(Ex_portals.ModID,ID),block);
    }
    public static void sucka(){
        Ex_portals.logger.debug("Initializing blocks");
    }
}
