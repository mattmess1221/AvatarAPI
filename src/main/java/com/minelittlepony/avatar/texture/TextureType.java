package com.minelittlepony.avatar.texture;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import java.io.IOException;
import java.util.Locale;
import java.util.Set;

public final class TextureType {

    private static final BiMap<String, TextureType> textures = HashBiMap.create(3);

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

    public static Set<TextureType> values() {
        return textures.values();
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


    public static class Serializer extends TypeAdapter<TextureType> {

        @Override
        public void write(JsonWriter out, TextureType value) throws IOException {
            out.value(value.toString());
        }

        @Override
        public TextureType read(JsonReader in) throws IOException {
            return TextureType.of(in.nextString());
        }
    }
}
