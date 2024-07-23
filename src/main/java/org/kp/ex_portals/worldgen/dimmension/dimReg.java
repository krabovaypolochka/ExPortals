package org.kp.ex_portals.worldgen.dimmension;

import net.kyrptonaught.customportalapi.CustomPortalsMod;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class dimReg extends CustomPortalsMod {
    public RegistryKey<DimensionOptions> Rift_OPTIONS = RegistryKey.of(RegistryKeys.DIMENSION
            ,new Identifier(Ex_portals.ModID,"rift"));
    public RegistryKey<World> Rift_Level = RegistryKey.of(RegistryKeys.WORLD
            ,new Identifier(Ex_portals.ModID,"rift"));
    public RegistryKey<DimensionType> Rift_Dim_Type = RegistryKey.of(RegistryKeys.DIMENSION_TYPE
            ,new Identifier(Ex_portals.ModID,"rift_type"));

    public static void reg(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(RiftBlocks.StablePortalTransm)
                .lightWithItem(RiftItems.ProccesedRiftShard)
                .destDimID(new Identifier(Ex_portals.ModID,"rift"))
                .onlyLightInOverworld()
                .registerPortal();
    }
}
