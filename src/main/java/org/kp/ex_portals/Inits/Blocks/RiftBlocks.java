package org.kp.ex_portals.Inits.Blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.entity.RiftInfuserEntity;
import org.kp.ex_portals.Inits.Items.RiftItems;

import java.awt.*;

public class RiftBlocks {
    public static final Block RiftStone = registerItem(
            new Block(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2.0f)
                    .requiresTool()
                    .hardness(2.0f)
                    .resistance(2.0f))
            ,"rift_stone",
            new FabricItemSettings()
                    .rarity(Rarity.UNCOMMON)
                    .fireproof());
    public static final Block RiftCobblestone = registerItem(new Block(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.3f)
                    .requiresTool()
                    .hardness(1.0f)
                    .resistance(2.0f))
            ,"rift_cobblestone",
            new FabricItemSettings()
                    .rarity(Rarity.UNCOMMON)
                    .fireproof());
    public static final Block StablePortalTransm = registerItem(new Block(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.DRIPSTONE_BLOCK)
                    .strength(2f)
                    .requiresTool()
                    .hardness(1.5f)
                    .resistance(2.0f)
                    .luminance(7)
            )
            ,"stable_portal_transm",
            new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof());
    public static final Block RIFT_INFUSER_T1 = registerItem(
            new RiftInfuserBlock(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.METAL)
                    .luminance(6)
                    .resistance(0.3f)
                    .hardness(0.4f)
            )
            ,"rift_infuser_t1",
            new FabricItemSettings()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .fireproof());
    public static Block RIFT_WOOD = registerItem(new Block(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(0.7f,2)
                    .luminance(2)
                    .requiresTool())
            ,"rift_wood"
            ,new FabricItemSettings()
                    .rarity(Rarity.UNCOMMON)
                    .maxCount(128));
    public static final BlockEntityType<RiftInfuserEntity> Rift_Infuser_Type = Registry.register(Registries.BLOCK_ENTITY_TYPE
            , new Identifier(Ex_portals.ModID,"entity_block_rift_infuser"),
            BlockEntityType.Builder.create(RiftInfuserEntity::new,RIFT_INFUSER_T1).build());

    public static Block registerItem(Block block, String ID,FabricItemSettings FIS){
        RiftItems.registerItem(new BlockItem(block,FIS),ID);
        return Registry.register(Registries.BLOCK,
                new Identifier(Ex_portals.ModID,ID),block);
    }
    public static void sucka(){
    }
}
