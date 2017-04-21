package InterfazDiscotienda;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelBotones extends JPanel implements ActionListener{
    
    private JButton btnArtista; // para ingresar artista

    private JButton btnDisco; // para ingresar disco

    private JButton btnCancion; // para ingresar cancion
    
    private PanelPrincipal panelPrincipal; // objeto panel principal
    
    private DialogoArtista dialogoArtista; // objeto dialogoArtista
    
    private DialogoDisco dialogoDisco; // objeto dialogo disco
    
    private DialogoCancion dialogoCancion; // objeto dialogo cancion 
    
    private boolean validarDisco = false; // validar disco
    
    /**
     * constructor
     * @param panelPrincipal 
     */
    public PanelBotones(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        this.dialogoArtista = new DialogoArtista(this.panelPrincipal);
        this.dialogoDisco = new DialogoDisco(this.panelPrincipal);
        this.dialogoCancion = new DialogoCancion(this.panelPrincipal);
        configuracionVentana();
    }
    
    /**
     * configurar ventana
     */
    public void configuracionVentana() {
        
        setLayout(new GridLayout(1, 3, 20, 10));
        setBorder(new TitledBorder("Agregar:"));
        agregarBoton();
    }

    // agrega elementos
    public void agregarBoton(){
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
    /**
     * esta atento de los eventos
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand() == "Artista") {
            dialogoArtista.setVisible(true);
        }
        else if(evento.getActionCommand() == "Disco") {
            if(!panelPrincipal.getArtistas().isEmpty()){
                dialogoDisco.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay Artistas agregados.", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(evento.getActionCommand() == "Cancion") {
            if(!panelPrincipal.getArtistas().isEmpty()){
                if(validarDisco){
                    dialogoCancion.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay Discos agregados.", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay Artistas agregados.", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

        /**
      * obtener el dialogo del disco
      * @return 
      */
    public DialogoDisco getDialogoDisco() {
        return dialogoDisco;
    }

    /**
     * cambiar dialogo de disco
     * @param dialogoDisco 
     */
    public void setDialogoDisco(DialogoDisco dialogoDisco) {
        this.dialogoDisco = dialogoDisco;
    }

    /**
     * Obtener dialogo de la cancion
     * @return 
     */
    public DialogoCancion getDialogoCancion() {
        return dialogoCancion;
    }

    /**
     * cambiar 
     * @param dialogoCancion 
     */
    public void setDialogoCancion(DialogoCancion dialogoCancion) {
        this.dialogoCancion = dialogoCancion;
    }

    /**
     * obtener la validacion de disco
     * @return 
     */
    public boolean isValidarDisco() {
        return validarDisco;
    }
    
    /**
     * cambiar validar disco
     * @param validarDisco 
     */
    public void setValidarDisco(boolean validarDisco) {
        this.validarDisco = validarDisco;
    }
}
