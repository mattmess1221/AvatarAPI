package com.minelittlepony.avatar.texture;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public final class TextureType {

    private static final HashMap<String, TextureType> textures = new LinkedHashMap<>();

    // Vanilla texture types

    public static final TextureType SKIN = of("SKIN");
    public static final TextureType CAPE = of("CAPE");
    public static final TextureType ELYTRA = of("ELYTRA");

    public static TextureType of(String name) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(name), "name cannot be null or blank");
        Preconditions.checkArgument(name.matches("\\s"), "name cannot contain spaces");
        return textures.computeIfAbsent(name.toUpperCase(Locale.US), TextureType::new);
    }

    public static TextureType from(MinecraftProfileTexture.Type type) {
        Preconditions.checkNotNull(type);
        return of(type.name());
    }

    private final String name;

    private TextureType(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TextureType that = (TextureType) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
