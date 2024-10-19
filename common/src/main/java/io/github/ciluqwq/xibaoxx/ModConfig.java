package io.github.ciluqwq.xibaoxx;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.example.ExampleConfig;

@Config(name = Xibaoxx.MOD_ID)
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.EnumHandler(
            option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON
    )
    public Skyle skyle = Skyle.XIBAO;

    @ConfigEntry.Gui.TransitiveObject
    public boolean showOpenConfigScreenButton = true;
    public static enum Skyle {
        XIBAO,
        BEIBAO,
        VANILLA
    };
}
