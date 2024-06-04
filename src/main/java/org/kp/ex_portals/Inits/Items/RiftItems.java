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
import org.kp.ex_portals.Inits.Items.Armors.riff_seeker_armor.rift_seeker_armor;
import org.kp.ex_portals.Inits.Items.custome.RiftCleanerItem;

public class
RiftItems {
    public static Item RiftShard = registerItem(new Item(new FabricItemSettings()
                    .fireproof()
                    .maxCount(8)
            ),
            "rift_shard");
    public static Item ProccesedRiftShard = registerItem(new Item(new FabricItemSettings()
            .fireproof()
            .maxCount(24)),"proccesed_rift_shard");
    public static Item BaseRiftingCleaner = registerItem(new RiftCleanerItem(new FabricItemSettings()
                    .fireproof()
                    .maxCount(1),100)
    ,"base_rift_cleaner");
    public static Item RiftedFlesh = registerItem(new Item(new FabricItemSettings().fireproof()), "rifted_flesh");
    public static Item RiftSeekerHelmet = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.HELMET, new FabricItemSettings()),"rift_seeker_helmet");
    public static Item RiftSeekerLeggings = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.LEGGINGS, new FabricItemSettings()),"rift_seeker_leggings");
    public static Item RiftSeekerChestplate = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.CHESTPLATE, new FabricItemSettings()),"rift_seeker_chestplate");
    public static Item RiftSeekerBoots = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.BOOTS, new FabricItemSettings()),"rift_seeker_boots");


    public static Item registerItem(Item item,String ID){
        return Registry.register(Registries.ITEM,
                new Identifier(Ex_portals.ModID,ID),item);
    }

    public static final ItemGroup RiftItemsGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RiftShard))
            .displayName(Text.translatable("itemgroup.ex_portals.riftitemsgroup"))
            .entries((context_, entries) -> {
                entries.add(RiftShard);
                entries.add(ProccesedRiftShard);
                entries.add(BaseRiftingCleaner);
                entries.add(RiftedFlesh);
                entries.add(RiftSeekerHelmet);
                entries.add(RiftSeekerChestplate);
                entries.add(RiftSeekerLeggings);
                entries.add(RiftSeekerBoots);
                entries.add(modBlock.RiftStone.asItem());
                entries.add(modBlock.RiftCobblestone.asItem());
                entries.add(modBlock.StablePortalTransm.asItem());
                entries.add(modBlock.RIFT_INFUSER_T1.asItem());
            })
            .build();
    public static void register() {
       Registry.register(Registries.ITEM_GROUP,new Identifier(Ex_portals.ModID,"rift_item_group"),RiftItemsGroup);
        Ex_portals.logger.debug("Initializing Items");
    }
}
