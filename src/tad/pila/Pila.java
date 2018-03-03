package tad.pila;

public interface Pila <T> {
    void push (T obj);
    T pop();
    boolean isEmpty();
}
