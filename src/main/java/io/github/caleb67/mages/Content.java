package io.github.caleb67.mages;

import io.github.caleb67.mages.classes.Classes;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import io.github.caleb67.mages.network.ClassDataPayload;
public class Content
{
    private static void common()
    {
        PayloadTypeRegistry.playS2C().register(ClassDataPayload.ID, ClassDataPayload.PACKET_CODEC);
    }
    public static void init() {
        common();
        Classes.init();
    }
}
