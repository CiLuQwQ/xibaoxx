package io.github.ciluqwq.xibaoxx;


import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.Minecraft;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class Xibaoxx {
    public static final String MOD_ID = "xibaoxx";

    public static void init() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }

    public static void onPressConfigButton(Button btn, Screen parentScreen, Minecraft mc) {
        Screen configScreen = AutoConfig.getConfigScreen(ModConfig.class, parentScreen).get();
        Minecraft.getInstance().setScreen(configScreen);
    }

}
