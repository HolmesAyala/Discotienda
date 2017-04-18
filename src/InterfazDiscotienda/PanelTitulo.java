package InterfazDiscotienda;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cuchurrumi
 */
public class PanelTitulo extends JPanel{
    
    private JLabel titulo;
    
    public PanelTitulo() {
        
      setBackground(Color.WHITE);
       
      titulo = new JLabel("HOLA MUNDO"); 
      
      
      ImageIcon icono = new ImageIcon("Iconos/icono.png");
      titulo.setIcon(icono);
      add(titulo); 
        
    }
 
}
