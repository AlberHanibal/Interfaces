package app.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import app.main.*;

public class VistaActividades extends JPanel {

    private JPanel pder;
    private JPanel pcent;
    private JTable tabla;
    private DefaultTableModel datosTabla;
    private Dimension DimensionTabla = new Dimension(800, 600);
    private Border padding = new EmptyBorder(5, 5, 5, 25);

    public VistaActividades() {
        setLayout(new BorderLayout());

        pcent = creaPanelCentral();
        iniciaTablaActividades();
        pder = creaPanelDerecho();

        add(pcent, BorderLayout.CENTER);
        add(pder, BorderLayout.EAST);
    }

    public void insertaActividad(Actividad a) {
        datosTabla.addRow(a.getFields());
        Controlador.getCtl().insertaActividad(a);
    }

    public void iniciaTablaActividades(){
        try {
            ArrayList<Actividad> actividades=Controlador.getCtl().getActividades();
            for (Actividad a:actividades){
                datosTabla.addRow(a.getFields());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(),
                                          "Error: Hubo un problema al cargar las actividades", "Error",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    private JPanel creaPanelCentral() {
        JPanel panel = new JPanel();

        Vector<String> cabeceras = new Vector<String>();
        cabeceras.add("Fecha");
        cabeceras.add("Duración");
        cabeceras.add("Distancia");
        cabeceras.add("Deporte");
        cabeceras.add("PPM");
        cabeceras.add("Ritmo (min / 1km)");

        Vector datos = new Vector();
        tabla = new JTable(datos, cabeceras);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setHorizontalScrollBarPolicy(
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(
                                              JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(DimensionTabla);
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        datosTabla = (DefaultTableModel) tabla.getModel();

        return panel;
    }

    private JPanel creaPanelDerecho() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // subpanel de información
        Estadisticas stats=Controlador.getCtl().getEstadisticas();
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(BorderFactory.createTitledBorder("Estadísticas"));
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        JLabel labelDist = new JLabel("Distancia total: "+stats.getDistanciaTotal());
        labelDist.setBorder(padding);
        JLabel labelDur = new JLabel("Tiempo total: "+stats.getDuracionTotal());
        labelDur.setBorder(padding);
        JLabel labelMLarga = new JLabel("Act. mayor distancia: "+stats.masLarga.getDistanciaString(true));
        labelMLarga.setBorder(padding);
        JLabel labelMDur = new JLabel("Act. mayor duración: "+stats.masDuracion.getDuracionString(true));
        labelMDur.setBorder(padding);
        JLabel durCarr = new JLabel("Tiempo (carrera): "+stats.getDuracionStringPorDeporte(Actividad.CARRERA));
        durCarr.setBorder(padding);
        JLabel durCicli = new JLabel("Tiempo (ciclismo): "+stats.getDuracionStringPorDeporte(Actividad.CICLISMO));
        durCicli.setBorder(padding);
        JLabel durNata = new JLabel("Tiempo (natación): "+stats.getDuracionStringPorDeporte(Actividad.NATACION));
        durNata.setBorder(padding);
        JLabel labelAct = new JLabel("Actividades registradas: "+stats.totalActividades);
        labelAct.setBorder(padding);
        panelInfo.add(labelDist);
        panelInfo.add(labelDur);
        panelInfo.add(durCarr);
        panelInfo.add(durCicli);
        panelInfo.add(durNata);
        panelInfo.add(labelMLarga);
        panelInfo.add(labelMDur);
        panelInfo.add(labelAct);

        // subpanel de botones
        JPanel panelBotones = new JPanel();
        JButton botonCrear = new JButton("Crea");
        JButton botonGuardar = new JButton("Guarda");
        JButton botonBorrar = new JButton("Borra");
        JButton botonAyuda = new JButton("Ayuda");

        panelBotones.add(botonCrear);
        panelBotones.add(botonGuardar);
        panelBotones.add(botonBorrar);
        panelBotones.add(botonAyuda);

        botonCrear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new VistaNuevaAct();
                }
            });

        botonGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Controlador.getCtl().guardaActividades();
                        JOptionPane.showMessageDialog(new JFrame(),
                                                      "Las actividades se guardaron con éxito", "Éxito",
                                                      JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                                      "Error: No se guardaron las actividades", "Error",
                                                      JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        botonBorrar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indiceTabla=tabla.getSelectedRow();
                    if (indiceTabla >=0){
                        /*
                          Es necesario convertir el índice seleccionado en la
                          tabla a ese mismo índice pero en el modelo. Ambos
                          índices pueden no coincidir, de ahí que la conversión
                          sea necesaria.
                         */
                        int indiceModelo = tabla.convertRowIndexToModel(indiceTabla);
                        datosTabla.removeRow(indiceModelo);
                    }

                }                
            });

        botonAyuda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new VistaNavegador();
                }
            });

        panel.add(panelInfo, BorderLayout.NORTH);
        panel.add(new JPanel(), BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }

}
