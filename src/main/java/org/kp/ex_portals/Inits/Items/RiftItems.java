package org.kp.ex_portals.Inits.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.kp.ex_portals.Ex_portals;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.Armors.riff_seeker_armor.rift_seeker_armor;
import org.kp.ex_portals.Inits.Items.RiftTools.RiftTools;
import org.kp.ex_portals.Inits.Items.custome.RiftCleanerItem;

public class RiftItems {
    public static Item RiftShard = registerItem(new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder()
                            .saturationModifier(0f)
                            .hunger(7)
                            .meat()
                            .build())
                    .fireproof()
                    .maxCount(8)
            ),
            "rift_shard");
    public static Item ProccesedRiftShard = registerItem(new Item(new FabricItemSettings()
            .fireproof()
            .maxCount(24))
            ,"proccesed_rift_shard");
    public static Item BaseRiftingCleaner = registerItem(new RiftCleanerItem(new FabricItemSettings()
                    .fireproof()
                    .maxCount(1),100,true)
    ,"base_rift_cleaner");
    public static Item RiftedFlesh = registerItem(new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                        .saturationModifier(0.75f)
                        .hunger(4)
                        .meat()
                        .build())
                    .rarity(Rarity.UNCOMMON)
                    .fireproof())
            ,"rifted_flesh");
    public static Item RiftSeekerHelmet = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.HELMET
            , new FabricItemSettings()
                    .fireproof()
                    .rarity(Rarity.RARE)
                    .maxCount(1))
            ,"rift_seeker_helmet");
    public static Item RiftSeekerLeggings = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.LEGGINGS
            , new FabricItemSettings()
                    .fireproof()
                    .rarity(Rarity.RARE)
                    .maxCount(1))
            ,"rift_seeker_leggings");
    public static Item RiftSeekerChestplate = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.CHESTPLATE
            , new FabricItemSettings()
                    .fireproof()
                    .rarity(Rarity.RARE)
                    .maxCount(1))
            ,"rift_seeker_chestplate");
    public static Item RiftSeekerBoots = registerItem(new ArmorItem(new rift_seeker_armor(), ArmorItem.Type.BOOTS
            , new FabricItemSettings()
                    .fireproof()
                    .rarity(Rarity.RARE)
                    .maxCount(1)),
            "rift_seeker_boots");

    public static Item RiftSword = registerItem(new SwordItem(
            new RiftTools()
                    ,6
                    ,-2.8f
                    ,new FabricItemSettings()
                        .rarity(Rarity.RARE)
                        .fireproof())
            ,"rift_sword");
    public static Item RiftHoe = registerItem(new HoeItem(
                    new RiftTools()
                    ,-1
                    ,-2f
                    ,new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof())
            ,"rift_hoe");
    public static Item RiftPickaxe = registerItem(new PickaxeItem(
                    new RiftTools()
                    ,-1
                    ,-2f
                    ,new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof())
            ,"rift_pickaxe");
    public static Item RiftShovel = registerItem(new ShovelItem(
                    new RiftTools()
                    ,-1
                    ,-2f
                    ,new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof())
            ,"rift_shovel");
    public static Item RiftAxe = registerItem(new ShovelItem(
                    new RiftTools()
                    ,-1
                    ,-2f
                    ,new FabricItemSettings()
                    .rarity(Rarity.RARE)
                    .fireproof())
            ,"rift_axe");
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
                entries.add(RiftSword);
                entries.add(RiftAxe);
                entries.add(RiftPickaxe);
                entries.add(RiftShovel);
                entries.add(RiftHoe);
                entries.add(RiftBlocks.RiftStone.asItem());
                entries.add(RiftBlocks.RiftCobblestone.asItem());
                entries.add(RiftBlocks.StablePortalTransm.asItem());
                entries.add(RiftBlocks.RIFT_INFUSER_T1.asItem());
                entries.add(RiftBlocks.RIFT_WOOD.asItem());
            })
            .build();
    public static void register() {
       Registry.register(Registries.ITEM_GROUP,new Identifier(Ex_portals.ModID,"rift_item_group"),RiftItemsGroup);
        Ex_portals.logger.debug("Initializing Items");
    }
}
