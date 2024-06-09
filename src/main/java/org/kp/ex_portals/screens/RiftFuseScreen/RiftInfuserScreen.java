package org.kp.ex_portals.screens.RiftFuseScreen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;

public class RiftInfuserScreen extends HandledScreen<RiftInfuserScreenHandler> implements ScreenHandlerProvider<RiftInfuserScreenHandler> {
    private final Identifier texture = new Identifier(Ex_portals.ModID,"textures/gui/Rift_infusing_station_gui.png");
    public RiftInfuserScreen(RiftInfuserScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
    @Override
    protected void init(){
        super.init();
        playerInventoryTitleY = 1000;
        titleX = (backgroundWidth - textRenderer.getWidth(title)) /2;
    }
    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1,1,1,1);
        RenderSystem.setShaderTexture(0,texture);
        int x = (width - backgroundWidth) /2;
        int y = (height - backgroundHeight) /2;
        context.drawTexture(texture,x,y,0,0,backgroundWidth,backgroundHeight);
        RenderprogressArowe(context,x,y);
        RenderRift(context,x,y);
    }
    public void RenderprogressArowe(DrawContext context,int x,int y){
        context.drawTexture(texture,x + 90,y + 28,176,0,8,handler.getScaledProgress());
    }
    public void RenderRift(DrawContext context,int x,int y){
        context.drawTexture(texture,x + 153,y + 13,176,47,11,handler.getRifting());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
    }
}
