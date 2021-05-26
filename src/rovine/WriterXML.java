package rovine;

import javax.xml.stream.XMLOutputFactory;
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
	        xmlw.writeStartElement(OUTPUT);
            xmlw.writeStartElement("route");
            xmlw.writeAttribute("team", "Tonathiu");
            xmlw.writeAttribute("cost", Integer.toString(carburanteTotV1) );
            xmlw.writeAttribute("cities",Integer.toString(listaCittaV1.size()) );
            for (int i = listaCittaV1.size()-1 ; i >= 0; i--) {
                xmlw.writeStartElement("city");
                xmlw.writeAttribute("id", Integer.toString(listaCittaV1.get(i).getId()));
                xmlw.writeAttribute("name",listaCittaV1.get(i).getName());
                xmlw.writeEndElement();
            }
            xmlw.writeEndElement();
        } catch (Exception e) { // se trova un errore viene eseguita questa parte
            
            return;
        }
        try {
        	  xmlw.writeStartElement(OUTPUT);
              xmlw.writeStartElement("route");
              xmlw.writeAttribute("team", "Metztli");
              xmlw.writeAttribute("cost", Integer.toString(carburanteTotV2) );
              xmlw.writeAttribute("cities",Integer.toString(listaCittaV2.size()) );
              for (int i = listaCittaV2.size()-1 ; i >= 0; i--) {
                  xmlw.writeStartElement("city");
                  xmlw.writeAttribute("id", Integer.toString(listaCittaV2.get(i).getId()));
                  xmlw.writeAttribute("name",listaCittaV2.get(i).getName());
                  xmlw.writeEndElement();
              }
            xmlw.writeEndElement();
            xmlw.writeEndElement();
            xmlw.writeEndDocument();
            xmlw.flush();
            xmlw.close();
        } catch (Exception e) { // se trova un errore viene eseguita questa parte
           
            return;
        }
     }
}
