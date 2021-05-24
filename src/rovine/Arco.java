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
        return (int) Math.sqrt((Math.pow(nodoPartenza.getX()-nodoArrivo.getX(),2))+(Math.pow(nodoPartenza.getY()-nodoArrivo.getY(),2)));
    }

    public int distanzaH(){
        return Math.abs(nodoPartenza.getH()-nodoArrivo.getH());
    }

    @Override
    public boolean equals(Object o){
        return this.toString()==o.toString();
    }

    @Override
    public String toString(){
        return this.nodoArrivo.getId()+"-"+this.nodoPartenza.getId();
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
