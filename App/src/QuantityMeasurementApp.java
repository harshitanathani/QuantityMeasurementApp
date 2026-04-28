public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.0328084);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double convertToFeet() {
            return value * unit.getFactor();
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            double feet = convertToFeet();
            double converted = feet / targetUnit.getFactor();
            return new QuantityLength(converted, targetUnit);
        }

        public QuantityLength add(QuantityLength other) {
            double totalFeet =
                    this.convertToFeet()
                  + other.convertToFeet();

            double result =
                    totalFeet / this.unit.getFactor();

            return new QuantityLength(result, this.unit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
            new QuantityLength(1, LengthUnit.FEET);

        QuantityLength q2 =
            new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength q3 = q1.add(q2);

        System.out.println(q3);

        QuantityLength q4 =
            new QuantityLength(1, LengthUnit.YARDS);

        QuantityLength q5 =
            new QuantityLength(3, LengthUnit.FEET);

        System.out.println(q4.add(q5));
    }
}