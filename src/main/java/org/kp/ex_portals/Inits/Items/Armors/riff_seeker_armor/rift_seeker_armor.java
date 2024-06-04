package org.kp.ex_portals.Inits.Items.Armors.riff_seeker_armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class rift_seeker_armor implements ArmorMaterial {
    private static int[] BASE_DURABILITY = new int[] {18,19,20,18};
    private static int[] PROTECTION_VALUES = new int[] {4,7,8,3};


    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvent.of(Identifier.tryParse("entity.player.breath"));
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Registries.ITEM.get(Identifier.tryParse("ex_portals:proccesed_rift_shard")));
    }

    @Override
    public String getName() {
        return "rift_seeker_armor";
    }

    @Override
    public float getToughness() {
        return 3.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.21f;
    }
}