package org.kp.ex_portals.Inits.Blocks.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.Inits.Items.custome.RiftCleanerItem;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreenHandler;

public class RiftInfuserEntity extends BlockEntity implements ExtendedScreenHandlerFactory, RiftInfuserInventory {
    protected final PropertyDelegate propDel;
    protected int RiftEnergy = 0;
    protected int MaxRiftEnergy = 120;
    protected int progress = 0;
    protected int maxprogress = 100;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);
    public RiftInfuserEntity(BlockPos pos, BlockState state) {
        super(RiftBlocks.Rift_Infuser_Type, pos, state);
        this.propDel = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RiftInfuserEntity.this.RiftEnergy;
                    case 1 -> RiftInfuserEntity.this.progress;
                    case 2 -> RiftInfuserEntity.this.maxprogress;
                    case 3 -> RiftInfuserEntity.this.MaxRiftEnergy;
                    default -> 0;
                };
            }
            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: RiftInfuserEntity.this.RiftEnergy = value; break;
                    case 1: RiftInfuserEntity.this.progress = value;break;
                    case 2: RiftInfuserEntity.this.maxprogress = value;break;
                    case 3: RiftInfuserEntity.this.MaxRiftEnergy = value; break;
                }
            }
            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        Inventories.writeNbt(tag,inventory);
        tag.putInt("rift_energy",RiftEnergy);
        tag.putInt("progress",progress);
    }
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        Inventories.readNbt(tag,inventory);
        RiftEnergy = tag.getInt("rift_energy");
        progress = tag.getInt("progress");
    }
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("RiftInfuser");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new RiftInfuserScreenHandler(syncId,playerInventory,this,this.propDel);
    }
    public static void tick(World world, BlockPos blockPos, BlockState blockState,RiftInfuserEntity entity) {
     if(world.isClient){
         return;
     }
     if(hasRecipe(entity)){
         if(entity.RiftEnergy >= 25){
             entity.progress++;
            if(entity.progress >= entity.maxprogress) {
                CraftItem(entity);
            }
             markDirty(world,blockPos,blockState);
         }
     }
     else {
         entity.ResetProgress();
         markDirty(world,blockPos,blockState);
     }
     if(entity.getItems().get(0).getItem().getClass() == RiftCleanerItem.class){
         RiftCleanerItem RCI = (RiftCleanerItem)(entity.getItems().get(0).getItem());
         if(entity.RiftEnergy + (RCI.GetCountC() / 2 - 10) <= entity.MaxRiftEnergy) {
             entity.RiftEnergy += RCI.GetCountC() / 2 - 10;
             entity.removeStack(0,1);
         }
     }
    }
    private static boolean hasRecipe(RiftInfuserEntity entity) {
        boolean hasRawShard = entity.getStack(1).getItem() == RiftItems.RiftShard;
        return  hasRawShard && getItemCorrect(RiftItems.ProccesedRiftShard,entity) && asCountN(entity);
    }
    private static boolean getItemCorrect(Item item,RiftInfuserEntity entity){
        return entity.getStack(2).getItem() == item || entity.getStack(2).isEmpty();
    }

    private static boolean asCountN(RiftInfuserEntity entity) {
        return entity.getStack(2).getItem().getMaxCount() > entity.getStack(2).getCount() + 1;
    }
    private static void CraftItem(RiftInfuserEntity entity){
        entity.RiftEnergy -= 30;
        entity.removeStack(1,1);
        entity.setStack(2,new ItemStack(RiftItems.ProccesedRiftShard,entity.getStack(2).getCount() + 1));
        entity.ResetProgress();
    }
    protected void ResetProgress(){
        this.progress = 0;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }

}
