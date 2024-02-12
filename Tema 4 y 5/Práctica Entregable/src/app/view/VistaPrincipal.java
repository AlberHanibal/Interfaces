package app.view;

import javax.swing.*;
import app.main.*;

public class VistaPrincipal extends JFrame {

    public VistaActividades vAct;
    JPanel vObj;

    public VistaPrincipal() {
        setTitle("DeporApp 1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vAct = new VistaActividades();
        vObj = new VistaObjetivos();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Actividades", vAct);
        tabs.addTab("Objetivos", vObj);
        add(tabs);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
