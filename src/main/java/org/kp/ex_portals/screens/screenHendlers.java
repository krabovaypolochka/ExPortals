package org.kp.ex_portals.screens;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreen;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreenHandler;

public class screenHendlers {
    public static ScreenHandlerType<RiftInfuserScreenHandler> Rift_InfuserScreen;
    public static void reg(){
        Rift_InfuserScreen =  Registry.register(Registries.SCREEN_HANDLER,
                new Identifier(Ex_portals.ModID,"rift_fusing"),
                new ExtendedScreenHandlerType<>(RiftInfuserScreenHandler::new));
    };
}