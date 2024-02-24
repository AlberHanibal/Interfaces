package app.main;

import java.util.ArrayList;

public class Estadisticas {

    private long distanciaTotal;
    private long distanciaTotalCiclismo;
    private long distanciaTotalCarrera;
    private long distanciaTotalNatacion;
    public long totalActividades;
    private long duracionTotal;
    private long duracionTotalCiclismo;
    private long duracionTotalCarrera;
    private long duractionTotalNatacion;
    public Actividad masLarga;
    public Actividad masDuracion;

    public Estadisticas(ArrayList<Actividad> todas) {
        distanciaTotal = 0;
        duracionTotal = 0;
        totalActividades = todas.size();
        masLarga = todas.get(0);
        masDuracion = todas.get(0);
        duracionTotalCiclismo = 0;
        duracionTotalCarrera = 0;
        duractionTotalNatacion = 0;
        distanciaTotalCiclismo = 0;
        distanciaTotalCarrera = 0;
        distanciaTotalNatacion = 0;

        for (Actividad a : todas) {
            distanciaTotal += a.getDistancia();
            duracionTotal += a.getDuracion();

            if (a.getDistancia() > masLarga.getDistancia()) {
                masLarga = a;
            }

            if (a.getDuracion() > masDuracion.getDuracion()) {
                masDuracion = a;
            }

            switch (a.getDeporte()) {
                case Actividad.CARRERA:
                    duracionTotalCarrera += a.getDuracion();
                    distanciaTotalCarrera +=a.getDistancia();
                    break;
                case Actividad.CICLISMO:
                    duracionTotalCiclismo += a.getDuracion();
                    distanciaTotalCiclismo +=a.getDistancia();
                    break;
                case Actividad.NATACION:
                    duractionTotalNatacion += a.getDuracion();
                    distanciaTotalNatacion +=a.getDistancia();
                    break;
            }
        }
    }

    public String getDuracionTotal() {
        long minutos = duracionTotal / 60;
        return String.valueOf(minutos) + " horas";
    }

    public String getDuracionStringPorDeporte(byte deporte) {
        switch (deporte) {
            case Actividad.CARRERA:
                return String.valueOf(duracionTotalCarrera) + " horas";
            case Actividad.CICLISMO:
                return String.valueOf(duracionTotalCiclismo) + " horas";
            case Actividad.NATACION:
                return String.valueOf(duractionTotalNatacion) + " horas";
        }
        return "0 horas";
    }

    public long getDuracionPorDeporte(byte deporte) {
        switch (deporte) {
            case Actividad.CARRERA:
                return duracionTotalCarrera;
            case Actividad.CICLISMO:
                return duracionTotalCiclismo;
            case Actividad.NATACION:
                return duractionTotalNatacion;
        }
        return 0;
    }

    public long getDistanciaPorDeporte(byte deporte) {
        switch (deporte) {
            case Actividad.CARRERA:
                return distanciaTotalCarrera;
            case Actividad.CICLISMO:
                return distanciaTotalCiclismo;
            case Actividad.NATACION:
                return distanciaTotalNatacion;
        }
        return 0;
    }

    public String getDistanciaTotal() {
        long km;
        if (distanciaTotal > 1000) {
            km = duracionTotal / 1000;
        } else {
            km = distanciaTotal;
        }
        return String.valueOf(km) + " km";
    }

}
