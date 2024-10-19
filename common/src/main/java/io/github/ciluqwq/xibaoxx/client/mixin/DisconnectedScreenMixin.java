package io.github.ciluqwq.xibaoxx.client.mixin;

import io.github.ciluqwq.xibaoxx.ModConfig;
import io.github.ciluqwq.xibaoxx.Xibaoxx;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DisconnectedScreen.class)
public abstract class DisconnectedScreenMixin extends Screen {
    private static final ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    @Final
    @Shadow
    private LinearLayout layout;

    protected DisconnectedScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/layouts/LinearLayout;arrangeElements()V"))
    private void addConfigButton(CallbackInfo ci) {
        if (config.showOpenConfigScreenButton) {
            var translatable = Component.translatable("xibao.open_config_page");
            this.layout.addChild(Button.builder(translatable,
                    btn -> Xibaoxx.onPressConfigButton(btn, this, this.minecraft)).width(200).build());
        }
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        ResourceLocation TEXTURE = config.skyle== ModConfig.Skyle.XIBAO ? ResourceLocation.fromNamespaceAndPath("xibaoxx", "textures/xibao.png"):ResourceLocation.fromNamespaceAndPath("xibaoxx", "textures/beibao.png");
        if (config.skyle != ModConfig.Skyle.VANILLA) {
            ((GuiGraphicsAccessor) guiGraphics).invokeInnerBlit(
                    TEXTURE, 0, this.width, 0, this.height, 0, 0, 1, 0, 1
            );
        } else {
            super.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        }


    }
}