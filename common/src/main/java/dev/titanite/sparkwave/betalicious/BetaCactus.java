package dev.titanite.sparkwave.betalicious;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BetaCactus extends CactusBlock {
    public BetaCactus(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockState2 = levelReader.getBlockState(blockPos.relative(direction));
            if (blockState2.isSolid() || levelReader.getFluidState(blockPos.relative(direction)).is(FluidTags.LAVA)) {
                return false;
            }
        }

        BlockState blockState3 = levelReader.getBlockState(blockPos.below());
        return (blockState3.is(Betalicious.BETA_CACTUS) || blockState3.is(BlockTags.SAND)) && !levelReader.getBlockState(blockPos.above()).liquid();
    }
}
