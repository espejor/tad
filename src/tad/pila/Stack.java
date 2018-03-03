package tad.pila;

import tad.nodos.NodoL;
import tad.lista.LinkedList;

public class Stack <T> implements Pila<T> {
    LinkedList<T> lista = new LinkedList<>();

    public void push(T obj){
        lista.insert(obj);
    }


    public T pop(){
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
