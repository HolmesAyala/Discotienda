
package discotienda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cuchurrumi
 */
public class Disco {
    
    private String nombre;  //  Nombre del disco
    
    private String descripcion; //  Descripcion del disco
    
    private String precio;  //  Precio del disco
    
    private List<Cancion> canciones;    //  Lista de caciones del disco

    /**
     * Constructor de la clase Disco
     * @param nombre
     * @param descripcion
     * @param precio 
     */
    public Disco(String nombre, String descripcion, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        canciones = new ArrayList<Cancion>();
    }
    
    /**
     * Metodo que agrega una cancion al disco
     * @param cancion 
     */
    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
    }

    /**
     * Obtener nombre del disco
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar nombre del disco
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener descripcion del disco
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambiar descripcion del disco
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtener el precio del disco
     * @return precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Cambiar el precio del disco
     * @param precio 
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Obtener la lista de canciones
     * @return canciones
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Cambiar la lista de canciones
     * @param canciones 
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
}
