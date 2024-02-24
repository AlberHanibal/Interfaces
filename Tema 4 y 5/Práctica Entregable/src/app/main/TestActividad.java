package app.main;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        // alguno más creo
    }

    // parseaFecha
    @Test
    public void testparseaFecha() {

    }


    // getDuracionString
    @Test
    public void testgetDuracionString() {

    }


    // getDistanciaString
    @Test
    public void testgetDistanciaString() {

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
        // hay que calcularlo
            // (float)dur/((float)dis/1000)
    }
}
