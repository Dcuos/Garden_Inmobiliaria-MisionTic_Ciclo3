
package Beans;


public class Inmueble {
    
    private int id_inmueble;
    private String tipo_inmueble;
    private double precio;
    private int habitaciones;
    private int banos;
    private double area_total;
    private int parqueadero;
    private String direccion_inmueble;
    private String descripcion;

    public Inmueble(int id_inmueble, String tipo_inmueble, double precio, int habitaciones, int banos, double area_total, int parqueadero, String direccion_inmueble, String descripcion) {
        this.id_inmueble = id_inmueble;
        this.tipo_inmueble = tipo_inmueble;
        this.precio = precio;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.area_total = area_total;
        this.parqueadero = parqueadero;
        this.direccion_inmueble = direccion_inmueble;
        this.descripcion = descripcion;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public String getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(String tipo_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public double getArea_total() {
        return area_total;
    }

    public void setArea_total(double area_total) {
        this.area_total = area_total;
    }

    public int getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(int parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getDireccion_inmueble() {
        return direccion_inmueble;
    }

    public void setDireccion_inmueble(String direccion_inmueble) {
        this.direccion_inmueble = direccion_inmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id_inmueble=" + id_inmueble + ", tipo_inmueble=" + tipo_inmueble + ", precio=" + precio + ", habitaciones=" + habitaciones + ", banos=" + banos + ", area_total=" + area_total + ", parqueadero=" + parqueadero + ", direccion_inmueble=" + direccion_inmueble + ", descripcion=" + descripcion + '}';
    }

}