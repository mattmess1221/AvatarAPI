package com.minelittlepony.avatar.texture;

import org.apache.commons.io.FilenameUtils;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public class TextureProfile {

    private URI url;
    private Map<String, String> metadata;

    public TextureProfile(URI url, Map<String, String> metadata) {
        this.url = url;
        this.metadata = metadata;
    }

    public URI getUrl() {
        return url;
    }

    public String getHash() {
        return FilenameUtils.getBaseName(this.url.getPath());
    }

    public Optional<String> getMetadata(String key) {
        return Optional.ofNullable(metadata.get(key));
    }


}
