package com.minelittlepony.avatar.impl;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.ModMetadata;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;

public class AvatarContainer extends DummyModContainer {

    public AvatarContainer() {
        super(mkmeta());
    }

    private static ModMetadata mkmeta() {

        try (InputStream meta = AvatarContainer.class.getResourceAsStream("/mcmod.info")) {
            return MetadataCollection.from(meta, "mcmod.info").getMetadataForId("avatarapi", null);
        } catch(IOException e) {
            LogManager.getLogger().warn("Unable to load mcmod.info", e);
            ModMetadata meta = new ModMetadata();
            meta.modId = "avatarapi";
            meta.name = "AvatarAPI";
            meta.version = "Unknown";
            return meta;
        }

    }

}
