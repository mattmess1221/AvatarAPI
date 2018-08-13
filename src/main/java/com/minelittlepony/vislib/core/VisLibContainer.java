package com.minelittlepony.vislib.core;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModMetadata;

public class VisLibContainer extends DummyModContainer {

    public VisLibContainer() {
        super(mkmeta());
    }

    private static ModMetadata mkmeta() {
        ModMetadata meta = new ModMetadata();
        meta.modId = "vislib";
        meta.name = "VisLib";
        meta.version = "1.0-SNAPSHOT";

        return meta;
    }

}
