package org.kp.ex_portals.utils;

import net.minecraft.nbt.NbtCompound;

public class RiftingData {
    public static float addRifting(IDataSaver player, float amount){
        NbtCompound nbt = player.getStats();
        float rifting = nbt.getInt("rifting");
        if(rifting <= 400) {
            rifting += amount;
        }
        else {
            float R = rifting + amount - 400;
            rifting += (amount - R);
        }
        nbt.putFloat("rifting", rifting);
        return rifting;
    }
    public static float RemoveRifting(IDataSaver player,float amount){
        NbtCompound nbt = player.getStats();
        float rifting = nbt.getFloat("rifting");
        if(rifting - amount < 2)
        {
            rifting = 2;
        }
        else{
            rifting -= amount;
        }

        nbt.putFloat("rifting",rifting);

        return rifting;
    }
    public static float getRifting(IDataSaver player){
        NbtCompound nbt = player.getStats();
        return nbt.getFloat("rifting");
    }
}
