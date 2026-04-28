public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 =
            new Quantity<>(10, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
            new Quantity<>(6, LengthUnit.INCHES);

        System.out.println(l1.subtract(l2));
        System.out.println(l1.divide(l2));

        Quantity<WeightUnit> w1 =
            new Quantity<>(10, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
            new Quantity<>(5000, WeightUnit.GRAM);

        System.out.println(w1.subtract(w2));
        System.out.println(w1.divide(w2));

        Quantity<VolumeUnit> v1 =
            new Quantity<>(5, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
            new Quantity<>(500, VolumeUnit.MILLILITRE);

        System.out.println(v1.subtract(v2));
        System.out.println(v1.divide(v2));
    }
}