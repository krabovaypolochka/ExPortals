package org.kp.ex_portals;

import net.fabricmc.api.ModInitializer;
import org.kp.ex_portals.Inits.Blocks.modBlock;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class Ex_portals implements ModInitializer {
    public static final String ModID = "ex_portals";
    @Override
    public void onInitialize() {
        modBlock.sucka();
        RiftItems.register();
    }
}
