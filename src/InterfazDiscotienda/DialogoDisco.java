
package InterfazDiscotienda;

import discotienda.Disco;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoDisco extends JDialog implements ActionListener{
    
    private JLabel labelArtista = new JLabel("*Artista: "); // texto para artista
    
    private JLabel labelNombre = new JLabel("*Nombre: "); // texto para nombre disco
    
    private JLabel labelDescripcion = new JLabel("*Descripcion: "); // texto para descipcion
   
    private JLabel labelPrecio = new JLabel("*Precio: ");   // Texto para precio
    
    private JComboBox boxArtistas; // menu de artistas
    
    private JTextField textoNombre; // para escribir nombre
    
    private JTextArea areaDescripcion; // para escribir descripcion
    
    private JScrollPane areaDescripcionBarras; // contenedor del panel de descripcion
    
    private JTextField textoPrecio; // para escribir el precio
    
    private JButton btnAceptar; // boton para agregar disco
    
    private PanelPrincipal panelPrincipal;  // objeto del panel principal
    
    private Disco disco; // objeto de disco

    /**
     * Constructor
     * @param panelPrincipal 
     */
    public DialogoDisco(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        configurarVentana();
        agregarDisco();
    }
    
    /**
     * Configurar ventana
     */
    public void configurarVentana(){
        setBounds(100, 100, 500, 300);
        setTitle("Ingresar Disco");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(5, 2, 10, 10));
    }
    
    /**
     * Agregar elementos al panel
     */
    public void agregarDisco(){
        add(labelArtista);
        boxArtistas = new JComboBox();
        boxArtistas.addItem("Seleccione");
        add(boxArtistas);
        
        add(labelNombre);
        textoNombre = new JTextField();
        add(textoNombre);
        
        add(labelDescripcion);
        areaDescripcion = new JTextArea(8, 5);
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setSize(100, 100);
        areaDescripcionBarras = new JScrollPane(areaDescripcion);
        areaDescripcionBarras.setSize(100, 100);
        add(areaDescripcionBarras);
        
        add(labelPrecio);
        textoPrecio = new JTextField();
        add(textoPrecio);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        add(btnAceptar);
    }
    
    /**
     * Agregar artista a la lista
     * @param nombre 
     */
    public void agregarArtista(String nombre){
        boxArtistas.addItem(nombre);
    }

    /**
     * atento de los eventos
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(validarDisco()){
             disco = new Disco(textoNombre.getText().trim(), areaDescripcion.getText().trim(), textoPrecio.getText().trim());
             panelPrincipal.agregarDisco((String)boxArtistas.getSelectedItem(), disco);
             panelPrincipal.getPanelBotones().setValidarDisco(true);
             setVisible(false);
             // Reiniciar
              boxArtistas.setSelectedIndex(0);
              textoNombre.setText("");
              areaDescripcion.setText("");
              textoPrecio.setText("");
        }
    }
    
    /**
     * valida datos del disco
     * @return 
     */
    public boolean validarDisco(){
        labelArtista.setForeground(Color.BLACK);
        labelNombre.setForeground(Color.BLACK);
        labelDescripcion.setForeground(Color.BLACK);
        labelPrecio.setForeground(Color.BLACK);
        boolean validarPrecio = true;
        boolean validar = true;
        if(boxArtistas.getSelectedItem().equals("Seleccione")){
            labelArtista.setForeground(Color.red);
            validar = false;
        }
        if(textoNombre.getText().trim().equals("")){
            labelNombre.setForeground(Color.red);
            validar = false;
        }
        if(areaDescripcion.getText().trim().equals("")){
            labelDescripcion.setForeground(Color.red);
            validar = false;
        }
        if(textoPrecio.getText().trim().equals("")){
            labelPrecio.setForeground(Color.red);
            validar = false;
        }
        else{
            if(!validarTextoPrecio()){
                validarPrecio = false;
            }
        }
        String texto = "Falta informacion por completar";
        if(!validar){
            if(!validarPrecio){
                texto += " y el Precio NO es valido";
            }
            JOptionPane.showMessageDialog(null, texto, "Cuidado", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!validarPrecio){
            JOptionPane.showMessageDialog(null, "El precio NO es valido", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
            return validarPrecio;
        }
        return validar;
    }
    
    /**
     * validar que el precio es valido
     * @return 
     */
    public boolean validarTextoPrecio(){
        boolean validarTextoPrecio = true;
        String textoAuxiliar = textoPrecio.getText().trim();
        for(int i = 0; i < textoAuxiliar.length(); i++){
            if(textoAuxiliar.charAt(i) < '0' || textoAuxiliar.charAt(i) > '9'){
                validarTextoPrecio = false;
                break;
            }
        }
        return validarTextoPrecio;
    }
}
