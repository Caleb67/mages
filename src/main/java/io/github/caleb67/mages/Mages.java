package io.github.caleb67.mages;

import io.github.caleb67.mages.manager.ClassDataManager;
import io.github.caleb67.mages.network.ClassDataPayload;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mages implements ModInitializer
{
    public static String MODID = "mages";

    public static Logger LOGGER = (Logger) LoggerFactory.getLogger("mages");;
    @Override
    public void onInitialize()
    {
        ServerPlayConnectionEvents.JOIN.register(
            (handler, sender, server) -> {
                ClassDataManager.PlayerClassData pcd = ClassDataManager.getPlayerState(handler.getPlayer());
                ClassDataPayload cdp = new ClassDataPayload(pcd.CLASS, pcd.MAX_MANA);

                server.execute(
                        () -> {
                            ServerPlayNetworking.send(handler.getPlayer(), cdp);
                        }
                );
            }
        );

        Content.init();

    }
}
