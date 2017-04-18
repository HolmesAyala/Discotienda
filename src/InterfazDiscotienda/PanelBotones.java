package InterfazDiscotienda;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cuchurrumi
 */
public class PanelBotones extends JPanel implements ActionListener{
    
    private JButton btnArtista;

    private JButton btnDisco;

    private JButton btnCancion;
    
    public PanelBotones() {
        configuracionVentana();
    }
    
    public void configuracionVentana() {
        
        setLayout(new GridLayout(1, 3));
        setBorder(new TitledBorder("Agregar:"));
        btnArtista = new JButton("Artista");
        btnArtista.addActionListener(this);
        add(btnArtista);
        btnDisco = new JButton("Disco");
        btnDisco.addActionListener(this);
        add(btnDisco);
        btnCancion = new JButton("Cancion");
        btnCancion.addActionListener(this);
        add(btnCancion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand() == "Artista") {
          DialogoArtista dialogoArtista = new DialogoArtista();
          dialogoArtista.setVisible(true);
          System.out.print("HOLA ARTISTA\n");
      }
      else if(e.getActionCommand() == "Disco") {
          System.out.print("HOLA DISCO\n");
      }
      else if(e.getActionCommand() == "Cancion") {
          System.out.print("HOLA CANCION\n");
      }
    }
    
}
