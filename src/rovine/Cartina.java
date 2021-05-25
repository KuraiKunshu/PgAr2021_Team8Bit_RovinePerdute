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
        Map<Nodo, Etichetta> mappaV1=new HashMap<>();
        Map<Nodo, Etichetta> mappaV2=new HashMap<>();
        for (Nodo n: insiemeNodi) {
            if(n.getId()==0){
                mappaV1.put(n,new Etichetta(n,0,0));
                mappaV2.put(n,new Etichetta(n,0,0));
            }
            else{
                mappaV1.put(n,null);
                mappaV2.put(n,null);
            }
        }
        for(int i=0; i<insiemeNodi.size(); i++){
            Nodo n1 = new Nodo(i);
            for(int j : mappaArchi.get(i)){
                Nodo n2 = new Nodo(j);
                //v1
                double carburanteDaBaseaN2V1 = mappaTerritorio.get(new Arco(n1,n2))[0]+mappaV1.get(n1).getDistanza();
                assegnazioneMetodo(mappaV1, i, n1, j, n2, carburanteDaBaseaN2V1, insiemeNodi);
                //v2
                double carburanteDaBaseaN2V2 = mappaTerritorio.get(new Arco(n1,n2))[1]+mappaV2.get(n1).getDistanza();
                assegnazioneMetodo(mappaV2, i, n1, j, n2, carburanteDaBaseaN2V2, insiemeNodi);
            }
        }

        ArrayList<Nodo> listaVeicolo1 = new ArrayList<>();
        ArrayList<Nodo> listaVeicolo2 = new ArrayList<>();
        Nodo n = insiemeNodi.get(insiemeNodi.size()-1);
        double carburanteVeicolo1=mappaV1.get(n).getDistanza();
        double carburanteVeicolo2=mappaV2.get(n).getDistanza();
        while(n.getId()==0){
            listaVeicolo1.add(n);
            n=mappaV1.get(n).getFrom();
        }
        n = insiemeNodi.get(insiemeNodi.size()-1);
        while(n.getId()==0){
            listaVeicolo2.add(n);
            n=mappaV2.get(n).getFrom();
        }
    }

    private void assegnazioneMetodo(Map<Nodo, Etichetta> mappa, int i, Nodo n1, int j, Nodo n2, double carburanteDaBaseaN2, ArrayList<Nodo> insiemeNodi) {
        if(mappa.get(n2)==null){
            mappa.put(n2,new Etichetta(insiemeNodi.get(i), carburanteDaBaseaN2, mappa.get(n1).getNumeroCitta()+1));
        }else if(mappa.get(n2).getDistanza()!=carburanteDaBaseaN2){
            if(mappa.get(n2).getDistanza()>carburanteDaBaseaN2){
                mappa.put(n2,new Etichetta(insiemeNodi.get(i), carburanteDaBaseaN2, mappa.get(n1).getNumeroCitta()+1));
            }
        }else{
            if(mappa.get(n1).getNumeroCitta()!=mappa.get(n2).getNumeroCitta()){
                if(mappa.get(n2).getNumeroCitta()>mappa.get(n1).getNumeroCitta()+1){
                    mappa.put(n2,new Etichetta(insiemeNodi.get(i), carburanteDaBaseaN2, mappa.get(n1).getNumeroCitta()+1));
                }
            }else{
                if(i>j) mappa.put(n2,new Etichetta(insiemeNodi.get(i), carburanteDaBaseaN2, mappa.get(n1).getNumeroCitta()+1));
            }
        }
    }
}
