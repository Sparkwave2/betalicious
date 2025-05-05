package dev.titanite.sparkwave.betalicious.neoforge;

import dev.titanite.sparkwave.betalicious.Betalicious;
import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.fml.common.Mod;

@Mod(Betalicious.MOD_ID)
public final class BetaliciousNeoForge {
    public BetaliciousNeoForge() {
        // Run our common setup.
        //ModConfigNeoForge.init();
        //ModConfigNeoForge config = AutoConfig.getConfigHolder(ModConfigNeoForge.class).getConfig();
        //Betalicious.disableDownload = config.disableDownload;
        //Betalicious.imageLocation = config.imageLocation;
        Betalicious.init();
    }
}
