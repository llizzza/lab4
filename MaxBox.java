public class MaxBox {
    public static  double findMax(Box<? extends Number>... boxes) {
        if (boxes == null) {
            throw new IllegalArgumentException("Коробок нет!");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> box : boxes) {
            if (box.isEmpty()) {
                continue;
            }
            double value = box.get().doubleValue();
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
