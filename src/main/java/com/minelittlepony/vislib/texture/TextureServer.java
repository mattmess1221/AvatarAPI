package com.minelittlepony.vislib.texture;

import com.mojang.authlib.GameProfile;
import net.minecraft.util.Session;

import java.util.concurrent.CompletableFuture;

public interface TextureServer {

    CompletableFuture<TexturePayload> load(GameProfile profile);

    CompletableFuture<TextureUpload.Response> upload(Session session, TextureUpload upload);

}
