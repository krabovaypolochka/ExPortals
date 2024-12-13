package org.kp.ex_portals.Inits.StatusEffects;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.StatusEffects.Effects.Rifting;

import java.awt.*;

public class StatusEffectRegistry {
    public static final RegistryKey<DamageType> Riften = RegDamageType("rift_damage");
    public static StatusEffect rifting = RegStatusEffect(new Rifting(StatusEffectCategory.HARMFUL, Color.PINK.getRGB()),"rifting");
    public static void reg(){

    }
    private static StatusEffect RegStatusEffect(StatusEffect statusEffect,String id){
        Registry.register(Registries.STATUS_EFFECT,new Identifier(Ex_portals.ModID,id),statusEffect);
        return statusEffect;
    }
    private static RegistryKey<DamageType> RegDamageType(String id){
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE,new Identifier(Ex_portals.ModID,id));
    }
}
