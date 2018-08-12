package com.minelittlepony.vislib.core;

import com.minelittlepony.vislib.texture.TextureData;
import com.minelittlepony.vislib.texture.TextureType;

import java.util.Optional;

public interface INetworkPlayerInfo {

    Optional<TextureData> getPlayerTexture(TextureType type);
}
