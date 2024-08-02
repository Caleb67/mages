package io.github.caleb67.mages.spells;

import io.github.caleb67.mages.spells.foundation.Spell;

import static io.github.caleb67.mages.Mages.LOGGER;

public class DebugSpell implements Spell
{
    public DebugSpell()
    {
    }

    @Override
    public boolean isValid()
    {
        return false;
    }

    @Override
    public CastResult canCast(ManaValue mana)
    {
        return CastResult.SUCCESS;
    }

    @Override
    public double getCastTime()
    {
        return 0.0;
    }

    @Override
    public double getRecastTime()
    {
        return 0.0;
    }

    @Override
    public CastResult cast(CastContext context)
    {
        LOGGER.info("Casted DEBUG.");
        return CastResult.SUCCESS;
    }

    @Override
    public String getName()
    {
        return "DEBUG";
    }
}
