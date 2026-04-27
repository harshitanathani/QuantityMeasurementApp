public class QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0);

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

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(this.convertToFeet(),
                                  other.convertToFeet()) == 0;
        }
    }

    public static void main(String[] args) {

        QuantityLength q1 =
            new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
            new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(q1.equals(q2));
    }
}