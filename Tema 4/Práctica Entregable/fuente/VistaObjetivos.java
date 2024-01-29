package app.view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import app.main.*;

public class VistaObjetivos extends JPanel{

    private JPanel pcentral;
    private Dimension dimensionPCentral = new Dimension(800, 600);
    private long OBJETIVO_CARRERA=50*1000; //km
    private long OBJETIVO_CICLISMO=80*1000; //km
    private long OBJETIVO_NATACION=40*1000; //km


    public VistaObjetivos(){

        pcentral=new JPanel();
        pcentral.setLayout(new BoxLayout(pcentral,BoxLayout.Y_AXIS));
        pcentral.setPreferredSize(dimensionPCentral);

        Border padding = new EmptyBorder(50, 10, 10, 10);
        
        JLabel objCiclismo = new JLabel("Objetivo de distancia para ciclismo");
        objCiclismo.setBorder(padding);
        JProgressBar barraCiclismo = new JProgressBar();
        barraCiclismo.setStringPainted(true);

        JLabel objCarrera = new JLabel("Objetivo de distancia para carrera");
        objCarrera.setBorder(padding);
        JProgressBar barraCarrera = new JProgressBar();
        barraCarrera.setStringPainted(true);

        JLabel objNatacion = new JLabel("Objetivo de distancia para natacion");
        objNatacion.setBorder(padding);
        JProgressBar barraNatacion = new JProgressBar();
        barraNatacion.setStringPainted(true);
        
        pcentral.add(Box.createVerticalGlue());  // añado los glue para centrar verticalmente
        pcentral.add(objCiclismo);
        pcentral.add(barraCiclismo);
        pcentral.add(objCarrera);
        pcentral.add(barraCarrera);
        pcentral.add(objNatacion);
        pcentral.add(barraNatacion);
        pcentral.add(Box.createVerticalGlue());

        // Calculo porcentaje de los objetivos alcanzados
        Estadisticas stat = Controlador.getCtl().getEstadisticas();

        int porcentajeCarrera =(int) ((stat.getDistanciaPorDeporte(Actividad.CARRERA)*100) / OBJETIVO_CARRERA);
        int porcentajeCiclismo =(int) ((stat.getDistanciaPorDeporte(Actividad.CICLISMO)*100) / OBJETIVO_CICLISMO);
        int porcentajeNatacion =(int) ((stat.getDistanciaPorDeporte(Actividad.NATACION)*100) / OBJETIVO_NATACION);

        barraCarrera.setValue(porcentajeCarrera);
        barraCiclismo.setValue(porcentajeCiclismo);
        barraNatacion.setValue(porcentajeNatacion);

        add(pcentral);
    }

    
}
