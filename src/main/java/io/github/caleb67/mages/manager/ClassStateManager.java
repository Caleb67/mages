package io.github.caleb67.mages.manager;

import io.github.caleb67.mages.classes.foundation.CLASS;
import io.github.caleb67.mages.spells.CastContext;
import io.github.caleb67.mages.spells.CastResult;
import io.github.caleb67.mages.spells.ManaValue;
import net.minecraft.entity.player.PlayerEntity;
import io.github.caleb67.mages.spells.foundation.*;
import net.minecraft.world.World;

public class ClassStateManager
{
    public static CastResult cast(String spell_name,
                           CLASS player_class,
                           CastContext context
                            )
    {
        if (context.world.isClient())
        {
            return CastResult.FAIL;
        }
        Spell spell = player_class.spells.getByName(spell_name);
        if(!spell.isValid())
        {
            return CastResult.INVALID;
        }
        CastResult result;
        if ((result = spell.canCast(context.mana)) != CastResult.SUCCESS)
        {
            return result;
        }

        return spell.cast(context);
    }
}
