package rovine;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

public class ReaderXML {
    private static final String ERROREREADER = "Errore nell'inizializzazione del reader: ";
    private static final String STRINGAINIZIOLETTURA = "Inzio lettura file: ";
    private static final String STRINGAFINELETTURA = "Fine lettura file: ";
    private static final String CITY = "city";
    private static final String LINK = "link";
    private static final String MAPPA_CREATA = "La mappaTerritorio è stata creata con successo";

    private Map<Arco, ArrayList<Double>> mappaTerritorio;
    private Map<Integer, ArrayList<Integer>> mappaArchi;
    private ArrayList<Nodo> elencoNodi;

    public void LeggiXML (String filename) {
        int h, y, x, idNodoPartenza = 0, idNodoArrivo = 0;
        String name;
        ArrayList<Integer> elencoIdNodiArrivo = null;
        //Questo frammento di codice serve a creare ed istanziare la variabile xmlr di tipo XMLStreamReader,
        //che sarà utilizzata per leggere il file XML
        XMLInputFactory xmlif;
        XMLStreamReader xmlr;
        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
            System.out.println(STRINGAINIZIOLETTURA+filename);
            //Legge il File xml fino a quando ci sono eventi di parsing disponibili
            while (xmlr.hasNext()) {
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    String nomeTag = xmlr.getLocalName();
                    if (nomeTag.equals(CITY)) {
                        h = Integer.parseInt(xmlr.getAttributeValue(0));
                        y = Integer.parseInt(xmlr.getAttributeValue(1));
                        x = Integer.parseInt(xmlr.getAttributeValue(2));
                        name = xmlr.getAttributeValue(3);
                        idNodoPartenza = Integer.parseInt(xmlr.getAttributeValue(4));
                        elencoNodi.add(new Nodo(name, idNodoPartenza, x, y, h));
                        elencoIdNodiArrivo = new ArrayList<>();
                    }
                    else if (nomeTag.equals(LINK)){
                        while (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                            idNodoArrivo = Integer.parseInt(xmlr.getAttributeValue(0));
                            elencoIdNodiArrivo.add(idNodoArrivo);
                            xmlr.next();
                            xmlr.next();
                        }
                        mappaArchi.put(idNodoPartenza, elencoIdNodiArrivo);
                    }
                }
                xmlr.next();
            }
            System.out.println(STRINGAFINELETTURA+filename);
            creaMappaTerritorio(mappaArchi, elencoNodi);
            System.out.println(MAPPA_CREATA);
        } catch (Exception e) {
            System.out.println(ERROREREADER);
            System.out.println(e.getMessage());
        }
    }

    public void creaMappaTerritorio(Map<Integer, ArrayList<Integer>> mappaArchi, ArrayList<Nodo> elencoNodi){
        for(int i = 0; i < mappaArchi.size(); i++){
            for (int j = 0; j < mappaArchi.get(i).size(); j++){
                Nodo nodoPartenza = elencoNodi.get(i);
                Nodo nodoArrivo = elencoNodi.get(mappaArchi.get(i).get(j));
                double valoreVeicolo1 = nodoPartenza.distanzaNelPianoXY(nodoArrivo);
                double valoreVeicolo2 = nodoPartenza.differenzaAltezze(nodoArrivo);
                ArrayList<Double> valoriConsumoVeicoli = new ArrayList<>();
                valoriConsumoVeicoli.add(valoreVeicolo1);
                valoriConsumoVeicoli.add(valoreVeicolo2);
                mappaTerritorio.put(new Arco(nodoPartenza, nodoArrivo), valoriConsumoVeicoli);
            }
        }
    }
}
