package rovine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cartina {
    Map<Arco,Double[]> mappaTerritorio;

    public Cartina(Map<Arco, Double[]> mappaTerritorio) {
        this.mappaTerritorio = mappaTerritorio;
    }
    public void generaPercorsoOttimale(ArrayList<Nodo> insiemeNodi, Map<Integer, ArrayList<Integer>> mappaArchi){
        /*
        * -1. Si crea un insieme Q contenente tutti i nodi da visitare: inizialmente, tutti i nodi del grafo
        * 2. Si crea una tabella contenente, per ogni nodo del grafo, la distanza minima calcolata dal nodo origine (inizialmente posta a infinito)
        * e il nodo precedente nel cammino minimo (inizialmente sconosciuto).
        * Si itera su tutti i nodi in Q, prendendo di volta in volta il nodo T che, rispetto agli altri nodi di Q, ha distanza minore
        * dall’origine. La precedenza è importantissima per il principio di ottimalità
        * 4. Per ogni vicino (neighbour) N del nodo T:
        * a. si calcola la distanza calc_dist = distanza(origine, T) + peso(T, N)
        * b. se calc_dist è minore della distanza presente in tabella per il nodo N, allora nella riga N della tabella si scrivono
        * calc_dist come distanza e T come nodo precedente
        * 5. Terminata l’iterazione, T viene rimosso da Q.
        * Quando Q è vuoto l’algoritmo termina.
        */
        Map<Nodo, Etichetta> mappaV1=new HashMap<>();
        Map<Nodo, Etichetta> mappaV2=new HashMap<>();
        for (Nodo n: insiemeNodi) {
            if(n.getId()==0){
                mappaV1.put(n,new Etichetta(n,0,0));

            }
            else mappaV1.put(n,null);
        }
        for(int i=0; i<insiemeNodi.size(); i++){
            Nodo n1 = new Nodo(i);
            for(int j : mappaArchi.get(i)){
                Nodo n2 = new Nodo(j);
                double carburanteDaBaseaN2 = mappaTerritorio.get(new Arco(n1,n2))[0]+mappaV1.get(n1).getDistanza();
                if(mappaV1.get(n2)==null){
                    mappaV1.put(n2,new Etichetta(n1, carburanteDaBaseaN2, mappaV1.get(n1).getNumeroCitta()+1));
                }else if(mappaV1.get(n2).getDistanza()!=carburanteDaBaseaN2){
                    /*
                    * imposto un etichetta in  base a quale consuma meno*/
                }else{
                    if(mappaV1.get(n1).getNumeroCitta()!=mappaV1.get(n2).getNumeroCitta()){
                        /*
                         * imposto un etichetta in  base a qunte citta passo*/
                    }else{
                        if(i>j) ;
                        else ;
                    }
                }
                if(mappaV2.get(n2)==null){
                    mappaV2.put(n2,new Etichetta(n1, mappaTerritorio.get(new Arco(n1,n2))[1], mappaV1.get(n1).getNumeroCitta()+1));
                }
            }
        }
    }
}
