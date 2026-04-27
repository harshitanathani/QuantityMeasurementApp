public class QuantityMeasurementApp {

    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static boolean checkFeetEquality(double first, double second) {
        Feet f1 = new Feet(first);
        Feet f2 = new Feet(second);
        return f1.equals(f2);
    }

    public static boolean checkInchesEquality(double first, double second) {
        Inches i1 = new Inches(first);
        Inches i2 = new Inches(second);
        return i1.equals(i2);
    }

    public static void main(String[] args) {

        System.out.println("Feet Equal: " + checkFeetEquality(1.0, 1.0));
        System.out.println("Inches Equal: " + checkInchesEquality(1.0, 1.0));
    }
}