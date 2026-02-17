public abstract class Cargo implements
    Comparable<Cargo>
{
    private static final int MIN_STARTING_WEIGHT = 1000;
    private int weightKgs;

    public Cargo(final int startingWeightKgs)
    {
        validateStartingWeight(startingWeightKgs);

        this.weightKgs = startingWeightKgs;
    }

    private static void validateStartingWeight(final int startingWeight)
    {
        if (startingWeight < MIN_STARTING_WEIGHT)
        {
            throw new IllegalArgumentException("Starting weight cannot be below " + MIN_STARTING_WEIGHT);
        }
    }

    public int getWeightKgs()
    {
        return this.weightKgs;
    }
    
    public abstract int getCategoryValue();
}
