package org.kp.ex_portals.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandlerFactory;
import org.kp.ex_portals.utils.IDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class BaseMixin implements IDataSaver {
    private NbtCompound StatsData;
    @Override
    public NbtCompound getStats() {
        if(this.StatsData == null){
            this.StatsData = new NbtCompound();
        }
        return StatsData;
    }
    @Inject(method = "writeCustomDataToNbt",at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfo info){
            if(StatsData != null){
                StatsData.put("ex_portals.rifting",StatsData);
            }
    }
    @Inject(method = "readCustomDataFromNbt",at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info){
        if(nbt.contains("ex_portals.rifting")){
            StatsData = nbt.getCompound("ex_portals.rifting");
        }
    }
}

