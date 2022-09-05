
package test;

import Connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import Beans.Inmueble;


public class OperacionesDB {
    
      public static void main(String[] args) {
    listarcasas();
         
    }
    public static void actualiozarcasas(int id_inmueble, String tipo_inmueble){
        DBConnection con = new DBConnection();
        String sql = "UPDATE garden SET tipo_inmueble = '"+tipo_inmueble+"' WHERE id_inmueble ="+ id_inmueble; 
        try {
            Statement st = con.getConnection().createStatement();
            st.executeLargeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
        finally{
            con.desconectar();
        }
    }
    public static void listarcasas(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM garden"; 
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_inmueble = rs.getInt("id_inmueble");
                String tipo_inmueble = rs.getString("tipo_inmueble");
                double precio = rs.getDouble("precio");
                byte habitaciones = rs.getByte("habitaciones");
                byte baños = rs.getByte("baños");
                float area_total = rs.getFloat("area_total");
                byte parqueadero = rs.getByte("parqueadero");
                String direccion_inmueble = rs.getString("direccion_inmueble");
                
                Inmueble inmuebles = new Inmueble(id_inmueble, tipo_inmueble , precio , habitaciones, baños, area_total, parqueadero, direccion_inmueble);
                System.out.println(inmuebles.toString());
            }
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
        finally{
            con.desconectar();
        }
    
            
}
}


