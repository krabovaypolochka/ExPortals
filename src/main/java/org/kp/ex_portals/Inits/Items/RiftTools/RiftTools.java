package org.kp.ex_portals.Inits.Items.RiftTools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import org.kp.ex_portals.Inits.Items.RiftItems;

public class RiftTools implements ToolMaterial {

    @Override
    public int getDurability() {
        return 2300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7f;
    }

    @Override
    public float getAttackDamage() {
        return 2f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 31;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RiftItems.ProccesedRiftShard);
    }
}
