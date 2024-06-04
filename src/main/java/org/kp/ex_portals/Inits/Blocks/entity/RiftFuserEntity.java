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
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.kp.ex_portals.Inits.Blocks.modBlock;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.screens.RiftFuseScreen.RiftInfuserScreenHandler;

public class RiftFuserEntity extends BlockEntity implements ExtendedScreenHandlerFactory, RiftInfuserInventory {
    protected final PropertyDelegate propDel;
    protected int RiftEnergy = 0;
    protected int MaxRiftEnergy = 120;
    protected int progress = 0;
    protected int maxprogress = 100;
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);
    public RiftFuserEntity( BlockPos pos, BlockState state) {
        super(modBlock.Rift_Infuser_Type, pos, state);
        this.propDel = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RiftFuserEntity.this.RiftEnergy;
                    case 1 -> RiftFuserEntity.this.progress;
                    case 2 -> RiftFuserEntity.this.maxprogress;
                    case 3 -> RiftFuserEntity.this.MaxRiftEnergy;
                    default -> 0;
                };
            }
            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: RiftFuserEntity.this.RiftEnergy = value; break;
                    case 1: RiftFuserEntity.this.progress = value;break;
                    case 2: RiftFuserEntity.this.maxprogress = value;break;
                    case 3: RiftFuserEntity.this.MaxRiftEnergy = value; break;
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
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
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
    public void tick(World world, BlockPos blockPos, BlockState blockState) {
     if(world.isClient){
         return;
     }
     if(hasRecipe()){
         if(this.RiftEnergy >= 25){
            this.progress++;
            if(this.progress >= maxprogress) {
                CraftItem();
            }
             markDirty(world,blockPos,blockState);
         }
     }
     else {
         this.resetprogress();
         markDirty(world,blockPos,blockState);
     }
     if(this.getItems().get(0).getItem() == RiftItems.RiftShard){
         this.removeStack(0,1);
         this.RiftEnergy += 5;
     }
    }
    private boolean hasRecipe() {
        boolean hasRawShard = this.getStack(1).getItem() == RiftItems.RiftShard;
        return  hasRawShard && getItemCorrect(RiftItems.ProccesedRiftShard) && asCountN();
    }
    private boolean getItemCorrect(Item item){
        return this.getStack(2).getItem() == item || this.getStack(2).isEmpty();
    }

    private boolean asCountN() {
        return this.getStack(2).getItem().getMaxCount() > this.getStack(2).getCount() + 1;
    }
    private void CraftItem(){
        this.RiftEnergy -= 25;
        this.removeStack(1,1);
        this.setStack(2,new ItemStack(RiftItems.ProccesedRiftShard,this.getStack(2).getCount() + 1));
        this.resetprogress();
    }
    protected void resetprogress(){
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
