
package discotienda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class Artista {
    
    private String nombre;  //  Nombre del artista
    
    private EnumGenero genero;  //  Genero musical
    
    private EnumNacionalidad nacionalidad;  //  Nacionalidad del artista
    
    private List<Disco> discos; //  Lista de discos

    /**
     * Constructor de la clase Artista
     * @param nombre
     * @param genero
     * @param nacionalidad 
     */
    public Artista(String nombre, EnumGenero genero, EnumNacionalidad nacionalidad) {
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        discos = new ArrayList<Disco>();
    }

    /**
     * Metodo para agregar un disco al artista
     * @param disco 
     */
    public void agregarDisco(Disco disco){
        discos.add(disco);
    }
    
    /**
     * Obtener nombre del artista
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar nombre del artista
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener genero musical del artista
     * @return genero
     */
    public EnumGenero getGenero() {
        return genero;
    }

    /**
     * cambiar genero del artista
     * @param genero 
     */
    public void setGenero(EnumGenero genero) {
        this.genero = genero;
    }

    /**
     * Obtener nacionalidad del artista
     * @return nacionalidad
     */
    public EnumNacionalidad getNacionalidad() {
        return nacionalidad;
    }

    /**
     * cambiar nacionalidad del artista
     * @param nacionalidad 
     */
    public void setNacionalidad(EnumNacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtener lista de discos
     * @return discos
     */
    public List<Disco> getDiscos() {
        return discos;
    }

    /**
     * Cambiar lista de discos
     * @param discos 
     */
    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }
    
}
