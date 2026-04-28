public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    private double performArithmetic(
            Quantity<U> other,
            char operation) {

        double first = this.toBase();
        double second = other.toBase();

        switch (operation) {
            case '+':
                return first + second;

            case '-':
                return first - second;

            case '/':
                return first / second;

            default:
                return 0;
        }
    }

    public Quantity<U> convertTo(U targetUnit) {
        double result =
            targetUnit.convertFromBaseUnit(toBase());

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        double result =
            targetUnit.convertFromBaseUnit(
                performArithmetic(other, '+'));

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        double result =
            targetUnit.convertFromBaseUnit(
                performArithmetic(other, '-'));

        return new Quantity<>(result, targetUnit);
    }

    public double divide(Quantity<U> other) {
        return performArithmetic(other, '/');
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        return Double.compare(
            this.toBase(),
            other.unit.convertToBaseUnit(other.value)
        ) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}