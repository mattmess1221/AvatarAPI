package com.minelittlepony.avatar.texture;

import org.apache.commons.io.FilenameUtils;

import java.net.URI;
import java.util.Optional;

public interface TextureProfile {

    URI getUrl();

    Optional<String> getMetadata(String key);

    default String getHash() {
        return FilenameUtils.getBaseName(this.getUrl().getPath());
    }

}
