package InterfazDiscotienda;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelTitulo extends JPanel{
    
    private JLabel titulo;  //  Nombres de los integrantes
    
    /**
     * Constructor
     */
    public PanelTitulo() {
        
      setBackground(Color.WHITE);
       
      titulo = new JLabel("Anggy Arguello - Holmes Ayala");
      titulo.setFont(new Font("tahoma", Font.PLAIN, 30));
      ImageIcon icono = new ImageIcon("Iconos/IconoPanelTitulo.jpg");
      titulo.setIcon(icono);
      add(titulo); 
        
    }
 
}
