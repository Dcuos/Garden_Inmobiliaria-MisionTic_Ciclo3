
package Controller;
import java.sql.ResultSet;
import java.sql.Statement;
import Beans.Inmueble;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author dicdh
 */
public class muebleController implements InmuebleController {
    
    @Override
    public String listar(boolean ordenar, String orden){
       Gson gson = new Gson();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM inmueble";
        if(ordenar == true){
            sql += "ORDER BY tipo_inmueble" + orden;
        }
        List<String> inmuebless = new ArrayList<String>();
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

               int id_inmueble = rs.getInt("id_inmueble");
                String tipo_inmueble = rs.getString("tipo_inmueble");
                double precio = rs.getDouble("precio");
                int habitaciones = rs.getInt("habitaciones");
                int banos = rs.getInt("banos");
                double area_total = rs.getDouble("area_total");
                int parqueadero = rs.getInt("parqueadero");
                String direccion_inmueble = rs.getString("direccion_inmueble");
                String descripcion = rs.getString("descripcion");
                Inmueble inmueble = new Inmueble(id_inmueble, tipo_inmueble, precio, habitaciones, banos, area_total, parqueadero, direccion_inmueble, descripcion);
                inmuebless.add(gson.toJson(inmueble));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return gson.toJson(inmuebless); 
    }

    @Override
    public String alquilar(int id_inmueble, String usuario) {
        
        int tiempo_minimo_alquiler = 6;
        String id_contrato = UUID.randomUUID().toString();
        Timestamp fecha = new Timestamp(new Date().getTime());
        DBConnection con = new DBConnection();
        String sql = "INSERT INTO contrato VALUES('"+id_contrato+"', '"+usuario+"', '"+id_inmueble+"', '"+tiempo_minimo_alquiler+"', '"+fecha+"')";
  
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            String modifi = modificar(id_inmueble);
            if(modifi.equals("true")){
                return "true";
            }            

        }catch (Exception ex) {
            System.out.println(ex.toString());

        } finally {
            con.desconectar();
        }

        return "false"; 
    }

    @Override
    public String modificar(int id_inmueble) {
       DBConnection con = new DBConnection();
        String sql = "UPDATE inmueble SET parqueadero = (parqueadero - 1) WHERE id_inmueble="+ id_inmueble;
  
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            
            
            
                return "true";
                        

        }catch (Exception ex) {
            System.out.println(ex.toString());

        } finally {
            con.desconectar();
        }

        return "false"; 
    }

    
}
