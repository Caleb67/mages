package io.github.caleb67.mages.spells;

import static io.github.caleb67.mages.Mages.LOGGER;

public class ManaValue
{
    private int value;
    private int max_value;
    public ManaValue(int max_value, int value)
    {
        this.max_value = max_value;
        this.setMana(value);
    }
    public int get()
    {
        return value;
    }
    public void setMana(int value)
    {
        if (value > max_value)
        {
            LOGGER.info(String.format("%d is greater than the max mana value %d!", value, max_value));
            this.value = max_value;
        }
        if (value < 0)
        {
            LOGGER.info("Cannot set the mana to a negative value!");
            this.value = 0;
        }
        this.value = value;
    }
    public void addMana(int value)
    {
        if((this.value + value) > max_value)
        {
            this.value = max_value;
        }
        if((this.value + value) < 0)
        {
            this.value = 0;
        }
        this.value += value;
    }
}
