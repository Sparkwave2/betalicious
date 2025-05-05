package dev.titanite.sparkwave.betalicious.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;

import dev.titanite.sparkwave.betalicious.Betalicious;

public final class BetaliciousFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        //ModConfigFabric.init();
        //ModConfigFabric config = AutoConfig.getConfigHolder(ModConfigFabric.class).getConfig();
        //Betalicious.disableDownload = config.disableDownload;
        //Betalicious.imageLocation = config.imageLocation;
        Betalicious.init();
    }
}
