package tad.nodos;

class Arista {
    private Nodo inicio;
    private Nodo fin;

    public Arista(Nodo inicio, Nodo fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
}
