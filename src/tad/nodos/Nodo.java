package tad.nodos;


/**
 * Clase que modela un Nodo para ser aplicado en tipos Abstractos de datos
 */
public abstract class Nodo <T>{
    private  T value;

    /**
     * Setter de value
     *
     * @param value del tipo T
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Constructor sin parámetros. Crea un Nodo sin valor
     */
    Nodo(){
        value =null;
    }

    /**
     * Constructor que inicializa el valor del nodo
     * @param value Object
     */
    Nodo(T value) {
        this.value = value;
    }

    /**
     * Constructor de copia
     * @param n Nodo a copiar
     */
    public Nodo (Nodo<T> n){
        value = n.value;
    }

    /**
     * Getter del valor del nodo
     * @return Object
     */
    public T getValue() {
        return value;
    }




    @Override
    public String toString() {
        return "(" + value + ")";
    }
}


