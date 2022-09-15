
package test;

import Connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import Beans.Inmueble;


public class OperacionesDB {
    
      public static void main(String[] args) {
        listarcasas();
         // actualiozarcasas(2, "pam");
         
    }
    public static void actualiozarcasas(int id_inmueble, String tipo_inmueble){
        DBConnection con = new DBConnection();
        String sql = "UPDATE inmueble SET tipo_inmueble = '"+tipo_inmueble+"' WHERE id_inmueble ="+ id_inmueble; 
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
        String sql = "SELECT * FROM inmueble"; 
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id_inmueble = rs.getInt("id_inmueble");
                String tipo_inmueble = rs.getString("tipo_inmueble");
                double precio = rs.getDouble("precio");
                int habitaciones = rs.getInt("habitaciones");
                int banos = rs.getInt("banos");
                double area_total = rs.getDouble("area_total");
                int parqueadero = rs.getInt("parqueadero");
                String direccion_inmueble = rs.getString("direccion_inmueble");
                String descripcion = rs.getString("descripcion");
                
                Inmueble inmuebles = new Inmueble(id_inmueble, tipo_inmueble, precio, habitaciones, banos, area_total, parqueadero, direccion_inmueble, descripcion);
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


