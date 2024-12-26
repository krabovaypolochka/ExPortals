package org.kp.ex_portals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(RiftBlocks.RIFT_WOOD);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(RiftBlocks.StablePortalTransm);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(RiftBlocks.RiftStone)
                .add(RiftBlocks.RiftCobblestone)
                .add(RiftBlocks.RIFT_INFUSER_T1);

    }
}
