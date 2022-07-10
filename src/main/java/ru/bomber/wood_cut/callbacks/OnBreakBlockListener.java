package ru.bomber.wood_cut.callbacks;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface OnBreakBlockListener {

    Event<OnBreakBlockListener> EVENT = EventFactory.createArrayBacked(OnBreakBlockListener.class,
            (listeners) -> (world, pos, state, player) -> {
                for (OnBreakBlockListener listener : listeners) {
                    ActionResult result = listener.interact(world, pos, state, player);

                    if(result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            });

    ActionResult interact(World world, BlockPos pos, BlockState state, PlayerEntity player);
}
