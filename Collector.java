import java.util.List;

interface Collector<P, T> {
    void add(P collection, T item);
}

interface CollectionFactory<P> {
    P create();
}

class Utils4 {
    public static <T, P> P collectList(List<T> source, CollectionFactory<P> factory, Collector<P, T> collector) {
        P result = factory.create();
        for (T item : source) {
            collector.add(result, item);
        }
        return result;
    }
}
