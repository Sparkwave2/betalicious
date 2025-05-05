package dev.titanite.sparkwave.betalicious;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.List;

public class BetaSapling extends SaplingBlock {
    public BetaSapling(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("block.betalicious.beta_sapling.tooltip").withColor(11184810));
    }
}
