package dev.titanite.sparkwave.betalicious.fabric.client;

import dev.titanite.sparkwave.betalicious.Betalicious;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public final class BetaliciousFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_COBWEB.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_ROSE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_DANDELION.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_RED_MUSHROOM.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_BROWN_MUSHROOM.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_GLASS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_CACTUS.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_SUGAR_CANE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_TORCH.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_REDSTONE_TORCH.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_WOODEN_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_IRON_DOOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_LADDER.get(), RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Betalicious.BETA_ICE.get(), RenderType.translucent());
    }
}
