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
        return this.id==o.hashCode();
    }

    @Override
    public int hashCode(){
        return this.id;
    }
}
