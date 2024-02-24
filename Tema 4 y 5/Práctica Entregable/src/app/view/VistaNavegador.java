package app.view;

import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.io.File; 
import app.main.App;

public class VistaNavegador {

    public VistaNavegador(){

        String errorText="<h1>Fichero de ayuda no encontrado</h1>";
        JEditorPane jep = new JEditorPane();

        try{
            File file = new File("./man/manual.html");
            jep.setPage(file.toURI().toURL());                        
        }catch(Exception e){
            jep.setText(errorText);
        }
        jep.setContentType("text/html");//set content as html
        jep.setEditable(false);//so its not editable
        jep.setOpaque(false);//so we dont see whit background
        
        jep.addHyperlinkListener(new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent pE) {
                    if (HyperlinkEvent.EventType.ACTIVATED.equals(pE.getEventType())) {
                        String reference = pE.getDescription();
                        if (reference != null && reference.startsWith("#")) { // link must start with # to be internal reference
                            reference = reference.substring(1);
                            jep.scrollToReference(reference);
                        }
                    }
                }
            });
        
        JFrame f = new JFrame("Ayuda");
               
        final JScrollPane sp = new JScrollPane(jep);
        f.add(sp);
        f.setSize(new Dimension(600,400));
        f.setLocationRelativeTo(null);      
        //f.pack();
        f.setVisible(true);
    }
}
