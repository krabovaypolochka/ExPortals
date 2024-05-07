package org.kp.ex_portals.Inits.Blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class modBlock {
    public static final Block RiftStone = registerItem(new Block(FabricBlockSettings.create()
                    .strength(2.0f)
                    .requiresTool()
                    .hardness(2.0f)
                    .resistance(2.0f))
            ,"rift_stone");
    public static final Block RiftCobblestone = registerItem(new Block(FabricBlockSettings.create()
                    .strength(1.0f)
                    .requiresTool()
                    .hardness(1.0f)
                    .resistance(2.0f))
            ,"rift_cobblestone");
    public static final Block StablePortalTransm = registerItem(new Block(FabricBlockSettings.create()
                    .strength(1.0f)
                    .requiresTool()
                    .hardness(1.0f)
                    .resistance(2.0f))
            ,"stable_portal_transm");


    public static Block registerItem(Block block, String ID){
        RiftItems.registerItem(new BlockItem(block,new FabricItemSettings()),ID);
        return Registry.register(Registries.BLOCK,
                new Identifier(Ex_portals.ModID,ID),block);
    }
    public static void sucka(){

    }
}
