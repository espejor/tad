package tad;

import tad.cola.Queue;
import tad.cola.QueueArrayList;
import tad.lista.DoubleLinkedList;
import tad.lista.IteratorDoubleList;
import tad.lista.IteratorList;
import tad.lista.LinkedList;
import tad.pila.Stack;
import tad.pila.StackArrayList;

import java.util.Iterator;

class Prueba{
    public static void main(String[] args) {
        // ========== Creación de una lista enlazada ============
        LinkedList<String> l = new LinkedList("nodo 0");
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
        LinkedList l2 = new LinkedList();
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        l2.add("Nodo 1 de l2");
        System.out.println("Lista enlazada l2: => " + l2);
        System.out.println("l2 ¿está vacía?: => " + l2.isEmpty());

        // ------------ Busqueda de elementos ---------------
        System.out.println("Índice del elemento <Nodo 15>: " + l.seek("Nodo 15"));

        // ------------ Borrado de un elemento ------------------
        l.deleteFirst();
        System.out.println("Borrado del primer elemento:");
        Iterator itrd = l.iterator();
        while (itrd.hasNext()){
            System.out.println(itrd.next());
        }

        l.delete("nodo 2");
        System.out.println("Borrado del elemento (Nodo 15):");
        Iterator itrd2 = l.iterator();
        while (itrd2.hasNext()){
            System.out.println(itrd2.next());
        }
        // =========== Creación de una lista doblemente enlazada ==============
        // Introducción de elementos y comprobación del tamaño de la lista
        DoubleLinkedList dll = new DoubleLinkedList(100);
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

        dll.insert(300,250);
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

        // =========== Creación de una Pila implementada con una lista enlazada =============
        Stack pila = new Stack();

        pila.push("Apilado 1");
        pila.push("Apilado 2");
        pila.push("Nodo 3");
        pila.push("Nodo 4");


        System.out.println("Pila p => " + pila);

        // ---------- Desapilamos un elemento
        System.out.println("Desapilamos el elemento " + pila.pop());
        System.out.println("Pila p => " + pila);

        // Creación de una Pila con arrayList
        StackArrayList<String> saL = new StackArrayList<>();
        saL.push("Pila ArrayList Elemento 1");
        saL.push("Pila ArrayList Elemento 2");
        saL.push("Pila ArrayList Elemento 3");
        saL.push("Pila ArrayList Elemento 4");
        System.out.println("Pila ArrayList => " + saL);

        // Desencolamos un elemento
        System.out.println("Desapilamos el elemento " + saL.pop());
        System.out.println("Pila ArrayList => " + saL);


        // =========== Creación de una Cola implementada con una lista enlazada =============
        Queue q = new Queue();
        q.enqueue("Encolado 1");
        q.enqueue("Encolado 2");
        q.enqueue("Encolado 3");
        q.enqueue("Encolado 4");
        System.out.println("Cola q => " + q);



        // Desencolamos un elemento
        System.out.println("Desencolamos el elemento " + q.dequeue());
        System.out.println("Cola q => " + q);

        // Creación de una Cola con arrayList
        QueueArrayList<String> qaL = new QueueArrayList<>();
        qaL.enqueue("Cola ArrayList Elemento 1");
        qaL.enqueue("Cola ArrayList Elemento 2");
        qaL.enqueue("Cola ArrayList Elemento 3");
        qaL.enqueue("Cola ArrayList Elemento 4");
        System.out.println("Cola ArrayList => " + qaL);

        // Desencolamos un elemento
        System.out.println("Desencolamos el elemento " + qaL.dequeue());
        System.out.println("Cola ArrayList => " + qaL);

    }
}


