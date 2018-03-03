package tad.cola;

public interface Cola<T> {
    void enqueue(T obj);
    T dequeue();
    boolean isEmpty();
}
