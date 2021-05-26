package rovine;

public class Arco {
    private Nodo nodoPartenza;
    private Nodo nodoArrivo;

    public Arco(Nodo nodoPartenza, Nodo nodoArrivo) {
        this.nodoPartenza = nodoPartenza;
        this.nodoArrivo = nodoArrivo;
    }

    /**
     * confronta 2 oggetti se sono in base la
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString(){
        return this.nodoPartenza.getId()+"-"+this.nodoArrivo.getId();
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
