
package discotienda;

/**
 *
 * @author Cuchurrumi
 */
public class Cancion {
    
    private String nombre;  //  Atributo para el nombre de la cancion
    
    private String duracion;    //  Atributo para la duracion de la cancion

    /**
     * Constructor de la clase Cancion
     * @param nombre
     * @param duracion 
     */
    public Cancion(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    /**
     * Obtener el Nombre de la cancion
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre de la cancion
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener la duracion de la cancion
     * @return duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Cambiar la duracion de la cancion
     * @param duracion 
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
