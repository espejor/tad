package tad.nodos;

public class NodoArbolAVL<T extends Comparable> extends NodoArbol<T>{

    int altura;

    public NodoArbolAVL(T value) {
        this(value,null,null);
    }

    public NodoArbolAVL(T value, NodoArbol<T> left, NodoArbol<T> rigth) {
        super(value, left, rigth);
        this.altura = 0;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
