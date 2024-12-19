package org.kp.ex_portals;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.model.SpriteAtlasManager;
import net.minecraft.client.texture.SpriteAtlasHolder;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.atlas.AtlasSource;
import net.minecraft.resource.ResourceReloader;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Inits.liquids.LiquidRegister;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreen;
import org.kp.ex_portals.screens.screenHendlers;

@Environment(EnvType.CLIENT)
public class Ex_portalsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(screenHendlers.Rift_InfuserScreen, RiftInfuserScreen::new);
        FluidRenderHandlerRegistry.INSTANCE.register(LiquidRegister.UnstablePortalTransm_Still, LiquidRegister.UnstablePortalTransm_Flowing, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x15c72
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), LiquidRegister.UnstablePortalTransm_Still, LiquidRegister.UnstablePortalTransm_Flowing);
    }
}