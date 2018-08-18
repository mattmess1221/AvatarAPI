package com.minelittlepony.avatar.impl;

import com.minelittlepony.avatar.texture.TextureData;
import com.minelittlepony.avatar.texture.TextureType;

import java.util.Optional;

public interface INetworkPlayerInfo {

    Optional<TextureData> getPlayerTexture(TextureType type);
}
