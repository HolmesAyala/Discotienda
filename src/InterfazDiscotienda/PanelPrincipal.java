package InterfazDiscotienda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.layout.Border;
import javax.swing.JFrame;

/**
 *
 * @author Cuchurrumi
 */
public class PanelPrincipal extends JFrame{
    
    private PanelTitulo panelTitulo;
    
    private PanelBotones panelBotones;
    
    public PanelPrincipal() {
        configuracionVentana();
    }
    
    public void configuracionVentana(){
        setTitle("Discotienda Holan");
        setLayout(new BorderLayout());
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension resolucion = pantalla.getScreenSize();
        setBounds(resolucion.width/2-400, resolucion.height/2-400, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTitulo = new PanelTitulo();
        getContentPane().add(panelTitulo, BorderLayout.NORTH);
        panelBotones = new PanelBotones();
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
                
    }
}
