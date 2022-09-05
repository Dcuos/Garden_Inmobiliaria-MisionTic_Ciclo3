
package Beans;

public class Cliente {
    
    private int id_cliente;
    private String usuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion_cliente;
    private boolean premium;

    public Cliente(int id_cliente, String usuario, String contraseña, String nombres, String apellidos, String telefono, String direccion_cliente, boolean premium) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion_cliente = direccion_cliente;
        this.premium = premium;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion_cliente=" + direccion_cliente + ", premium=" + premium + '}';
    }
    
    
    
}
