package app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import java.lang.NumberFormatException;

public class TestCalculadora {

  @BeforeClass
  public static void SetUpGlobal() {
    // Estos métodos se ejecutarán antes de todos los test
    // El convenio es nombrarlos con el prefijo SetUp...
    // Aquí podemos realizar tareas como conexiones a la BD, cargas de disco, etc.
    // Debe ser estático

    System.out.println("Inicio de la batería de test");
  }

  @Before
  public void setUp() {
    // Estos métodos se ejecutarán antes de cada test
    System.out.println("Inicio de nuevo test");
  }

  @Test
  public void evaluaSumasEnteros() {

    Calculadora c = new Calculadora();
    int res = 0;

    res = c.suma("1+2");
    assertEquals(3, res);

    res = c.suma("6+2+8");
    assertEquals(16, res);

    res = c.suma("5+5+4+10");
    assertEquals(24, res);
  }


  @Test(expected = NumberFormatException.class)
  public void evaluaSumasReales() throws NumberFormatException{

    Calculadora c = new Calculadora();
    int res = 0;

    res = c.suma("1+2.5");
  }


  @Test
  public void evaluaRestasEnteros() {

    Calculadora c = new Calculadora();
    int res = 0;

    res = c.resta("6-2-8");
    assertEquals(-4, res);

    res = c.resta("0-2");
    assertEquals(-2, res);

  }

  @Test
  public void evaluaMultisEnteros() {

    Calculadora c = new Calculadora();
    int res = 0;

    res = c.mult("5*5*4");
    assertEquals(100, res);

  }

}
