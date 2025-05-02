package dev.titanite.kato.betalicious.neoforge;

import net.neoforged.fml.common.Mod;

import dev.titanite.kato.betalicious.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
