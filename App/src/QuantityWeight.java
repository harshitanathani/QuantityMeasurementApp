public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        double kg = unit.convertToBaseUnit(value);
        double converted =
                targetUnit.convertFromBaseUnit(kg);

        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    public QuantityWeight add(
            QuantityWeight other,
            WeightUnit targetUnit) {

        double totalKg =
                this.unit.convertToBaseUnit(this.value)
              + other.unit.convertToBaseUnit(other.value);

        double result =
                targetUnit.convertFromBaseUnit(totalKg);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityWeight other =
                (QuantityWeight) obj;

        return Double.compare(
            this.unit.convertToBaseUnit(this.value),
            other.unit.convertToBaseUnit(other.value)
        ) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}