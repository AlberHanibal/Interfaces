package app.main;

import app.view.*;

/*
 * TODO:
 * 
 * [x] Cargar/Guardar actividades a fichero
 * [x] Panel para crear actividad
 * [x] Panel para estadísticas generales
 *      + Distancia total
 *      + Distancia total por deporte
 *      + Tiempo total
 *      + Tiempo total por deporte
 *      + Actividades registradas
 * [x] Panel para mostrar objetivos
 *      + Progreso con barra de progreso de los objetivos
 * [x] Calcular ritmo en actividades
 * 
 * 
 *  Opcional:
 * [ ] Borrar actividades
 * [ ] Panel para editar objetivos propuestos
 * [ ] Editar objetivos
 * 
 */

public class App {
    public static void main(String[] args) {

        VistaPrincipal ppal = new VistaPrincipal();
        Controlador.getCtl().setVistaPrincipal(ppal);
    }
}
