package app.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import app.main.Actividad;

public class TestActividad {
    
    DateFormat df = new SimpleDateFormat("dd/MM/yy");

    // parseaDeporte
    @Test()
    public void testparseaDeporte() {
        assertEquals(Actividad.NATACION, Actividad.parseaDeporte("Natación"));
        assertEquals(Actividad.CARRERA, Actividad.parseaDeporte("Carrera"));
        assertEquals(Actividad.CICLISMO, Actividad.parseaDeporte("Ciclismo"));

        assertNotEquals(Actividad.CARRERA, Actividad.parseaDeporte("carrera"));
        assertNotEquals(Actividad.NATACION, Actividad.parseaDeporte("Natacion"));
        assertNotEquals(Actividad.NATACION, Actividad.parseaDeporte("aaasssdddd"));
    }

    // parseaFecha
    @Test
    public void testparseaFecha() throws ParseException {
        String fecha;
        Date date;
        fecha = "02/08/1997";
        date = df.parse("02/08/1997");
        assertEquals(date, Actividad.parseaFecha(fecha));

        date = df.parse("02/09/1997");
        assertNotEquals(date, Actividad.parseaFecha(fecha));
    }


    // getDuracionString
    @Test
    public void testgetDuracionString() throws ParseException {
        Actividad act;
        act = new Actividad(df.parse("01/01/2000"), 100, 500, 10, Actividad.CARRERA);
        assertEquals("1 horas", act.getDuracionString(true));
        assertEquals("1 horas 40 min", act.getDuracionString(false));
        assertNotEquals("1 horas", act.getDuracionString(false));
        assertNotEquals("0 horas 40 min", act.getDuracionString(false));

        act = new Actividad(df.parse("01/01/2000"), 0, 500, 10, Actividad.CARRERA);
        assertEquals("0 horas", act.getDuracionString(true));
        assertNotEquals("0 horas 0 min", act.getDuracionString(true));
    }


    // getDistanciaString
    @Test
    public void testgetDistanciaString() throws ParseException {
        Actividad act;
        act = new Actividad(df.parse("01/01/2000"), 10, 260, 10, Actividad.CARRERA);
        assertEquals("0 km", act.getDistanciaString(true));
        assertEquals("0 km 260 m", act.getDistanciaString(false));
        assertNotEquals("260 m", act.getDistanciaString(false));

        act = new Actividad(df.parse("01/01/2000"), 10, 2680, 10, Actividad.CARRERA);
        assertEquals("2 km", act.getDistanciaString(true));
        assertEquals("2 km 680 m", act.getDistanciaString(false));
        assertNotEquals("2 km", act.getDistanciaString(false));
    }


    // getDeporteString
    @Test()
    public void testGetDeporteString() throws ParseException {
        Actividad act;
        act = new Actividad(df.parse("01/01/2000"), 10, 10, 10, Actividad.NATACION);
        assertEquals("Natación", act.getDeporteString());
        act = new Actividad(df.parse("01/01/2000"), 10, 10, 10, Actividad.CARRERA);
        assertEquals("Carrera", act.getDeporteString());
        act = new Actividad(df.parse("01/01/2000"), 10, 10, 10, Actividad.CICLISMO);
        assertEquals("Ciclismo", act.getDeporteString());
        act = new Actividad(df.parse("01/01/2000"), 10, 10, 10, (byte) 5);
        assertEquals("desconocido", act.getDeporteString());
    }


    // getRitmo
    @Test
    public void testgetRitmo() throws ParseException {
        Actividad act;
        act = new Actividad(df.parse("01/01/2000"), 10, 10, 10, Actividad.NATACION);
        assertNotEquals(10, act.getRitmo(), 0);
        assertEquals(1000, act.getRitmo(), 0);

        act = new Actividad(df.parse("01/01/2000"), 10, 100, 10, Actividad.NATACION);
        assertNotEquals(128, act.getRitmo(), 0);
        assertEquals(100, act.getRitmo(), 0);
    }
}
