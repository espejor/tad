package tad.lista;

import tad.nodos.NodoL;

import java.util.Iterator;

public class IteratorList<T>  implements Iterator<T> {
    private LinkedList<T> lista;
    protected NodoL<T> position;

    public IteratorList(LinkedList<T> lista) {
        position = lista.inicio;
        this.lista = lista;
    }



    private NodoL<T> getPosition() {
        return position;
    }

    /**
     * Setter de position
     *
     * @param position del tipo tad.nodos.NodoL
     */
    public void setPosition(NodoL<T> position) {
        this.position = position;
    }

    @Override
    public boolean hasNext() {
        return position != null;
    }

    @Override
    public T next() {
        NodoL<T> temp = position;
        position = (position.getSiguiente());
        return temp.getValue();
    }
}
