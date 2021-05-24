package rovine;

public class Etichetta {
    private Nodo from;
    private double distanza;
    private int numeroCitta;

    public Etichetta(Nodo from, double distanza, int numeroCitta) {
        this.from = from;
        this.distanza = distanza;
        this.numeroCitta = numeroCitta;
    }

    public Nodo getFrom() {
        return from;
    }

    public void setFrom(Nodo from) {
        this.from = from;
    }

    public double getDistanza() {
        return distanza;
    }

    public void setDistanza(int distanza) {
        this.distanza = distanza;
    }

    public int getNumeroCitta() {
        return numeroCitta;
    }

    public void setNumeroCitta(int numeroCitta) {
        this.numeroCitta = numeroCitta;
    }
}
