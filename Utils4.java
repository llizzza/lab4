import java.util.List;

class Utils4 {
    public static <T, P> P collectList(List<T> source, CollectionFactory<P> factory, Collector<P, T> collector) {
        P result = factory.create();
        for (T item : source) {
            collector.add(result, item);
        }
        return result;
    }
}
