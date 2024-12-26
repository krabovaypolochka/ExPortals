package org.kp.ex_portals.Inits.Blocks;

import com.mojang.datafixers.types.templates.Check;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.GameEventListener;
import org.jetbrains.annotations.Nullable;
import org.kp.ex_portals.Inits.Blocks.entity.RiftInfuserEntity;

public class RiftInfuserBlock extends BlockWithEntity implements BlockEntityProvider{

    public RiftInfuserBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RiftInfuserEntity(pos,state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, RiftBlocks.Rift_Infuser_Type, RiftInfuserEntity::tick);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getGameEventListener(ServerWorld world, T blockEntity) {
        return super.getGameEventListener(world, blockEntity);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                NamedScreenHandlerFactory screenHandlerFactory = ((RiftInfuserEntity) world.getBlockEntity(pos));

                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }
            return ActionResult.PASS;
    }

}
