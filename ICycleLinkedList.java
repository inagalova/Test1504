public interface ICycleLinkedList<T> {
    boolean isEmpty();
    int size();
    void add(T element);
    void addAtIndex(int index, T element);
    void clear();
    T get(int index);
}
