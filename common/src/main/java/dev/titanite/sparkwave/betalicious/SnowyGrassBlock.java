package dev.titanite.sparkwave.betalicious;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.SnowyDirtBlock;

import java.util.List;

public class SnowyGrassBlock extends SnowyDirtBlock {
    public SnowyGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("block.betalicious.beta_snowy_grass_block.tooltip1").withColor(11184810));
        list.add(Component.translatable("block.betalicious.beta_snowy_grass_block.tooltip2").withColor(11184810));

    }
}
