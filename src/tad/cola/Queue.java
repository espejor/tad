package tad.cola;

import tad.nodos.NodoL;
import tad.lista.LinkedList;

/**
 * Implementación de una Cola mediate una Lista enlazada
 * @param <T> Genérico
 */
public class Queue <T> implements Cola<T> {

    LinkedList<T> lista = new LinkedList<>();

    public void enqueue(T obj){
        lista.add(obj);
    }

    public T dequeue(){
        return lista.deleteFirst();
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
