package tad.arbol;


import fecha.Fecha;
import tad.nodos.NodoArbol;
import tad.nodos.NodoArbolAVL;
//import tad.nodos.NodoArbolAVL;

/**
 * Estructura de datos Arbol Binario implementada con nodos de tipo NodoArbol
 */
public class ArbolB<T extends Comparable>  {
    /**
     * Atributo que apunta a la raiz del árbol
     */
    private NodoArbol<T> root;

    /**
     * Getter de la raiz del árbol
     * @return La raiz del árbol
     */
    protected NodoArbol<T> getRoot() {
        return root;
    }

    /**
     * Setter de la raiz del árbol
     * @param root Nodo que pasa a ser la raiz de árbol
     */
    protected void setRoot(NodoArbol<T> root) {
        this.root = root;
    }

    /**
     * Comprueba si el árbol está vacío
     * @return boolean true si el árbol está vacío
     */
    public boolean isEmpty(){
        return root == null;
    }

    // ------------------- INSERT -------------------------
    /**
     * Inserta un Valor de tipo {@link Comparable} en el árbol
     * @param value Valor a insertar en el árbol de tipo {@link Comparable}
     */
    public void insert(T value){
        NodoArbol<T> nodo = new NodoArbol<T>(value);
        insert(nodo);
    }


    /**
     * Inserta un {@link NodoArbol}
     * @param nodo Nodo a insertar
     */
    private void insert(NodoArbol<T> nodo){
        root = insert(nodo,root);
    }


    /**
     * Inserta un {@link NodoArbol} en un subárbol subRoot de forma recursiva. No se admiten valores repetidos
     * @param nodo Nodo a insertar
     * @param subRoot subárbol donde insertar el nodo
     * @return Nodo raiz del subárbol donde se ha insertado el nodo
     */
    private NodoArbol<T> insert (NodoArbol<T> nodo, NodoArbol<T> subRoot){
        // SubArbol vacío
        if (subRoot == null){
            return nodo;
        }else{
            if (nodo.compareTo(subRoot) < 0){   // hay que insertarlo en la rama izquierda
                subRoot.setLeft(insert(nodo,subRoot.getLeft()));
            }
            if (nodo.compareTo(subRoot) > 0){   // hay que insertarlo en la rama derecha
               subRoot.setRight(insert(nodo,subRoot.getRight()));
            }
            return subRoot;
        }
    }

    private boolean existLeftNode(NodoArbol<T> nodo){
        return nodo.getLeft() != null;
    }


    private boolean existRightNode(NodoArbol<T> nodo){
        return nodo.getRight() != null;
    }

    /**
     * Busca el valor mínimo en todo el árbol
     * @return Valor mínimo del árbol de tipo Comparable
     */
    private T findMin(){
        return value(findMin (root));
    }


    /**
     * Busca el valor máximo en todo el árbol
     * @return Valór máximo del árbol de tipo Comparable
     */
    private T findMax(){
        return value(findMax (root));
    }

    /**
     * Devuelve el valor almacenado en un nodo
     * @param nodo Nodo que almacena el valor
     * @return Valor almacenado. Null en caso de nodo nulo
     */
    private T value(NodoArbol<T> nodo){
        return nodo == null ? null : nodo.getValue();
    }

    /**
     * Busca el Nodo con el valor mínimo dentro de un subárbol
     * @param subRoot Nodo raiz del subárbol
     * @return Nodo con valor mínimo del subárbol
     */
    private NodoArbol<T> findMin(NodoArbol<T> subRoot){
        if (subRoot == null)
            return null;
        if (existLeftNode(subRoot))
            return findMin(subRoot.getLeft());
        else
            return subRoot;
    }


    /**
     * Busca el Nodo con el valor máximo dentro de un subárbol
     * @param subRoot Nodo raiz del subárbol
     * @return Nodo con valor máximo del subárbol
     */
    private NodoArbol<T> findMax(NodoArbol<T> subRoot){
        if (subRoot == null)
            return null;
        else
        if (existRightNode(subRoot))
            return findMax(subRoot.getRight());
        else
            return subRoot;
    }

    /**
     * Busca un valor en el árbol
     * @param value Comparable a buscar
     * @return Si lo encuentra o no
     */
    public boolean contains(T value) {
        return contains(new NodoArbol<T>(value), root) != null;
    }

    public T retrieve(T value){
        NodoArbol<T> n = contains(new NodoArbol<T>(value), root);
        if (n != null)
            return n.getValue();
        return null;
    }

    /**
     * Busca un nodo en un subárbol
     * @param nodo Nodo a buscar
     * @param subRoot nodo raiz del subárbol donde buscar
     * @return Nodo encontrado o null
     */
    private NodoArbol<T> contains(NodoArbol<T> nodo, NodoArbol<T> subRoot )
    {
        //NodoArbol<T> result = subRoot;// Caso base => coincide con el nodo padre

        if (subRoot == null)
            return null; // No match
        else {
            if (nodo.compareTo(subRoot) < 0)
                return contains(nodo, subRoot.getLeft());
            if (nodo.compareTo(subRoot) > 0)
                return contains(nodo, subRoot.getRight());
        }
        // Es igual. ¡¡¡MATCH!!!
        return subRoot;
    }


    private NodoArbol<T> findNode(T value) {
        return contains(new NodoArbol<T>(value), root );
    }


    public boolean remove (T value){
        return removeNodo(findNode(value));
    }

    protected boolean removeNodo( NodoArbol<T> nodo ) {
        if (nodo == null)
            return false;

    /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = existRightNode(nodo);
        boolean tieneNodoIzquierda = existLeftNode(nodo);

    /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */

    /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }

    /* Caso 2: Tiene un hijo derecha y el otro no */
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }

    /* Caso 2: Tiene un hijo y el otro no */
        if ( !tieneNodoDerecha && tieneNodoIzquierda) {
            return removeNodoCaso2( nodo );
        }

    /* Caso 3: Tiene ambos hijos */
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }

        return false;
    }

    private boolean removeNodoCaso1( NodoArbol<T> nodo ) {
    /* lo único que hay que hacer es borrar el nodo y establecer el apuntador de su padre a nulo */

    /*
     * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que
     * eliminar
     */
        NodoArbol<T> hijoIzquierdo = nodo.getParent().getLeft();
        NodoArbol<T> hijoDerecho = nodo.getParent().getRight();

        if ( hijoIzquierdo == nodo ) {
            nodo.getParent().setLeft( null );
            return true;
        }

        if ( hijoDerecho == nodo) {
            nodo.getParent().setRight( null );
            return true;
        }

        return false;
    }

    private boolean removeNodoCaso2( NodoArbol<T> nodo ) {
    /* Borrar el Nodo y el subárbol que tenía pasa a ocupar su lugar */

    /*
     * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que
     * eliminar
     */
        NodoArbol<T> hijoIzquierdo = nodo.getParent().getLeft();
        NodoArbol<T> hijoDerecho = nodo.getParent().getRight();

    /*
     * Buscamos el hijo existente del nodo que queremos eliminar
     */
        NodoArbol<T> hijoActual = existLeftNode(nodo) ?
                nodo.getLeft() : nodo.getRight();

        if ( hijoIzquierdo == nodo ) {
            nodo.getParent().setLeft( hijoActual );

        /* Eliminando todas las referencias hacia el nodo */
            //hijoActual.setParent(nodo.getParent());
            nodo.setRight(null);
            nodo.setLeft(null);

            return true;
        }

        if ( hijoDerecho == nodo) {
            nodo.getParent().setRight( hijoActual );

        /* Eliminando todas las referencias hacia el nodo */
            //hijoActual.setParent(nodo.getParent());
            nodo.setRight(null);
            nodo.setLeft(null);

            return true;
        }

        return false;
    }

    private boolean removeNodoCaso3( NodoArbol<T> nodo ) {
    /* Tomar el hijo derecho del Nodo que queremos eliminar */
        NodoArbol<T> nodoMasALaIzquierda = recorrerIzquierda( nodo.getRight() );
        if ( nodoMasALaIzquierda != null ) {
        /*
         * Reemplazamos el valor del nodo que queremos eliminar por el nodo que encontramos
         */
            nodo.setValue( nodoMasALaIzquierda.getValue() );
        /*
         * Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 )
         */
            removeNodo( nodoMasALaIzquierda );
            return true;
        }
        return false;
    }

    /* Recorrer de forma recursiva hasta encontrar el nodo más a la izquierda */
    private NodoArbol<T> recorrerIzquierda(NodoArbol<T> nodo) {
        if (existLeftNode(nodo)) {
            return recorrerIzquierda( nodo.getLeft() );
        }
        return nodo;
    }


    @Override
    public String toString() {
        if( isEmpty( ) )
            return ( "Empty tree" );
        else
            return printTree( root ,0);
    }


    private String printTree(NodoArbol nodo,int level ) {
        // Imprime el nodo
        String output = printNode(nodo,level);
        if( nodo != null ) {
            if (!nodo.esNodoHoja()) {
                // Recorre las ramas para seguir imprimiendo
                level++;
                output += printTree(nodo.getLeft(), level);
                output += printTree(nodo.getRight(), level);
            }
        }
        return output;
    }

    private String printNode (NodoArbol nodo, int level){
        String output = "";
        for (int i = 1; i < level; i++) {
            output += ("\t");
        }
        if (level > 0)
            output += ("│_\t");
//        else
//            output += ("");
        if (nodo != null)
            output += (nodo + "\n");
        else
            output += "\n";
        return output;
    }


    protected void postOrden(NodoArbol nodo) {
        if (nodo.getLeft()!= null)
            postOrden(nodo.getLeft());
        if (nodo.getRight()!= null)
            postOrden(nodo.getRight());
        System.out.println(nodo);
    }

    protected String inOrden(NodoArbol nodo){
        String output = "";
        if (nodo.getLeft()!= null)
            output += inOrden(nodo.getLeft());
        output += (nodo.toString() + "\n");
        if (nodo.getRight()!= null)
            output += inOrden(nodo.getRight());
        return output;
    }

    protected void preOrden(NodoArbol nodo){
        System.out.println(nodo);
        if (nodo.getLeft()!= null)
            preOrden(nodo.getLeft());
        if (nodo.getRight()!= null)
            preOrden(nodo.getRight());
    }

    //======================== MAIN =================================

    public static void main(String[] args) {

        NodoArbol<Fecha> d1 = new NodoArbol<>(new Fecha(1961,10,5));
        NodoArbol<Fecha> d2 = new NodoArbol<>(new Fecha(1967,6,5));
        NodoArbol<Fecha> d3 = new NodoArbol<>(new Fecha(1961,5,5));
        NodoArbol<Fecha> d4 = new NodoArbol<>(new Fecha(1956,1,5));
        NodoArbol<Fecha> d5 = new NodoArbol<>(new Fecha(1952,6,5));
        NodoArbol<Fecha> d6 = new NodoArbol<>(new Fecha(1987,9,5));
        NodoArbol<Fecha> d7 = new NodoArbol<>(new Fecha(1945,10,5));
        ArbolB<Integer> a = new ArbolB<>();
        ArbolB<Fecha> b = new ArbolB<>();
        ArbolAVL<Integer> c = new ArbolAVL<>();

        a.insert(4);
        a.insert(3);
        a.insert(9);
        a.insert(5);
        a.insert(7);
        a.insert(12);
        a.insert(58);
        a.insert(62);
        a.insert(9);
        a.insert(23);
        a.insert(51);
        a.insert(60);
        a.insert(33);
        a.insert(67);
        a.insert(88);
        a.insert(11);
        a.insert(43);

        System.out.println(a);

        System.out.println(a.contains(88) ? "Encontrado el 12" : "No encontrado el 12");

        a.remove(12);

        System.out.println(a.contains(43) ? "Encontrado el 12" : "No encontrado el 12");

        System.out.println(a);

        System.out.println("Búqueda del elemento 10: " + (a.contains(9)?"encontrado":"No encontrado"));

        b.insert(d1);
        b.insert(d2);
        b.insert(d3);
        b.insert(d4);
        b.insert(d5);
        b.insert(d6);
        b.insert(d7);
        b.insert(new Fecha(1935,10,5));

        c.insert(4);
        c.insert(3);
        c.insert(9);
        c.insert(5);
        c.insert(7);
        c.insert(12);
        c.insert(58);
        c.insert(62);
        c.insert(9);
        c.insert(23);
        c.insert(51);
        c.insert(60);
        c.insert(33);
        c.insert(67);
        c.insert(88);
        c.insert(11);
        c.insert(43);

        System.out.println("a PostOrden:");
        a.postOrden(a.root);
        System.out.println();

        System.out.println("a InOrden:");
        System.out.println(a.inOrden(a.getRoot()));
        System.out.println();

        System.out.println("a PreOrden:");
        a.preOrden(a.root);

        System.out.println("b PostOrden:");
        b.postOrden(b.root);
        System.out.println();
        System.out.println("b InOrden:");
        System.out.println(b.inOrden(b.getRoot()));
        System.out.println();
        System.out.println("b PreOrden:");
        b.preOrden(b.root);

        System.out.println("c PostOrden:");
        c.postOrden(c.getRoot());
        System.out.println();
        System.out.println("c InOrden:");
        System.out.println(c.inOrden(c.getRoot()));
        System.out.println();
        System.out.println("c PreOrden:");
        c.preOrden(c.getRoot());

        System.out.println("Altura de c: " + ((NodoArbolAVL)c.getRoot()).getAltura());

        System.out.println("Mínimo de a: " + a.findMin());
        System.out.println("Máximo de a: " + a.findMax());
        System.out.println("Mínimo de b: " + b.findMin());
        System.out.println("Máximo de b: " + b.findMax().toString());

        System.out.println("¿Encontrado el 52 en a? : " + a.contains(52));

        System.out.println("Arbol a:");
        System.out.println(a);
        System.out.println("Arbol b:");
        System.out.println(b);
        System.out.println("Arbol c:");
        System.out.println(c);


        ArbolB<Integer> a1 = new ArbolB<>();
        ArbolAVL<Integer> a2 = new ArbolAVL<>();

        for (int i = 0; i < 63; i++) {
            a1.insert(i);
            a2.insert(i);
        }

        a2.remove(7);

        System.out.println("ArbolB a1:");
        System.out.println(a1);
        System.out.println("ArbolAVL a2:");
        System.out.println(a2);
    }

}
