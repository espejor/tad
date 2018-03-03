package tad.lista;

/**
 * Interface que establece los métodos que deben cumplimentar las colecciones en forma de Lista
 * @param <T> Tipo de los elementos de la colección
 */
public interface List <T>  {
    /**
     * Devuelve el número de elementos de la Lista
     * @return Número de elementos de la Lista
     */
    int size();

    /**
     * Devuelve si la Lista está vacía
     * @return Devuelve si la Lista está vacía
     */
    boolean isEmpty();

    /**
     * Agrega un elemento del tipo T al final de la Lista
     * @param o Elemento del tipo T a agregar
     */
    void add(T o);

    /**
     * Inserta un elemento de tipo T al principio de la Lista
     * @param obj Elemento del tipo T a agregar
     */
    void insert(T obj);

    /**
     * Inserta un elemento de tipo T tras el elemento "lugar"
     * @param lugar Elemento tras el cual se inserta el nuevo elemento
     * @param obj Elemento del tipo T a agregar
     */
    void insert (T lugar, T obj);

    /**
     * Elimina e primer elemento de la lista y lo devuelve
     */
    T deleteFirst();

    /**
     * Elimina la primera ocurrencia del elemento o de Tipo T y lo devuelve
     * @param o Elemento a eliminar
     */
    boolean delete (T o);

    /**
     * Busca un elemento de Tipo y devuelve el índice en que se encuentra en la lista
     * @param o Elemento a buscar
     * @return Indice donde se encuentra el elemento biscado. Devuelve -1 si no lo encuentra
     */
    int seek(T o);

    /**
     * Devuelve true si la Lista contiene el elemento o de tipo T
     * @param o Elemento que se busca
     * @return True si contiene al elemento o
     */
    boolean contains(T o);

    /**
     * Devuelve el elemento de la Lista que se encuentra en la posición del índice. Null en caso de no encontrar
     * al elemento
     * @param i Indice del elemento a devolver
     * @return Elemento que se encuentra en la posición del índice i
     */
    T get(int i);

    void set(T obj,T newObj);
}
