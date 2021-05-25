package rovine;

public class Nodo {
    private String name;
    private int id;
    private int x;
    private int y;
    private int h;

    public Nodo(String name, int id, int x, int y, int h) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public Nodo(int id){
        this.id=id;
        this.name="";
        this.x=0;
        this.y=0;
        this.h=0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o){
        return this.hashCode()==o.hashCode();
    }

    @Override
    public int hashCode(){
        return this.id;
    }

    public double distanzaNelPianoXY(Nodo nodoArrivo){
        double differenzaX = this.getX() - nodoArrivo.getX();
        double differenzaY = this.getY() - nodoArrivo.getY();
        double distanza = Math.sqrt((differenzaX * differenzaX) + (differenzaY * differenzaY));
        return distanza;
    }

    public double differenzaAltezze(Nodo nodoArrivo){
        return Math.abs(this.getH() - nodoArrivo.getH());
    }
}
