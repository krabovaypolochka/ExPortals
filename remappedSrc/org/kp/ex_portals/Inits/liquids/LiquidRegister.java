package org.kp.ex_portals.Inits.liquids;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.liquids.CustomeFluids.UnstablePortalTransm_Class;

public class LiquidRegister {
    public static Fluid UnstablePortalTransm_Still = registerFluid("unstable_portal_transm", new UnstablePortalTransm_Class.StillPortalTransm());
    public static Fluid UnstablePortalTransm_Flowing = registerFluid("flowing_unstable_portal_transm", new UnstablePortalTransm_Class.FlowingPortalTransm());
    public static Fluid registerFluid(String id,Fluid fluid){
        return Registry.register(Registries.FLUID,new Identifier(Ex_portals.ModID,id),fluid);
    }
    public static void reg(){

    }
}
