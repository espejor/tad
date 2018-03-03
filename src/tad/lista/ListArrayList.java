package tad.lista;

import java.util.ArrayList;
import java.util.Iterator;

public class ListArrayList <T> implements List<T> {
    protected ArrayList<T> lista = new ArrayList<T>();

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.size() == 0;
    }

    @Override
    public void add(T o) {
        lista.add(o);
    }

    @Override
    public void insert(T obj) {
        lista.add(0,obj);
    }

    @Override
    public void insert(T lugar, T obj) {
        int i = seek(lugar);
        lista.add(i,obj);
    }

    @Override
    public void set(T site, T obj) {
        int i = seek(site);
        lista.set(i,obj);
    }

    @Override
    public T deleteFirst() {
        T first = lista.get(0);
        lista.remove(0);
        return first;
    }

    @Override
    public boolean delete(T o) {
        T obj = get(lista.indexOf(o));
        return lista.remove(o);
    }

    @Override
    public int seek(T o) {
        return lista.indexOf(o);
    }

    @Override
    public boolean contains(T o) {
        return lista.contains(o);
    }

    @Override
    public T get(int i) {
        return lista.get(i);
    }

    @Override
    public String toString() {
        String output = "";
        Iterator it = lista.iterator();
        while (it.hasNext()){
            output += "(" + it.next() + ") ";
        }
        return output;
    }
}
