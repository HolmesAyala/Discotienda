package InterfazDiscotienda;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import discotienda.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelPrincipal extends JFrame{
    
    private PanelTitulo panelTitulo; // objeto panelTitulo
    
    private PanelBotones panelBotones; // objeto panel botones
    
    private PanelCompra panelCompra; // objeto panelcompra
    
    private List<Artista> artistas; // listas artistas
    
    /**
     * constructor
     */
    public PanelPrincipal() {
        artistas = new ArrayList<Artista>();
        configuracionVentana();
        
    }
    
    /**
     * Configurar ventana
     */
    public void configuracionVentana(){
        setTitle("Discotienda...");
        setLayout(new BorderLayout());
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        //Dimension resolucion = pantalla.getScreenSize();
        //setBounds(resolucion.width/2-400, resolucion.height/2-400, 800, 800);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Image icono = pantalla.getImage("Iconos/IconoPrincipal.png");
        setIconImage(icono);
        setResizable(false);
        agregarPanel();
        
        setVisible(true);
        
    }
    
    /**
     * agregar a la ventana
     */
    public void agregarPanel(){
        panelTitulo = new PanelTitulo();
        //getContentPane().add(panelTitulo, BorderLayout.NORTH);
        add(panelTitulo, BorderLayout.NORTH);
        
        panelBotones = new PanelBotones(this);
        //getContentPane().add(panelBotones, BorderLayout.SOUTH);
        add(panelBotones, BorderLayout.SOUTH);
        
        panelCompra = new PanelCompra(this);
        add(panelCompra, BorderLayout.CENTER);
    }

    /**
     * Agregar artista a la lista
     * @param artista 
     */
    public void agregarArtista(Artista artista){
        artistas.add(artista);
        for(int i = 0; i < artistas.size(); i++){
            System.out.println(artistas.get(i).getNombre()+" "+artistas.get(i).getNacionalidad()+" "+artistas.get(i).getGenero());
        }
      
    }
    
    /**
     * Para agregar un disco
     * @param nombre
     * @param disco 
     */
    public void agregarDisco(String nombre, Disco disco){
        for(int i = 0; i < artistas.size(); i++){
            System.out.println(artistas.get(i).getNombre()+" = "+nombre);
            if(artistas.get(i).getNombre().equals(nombre)){
                artistas.get(i).agregarDisco(disco);
                break;
            }
        }
    }
    
    /**
     * Para agregar cancion
     * @param nombreArtista
     * @param nombreDisco
     * @param cancion 
     */
    public void agregarCancion(String nombreArtista, String nombreDisco, Cancion cancion){
        for(int i = 0; i < artistas.size(); i++){
            if(artistas.get(i).getNombre().equals(nombreArtista)){
                for(int j = 0; j < artistas.get(i).getDiscos().size(); j++){
                    if(artistas.get(i).getDiscos().get(j).getNombre().equals(nombreDisco)){
                        System.out.println("\n\nSe ha agregado la cancion!\n");
                        artistas.get(i).getDiscos().get(j).agregarCancion(cancion);
                        break;
                    }
                }
                break;
            }
        }
    }
    
    /**
     * obtener lista
     * @return 
     */
    public List<Artista> getArtistas() {
        return artistas;
    }
    /**
     * cambiar lista
     * @param artistas 
     */
    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    /**
     * obtener el panel de botones
     * @return 
     */
    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    /**
     * cambiar panel de botones
     * @param panelBotones 
     */
    public void setPanelBotones(PanelBotones panelBotones) {
        this.panelBotones = panelBotones;
    }

    /**
     * obtener panel compra
     * @return 
     */
    public PanelCompra getPanelCompra() {
        return panelCompra;
    }

    /**
     * cambiar panel de compra
     * @param panelCompra 
     */
    public void setPanelCompra(PanelCompra panelCompra) {
        this.panelCompra = panelCompra;
    }
    
}
