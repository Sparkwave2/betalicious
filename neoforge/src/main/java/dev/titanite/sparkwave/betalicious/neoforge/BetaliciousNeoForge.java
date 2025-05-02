package dev.titanite.sparkwave.betalicious.neoforge;

import dev.titanite.sparkwave.betalicious.Betalicious;
import net.neoforged.fml.common.Mod;

@Mod(Betalicious.MOD_ID)
public final class BetaliciousNeoForge {
    public BetaliciousNeoForge() {
        // Run our common setup.
        Betalicious.init();
    }
}
