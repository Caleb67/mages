package io.github.caleb67.mages.spells;

import io.github.caleb67.mages.spells.target.Target;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class CastContext
{
    public PlayerEntity player;
    public World world;
    public Target target;
    public ManaValue mana;

    public CastContext(PlayerEntity player,
                       ManaValue mana,
                       Target target,
                       World world)
    {
        this.player = player;
        this.world = world;
        this.target = target;
        this.mana = mana;
    }
}
