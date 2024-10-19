package io.github.ciluqwq.xibaoxx.fabric;

import io.github.ciluqwq.xibaoxx.Xibaoxx;
import net.fabricmc.api.ModInitializer;

public final class XibaoxxFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Xibaoxx.init();
    }
}
