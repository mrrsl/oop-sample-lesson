public class TrainCart<CargoType extends Cargo> implements
    Comparable<TrainCart<CargoType>>
{
    private static final int CART_WEIGHT_KGS = 2000;
    
    private CargoType cargo;

    public TrainCart(final CargoType cargo)
    {
        validateCargo(cargo);

        this.cargo = cargo;
    }

    private static <CargoType> void validateCargo(final CargoType cargo)
    {
        if (cargo == null)
        {
            throw new IllegalArgumentException("Cannot load null cargo onto cart");
        }
    }

    public int getTotalWeight()
    {
        return cargo.getWeightKgs() + CART_WEIGHT_KGS;
    }

    public CargoType getCargo()
    {
        return this.cargo;
    }

    @Override
    public int compareTo(final TrainCart<CargoType> thatCart)
    {
        final Cargo currentCargo;
        final Cargo thatCargo;

        currentCargo = this.cargo;
        thatCargo = thatCart.cargo;

        return currentCargo.compareTo(thatCargo);
    }
}
