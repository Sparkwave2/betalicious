package dev.titanite.sparkwave.betalicious;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.LeavesBlock;

import java.util.List;

public class OpaqueLeaves extends LeavesBlock {
    public OpaqueLeaves(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("block.betalicious.beta_opaque_leaves.tooltip").withColor(11184810));

    }
}
