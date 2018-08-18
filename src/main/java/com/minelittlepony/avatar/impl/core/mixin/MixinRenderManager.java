package com.minelittlepony.avatar.impl.core.mixin;

import com.minelittlepony.avatar.ServiceManager;
import com.minelittlepony.avatar.render.RenderService;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RenderManager.class)
public abstract class MixinRenderManager {

    @Final @Shadow private Map<String, RenderPlayer> skinMap;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void postInit(TextureManager renderEngineIn, RenderItem itemRendererIn, CallbackInfo ci) {
        ServiceManager.get(RenderService.class).ifPresent(s -> s.loadPlayerRenders((RenderManager) (Object) this, skinMap));
    }

    @Redirect(method = "getEntityRenderObject",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/entity/RenderManager;"
                            + "getEntityClassRenderObject(Ljava/lang/Class;)"
                            + "Lnet/minecraft/client/renderer/entity/Render;"))
    private <T extends Entity> Render<T> getRender(RenderManager renderManager, Class<T> entityClass) {
        Render<T> original = renderManager.getEntityClassRenderObject(entityClass);
        return ServiceManager.get(RenderService.class)
                .flatMap(s -> s.getOverrideEntity(entityClass, original))
                .orElse(original);
    }
}
