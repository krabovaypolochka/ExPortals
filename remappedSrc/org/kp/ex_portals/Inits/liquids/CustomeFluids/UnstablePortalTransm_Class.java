package org.kp.ex_portals.Inits.liquids.CustomeFluids;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.kp.ex_portals.Inits.Blocks.RiftBlocks;
import org.kp.ex_portals.Inits.Items.RiftItems;
import org.kp.ex_portals.Inits.liquids.LiquidRegister;

public abstract class UnstablePortalTransm_Class extends FlowableFluid {

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    public Fluid getFlowing() {
        return LiquidRegister.UnstablePortalTransm_Flowing;
    }

    @Override
    public Fluid getStill() {
        return LiquidRegister.UnstablePortalTransm_Still;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {

    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public Item getBucketItem() {
        return RiftItems.Bucket_UnstablePortalTransm;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 10;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return RiftBlocks.UnstablePortalTransmBlock.getDefaultState().with(Properties.LEVEL_1_8, getBlockStateLevel(state));
    }
    public static class FlowingPortalTransm extends UnstablePortalTransm_Class {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }
    }
    public static class StillPortalTransm extends UnstablePortalTransm_Class {

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}