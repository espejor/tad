package tad.arbol;

import tad.nodos.NodoArbolAVL;

public class ArbolAVL<T extends Comparable>  extends ArbolB<T> {

    public void insert(T value){
        NodoArbolAVL<T> nodo = new NodoArbolAVL<>(value);
        insert(nodo);
    }

    private void insert(NodoArbolAVL<T> nodo){
        setRoot((insert(nodo,(NodoArbolAVL<T>)getRoot())));
    }

    // El factor de equilibrio es la diferencia entre las alturas del árbol derecho y el izquierdo:
    // FE = altura subárbol derecho - altura subárbol izquierdo
    private int factorDeEquilibrio(NodoArbolAVL<T> subRoot){
        return height((NodoArbolAVL<T>) subRoot.getRight() ) - height((NodoArbolAVL<T>) subRoot.getLeft());
    }

    private NodoArbolAVL<T> insert (NodoArbolAVL<T> nodo, NodoArbolAVL<T> subRoot){
        if (subRoot == null){
            return nodo;
        }else{
            if (nodo.compareTo(subRoot) < 0){
                //nodo.setParent(subRoot);
                subRoot.setLeft(insert(nodo,(NodoArbolAVL<T>) subRoot.getLeft()));
                if(factorDeEquilibrio(subRoot) == -2)   // SubArbol izquierdo es más alto y está desequilibrado
                    if(nodo.compareTo(subRoot.getLeft()) < 0 )
                        subRoot = rotateWithLeftChild(subRoot);
                    else                                        // Se insertó a la derecha
                        subRoot = doubleWithLeftChild(subRoot);
            }
            if (nodo.compareTo(subRoot) > 0){
                //nodo.setParent(subRoot);
                subRoot.setRight(insert(nodo,(NodoArbolAVL<T>)subRoot.getRight()));
                if(factorDeEquilibrio(subRoot) == 2 )   // SubArbol derecho es más alto y está desequilibrado
                    if(nodo.compareTo(subRoot.getRight()) > 0 ) // Se insertó a la derecha
                        subRoot = rotateWithRightChild(subRoot);
                    else
                        subRoot = doubleWithRightChild(subRoot);
            }
            updateHeight(subRoot);
            return subRoot;
        }
    }

    private void updateHeight(NodoArbolAVL<T> subRoot){
        subRoot.setAltura(max( height((NodoArbolAVL<T>) subRoot.getLeft()), height((NodoArbolAVL<T>) subRoot.getRight()) ) + 1);
    }

    private  NodoArbolAVL<T> rotateWithLeftChild( NodoArbolAVL<T> k2 ) {
        NodoArbolAVL<T> k1 = (NodoArbolAVL<T>)k2.getLeft();
        //k1.setParent(k2.getParent());
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        updateHeight(k2);
        updateHeight(k1);
        return k1;
    }

    private  NodoArbolAVL<T> rotateWithRightChild( NodoArbolAVL<T> k2 ) {
        NodoArbolAVL<T> k1 = (NodoArbolAVL<T>)k2.getRight();
        //k1.setParent(k2.getParent());
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
        updateHeight(k2);
        updateHeight(k1);
        return k1;
    }

    private  NodoArbolAVL<T> doubleWithLeftChild( NodoArbolAVL<T> k3 ) {
        k3.setLeft(rotateWithRightChild((NodoArbolAVL<T>) k3.getLeft()));
        return rotateWithLeftChild( k3 );
    }

    private  NodoArbolAVL<T> doubleWithRightChild( NodoArbolAVL<T> k3 ) {
        k3.setRight(rotateWithLeftChild((NodoArbolAVL<T>) k3.getRight()));
        return rotateWithRightChild( k3 );
    }

    private  int max( int lhs, int rhs ) {
        return lhs > rhs ? lhs : rhs;
    }
    private  int height(NodoArbolAVL<T> t ){
        return t == null ? -1 : t.getAltura();
    }
}
