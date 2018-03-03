package tad.pila;

import java.util.ArrayList;

public class StackArrayList<T> implements Pila<T> {
    ArrayList<T> lista = new ArrayList<>();

    @Override
    public void push(T obj) {
        lista.add(0,obj);
    }

    @Override
    public T pop() {
        return lista.remove(0);  // Método de la superclase
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
