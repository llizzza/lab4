import java.util.List;

class Utils3 {
    public static <T> T reduceList(List<T> list, Reduction<T> reduction, T defaultValue) {
        T result = defaultValue;
        for (T item : list) {
            result = reduction.apply(result, item);
        }
        return result;
    }
}

