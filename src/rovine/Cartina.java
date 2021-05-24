package rovine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cartina {
    Map<Arco,Integer[]> mappaTerritorio;

    public Cartina(Map<Arco, Integer[]> mappaTerritorio) {
        this.mappaTerritorio = mappaTerritorio;
    }
    public void generaPercorsoOttimale(ArrayList<Nodo> insiemeNodi){
        Map<Nodo, Etichetta> mappa=new HashMap<>();
        //genero una mappa di nodi dati n nodi
        //per ogni nodo genero un etichetta con distanza e il nodo precedente
        for (Nodo n: insiemeNodi) {
            if(n.getId()==0)mappa.put(n,new Etichetta(n));
            else mappa.put(n,new Etichetta());
        }
    }
}
