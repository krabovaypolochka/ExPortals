package org.kp.ex_portals.screens.RiftFuseScreen;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.kp.ex_portals.Inits.Blocks.entity.RiftInfuserEntity;
import org.kp.ex_portals.screens.screenHendlers;

public class RiftInfuserScreenHandler extends ScreenHandler {
    private final Inventory INV;
    private final PropertyDelegate PROP;
    private final RiftInfuserEntity blockEntity;
    public RiftInfuserScreenHandler(int syncId,PlayerInventory playerInventory,PacketByteBuf buf){
        this(syncId,playerInventory,playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()), new ArrayPropertyDelegate(4));
    }
    public RiftInfuserScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity block, PropertyDelegate prop) {
        super(screenHendlers.Rift_InfuserScreen,syncId);
        checkSize((Inventory) block,3);
        this.INV = (Inventory)block;
        INV.onOpen(playerInventory.player);
        this.PROP = prop;
        this.blockEntity =(RiftInfuserEntity) block;
        this.addSlot(new Slot(INV,0,120,38));
        this.addSlot(new Slot(INV,1,86,15));
        this.addSlot(new Slot(INV,2,86,60));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(prop);
    }
    public boolean isCrafting() {
        return PROP.get(0) > 0;
    }
    public int getRifting(){
        int max_rift = this.PROP.get(3);
        int rift = this.PROP.get(0);
        int size = 80;
        return max_rift != 0 && rift != 0 ? rift * size / max_rift : 0;
    }
    public int getScaledProgress() {
        int progress = this.PROP.get(1);
        int maxProgress = this.PROP.get(2);  // Max Progress
        int progressArrowSize = 30; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.INV.size()) {
                if (!this.insertItem(originalStack, this.INV.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.INV.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return INV.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }
    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}
