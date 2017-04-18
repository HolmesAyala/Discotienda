
package discotienda;

/**
 * 
 * @author Cuchurrumi
 */
public class Discotienda {

    Artista artista;
    
    Disco disco;
    
    Cancion cancion;
    
    public Discotienda() {
        artista = new Artista("Holmes", EnumGenero.POP, EnumNacionalidad.LATINOAMERICA);
        
        disco = new Disco("Canciones del Alma.", "Canciones que llegan a el alma", "15000");
        cancion = new Cancion("Cancion Bonita", "240 min");
        disco.agregarCancion(cancion);
        cancion = new Cancion("Cancion no tan bonita", "120 min");
        disco.agregarCancion(cancion);
        artista.agregarDisco(disco);
        
        System.out.println("Artista: " + artista.getNombre());
        System.out.println("  Genero: " + artista.getGenero());
        System.out.println("  Nacionalidad: " + artista.getNacionalidad());
        System.out.println("  Discos:");
        for(int i = 0; i < artista.getDiscos().size(); i++){
            System.out.println("    - " + artista.getDiscos().get(i).getNombre());
            System.out.println("    Descripcion: " + artista.getDiscos().get(i).getDescripcion());
            System.out.println("    Precio: " + artista.getDiscos().get(i).getPrecio());
            System.out.println("      Canciones:");
            for(int j = 0; j < artista.getDiscos().get(i).getCanciones().size(); j++){
                System.out.println("        - " + artista.getDiscos().get(i).getCanciones().get(j).getNombre());
                System.out.println("        Duracion: " + artista.getDiscos().get(i).getCanciones().get(j).getDuracion());
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Discotienda Discotienda = new Discotienda();
    }
    
}
