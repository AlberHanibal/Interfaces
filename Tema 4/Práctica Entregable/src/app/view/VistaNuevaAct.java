package app.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.*;

import app.main.*;

public class VistaNuevaAct extends JFrame {

    public VistaNuevaAct() {
        setTitle("Nueva actividad");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel central = new JPanel();
        central.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));
        JLabel labelFecha = new JLabel("Fecha:");
        JTextField textFecha = new JTextField();
        JLabel labelDuracion = new JLabel("Duración (min):");
        JTextField textDuracion = new JTextField();
        JLabel labelDistancia = new JLabel("Distancia (metros):");
        JTextField textDistancia = new JTextField();
        JLabel labelPPM = new JLabel("Pulso medio");
        JTextField textPPM = new JTextField();
        JLabel labelDeporte = new JLabel("Deporte:");
        JComboBox textDeporte = new JComboBox<String>();
        textDeporte.addItem("Carrera");
        textDeporte.addItem("Ciclismo");
        textDeporte.addItem("Natación");

        labelPPM.setAlignmentX(LEFT_ALIGNMENT);
        textPPM.setAlignmentX(LEFT_ALIGNMENT);
        labelFecha.setAlignmentX(LEFT_ALIGNMENT);
        textFecha.setAlignmentX(LEFT_ALIGNMENT);
        labelDuracion.setAlignmentX(LEFT_ALIGNMENT);
        textDuracion.setAlignmentX(LEFT_ALIGNMENT);
        labelDistancia.setAlignmentX(LEFT_ALIGNMENT);
        textDistancia.setAlignmentX(LEFT_ALIGNMENT);
        labelDeporte.setAlignmentX(LEFT_ALIGNMENT);
        textDeporte.setAlignmentX(LEFT_ALIGNMENT);

        central.add(labelFecha);
        central.add(textFecha);
        central.add(labelDuracion);
        central.add(textDuracion);
        central.add(labelDistancia);
        central.add(textDistancia);
        central.add(labelPPM);
        central.add(textPPM);
        central.add(labelDeporte);
        central.add(textDeporte);

        JPanel botones = new JPanel();
        JButton botonGuardar = new JButton("Guardar");
        JButton botonCancelar = new JButton("Cancelar");
        botones.add(botonGuardar);
        botones.add(botonCancelar);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controlador.getCtl().creaActividad(textFecha.getText(),
                            textDuracion.getText(), textDistancia.getText(), textPPM.getText(),
                            textDeporte.getSelectedItem().toString());
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Error: Actividad mal formada", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(central, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
