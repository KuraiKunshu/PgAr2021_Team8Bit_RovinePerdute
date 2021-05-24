package rovine;

public class Main {
    public static void main(String[] args) {
        Nodo a= new Nodo("abc",43,432,123,45);
        Nodo b= new Nodo("abc",44,432,123,45);
        Arco ar=new Arco(a,b);
        System.out.println(ar.toString());
    }
}
