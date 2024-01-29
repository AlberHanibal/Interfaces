package vista;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import app.*;


public class VistaTabla extends JScrollPane {

    JTable tablaDatos;
    Vector modeloDatos;

    public VistaTabla(ArrayList<Libro> datos) {

        modeloDatos = new Vector();
        Vector<String> cabeceras = new Vector<String>();
        cabeceras.add("Título");
        cabeceras.add("Autor");
        cabeceras.add("Género");
        tablaDatos = new JTable(modeloDatos, cabeceras);

        for (Libro libro : datos) {
            Vector<String> fila = new Vector<String>();
            fila.add(libro.getTitulo());
            fila.add(libro.getAutor());
            fila.add(libro.getGenero());
            modeloDatos.add(fila);
        }

        // añado la tabla al mi viewport
        getViewport().add(tablaDatos);

        setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void insertaLibro(Libro nuevo) {
        Vector<String> fila = new Vector<String>();
        fila.add(nuevo.getTitulo());
        fila.add(nuevo.getAutor());
        fila.add(nuevo.getGenero());
        modeloDatos.add(fila);

        DefaultTableModel dm = (DefaultTableModel) tablaDatos.getModel();
        dm.fireTableDataChanged();
    }

}
