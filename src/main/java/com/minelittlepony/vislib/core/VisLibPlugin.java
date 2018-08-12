package com.minelittlepony.vislib.core;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

import javax.annotation.Nullable;

public class VisLibPlugin implements IFMLLoadingPlugin {

    public VisLibPlugin() {
        Mixins.addConfiguration("mixins.vislib.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
