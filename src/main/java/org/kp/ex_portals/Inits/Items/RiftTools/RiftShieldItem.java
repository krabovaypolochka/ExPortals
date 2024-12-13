package org.kp.ex_portals.Inits.Items.RiftTools;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.kp.ex_portals.utils.IDataSaver;
import org.kp.ex_portals.utils.RiftingData;

public class RiftShieldItem extends ShieldItem {
    public int ColdDown = 0;
    public RiftShieldItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(this.ColdDown <= 0) {
            Vec3d vec = user.getPos();
            Vec3d endvec = entity.getPos().add(vec.negate()).normalize();
            entity.addVelocity(endvec.multiply(1.5f + 0.1f * RiftingData.getRifting((IDataSaver) user)));
            this.ColdDown = 90;
        }
        user.sendMessage(Text.literal("used" + this.ColdDown));
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        this.MinusCD();
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    public void MinusCD(){
        this.ColdDown -= 1;
    }
}
