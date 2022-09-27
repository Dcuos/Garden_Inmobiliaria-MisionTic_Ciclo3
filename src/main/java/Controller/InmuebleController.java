
package Controller;

/**
 *
 * @author dicdh
 */
public interface InmuebleController {
    
    public String listar(boolean ordenar, String orden);
    public String alquilar(int id_inmueble, String usuario);
    public String modificar(int id_inmueble);
   
}
