package com.minelittlepony.avatar.impl.core.mixin;

import com.minelittlepony.avatar.ServiceManager;
import com.minelittlepony.avatar.texture.TextureData;
import com.minelittlepony.avatar.texture.TextureService;
import com.minelittlepony.avatar.texture.TextureType;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Optional;

import javax.annotation.Nullable;

@Mixin(TileEntitySkullRenderer.class)
public class MixinTileEntitySkullRenderer extends TileEntitySpecialRenderer<TileEntitySkull> {

    @Redirect(
            method = "renderSkull",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/tileentity/TileEntitySkullRenderer;bindTexture(Lnet/minecraft/util/ResourceLocation;)V",
                    ordinal = 4))
    private void onBindTexture(TileEntitySkullRenderer tesr, ResourceLocation rl, float x, float y, float z, EnumFacing facing, float rotation,
            int meta, @Nullable GameProfile profile, int p_180543_8_, float ticks) {
        Optional<TextureService> optService = ServiceManager.get(TextureService.class);

        if (profile != null && optService.isPresent()) {
            TextureService service = optService.get();
            TextureData texture = service.getTextures(profile).get(TextureType.SKIN);
            if (texture != null) {
                rl = texture.getLocation();
            }
        }
        bindTexture(rl);
    }
}
