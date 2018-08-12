package com.minelittlepony.vislib.core.mixin;

import com.minelittlepony.vislib.event.TextureLoadEvent;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.image.BufferedImage;

@Mixin(ImageBufferDownload.class)
public class MixinImageBufferDownload {

    @Inject(method = "parseUserSkin", at = @At("RETURN"), cancellable = true)
    private void convertSkin(BufferedImage image, CallbackInfoReturnable<BufferedImage> ci) {
        TextureLoadEvent event = new TextureLoadEvent(image, ci.getReturnValue());
        MinecraftForge.EVENT_BUS.post(event);
        ci.setReturnValue(event.getImage());
    }
}
