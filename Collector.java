interface Collector<P, T> {
    void add(P collection, T item);
}

interface CollectionFactory<P> {
    P create();
}
