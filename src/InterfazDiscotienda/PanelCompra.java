
package InterfazDiscotienda;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelCompra extends JPanel implements ActionListener{

    private PanelPrincipal panelPrincipal;
    
    private JLabel labelArtista = new JLabel("Artista: "); // texto para artista
    
    private JLabel labelDisco = new JLabel("Disco: "); // texto para disco
    
    private JComboBox boxArtista; // lista de nombres de artistas
    
    private JComboBox boxDisco; // lista de discos
    
    private JButton btnComprar; // boton para comprar disco
    
    private JScrollPane areaArtistaBarra; // muestra informacion del artista
    
    private JTextArea areaArtista;  // muestra informacion del artista
    
    private JScrollPane areaDiscoBarra; // muestra los discos
    
    private JTextArea areaDisco; // muestra los discos del artista
    
    private JScrollPane areaCancionBarra; // muestra los discos del artista
    
    private JTextArea areaCancion; // muestra canciones de un disco
    
    private int indiceSeleccionArtista; // indice para saber cual esta seleccionado
    
    /**
     * Constructor
     * @param panelPrincipal 
     */
    public PanelCompra(PanelPrincipal panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        configurarPanel();
        agregarElementos();
    }
    
    /**
     * Configurar el panel
     */
    public void configurarPanel(){
        setLayout(null);
        setBorder(new TitledBorder("Comprar:"));
    }
    
    /**
     * Agrega los componentes
     */
    public void agregarElementos(){
        
        labelArtista.setBounds(30, 40, 100, 20);
        add(labelArtista);
        boxArtista = new JComboBox();
        boxArtista.setBounds(130, 40, 150, 20);
        boxArtista.addItem("Seleccione");
        boxArtista.setActionCommand("ARTISTA");
        boxArtista.addActionListener(this);
        add(boxArtista);
        
        labelDisco.setBounds(30, 80, 100, 20);
        add(labelDisco);
        boxDisco = new JComboBox();
        boxDisco.setBounds(130, 80, 150, 20);
        boxDisco.addItem("Seleccione");
        boxDisco.setActionCommand("DISCO");
        boxDisco.addActionListener(this);
        add(boxDisco);
        
        btnComprar = new JButton("Comprar Disco");
        btnComprar.setBounds(130, 120, 150, 20);
        ImageIcon icono = new ImageIcon("Iconos/IconoPanelCompra.png");
        //btnComprar.setIcon(icono);
        btnComprar.setEnabled(false);
        add(btnComprar);
        
        areaArtista = new JTextArea(20, 10);
        areaArtista.setLineWrap(true);
        areaArtista.setEditable(false);
        areaArtista.setFont(new Font("arial", Font.ITALIC, 20));
        areaArtistaBarra = new JScrollPane(areaArtista);
        areaArtistaBarra.setBounds(400, 40, 300, 100);
        add(areaArtistaBarra);
        
        areaDisco = new JTextArea(20, 10);
        areaDisco.setLineWrap(true);
        areaDisco.setEditable(false);
        areaDisco.setFont(new Font("arial", Font.ITALIC, 15));
        areaDiscoBarra = new JScrollPane(areaDisco);
        areaDiscoBarra.setBounds(400, 180, 300, 150);
        add(areaDiscoBarra);
        
        areaCancion = new JTextArea(20, 10);
        areaCancion. setLineWrap(true);
        areaCancion.setEditable(false);
        areaCancion.setFont(new Font("arial", Font.ITALIC, 15));
        areaCancionBarra = new JScrollPane(areaCancion);
        areaCancionBarra.setBounds(400, 363, 300, 190);
        add(areaCancionBarra);
        
    }
    
    /**
     * agregar artista a la lista
     * @param nombre 
     */
    public void agregarArtista(String nombre){
        boxArtista.addItem(nombre);
    }

    /**
     * Atento a los eventos
     * @param evento 
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equals("ARTISTA") && !(boxArtista.getSelectedItem().equals("Seleccione"))){
            areaArtista.setText("");
            areaDisco.setText("");
            areaCancion.setText("");
            for(int i = 0; i < panelPrincipal.getArtistas().size(); i++){
                if(panelPrincipal.getArtistas().get(i).getNombre().equals(boxArtista.getSelectedItem())){
                    String auxiliar;
                    auxiliar = "Nombre: " + panelPrincipal.getArtistas().get(i).getNombre() + "\n";
                    auxiliar += "Genero: " + panelPrincipal.getArtistas().get(i).getGenero() + "\n";
                    auxiliar += "Nacionalidad: " + panelPrincipal.getArtistas().get(i).getNacionalidad() + "\n";
                    areaArtista.setText(auxiliar);
                    indiceSeleccionArtista = i;
                    agregarDisco(i);
                    break;
                }
            }
        }
        if(evento.getActionCommand().equals("DISCO")){
            btnComprar.setEnabled(false);
            System.out.println("Entre Aqui\n");
            for(int i = 0; i < panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().size(); i++){
                if(panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().get(i).getNombre().equals(boxDisco.getSelectedItem())){
                    if(!(panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().get(i).getCanciones().isEmpty())){
                        String auxiliar = "";
                        for(int j = 0; j < panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().get(i).getCanciones().size(); j++){
                            auxiliar += "Nombre: "+panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().get(i).getCanciones().get(j).getNombre()+"\n";
                            auxiliar += "Duracion (seg): "+panelPrincipal.getArtistas().get(indiceSeleccionArtista).getDiscos().get(i).getCanciones().get(j).getDuracion()+"\n\n";
                        }
                        areaCancion.setText(auxiliar);
                        btnComprar.setEnabled(true);
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Agregar disco a la lista
     * @param indice 
     */
    public void agregarDisco(int indice){
        if(!(panelPrincipal.getArtistas().get(indice).getDiscos().isEmpty())){
            boxDisco.removeAllItems();
            boxDisco.addItem("Seleccione");
            areaDisco.setText("");
            areaCancion.setText("");
            String auxiliar = "";
            for(int i = 0; i < panelPrincipal.getArtistas().get(indice).getDiscos().size(); i++){
                boxDisco.addItem(panelPrincipal.getArtistas().get(indice).getDiscos().get(i).getNombre());
                auxiliar += "Nombre: "+panelPrincipal.getArtistas().get(indice).getDiscos().get(i).getNombre()+"\n";
                auxiliar += "Descripcion: "+panelPrincipal.getArtistas().get(indice).getDiscos().get(i).getDescripcion()+"\n";
                auxiliar += "Precio: "+panelPrincipal.getArtistas().get(indice).getDiscos().get(i).getPrecio()+"\n\n";
                areaDisco.setText(auxiliar);
            }
        }
    }
}
