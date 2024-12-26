package org.kp.ex_portals.Inits.Items.custome;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.kp.ex_portals.utils.IDataSaver;
import org.kp.ex_portals.utils.RiftingData;

import java.util.List;

public class RiftCleanerItem extends Item {
    public static int CountOfCleaning;
    public static boolean isCleaning;
    public RiftCleanerItem(Settings settings,int a,boolean b) {
        super(settings);
        CountOfCleaning = a;
        isCleaning = b;

    }
    public int GetCountC(){
        return CountOfCleaning;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (isCleaning){
            tooltip.add(Text.literal("Clear rifting count:" + CountOfCleaning).formatted(Formatting.DARK_PURPLE));
        tooltip.add(Text.literal("            ").formatted(Formatting.ITALIC));
    }
        tooltip.add(Text.literal("On convert in rift energy:" + ((CountOfCleaning/2)-(CountOfCleaning/5))).formatted(Formatting.LIGHT_PURPLE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(isCleaning)
        {
            if(hand == Hand.MAIN_HAND) {
                RiftingData.RemoveRifting((IDataSaver) user,CountOfCleaning);
                user.getStackInHand(hand).decrement(1);
                user.sendMessage(Text.literal("rifting =" + ((IDataSaver) user).getStats().getInt("rifting")),true);
                return TypedActionResult.success(user.getStackInHand(hand));
            }
            else{
                return TypedActionResult.pass(user.getStackInHand(hand));
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
