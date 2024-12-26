package org.kp.ex_portals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RiftBlocks.RiftStone);
        blockStateModelGenerator.registerSimpleCubeAll(RiftBlocks.StablePortalTransm);
        blockStateModelGenerator.registerSimpleCubeAll(RiftBlocks.RiftCobblestone);

        blockStateModelGenerator.registerSingleton(RiftBlocks.RIFT_WOOD
                ,new TextureMap()
                        .put(TextureKey.EAST,new Identifier(Ex_portals.ModID,"block/rift_wood_face"))
                        .put(TextureKey.SOUTH,new Identifier(Ex_portals.ModID,"block/rift_wood_face"))
                        .put(TextureKey.WEST,new Identifier(Ex_portals.ModID,"block/rift_wood_face"))
                        .put(TextureKey.NORTH,new Identifier(Ex_portals.ModID,"block/rift_wood_face"))
                        .put(TextureKey.PARTICLE,new Identifier(Ex_portals.ModID,"block/rift_wood_face"))
                        .put(TextureKey.UP,new Identifier(Ex_portals.ModID,"block/rift_wood"))
                        .put(TextureKey.DOWN,new Identifier(Ex_portals.ModID,"block/rift_wood"))
                        ,Models.CUBE);
        blockStateModelGenerator.registerSingleton(RiftBlocks.RIFT_INFUSER_T1
                ,new TextureMap()
                        .put(TextureKey.DOWN,new Identifier(Ex_portals.ModID,"block/rift_wood"))
                        .put(TextureKey.UP,new Identifier(Ex_portals.ModID,"block/rift_wood"))
                        .put(TextureKey.EAST,new Identifier(Ex_portals.ModID,"block/rift_infuser_t1"))
                        .put(TextureKey.SOUTH,new Identifier(Ex_portals.ModID,"block/rift_infuser_t1"))
                        .put(TextureKey.WEST,new Identifier(Ex_portals.ModID,"block/rift_infuser_t1"))
                        .put(TextureKey.NORTH,new Identifier(Ex_portals.ModID,"block/rift_infuser_t1"))
                        .put(TextureKey.PARTICLE,new Identifier(Ex_portals.ModID,"block/rift_infuser_t1"))
                ,Models.CUBE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RiftItems.RiftShard, Models.GENERATED);
        itemModelGenerator.register(RiftItems.ProccesedRiftShard, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftHoe, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftPickaxe, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftShovel, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftSeekerBoots, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftSeekerChestplate, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftSeekerLeggings, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftSeekerHelmet, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftedFlesh, Models.GENERATED);
        itemModelGenerator.register(RiftItems.BaseRiftingCleaner, Models.GENERATED);
        itemModelGenerator.register(RiftItems.Bucket_UnstablePortalTransm, Models.GENERATED);
        itemModelGenerator.register(RiftItems.RiftAxe, Models.GENERATED);
    }
}
