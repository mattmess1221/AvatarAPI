package com.minelittlepony.vislib.texture;

import com.minelittlepony.vislib.core.INetworkPlayerInfo;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TextureService {

    static Optional<TextureData> getPlayerTexture(NetworkPlayerInfo playerInfo, TextureType type) {
        return ((INetworkPlayerInfo) playerInfo).getPlayerTexture(type);
    }

    CompletableFuture<TexturePayload> loadTextures(GameProfile profile);

    void loadTextures(GameProfile profile, SkinCallback callback);

    ResourceLocation loadTexture(TextureType type, TextureProfile texture, SkinCallback callback);

    void registerServer(TextureServer server);

    @FunctionalInterface
    interface SkinCallback {

        void skinAvailable(TextureType type, TextureData location);
    }

}
