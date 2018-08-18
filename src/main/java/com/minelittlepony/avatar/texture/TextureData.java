package com.minelittlepony.avatar.texture;

import net.minecraft.util.ResourceLocation;

public class TextureData {

    private final ResourceLocation location;
    private final TextureProfile profile;

    public TextureData(ResourceLocation location, TextureProfile profile) {
        this.location = location;
        this.profile = profile;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public TextureProfile getProfile() {
        return profile;
    }
}
