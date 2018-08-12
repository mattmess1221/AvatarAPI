package com.minelittlepony.vislib.event;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.awt.image.BufferedImage;

import javax.annotation.Nullable;

/**
 * Fired possibly async when a skin is loaded from network or disk. It is used to check and convert to a newer format.
 */
public class TextureLoadEvent extends Event {

    private final BufferedImage original;
    private BufferedImage image;

    public TextureLoadEvent(BufferedImage original, BufferedImage image) {
        this.original = original;
        this.image = image;
    }

    public BufferedImage getOriginalImage() {
        return original;
    }

    @Nullable
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
