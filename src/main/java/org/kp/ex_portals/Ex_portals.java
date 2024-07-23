package org.kp.ex_portals;

import net.fabricmc.api.ModInitializer;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.screens.screenHendlers;
import org.kp.ex_portals.worldgen.biomes.biomeRegistration;
import org.kp.ex_portals.worldgen.dimmension.dimReg;
import org.kp.ex_portals.worldgen.ore.ModOre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ex_portals implements ModInitializer {
    public static final String ModID = "ex_portals";
    public static final Logger logger = LoggerFactory.getLogger(ModID);
    @Override
    public void onInitialize() {
        biomeRegistration.reg();
        RiftBlocks.sucka();
        RiftItems.register();
        ModOre.reg();
        screenHendlers.reg();
        dimReg.reg();
    }
}
