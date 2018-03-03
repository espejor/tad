package tad.nodos;

public class NodoDL<T> extends NodoL<T> {
    private NodoDL<T> anterior;

    public NodoDL(T value) {
        super(value);
        this.anterior = null;
    }


    public NodoDL() {
        super();
        anterior = null;
    }

    public NodoDL(NodoDL<T> n) {
        super(n);
        anterior = n.getAnterior();
    }

    public void setAnterior(NodoDL<T> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoDL<T> siguiente) {
        this.siguiente = siguiente;
    }
//
//    public NodoL<T> getSiguiente (){
//        return  siguiente;
//    }
//
//    public NodoL<T> prev(NodoDL<T> n){
//        return n.getAnterior();
//    }

    public NodoDL<T> getAnterior() {
        return anterior;
    }
}
