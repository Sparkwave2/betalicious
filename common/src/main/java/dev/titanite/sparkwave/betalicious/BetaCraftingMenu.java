package dev.titanite.sparkwave.betalicious;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Blocks;

public class BetaCraftingMenu extends CraftingMenu {

    private final ContainerLevelAccess access;

    public BetaCraftingMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    public BetaCraftingMenu(int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(i, inventory);
        this.access = containerLevelAccess;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, Betalicious.BETA_CRAFTING_TABLE.get());
    }
}
