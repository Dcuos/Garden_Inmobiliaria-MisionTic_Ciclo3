
package Beans;


public class Inmueble {
    
    private int id_inmueble;
    private String tipo_inmueble;
    private double precio;
    private byte habitaciones;
    private byte baños;
    private float area_total;
    private byte parqueadero;
    private String direccion_inmueble;

    public Inmueble(int id_inmueble, String tipo_inmueble, double precio, byte habitaciones, byte baños, float area_total, byte parqueadero, String direccion_inmueble) {
        this.id_inmueble = id_inmueble;
        this.tipo_inmueble = tipo_inmueble;
        this.precio = precio;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.area_total = area_total;
        this.parqueadero = parqueadero;
        this.direccion_inmueble = direccion_inmueble;
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

    public byte getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(byte habitaciones) {
        this.habitaciones = habitaciones;
    }

    public byte getBaños() {
        return baños;
    }

    public void setBaños(byte baños) {
        this.baños = baños;
    }

    public float getArea_total() {
        return area_total;
    }

    public void setArea_total(float area_total) {
        this.area_total = area_total;
    }

    public byte getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(byte parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getDireccion_inmueble() {
        return direccion_inmueble;
    }

    public void setDireccion_inmueble(String direccion_inmueble) {
        this.direccion_inmueble = direccion_inmueble;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id_inmueble=" + id_inmueble + ", tipo_inmueble=" + tipo_inmueble + ", precio=" + precio + ", habitaciones=" + habitaciones + ", ba\u00f1os=" + baños + ", area_total=" + area_total + ", parqueadero=" + parqueadero + ", direccion_inmueble=" + direccion_inmueble + '}';
    }

    
    
}