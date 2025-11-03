import java.util.ArrayList;
import java.util.List;

interface Function<T, P> {
    P apply(T t);
}
class Utils {
    public static <T, P> List<P> mapList(List<T> input, Function<T, P> func) {
        List<P> result = new ArrayList<>();
        for (T item : input) {
            result.add(func.apply(item));
        }
        return result;
    }
}
