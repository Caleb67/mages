package io.github.caleb67.mages.classes;

import io.github.caleb67.mages.spells.DebugSpell;
import io.github.caleb67.mages.spells.foundation.Spell;
import static io.github.caleb67.mages.Mages.LOGGER;

import java.util.Vector;

public class SpellSet
{
    public final Vector<Spell> spells;

    public Spell getByName(String spell_name)
    {
        for (Spell spell : spells)
        {
            if (spell.getName() == spell_name)
            {
                return spell;
            }
        }
        LOGGER.info("Couldn't find '"+spell_name+"' in the spellset!");
        return new DebugSpell();
    }

    public SpellSet(Vector<Spell> spells)
    {
        this.spells = spells;
    }
}
