package InterfazDiscotienda;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Cuchurrumi
 */
public class DialogoArtista extends JDialog{
    
    private JButton btnAceptar; 
    
    private JTextField nombreArtista;
    
    private JLabel artista = new JLabel("Nombre Artista: ");
    
    private JLabel nacionalidadArt = new JLabel("Nacionalidad: ");
    
    private JLabel generoArt = new JLabel("Genero: ");
    
    private JComboBox nacionalidad;
    
    private JComboBox genero;

    public DialogoArtista() {
        configurarVentana();
        agregarArtista();
    }
    
    public void configurarVentana() {
        setBounds(100,100, 500, 200);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
    }
    
    public void agregarArtista() {
        
        add(artista);
        nombreArtista  = new JTextField();
        add(nombreArtista);
        add(nacionalidadArt);
        nacionalidad = new JComboBox();
        nacionalidad.addItem("Asia");
        nacionalidad.addItem("Colombia");
        nacionalidad.addItem("EEUU");
        nacionalidad.addItem("Europa");
        nacionalidad.addItem("Latinoamerica");
        nacionalidad.addItem("Mexico");
        add(nacionalidad);
        add(generoArt);
        genero = new JComboBox();
        genero.addItem("Blues");
        genero.addItem("Cumbia");
        genero.addItem("Jazz");
        genero.addItem("Merengue");
        genero.addItem("Pop");
        genero.addItem("Ranchera");
        genero.addItem("Rock");
        genero.addItem("Salsa");
        genero.addItem("Tecno");
        genero.addItem("Urbano");
        genero.addItem("Vallenato");
        add(genero);
        btnAceptar = new JButton("Aceptar");
        add(btnAceptar);
    }
    
}
