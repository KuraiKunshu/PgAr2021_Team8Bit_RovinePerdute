package rovine;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

public class WriterXML {
	
	private static final String OUTPUT = "routes";

	public WriterXML(){}
	
	public void ScriviXML(ArrayList<Nodo> listaCittaV1, ArrayList<Nodo> listaCittaV2, int carburanteTotV1 , int carburanteTotV2, String filePath) {
	        //Questo frammento di codice serve a creare ed istanziare la variabile xmlw di tipo XMLStreamWriter, che
	        //sarà utilizzata per scrivere il file XML. Viene inoltre inizializzato il documento XML.
	        XMLOutputFactory xmlof = null;
	        XMLStreamWriter xmlw = null;
	        try {
	            xmlof = XMLOutputFactory.newInstance();
	            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filePath), "utf-8");
	            xmlw.writeStartDocument("utf-8", "1.0");
	        } catch (Exception e) {
	            System.out.println("Errore nell'inizializzazione del writer:");
	            System.out.println(e.getMessage());
	            return;
	        }
	        try {
                xmlw.writeCharacters("\n");
                xmlw.writeStartElement(OUTPUT);
                xmlw.writeCharacters("\n"+"\t");
                xmlw.writeStartElement("route");
                xmlw.writeAttribute("team", "Tonathiu");
                stampaRoute(listaCittaV1, carburanteTotV1, xmlw);
            } catch (Exception e) { // se trova un errore viene eseguita questa parte
                return;
            }
            try {
                xmlw.writeCharacters("\n"+"\t");
                xmlw.writeStartElement("route");
                xmlw.writeAttribute("team", "Metztli");
                stampaRoute(listaCittaV2, carburanteTotV2, xmlw);
                xmlw.writeCharacters("\n");
                xmlw.writeEndDocument();
                xmlw.flush();
                xmlw.close();
            } catch (Exception e) { // se trova un errore viene eseguita questa parte
                return;
            }
     }

    private void stampaRoute(ArrayList<Nodo> listaCittaV1, int carburanteTotV1, XMLStreamWriter xmlw) throws XMLStreamException {
        xmlw.writeAttribute("cost", Integer.toString(carburanteTotV1));
        xmlw.writeAttribute("cities",Integer.toString(listaCittaV1.size()));
        xmlw.writeCharacters("\n");
        for (int i = listaCittaV1.size()-1 ; i >= 0; i--) {
            xmlw.writeCharacters("\t"+"\t");
            xmlw.writeStartElement("city");
            xmlw.writeAttribute("id", Integer.toString(listaCittaV1.get(i).getId()));
            xmlw.writeAttribute("name",listaCittaV1.get(i).getName());
            xmlw.writeEndElement();
            xmlw.writeCharacters("\n");
        }
        xmlw.writeCharacters("\t");
        xmlw.writeEndElement();
    }
}
