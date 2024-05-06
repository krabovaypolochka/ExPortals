package org.kp.ex_portals.Inits.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.modBlock;

public class RiftItems {
    public static Item RiftShard = registerItem(new Item(new FabricItemSettings()),
            "rift_shard");
    public static Item registerItem(Item item,String ID){
        return Registry.register(Registries.ITEM,
                new Identifier(Ex_portals.ModID,ID),item);
    }

    public static final ItemGroup RiftItemsGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RiftShard))
            .displayName(Text.translatable("itemgroup.ex_portals.riftitemsgroup"))
            .entries((context_, entries) -> {
                entries.add(RiftShard);
                entries.add(modBlock.RiftStone.asItem());
            })
            .build();
    public static void register() {
       Registry.register(Registries.ITEM_GROUP,new Identifier(Ex_portals.ModID,"rift_item_group"),RiftItemsGroup);
    }
}
