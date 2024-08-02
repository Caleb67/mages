package io.github.caleb67.mages.spells.foundation;

import io.github.caleb67.mages.spells.ManaValue;
import io.github.caleb67.mages.spells.CastContext;
import io.github.caleb67.mages.spells.CastResult;

public interface Spell
{
    boolean isValid();
    CastResult canCast(ManaValue mana);
    double getCastTime();
    double getRecastTime();
    CastResult cast(CastContext context);
    String getName();
}
