public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double result =
                targetUnit.convertFromBaseUnit(base);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        double total =
                this.unit.convertToBaseUnit(this.value)
              + other.unit.convertToBaseUnit(other.value);

        double result =
                targetUnit.convertFromBaseUnit(total);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        double diff =
                this.unit.convertToBaseUnit(this.value)
              - other.unit.convertToBaseUnit(other.value);

        double result =
                targetUnit.convertFromBaseUnit(diff);

        return new Quantity<>(result, targetUnit);
    }

    public double divide(Quantity<U> other) {

        double first =
            this.unit.convertToBaseUnit(this.value);

        double second =
            other.unit.convertToBaseUnit(other.value);

        return first / second;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

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