package io.github.caleb67.mages.classes;

import io.github.caleb67.mages.Mages;
import io.github.caleb67.mages.classes.foundation.CLASS;
import io.github.caleb67.mages.spells.foundation.Spell;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


import java.util.Vector;

public class Classes
{
    private static final RegistryKey<Registry<CLASS>>CLASS_KEY = RegistryKey.ofRegistry(Identifier.of(Mages.MODID, "classes"));
    public static final Registry<CLASS> CLASSES = FabricRegistryBuilder.createSimple(CLASS_KEY)
                                                                .attribute(RegistryAttribute.SYNCED)
                                                                .buildAndRegister();

    public static void init(){};

    public static CLASS of(int class_value)
    {
        return switch (class_value) {
            case 0 -> Classes.NONE;
            default -> Classes.NONE;
        };
    }

    public static CLASS NONE = Registry.register(CLASSES, Identifier.of(Mages.MODID, "none"),
                                new CLASS(
                                        "none",
                                        new SpellSet(new Vector<Spell>()),
                                        ClassType.MISC
                                ));

}
