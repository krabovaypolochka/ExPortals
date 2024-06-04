package org.kp.ex_portals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Inits.Blocks.modBlock;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreen;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreenHandler;
import org.kp.ex_portals.screens.screenHendlers;
import org.kp.ex_portals.worldgen.biomes.biomeRegistration;
import org.kp.ex_portals.worldgen.ore.ModOre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ex_portals implements ModInitializer {
    public static final String ModID = "ex_portals";
    public static final Logger logger = LoggerFactory.getLogger(ModID);
    @Override
    public void onInitialize() {
        biomeRegistration.reg();
        modBlock.sucka();
        RiftItems.register();
        ModOre.reg();
        screenHendlers.reg();
    }
}
