public class QuantityMeasurementApp {

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            double feet = unit.convertToBaseUnit(value);
            double converted =
                    targetUnit.convertFromBaseUnit(feet);

            return new QuantityLength(converted, targetUnit);
        }

        public QuantityLength add(QuantityLength other) {
            return add(other, this.unit);
        }

        public QuantityLength add(
                QuantityLength other,
                LengthUnit targetUnit) {

            double totalFeet =
                    this.unit.convertToBaseUnit(this.value)
                  + other.unit.convertToBaseUnit(other.value);

            double result =
                    targetUnit.convertFromBaseUnit(totalFeet);

            return new QuantityLength(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other =
                    (QuantityLength) obj;

            return Double.compare(
                this.unit.convertToBaseUnit(this.value),
                other.unit.convertToBaseUnit(other.value)
            ) == 0;
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

        System.out.println(q1.equals(q2));
        System.out.println(q1.add(q2, LengthUnit.YARDS));
        System.out.println(q1.convertTo(LengthUnit.INCHES));
    }
}