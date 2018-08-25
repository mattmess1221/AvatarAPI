package com.minelittlepony.avatar.impl;

import net.minecraftforge.fml.client.FMLClientHandler;

import java.util.concurrent.Executor;

public class MinecraftExecutors {

    public static Executor client() {
        return command -> FMLClientHandler.instance().getClient().addScheduledTask(command);
    }

}
