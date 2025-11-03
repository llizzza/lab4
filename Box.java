public class Box < type > {
    private type item;

    public Box(type item) {
            this.item = item;
    }

    public void put(type item) {
        if (this.item != null) {
            throw new IllegalArgumentException("Коробка не пустая!");
        }
        this.item = item;
    }

    public type get() {
        if ( item == null) {
            throw new IllegalArgumentException("Коробка пустая!");
        }
        type item2 = item;
        item = null;
        return item2;
    }

    public boolean isEmpty() {
        return item == null;
    }

    public String toString() {
        if (item == null) {
            return "Коробка пустая.";
        } else {
            return "Коробка содержит" + item.toString();
        }
    }
}
