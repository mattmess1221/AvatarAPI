package com.minelittlepony.vislib.texture;

import java.util.Map;
import java.util.UUID;

public interface TexturePayload {

    long getTimestamp();

    UUID getProfileId();

    String getProfileName();

    boolean isPublic();

    Map<TextureType, TextureProfile> getTextures();

}
