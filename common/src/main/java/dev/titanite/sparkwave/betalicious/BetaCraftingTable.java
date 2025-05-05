package dev.titanite.sparkwave.betalicious;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BetaCraftingTable extends CraftingTableBlock {
    private static final Component CONTAINER_TITLE = Component.translatable("gui.betalicious.beta_crafting_table");

    public BetaCraftingTable(Properties properties) {
        super(properties);
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i, inventory, player) -> new BetaCraftingMenu(i, inventory, ContainerLevelAccess.create(level, blockPos)), CONTAINER_TITLE);
    }
}
