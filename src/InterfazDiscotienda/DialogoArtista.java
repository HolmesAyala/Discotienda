package InterfazDiscotienda;
import discotienda.Artista;
import discotienda.EnumGenero;
import discotienda.EnumNacionalidad;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoArtista extends JDialog implements ActionListener{
    
    private JButton btnAceptar; // boton para agregar artista
    
    private JTextField nombreArtista; // escribir nombre del artista
    
    private JLabel artista = new JLabel("*Nombre Artista: "); // texto para el nombre del artista
    
    private JLabel nacionalidadArt = new JLabel("*Nacionalidad: "); // texto para la nacionalidad
    
    private JLabel generoArt = new JLabel("*Genero: "); // texto para el genero
    
    private JComboBox nacionalidad; // lista de nacionalidades
    
    private JComboBox genero; // lista de genero musical
    
    private Artista artistaAuxiliar; // objeto de artista
    
    private PanelPrincipal panelPrincipal; // objeto de panel principal

    /**
     * Constructor
     * @param panelPrincipal 
     */
    public DialogoArtista(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        configurarVentana();
        agregarArtista();
    }
    
    /**
     * Configurar la ventana
     */
    public void configurarVentana() {
        setBounds(100,100, 500, 200);
        setTitle("Ingresar Artista");
        setResizable(false);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
    }
    
    /**
     * agregar elementos al panel
     */
    public void agregarArtista() {
        
        add(artista);
        
        nombreArtista  = new JTextField();
        add(nombreArtista);
        
        add(nacionalidadArt);
        
        nacionalidad = new JComboBox(EnumNacionalidad.values());
        
        add(nacionalidad);
        
        add(generoArt);
        
        genero = new JComboBox(EnumGenero.values());
        add(genero);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        add(btnAceptar);
    }

    /**
     * Atento de los eventos
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(validarArtista()){
            artistaAuxiliar = new Artista(nombreArtista.getText().trim(), (EnumGenero)genero.getSelectedItem(), (EnumNacionalidad)nacionalidad.getSelectedItem());
            System.out.println(artistaAuxiliar.getNombre()+" "+artistaAuxiliar.getNacionalidad()+" "+artistaAuxiliar.getGenero());
            panelPrincipal.agregarArtista(artistaAuxiliar);
            panelPrincipal.getPanelBotones().getDialogoDisco().agregarArtista(artistaAuxiliar.getNombre());
            panelPrincipal.getPanelBotones().getDialogoCancion().agregarArtista(artistaAuxiliar.getNombre());
            panelPrincipal.getPanelCompra().agregarArtista(artistaAuxiliar.getNombre());
            setVisible(false);
            //  Reiniciar
            nombreArtista.setText("");
            genero.setSelectedIndex(0);
            nacionalidad.setSelectedIndex(0);
        }
    }
    
    /**
     * valida datos del artista
     * @return 
     */
    public boolean validarArtista(){
        artista.setForeground(Color.BLACK);
        nacionalidadArt.setForeground(Color.BLACK);
        generoArt.setForeground(Color.BLACK);
        
        boolean validar = true;
        if(nombreArtista.getText().trim().equals("")){
            System.out.println("Dejo el nombre vacio!");
            artista.setForeground(Color.red);
            validar = false;
        }
        if(nacionalidad.getSelectedItem().equals(EnumNacionalidad.Seleccionar)){
            System.out.println("Dejo nacionalidad vacio!");
            nacionalidadArt.setForeground(Color.red);
            validar = false;
        }
        if(genero.getSelectedItem().equals(EnumGenero.Seleccionar)){
            System.out.println("Dejo genero vacio!");
            generoArt.setForeground(Color.red);
            validar = false;
        }
        if(!validar){
            JOptionPane.showMessageDialog(null, "Falta informacion por completar", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
        }
        return validar;
    }
    
}
