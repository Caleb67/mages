package io.github.caleb67.mages.client;

import net.fabricmc.api.ClientModInitializer;

public class MagesClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        ClientContent.init();
    }
}
