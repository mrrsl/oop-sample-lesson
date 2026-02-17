import java.util.List;
import java.util.ArrayList;
/**
 * Sample Train class showing the compliant order method
 */
public class Train<CargoType extends Cargo>
{
    private static final int TRAIN_STARTING_GW_KGS = 2500;

    private int grossWeight;
    private List<TrainCart<CargoType>> carts;
    
    public Train()
    {
        this.grossWeight = TRAIN_STARTING_GW_KGS;
        this.carts = new ArrayList<>();
    }

    public boolean compliantCartOrder()
    {
        TrainCart<CargoType> prev;

        prev = null;

        for (final TrainCart<CargoType> currentCart : carts)
        {
            if (prev == null)
            {
                continue;
            }
            else
            {
                if (prev.compareTo(currentCart) < 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    void addCart(final TrainCart<CargoType> cart)
    {
        final Cargo addedCargo;

        addedCargo = cart.getCargo();

        for (int cartIndex = 0; cartIndex < carts.size(); cartIndex++)
        {
            final Cargo checkedCargo;
            final int cargoComparison;

            checkedCargo = carts.get(cartIndex).getCargo();
            cargoComparison = addedCargo.compareTo(checkedCargo);

            if (cargoComparison < 0)
            {
                carts.add(cartIndex, cart);
            }
        }
    }
}