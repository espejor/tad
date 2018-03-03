package tad.lista;

import tad.nodos.NodoDL;
import tad.nodos.NodoL;

import java.util.Iterator;

/**
 * Lista enlazada doble. Implementa las interfaces Iterable y List
 * @param <T> Tipo genérico
 */
public class DoubleLinkedList <T> extends LinkedList<T> {
    public DoubleLinkedList(T o) {
        NodoL<T> n = new NodoDL<>(o);
        add(n);
    }

    // -------------- Constructores ----------------------

    public DoubleLinkedList() {
        super();
    }

    public void add(T obj){
        NodoDL<T> n = new NodoDL<>(obj);
        n.setAnterior((NodoDL<T>) ultimo);
        add(n);

    }

    // ---------------- Métodos insert ----------------------

    @Override
    public void insert(T obj){
        NodoDL<T> n = new NodoDL<>(obj); // Si se declarara como NodoL, insert(n) llamaría al método de la superclase
        insert(n);
    }

    /**
     * Inserta un NodoDL al principio de la Lista
     * @param n NodoDL
     */
    private void insert(NodoDL<T> n){
        ((NodoDL<T>)inicio).setAnterior(n);
        super.insert(n);    // Hay que llamar explícitamente al super porque si no haría una llamada recursiva
    }


    @Override
    public void insert (T lugar, T obj){
        NodoDL<T> n = new NodoDL<>(obj);
        NodoDL<T> l = (NodoDL<T>) get(lugar); // Método de la superclase
        if (l != null)      // Encuentra el nodo previo donde insertar
            insert( l, n);
    }


    /**
     * Inserta un nodo nuevoNodo en el lugar <lugar>
     * @param lugar NodoL tras el que insertar el nodo
     * @param nuevoNodo ModoL a insertar
     */
    protected void insert(NodoDL<T> lugar, NodoDL<T> nuevoNodo){
        super.insert(lugar,nuevoNodo);
        nuevoNodo.setAnterior(((NodoDL<T>)(nuevoNodo.getSiguiente())).getAnterior());
        ((NodoDL<T>)(nuevoNodo.getSiguiente())).setAnterior(nuevoNodo);
    }

    // ------------------- Método delete -------------------
    @Override
    public boolean delete(T o) {
        // Si queremos borrar el primer elemento
        if (inicio.getValue().equals(o)){
            return deleteFirst() != null;
        }
        NodoDL<T> previous =  previous(o); // Método previous de la subclase
        if (previous != null) { // Existe el objeto a borrar
            NodoDL<T> nodeToDelete = (NodoDL<T>) previous.getSiguiente();
            if (nodeToDelete != null) { // El nodo anterior no es el último
                previous.setSiguiente(nodeToDelete.getSiguiente());
                ((NodoDL<T>)nodeToDelete.getSiguiente()).setAnterior(previous);
                size--;
                return true;
            }
        }
        return false;
    }


    private NodoDL<T> previous (T o){
        NodoDL<T> n = (NodoDL<T>) get(o); // Método de la superclase
        if (n != null)  // Si encuentra el dato o
            return n.getAnterior();     // Devuelve el anterior
        return null;        // Si no encuentra el objeto value devuelve null
    }

    // ================== Iteradores =============================
    @Override
    public  Iterator iterator() {
        return new IteratorList<>(this);
    }
    public  Iterator doubleIterator() {
        return new IteratorDoubleList<>(this);
    }

    // ===================================================================
    // ------------------------------ MAIN -------------------------------
    // ===================================================================

    public static void main(String[] args) {
        // ========== Creación de una lista enlazada ============
        DoubleLinkedList<String> l = new DoubleLinkedList<>("nodo 0");
        l.add("nodo 1");
        l.add("nodo 2");
        //----------- Inserción de un elemento ------------------
        l.insert("nodo 1","nodo 15");
        l.insert("nodo -1");

        System.out.println("Lista enlazada l: => " + l);

        // ---------- Recorrido con un iterador
        System.out.println("Recorrido de la lista l con un iterador:");
        Iterator itr = l.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        // ---------- Creación de una lista enlazada vacía ---------
        // ---------- Comprobación del método isEmpty() ------------
        DoubleLinkedList<String> l2 = new DoubleLinkedList<>();
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        l2.add("Nodo 1 de l2");
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        // ------------ Busqueda de elementos ---------------
        System.out.println("Indice del elemento <Nodo 15>: " + l.seek("Nodo 15"));

        //------------- Setter de un elemento --------------

        System.out.println("Cambio del nodo <nodo 2>");
        l.set("nodo 2","nodo 00");
        System.out.println(l);

        // ------------ Borrado de un elemento ------------------
        l.deleteFirst();
        System.out.println("Borrado del primer elemento:");
        Iterator itrd = l.iterator();
        while (itrd.hasNext()){
            System.out.println(itrd.next());
        }

        l.delete("nodo 15");
        System.out.println("Borrado del elemento (Nodo 15):");
        Iterator itrd2 = l.iterator();
        while (itrd2.hasNext()){
            System.out.println(itrd2.next());
        }
        // =========== Creación de una lista doblemente enlazada ==============
        // Introducción de elementos y comprobación del tamaño de la lista
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>(100);
        System.out.println("Lista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());
        dll.add(200);
        System.out.println("Lista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());
        dll.add(300);
        System.out.println("Lista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());
        dll.add(400);
        System.out.println("Lista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());
        dll.add(500);
        System.out.println("Lista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());

        dll.insert(0);
        System.out.println("Insertado elemento 0\nLista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());

        dll.insert(200,250);
        System.out.println("Insertado elemento 250\nLista doblemente enlazada dll: => " + dll);
        System.out.println("De tamaño: " + dll.size());


        // ------- Prueba de iteradores directos e inversos
        IteratorDoubleList itr2 = (IteratorDoubleList) dll.doubleIterator();
        IteratorList itr3 = (IteratorList) dll.iterator();

        System.out.println("Prueba iterador directo");
        while (itr3.hasNext()){
            System.out.println(itr3.next());
        }
        System.out.println("Prueba iterador inverso");
        while (itr2.hasPrevious()){
            System.out.println(itr2.previous());
        }

    }
}
