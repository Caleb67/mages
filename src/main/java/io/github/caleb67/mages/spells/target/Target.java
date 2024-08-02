package io.github.caleb67.mages.spells.target;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;

public class Target
{
    private final Object entity;
    private final TargetType type;

    public Target(LivingEntity entity)
    {
        this.entity = (Object) entity;
        this.type = TargetType.ENTITY;
    }
    public Target(BlockPos block)
    {
        this.entity = (Object) block;
        this.type = TargetType.BLOCK;
    }

    public BlockPos asBlock()
    {
        return (BlockPos) entity;
    }
    public LivingEntity asEntity()
    {
        return (LivingEntity) entity;
    }


}
