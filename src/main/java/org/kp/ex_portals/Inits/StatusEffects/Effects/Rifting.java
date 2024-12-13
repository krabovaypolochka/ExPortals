package org.kp.ex_portals.Inits.StatusEffects.Effects;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.Inits.StatusEffects.StatusEffectRegistry;
import org.kp.ex_portals.utils.IDataSaver;
import org.kp.ex_portals.utils.RiftingData;

public final class Rifting extends StatusEffect {
    public Rifting(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(RiftItems.RiftSeekerChestplate == entity.getEquippedStack(EquipmentSlot.CHEST).getItem()) {
            entity.damageArmor(new DamageSource(entity.getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(StatusEffectRegistry.Riften)), 10);
        }
        else
        {
            entity.damage(new DamageSource(entity.getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(StatusEffectRegistry.Riften)), 0.2f * amplifier);
        }
        if(entity instanceof PlayerEntity){
            RiftingData.addRifting((IDataSaver) entity,1);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
