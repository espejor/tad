package tad.lista;

import tad.nodos.Nodo;

import java.util.Iterator;

public abstract class IteratorTAD implements Iterator{
    protected List<Nodo> tad;
    protected Nodo position;

    public IteratorTAD(List<Nodo> tad) {
        this.tad = tad;
    }
}
