package com.minelittlepony.avatar.texture;

import com.minelittlepony.avatar.impl.INetworkPlayerInfo;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.NetworkPlayerInfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import javax.annotation.Nullable;

public interface TextureService {

    static Optional<TextureData> getPlayerTexture(NetworkPlayerInfo playerInfo, TextureType type) {
        return ((INetworkPlayerInfo) playerInfo).getPlayerTexture(type);
    }

    CompletableFuture<Map<TextureType, TextureProfile>> loadProfileTextures(GameProfile profile);

    TextureData loadTexture(TextureType type, TextureProfile texture, @Nullable BiConsumer<TextureType, TextureData> callback);

    default Map<TextureType, TextureData> getTextures(GameProfile profile) {
        CompletableFuture<Map<TextureType, TextureProfile>> future = loadProfileTextures(profile);
        if (!future.isDone() || future.isCompletedExceptionally()) {
            return Collections.emptyMap();
        }

        Map<TextureType, TextureProfile> textures = future.getNow(Collections.emptyMap());
        Map<TextureType, TextureData> map = new HashMap<>();
        for (Map.Entry<TextureType, TextureProfile> e : textures.entrySet()) {
            map.put(e.getKey(), loadTexture(e.getKey(), e.getValue(), null));
        }
        return map;

    }

}
