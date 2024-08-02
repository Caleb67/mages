package io.github.caleb67.mages.manager;

import io.github.caleb67.mages.Mages;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class ClassDataManager extends PersistentState
{
    public static class PlayerClassData {
        public int CLASS = 0;
        public int MAX_MANA = 100;
        public PlayerClassData(){};
        public PlayerClassData(int CLASS, int MAX_MANA)
        {
            this.CLASS = CLASS;
            this.MAX_MANA = MAX_MANA;
        }
    }

    public HashMap<UUID, PlayerClassData> playerData = new HashMap<>();

    public static PlayerClassData getPlayerState(LivingEntity player) {
        ClassDataManager serverState = getPersistent(player.getWorld().getServer());

        // Either get the player by the uuid, or we don't have data for him yet, make a new player state

        return serverState.playerData.computeIfAbsent(player.getUuid(), uuid -> new PlayerClassData());
    }


    public static ClassDataManager getPersistent(MinecraftServer server)
    {
        PersistentStateManager psm = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ClassDataManager cdm = psm.getOrCreate(type, Mages.MODID);
        cdm.markDirty();
        return cdm;
    }

    public static ClassDataManager createFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        ClassDataManager state = new ClassDataManager();
        NbtCompound playersNbt = tag.getCompound("players");

        playersNbt.getKeys().forEach(
                key -> {
                    PlayerClassData pd = new PlayerClassData();
                    pd.CLASS = playersNbt.getCompound(key).getInt("class");
                    pd.MAX_MANA = playersNbt.getCompound(key).getInt("mana");

                    UUID uuid = UUID.fromString(key);
                    state.playerData.put(uuid, pd);
                }
        );
        return state;
    }

    private static Type<ClassDataManager> type = new Type<>(
            ClassDataManager::new, // If there's no 'ClassDataManager' yet create one
            ClassDataManager::createFromNbt, // If there is a 'ClassDataManager' NBT, parse it with 'createFromNbt'
            null // Supposed to be an 'DataFixTypes' enum, but we can just pass null
    );

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        NbtCompound playersNbt = new NbtCompound();
        playerData.forEach((uuid, playerClassData) -> {
            NbtCompound playerNbt = new NbtCompound();
            playerNbt.putInt("class", playerClassData.CLASS);
            playerNbt.putInt("mana", playerClassData.MAX_MANA);

            playersNbt.put(uuid.toString(), playerNbt);
        });

        nbt.put("players", playersNbt);
        return nbt;
    }

}
