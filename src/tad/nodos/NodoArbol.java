package tad.nodos;

import java.util.GregorianCalendar;

public class NodoArbol<T extends Comparable> implements Comparable<NodoArbol<T>>{
    // Implementamos la interfaz Comparable para comparar los nodos y no los values
    private NodoArbol<T> left, right;
    private T value;
    private NodoArbol<T> parent;


    public NodoArbol(T value) {
        this(value,null,null);
    }

    public NodoArbol(T value, NodoArbol<T> left, NodoArbol<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    /**
     * Getter de parent
     *
     * @return parent
     */
    public NodoArbol<T> getParent() {
        return parent;
    }

    /**
     * Setter de parent
     *
     * @param parent del tipo tad.nodos.NodoArbol
     */
    public void setParent(NodoArbol<T> parent) {
        this.parent = parent;
    }

    /**
     * Setter de value
     *
     * @param value del tipo java.lang.Comparable
     */
    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setLeft(NodoArbol<T> left) {
        this.left = left;
        if (left != null)
            left.setParent(this);
    }

    public void setRight(NodoArbol<T> right) {
        this.right = right;
        if (right != null)
            right.setParent(this);
    }

    public NodoArbol<T> getLeft() {
        return left;
    }

    public NodoArbol<T> getRight() {
        return right;
    }
//
//    public void insert(NodoArbol newNode){
//        Comparable valueRootNode =  this.value;
//        Comparable valueNewNode =  newNode.value;
//        if (valueRootNode.compareTo(valueNewNode) == 1){
//            left = newNode;
//        }else {
//            right = newNode;
//        }
//    }
//
    public boolean esNodoHoja(){
        return this.right == null && left == null;
    }

    @Override
    public String toString() {
        if (this.value.getClass().getSimpleName().equals("GregorianCalendar")){
            return ((GregorianCalendar)(this.value)).getTime().toString();
        }
        return value.toString();
    }
//
//    @Override
//    public int compareTo(Object o) {
//        return  (this.value.compareTo(((NodoArbol)o).value));
//    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        return  (this.getValue().compareTo(o.getValue()));
    }
}
