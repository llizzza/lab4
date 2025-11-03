import java.util.ArrayList;
import java.util.List;

class Utils2 {
    public static <T> List<T> filterList(List<T> input, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
