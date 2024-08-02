package io.github.caleb67.mages.client.manager;

import io.github.caleb67.mages.classes.foundation.CLASS;
import io.github.caleb67.mages.manager.ClassDataManager;
import io.github.caleb67.mages.spells.ManaValue;
import io.github.caleb67.mages.classes.Classes;

public class ClientClassStateManager
{
    public static ManaValue Mana = new ManaValue(100, 100);
    public static CLASS Class = Classes.NONE;

    public static void update(ClassDataManager.PlayerClassData data)
    {
        Mana = new ManaValue(data.MAX_MANA, data.MAX_MANA);
        Class = Classes.of(data.CLASS);
    }
}
