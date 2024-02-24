package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import app.*;
import modelo.*;

public class Vista {

    private ArrayList<Libro> biblioteca;
    private VistaTabla vtabla;

    private JPanel creaPanelDerecho(){

        JPanel pder = new JPanel();
        pder.setLayout(new BorderLayout());

        vtabla = new VistaTabla(biblioteca);
        vtabla.setPreferredSize(new Dimension(400,250));
        pder.add(vtabla, BorderLayout.CENTER);

        return pder;

    }


    private JPanel creoPanelEntradaDatos(){
        JPanel central = new JPanel();
        central.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));

        JLabel jLabel1 = new JLabel("Título:");
        jLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);
        central.add(jLabel1);
        JTextField titulo = new JTextField("", 30);
        titulo.setMaximumSize(new Dimension(Integer.MAX_VALUE,
                titulo.getPreferredSize().height)); 
        central.add(titulo);

        JLabel jLabel2 = new JLabel("Autor:");
        jLabel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        central.add(jLabel2);
        JTextField autor = new JTextField("", 30);
        autor.setMaximumSize(new Dimension(Integer.MAX_VALUE,
                autor.getPreferredSize().height));
        central.add(autor);

        JLabel jLabel4 = new JLabel("Etiquetas:");
        jLabel4.setAlignmentX(Component.LEFT_ALIGNMENT);
        central.add(jLabel4);
        JTextField etiquetas = new JTextField("", 30);
        etiquetas.setMaximumSize(new Dimension(Integer.MAX_VALUE,
                etiquetas.getPreferredSize().height));
        central.add(etiquetas);

        JLabel jLabel3 = new JLabel("Género:");
        jLabel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        central.add(jLabel3);
        JComboBox genero = new JComboBox<String>();
        central.add(genero);
        genero.setMaximumSize(new Dimension(Integer.MAX_VALUE,
                genero.getPreferredSize().height));
        genero.setAlignmentX(Component.LEFT_ALIGNMENT);
        genero.addItem("Contemporánea");
        genero.addItem("Ciencia Ficción");
        genero.addItem("Histórica");
        genero.addItem("Suspense");

        /*
         * Creo el panel inferior con el botón y el mensaje de error.
         */
        JPanel inferior = new JPanel();
        inferior.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));

        inferior.setAlignmentX(Component.LEFT_ALIGNMENT);
        inferior.setLayout(new BorderLayout());
        inferior.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JButton jbutton = new JButton("Guardar");
        inferior.add(jbutton, BorderLayout.EAST);

        JLabel error = new JLabel("  ");
        error.setHorizontalAlignment(SwingConstants.RIGHT);
        inferior.add(error, BorderLayout.CENTER);

        central.add(inferior);

        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("  ");
                if ((titulo.getText().length() == 0)
                        || (autor.getText().length() == 0)) {
                    error.setText("!!");
                } else {
                    // guardo info en un fichero de texto
                    Libro nuevo=Controlador.creaLibro(titulo.getText(),
                            autor.getText(),
                            genero.getSelectedItem().toString(),
                            etiquetas.getText());
                    vtabla.insertaLibro(nuevo);
                }
            }
        });

        return central;
    }




    public Vista() {

        // Cargo biblioteca
        biblioteca = Libro.getAll();

        JFrame jfrm = new JFrame("Tus Libros");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.getContentPane().setLayout(new GridLayout(1, 2));

        jfrm.add(creoPanelEntradaDatos());
        jfrm.add(creaPanelDerecho());

        jfrm.pack();
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        new Vista();
    }
}
