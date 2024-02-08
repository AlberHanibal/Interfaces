package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.main.Actividad;

public class TestActividad {
    

    @Rule
    public ExpectedException exceptionRuleDeporte = ExpectedException.none();;
    @Test
    public void testparseaDeporte() {
        
        exceptionRuleDeporte.expect(Exception.class);
        exceptionRuleDeporte.expectMessage("NATACION");
        String deporte = "Natación";
        Actividad.parseaDeporte(deporte);
        
    }

    @Test
    public void prueba() {
        assertEquals(10, 5 + 5);
    }


}
