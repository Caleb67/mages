package io.github.caleb67.mages.client;

import io.github.caleb67.mages.client.manager.ClientClassStateManager;
import io.github.caleb67.mages.manager.ClassDataManager;
import io.github.caleb67.mages.network.ClassDataPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ClientContent
{

    public static void init()
    {
        common();
    }

    private static void common()
    {
        ClientPlayNetworking.registerGlobalReceiver(ClassDataPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                System.out.println("Recieved Payload");
                ClientClassStateManager.update(new ClassDataManager.PlayerClassData(payload.CLASS(), payload.MAX_MANA()));
                System.out.println(ClientClassStateManager.Class.class_name);
                System.out.println(ClientClassStateManager.Mana.get());
            });
        });
    }
}
