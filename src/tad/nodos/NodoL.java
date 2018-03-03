package tad.nodos;

/**
 * Nodo de una Lista enlazada. Extiende de {@link tad.nodos.Nodo}
 */
public class NodoL <T> extends Nodo<T> {
    /**
     * Apunta al siguiente node de la lista
     */
    NodoL<T> siguiente;

    /**
     * Constructor que recibe un valor a almacenar en el nodo
     * @param value Object
     */
    public NodoL(T value) {
        super(value);
        this.siguiente = null;
    }

    /**
     * Constructor sin parámetros
     */
    public NodoL(){
        super();
        siguiente = null;
    }

    /**
     * Constructor de copia
     * @param n NodoL
     */
    NodoL(NodoL<T> n){
        super(n);
        siguiente = n.getSiguiente();
    }

    /**
     * Devuelve el siguiente NodoL de la lista enlazada
     * @return NodoL
     */
    public NodoL<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece cuál es el siguiente Nodo de la lista
      * @param siguiente NodoL
     */
    public void setSiguiente(NodoL<T> siguiente) {
        this.siguiente = siguiente;
    }
}
