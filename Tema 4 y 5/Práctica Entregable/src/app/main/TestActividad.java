package app.main;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.main.Actividad;

public class TestActividad {
    
    // parseaDeporte
    /*
    @Rule
	public ExpectedException thrown = ExpectedException.none();
    @Test()
    public void testparseaDeporte() throws Throwable {
        thrown.expect(Throwable.class);
		thrown.expectMessage("NATACION");
        Actividad.parseaDeporte("Natación");
        thrown.expectMessage("CARRERA");
        Actividad.parseaDeporte("Carrera");
    }
    */

    // parseaFecha



    // getDuracionString



    // getDistanciaString



    // getDeporteString
    @Test()
    public void testGetDeporteString() {
        byte deporte = Byte.parseByte("NATACION");
        Actividad act = new Actividad("01/01/2000", 10, 10, 10, deporte);
    }


    // getRitmo

}
