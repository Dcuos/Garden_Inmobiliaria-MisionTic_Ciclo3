package Controller;

public interface IUsuarioController {

    public String login(String usuario, String contraseña);

    public String register(String usuario, String contraseña, String nombres, String apellidos,
            String telefono, String direccion_inmueble, boolean premium, double saldo);
    
    public String pedir(String usuario);
    
    public String restarDinero(String usuario, double nuevo_saldo); 
}
