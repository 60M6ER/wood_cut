package ru.bomber.survivalfabric.callBacks;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttackTreeListener implements AttackBlockCallback {

    Logger LOGGER = LoggerFactory.getLogger(AttackTreeListener.class);

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        LOGGER.info("I see attack!");
        if (player.getItemsHand().iterator().next().getItem() instanceof AxeItem) {
            LOGGER.info("This is axe!");
            if (world.getBlockState(pos).getBlock() instanceof PillarBlock) {
                LOGGER.info("This is tree!");
                Set<BlockPos> posSet = new HashSet<>();
                getAllNeighbors(world.getBlockState(pos).getBlock(), world, pos, posSet, new HashSet<>());
                if (posSet.size() > 0) {
                    world.getBlockState(pos).calcBlockBreakingDelta()
                }
            }
        }
        return ActionResult.PASS;
    }

    private void getAllNeighbors(Block block, World world, BlockPos pos, Set<BlockPos> posSet, Set<BlockPos> allPos) {
        Set<BlockPos> curNeighbors = new HashSet<>();

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = 0; z < 2; z++) {
                    curNeighbors.add(new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
                }
            }
        }

        curNeighbors.forEach(pos1 -> {
            if (!posSet.contains(pos1) && !allPos.contains(pos1)) {
                if (world.getBlockState(pos1).getBlock().equals(block)) {
                    posSet.add(pos1);
                    getAllNeighbors(block, world, pos1, posSet, allPos);
                }
                allPos.add(pos1);
            }
        });
    }
}
