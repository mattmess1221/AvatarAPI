package com.minelittlepony.vislib.texture;

import java.net.URI;
import java.util.Map;

public class TextureUpload {

    private final URI file;
    private final TextureType type;
    private final Map<String, String> metadata;

    public TextureUpload(URI file, TextureType type, Map<String, String> metadata) {
        this.file = file;
        this.type = type;
        this.metadata = metadata;
    }

    public URI getFile() {
        return file;
    }

    public TextureType getType() {
        return type;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public static class Response {

        private String message;

        public Response(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
