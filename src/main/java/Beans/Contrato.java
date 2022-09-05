
package Beans;

import java.util.Date;


public class Contrato {
    
    private int id_contrato;
    private int id_inmueble;
    private int id_cliente;
    private String medio_de_pago;
    private int tiempo_minimo_alquiler;
    private Date Fecha_alquiler;

    public Contrato(int id_contrato, int id_inmueble, int id_cliente, String medio_de_pago, int tiempo_minimo_alquiler, Date Fecha_alquiler) {
        this.id_contrato = id_contrato;
        this.id_inmueble = id_inmueble;
        this.id_cliente = id_cliente;
        this.medio_de_pago = medio_de_pago;
        this.tiempo_minimo_alquiler = tiempo_minimo_alquiler;
        this.Fecha_alquiler = Fecha_alquiler;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMedio_de_pago() {
        return medio_de_pago;
    }

    public void setMedio_de_pago(String medio_de_pago) {
        this.medio_de_pago = medio_de_pago;
    }

    public int getTiempo_minimo_alquiler() {
        return tiempo_minimo_alquiler;
    }

    public void setTiempo_minimo_alquiler(int tiempo_minimo_alquiler) {
        this.tiempo_minimo_alquiler = tiempo_minimo_alquiler;
    }

    public Date getFecha_alquiler() {
        return Fecha_alquiler;
    }

    public void setFecha_alquiler(Date Fecha_alquiler) {
        this.Fecha_alquiler = Fecha_alquiler;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id_contrato=" + id_contrato + ", id_inmueble=" + id_inmueble + ", id_cliente=" + id_cliente + ", medio_de_pago=" + medio_de_pago + ", tiempo_minimo_alquiler=" + tiempo_minimo_alquiler + ", Fecha_alquiler=" + Fecha_alquiler + '}';
    }
    

    
    
    
}
