public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight w1 =
            new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
            new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight w3 =
            new QuantityWeight(2, WeightUnit.POUND);

        System.out.println(w1.equals(w2));
        System.out.println(w1.convertTo(WeightUnit.GRAM));
        System.out.println(w1.add(w3));
    }
}