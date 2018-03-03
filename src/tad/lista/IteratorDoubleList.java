package tad.lista;

import tad.nodos.NodoDL;

public class IteratorDoubleList<T> extends IteratorList<T> {

    public IteratorDoubleList(DoubleLinkedList lista) {
        super(lista);
        position = (NodoDL) lista.ultimo;
    }

    public boolean hasPrevious() {
        return position != null;

    }

    public T previous() {
        NodoDL<T> temp = (NodoDL)position;
        position = ((NodoDL) position).getAnterior();
        return temp.getValue();
    }
}
