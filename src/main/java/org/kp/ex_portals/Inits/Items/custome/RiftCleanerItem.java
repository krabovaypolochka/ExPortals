package org.kp.ex_portals.Inits.Items.custome;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.kp.ex_portals.utils.IDataSaver;
import org.kp.ex_portals.utils.RiftingData;

public class RiftCleanerItem extends Item {
    public int CountOfClining;
    public RiftCleanerItem(Settings settings,int a) {
        super(settings);
        CountOfClining = a;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(hand == Hand.MAIN_HAND) {
            RiftingData.RemoveRifting((IDataSaver) user,CountOfClining);
            user.getStackInHand(hand).decrement(1);
            user.sendMessage(Text.literal("rifting =" + ((IDataSaver) user).getStats().getInt("rifting")),true);
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        else{
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
