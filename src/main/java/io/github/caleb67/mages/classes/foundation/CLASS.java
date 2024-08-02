package io.github.caleb67.mages.classes.foundation;

import io.github.caleb67.mages.classes.ClassType;
import io.github.caleb67.mages.classes.SpellSet;

public class CLASS
{
    public final String class_name;
    public final SpellSet spells;
    public final ClassType type;

    public CLASS(String class_name, SpellSet spells, ClassType type)
    {
        this.class_name = class_name;
        this.spells = spells;
        this.type = type;
    }
}
