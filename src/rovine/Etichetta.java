package rovine;

public class Etichetta {
    private Nodo from;
    private int distanza;

    public Etichetta(Nodo from) {
        this.from = from;
        this.distanza = 0;
    }

    public Etichetta() {
        this.from = null;
        this.distanza = -1;
    }
}
