package com.minelittlepony.vislib.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface RenderService {

    void registerPlayerRenderer(String model, Function<RenderManager, RenderPlayer> renderer);

    <T extends Entity, R extends Render<? super T>> void registerOverrideRenderer(Class<T> cl, UnaryOperator<R> renderer);

    void loadPlayerRenders(RenderManager manager, Map<String, RenderPlayer> skinMap);

    <T extends Entity, R extends Render<? super T>> Optional<R> getOverrideEntity(Class<T> entity, R original);
}
