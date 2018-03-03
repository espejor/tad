package tad.lista;

import tad.nodos.NodoL;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<NodoL>,List<T> {

    protected NodoL<T> inicio = null;
    protected NodoL<T> ultimo;
    protected int size = 0;


    public LinkedList(T o){
        NodoL<T> n = new NodoL<>(o);
        add(n);
    }

    /**
     * Constructor de una Lista vacía
     */
    public LinkedList() { }

    public int size() {
        return size;
    }


    private NodoL<T> getInicio() {
        return inicio;
    }

    private NodoL<T> getUltimo() {
        return ultimo;
    }

    public boolean isEmpty(){
        return (inicio == null);
    }


    /**
     * Elimina el primer elemento de la lista
     * @return El valor del primer elemento borrado
     */
    @Override
    public  T deleteFirst(){
        if (!isEmpty()) {
            T first = inicio.getValue();
            inicio = inicio.getSiguiente();
            size--;
            return first;
        }
        return null;
    }

    @Override
    public boolean delete(T o) {
        if (inicio.getValue().equals(o)){
            return deleteFirst() != null;
        }
        NodoL<T> previous =  previous(o);
        if (previous != null) {
            NodoL<T> nodeToDelete = previous.getSiguiente();
            if (nodeToDelete != null) {
                previous.setSiguiente(nodeToDelete.getSiguiente());
                size--;
                return true;
            }
        }
        return false;
    }

    private NodoL<T> previous (T o){
        IteratorList<T> it = (IteratorList<T>) iterator();
        NodoL<T> previousNode = it.position;
        while (it.hasNext()){
            if (previousNode.getSiguiente().getValue().equals(o))
                return previousNode;
            it.next();
            previousNode = it.position;
        }
        return null;
    }

    @Override
    public int seek(T o) {
        IteratorList it = (IteratorList) iterator();
        int i = 0;
        while (it.hasNext()){
            if (it.next().equals(o))
                return i;
            i++;
        }
        return -1;
    }


    @Override
    public boolean contains(T o){
        return seek(o) != -1;
    }

    @Override
    public T get(int i) {
        IteratorList<T> it = (IteratorList) iterator();
        int j = 0;
        while (it.hasNext()){
            if (i == j)
                return (it.next());
            it.next();
            j++;
        }
        return null;
    }

    @Override
    public void set(T obj, T newObj) {
        NodoL<T> nodeObl = get(obj);   // Nodo que contiene el primer objeto buscado
        if (nodeObl != null)
            nodeObl.setValue(newObj);
    }

    protected NodoL<T> get(T o) {
        IteratorList<T> it = (IteratorList<T>) iterator();
        while (it.hasNext()){
            if(it.position.getValue().equals(o))
                return it.position;
            it.next();
        }
        return null;
    }

    protected void add(NodoL<T> n){
        if (isEmpty()) {
            inicio = n;
        }else {
            ultimo.setSiguiente(n);
        }
        ultimo = n;
        size++;
    }

    public void add(T o){
        NodoL<T> n = new NodoL<>(o);
        add(n);
    }

    /**
     * Inserta un nodo nuevoNodo tras el lugar <lugar>
     * @param lugar NodoL tras el que insertar el nodo
     * @param nuevoNodo ModoL a insertar
     */
    protected void insert(NodoL<T> lugar, NodoL<T> nuevoNodo){
        nuevoNodo.setSiguiente(lugar.getSiguiente());
        lugar.setSiguiente(nuevoNodo);
        if (lugar.equals(ultimo))
            ultimo = nuevoNodo;
        size++;
    }

    public void insert (T lugar, T obj){
        NodoL<T> n = new NodoL<>(obj);
        NodoL<T> l = get(lugar);
        if (l != null)  // El nodo existe
            insert( l, n);
    }

    /**
     * Inserta un NodoL al principio de la Lista
     * @param n NodoL
     */
    protected void insert(NodoL<T> n){
        n.setSiguiente(inicio);
        if (isEmpty()) {
            ultimo = n;
        }
        inicio = n;
        size++;
    }

    public void insert(T obj){
        NodoL<T> n = new NodoL<>(obj);
        insert(n);
    }


    @Override
    public String toString() {
        String output = "";
        IteratorList it = (IteratorList) iterator();
        while (it.hasNext()){
            output += "(" + it.next() + ")";
        }
        return output;
    }

    @Override
    public  Iterator iterator() {
        return new IteratorList<T>(this);
    }


    public static void main(String[] args) {
        // ========== Creación de una lista enlazada ============
        LinkedList<String> l = new LinkedList<>("nodo 0");
        l.add("nodo 1");
        l.add("nodo 2");
        //----------- Inserción de un elemento ------------------
        l.insert("nodo 1","nodo 15");
        l.insert("nodo -1");

        System.out.println("Lista enlazada l: => " + l);

        // ---------- Recorrido con un iterador
        System.out.println("Recorrido de la lista l con un iterador:");
        System.out.println(l);
        Iterator itr = l.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        // ---------- Creación de una lista enlazada vacía ---------
        // ---------- Comprobación del método isEmpty() ------------
        LinkedList<String> l2 = new LinkedList<>();
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        l2.add("Nodo 1 de l2");
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        // ------------ Busqueda de elementos ---------------
        System.out.println("Índice del elemento <nodo -1>: " + l.seek("nodo -1"));

        System.out.println("Elemento del índice 4: " + l.get(4));

        //------------- Setter de un elemento --------------

        System.out.println("Cambio del nodo <nodo 3>");
        l.set("nodo 3","nodo 00");
        System.out.println(l);

        // ------------ Borrado de un elemento ------------------
        System.out.println(l.deleteFirst());
        System.out.println("Borrado del primer elemento:");
        Iterator itrd = l.iterator();
        while (itrd.hasNext()){
            System.out.println(itrd.next());
        }

        l.delete("nodo 0");
        System.out.println("Borrado del elemento (nodo 0):");
        Iterator itrd2 = l.iterator();
        while (itrd2.hasNext()){
            System.out.println(itrd2.next());
        }
    }

}
