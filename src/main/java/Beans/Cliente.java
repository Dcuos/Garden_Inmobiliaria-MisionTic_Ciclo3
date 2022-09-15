
package Beans;

public class Cliente {
    

    private String usuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion_cliente;
    private boolean premium;
    private double saldo;

    public Cliente(String usuario, String contraseña, String nombres, String apellidos, String telefono, String direccion_cliente, boolean premium, double saldo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion_cliente = direccion_cliente;
        this.premium = premium;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion_cliente=" + direccion_cliente + ", premium=" + premium + ", saldo=" + saldo + '}';
    }

    
}