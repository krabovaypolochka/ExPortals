package org.kp.ex_portals.worldgen.dimmension;

import net.kyrptonaught.customportalapi.CustomPortalsMod;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.Inits.StatusEffects.StatusEffectRegistry;

import java.awt.*;

public class dimReg extends CustomPortalsMod {
    public static RegistryKey<World> Rift_World = RegistryKey.of(RegistryKeys.WORLD
            ,new Identifier(Ex_portals.ModID,"rift"));
    public static RegistryKey<DimensionOptions> Rift_Dim = RegistryKeys.toDimensionKey(Rift_World);
    public static RegistryKey<DimensionType> Rift_Dim_Type = RegistryKey.of(RegistryKeys.DIMENSION_TYPE
            ,new Identifier(Ex_portals.ModID,"rift_type"));

    public static void reg(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(RiftBlocks.StablePortalTransm)
                .lightWithItem(RiftItems.ProccesedRiftShard)
                .destDimID(new Identifier(Ex_portals.ModID,"rift"))
                .registerPostTPEvent(entity -> applyrift((LivingEntity) entity))
                .onlyLightInOverworld()
                .registerPortal();
    }
    public static void applyrift(LivingEntity ent){
        if(ent instanceof PlayerEntity){
            ent.addStatusEffect(new StatusEffectInstance(StatusEffectRegistry.rifting,100,10));
        }
    }
}
