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
            double feetValue = convertToFeet();
            double converted = feetValue / targetUnit.getFactor();
            return new QuantityLength(converted, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(
                this.convertToFeet(),
                other.convertToFeet()
            ) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
            new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
            q1.convertTo(LengthUnit.INCHES);

        QuantityLength q3 =
            new QuantityLength(1.0, LengthUnit.YARDS)
                .convertTo(LengthUnit.INCHES);

        System.out.println(q2);
        System.out.println(q3);
    }
}