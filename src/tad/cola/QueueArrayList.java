package tad.cola;

import java.util.ArrayList;

public class QueueArrayList<T> implements Cola<T> {
    ArrayList<T> lista = new ArrayList<>();

    @Override
    public void enqueue(T obj) {
        lista.add(obj);   // Método de la superclase
    }

    @Override
    public T dequeue() {
        return lista.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
