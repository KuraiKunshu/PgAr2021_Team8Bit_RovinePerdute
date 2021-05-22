package rovine;

public class Arco {
    private Nodo nodoPartenza;
    private Nodo nodoArrivo;

    public Arco(Nodo nodoPartenza, Nodo nodoArrivo) {
        this.nodoPartenza = nodoPartenza;
        this.nodoArrivo = nodoArrivo;
    }

    public Nodo getNodoPartenza() {
        return nodoPartenza;
    }

    public void setNodoPartenza(Nodo nodoPartenza) {
        this.nodoPartenza = nodoPartenza;
    }

    public Nodo getNodoArrivo() {
        return nodoArrivo;
    }

    public void setNodoArrivo(Nodo nodoArrivo) {
        this.nodoArrivo = nodoArrivo;
    }

    public int distanzaXY(){
        return 0;
    }

    public int distanzaH(){
        return 0;
    }

    @Override
    public boolean equals(Object o){
        return this.toString()==o.toString();
    }

    @Override
    public String toString(){
        return this.nodoArrivo.getName()+this.nodoPartenza.getName();
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
