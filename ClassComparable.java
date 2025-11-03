class ClassComparable implements Comparable<ClassComparable>{
    private int item;

    public ClassComparable(int item) {
        this.item = item;
    }

    public int сравнить(ClassComparable other) {
        if (this.item < other.item) {
            return -1;
        } else if (this.item > other.item) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(item);
    }
}
