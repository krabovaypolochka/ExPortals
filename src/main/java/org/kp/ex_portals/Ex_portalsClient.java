package org.kp.ex_portals;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreen;
import org.kp.ex_portals.screens.screenHendlers;

@Environment(EnvType.CLIENT)
public class Ex_portalsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(screenHendlers.Rift_InfuserScreen,RiftInfuserScreen::new);
    }
}