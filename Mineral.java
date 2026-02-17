
/**
 * Sample Mineral class
 */
public class Mineral extends Cargo
{
    private static final double MINIMUM_DENSITY_KGM3 = 0.00001;
    private static final double DENSITY_DIFF_AMPLIFY = 10000;
    private static final int ORDER_CATEGORY = 2;

    private final double densityKgM3;

    public Mineral(final double densityKgM3, final int loadWeightKgs)
    {
        super(loadWeightKgs);
        validateDensity(densityKgM3);

        this.densityKgM3 = densityKgM3;
    }

    private static void validateDensity(final double densityKgM3)
    {
        if (densityKgM3 < MINIMUM_DENSITY_KGM3)
        {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCategoryValue()
    {
        return Mineral.ORDER_CATEGORY;
    }
    
    @Override
    public int compareTo(final Cargo that)
    {
        if (that == null)
        {
            throw new NullPointerException("Cannot compare against null");
        }

        if (that instanceof Mineral)
        {
            final Mineral thatMineral;
            final double densityDiff;

            thatMineral = (Mineral) that;
            // Multiplying differences less than 1 to still get propering ordering up to a point.
            densityDiff = (this.densityKgM3 - thatMineral.densityKgM3) * DENSITY_DIFF_AMPLIFY;
            return (int) (densityDiff);
        }
        else
        {
            return this.getCategoryValue() - that.getCategoryValue();
        }
        
    }
}