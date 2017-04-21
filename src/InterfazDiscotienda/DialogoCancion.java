
package InterfazDiscotienda;

import discotienda.Disco;
import discotienda.Cancion;
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
public class DialogoCancion extends JDialog implements ActionListener{
    
    private JLabel labelArtista = new JLabel("Artista: ");  // Texto para el artista
    
    private JLabel labelDisco = new JLabel("Disco:");   //  Texto para el disco

    private JLabel  labelNombre = new JLabel("Nombre:");    //  Texto para el nombre de la cancion
    
    private JLabel labelDuracion = new JLabel("Duracion (segundos):");  // Texto para la duracion de la cancion
    
    private JComboBox boxArtista;   //  Seleccion de artista
    
    private JComboBox boxDisco; //  Seleccion de disco
    
    private JTextField textoNombre; // Para ingresar el nombre de la cancion
    
    private JTextField textoDuracion;   //  Para ingresar la duracion de la cancion
    
    private JButton btnAceptar; // Boton para agregar cancion
    
    private PanelPrincipal panelPrincipal; // Objeto del panel principal
    
    private Cancion cancion;    // Objeto de Cancion

    /**
     * Contructor
     * @param panelPrincipal 
     */
    public DialogoCancion(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        configurarVentana();
        agregarCancion();
    }
    
    /**
     * Configuracion de ventana
     */
    public void configurarVentana() {
        setBounds(100, 100, 500, 200);
        setTitle("Ingresar Cancion");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(5, 2, 10, 10));
    }
    
    /**
     * Agregar elementos al panel
     */
    public void agregarCancion(){
        add(labelArtista);
        boxArtista = new JComboBox();
        boxArtista.addItem("Seleccione");
        boxArtista.setActionCommand("CambioArtista");
        boxArtista.addActionListener(this);
        add(boxArtista);
        
        add(labelDisco);
        boxDisco = new JComboBox();
        boxDisco.addItem("Seleccione");
        add(boxDisco);
        
        add(labelNombre);
        textoNombre = new JTextField();
        add(textoNombre);
        
        add(labelDuracion);
        textoDuracion = new JTextField();
        add(textoDuracion);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        add(btnAceptar);
    }
    
    /**
     * Agregar nombre artista a la lista
     * @param nombre 
     */
    public void agregarArtista(String nombre){
        boxArtista.addItem(nombre);
    }
    
    /**
     * Escuchador de los elementos
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand() == "Aceptar" && validarCancion()){
            cancion = new Cancion(textoNombre.getText().trim(), textoDuracion.getText().trim());
            panelPrincipal.agregarCancion((String)boxArtista.getSelectedItem(), (String)boxDisco.getSelectedItem(), cancion);
            //  Reiniciar Componentes
            boxArtista.setSelectedIndex(0);
            boxDisco.setSelectedIndex(0);
            textoNombre.setText("");
            textoDuracion.setText("");
        }
        else if(evento.getActionCommand().equals("CambioArtista")){
            boxDisco.removeAllItems();
            boxDisco.addItem("Seleccione");
            for(int i = 0; i < panelPrincipal.getArtistas().size(); i++){
                if(panelPrincipal.getArtistas().get(i).getNombre().equals(boxArtista.getSelectedItem())){
                    for(int j = 0; j < panelPrincipal.getArtistas().get(i).getDiscos().size(); j++){
                        boxDisco.addItem(panelPrincipal.getArtistas().get(i).getDiscos().get(j).getNombre());
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Valida datos de la cancion
     * @return 
     */
    public boolean validarCancion(){
        labelArtista.setForeground(Color.BLACK);
        labelDisco.setForeground(Color.BLACK);
        labelNombre.setForeground(Color.BLACK);
        labelDuracion.setForeground(Color.BLACK);
        boolean validarDuracion = true;
        boolean validar = true;
        if(boxArtista.getSelectedItem().equals("Seleccione")){
            labelArtista.setForeground(Color.red);
            validar = false;
        }
        if(boxDisco.getSelectedItem().equals("Seleccione")){
            labelDisco.setForeground(Color.red);
            validar = false;
        }
        if(textoNombre.getText().trim().equals("")){
            labelNombre.setForeground(Color.red);
            validar = false;
        }
        if(textoDuracion.getText().trim().equals("")){
            labelDuracion.setForeground(Color.red);
            validar = false;
        }
        else{
            if(!validarTextoPrecio()){
                labelDuracion.setForeground(Color.red);
                validarDuracion = false;
            }
        }
        String texto = "Falta informacion por completar";
        if(!validar){
            if(!validarDuracion){
                texto += " y la duracion NO es valida";
            }
            JOptionPane.showMessageDialog(null, texto, "Cuidado", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!validarDuracion){
            JOptionPane.showMessageDialog(null, "La duracion NO es valida", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
            return validarDuracion;
        }
        return validar;
    }
    
    /**
     * Valida que contenga solo numeros
     * @return 
     */
    public boolean validarTextoPrecio(){
        boolean validarTextoDuracion = true;
        String textoAuxiliar = textoDuracion.getText().trim();
        for(int i = 0; i < textoAuxiliar.length(); i++){
            if(textoAuxiliar.charAt(i) < '0' || textoAuxiliar.charAt(i) > '9'){
                validarTextoDuracion = false;
                break;
            }
        }
        return validarTextoDuracion;
    }
}
