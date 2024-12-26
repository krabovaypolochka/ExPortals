package org.kp.ex_portals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(RiftBlocks.RIFT_INFUSER_T1);
        addDrop(RiftBlocks.RIFT_WOOD);
        addDrop(RiftBlocks.RiftCobblestone);
        addDrop(RiftBlocks.StablePortalTransm,oreDrops(RiftBlocks.StablePortalTransm, RiftItems.RiftShard));
        addDrop(RiftBlocks.RiftStone,oreDrops(RiftBlocks.RiftStone, RiftBlocks.RiftCobblestone.asItem()));
    }
}
