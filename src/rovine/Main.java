package rovine;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String firstPath="src/xmlFile/";
        String mappaFile5 = "PgAr_Map_5.xml";
        String mappaFile12 = "PgAr_Map_12.xml";
        String mappaFile50 = "PgAr_Map_50.xml";
        String mappaFile200 = "PgAr_Map_200.xml";
        String mappaFile2000 = "PgAr_Map_2000.xml";
        String mappaFile10000 = "PgAr_Map_10000.xml";
        ReaderXML lettore = new ReaderXML();
        lettore.leggiXML(firstPath+mappaFile50);
        Cartina mappa=new Cartina(lettore.getMappaTerritorio());
        mappa.generaPercorsoOttimale(lettore.getElencoNodi(), lettore.getMappaArchi());
        System.out.println("Numero citta: "+lettore.getElencoNodi().size());
        System.out.println("Numero di archi in mappaTerritorio: "+lettore.getMappaTerritorio().size());
    }
}