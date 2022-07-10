package ru.bomber.wood_cut.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.bomber.wood_cut.callbacks.OnBreakBlockListener;

@Mixin(Block.class)
public abstract class BlockMixin {

    @Inject(method = "onBreak", at = @At(value = "TAIL"))
    protected void onBreakBlock(final World world, final BlockPos pos, final BlockState state, final PlayerEntity player, final CallbackInfo ci) {
        OnBreakBlockListener.EVENT.invoker().interact(world, pos, state, player);
    }
}
