package app.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;




import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.InputStream;


public class Actividad {

    public final static byte NATACION = 1;
    public final static byte CARRERA = 2;
    public final static byte CICLISMO = 3;

    public final static String fichero = "resources/datos.xml";

    private long duracion; // minutos
    private long distancia; // metros
    private Date fecha;
    private int ppm;
    private byte deporte;
    private float ritmo;  // tiempo empleado para hacer 1000 metros de actividad

    public Actividad(Date d, long dur, long dis, int ppm, byte depor) {
        this.duracion = dur;
        this.fecha = d;
        this.distancia = dis;
        this.deporte = depor;
        this.ppm = ppm;
        this.ritmo = (float)dur/((float)dis/1000);
    }

    // Necesita ser probado!!!!
    public static byte parseaDeporte(String s) {
        try {
            byte b=Byte.parseByte(s);
            return b;
        } catch (Exception e) {
            if (s.equals("Natación")) {
                return NATACION;
            }
            if (s.equals("Carrera")) {
                return CARRERA;
            }
            if (s.equals("Ciclismo")) {
                return CICLISMO;
            }
        }
        return 0;

    }

    // Necesita ser probado!!!!
    public static Date parseaFecha(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date date = formatter.parse(s);
        return date;
    }

    private String imprimeFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        return formatter.format(this.fecha);
    }

    public Date getFecha() {
        return this.fecha;
    }

    public long getDuracion(){
        return duracion;
    }

    // Necesita ser probado!!!!
    public String getDuracionString(boolean aprox){
        String s=String.valueOf((int)duracion / 60)+" horas";
        if (!aprox){
            s+=" "+String.valueOf((int)duracion % 60)+" min";
        }
        return s;
    }

    public long getDistancia(){
        return distancia;
    }

    // Necesita ser probado!!!!
    public String getDistanciaString(boolean aprox){
        String s= String.valueOf((int)distancia / 1000)+" km";
        if (!aprox){
            s+=" "+String.valueOf((int)distancia % 1000)+" m";
        }
        return s;
    }

    public byte getDeporte(){
        return deporte;
    }

    // Necesita ser probado!!!!
    public String getDeporteString() {
        switch (this.deporte) {
            case NATACION:
                return "Natación";
            case CARRERA:
                return "Carrera";
            case CICLISMO:
                return "Ciclismo";
            default:
                return "desconocido";
        }
    }

    public int getPPM() {
        return this.ppm;
    }

    // Necesita ser probado!!!!
    public float getRitmo() {
        return this.ritmo;
    }

    public Vector<String> getFields() {
        Vector<String> v = new Vector<String>();
        v.add(imprimeFecha());
        v.add(getDuracionString(false));
        v.add(getDistanciaString(false));
        v.add(this.getDeporteString());
        v.add(String.valueOf(this.getPPM()));
        v.add(String.format("%.02f", this.getRitmo()));
        return v;
    }

    public String toString() {
        String s="<actividad>\n";
        s+="\t<fecha>"+this.imprimeFecha()+"</fecha>\n";
        s+="\t<duracion>"+this.duracion+"</duracion>\n";
        s+="\t<distancia>"+this.distancia+"</distancia>\n";
        s+="\t<ppm>"+this.ppm+"</ppm>\n";
        s+="\t<deporte>"+this.deporte+"</deporte>\n";
        s+="</actividad>\n";
        return s;
    }


    public static void guardaActividades(ArrayList<Actividad> actividades) throws IOException {
        Path filename = Path.of(fichero);
        Files.write(filename, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        Files.writeString(filename,"<actividades>\n", StandardOpenOption.APPEND);
        for (Actividad a : actividades) {
            Files.writeString(filename, a.toString() + "\n", StandardOpenOption.APPEND);
        }
        Files.writeString(filename,"</actividades>\n", StandardOpenOption.APPEND);
    }


    public static ArrayList<Actividad> cargaActividades() throws Exception{

        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {            
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(fichero));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("actividad");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;                  
                    long duracion = Long.parseLong(element.getElementsByTagName("duracion").item(0).getTextContent());
                    long distancia = Long.parseLong(element.getElementsByTagName("distancia").item(0).getTextContent());
                    int ppm = Integer.parseInt(element.getElementsByTagName("ppm").item(0).getTextContent());
                    byte deporte = Actividad.parseaDeporte(element.getElementsByTagName("deporte").item(0).getTextContent());
                    Date fecha = Actividad.parseaFecha(element.getElementsByTagName("fecha").item(0).getTextContent());
                    Actividad act = new Actividad(fecha, duracion, distancia, ppm, deporte);
                    actividades.add(act);                  
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }   
        return actividades;
    }
}
