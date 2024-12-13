package org.kp.ex_portals.utils;

import net.minecraft.nbt.NbtCompound;

public class RiftingData {
    public static int addRifting(IDataSaver player, int amount){
        NbtCompound nbt = player.getStats();
        int rifting = nbt.getInt("rifting");
        rifting += amount;

        nbt.putInt("rifting",rifting);

        return rifting;
    }
    public static int RemoveRifting(IDataSaver player, int amount){
        NbtCompound nbt = player.getStats();
        int rifting = nbt.getInt("rifting");
        if(rifting - amount < 2)
        {
            rifting = 2;
        }
        else{
            rifting -= amount;
        }

        nbt.putInt("rifting",rifting);

        return rifting;
    }
    public static int getRifting(IDataSaver player){
        NbtCompound nbt = player.getStats();
        return nbt.getInt("rifting");
    }
}
