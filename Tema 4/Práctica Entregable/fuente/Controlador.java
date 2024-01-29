package app.main;

import java.util.ArrayList;
import java.util.Date;
import app.view.*;

public class Controlador {

    /*
     * Para tener una referencia al Controlador desde cualquier objeto del programa
     * utilizo el patrón de diseño Singleton. Es un patrón muy sencillo y muy útil
     * 
     * Si tienes dudas de como funciona pregúntame.
     */

    private static final Controlador ctl = new Controlador();

    private VistaPrincipal vistappal;
    private ArrayList<Actividad> actividades;

    private Controlador() {
    }

    public static Controlador getCtl() {
        return ctl;
    }

    public ArrayList<Actividad> getActividades() throws Exception{
        if (actividades==null){  // solo las carga la primera vez
            actividades = Actividad.cargaActividades();
            //actividades = creaActividadesAleatorias();
        }
        return actividades;
    }

    public Estadisticas getEstadisticas(){
        return new Estadisticas(actividades);
    }

    public void insertaActividad(Actividad a){
        if (actividades!=null){  
            actividades.add(a);
        }
    }

    public void setVistaPrincipal(VistaPrincipal vista) {
        vistappal = vista;
    }

    public void creaActividad(String sfecha, String dur,
            String dist, String sppm, String depor) throws Exception {

        long duracion = Long.parseLong(dur);
        long distancia = Long.parseLong(dist);
        int ppm = Integer.parseInt(sppm);
        byte deporte = Actividad.parseaDeporte(depor);
        if (deporte == 0) {
            throw new Exception("Deporte desconocido");
        }
        Date fecha = Actividad.parseaFecha(sfecha);
        Actividad a = new Actividad(fecha, duracion, distancia, ppm, deporte);

        if (vistappal != null) {
            vistappal.vAct.insertaActividad(a);
        }
    }

    public void guardaActividades() throws Exception{
        Actividad.guardaActividades(actividades);
    }

}
